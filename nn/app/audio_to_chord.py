"""
Provides a primary function, spectrogram_to_chord(), that reads in spectrogram
data and outputs a string containing the chord root, chord type, and root note
of the spectrogram. Also provides auxilliary functions for this task.
"""

from importlib import reload
import matplotlib.pyplot as plt
import numpy as np
import tensorflow as tf
from scipy.io import wavfile
from scipy import signal
import variables_chord_roots
import variables_chord_types
import variables_root_notes
import translate

frequencies = [375/16*i for i in range(1025)]
times_all = [0.064/3 + i*0.112/3 for i in range(64)]
NUM_DATA_POINTS = 16
LEN_DATA = 217*3

# build graph for ONLY predictions
data_predict = tf.placeholder(tf.float32, shape=[None, LEN_DATA])

layer_chord_roots_1_predict = tf.nn.relu(tf.add(tf.matmul(data_predict, variables_chord_roots.weights_chord_roots_hidden_1_true), variables_chord_roots.biases_chord_roots_hidden_1_true))
layer_chord_roots_2_predict = tf.nn.relu(tf.add(tf.matmul(layer_chord_roots_1_predict, variables_chord_roots.weights_chord_roots_hidden_2_true), variables_chord_roots.biases_chord_roots_hidden_2_true))
out_chord_roots_predict = tf.add(tf.matmul(layer_chord_roots_2_predict, variables_chord_roots.weights_chord_roots_out_true), variables_chord_roots.biases_chord_roots_out_true)
predict_chord_roots_op = tf.argmax(out_chord_roots_predict, axis=1)

layer_chord_types_1_predict = tf.nn.relu(tf.add(tf.matmul(data_predict, variables_chord_types.weights_chord_types_hidden_1_true), variables_chord_types.biases_chord_types_hidden_1_true))
layer_chord_types_2_predict = tf.nn.relu(tf.add(tf.matmul(layer_chord_types_1_predict, variables_chord_types.weights_chord_types_hidden_2_true), variables_chord_types.biases_chord_types_hidden_2_true))
out_chord_types_predict = tf.add(tf.matmul(layer_chord_types_2_predict, variables_chord_types.weights_chord_types_out_true), variables_chord_types.biases_chord_types_out_true)
predict_chord_types_op = tf.argmax(out_chord_types_predict, axis=1)

layer_root_notes_1_predict = tf.nn.relu(tf.matmul(data_predict, variables_root_notes.weights_root_notes_hidden_1_true) + variables_root_notes.biases_root_notes_hidden_1_true)
out_root_notes_predict = tf.add(tf.matmul(layer_root_notes_1_predict, variables_root_notes.weights_root_notes_out_true), variables_root_notes.biases_root_notes_out_true)
predict_root_notes_op = tf.argmax(out_root_notes_predict, axis=1)

