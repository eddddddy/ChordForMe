import numpy as np
import tensorflow as tf
import get_data

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

tf.reset_default_graph()

weights_chord_roots_hidden_1 = tf.Variable(tf.random_normal([LEN_DATA, NUM_HIDDEN_CHORD_ROOTS_1], stddev=1/np.sqrt(LEN_DATA)), name="weights_chord_roots_hidden_1")
weights_chord_roots_hidden_2 = tf.Variable(tf.random_normal([NUM_HIDDEN_CHORD_ROOTS_1, NUM_HIDDEN_CHORD_ROOTS_2], stddev=1/np.sqrt(NUM_HIDDEN_CHORD_ROOTS_1)), name="weights_chord_roots_hidden_2")
weights_chord_roots_out = tf.Variable(tf.random_normal([NUM_HIDDEN_CHORD_ROOTS_2, 12], stddev=1/np.sqrt(NUM_HIDDEN_CHORD_ROOTS_2)), name="weights_chord_roots_out")
biases_chord_roots_hidden_1 = tf.Variable(tf.zeros(NUM_HIDDEN_CHORD_ROOTS_1), name="biases_chord_roots_hidden_1")
biases_chord_roots_hidden_2 = tf.Variable(tf.zeros(NUM_HIDDEN_CHORD_ROOTS_2), name="biases_chord_roots_hidden_2")
biases_chord_roots_out = tf.Variable(tf.zeros(12), name="biases_chord_roots_out")

saver = tf.train.Saver(max_to_keep=1)
sess = tf.InteractiveSession()


try:
    saver.restore(sess, "model/chord_roots/chord_roots_model")

    weights_chord_roots_hidden_1 = tf.get_variable("weights_chord_roots_hidden_1", shape=[LEN_DATA, NUM_HIDDEN_CHORD_ROOTS_1], dtype=tf.float32, initializer=tf.random_normal_initializer(stddev=1/np.sqrt(LEN_DATA)))
    weights_chord_roots_hidden_2 = tf.get_variable("weights_chord_roots_hidden_2", shape=[NUM_HIDDEN_CHORD_ROOTS_1, NUM_HIDDEN_CHORD_ROOTS_2], dtype=tf.float32, initializer=tf.random_normal_initializer(stddev=1/np.sqrt(NUM_HIDDEN_CHORD_ROOTS_1)))
    weights_chord_roots_out = tf.get_variable("weights_chord_roots_out", shape=[NUM_HIDDEN_CHORD_ROOTS_2, 12], dtype=tf.float32, initializer=tf.random_normal_initializer(stddev=1/np.sqrt(NUM_HIDDEN_CHORD_ROOTS_2)))
    biases_chord_roots_hidden_1 = tf.get_variable("biases_chord_roots_hidden_1", shape=[NUM_HIDDEN_CHORD_ROOTS_1], dtype=tf.float32, initializer=tf.zeros_initializer())
    biases_chord_roots_hidden_2 = tf.get_variable("biases_chord_roots_hidden_2", shape=[NUM_HIDDEN_CHORD_ROOTS_2], dtype=tf.float32, initializer=tf.zeros_initializer())
    biases_chord_roots_out = tf.get_variable("biases_chord_roots_out", shape=[12], dtype=tf.float32, initializer=tf.zeros_initializer())

except:
    sess.run(tf.global_variables_initializer())


data = tf.placeholder(tf.float32, shape=[None, LEN_DATA])
labels_chord_roots = tf.placeholder(tf.float32, shape=[None, 12])
keep_prob = tf.placeholder(tf.float32)

layer_chord_roots_1 = tf.nn.relu(tf.matmul(data, weights_chord_roots_hidden_1) + biases_chord_roots_hidden_1)
layer_dropout_chord_roots_1 = tf.nn.dropout(layer_chord_roots_1, keep_prob)
layer_chord_roots_2 = tf.nn.relu(tf.matmul(layer_dropout_chord_roots_1, weights_chord_roots_hidden_2) + biases_chord_roots_hidden_2)
layer_dropout_chord_roots_2 = tf.nn.dropout(layer_chord_roots_2, keep_prob)
out_chord_roots = tf.matmul(layer_dropout_chord_roots_2, weights_chord_roots_out) + biases_chord_roots_out

predict_chord_roots_op = tf.argmax(tf.nn.softmax(out_chord_roots), axis=1)
loss_chord_roots = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(logits=out_chord_roots, labels=labels_chord_roots))
train_chord_roots_op = tf.train.GradientDescentOptimizer(learning_rate=LEARNING_RATE).minimize(loss_chord_roots)

correct_chord_roots = tf.equal(predict_chord_roots_op, tf.argmax(test_chord_roots, 1))
accuracy_chord_roots = tf.reduce_mean(tf.cast(correct_chord_roots, tf.float32))

counter = 0
while True:
    batch_data, batch_labels_chord_roots = get_data.next_batch(BATCH_SIZE, train_data, train_chord_roots)
    sess.run(train_chord_roots_op, feed_dict={data: batch_data, keep_prob: KEEP_PROB, labels_chord_roots: batch_labels_chord_roots})
    if counter % 100 == 0:
        saver.save(sess, "model/chord_roots/chord_roots_model", write_meta_graph=False)
        total_accuracy_chord_roots = sess.run(accuracy_chord_roots, feed_dict={data: test_data, keep_prob: 1, labels_chord_roots: test_chord_roots})
        print("Training step:", counter)
        print("Evaluation accuracy:", str(round(100*total_accuracy_chord_roots, 1)) + "%\n")
        if total_accuracy_chord_roots > 0.95:
            break
    counter += 1

saver.save(sess, "model/chord_roots/chord_roots_model", write_meta_graph=False)
sess.close()
