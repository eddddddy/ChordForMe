import numpy as np
import tensorflow as tf
import get_data

train_data = get_data.train_data
train_chord_roots = get_data.train_chord_roots
test_data = get_data.test_data
test_chord_roots = get_data.test_chord_roots

#hyper-parameters
learning_rate = 0.0001
num_training_steps = 10000
num_hidden_1 = 1024
batch_size = 1000

#network architecture
data = tf.placeholder(tf.float32, shape=[None, get_data.len_data])
keep_prob = tf.placeholder(tf.float32)
labels_chord_roots = tf.placeholder(tf.float32, shape=[None, 12])
weights_chord_roots_hidden_1 =  tf.Variable(tf.random_normal([get_data.len_data, num_hidden_1], stddev=1/np.sqrt(get_data.len_data)))
weights_chord_roots_out = tf.Variable(tf.random_normal([num_hidden_1, 12], stddev=1/np.sqrt(num_hidden_1)))
biases_chord_roots_hidden_1 = tf.Variable(tf.zeros(num_hidden_1))
biases_chord_roots_out = tf.Variable(tf.zeros(12))
layer_chord_roots_1 = tf.nn.relu(tf.matmul(data, weights_chord_roots_hidden_1) + biases_chord_roots_hidden_1)
layer_dropout_chord_roots_1 = tf.nn.dropout(layer_chord_roots_1, keep_prob)
out_chord_roots = tf.matmul(layer_dropout_chord_roots_1, weights_chord_roots_out) + biases_chord_roots_out
predict_chord_roots_op = tf.nn.softmax(out_chord_roots)
loss_chord_roots = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(logits=out_chord_roots, labels=labels_chord_roots))
train_chord_roots_op = tf.train.AdamOptimizer(learning_rate).minimize(loss_chord_roots)

#train
init_ = tf.global_variables_initializer()
sess = tf.InteractiveSession()
sess.run(init_)
for i in range(num_training_steps):
	batch_data, batch_labels_chord_roots = get_data.next_batch(batch_size, train_data, train_chord_roots)
	sess.run(train_chord_roots_op, feed_dict={data: batch_data, keep_prob: 0.6, labels_chord_roots: batch_labels_chord_roots})

#get values
weights_list_chord_roots_hidden_1 = sess.run(weights_chord_roots_hidden_1)
biases_list_chord_roots_hidden_1 = sess.run(biases_chord_roots_hidden_1)
weights_list_chord_roots_out = sess.run(weights_chord_roots_out)
biases_list_chord_roots_out = sess.run(biases_chord_roots_out)

#test
correct_chord_roots = tf.equal(tf.argmax(predict_chord_roots_op, 1), tf.argmax(test_chord_roots, 1))
accuracy_chord_roots = tf.reduce_mean(tf.cast(correct_chord_roots, tf.float32))
total_accuracy_chord_roots = sess.run(accuracy_chord_roots, feed_dict={data: test_data, keep_prob: 1, labels_chord_roots: test_chord_roots})
print("Evaluation accuracy: ", str(round(100*total_accuracy_chord_roots, 1)) + "%")