# build graph for predictions and training
def initialize():
    """
    Updates parameters
    """
    reload(variables_chord_roots)
    reload(variables_chord_types)
    reload(variables_root_notes)

    data = tf.placeholder(tf.float32, shape=[None, LEN_DATA])

    weights_chord_roots_hidden_1 =  tf.Variable(tf.random_normal([LEN_DATA, variables_chord_roots.NUM_HIDDEN_CHORD_ROOTS_1], stddev=1/np.sqrt(LEN_DATA)))
    weights_chord_roots_hidden_2 =  tf.Variable(tf.random_normal([variables_chord_roots.NUM_HIDDEN_CHORD_ROOTS_1, variables_chord_roots.NUM_HIDDEN_CHORD_ROOTS_2], stddev=1/np.sqrt(variables_chord_roots.NUM_HIDDEN_CHORD_ROOTS_1)))
    weights_chord_roots_out = tf.Variable(tf.random_normal([variables_chord_roots.NUM_HIDDEN_CHORD_ROOTS_2, 12], stddev=1/np.sqrt(variables_chord_roots.NUM_HIDDEN_CHORD_ROOTS_2)))
    biases_chord_roots_hidden_1 = tf.Variable(tf.zeros(variables_chord_roots.NUM_HIDDEN_CHORD_ROOTS_1))
    biases_chord_roots_hidden_2 = tf.Variable(tf.zeros(variables_chord_roots.NUM_HIDDEN_CHORD_ROOTS_2))
    biases_chord_roots_out = tf.Variable(tf.zeros(12))
    weights_chord_roots_hidden_1_assign_op = weights_chord_roots_hidden_1.assign(variables_chord_roots.weights_chord_roots_hidden_1_true)
    weights_chord_roots_hidden_2_assign_op = weights_chord_roots_hidden_2.assign(variables_chord_roots.weights_chord_roots_hidden_2_true)
    weights_chord_roots_out_assign_op = weights_chord_roots_out.assign(variables_chord_roots.weights_chord_roots_out_true)
    biases_chord_roots_hidden_1_assign_op = biases_chord_roots_hidden_1.assign(variables_chord_roots.biases_chord_roots_hidden_1_true)
    biases_chord_roots_hidden_2_assign_op = biases_chord_roots_hidden_2.assign(variables_chord_roots.biases_chord_roots_hidden_2_true)
    biases_chord_roots_out_assign_op = biases_chord_roots_out.assign(variables_chord_roots.biases_chord_roots_out_true)

    layer_chord_roots_1 = tf.nn.relu(tf.add(tf.matmul(data, weights_chord_roots_hidden_1), biases_chord_roots_hidden_1))
    layer_chord_roots_2 = tf.nn.relu(tf.add(tf.matmul(layer_chord_roots_1, weights_chord_roots_hidden_2), biases_chord_roots_hidden_2))
    out_chord_roots = tf.add(tf.matmul(layer_chord_roots_2, weights_chord_roots_out), biases_chord_roots_out)
    out_chord_roots_softmax = tf.nn.softmax(out_chord_roots)
    labels_chord_roots = tf.placeholder(tf.float32, shape=[None, 12])
    loss_chord_roots = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(logits=out_chord_roots, labels=labels_chord_roots))
    train_chord_roots_op = tf.train.GradientDescentOptimizer(learning_rate=0.0001).minimize(loss_chord_roots)  # adjust learning rate as needed

    weights_chord_types_hidden_1 =  tf.Variable(tf.random_normal([LEN_DATA, variables_chord_types.NUM_HIDDEN_CHORD_TYPES_1], stddev=1/np.sqrt(LEN_DATA)))
    weights_chord_types_hidden_2 =  tf.Variable(tf.random_normal([variables_chord_types.NUM_HIDDEN_CHORD_TYPES_1, variables_chord_types.NUM_HIDDEN_CHORD_TYPES_2], stddev=1/np.sqrt(variables_chord_types.NUM_HIDDEN_CHORD_TYPES_1)))
    weights_chord_types_out = tf.Variable(tf.random_normal([variables_chord_types.NUM_HIDDEN_CHORD_TYPES_2, translate.NUM_CHORD_TYPES], stddev=1/np.sqrt(variables_chord_types.NUM_HIDDEN_CHORD_TYPES_2)))
    biases_chord_types_hidden_1 = tf.Variable(tf.zeros(variables_chord_types.NUM_HIDDEN_CHORD_TYPES_1))
    biases_chord_types_hidden_2 = tf.Variable(tf.zeros(variables_chord_types.NUM_HIDDEN_CHORD_TYPES_2))
    biases_chord_types_out = tf.Variable(tf.zeros(translate.NUM_CHORD_TYPES))
    weights_chord_types_hidden_1_assign_op = weights_chord_types_hidden_1.assign(variables_chord_types.weights_chord_types_hidden_1_true)
    weights_chord_types_hidden_2_assign_op = weights_chord_types_hidden_2.assign(variables_chord_types.weights_chord_types_hidden_2_true)
    weights_chord_types_out_assign_op = weights_chord_types_out.assign(variables_chord_types.weights_chord_types_out_true)
    biases_chord_types_hidden_1_assign_op = biases_chord_types_hidden_1.assign(variables_chord_types.biases_chord_types_hidden_1_true)
    biases_chord_types_hidden_2_assign_op = biases_chord_types_hidden_2.assign(variables_chord_types.biases_chord_types_hidden_2_true)
    biases_chord_types_out_assign_op = biases_chord_types_out.assign(variables_chord_types.biases_chord_types_out_true)

    layer_chord_types_1 = tf.nn.relu(tf.add(tf.matmul(data, weights_chord_types_hidden_1), biases_chord_types_hidden_1))
    layer_chord_types_2 = tf.nn.relu(tf.add(tf.matmul(layer_chord_types_1, weights_chord_types_hidden_2), biases_chord_types_hidden_2))
    out_chord_types = tf.add(tf.matmul(layer_chord_types_2, weights_chord_types_out), biases_chord_types_out)
    out_chord_types_softmax = tf.nn.softmax(out_chord_types)
    labels_chord_types = tf.placeholder(tf.float32, shape=[None, translate.NUM_CHORD_TYPES])
    loss_chord_types = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(logits=out_chord_types, labels=labels_chord_types))
    train_chord_types_op = tf.train.GradientDescentOptimizer(learning_rate=0.0001).minimize(loss_chord_types)  # adjust learning rate as needed

    weights_root_notes_hidden_1 =  tf.Variable(tf.random_normal([LEN_DATA, variables_root_notes.NUM_HIDDEN_ROOT_NOTES_1], stddev=1/np.sqrt(LEN_DATA)))
    weights_root_notes_out = tf.Variable(tf.random_normal([variables_root_notes.NUM_HIDDEN_ROOT_NOTES_1, 12], stddev=1/np.sqrt(variables_root_notes.NUM_HIDDEN_ROOT_NOTES_1)))
    biases_root_notes_hidden_1 = tf.Variable(tf.zeros(variables_root_notes.NUM_HIDDEN_ROOT_NOTES_1))
    biases_root_notes_out = tf.Variable(tf.zeros(12))
    weights_root_notes_hidden_1_assign_op = weights_root_notes_hidden_1.assign(variables_root_notes.weights_root_notes_hidden_1_true)
    weights_root_notes_out_assign_op = weights_root_notes_out.assign(variables_root_notes.weights_root_notes_out_true)
    biases_root_notes_hidden_1_assign_op = biases_root_notes_hidden_1.assign(variables_root_notes.biases_root_notes_hidden_1_true)
    biases_root_notes_out_assign_op = biases_root_notes_out.assign(variables_root_notes.biases_root_notes_out_true)

    layer_root_notes_1 = tf.nn.relu(tf.matmul(data, weights_root_notes_hidden_1) + biases_root_notes_hidden_1)
    out_root_notes = tf.add(tf.matmul(layer_root_notes_1, weights_root_notes_out), biases_root_notes_out)
    out_root_notes_softmax = tf.nn.softmax(out_root_notes)
    labels_root_notes = tf.placeholder(tf.float32, shape=[None, 12])
    loss_root_notes = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(logits=out_root_notes, labels=labels_root_notes))
    train_root_notes_op = tf.train.GradientDescentOptimizer(learning_rate=0.0001).minimize(loss_root_notes)  # adjust learning rate as needed

    # create savers for training
    saver_chord_roots = tf.train.Saver({"weights_chord_roots_hidden_1": weights_chord_roots_hidden_1,
                                        "weights_chord_roots_hidden_2": weights_chord_roots_hidden_2,
                                        "weights_chord_roots_out": weights_chord_roots_out,
                                        "biases_chord_roots_hidden_1": biases_chord_roots_hidden_1,
                                        "biases_chord_roots_hidden_2": biases_chord_roots_hidden_2,
                                        "biases_chord_roots_out": biases_chord_roots_out}, max_to_keep=1)

    saver_chord_types = tf.train.Saver({"weights_chord_types_hidden_1": weights_chord_types_hidden_1,
                                        "weights_chord_types_hidden_2": weights_chord_types_hidden_2,
                                        "weights_chord_types_out": weights_chord_types_out,
                                        "biases_chord_types_hidden_1": biases_chord_types_hidden_1,
                                        "biases_chord_types_hidden_2": biases_chord_types_hidden_2,
                                        "biases_chord_types_out": biases_chord_types_out}, max_to_keep=1)

    saver_root_notes = tf.train.Saver({"weights_root_notes_hidden_1": weights_root_notes_hidden_1,
                                       "weights_root_notes_out": weights_root_notes_out,
                                       "biases_root_notes_hidden_1": biases_root_notes_hidden_1,
                                       "biases_root_notes_out": biases_root_notes_out}, max_to_keep=1)

    globals().update(locals())

