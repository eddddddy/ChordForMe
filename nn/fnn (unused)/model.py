import tensorflow as tf

learning_rate = 0.05 #adjust the learning rate
num_epochs = 10000 #adjust the number of training epochs
batch_size = 128 #adjust the batch size per training session
num_hidden = 100 #adjust the number of hidden units

momentum = 0.9 #adjust momentum

#variables for decaying learning rate
global_step = tf.Variable(0, trainable=False)
decay_steps = 10000 #adjust number of decay steps of learning rate
decay_rate = 0.99 #adjust decay rate of learning rate

#determine how to initialize the weights
def init_weights(shape):
    return(tf.Variable(tf.random_normal(shape, stddev=0.01)))

#determine which non-linear activation function to use
def model(data, weights_hidden, weights_output):
    hidden = tf.nn.sigmoid(tf.matmul(data, weights_hidden))
    return(tf.nn.sigmoid(tf.matmul(hidden, weights_output)))

#determine which optimizer to use
def create_train_op(loss):
    return(tf.train.MomentumOptimizer(learning_rate, momentum).minimize(loss))
