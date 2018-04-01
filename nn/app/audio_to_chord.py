"""
Includes a main function, spectrogram_to_chord(), that reads in spectrogram
data and outputs a string containing the chord root, chord type, and root note
of the spectrogram. Also includes spectrogram_to_chord_train(), for additional
training, as well as other auxilliary functions.
"""

from itertools import product
import matplotlib.pyplot as plt
import numpy as np
import tensorflow as tf
from scipy.io import wavfile
from scipy import signal

def load_global_vars():
    """
    Creates global variables used in predictions.
    """
    frequencies = [375/16*i for i in range(1025)]
    times_all = [0.064/3 + i*0.112/3 for i in range(32)]
    notes = ["C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C"]
    chord_types = ["", "m", "7", "maj7", "min7", "mm7", "aug", "dim", "dim7", "dimm7"]
    NUM_DATA_POINTS = 4
    NUM_CHORD_TYPES = 3  # only major, minor, and dominant seventh
    NUM_HIDDEN_CHORD_ROOTS_1 = 1024
    NUM_HIDDEN_CHORD_ROOTS_2 = 1024
    NUM_HIDDEN_CHORD_TYPES_1 = 2048
    NUM_HIDDEN_CHORD_TYPES_2 = 2048
    NUM_HIDDEN_ROOT_NOTES_1 = 2048
    LEN_DATA = 217*3

    globals().update(locals())

def load_variables_chord_roots():
    """
    Retrieves values of variables in the chord roots model, stored in
    Tensorflow checkpoint files, and gives them global scope.
    """
    tf.reset_default_graph()

    weights_chord_roots_hidden_1 = tf.get_variable(
        "weights_chord_roots_hidden_1",
        shape=[LEN_DATA, NUM_HIDDEN_CHORD_ROOTS_1],
        dtype=tf.float32,
        initializer=tf.random_normal_initializer(stddev=1/np.sqrt(LEN_DATA)))

    weights_chord_roots_hidden_2 = tf.get_variable(
        "weights_chord_roots_hidden_2",
        shape=[NUM_HIDDEN_CHORD_ROOTS_1, NUM_HIDDEN_CHORD_ROOTS_2],
        dtype=tf.float32,
        initializer=tf.random_normal_initializer(stddev=1/np.sqrt(NUM_HIDDEN_CHORD_ROOTS_1)))

    weights_chord_roots_out = tf.get_variable(
        "weights_chord_roots_out",
        shape=[NUM_HIDDEN_CHORD_ROOTS_1, 12],
        dtype=tf.float32,
        initializer=tf.random_normal_initializer(stddev=1/np.sqrt(NUM_HIDDEN_CHORD_ROOTS_2)))

    biases_chord_roots_hidden_1 = tf.get_variable(
        "biases_chord_roots_hidden_1",
        shape=[NUM_HIDDEN_CHORD_ROOTS_1],
        dtype=tf.float32,
        initializer=tf.zeros_initializer())

    biases_chord_roots_hidden_2 = tf.get_variable(
        "biases_chord_roots_hidden_2",
        shape=[NUM_HIDDEN_CHORD_ROOTS_2],
        dtype=tf.float32,
        initializer=tf.zeros_initializer())

    biases_chord_roots_out = tf.get_variable(
        "biases_chord_roots_out",
        shape=[12],
        dtype=tf.float32,
        initializer=tf.zeros_initializer())

    with tf.Session() as sess:
        saver = tf.train.Saver()
        saver.restore(sess, "model/chord_roots/chord_roots_model")

        weights_chord_roots_hidden_1_true = sess.run(weights_chord_roots_hidden_1)
        weights_chord_roots_hidden_2_true = sess.run(weights_chord_roots_hidden_2)
        weights_chord_roots_out_true = sess.run(weights_chord_roots_out)
        biases_chord_roots_hidden_1_true = sess.run(biases_chord_roots_hidden_1)
        biases_chord_roots_hidden_2_true = sess.run(biases_chord_roots_hidden_2)
        biases_chord_roots_out_true = sess.run(biases_chord_roots_out)

    globals().update(locals())