def crop_image(image):
    """
    Gets pixels in first non-whitespace column, removing whitespace at the top
    and bottom.
    """
    return(image[34:251, 55, 0:])

def mode(list_):
    """
    Returns the mode of list_. If multimodal, returns the mode lowest in value.
    If list_ is empty, returns None.
    """
    if list_ != []:
        return(max(set(list_), key=list_.count))
    return None

def error(list_, correct):
    """
    Returns the error (incorrect predictions divided by the total number of
    predictions).
    """
    return(1 - list_.count(correct)/len(list_))

def rank_confidence_notes(list_lists):
    """
    Ranks the confidence of chord note predictions given the probabilities in
    list_lists. Returns a tuple containing the ranked list (highest first) and
    the lowest probabilities of each note in list_lists.
    """
    min_confidence = [1]*len(list_lists[0])
    for i in range(len(list_lists)):
        for j in range(len(list_lists[0])):
            min_confidence[j] = min(min_confidence[j], list_lists[i][j])
    return([translate.index_to_note(i) for i in np.argsort(min_confidence)[::-1]], sorted(min_confidence, reverse=True))

def rank_confidence_types(list_lists):
    """
    Ranks the confidence of chord type predictions given the probabilities in
    list_lists. Returns a tuple containing the ranked list (highest first) and
    the lowest probabilities of each type in list_lists.
    """
    min_confidence = [1]*len(list_lists[0])
    for i in range(len(list_lists)):
        for j in range(len(list_lists[0])):
            min_confidence[j] = min(min_confidence[j], list_lists[i][j])
    return([translate.index_to_type(i) for i in np.argsort(min_confidence)[::-1]], sorted(min_confidence, reverse=True))

