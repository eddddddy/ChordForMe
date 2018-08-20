import numpy as np
import tensorflow as tf
import translate
import get_data

import tflearn
from tflearn.layers.core import input_data, fully_connected
from tflearn.layers.estimator import regression
from tflearn.models.dnn import DNN

train_data = get_data.train_data
train_chord_types = get_data.train_chord_types
test_data = get_data.test_data
test_chord_types = get_data.test_chord_types

tf.reset_default_graph()
LEN_DATA = get_data.len_data
NUM_HIDDEN_LAYERS = 3
NUM_HIDDEN_UNITS = 2048
LEARNING_RATE = 0.0001
BATCH_SIZE = 1000

network = input_data(shape = [None, LEN_DATA])
for i in range(NUM_HIDDEN_LAYERS):
	network = fully_connected(network, NUM_HIDDEN_UNITS, activation = 'relu')
network = fully_connected(network, translate.NUM_CHORD_TYPES, activation = 'softmax')
network = regression(network, learning_rate = LEARNING_RATE)

model = DNN(network, best_checkpoint_path = 'model/chord_types/model.tflearn', max_checkpoints = 1)
# model.load('model/chord_types/model.tflearn9626')
model.fit(train_data, train_chord_types, n_epoch = 100000, validation_set = (test_data, test_chord_types),
          show_metric = True, batch_size = BATCH_SIZE, shuffle = True)