def load_variables_chord_types():
    """
    Retrieves values of variables in the chord types model, stored in
    Tensorflow checkpoint files, and gives them global scope.
    """
    tf.reset_default_graph()

    weights_chord_types_hidden_1 = tf.get_variable(
        "weights_chord_types_hidden_1",
        shape=[LEN_DATA, NUM_HIDDEN_CHORD_TYPES_1],
        dtype=tf.float32,
        initializer=tf.random_normal_initializer(stddev=1/np.sqrt(LEN_DATA)))

    weights_chord_types_hidden_2 = tf.get_variable(
        "weights_chord_types_hidden_2",
        shape=[NUM_HIDDEN_CHORD_TYPES_1, NUM_HIDDEN_CHORD_TYPES_2],
        dtype=tf.float32,
        initializer=tf.random_normal_initializer(stddev=1/np.sqrt(NUM_HIDDEN_CHORD_TYPES_1)))

    weights_chord_types_out = tf.get_variable(
        "weights_chord_types_out",
        shape=[NUM_HIDDEN_CHORD_TYPES_2, NUM_CHORD_TYPES],
        dtype=tf.float32,
        initializer=tf.random_normal_initializer(stddev=1/np.sqrt(NUM_HIDDEN_CHORD_TYPES_2)))

    biases_chord_types_hidden_1 = tf.get_variable(
        "biases_chord_types_hidden_1",
        shape=[NUM_HIDDEN_CHORD_TYPES_1],
        dtype=tf.float32,
        initializer=tf.zeros_initializer())

    biases_chord_types_hidden_2 = tf.get_variable(
        "biases_chord_types_hidden_2",
        shape=[NUM_HIDDEN_CHORD_TYPES_2],
        dtype=tf.float32,
        initializer=tf.zeros_initializer())

    biases_chord_types_out = tf.get_variable(
        "biases_chord_types_out",
        shape=[NUM_CHORD_TYPES],
        dtype=tf.float32,
        initializer=tf.zeros_initializer())

    with tf.Session() as sess:
        saver = tf.train.Saver()
        saver.restore(sess, "model/chord_types/chord_types_model")

        weights_chord_types_hidden_1_true = sess.run(weights_chord_types_hidden_1)
        weights_chord_types_hidden_2_true = sess.run(weights_chord_types_hidden_2)
        weights_chord_types_out_true = sess.run(weights_chord_types_out)
        biases_chord_types_hidden_1_true = sess.run(biases_chord_types_hidden_1)
        biases_chord_types_hidden_2_true = sess.run(biases_chord_types_hidden_2)
        biases_chord_types_out_true = sess.run(biases_chord_types_out)

    globals().update(locals())

def load_variables_root_notes():
    """
    Retrieves values of variables in the chord roots model, stored in
    Tensorflow checkpoint files, and gives them global scope.
    """
    tf.reset_default_graph()

    weights_root_notes_hidden_1 = tf.get_variable(
        "weights_root_notes_hidden_1",
        shape=[LEN_DATA, NUM_HIDDEN_ROOT_NOTES_1],
        dtype=tf.float32,
        initializer=tf.random_normal_initializer(stddev=1/np.sqrt(LEN_DATA)))

    weights_root_notes_out = tf.get_variable(
        "weights_root_notes_out",
        shape=[NUM_HIDDEN_ROOT_NOTES_1, 12],
        dtype=tf.float32,
        initializer=tf.random_normal_initializer(stddev=1/np.sqrt(NUM_HIDDEN_ROOT_NOTES_1)))

    biases_root_notes_hidden_1 = tf.get_variable(
        "biases_root_notes_hidden_1",
        shape=[NUM_HIDDEN_ROOT_NOTES_1],
        dtype=tf.float32,
        initializer=tf.zeros_initializer())

    biases_root_notes_out = tf.get_variable(
        "biases_root_notes_out",
        shape=[12],
        dtype=tf.float32,
        initializer=tf.zeros_initializer())

    with tf.Session() as sess:
        saver = tf.train.Saver()
        saver.restore(sess, "model/root_notes/root_notes_model")

        weights_root_notes_hidden_1_true = sess.run(weights_root_notes_hidden_1)
        weights_root_notes_out_true = sess.run(weights_root_notes_out)
        biases_root_notes_hidden_1_true = sess.run(biases_root_notes_hidden_1)
        biases_root_notes_out_true = sess.run(biases_root_notes_out)

    globals().update(locals())

