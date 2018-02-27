import os
import imageio
import numpy as np

def preprocess_image(image):
    for i in range(4):
        del image[0]
        del image[-1]
    for i in range(216):
        for j in range(3):
            del image[i][0]
            del image[i][-1]
        for j in range(3):
            del image[i][0]
    for i in range(216):
        for j in range(332):
            del image[i][j][3]

files = [file[:-4] for file in os.listdir("images")]
filepaths = ["images\\" + file + ".png" for file in files]
train_images = []
train_chord_root_labels = []
train_chord_type_labels = []
train_root_note_labels = []

for i in range(len(files)):
    image = imageio.imread(filepaths[i]).tolist()
    preprocess_image(image)
    train_images.append(image)

train_images = np.array(train_images)
