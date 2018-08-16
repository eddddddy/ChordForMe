import numpy as np
import tensorflow as tf
import get_data

train_data = get_data.train_data
train_root_notes = get_data.train_root_notes
test_data = get_data.test_data
test_root_notes = get_data.test_root_notes

LEN_DATA = get_data.len_data
NUM_HIDDEN_ROOT_NOTES_1 = 2048
BATCH_SIZE = 1000
LEARNING_RATE = 0.001
KEEP_PROB = 0.5

tf.reset_default_graph()

weights_root_notes_hidden_1 = tf.Variable(tf.random_normal([get_data.len_data, NUM_HIDDEN_ROOT_NOTES_1], stddev=1/np.sqrt(LEN_DATA)), name="weights_root_notes_hidden_1")
weights_root_notes_out = tf.Variable(tf.random_normal([NUM_HIDDEN_ROOT_NOTES_1, 12], stddev=1/np.sqrt(NUM_HIDDEN_ROOT_NOTES_1)), name="weights_root_notes_out")
biases_root_notes_hidden_1 = tf.Variable(tf.zeros(NUM_HIDDEN_ROOT_NOTES_1), name="biases_root_notes_hidden_1")
biases_root_notes_out = tf.Variable(tf.zeros(12), name="biases_root_notes_out")

saver = tf.train.Saver(max_to_keep=1)
sess = tf.InteractiveSession()


try:
    saver.restore(sess, "model/root_notes/root_notes_model")

    weights_root_notes_hidden_1 = tf.get_variable("weights_root_notes_hidden_1", shape=[LEN_DATA, NUM_HIDDEN_ROOT_NOTES_1], dtype=tf.float32, initializer=tf.random_normal_initializer(stddev=1/np.sqrt(LEN_DATA)))
    weights_root_notes_out = tf.get_variable("weights_root_notes_out", shape=[NUM_HIDDEN_ROOT_NOTES_1, 12], dtype=tf.float32, initializer=tf.random_normal_initializer(stddev=1/np.sqrt(NUM_HIDDEN_ROOT_NOTES_1)))
    biases_root_notes_hidden_1 = tf.get_variable("biases_root_notes_hidden_1", shape=[NUM_HIDDEN_ROOT_NOTES_1], dtype=tf.float32, initializer=tf.zeros_initializer())
    biases_root_notes_out = tf.get_variable("biases_root_notes_out", shape=[12], dtype=tf.float32, initializer=tf.zeros_initializer())

except:
    sess.run(tf.global_variables_initializer())


data = tf.placeholder(tf.float32, shape=[None, get_data.len_data])
labels_root_notes = tf.placeholder(tf.float32, shape=[None, 12])
keep_prob = tf.placeholder(tf.float32)

layer_root_notes_1 = tf.nn.relu(tf.matmul(data, weights_root_notes_hidden_1) + biases_root_notes_hidden_1)
layer_dropout_root_notes_1 = tf.nn.dropout(layer_root_notes_1, keep_prob)
out_root_notes = tf.matmul(layer_dropout_root_notes_1, weights_root_notes_out) + biases_root_notes_out

predict_root_notes_op = tf.argmax(tf.nn.softmax(out_root_notes), axis=1)
loss_root_notes = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(logits=out_root_notes, labels=labels_root_notes))
train_root_notes_op = tf.train.GradientDescentOptimizer(learning_rate=LEARNING_RATE).minimize(loss_root_notes)

correct_root_notes = tf.equal(predict_root_notes_op, tf.argmax(test_root_notes, 1))
accuracy_root_notes = tf.reduce_mean(tf.cast(correct_root_notes, tf.float32))

counter = 0
while True:
    batch_data, batch_labels_root_notes = get_data.next_batch(BATCH_SIZE, train_data, train_root_notes)
    sess.run(train_root_notes_op, feed_dict={data: batch_data, keep_prob: KEEP_PROB, labels_root_notes: batch_labels_root_notes})
    if counter % 10000 == 0:
        saver.save(sess, "model/root_notes/root_notes_model", write_meta_graph=False)
        total_accuracy_root_notes = sess.run(accuracy_root_notes, feed_dict={data: test_data, keep_prob: 1, labels_root_notes: test_root_notes})
        print("Training step:", counter)
        print("Evaluation accuracy:", str(round(100*total_accuracy_root_notes, 1)) + "%\n")
        if total_accuracy_root_notes > 0.95:
            break
    counter += 1

saver.save(sess, "model/root_notes/root_notes_model", write_meta_graph=False)
sess.close()
