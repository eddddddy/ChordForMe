import os
import random
import matplotlib.pyplot as plt
from scipy import signal
from scipy.io import wavfile
import numpy as np
import translate

"""
<<<<<<< HEAD
directories_list = ["major_root\\", "major_first_inversion\\", "major_second_inversion\\", "minor_root\\", "minor_first_inversion\\", "minor_second_inversion\\",
                    "dominant_seventh_root\\", "dominant_seventh_first_inversion\\", "dominant_seventh_second_inversion\\", "dominant_seventh_third_inversion\\"]
=======
fileroot1 = "C:\\Users\\James Jiang\\Documents\\ChordForMe\\"
fileroot2 = "C:\\Users\\Edward\\Documents\\Side Projects\\ChordForMe\\"
directories_list = ["major_root\\", "major_first_inversion\\", "major_second_inversion\\", "minor_root\\", "minor_first_inversion\\", "minor_second_inversion\\",
                    "dominant_seventh_root\\","dominant_seventh_first_inversion\\", "dominant_seventh_second_inversion\\", "dominant_seventh_third_inversion\\"]
>>>>>>> 447de3eaed3a4c98b01e6205d42465b7fc756366
"""

def crop_image(image):
    image = image[35:252]
    for i in range(len(image)):
        image[i] = image[i][54:55]
    return(image)

def decrement_note(note):
    notes = list("abcdefg")
    return(notes[(notes.index(note) - 1) % len(notes)])

train_data_file = open("data\\train_data.txt", "w")
train_chord_root_labels_file = open("data\\train_chord_root_labels.txt", "w")
train_chord_type_labels_file = open("data\\train_chord_type_labels.txt", "w")
train_root_note_labels_file = open("data\\train_root_note_labels.txt", "w")
test_data_file = open("data\\test_data.txt", "w")
test_chord_root_labels_file = open("data\\test_chord_root_labels.txt", "w")
test_chord_type_labels_file = open("data\\test_chord_type_labels.txt", "w")
test_root_note_labels_file = open("data\\test_root_note_labels.txt", "w")

directories_list = ["major_root\\", "major_first_inversion\\", "major_second_inversion\\", "minor_root\\", "minor_first_inversion\\", "minor_second_inversion\\",
                    "dominant_seventh_root\\","dominant_seventh_first_inversion\\", "dominant_seventh_second_inversion\\", "dominant_seventh_third_inversion\\"]

figure = plt.figure()
ax = figure.add_subplot(111)

for directory in directories_list:
    print(directory)
    audio_files = os.listdir("chordrecordings\\" + directory)
    for file in audio_files:
        sample_rate, samples = wavfile.read("chordrecordings\\" + directory + file)
        frequencies, times, spectrogram = signal.spectrogram(samples, sample_rate, nperseg=2048)
        plt.pcolormesh(times, frequencies, spectrogram)
        for i in range(16):
            plt.axis([0.064/3 + i*0.112/3, 0.064/3 + (i + 1)*0.112/3, 0, 5000])
            plt.axis("off")
            ax.get_xaxis().set_visible(False)
            ax.get_yaxis().set_visible(False)

            figure.canvas.draw()
            image = np.frombuffer(figure.canvas.tostring_rgb(), dtype=np.uint8)
            image = image.reshape(figure.canvas.get_width_height()[::-1] + (3,))
            image = np.array(crop_image(image.tolist())).flatten()
            image_data_str = " ".join([str(j) for j in image])

            random_num = random.randint(0, 9)

            if random_num != 5:
                train_data_file.write(image_data_str + "\n")

                filename_components = file.split("_")[:-2]

                if filename_components[1] == "flat":
                    train_chord_root_labels_file.write(str(translate.note_to_index(decrement_note(filename_components[0]).upper() + "#")) + "\n")
                elif filename_components[1] == "sharp":
                    train_chord_root_labels_file.write(str(translate.note_to_index(filename_components[0].upper() + "#")) + "\n")
                else:
                    train_chord_root_labels_file.write(str(translate.note_to_index(filename_components[0].upper())) + "\n")

                if "major" in filename_components:
                    train_chord_type_labels_file.write(str(translate.type_to_index("")) + "\n")
                elif "minor" in filename_components:
                    train_chord_type_labels_file.write(str(translate.type_to_index("m")) + "\n")
                elif "dominant" in filename_components:
                    train_chord_type_labels_file.write(str(translate.type_to_index("7")) + "\n")

                if filename_components[-1] == "flat":
                    train_root_note_labels_file.write(str(translate.note_to_index(decrement_note(filename_components[-2]).upper() + "#")) + "\n")
                elif filename_components[-1] == "sharp":
                    train_root_note_labels_file.write(str(translate.note_to_index(filename_components[-2].upper() + "#")) + "\n")
                else:
                    train_root_note_labels_file.write(str(translate.note_to_index(filename_components[-1].upper())) + "\n")

            else:
                test_data_file.write(image_data_str + "\n")

                filename_components = file.split("_")[:-2]

                if filename_components[1] == "flat":
                    test_chord_root_labels_file.write(str(translate.note_to_index(decrement_note(filename_components[0]).upper() + "#")) + "\n")
                elif filename_components[1] == "sharp":
                    test_chord_root_labels_file.write(str(translate.note_to_index(filename_components[0].upper() + "#")) + "\n")
                else:
                    test_chord_root_labels_file.write(str(translate.note_to_index(filename_components[0].upper())) + "\n")

                if "major" in filename_components:
                    test_chord_type_labels_file.write(str(translate.type_to_index("")) + "\n")
                elif "minor" in filename_components:
                    test_chord_type_labels_file.write(str(translate.type_to_index("m")) + "\n")
                elif "dominant" in filename_components:
                    test_chord_type_labels_file.write(str(translate.type_to_index("7")) + "\n")

                if filename_components[-1] == "flat":
                    test_root_note_labels_file.write(str(translate.note_to_index(decrement_note(filename_components[-2]).upper() + "#")) + "\n")
                elif filename_components[-1] == "sharp":
                    test_root_note_labels_file.write(str(translate.note_to_index(filename_components[-2].upper() + "#")) + "\n")
                else:
                    test_root_note_labels_file.write(str(translate.note_to_index(filename_components[-1].upper())) + "\n")

train_data_file.close()
train_chord_root_labels_file.close()
train_chord_type_labels_file.close()
train_root_note_labels_file.close()
test_data_file.close()
test_chord_root_labels_file.close()
test_chord_type_labels_file.close()
test_root_note_labels_file.close()

# Edward's test code
'''
def genimage():
	audiopath = fileroot2 + "chordrecordings\\major_root\\a_major_a_fourth_octave.wav"
	sample_rate, samples = wavfile.read(audiopath)
	print(samples)
    frequencies, times, spectrogram = signal.spectrogram(samples, sample_rate, nperseg=2048)
    plt.pcolormesh(times, frequencies, spectrogram)
    for i in range(16):
        plt.axis([0.064/3 + i*0.112/3, 0.064/3 + (i + 1)*0.112/3, 0, 5000])
        plt.axis("off")
        ax = plt.gca()
        ax.get_xaxis().set_visible(False)
        ax.get_yaxis().set_visible(False)
        plt.savefig(imagepath, bbox_inches="tight", pad_inches=0)


if __name__ == "__main__":
	print(genimage())
'''