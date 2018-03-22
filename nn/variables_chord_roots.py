"""
Retrieves values of variables trained by the chord roots neural network,
stored in Tensorflow checkpoint files.
"""

import numpy as np
import tensorflow as tf

LEN_DATA = 217*3
NUM_HIDDEN_CHORD_ROOTS_1 = 1024
NUM_HIDDEN_CHORD_ROOTS_2 = 1024

tf.reset_default_graph()  # necessary to avoid an error that occurs when importing multiple times

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

sess = tf.Session()
saver = tf.train.Saver()
saver.restore(sess, "model/chord_roots/chord_roots_model")

# create variables that can be used in other scripts
weights_chord_roots_hidden_1 = sess.run(weights_chord_roots_hidden_1)
weights_chord_roots_hidden_2 = sess.run(weights_chord_roots_hidden_2)
weights_chord_roots_out = sess.run(weights_chord_roots_out)
biases_chord_roots_hidden_1 = sess.run(biases_chord_roots_hidden_1)
biases_chord_roots_hidden_2 = sess.run(biases_chord_roots_hidden_2)
biases_chord_roots_out = sess.run(biases_chord_roots_out)

sess.close()
