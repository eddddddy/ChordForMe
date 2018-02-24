import numpy as np
import tensorflow as tf
import translate
import get_data
import model

train_data = get_data.get_train_data()
train_chord_roots = get_data.get_train_chord_roots()
test_data = get_data.get_test_data()
test_chord_roots = get_data.get_test_chord_roots()

data = tf.placeholder(tf.float32, shape=[None, get_data.num_bytes*8])
labels_chord_roots = tf.placeholder(tf.float32, shape=[None, 12])
weights_chord_roots_hidden = model.init_weights([get_data.num_bytes*8, model.num_hidden])
weights_chord_roots_output = model.init_weights([model.num_hidden, 12])

predict_chord_roots = model.model(data, weights_chord_roots_hidden, weights_chord_roots_output)
loss_chord_roots = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(logits=predict_chord_roots, labels=labels_chord_roots))
train_chord_roots_op = model.create_train_op(loss_chord_roots)
predict_chord_roots_op = tf.argmax(predict_chord_roots, 1)

init_ = tf.global_variables_initializer()
sess = tf.Session()
sess.run(init_)
for epoch in range(model.num_epochs):
    shuffled = np.random.permutation(range(len(train_data)))
    train_data, train_chord_roots = train_data[shuffled], train_chord_roots[shuffled]
    for start in range(0, len(train_data), model.batch_size):
        end = start + model.batch_size
        sess.run(train_chord_roots_op, feed_dict={data: train_data[start:end], labels_chord_roots: train_chord_roots[start:end]})
    print(epoch, np.mean(np.argmax(train_chord_roots, axis=1) == sess.run(predict_chord_roots_op, feed_dict={data: train_data, labels_chord_roots: train_chord_roots})))

predicted_chord_root = sess.run(predict_chord_roots_op, feed_dict={data: test_data})
output = np.vectorize(translate.index_to_note)(predicted_chord_root)
print("Predicted:", output)
print("Actual:   ", np.array([translate.index_to_note(chord) for chord in np.argmax(test_chord_roots, axis=1)]))
