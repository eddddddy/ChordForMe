import numpy as np
import tensorflow as tf
import translate
import get_data
import model

train_data = get_data.get_train_data()
train_root_notes = get_data.get_train_root_notes()
test_data = get_data.get_test_data()
test_root_notes = get_data.get_test_root_notes()

data = tf.placeholder(tf.float32, shape=[None, get_data.num_bytes*8])
labels_root_notes = tf.placeholder(tf.float32, shape=[None, 12])
weights_root_notes_hidden = model.init_weights([get_data.num_bytes*8, model.num_hidden])
weights_root_notes_output = model.init_weights([model.num_hidden, 12])

predict_root_notes = model.model(data, weights_root_notes_hidden, weights_root_notes_output)
loss_root_notes = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(logits=predict_root_notes, labels=labels_root_notes))
train_root_notes_op = model.create_train_op(loss_root_notes)
predict_root_notes_op = tf.argmax(predict_root_notes, 1)

init_ = tf.global_variables_initializer()
sess = tf.Session()
sess.run(init_)
for epoch in range(model.num_epochs):
    shuffled = np.random.permutation(range(len(train_data)))
    train_data, train_root_notes = train_data[shuffled], train_root_notes[shuffled]
    for start in range(0, len(train_data), model.batch_size):
        end = start + model.batch_size
        sess.run(train_root_notes_op, feed_dict={data: train_data[start:end], labels_root_notes: train_root_notes[start:end]})
    print(epoch, np.mean(np.argmax(train_root_notes, axis=1) == sess.run(predict_root_notes_op, feed_dict={data: train_data, labels_root_notes: train_root_notes})))

predicted_root_note = sess.run(predict_root_notes_op, feed_dict={data: test_data})
output = np.vectorize(translate.index_to_note)(predicted_root_note)
print("Predicted:", output)
print("Actual:   ", np.array([translate.index_to_note(chord) for chord in np.argmax(test_root_notes, axis=1)]))
