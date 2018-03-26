"""
Provides a primary function, spectrogram_to_chord(), that reads in spectrogram
data and outputs a string containing the chord root, chord type, and root note
of the spectrogram. Also provides auxilliary functions.
"""

from importlib import reload
from itertools import product
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
times_all = [0.064/3 + i*0.112/3 for i in range(32)]
NUM_DATA_POINTS = 4
LEN_DATA = 217*3

# build graph for ONLY predictions
data_predict = tf.placeholder(tf.float32, shape=[None, LEN_DATA])

layer_chord_roots_1_predict = tf.nn.relu(tf.add(tf.matmul(data_predict, variables_chord_roots.weights_chord_roots_hidden_1_true), variables_chord_roots.biases_chord_roots_hidden_1_true))
layer_chord_roots_2_predict = tf.nn.relu(tf.add(tf.matmul(layer_chord_roots_1_predict, variables_chord_roots.weights_chord_roots_hidden_2_true), variables_chord_roots.biases_chord_roots_hidden_2_true))
out_chord_roots_predict = tf.add(tf.matmul(layer_chord_roots_2_predict, variables_chord_roots.weights_chord_roots_out_true), variables_chord_roots.biases_chord_roots_out_true)
out_chord_roots_softmax_predict = tf.nn.softmax(out_chord_roots_predict)
predict_chord_roots_op = tf.argmax(out_chord_roots_predict, axis=1)

layer_chord_types_1_predict = tf.nn.relu(tf.add(tf.matmul(data_predict, variables_chord_types.weights_chord_types_hidden_1_true), variables_chord_types.biases_chord_types_hidden_1_true))
layer_chord_types_2_predict = tf.nn.relu(tf.add(tf.matmul(layer_chord_types_1_predict, variables_chord_types.weights_chord_types_hidden_2_true), variables_chord_types.biases_chord_types_hidden_2_true))
out_chord_types_predict = tf.add(tf.matmul(layer_chord_types_2_predict, variables_chord_types.weights_chord_types_out_true), variables_chord_types.biases_chord_types_out_true)
out_chord_types_softmax_predict = tf.nn.softmax(out_chord_types_predict)
predict_chord_types_op = tf.argmax(out_chord_types_predict, axis=1)

layer_root_notes_1_predict = tf.nn.relu(tf.matmul(data_predict, variables_root_notes.weights_root_notes_hidden_1_true) + variables_root_notes.biases_root_notes_hidden_1_true)
out_root_notes_predict = tf.add(tf.matmul(layer_root_notes_1_predict, variables_root_notes.weights_root_notes_out_true), variables_root_notes.biases_root_notes_out_true)
out_root_notes_softmax_predict = tf.nn.softmax(out_root_notes_predict)
predict_root_notes_op = tf.argmax(out_root_notes_predict, axis=1)

def init():
    """
    Updates parameters from Tensorflow checkpoints. Builds graphs for
    predictions and training using global variables.
    """
    # need to re-read data from checkpoint files
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

def rank_lowest_confidence_notes(list_lists):
    """
    Ranks the lowest confidence of note predictions given the probabilities in
    list_lists. Returns a tuple containing the ranked list (highest first) and
    the lowest probabilities of each note in list_lists.
    """
    min_confidence = np.amin(list_lists, axis=0)
    return(np.vectorize(translate.index_to_note)(np.argsort(min_confidence)[::-1]), np.sort(min_confidence)[::-1])

def rank_lowest_confidence_types(list_lists):
    """
    Ranks the lowest confidence of type predictions given the probabilities in
    list_lists. Returns a tuple containing the ranked list (highest first) and
    the lowest probabilities of each type in list_lists.
    """
    min_confidence = np.amin(list_lists, axis=0)
    return(np.vectorize(translate.index_to_type)(np.argsort(min_confidence)[::-1]), np.sort(min_confidence)[::-1])

def lowest_confidence(list_lists):
    """
    Returns the lowest confidence of predictions in list_lists. Unlike
    rank_lowest_confidence, does not attempt to sort the resulting list, but
    instead retains the same order as the elements of list_lists.
    """
    return(np.amin(list_lists, axis=0))

def generate_label(num_labels, correct_label):
    """
    Returns a one-hot label.
    """
    label = [0]*num_labels
    label[correct_label] = 1
    return(label)

def is_empty_space(list_):
    """
    Checks if list_ data is empty space.
    """
    return(list_[0] == 1)

