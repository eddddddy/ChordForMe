import numpy as np
import tensorflow as tf
import get_data

train_data = get_data.train_data
train_root_notes = get_data.train_root_notes
test_data = get_data.test_data
test_root_notes = get_data.test_root_notes

num_training_steps = 20000
num_hidden_1 = 2048
batch_size = 1000
learning_rate = 0.001
beta_1 = 0.9
beta_2 = 0.999
epsilon = 1e-8

data = tf.placeholder(tf.float32, shape=[None, get_data.len_data])
labels_root_notes = tf.placeholder(tf.float32, shape=[None, 12])
keep_prob = tf.placeholder(tf.float32)
weights_root_notes_hidden_1 =  tf.Variable(tf.random_normal([get_data.len_data, num_hidden_1], stddev=1/np.sqrt(get_data.len_data)), name="weights_root_notes_hidden_1")
weights_root_notes_out = tf.Variable(tf.random_normal([num_hidden_1, 12], stddev=1/np.sqrt(num_hidden_1)), name="weights_root_notes_out")
biases_root_notes_hidden_1 = tf.Variable(tf.zeros(num_hidden_1), name="biases_root_notes_hidden_1")
biases_root_notes_out = tf.Variable(tf.zeros(12), name="biases_root_notes_out")
layer_root_notes_1 = tf.nn.relu(tf.matmul(data, weights_root_notes_hidden_1) + biases_root_notes_hidden_1)
layer_dropout_root_notes_1 = tf.nn.dropout(layer_root_notes_1, keep_prob)
out_root_notes = tf.matmul(layer_dropout_root_notes_1, weights_root_notes_out) + biases_root_notes_out
predict_root_notes_op = tf.argmax(tf.nn.softmax(out_root_notes), axis=1)
loss_root_notes = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(logits=out_root_notes, labels=labels_root_notes))
train_root_notes_op = tf.train.AdamOptimizer(learning_rate=learning_rate, beta1=beta_1, beta2=beta_2, epsilon=epsilon).minimize(loss_root_notes)

saver = tf.train.Saver(max_to_keep=1)
sess = tf.InteractiveSession()
sess.run(tf.global_variables_initializer())
for i in range(num_training_steps):
    batch_data, batch_labels_root_notes = get_data.next_batch(batch_size, train_data, train_root_notes)
    sess.run(train_root_notes_op, feed_dict={data: batch_data, keep_prob: 1, labels_root_notes: batch_labels_root_notes})
saver.save(sess, "tmp\\model\\root_notes_model")

correct_root_notes = tf.equal(predict_root_notes_op, tf.argmax(test_root_notes, 1))
accuracy_root_notes = tf.reduce_mean(tf.cast(correct_root_notes, tf.float32))
total_accuracy_root_notes = sess.run(accuracy_root_notes, feed_dict={data: test_data, keep_prob: 1, labels_root_notes: test_root_notes})
print("Evaluation accuracy: ", str(round(100*total_accuracy_root_notes, 1)) + "%")
