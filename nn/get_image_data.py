import os
import imageio
import random
import translate

def preprocess_image(image):
    """
    Crops image appropriately and removes alpha channel
    """
    image = image[3:-3]
    for i in range(len(image)):
        image[i] = image[i][4:-3]
    for i in range(len(image)):
        for j in range(len(image[0])):
            del image[i][j][3]
    return(image)

def decrement_note(note):
    notes = list("abcdefg")
    return(notes[(notes.index(note) - 1) % len(notes)])

files = [file[:-4] for file in os.listdir("images")]
filepaths = ["images\\" + file + ".png" for file in files]

train_data_file = open("data\\train_data.txt", "w")
train_chord_root_labels_file = open("data\\train_chord_root_labels.txt", "w")
train_chord_type_labels_file = open("data\\train_chord_type_labels.txt", "w")
train_root_note_labels_file = open("data\\train_root_note_labels.txt", "w")
test_data_file = open("data\\test_data.txt", "w")
test_chord_root_labels_file = open("data\\test_chord_root_labels.txt", "w")
test_chord_type_labels_file = open("data\\test_chord_type_labels.txt", "w")
test_root_note_labels_file = open("data\\test_root_note_labels.txt", "w")

for i in range(len(filepaths)):
    #generate image data
    image = imageio.imread(filepaths[i]).tolist()
    image = preprocess_image(image)
    image_data_str = ""
    for j in range(len(image)):
        image_data_str += " ".join([str(k) for k in image[j][0]])
        if j != (len(image) - 1):
            image_data_str += " "

    random_num = random.randint(0, 9)

    #train data
    if random_num != 5:
        train_data_file.write(image_data_str + "\n")

        filename_components = files[i].split("_")[:-3]

        #generate chord root labels
        if filename_components[1] == "flat":
            train_chord_root_labels_file.write(str(translate.note_to_index(decrement_note(filename_components[0]).upper() + "#")) + "\n")
        elif filename_components[1] == "sharp":
            train_chord_root_labels_file.write(str(translate.note_to_index(filename_components[0].upper() + "#")) + "\n")
        else:
            train_chord_root_labels_file.write(str(translate.note_to_index(filename_components[0].upper())) + "\n")

        #generate chord type labels
        if "major" in filename_components:
            train_chord_type_labels_file.write(str(translate.type_to_index("")) + "\n")
        elif "minor" in filename_components:
            train_chord_type_labels_file.write(str(translate.type_to_index("m")) + "\n")
        elif "dominant" in filename_components:
            train_chord_type_labels_file.write(str(translate.type_to_index("7")) + "\n")

        #generate root note labels
        if filename_components[-1] == "flat":
            train_root_note_labels_file.write(str(translate.note_to_index(decrement_note(filename_components[-2]).upper() + "#")) + "\n")
        elif filename_components[-1] == "sharp":
            train_root_note_labels_file.write(str(translate.note_to_index(filename_components[-2].upper() + "#")) + "\n")
        else:
            train_root_note_labels_file.write(str(translate.note_to_index(filename_components[-1].upper())) + "\n")

    #test data
    else:
        test_data_file.write(image_data_str + "\n")

        filename_components = files[i].split("_")[:-3]

        #generate chord root labels
        if filename_components[1] == "flat":
            test_chord_root_labels_file.write(str(translate.note_to_index(decrement_note(filename_components[0]).upper() + "#")) + "\n")
        elif filename_components[1] == "sharp":
            test_chord_root_labels_file.write(str(translate.note_to_index(filename_components[0].upper() + "#")) + "\n")
        else:
            test_chord_root_labels_file.write(str(translate.note_to_index(filename_components[0].upper())) + "\n")

        #generate chord type labels
        if "major" in filename_components:
            test_chord_type_labels_file.write(str(translate.type_to_index("")) + "\n")
        elif "minor" in filename_components:
            test_chord_type_labels_file.write(str(translate.type_to_index("m")) + "\n")
        elif "dominant" in filename_components:
            test_chord_type_labels_file.write(str(translate.type_to_index("7")) + "\n")

        #generate root note labels
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