def is_background_noise(list_):
    """
    Checks if list_ data is background noise.
    """
    for i in range(int(len(list_)/3)):
        if (list_[3*i] != 68/255) or (list_[3*i + 1] != 1/255) or (list_[3*i + 2] != 84/255):  # rgb color of background noise is (68, 1, 84)
            return False
    return True

def most_likely_chord_probability(chord_root_probabilities, chord_type_probabilities, root_note_probabilities):
    """
    Returns a tuple with the most likely possible chord root, chord type, and
    root note (represented as indices), given lists of probabilities.
    """
    chord_properties = list(product(list(range(12)), list(range(translate.NUM_CHORD_TYPES)), list(range(12))))
    chord_probabilities = [np.prod(i) for i in product(chord_root_probabilities, chord_type_probabilities, root_note_probabilities)]

    # rank chords based on probability
    chord_properties_sorted = [properties for probability, properties in sorted(zip(chord_probabilities, chord_properties), reverse=True)]
    chord_probabilities_sorted = sorted(chord_probabilities, reverse=True)

    for i in range(len(chord_probabilities_sorted)):
        chord_root_predicted = chord_properties_sorted[i][0]
        chord_type_predicted = chord_properties_sorted[i][1]
        root_note_predicted = chord_properties_sorted[i][2]

        # return properties if chord is possible
        if translate.is_possible_chord(chord_root_predicted, chord_type_predicted, root_note_predicted):
            return(chord_root_predicted, chord_type_predicted, root_note_predicted)

def most_likely_chord_mode(chord_root_predictions, chord_type_predictions, root_note_predictions):
    """
    Returns a tuple with the most frequent possible chord root, chord type, and
    root note (represented as indices), given lists of predictions.
    """
    chord_properties_predictions = list(product(chord_root_predictions, chord_type_predictions, root_note_predictions))

    while True:
        # handle case where no predicted chord is possible
        if chord_properties_predictions == []:
            raise ValueError("No possible chord found")

        chord_properties_predicted = mode(chord_properties_predictions)
        chord_root_predicted = chord_properties_predicted[0]
        chord_type_predicted = chord_properties_predicted[1]
        root_note_predicted = chord_properties_predicted[2]

        # return properties if chord is possible
        if translate.is_possible_chord(chord_root_predicted, chord_type_predicted, root_note_predicted):
            return(chord_root_predicted, chord_type_predicted, root_note_predicted)

        # if not possible, remove all instances of mode from list and loop
        chord_properties_predictions = [properties for properties in chord_properties_predictions if properties != chord_properties_predicted]

