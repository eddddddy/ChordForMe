import numpy as np
import tensorflow as tf
import to_index

def next_batch_chords(batch_size, data, labels_chord_roots, labels_chord_types, labels_root_notes):
    a = np.arange(0, len(data))
    np.random.shuffle(a)
    a = a[:batch_size]
    return(data[a], labels_chord_roots[a], labels_chord_types[a], labels_root_notes[a])

#read and process training data from text files
all_data_list = []
all_chord_roots_list = []
all_chord_types_list = []
all_root_notes_list = []
with open('C:\\Users\\James Jiang\\Documents\\ChordForMe\\app\\src\\main\\res\\raw\\train-in.txt') as f:
    for line in f:
        bytes_str = line.rstrip('\n')[1:-1].split(", ")
        all_data_list.append([int(byte) for byte in bytes_str])
with open('C:\\Users\\James Jiang\\Documents\\ChordForMe\\app\\src\\main\\res\\raw\\train-out.txt') as f:
    for line in f:
        chord_str = line.rstrip('\n')[2:-2].split("\", \"")
        chord_root_hot = [0]*12
        chord_type_hot = [0]*to_index.num_chord_types
        root_note_hot = [0]*12
        if len(chord_str[0]) == 1:
            chord_root = chord_str[0]
            chord_type = ""
        elif chord_str[0][1] == "#":
            chord_root = chord_str[0][:2]
            chord_type = chord_str[0][2:]
        else:
            chord_root = chord_str[0][0]
            chord_type = chord_str[0][1:]
        chord_root_hot[to_index.note_to_index(chord_root)] = 1
        chord_type_hot[to_index.type_to_index(chord_type)] = 1
        root_note_hot[to_index.note_to_index(chord_str[1])] = 1
        all_chord_roots_list.append(chord_root_hot)
        all_chord_types_list.append(chord_type_hot)
        all_root_notes_list.append(root_note_hot)
all_data = np.array(all_data_list)
all_chord_roots = np.array(all_chord_roots_list)
all_chord_types = np.array(all_chord_types_list)
all_root_notes = np.array(all_root_notes_list)

#initialize hyper-parameters
learning_rate = 0.1
num_training_steps = 1000
batch_size = 100

#define training specs and network architecture
data = tf.placeholder(tf.float32, shape=[None, 2048])
labels_chord_roots = tf.placeholder(tf.float32, shape=[None, 12])
labels_chord_types = tf.placeholder(tf.float32, shape=[None, to_index.num_chord_types])
labels_root_notes = tf.placeholder(tf.float32, shape=[None, 12])
weights_chord_roots = tf.Variable(tf.zeros([2048, 12]))
weights_chord_types = tf.Variable(tf.zeros([2048, to_index.num_chord_types]))
weights_root_notes = tf.Variable(tf.zeros([2048, 12]))
biases_chord_roots = tf.Variable(tf.zeros([12]))
biases_chord_types = tf.Variable(tf.zeros([to_index.num_chord_types]))
biases_root_notes = tf.Variable(tf.zeros([12]))
out_chord_roots = tf.matmul(data, weights_chord_roots) + biases_chord_roots
out_chord_types = tf.matmul(data, weights_chord_types) + biases_chord_types
out_root_notes = tf.matmul(data, weights_root_notes) + biases_root_notes
prediction_chord_roots = tf.nn.softmax(out_chord_roots)
prediction_chord_types = tf.nn.softmax(out_chord_types)
prediction_root_notes = tf.nn.softmax(out_root_notes)
loss_chord_roots = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits(logits=out_chord_roots, labels=labels_chord_roots))
loss_chord_types = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits(logits=out_chord_types, labels=labels_chord_types))
loss_root_notes = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits(logits=out_root_notes, labels=labels_root_notes))
train_chord_roots = tf.train.GradientDescentOptimizer(learning_rate).minimize(loss_chord_roots)
train_chord_types = tf.train.GradientDescentOptimizer(learning_rate).minimize(loss_chord_types)
train_root_notes = tf.train.GradientDescentOptimizer(learning_rate).minimize(loss_root_notes)

