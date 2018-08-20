import numpy as np
import tensorflow as tf
import get_data

import tflearn
from tflearn.layers.core import input_data, fully_connected, activation
from tflearn.layers.normalization import batch_normalization
from tflearn.layers.estimator import regression
from tflearn.models.dnn import DNN

train_data = get_data.train_data
train_chord_roots = get_data.train_chord_roots
test_data = get_data.test_data
test_chord_roots = get_data.test_chord_roots

LEN_DATA = get_data.len_data
NUM_HIDDEN_CHORD_ROOTS_1 = 1024
NUM_HIDDEN_CHORD_ROOTS_2 = 1024
BATCH_SIZE = 1000
LEARNING_RATE = 0.001
KEEP_PROB = 0.5

# tf.reset_default_graph()
# saver = tf.train.Saver(max_to_keep = 1)
# sess = tf.InteractiveSession()

network = input_data(shape = [None, LEN_DATA])
network = fully_connected(network, NUM_HIDDEN_CHORD_ROOTS_1, regularizer = 'L2')
network = batch_normalization(network)
network = activation(network, activation = 'relu')
network = fully_connected(network, NUM_HIDDEN_CHORD_ROOTS_2, regularizer = 'L2')
network = batch_normalization(network)
network = activation(network, activation = 'relu')
network = fully_connected(network, 12, activation = 'softmax', regularizer = 'L2')
network = regression(network, learning_rate = LEARNING_RATE)

# data = tf.placeholder(tf.float32, shape = [None, LEN_DATA])
# labels = tf.placeholder(tf.float32, shape = [None, 12])

# loss = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(logits = network, labels = labels))
# optimizer = tf.train.AdamOptimizer(learning_rate = LEARNING_RATE)
# accuracy = tf.reduce_mean(
           # tf.cast(tf.equal(tf.argmax(network, 1), tf.argmax(labels, 1)), tf.float32))

# try:
    # saver.restore(sess, "model/chord_roots/chord_roots_model")
# except:
    # sess.run(tf.global_variables_initializer())

# train_op = tflearn.TrainOp(loss, optimizer, metric = accuracy, batch_size = BATCH_SIZE, shuffle = True)
# trainer = tflearn.Trainer(train_op, best_checkpoint_path = 'model/chord_roots/chord_roots_model', max_checkpoints = 1,  session = sess)

# trainer.fit({data: train_data, labels: train_chord_roots}, n_epoch = 100, 
            # val_feed_dicts = {data: test_data, labels: test_chord_roots}, show_metric = True, snapshot_step = 200,
			# shuffle_all = True)

model = DNN(network, best_checkpoint_path = 'model/chord_roots/chord_roots_model', max_checkpoints = 1)
model.fit(train_data, train_chord_roots, n_epoch = 100, validation_set = (test_data, test_chord_roots),
          show_metric = True, batch_size = BATCH_SIZE, shuffle = True, snapshot_step = 200)


	