def generate_label(num_labels, correct_label):
    """
    Returns a one-hot label.
    """
    label = [0]*num_labels
    label[correct_label] = 1
    return(label)

def spectrogram_to_chord_train(file):  # change parameter to spectrogram if input is spectrogram data
    """
    Reads in spectrogram data and returns a string containing the predicted
    chord root, chord type, and root note of the spectrogram. Use for training
    the neural networks.
    """
    initialize()

    sample_rate, samples = wavfile.read(file)
    frequencies_, times, spectrogram = signal.spectrogram(samples, sample_rate, nperseg=2048)

    # convert spectrogram data to image pixel data
    array_image_data_all = []

    figure = plt.figure(figsize=(6, 3.92), dpi=72)  # don't change this line
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

    plt.close("all")
    array_image_data_all = np.array(array_image_data_all)

    # make chord predictions using the created graph
    sess = tf.Session()

    sess.run(weights_chord_roots_hidden_1_assign_op)
    sess.run(weights_chord_roots_hidden_2_assign_op)
    sess.run(weights_chord_roots_out_assign_op)
    sess.run(biases_chord_roots_hidden_1_assign_op)
    sess.run(biases_chord_roots_hidden_2_assign_op)
    sess.run(biases_chord_roots_out_assign_op)

    sess.run(weights_chord_types_hidden_1_assign_op)
    sess.run(weights_chord_types_hidden_2_assign_op)
    sess.run(weights_chord_types_out_assign_op)
    sess.run(biases_chord_types_hidden_1_assign_op)
    sess.run(biases_chord_types_hidden_2_assign_op)
    sess.run(biases_chord_types_out_assign_op)

    sess.run(weights_root_notes_hidden_1_assign_op)
    sess.run(weights_root_notes_out_assign_op)
    sess.run(biases_root_notes_hidden_1_assign_op)
    sess.run(biases_root_notes_out_assign_op)

    out_chord_roots_probabilities = sess.run(out_chord_roots_softmax, feed_dict={data: array_image_data_all})
    out_chord_types_probabilities = sess.run(out_chord_types_softmax, feed_dict={data: array_image_data_all})
    out_root_notes_probabilities = sess.run(out_root_notes_softmax, feed_dict={data: array_image_data_all})

    predicted_chord_roots = tf.argmax(out_chord_roots_probabilities, axis=1).eval(session=sess)
    predicted_chord_types = tf.argmax(out_chord_types_probabilities, axis=1).eval(session=sess)
    predicted_root_notes = tf.argmax(out_root_notes_probabilities, axis=1).eval(session=sess)

    rank_chord_roots, probabilities_chord_roots = rank_confidence_notes(out_chord_roots_probabilities)
    rank_chord_types, probabilities_chord_types = rank_confidence_types(out_chord_types_probabilities)
    rank_root_notes, probabilities_root_notes = rank_confidence_notes(out_root_notes_probabilities)

    print("\nChord root:")
    print("All predictions:", [translate.index_to_note(i) for i in predicted_chord_roots])
    print("Confidence rank: ", rank_chord_roots)
    print("Lowest probabilities:", probabilities_chord_roots)

    print("\nChord type:")
    print("All predictions:", [translate.index_to_type(i) for i in predicted_chord_types])
    print("Confidence rank: ", rank_chord_types)
    print("Lowest probabilities:", probabilities_chord_types)

    print("\nRoot note:")
    print("All predictions:", [translate.index_to_note(i) for i in predicted_root_notes])
    print("Confidence rank: ", rank_root_notes)
    print("Lowest probabilities:", probabilities_root_notes)

    chord_root_prediction = rank_chord_roots[0]
    chord_type_prediction = rank_chord_types[0]
    root_note_prediction = rank_root_notes[0]

    print("\nChord prediction:", chord_root_prediction + chord_type_prediction + "/" + root_note_prediction)

    if input("\nTrain chord root? (y/n): ") == "y":
        chord_root_label = input("Index of correct chord root in confidence rank (c to cancel): ")
        if chord_root_label != "c":
            chord_root_label = translate.note_to_index(rank_chord_roots[int(chord_root_label)])
            chord_root_labels = np.array([generate_label(12, int(chord_root_label))]*len(predicted_chord_roots))
            sess.run(train_chord_roots_op, feed_dict={data: array_image_data_all, labels_chord_roots: chord_root_labels})
            saver_chord_roots.save(sess, "model/chord_roots/chord_roots_model")
            print("\nChord root trained!")

    if input("\nTrain chord type? (y/n): ") == "y":
        chord_type_label = input("Index of correct chord type in confidence rank (c to cancel): ")
        if chord_type_label != "c":
            chord_type_label = translate.type_to_index(rank_chord_types[int(chord_type_label)])
            chord_type_labels = np.array([generate_label(translate.NUM_CHORD_TYPES, int(chord_type_label))]*len(predicted_chord_types))
            sess.run(train_chord_types_op, feed_dict={data: array_image_data_all, labels_chord_types: chord_type_labels})
            saver_chord_types.save(sess, "model/chord_types/chord_types_model")
            print("\nChord type trained!")

    if input("\nTrain root note? (y/n): ") == "y":
        root_note_label = input("Index of correct root note in confidence rank (c to cancel): ")
        if root_note_label != "c":
            root_note_label = translate.note_to_index(rank_root_notes[int(root_note_label)])
            root_note_labels = np.array([generate_label(12, int(root_note_label))]*len(predicted_root_notes))
            sess.run(train_root_notes_op, feed_dict={data: array_image_data_all, labels_root_notes: root_note_labels})
            saver_root_notes.save(sess, "model/root_notes/root_notes_model")
            print("\nRoot note trained!\n")

    sess.close()

