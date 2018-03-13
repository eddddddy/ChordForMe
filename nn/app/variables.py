import numpy as np
import tensorflow as tf

len_data = 217*3
num_hidden_1 = 1024
num_hidden_2 = 1024

weights_chord_roots_hidden_1 =  tf.Variable(tf.random_normal([len_data, num_hidden_1], stddev=1/np.sqrt(len_data)), name="weights_chord_roots_hidden_1")
weights_chord_roots_hidden_2 =  tf.Variable(tf.random_normal([num_hidden_1, num_hidden_2], stddev=1/np.sqrt(num_hidden_1)), name="weights_chord_roots_hidden_2")
weights_chord_roots_out = tf.Variable(tf.random_normal([num_hidden_2, 12], stddev=1/np.sqrt(num_hidden_2)), name="weights_chord_roots_out")
biases_chord_roots_hidden_1 = tf.Variable(tf.zeros(num_hidden_1), name="biases_chord_roots_hidden_1")
biases_chord_roots_hidden_2 = tf.Variable(tf.zeros(num_hidden_2), name="biases_chord_roots_hidden_2")
biases_chord_roots_out = tf.Variable(tf.zeros(12), name="biases_chord_roots_out")

saver = tf.train.Saver()
sess = tf.Session()
saver.restore(sess, "model\\chord_roots\\chord_roots_model")
#saver.restore(sess, "model\\chord_types\\chord_types_model")
#saver.restore(sess, "model\\root_notes\\root_notes_model")

weights_chord_roots_hidden_1 = sess.run(weights_chord_roots_hidden_1)
biases_chord_roots_hidden_1 = sess.run(biases_chord_roots_hidden_1)
weights_chord_roots_hidden_2 = sess.run(weights_chord_roots_hidden_2)
biases_chord_roots_hidden_2 = sess.run(biases_chord_roots_hidden_2)
weights_chord_roots_out = sess.run(weights_chord_roots_out)
biases_chord_roots_out = sess.run(biases_chord_roots_out)
