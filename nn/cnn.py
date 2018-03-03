import tensorflow as tf
import translate

tf.logging.set_verbosity(tf.logging.INFO)

def cnn_model_fn_chord_root(features, labels, mode):
    input_layer = tf.reshape(features["x"], [-1, 216, 332, 3])
    conv_layer_1 = tf.layers.conv2d(inputs=input_layer, filters=32, kernel_size=5, padding="same", activation=tf.nn.relu)
    pool_layer_1 = tf.layers.max_pooling2d(inputs=conv_layer_1, pool_size=2, strides=2)
    conv_layer_2 = tf.layers.conv2d(inputs=pool_layer_1, filters=64, kernel_size=5, padding="same", activation=tf.nn.relu)
    pool_layer_2 = tf.layers.max_pooling2d(inputs=conv_layer_2, pool_size=2, strides=2)
    pool_2_flat = tf.reshape(pool_layer_2, [-1, 54*83*64])
    dense_layer = tf.layers.dense(inputs=pool_2_flat, units=1024, activation=tf.nn.relu)
    dropout = tf.layers.dropout(inputs=dense_layer, rate=0.4, training=(mode == tf.estimator.ModeKeys.TRAIN))
    logits = tf.layers.dense(inputs=dropout, units=12)

    predictions = {"classes": tf.argmax(input=logits, axis=1), "probabilities": tf.nn.softmax(logits, name="softmax_chord_root")}

    if mode == tf.estimator.ModeKeys.PREDICT:
        return tf.estimator.EstimatorSpec(mode=mode, predictions=predictions)

    loss = tf.losses.sparse_softmax_cross_entropy(labels=labels, logits=logits)

    if mode == tf.estimator.ModeKeys.TRAIN:
        optimizer = tf.train_GradientDescentOptimizer(learning_rate=0.001)
        train_op = optimizer.minimize(loss=loss, global_step=tf.train.get_global_step())
        return tf.estimator.EstimatorSpec(mode=mode, loss=loss, train_op=train_op)

    if mode == tf.estimator.ModeKeys.EVAL:
        eval_metric_ops = {"accuracy": tf.metrics.accuracy(labels=labels, predictions=predictions["classes"])}
        return tf.estimator.EstimatorSpec(mode=mode, loss=loss, eval_metric_ops=eval_metric_ops)


def cnn_model_fn_chord_type(features, labels, mode):
    input_layer = tf.reshape(features["x"], [-1, 216, 332, 3])
    conv_layer_1 = tf.layers.conv2d(inputs=input_layer, filters=32, kernel_size=5, padding="same", activation=tf.nn.relu)
    pool_layer_1 = tf.layers.max_pooling2d(inputs=conv_layer_1, pool_size=2, strides=2)
    conv_layer_2 = tf.layers.conv2d(inputs=pool_layer_1, filters=64, kernel_size=5, padding="same", activation=tf.nn.relu)
    pool_layer_2 = tf.layers.max_pooling2d(inputs=conv_layer_2, pool_size=2, strides=2)
    pool_2_flat = tf.reshape(pool_layer_2, [-1, 54*83*64])
    dense_layer = tf.layers.dense(inputs=pool_2_flat, units=1024, activation=tf.nn.relu)
    dropout = tf.layers.dropout(inputs=dense_layer, rate=0.4, training=(mode == tf.estimator.ModeKeys.TRAIN))
    logits = tf.layers.dense(inputs=dropout, units=translate.num_chord_types)

    predictions = {"classes": tf.argmax(input=logits, axis=1), "probabilities": tf.nn.softmax(logits, name="softmax_chord_type")}

    if mode == tf.estimator.ModeKeys.PREDICT:
        return tf.estimator.EstimatorSpec(mode=mode, predictions=predictions)

    loss = tf.losses.sparse_softmax_cross_entropy(labels=labels, logits=logits)

    if mode == tf.estimator.ModeKeys.TRAIN:
        optimizer = tf.train_GradientDescentOptimizer(learning_rate=0.001)
        train_op = optimizer.minimize(loss=loss, global_step=tf.train.get_global_step())
        return tf.estimator.EstimatorSpec(mode=mode, loss=loss, train_op=train_op)

    if mode == tf.estimator.ModeKeys.EVAL:
        eval_metric_ops = {"accuracy": tf.metrics.accuracy(labels=labels, predictions=predictions["classes"])}
        return tf.estimator.EstimatorSpec(mode=mode, loss=loss, eval_metric_ops=eval_metric_ops)