#train weights and biases
init_ = tf.global_variables_initializer()
sess = tf.InteractiveSession()
sess.run(init_)
for i in range(num_training_steps):
    batch_data, batch_labels_chord_roots, batch_labels_chord_types, batch_labels_root_notes = next_batch_chords(batch_size, all_data, all_chord_roots, all_chord_types, all_root_notes)
    sess.run(train_chord_roots, feed_dict={data: batch_data, labels_chord_roots: batch_labels_chord_roots})
    sess.run(train_chord_types, feed_dict={data: batch_data, labels_chord_types: batch_labels_chord_types})
    sess.run(train_root_notes, feed_dict={data: batch_data, labels_root_notes: batch_labels_root_notes})

#check values of weights and biases
weights_list_chord_roots = sess.run(weights_chord_roots)
weights_list_chord_types = sess.run(weights_chord_types)
weights_list_root_notes = sess.run(weights_root_notes)
biases_list_chord_roots = sess.run(biases_chord_roots)
biases_list_chord_types = sess.run(biases_chord_types)
biases_list_root_notes = sess.run(biases_root_notes)

#read and process testing data from text files
test_data_list = []
test_chord_roots_list = []
test_chord_types_list = []
test_root_notes_list = []
with open('C:\\Users\\James Jiang\\Documents\\ChordForMe\\app\\src\\main\\res\\raw\\train-in.txt') as f:
    for line in f:
        bytes_str = line.rstrip('\n')[1:-1].split(", ")
        test_data_list.append([int(byte) for byte in bytes_str])
with open('C:\\Users\\James Jiang\\Documents\\ChordForMe\\app\\src\\main\\res\\raw\\train-out.txt') as f:
    for line in f:
        chord_str = line.rstrip('\n')[2:-2].split("\", \"")
        chord_root_hot = [0]*12
        chord_type_hot = [0]*to_index.num_chord_types
        root_note_hot = [0]*12
        if len(chord_str[0]) == 1:
            chord_root = chord_str[0]
            chord_type = ""
        elif chord_str[0][1] == "#":
            chord_root = chord_str[0][:2]
            chord_type = chord_str[0][2:]
        else:
            chord_root = chord_str[0][0]
            chord_type = chord_str[0][1:]
        chord_root_hot[to_index.note_to_index(chord_root)] = 1
        chord_type_hot[to_index.type_to_index(chord_type)] = 1
        root_note_hot[to_index.note_to_index(chord_str[1])] = 1
        test_chord_roots_list.append(chord_root_hot)
        test_chord_types_list.append(chord_type_hot)
        test_root_notes_list.append(root_note_hot)
test_data = np.array(test_data_list)
test_chord_roots = np.array(test_chord_roots_list)
test_chord_types = np.array(test_chord_types_list)
test_root_notes = np.array(test_root_notes_list)

#test weights and biases
correct_chord_roots = tf.equal(tf.argmax(prediction_chord_roots), tf.argmax(test_chord_roots))
correct_chord_types = tf.equal(tf.argmax(prediction_chord_types), tf.argmax(test_chord_types))
correct_root_notes = tf.equal(tf.argmax(prediction_root_notes), tf.argmax(test_root_notes))
accuracy_chord_roots = tf.reduce_mean(tf.cast(correct_chord_roots, tf.float32))
accuracy_chord_types = tf.reduce_mean(tf.cast(correct_chord_types, tf.float32))
accuracy_root_notes = tf.reduce_mean(tf.cast(correct_root_notes, tf.float32))
total_accuracy_chord_roots = sess.run(accuracy_chord_roots, feed_dict={data: test_data, labels_chord_roots: test_chord_roots})
total_accuracy_chord_types = sess.run(accuracy_chord_types, feed_dict={data: test_data, labels_chord_types: test_chord_types})
total_accuracy_root_notes = sess.run(accuracy_root_notes, feed_dict={data: test_data, labels_root_notes: test_root_notes})
