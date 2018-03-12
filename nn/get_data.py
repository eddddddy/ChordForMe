import numpy as np
import translate

def next_batch(batch_size, data, labels):
	a = np.arange(0, len(data))
	np.random.shuffle(a)
	a = a[:batch_size]
	return(data[a], labels[a])

len_data = 654

train_data = []
with open("data\\train_data.txt") as f:
    for line in f:
        data = line.rstrip("\n").split(" ")
        train_data.append(list(map(int, data)))

test_data = []
with open("data\\test_data.txt") as f:
    for line in f:
        data = line.rstrip("\n").split(" ")
        train_data.append(list(map(int, data)))

train_chord_roots = []
train_chord_types = []
train_root_notes = []
train_chord_roots_read = [line.rstrip("\n") for line in open("data\\train_chord_root_labels.txt")]
train_chord_types_read = [line.rstrip("\n") for line in open("data\\train_chord_type_labels.txt")]
train_root_notes_read = [line.rstrip("\n") for line in open("data\\train_root_note_labels.txt")]

for i in range(len(train_data)):
    chord_root_label = [0]*12
    chord_type_label = [0]*translate.num_chord_types
    root_note_label = [0]*12
    chord_root_label[int(train_chord_roots_read[i])] = 1
    chord_type_label[int(train_chord_types_read[i])] = 1
    root_note_label[int(train_root_notes_read[i])] = 1
    train_chord_roots.append(chord_root_label)
    train_chord_types.append(chord_type_label)
    train_root_notes.append(root_note_label)

test_chord_roots = []
test_chord_types = []
test_root_notes = []
test_chord_roots_read = [line.rstrip("\n") for line in open("data\\test_chord_root_labels.txt")]
test_chord_types_read = [line.rstrip("\n") for line in open("data\\test_chord_type_labels.txt")]
test_root_notes_read = [line.rstrip("\n") for line in open("data\\test_root_note_labels.txt")]

for i in range(len(test_data)):
    chord_root_label = [0]*12
    chord_type_label = [0]*translate.num_chord_types
    root_note_label = [0]*12
    chord_root_label[int(test_chord_roots_read[i])] = 1
    chord_type_label[int(test_chord_types_read[i])] = 1
    root_note_label[int(test_root_notes_read[i])] = 1
    test_chord_roots.append(chord_root_label)
    test_chord_types.append(chord_type_label)
    test_root_notes.append(root_note_label)

train_data = np.array(train_data)
test_data = np.array(test_data)
train_chord_roots = np.array(train_chord_roots)
test_chord_roots = np.array(test_chord_roots)
train_chord_types = np.array(train_chord_types)
test_chord_types = np.array(test_chord_types)
train_root_notes = np.array(train_root_notes)
test_root_notes = np.array(test_root_notes)