def init_train():
    """
    Updates variables from Tensorflow checkpoints. Builds graphs for
    predictions and training, giving them global scope.
    """
    load_global_vars()

    # need to re-read data from checkpoint files
    load_variables_chord_roots()
    load_variables_chord_types()
    load_variables_root_notes()

    data = tf.placeholder(tf.float32, shape=[None, LEN_DATA])

    weights_chord_roots_hidden_1 =  tf.Variable(tf.random_normal([LEN_DATA, NUM_HIDDEN_CHORD_ROOTS_1], stddev=1/np.sqrt(LEN_DATA)))
    weights_chord_roots_hidden_2 =  tf.Variable(tf.random_normal([NUM_HIDDEN_CHORD_ROOTS_1, NUM_HIDDEN_CHORD_ROOTS_2], stddev=1/np.sqrt(NUM_HIDDEN_CHORD_ROOTS_1)))
    weights_chord_roots_out = tf.Variable(tf.random_normal([NUM_HIDDEN_CHORD_ROOTS_2, 12], stddev=1/np.sqrt(NUM_HIDDEN_CHORD_ROOTS_2)))
    biases_chord_roots_hidden_1 = tf.Variable(tf.zeros(NUM_HIDDEN_CHORD_ROOTS_1))
    biases_chord_roots_hidden_2 = tf.Variable(tf.zeros(NUM_HIDDEN_CHORD_ROOTS_2))
    biases_chord_roots_out = tf.Variable(tf.zeros(12))
    weights_chord_roots_hidden_1_assign_op = weights_chord_roots_hidden_1.assign(weights_chord_roots_hidden_1_true)
    weights_chord_roots_hidden_2_assign_op = weights_chord_roots_hidden_2.assign(weights_chord_roots_hidden_2_true)
    weights_chord_roots_out_assign_op = weights_chord_roots_out.assign(weights_chord_roots_out_true)
    biases_chord_roots_hidden_1_assign_op = biases_chord_roots_hidden_1.assign(biases_chord_roots_hidden_1_true)
    biases_chord_roots_hidden_2_assign_op = biases_chord_roots_hidden_2.assign(biases_chord_roots_hidden_2_true)
    biases_chord_roots_out_assign_op = biases_chord_roots_out.assign(biases_chord_roots_out_true)

    layer_chord_roots_1 = tf.nn.relu(tf.add(tf.matmul(data, weights_chord_roots_hidden_1), biases_chord_roots_hidden_1))
    layer_chord_roots_2 = tf.nn.relu(tf.add(tf.matmul(layer_chord_roots_1, weights_chord_roots_hidden_2), biases_chord_roots_hidden_2))
    out_chord_roots = tf.add(tf.matmul(layer_chord_roots_2, weights_chord_roots_out), biases_chord_roots_out)
    out_chord_roots_softmax = tf.nn.softmax(out_chord_roots)
    labels_chord_roots = tf.placeholder(tf.float32, shape=[None, 12])
    loss_chord_roots = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(logits=out_chord_roots, labels=labels_chord_roots))
    train_chord_roots_op = tf.train.GradientDescentOptimizer(learning_rate=0.0001).minimize(loss_chord_roots)  # adjust learning rate as needed

    weights_chord_types_hidden_1 =  tf.Variable(tf.random_normal([LEN_DATA, NUM_HIDDEN_CHORD_TYPES_1], stddev=1/np.sqrt(LEN_DATA)))
    weights_chord_types_hidden_2 =  tf.Variable(tf.random_normal([NUM_HIDDEN_CHORD_TYPES_1, NUM_HIDDEN_CHORD_TYPES_2], stddev=1/np.sqrt(NUM_HIDDEN_CHORD_TYPES_1)))
    weights_chord_types_out = tf.Variable(tf.random_normal([NUM_HIDDEN_CHORD_TYPES_2, NUM_CHORD_TYPES], stddev=1/np.sqrt(NUM_HIDDEN_CHORD_TYPES_2)))
    biases_chord_types_hidden_1 = tf.Variable(tf.zeros(NUM_HIDDEN_CHORD_TYPES_1))
    biases_chord_types_hidden_2 = tf.Variable(tf.zeros(NUM_HIDDEN_CHORD_TYPES_2))
    biases_chord_types_out = tf.Variable(tf.zeros(NUM_CHORD_TYPES))
    weights_chord_types_hidden_1_assign_op = weights_chord_types_hidden_1.assign(weights_chord_types_hidden_1_true)
    weights_chord_types_hidden_2_assign_op = weights_chord_types_hidden_2.assign(weights_chord_types_hidden_2_true)
    weights_chord_types_out_assign_op = weights_chord_types_out.assign(weights_chord_types_out_true)
    biases_chord_types_hidden_1_assign_op = biases_chord_types_hidden_1.assign(biases_chord_types_hidden_1_true)
    biases_chord_types_hidden_2_assign_op = biases_chord_types_hidden_2.assign(biases_chord_types_hidden_2_true)
    biases_chord_types_out_assign_op = biases_chord_types_out.assign(biases_chord_types_out_true)

    layer_chord_types_1 = tf.nn.relu(tf.add(tf.matmul(data, weights_chord_types_hidden_1), biases_chord_types_hidden_1))
    layer_chord_types_2 = tf.nn.relu(tf.add(tf.matmul(layer_chord_types_1, weights_chord_types_hidden_2), biases_chord_types_hidden_2))
    out_chord_types = tf.add(tf.matmul(layer_chord_types_2, weights_chord_types_out), biases_chord_types_out)
    out_chord_types_softmax = tf.nn.softmax(out_chord_types)
    labels_chord_types = tf.placeholder(tf.float32, shape=[None, NUM_CHORD_TYPES])
    loss_chord_types = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(logits=out_chord_types, labels=labels_chord_types))
    train_chord_types_op = tf.train.GradientDescentOptimizer(learning_rate=0.0001).minimize(loss_chord_types)  # adjust learning rate as needed

    weights_root_notes_hidden_1 =  tf.Variable(tf.random_normal([LEN_DATA, NUM_HIDDEN_ROOT_NOTES_1], stddev=1/np.sqrt(LEN_DATA)))
    weights_root_notes_out = tf.Variable(tf.random_normal([NUM_HIDDEN_ROOT_NOTES_1, 12], stddev=1/np.sqrt(NUM_HIDDEN_ROOT_NOTES_1)))
    biases_root_notes_hidden_1 = tf.Variable(tf.zeros(NUM_HIDDEN_ROOT_NOTES_1))
    biases_root_notes_out = tf.Variable(tf.zeros(12))
    weights_root_notes_hidden_1_assign_op = weights_root_notes_hidden_1.assign(weights_root_notes_hidden_1_true)
    weights_root_notes_out_assign_op = weights_root_notes_out.assign(weights_root_notes_out_true)
    biases_root_notes_hidden_1_assign_op = biases_root_notes_hidden_1.assign(biases_root_notes_hidden_1_true)
    biases_root_notes_out_assign_op = biases_root_notes_out.assign(biases_root_notes_out_true)

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

