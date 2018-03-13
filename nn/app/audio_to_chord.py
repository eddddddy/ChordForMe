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
from variables import *
import translate

frequencies = [375/16*i for i in range(1025)]
times_all = [0.064/3 + i*0.112/3 for i in range(64)]

# build graph for predictions
data = tf.placeholder(tf.float32, shape=[16, LEN_DATA])

layer_chord_roots_1 = tf.nn.relu(tf.add(tf.matmul(data, weights_chord_roots_hidden_1), biases_chord_roots_hidden_1))
layer_chord_roots_2 = tf.nn.relu(tf.add(tf.matmul(layer_chord_roots_1, weights_chord_roots_hidden_2), biases_chord_roots_hidden_2))
out_chord_roots = tf.add(tf.matmul(layer_chord_roots_2, weights_chord_roots_out), biases_chord_roots_out)
predict_chord_roots_op = tf.argmax(out_chord_roots, axis=1)

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

def mode_in_list(list_check, list_mode):
    """

    """
    """
    mode_ = mode(list_mode)
    while mode_ not in list_search:
        list_mode = [i for i in list_mode if i != mode_]
        mode_ = mode(list_mode)
        if not mode_:
            return None
    return mode
    """
    return(mode(list_mode) in list_check)

def spectrogram_to_chord(file):
    """
    Reads in spectrogram data and outputs a string containing the predicted
    chord root, chord type, and root note of the spectrogram.
    """
    # comment these two lines out if input is spectrogram data
    sample_rate, samples = wavfile.read(file)
    frequencies_, times, spectrogram = signal.spectrogram(samples, sample_rate, nperseg=2048)

    # comment this line in if input is spectrogram data
    # times = times_all[:len(times)]

    # convert spectrogram data to image pixel data
    array_image_data_all = []

    figure = plt.figure()
    ax = figure.add_subplot(111)

    ax.pcolormesh(times, frequencies, spectrogram)
    for i in range(16):
        ax.axis([0.064/3 + i*0.112/3, 0.064/3 + (i + 1)*0.112/3, 0, 5000])
        ax.axis("off")
        ax.get_xaxis().set_visible(False)
        ax.get_yaxis().set_visible(False)

        figure.canvas.draw()
        image = np.frombuffer(figure.canvas.tostring_rgb(), dtype=np.uint8)
        image = image.reshape(figure.canvas.get_width_height()[::-1] + (3,))
        image = crop_image(image).flatten()
        array_image_data_all.append(image.tolist())

    array_image_data_all = np.array(array_image_data_all)

    # make chord predictions using the created graph
    with tf.Session() as sess:
        predicted_chord_roots = sess.run(predict_chord_roots_op, feed_dict={data: array_image_data_all})
        # TODO
        # predicted_chord_types = sess.run(predict_chord_types_op, feed_dict={data: array_image_data_all})
        # predicted_root_notes = sess.run(predict_root_notes_op, feed_dict={data: array_image_data_all})

    print(predicted_chord_roots)
    # TODO
    # print(predicted_chord_types)
    # print(predicted_root_notes)
    chord_root_prediction = translate.index_to_note(mode(predicted_chord_roots.tolist()))
    # TODO
    # chord_type_prediction = translate.index_to_type(mode(predicted_chord_types.tolist()))
    # root_note_prediction = translate.index_to_note(mode(predicted_root_notes.tolist()))

    return(chord_root_prediction)
    # TODO
    # return(chord_root_prediction + chord_type_prediction + "/" + root_note_prediction)
