import numpy as np
import tensorflow as tf
import translate
import get_data

train_data = get_data.train_data
train_chord_types = get_data.train_chord_types
test_data = get_data.test_data
test_chord_types = get_data.test_chord_types

#hyper-parameters
num_training_steps = 10000
num_hidden_1 = 100
num_hidden_2 = 100
num_hidden_3 = 100
num_hidden_4 = 100
batch_size = 1000
learning_rate = 0.0001
beta_1 = 0.9
beta_2 = 0.999
epsilon = 1e-8

#network architecture
data = tf.placeholder(tf.float32, shape=[None, get_data.len_data])
labels_chord_types = tf.placeholder(tf.float32, shape=[None, translate.num_chord_types])
keep_prob = tf.placeholder(tf.float32)
weights_chord_types_hidden_1 =  tf.Variable(tf.random_normal([get_data.len_data, num_hidden_1], stddev=1/np.sqrt(get_data.len_data)))
weights_chord_types_hidden_2 =  tf.Variable(tf.random_normal([num_hidden_1, num_hidden_2], stddev=1/np.sqrt(num_hidden_1)))
weights_chord_types_hidden_3 =  tf.Variable(tf.random_normal([num_hidden_2, num_hidden_3], stddev=1/np.sqrt(num_hidden_2)))
weights_chord_types_hidden_4 =  tf.Variable(tf.random_normal([num_hidden_3, num_hidden_4], stddev=1/np.sqrt(num_hidden_3)))
weights_chord_types_out = tf.Variable(tf.random_normal([num_hidden_4, translate.num_chord_types], stddev=1/np.sqrt(num_hidden_4)))
biases_chord_types_hidden_1 = tf.Variable(tf.zeros(num_hidden_1))
biases_chord_types_hidden_2 = tf.Variable(tf.zeros(num_hidden_2))
biases_chord_types_hidden_3 = tf.Variable(tf.zeros(num_hidden_3))
biases_chord_types_hidden_4 = tf.Variable(tf.zeros(num_hidden_4))
biases_chord_types_out = tf.Variable(tf.zeros(translate.num_chord_types))
layer_chord_types_1 = tf.nn.relu(tf.matmul(data, weights_chord_types_hidden_1) + biases_chord_types_hidden_1)
layer_dropout_chord_types_1 = tf.nn.dropout(layer_chord_types_1, keep_prob)
layer_chord_types_2 = tf.nn.relu(tf.matmul(layer_dropout_chord_types_1, weights_chord_types_hidden_2) + biases_chord_types_hidden_2)
layer_dropout_chord_types_2 = tf.nn.dropout(layer_chord_types_2, keep_prob)
layer_chord_types_3 = tf.nn.relu(tf.matmul(layer_dropout_chord_types_2, weights_chord_types_hidden_3) + biases_chord_types_hidden_3)
layer_dropout_chord_types_3 = tf.nn.dropout(layer_chord_types_3, keep_prob)
layer_chord_types_4 = tf.nn.relu(tf.matmul(layer_dropout_chord_types_3, weights_chord_types_hidden_4) + biases_chord_types_hidden_4)
layer_dropout_chord_types_4 = tf.nn.dropout(layer_chord_types_4, keep_prob)
out_chord_types = tf.matmul(layer_dropout_chord_types_4, weights_chord_types_out) + biases_chord_types_out
predict_chord_types_op = tf.nn.softmax(out_chord_types)
loss_chord_types = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(logits=out_chord_types, labels=labels_chord_types))
train_chord_types_op = tf.train.AdamOptimizer(learning_rate=learning_rate, beta1=beta_1, beta2=beta_2, epsilon=epsilon).minimize(loss_chord_types)

#train
init_ = tf.global_variables_initializer()
sess = tf.InteractiveSession()
sess.run(init_)
for i in range(num_training_steps):
    batch_data, batch_labels_chord_types = get_data.next_batch(batch_size, train_data, train_chord_types)
    sess.run(train_chord_types_op, feed_dict={data: batch_data, keep_prob: 0.5, labels_chord_types: batch_labels_chord_types})
    #print(i, np.mean(np.argmax(batch_labels_chord_types, 1) == np.argmax(sess.run(predict_chord_types_op, feed_dict={data: batch_data, keep_prob: 0.5, labels_chord_types: batch_labels_chord_types}), 1)), sess.run(loss_chord_types, feed_dict={data: batch_data, keep_prob: 0.5, labels_chord_types: batch_labels_chord_types}))

#get values
weights_list_chord_types_hidden_1 = sess.run(weights_chord_types_hidden_1)
biases_list_chord_types_hidden_1 = sess.run(biases_chord_types_hidden_1)
weights_list_chord_types_hidden_2 = sess.run(weights_chord_types_hidden_2)
biases_list_chord_types_hidden_2 = sess.run(biases_chord_types_hidden_2)
weights_list_chord_types_hidden_3 = sess.run(weights_chord_types_hidden_3)
biases_list_chord_types_hidden_3 = sess.run(biases_chord_types_hidden_3)
weights_list_chord_types_hidden_4 = sess.run(weights_chord_types_hidden_3)
biases_list_chord_types_hidden_4 = sess.run(biases_chord_types_hidden_3)
weights_list_chord_types_out = sess.run(weights_chord_types_out)
biases_list_chord_types_out = sess.run(biases_chord_types_out)

#test
correct_chord_types = tf.equal(tf.argmax(predict_chord_types_op, 1), tf.argmax(test_chord_types, 1))
accuracy_chord_types = tf.reduce_mean(tf.cast(correct_chord_types, tf.float32))
total_accuracy_chord_types = sess.run(accuracy_chord_types, feed_dict={data: test_data, keep_prob: 1, labels_chord_types: test_chord_types})
print("Evaluation accuracy: ", str(round(100*total_accuracy_chord_types, 1)) + "%")