def note_to_index(note):
    """
    Returns index of note in global variable notes.

    note: str -> int
    """
    return(notes.index(note))

def type_to_index(chord_type):
    """
    Returns index of chord_type in global variable chord_types.

    chord_type: str -> int
    """
    return(chord_types.index(chord_type))

def index_to_note(index):
    """
    Returns note at index in global variable notes.

    index: int -> str
    """
    return(notes[index])

def index_to_type(index):
    """
    Returns chord_type at index in global variable chord_types.

    index: int -> str
    """
    return(chord_types[index])

def possible_chord_roots(chord_type, root_note):
    """
    Returns a list of all possible chord roots of a chord with properties
    chord_type and root_note, represented as indices in global variables notes
    and chord_types.

    chord_type: int, root_note: int -> List[int]
    """
    chord_roots = [root_note]
    if chord_type == 0:  # major chord
        chord_roots.extend([(root_note + 4) % 12, (root_note + 7) % 12])  # root position
        chord_roots.extend([(root_note + 3) % 12, (root_note + 8) % 12])  # first inversion
        chord_roots.extend([(root_note + 5) % 12, (root_note + 9) % 12])  # second inversion
        return(chord_roots)
    if chord_type == 1:  # minor chord
        chord_roots.extend([(root_note + 3) % 12, (root_note + 7) % 12])  # root position
        chord_roots.extend([(root_note + 4) % 12, (root_note + 9) % 12])  # first inversion
        chord_roots.extend([(root_note + 5) % 12, (root_note + 8) % 12])  # second inversion
        return(chord_roots)
    if chord_type == 2:  # dominant seventh chord
        chord_roots.extend([(root_note + 4) % 12, (root_note + 7) % 12, (root_note + 10) % 12])  # root position
        chord_roots.extend([(root_note + 3) % 12, (root_note + 6) % 12, (root_note + 8) % 12])  # first inversion
        chord_roots.extend([(root_note + 3) % 12, (root_note + 5) % 12, (root_note + 9) % 12])  # second inversion
        chord_roots.extend([(root_note + 2) % 12, (root_note + 6) % 12, (root_note + 9) % 12])  # third inversion
        return(chord_roots)

