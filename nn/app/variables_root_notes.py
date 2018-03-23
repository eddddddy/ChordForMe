"""
Retrieves values of variables trained by the root notes neural network, stored
in Tensorflow checkpoint files.
"""

import numpy as np
import tensorflow as tf

LEN_DATA = 217*3
NUM_HIDDEN_ROOT_NOTES_1 = 2048

tf.reset_default_graph()  # necessary to avoid an error that occurs when importing multiple times

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

sess = tf.Session()
saver = tf.train.Saver()
saver.restore(sess, "model/root_notes/root_notes_model")

# create variables that can be used in other scripts
weights_root_notes_hidden_1_true = sess.run(weights_root_notes_hidden_1)
weights_root_notes_out_true = sess.run(weights_root_notes_out)
biases_root_notes_hidden_1_true = sess.run(biases_root_notes_hidden_1)
biases_root_notes_out_true = sess.run(biases_root_notes_out)

sess.close()