def spectrogram_to_chord_train(file):
    """
    Reads data from a wav file and returns a string containing the predicted
    chord root, chord type, and root note of the spectrogram. Use for
    additional training.
    """
    init()  # reload parameters

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

        if is_empty_space(image) or is_background_noise(image):  # skip empty space and background noise
            continue
        array_image_data_all.append(image.tolist())

    plt.close("all")

    if array_image_data_all == []:
        return("")
    array_image_data_all = np.array(array_image_data_all)

    # make chord predictions using the created graph (in global variables)
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

    # use softmax probabilities to rank predictions
    rank_chord_roots, probabilities_chord_roots = rank_lowest_confidence_notes(out_chord_roots_probabilities)
    rank_chord_types, probabilities_chord_types = rank_lowest_confidence_types(out_chord_types_probabilities)
    rank_root_notes, probabilities_root_notes = rank_lowest_confidence_notes(out_root_notes_probabilities)

    # print relevant information
    print("\nChord root:")
    print("All predictions:", np.vectorize(translate.index_to_note)(predicted_chord_roots))
    print("Confidence rank: ", rank_chord_roots)
    print("Lowest probabilities:", probabilities_chord_roots)

    print("\nChord type:")
    print("All predictions:", np.vectorize(translate.index_to_type)(predicted_chord_types))
    print("Confidence rank: ", rank_chord_types)
    print("Lowest probabilities:", probabilities_chord_types)

    print("\nRoot note:")
    print("All predictions:", np.vectorize(translate.index_to_note)(predicted_root_notes))
    print("Confidence rank: ", rank_root_notes)
    print("Lowest probabilities:", probabilities_root_notes)

    chord_properties_prediction = most_likely_chord_probability(lowest_confidence(out_chord_roots_probabilities), lowest_confidence(out_chord_types_probabilities), lowest_confidence(out_root_notes_probabilities))
    chord_root_prediction = translate.index_to_note(chord_properties_prediction[0])
    chord_type_prediction = translate.index_to_type(chord_properties_prediction[1])
    root_note_prediction = translate.index_to_note(chord_properties_prediction[2])

    print("\nChord prediction:", chord_root_prediction + chord_type_prediction + "/" + root_note_prediction)

    # user determines whether to train
    if input("\nTrain chord root? (y/n): ") == "y":
        chord_root_label = input("Index of correct chord root in confidence rank (c to cancel): ")
        if chord_root_label != "c":
            chord_root_label = translate.note_to_index(rank_chord_roots[int(chord_root_label)])
            chord_root_labels = np.array([generate_label(12, int(chord_root_label))]*len(predicted_chord_roots))
            sess.run(train_chord_roots_op, feed_dict={data: array_image_data_all, labels_chord_roots: chord_root_labels})
            saver_chord_roots.save(sess, "model/chord_roots/chord_roots_model", write_meta_graph=False)
            print("\nChord root trained!")

    if input("\nTrain chord type? (y/n): ") == "y":
        chord_type_label = input("Index of correct chord type in confidence rank (c to cancel): ")
        if chord_type_label != "c":
            chord_type_label = translate.type_to_index(rank_chord_types[int(chord_type_label)])
            chord_type_labels = np.array([generate_label(translate.NUM_CHORD_TYPES, int(chord_type_label))]*len(predicted_chord_types))
            sess.run(train_chord_types_op, feed_dict={data: array_image_data_all, labels_chord_types: chord_type_labels})
            saver_chord_types.save(sess, "model/chord_types/chord_types_model", write_meta_graph=False)
            print("\nChord type trained!")

    if input("\nTrain root note? (y/n): ") == "y":
        root_note_label = input("Index of correct root note in confidence rank (c to cancel): ")
        if root_note_label != "c":
            root_note_label = translate.note_to_index(rank_root_notes[int(root_note_label)])
            root_note_labels = np.array([generate_label(12, int(root_note_label))]*len(predicted_root_notes))
            sess.run(train_root_notes_op, feed_dict={data: array_image_data_all, labels_root_notes: root_note_labels})
            saver_root_notes.save(sess, "model/root_notes/root_notes_model", write_meta_graph=False)
            print("\nRoot note trained!")

    print("\n")
    sess.close()

def spectrogram_to_chord(spectrogram):
    """
    Reads spectrogram data and returns a string containing the predicted
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

        if is_empty_space(image) or is_background_noise(image):  # skip empty space and background noise
            continue
        array_image_data_all.append(image.tolist())

    plt.close("all")

    if array_image_data_all == []:
        return("")
    array_image_data_all = np.array(array_image_data_all)

    # make chord predictions using the created graph

    # using softmax probabilities
    with tf.Session() as sess:
        out_chord_roots_probabilities = sess.run(out_chord_roots_softmax_predict, feed_dict={data_predict: array_image_data_all})
        out_chord_types_probabilities = sess.run(out_chord_types_softmax_predict, feed_dict={data_predict: array_image_data_all})
        out_root_notes_probabilities = sess.run(out_root_notes_softmax_predict, feed_dict={data_predict: array_image_data_all})

    chord_properties_prediction = most_likely_chord_probability(lowest_confidence(out_chord_roots_probabilities), lowest_confidence(out_chord_types_probabilities), lowest_confidence(out_root_notes_probabilities))

    # using mode
    """
    with tf.Session() as sess:
        predicted_chord_roots = sess.run(predict_chord_roots_op, feed_dict={data_predict: array_image_data_all})
        predicted_chord_types = sess.run(predict_chord_types_op, feed_dict={data_predict: array_image_data_all})
        predicted_root_notes = sess.run(predict_root_notes_op, feed_dict={data_predict: array_image_data_all})

    try:
        chord_properties_prediction = most_likely_chord_mode(predicted_chord_roots, predicted_chord_types, predicted_root_notes)
    except ValueError:
        return("")
    """

    chord_root_prediction = translate.index_to_note(chord_properties_prediction[0])
    chord_type_prediction = translate.index_to_type(chord_properties_prediction[1])
    root_note_prediction = translate.index_to_note(chord_properties_prediction[2])

    return(chord_root_prediction + chord_type_prediction + "/" + root_note_prediction)

"""
if __name__ == "__main__":
    spectrogram_to_chord_train("e_flat_minor_f_sharp_fourth_octave.wav")
"""