def possible_chord_types(chord_root, root_note):
    """
    Returns a list of all possible chord types of a chord with properties
    chord_root and root_note, represented as indices in global variable notes.

    chord_root: int, root_note: int -> List[int]
    """
    semitone_difference = abs(chord_root - root_note)
    if semitone_difference > 6:
        semitone_difference = 12 - semitone_difference
    if semitone_difference == 0:
        return([0, 1, 2])
    if semitone_difference == 1:
        return([])  # minor second not a possible interval between chord root and any chord note, regardless of chord type
    if semitone_difference == 2:
        return([2])
    if semitone_difference == 3:
        return([1])
    if semitone_difference == 4:
        return([0, 2])
    if semitone_difference == 5:
        return([0, 1, 2])
    if semitone_difference == 6:
        return([])  # tritone not a possible interval between chord root and any chord note, regardless of chord type

def possible_root_notes(chord_root, chord_type):
    """
    Returns a list of all possible root notes of a chord with properties
    chord_root and chord_type, represented as indices in global variables notes
    and chord_types.

    chord_root: int, chord_type: int -> List[int]
    """
    if chord_type == 0:  # major chord
        return([chord_root, (chord_root + 4) % 12, (chord_root + 7) % 12])
    if chord_type == 1:  # minor chord
        return([chord_root, (chord_root + 3) % 12, (chord_root + 7) % 12])
    if chord_type == 2:  # dominant seventh chord
        return([chord_root, (chord_root + 4) % 12, (chord_root + 7) % 12, (chord_root + 10) % 12])

def is_possible_chord(chord_root, chord_type, root_note):
    """
    Checks if the chord with the given properties is a possible chord.

    chord_root: int, chord_type: int, root_note: int -> bool
    """
    chord_roots_possible = possible_chord_roots(chord_type, root_note)
    chord_types_possible = possible_chord_types(chord_root, root_note)
    root_notes_possible = possible_root_notes(chord_root, chord_type)
    if (chord_root in chord_roots_possible) and (chord_type in chord_types_possible) and (root_note in root_notes_possible):
        return True
    return False

def crop_image(image):
    """
    Gets pixels in first non-white column, removing white pixels at the top
    and bottom.

    image: Array[][][int] -> List[][int]

    Array refers to either a Python list or a numpy array.
    """
    return(image[34:251, 55, 0:])

