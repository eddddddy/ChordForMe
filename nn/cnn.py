import tensorflow as tf
import get_image_data

tf.logging.set_verbosity(tf.logging.INFO)

def cnn_model_fn(features, labels, mode):
    input_layer = tf.reshape(features["x"], [-1, 216, 332, 3])
    conv_layer_1 = tf.layers.conv2d(inputs=input_layer, filters=32, kernel_size=5, padding="same", activation=tf.nn.relu)
    pool_layer_1 = tf.layers.max_pooling2d(inputs=conv_layer_1, pool_size=2, strides=2)
    conv_layer_2 = tf.layers.conv2d(inputs=pool_layer_1, filters=64, kernel_size=5, padding="same", activation=tf.nn.relu)
    pool_layer_2 = tf.layers.max_pooling2d(inputs=conv_layer_2, pool_size=2, strides=2)
    pool_2_flat = tf.reshape(pool_layer_2, [-1, 54*83*64])
    dense_layer = tf.layers.dense(inputs=pool_2_flat, units=1024, activation=tf.nn.relu)
    dropout = tf.layers.dropout(inputs=dense_layer, rate=0.4, training=(mode == tf.estimator.ModeKeys.TRAIN))
    logits = tf.layers.dense(inputs=dropout, units=12)

    predictions = {"classes": tf.argmax(input=logits, axis=1), "probabilities": tf.nn.softmax(logits, name="softmax_")}
    loss = tf.losses.sparse_softmax_cross_entropy(labels=labels, logits=logits)

    if mode == tf.estimator.ModeKeys.PREDICT:
        return tf.estimator.EstimatorSpec(mode=mode, predictions=predictions)

    if mode == tf.estimator.ModeKeys.TRAIN:
        optimizer = tf.train_GradientDescentOptimizer(learning_rate=0.001)
        train_op = optimizer.minimize(loss=loss, global_step=tf.train.get_global_step())
        return tf.estimator.EstimatorSpec(mode=mode, loss=loss, train_op=train_op)

    if mode == tf.estimator.ModeKeys.EVAL:
        eval_metric_ops = {"accuracy": tf.metrics.accuracy(labels=labels, predictions=predictions["classes"])}
        return tf.estimator.EstimatorSpec(mode=mode, loss=loss, eval_metric_ops=eval_metric_ops)

def main(argv):
    train_data = get_image_data.
    train_labels = get_image_data.
    test_data = get_image_data.
    test_labels = get_image_data.
    classifier = tf.estimator.Estimator(model_fn=cnn_model_fn, model_dir="C:\\Users\\James Jiang\\Documents\\ChordForMe\\nn")
    to_log = {"probabilities": "softmax_"}
    logging_hook = tf.train.LoggingTensorHook(tensors=to_log, every_n_iter=50)

    train_input_fn = tf.estimator.inputs.numpy_input_fn(x={"x": train_data}, y=train_labels, batch_size = 100, num_epochs=None, shuffle=True)
    classifier.train(input_fn=train_input_fn, steps=10000, hooks=[logging_hook])

    eval_input_fn = tf.estimator.inputs.numpy_input_fn(x={"x": test_data}, y=test_labels, num_epochs=1, shuffle=False)
    eval_results = classifier.evaluate(input_fn=eval_input_fn)
    print(eval_results)

if __name__ == "__main__":
    tf.app.run()
