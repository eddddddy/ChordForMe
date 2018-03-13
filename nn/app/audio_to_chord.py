import matplotlib.pyplot as plt
import numpy as np
import tensorflow as tf
from scipy.io import wavfile
from scipy import signal
import variables
import translate

def crop_image(image):
    """
    Gets pixels in first non-whitespace column, removing whitespace at the top and bottom
    """
    return(image[35:252, 54, 0:])

def mode(list1):
    """
    Returns the mode of list1. If multimodal, returns the mode lowest in value
    """
    return(max(set(list1), key=list1.count))

frequencies = [375/16*i for i in range(1025)]
times_all = [0.064/3 + i*0.112/3 for i in range(64)]

data = tf.placeholder(tf.float32, shape=[16, variables.len_data])

layer_chord_roots_1 = tf.nn.relu(tf.matmul(data, variables.weights_chord_roots_hidden_1) + variables.biases_chord_roots_hidden_1)
layer_chord_roots_2 = tf.nn.relu(tf.matmul(layer_chord_roots_1, variables.weights_chord_roots_hidden_2) + variables.biases_chord_roots_hidden_2)
out_chord_roots = tf.matmul(layer_chord_roots_2, variables.weights_chord_roots_out) + variables.biases_chord_roots_out
predict_chord_roots_op = tf.argmax(out_chord_roots, axis=1)

def spectrogram_to_chord(file):
    #comment these two lines out if input is spectrogram data
    sample_rate, samples = wavfile.read(file)
    frequencies_, times, spectrogram = signal.spectrogram(samples, sample_rate, nperseg=2048)

    #comment this line in if input is spectrogram data
    #times = times_all[:len(times)]

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

    with tf.Session() as sess:
        predicted_chord_roots = sess.run(predict_chord_roots_op, feed_dict={data: array_image_data_all})
        #predicted_chord_types = sess.run(predict_chord_types_op, feed_dict={data: array_image_data_all})
        #predicted_root_notes = sess.run(predict_root_notes_op, feed_dict={data: array_image_data_all})

    chord_root_prediction = translate.index_to_note(mode(predicted_chord_roots.tolist()))
    #chord_type_prediction = translate.index_to_type(mode(predicted_chord_types.tolist()))
    #root_note_prediction = translate.index_to_note(mode(predicted_root_notes.tolist()))

    return(chord_root_prediction)
    #return(chord_root_prediction + chord_type_prediction + "/" + root_note_prediction)