def mode(list_):
    """
    Returns the mode of list_. If multimodal, returns the mode lowest in value.

    list_: List[int] -> int
    """
    return(max(set(list_), key=list_.count))

def error(list_, correct):
    """
    Returns the error (incorrect predictions divided by the total number of
    predictions).

    list_: List[int], correct: int -> float
    """
    return(1 - list_.count(correct)/len(list_))

def rank_lowest_confidence_notes(list_lists):
    """
    Ranks the lowest confidence of note predictions given the probabilities in
    list_lists. Returns a tuple containing the ranked list (highest first) and
    the lowest probabilities of each note in list_lists.

    list_lists: Array[][float] -> Tuple(ndarray[str], ndarray[float])

    Array refers to either a Python list or a numpy array.
    """
    min_confidence = np.amin(list_lists, axis=0)
    return(np.vectorize(index_to_note)(np.argsort(min_confidence)[::-1]), np.sort(min_confidence)[::-1])

def rank_lowest_confidence_types(list_lists):
    """
    Ranks the lowest confidence of type predictions given the probabilities in
    list_lists. Returns a tuple containing the ranked list (highest first) and
    the lowest probabilities of each type in list_lists.

    list_lists: Array[][float] -> Tuple(ndarray[str], ndarray[float])

    Array refers to either a Python list or a numpy array.
    """
    min_confidence = np.amin(list_lists, axis=0)
    return(np.vectorize(index_to_type)(np.argsort(min_confidence)[::-1]), np.sort(min_confidence)[::-1])

def lowest_confidence(list_lists):
    """
    Returns the lowest confidence of predictions in list_lists. Unlike
    rank_lowest_confidence(), does not attempt to sort the resulting list, but
    instead retains the same order as the elements of list_lists.

    list_lists: Array[][float] -> ndarray[float]

    Array refers to either a Python list or a numpy array.
    """
    return(np.amin(list_lists, axis=0))

def generate_label(num_labels, correct_label):
    """
    Returns a one-hot label.

    num_labels: int, correct_label: int -> List[int]
    """
    label = [0]*num_labels
    label[correct_label] = 1
    return(label)

def is_empty_space(list_):
    """
    Checks if list_ data is empty space.

    list_: List[float] -> bool
    """
    return(list_[0] == 1)

def is_background_noise(list_):
    """
    Checks if list_ data is background noise.

    list_: List[float] -> bool
    """
    for i in range(int(len(list_)/3)):
        if (list_[3*i] != 68/255) or (list_[3*i + 1] != 1/255) or (list_[3*i + 2] != 84/255):  # rgb color of background noise is (68, 1, 84)
            return False
    return True

def most_likely_chord_probability(chord_root_probabilities, chord_type_probabilities, root_note_probabilities):
    """
    Returns a tuple with the most likely POSSIBLE chord root, chord type, and
    root note, represented as indices in global variables notes and
    chord_types, given lists of probabilities.

    chord_root_probabilities: Array[float],
    chord_type_probabilities: Array[float],
    root_note_probabilities: Array[float] -> Tuple(int, int, int)

    Array refers to either a Python list or a numpy array.
    """
    chord_properties = list(product(list(range(12)), list(range(NUM_CHORD_TYPES)), list(range(12))))
    chord_probabilities = [np.prod(i) for i in product(chord_root_probabilities, chord_type_probabilities, root_note_probabilities)]

    # rank chords based on probability
    chord_properties_sorted = [properties for probability, properties in sorted(zip(chord_probabilities, chord_properties), reverse=True)]
    chord_probabilities_sorted = sorted(chord_probabilities, reverse=True)

    for i in range(len(chord_probabilities_sorted)):
        chord_root_predicted = chord_properties_sorted[i][0]
        chord_type_predicted = chord_properties_sorted[i][1]
        root_note_predicted = chord_properties_sorted[i][2]

        # return properties if chord is possible
        if is_possible_chord(chord_root_predicted, chord_type_predicted, root_note_predicted):
            return(chord_root_predicted, chord_type_predicted, root_note_predicted)

