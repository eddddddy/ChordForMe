"""
Provides a primary function, spectrogram_to_chord(), that reads in spectrogram
data and outputs a string containing the chord root, chord type, and root note
of the spectrogram. Also provides auxilliary functions for this task.
"""

import matplotlib.pyplot as plt
import numpy as np
import tensorflow as tf
from scipy.io import wavfile
from scipy import signal
from variables_chord_roots import *
from variables_chord_types import *
from variables_root_notes import *
import translate

frequencies = [375/16*i for i in range(1025)]
times_all = [0.064/3 + i*0.112/3 for i in range(64)]
NUM_DATA_POINTS = 16

# build graph for predictions
data = tf.placeholder(tf.float32, shape=[None, LEN_DATA])

layer_chord_roots_1 = tf.nn.relu(tf.add(tf.matmul(data, weights_chord_roots_hidden_1), biases_chord_roots_hidden_1))
layer_chord_roots_2 = tf.nn.relu(tf.add(tf.matmul(layer_chord_roots_1, weights_chord_roots_hidden_2), biases_chord_roots_hidden_2))
out_chord_roots = tf.add(tf.matmul(layer_chord_roots_2, weights_chord_roots_out), biases_chord_roots_out)
predict_chord_roots_op = tf.argmax(out_chord_roots, axis=1)

layer_chord_types_1 = tf.nn.relu(tf.add(tf.matmul(data, weights_chord_types_hidden_1), biases_chord_types_hidden_1))
layer_chord_types_2 = tf.nn.relu(tf.add(tf.matmul(layer_chord_types_1, weights_chord_types_hidden_2), biases_chord_types_hidden_2))
out_chord_types = tf.add(tf.matmul(layer_chord_types_2, weights_chord_types_out), biases_chord_types_out)
predict_chord_types_op = tf.argmax(out_chord_types, axis=1)

layer_root_notes_1 = tf.nn.relu(tf.matmul(data, weights_root_notes_hidden_1) + biases_root_notes_hidden_1)
out_root_notes = tf.add(tf.matmul(layer_root_notes_1, weights_root_notes_out), biases_root_notes_out)
predict_root_notes_op = tf.argmax(out_root_notes, axis=1)

def crop_image(image):
    """
    Gets pixels in first non-whitespace column, removing whitespace at the top
    and bottom.
    """
    return(image[35:252, 54, 0:])

def mode(list_):
    """
    Returns the mode of list_. If multimodal, returns the mode lowest in value.
    If list_ is empty, returns None.
    """
    if list_:
        return(max(set(list_), key=list_.count))
    return None

def confidence_level(chord_roots_list, chord_types_list, root_notes_list):
    """
    Returns the overall confidence level, given the predictions made for each
    of the three chord properties, from 0 (least confident) to 1 (most
    confident).
    """
    confidence = 0

    mode_chord_roots = mode(chord_roots_list)
    mode_chord_types = mode(chord_types_list)
    mode_root_notes = mode(root_notes_list)

    confidence += chord_roots_list.count(mode_chord_roots)/(3*NUM_DATA_POINTS)
    confidence += chord_types_list.count(mode_chord_types)/(3*NUM_DATA_POINTS)
    confidence += root_notes_list.count(mode_root_notes)/(3*NUM_DATA_POINTS)

    chord_roots_possible = translate.possible_chord_roots(mode_chord_types, mode_root_notes)
    chord_types_possible = translate.possible_chord_types(mode_chord_roots, mode_root_notes)
    root_notes_possible = translate.possible_root_notes(mode_chord_roots, mode_chord_types)

    if mode_chord_roots not in chord_roots_possible:
        confidence -= 1/3
    if mode_chord_types not in chord_types_possible:
        confidence -= 1/3
    if mode_root_notes not in root_notes_possible:
        confidence -= 1/3

    return(max(0, confidence))

def spectrogram_to_chord(file):  # change parameter to spectrogram if input is spectrogram data
    """
    Reads in spectrogram data and returns a string containing the predicted
    chord root, chord type, and root note of the spectrogram.
    """
    # comment these two lines out if input is spectrogram data
    sample_rate, samples = wavfile.read(file)
    frequencies_, times, spectrogram = signal.spectrogram(samples, sample_rate, nperseg=2048)

    # comment this line in if input is spectrogram data
    # times = times_all[:len(spectrogram[0])]  # times_all is a global variable

    # convert spectrogram data to image pixel data
    array_image_data_all = []

    figure = plt.figure()
    ax = figure.add_subplot(111)

    ax.pcolormesh(times, frequencies, spectrogram)  # frequencies is a global variable
    for i in range(NUM_DATA_POINTS):
        ax.axis([0.064/3 + i*0.112/3, 0.064/3 + (i + 1)*0.112/3, 0, 5000])
        ax.axis("off")

        figure.canvas.draw()
        image = np.frombuffer(figure.canvas.tostring_rgb(), dtype=np.uint8)
        image = image.reshape(figure.canvas.get_width_height()[::-1] + (3,))
        image = crop_image(image).flatten()/255
        array_image_data_all.append(image.tolist())

    array_image_data_all = np.array(array_image_data_all)

    # make chord predictions using the created graph
    with tf.Session() as sess:
        predicted_chord_roots = sess.run(predict_chord_roots_op, feed_dict={data: array_image_data_all}).tolist()
        predicted_chord_types = sess.run(predict_chord_types_op, feed_dict={data: array_image_data_all}).tolist()
        predicted_root_notes = sess.run(predict_root_notes_op, feed_dict={data: array_image_data_all}).tolist()

    chord_root_prediction = translate.index_to_note(mode(predicted_chord_roots))
    chord_type_prediction = translate.index_to_type(mode(predicted_chord_types))
    root_note_prediction = translate.index_to_note(mode(predicted_root_notes))

    # if confidence in prediction is low, return an empty string
    if confidence_level(predicted_chord_roots, predicted_chord_types, predicted_root_notes) < 0.70:
        return("")

    return(chord_root_prediction + chord_type_prediction + "/" + root_note_prediction)