def spectrogram_to_chord(spectrogram):
    """
    Reads in spectrogram data and returns a string containing the predicted
    chord root, chord type, and root note of the spectrogram.
    """
    times = times_all[:len(spectrogram[0])]  # times_all is a global variable

    # convert spectrogram data to image pixel data
    array_image_data_all = []

    figure = plt.figure(figsize=(6, 3.92), dpi=72)  # don't change this line
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

    plt.close("all")
    array_image_data_all = np.array(array_image_data_all)

    # make chord predictions using the created graph
    with tf.Session() as sess:
        predicted_chord_roots = sess.run(predict_chord_roots_op, feed_dict={data: array_image_data_all}).tolist()
        predicted_chord_types = sess.run(predict_chord_types_op, feed_dict={data: array_image_data_all}).tolist()
        predicted_root_notes = sess.run(predict_root_notes_op, feed_dict={data: array_image_data_all}).tolist()

    chord_root_prediction = translate.index_to_note(mode(predicted_chord_roots))
    chord_type_prediction = translate.index_to_type(mode(predicted_chord_types))
    root_note_prediction = translate.index_to_note(mode(predicted_root_notes))

    return(chord_root_prediction + chord_type_prediction + "/" + root_note_prediction)

"""
if __name__ == "__main__":
    spectrogram_to_chord_train("e_flat_minor_f_sharp_fourth_octave.wav")
"""
