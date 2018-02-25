import numpy as np
import tensorflow as tf
import translate
import get_data
import model

train_data = get_data.get_train_data()
train_chord_types = get_data.get_train_chord_types()
test_data = get_data.get_test_data()
test_chord_types = get_data.get_test_chord_types()

data = tf.placeholder(tf.float32, shape=[None, get_data.num_bytes*8])
labels_chord_types = tf.placeholder(tf.float32, shape=[None, translate.num_chord_types])
weights_chord_types_hidden = model.init_weights([get_data.num_bytes*8, model.num_hidden])
weights_chord_types_output = model.init_weights([model.num_hidden, translate.num_chord_types])

predict_chord_types = model.model(data, weights_chord_types_hidden, weights_chord_types_output)
loss_chord_types = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(logits=predict_chord_types, labels=labels_chord_types))
train_chord_types_op = model.create_train_op(loss_chord_types)
predict_chord_types_op = tf.argmax(predict_chord_types, 1)

init_ = tf.global_variables_initializer()
sess = tf.Session()
sess.run(init_)
for epoch in range(model.num_epochs):
    shuffled = np.random.permutation(range(len(train_data)))
    train_data, train_chord_types = train_data[shuffled], train_chord_types[shuffled]
    for start in range(0, len(train_data), model.batch_size):
        end = start + model.batch_size
        sess.run(train_chord_types_op, feed_dict={data: train_data[start:end], labels_chord_types: train_chord_types[start:end]})
    print(epoch, np.mean(np.argmax(train_chord_types, axis=1) == sess.run(predict_chord_types_op, feed_dict={data: train_data, labels_chord_types: train_chord_types})))

predicted_chord_type = sess.run(predict_chord_types_op, feed_dict={data: test_data})
output = np.vectorize(translate.index_to_type)(predicted_chord_type)
print("Predicted:", output)
print("Actual:   ", np.array([translate.index_to_type(chord) for chord in np.argmax(test_chord_types, axis=1)]))