def most_likely_chord_mode(chord_root_predictions, chord_type_predictions, root_note_predictions):
    """
    Returns a tuple with the most frequent POSSIBLE chord root, chord type, and
    root note, represented as indices in global variables notes and
    chord_types, given lists of predictions.

    chord_root_predictions: Array[int],
    chord_root_predictions: Array[int],
    root_note_predictions: Array[int] -> Tuple(int, int, int)

    Array refers to either a Python list or a numpy array.
    """
    chord_properties_predictions = list(product(chord_root_predictions, chord_type_predictions, root_note_predictions))

    while True:
        # no predicted chord is possible
        if chord_properties_predictions == []:
            raise ValueError("No possible chord found")

        chord_properties_predicted = mode(chord_properties_predictions)
        chord_root_predicted = chord_properties_predicted[0]
        chord_type_predicted = chord_properties_predicted[1]
        root_note_predicted = chord_properties_predicted[2]

        # return properties if chord is possible
        if is_possible_chord(chord_root_predicted, chord_type_predicted, root_note_predicted):
            return(chord_root_predicted, chord_type_predicted, root_note_predicted)

        # if not possible, remove all instances of mode from list and loop
        chord_properties_predictions = [properties for properties in chord_properties_predictions if properties != chord_properties_predicted]

def spectrogram_to_chord_train(file):
    """
    Reads data from a wav file and returns a string containing the predicted
    chord root, chord type, and root note of the chord being played in the
    file. Use for additional training.

    file: str -> None
    """
    init_train()  # reload parameters

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
    print("All predictions:", np.vectorize(index_to_note)(predicted_chord_roots))
    print("Confidence rank: ", rank_chord_roots)
    print("Lowest probabilities:", probabilities_chord_roots)

    print("\nChord type:")
    print("All predictions:", np.vectorize(index_to_type)(predicted_chord_types))
    print("Confidence rank: ", rank_chord_types)
    print("Lowest probabilities:", probabilities_chord_types)

    print("\nRoot note:")
    print("All predictions:", np.vectorize(index_to_note)(predicted_root_notes))
    print("Confidence rank: ", rank_root_notes)
    print("Lowest probabilities:", probabilities_root_notes)

    chord_properties_prediction = most_likely_chord_probability(lowest_confidence(out_chord_roots_probabilities), lowest_confidence(out_chord_types_probabilities), lowest_confidence(out_root_notes_probabilities))
    chord_root_prediction = index_to_note(chord_properties_prediction[0])
    chord_type_prediction = index_to_type(chord_properties_prediction[1])
    root_note_prediction = index_to_note(chord_properties_prediction[2])

    print("\nChord prediction:", chord_root_prediction + chord_type_prediction + "/" + root_note_prediction)

    # user determines whether to train
    if input("\nTrain chord root? (y/n): ") == "y":
        chord_root_label = input("Index of correct chord root in confidence rank (c to cancel): ")
        if chord_root_label != "c":
            chord_root_label = note_to_index(rank_chord_roots[int(chord_root_label)])
            chord_root_labels = np.array([generate_label(12, int(chord_root_label))]*len(predicted_chord_roots))
            sess.run(train_chord_roots_op, feed_dict={data: array_image_data_all, labels_chord_roots: chord_root_labels})
            saver_chord_roots.save(sess, "model/chord_roots/chord_roots_model", write_meta_graph=False)
            print("\nChord root trained!")

    if input("\nTrain chord type? (y/n): ") == "y":
        chord_type_label = input("Index of correct chord type in confidence rank (c to cancel): ")
        if chord_type_label != "c":
            chord_type_label = type_to_index(rank_chord_types[int(chord_type_label)])
            chord_type_labels = np.array([generate_label(NUM_CHORD_TYPES, int(chord_type_label))]*len(predicted_chord_types))
            sess.run(train_chord_types_op, feed_dict={data: array_image_data_all, labels_chord_types: chord_type_labels})
            saver_chord_types.save(sess, "model/chord_types/chord_types_model", write_meta_graph=False)
            print("\nChord type trained!")

    if input("\nTrain root note? (y/n): ") == "y":
        root_note_label = input("Index of correct root note in confidence rank (c to cancel): ")
        if root_note_label != "c":
            root_note_label = note_to_index(rank_root_notes[int(root_note_label)])
            root_note_labels = np.array([generate_label(12, int(root_note_label))]*len(predicted_root_notes))
            sess.run(train_root_notes_op, feed_dict={data: array_image_data_all, labels_root_notes: root_note_labels})
            saver_root_notes.save(sess, "model/root_notes/root_notes_model", write_meta_graph=False)
            print("\nRoot note trained!")

    print("\n")
    sess.close()