def cnn_model_fn_root_note(features, labels, mode):
    input_layer = tf.reshape(features["x"], [-1, 216, 332, 3])
    conv_layer_1 = tf.layers.conv2d(inputs=input_layer, filters=32, kernel_size=5, padding="same", activation=tf.nn.relu)
    pool_layer_1 = tf.layers.max_pooling2d(inputs=conv_layer_1, pool_size=2, strides=2)
    conv_layer_2 = tf.layers.conv2d(inputs=pool_layer_1, filters=64, kernel_size=5, padding="same", activation=tf.nn.relu)
    pool_layer_2 = tf.layers.max_pooling2d(inputs=conv_layer_2, pool_size=2, strides=2)
    pool_2_flat = tf.reshape(pool_layer_2, [-1, 54*83*64])
    dense_layer = tf.layers.dense(inputs=pool_2_flat, units=1024, activation=tf.nn.relu)
    dropout = tf.layers.dropout(inputs=dense_layer, rate=0.4, training=(mode == tf.estimator.ModeKeys.TRAIN))
    logits = tf.layers.dense(inputs=dropout, units=12)

    predictions = {"classes": tf.argmax(input=logits, axis=1), "probabilities": tf.nn.softmax(logits, name="softmax_root_note")}

    if mode == tf.estimator.ModeKeys.PREDICT:
        return tf.estimator.EstimatorSpec(mode=mode, predictions=predictions)

    loss = tf.losses.sparse_softmax_cross_entropy(labels=labels, logits=logits)

    if mode == tf.estimator.ModeKeys.TRAIN:
        optimizer = tf.train_GradientDescentOptimizer(learning_rate=0.001)
        train_op = optimizer.minimize(loss=loss, global_step=tf.train.get_global_step())
        return tf.estimator.EstimatorSpec(mode=mode, loss=loss, train_op=train_op)

    if mode == tf.estimator.ModeKeys.EVAL:
        eval_metric_ops = {"accuracy": tf.metrics.accuracy(labels=labels, predictions=predictions["classes"])}
        return tf.estimator.EstimatorSpec(mode=mode, loss=loss, eval_metric_ops=eval_metric_ops)


def main(argv):
    train_data = get_image_data.train_images
    train_chord_root_labels = get_image_data.train_chord_root_labels
    train_chord_type_labels = get_image_data.train_chord_type_labels
    train_root_note_labels = get_image_data.train_root_note_labels

    test_data = get_image_data.test_images
    test_chord_root_labels = get_image_data.test_chord_root_labels
    test_chord_type_labels = get_image_data.test_chord_type_labels
    test_root_note_labels = get_image_data.test_root_note_labels

    checkpoint_cfg = tf.estimator.RunConfig(save_checkpoints_secs=5*60, keep_checkpoint_max=5)

    #train and evaluate chord root model
    classifier_chord_root = tf.estimator.Estimator(model_fn=cnn_model_fn_chord_root, model_dir="log\\", config=checkpoint_cfg)
    to_log_chord_root = {"probabilities": "softmax_chord_root"}
    logging_hook_chord_root = tf.train.LoggingTensorHook(tensors=to_log_chord_root, every_n_iter=50)

    train_input_fn_chord_root = tf.estimator.inputs.numpy_input_fn(x={"x": train_data}, y=train_chord_root_labels, batch_size = 100, num_epochs=None, shuffle=True)
    classifier_chord_root.train(input_fn=train_input_fn_chord_root, steps=10000, hooks=[logging_hook_chord_root])

    eval_input_fn_chord_root = tf.estimator.inputs.numpy_input_fn(x={"x": test_data}, y=test_chord_root_labels, num_epochs=1, shuffle=False)
    eval_results_chord_root = classifier_chord_root.evaluate(input_fn=eval_input_fn_chord_root)
    print(eval_results_chord_root)

    #train and evaluate chord type model
    classifier_chord_type = tf.estimator.Estimator(model_fn=cnn_model_fn_chord_type, model_dir="log\\", config=checkpoint_cfg)
    to_log_chord_type = {"probabilities": "softmax_chord_type"}
    logging_hook_chord_type = tf.train.LoggingTensorHook(tensors=to_log_chord_type, every_n_iter=50)

    train_input_fn_chord_type = tf.estimator.inputs.numpy_input_fn(x={"x": train_data}, y=train_chord_type_labels, batch_size = 100, num_epochs=None, shuffle=True)
    classifier_chord_type.train(input_fn=train_input_fn_chord_type, steps=10000, hooks=[logging_hook_chord_type])

    eval_input_fn_chord_type = tf.estimator.inputs.numpy_input_fn(x={"x": test_data}, y=test_chord_type_labels, num_epochs=1, shuffle=False)
    eval_results_chord_type = classifier_chord_type.evaluate(input_fn=eval_input_fn_chord_type)
    print(eval_results_chord_type)

    #train and evaluate root note model
    classifier_root_note = tf.estimator.Estimator(model_fn=cnn_model_fn_root_note, model_dir="log\\", config=checkpoint_cfg)
    to_log_root_note = {"probabilities": "softmax_root_note"}
    logging_hook_root_note = tf.train.LoggingTensorHook(tensors=to_log_root_note, every_n_iter=50)

    train_input_fn_root_note = tf.estimator.inputs.numpy_input_fn(x={"x": train_data}, y=train_root_note_labels, batch_size = 100, num_epochs=None, shuffle=True)
    classifier_root_note.train(input_fn=train_input_fn_root_note, steps=10000, hooks=[logging_hook_root_note])

    eval_input_fn_root_note = tf.estimator.inputs.numpy_input_fn(x={"x": test_data}, y=test_root_note_labels, num_epochs=1, shuffle=False)
    eval_results_root_note = classifier_root_note.evaluate(input_fn=eval_input_fn_root_note)
    print(eval_results_root_note)


if __name__ == "__main__":
    tf.app.run()
