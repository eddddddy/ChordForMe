import os
import tensorflow as tf

files = [file[:-4] for file in os.listdir("images")]
filepaths = ["images\\" + file + ".png" for file in files]
images = []

filename_queue = tf.train.string_input_producer(tf.convert_to_tensor(filepaths, dtype=tf.string), shuffle=False)
image_reader = tf.WholeFileReader()
filename, image_file = image_reader.read(filename_queue)
image = tf.image.decode_png(image_file, channels=3)
image = tf.image.crop_to_bounding_box(image, 5, 5, 216, 332)

with tf.Session() as sess:
    tf.local_variables_initializer().run()
    coord = tf.train.Coordinator()
    threads = tf.train.start_queue_runners(coord=coord)
    for i in range(len(files)):
        image_tensor = image.eval()
        images.append(image_tensor.tolist())
    images = tf.convert_to_tensor(images, dtype=tf.float32).eval()
    coord.request_stop()
    coord.join(threads)