def init_predict():
    """
    Updates variables from Tensorflow checkpoints. Builds graphs for
    predictions and training, giving them global scope.

    THIS FUNCTION MUST ONLY BE EXECUTED ONCE WHEN THE SCRIPT IS RUN.
    """
    load_global_vars()
    chord_prediction = ""  # variable to change when making chord predictions using spectrogram_to_chord()

    load_variables_chord_roots()
    load_variables_chord_types()
    load_variables_root_notes()

    # build predictions graph
    data_predict = tf.placeholder(tf.float32, shape=[None, LEN_DATA])

    layer_chord_roots_1_predict = tf.nn.relu(tf.add(tf.matmul(data_predict, weights_chord_roots_hidden_1_true), biases_chord_roots_hidden_1_true))
    layer_chord_roots_2_predict = tf.nn.relu(tf.add(tf.matmul(layer_chord_roots_1_predict, weights_chord_roots_hidden_2_true), biases_chord_roots_hidden_2_true))
    out_chord_roots_predict = tf.add(tf.matmul(layer_chord_roots_2_predict, weights_chord_roots_out_true), biases_chord_roots_out_true)
    out_chord_roots_softmax_predict = tf.nn.softmax(out_chord_roots_predict)
    predict_chord_roots_op = tf.argmax(out_chord_roots_predict, axis=1)

    layer_chord_types_1_predict = tf.nn.relu(tf.add(tf.matmul(data_predict, weights_chord_types_hidden_1_true), biases_chord_types_hidden_1_true))
    layer_chord_types_2_predict = tf.nn.relu(tf.add(tf.matmul(layer_chord_types_1_predict, weights_chord_types_hidden_2_true), biases_chord_types_hidden_2_true))
    out_chord_types_predict = tf.add(tf.matmul(layer_chord_types_2_predict, weights_chord_types_out_true), biases_chord_types_out_true)
    out_chord_types_softmax_predict = tf.nn.softmax(out_chord_types_predict)
    predict_chord_types_op = tf.argmax(out_chord_types_predict, axis=1)

    layer_root_notes_1_predict = tf.nn.relu(tf.add(tf.matmul(data_predict, weights_root_notes_hidden_1_true), biases_root_notes_hidden_1_true))
    out_root_notes_predict = tf.add(tf.matmul(layer_root_notes_1_predict, weights_root_notes_out_true), biases_root_notes_out_true)
    out_root_notes_softmax_predict = tf.nn.softmax(out_root_notes_predict)
    predict_root_notes_op = tf.argmax(out_root_notes_predict, axis=1)

    globals().update(locals())

def spectrogram_to_chord(spectrogram):
    """
    Reads spectrogram data and returns a string containing the predicted
    chord root, chord type, and root note of the spectrogram.

    spectrogram: ndarray[][float] -> None
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

    global chord_prediction

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
        chord_prediction = ""
        return
    """

    chord_root_prediction = index_to_note(chord_properties_prediction[0])
    chord_type_prediction = index_to_type(chord_properties_prediction[1])
    root_note_prediction = index_to_note(chord_properties_prediction[2])

    chord_prediction = chord_root_prediction + chord_type_prediction + "/" + root_note_prediction
