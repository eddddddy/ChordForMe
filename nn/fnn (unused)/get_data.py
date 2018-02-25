import numpy as np
import translate

def bytes_encode(bytes_list):
    string_bits = ''
    for byte in bytes_list:
        string_bits += bin(byte)[2:].zfill(8)
    return([int(bit) for bit in string_bits])

num_bytes = 16

train_data_list = []
test_data_list = []
train_chord_roots_list = []
test_chord_roots_list = []
train_chord_types_list = []
test_chord_types_list = []
train_root_notes_list = []
test_root_notes_list = []

with open('C:\\Users\\James Jiang\\Documents\\ChordForMe\\app\\src\\main\\res\\raw\\train_in.txt') as f:
    for line in f:
        bytes_str = line.rstrip('\n')[1:-1].split(", ")
        train_data_list.append(bytes_encode([int(byte) for byte in bytes_str][:num_bytes]))

with open('C:\\Users\\James Jiang\\Documents\\ChordForMe\\app\\src\\main\\res\\raw\\test_in.txt') as f:
    for line in f:
        bytes_str = line.rstrip('\n')[1:-1].split(", ")
        test_data_list.append(bytes_encode([int(byte) for byte in bytes_str][:num_bytes]))

with open('C:\\Users\\James Jiang\\Documents\\ChordForMe\\app\\src\\main\\res\\raw\\train_out.txt') as f:
    for line in f:
        chord_str = line.rstrip('\n')[2:-2].split("\", \"")
        chord_root_hot = [0]*12
        chord_type_hot = [0]*translate.num_chord_types
        root_note_hot = [0]*12
        if len(chord_str[0]) == 1:
            chord_root = chord_str[0]
            chord_type = ""
        elif chord_str[0][1] == "#":
            chord_root = chord_str[0][:2]
            chord_type = chord_str[0][2:]
        else:
            chord_root = chord_str[0][0]
            chord_type = chord_str[0][1:]
        chord_root_hot[translate.note_to_index(chord_root)] = 1
        chord_type_hot[translate.type_to_index(chord_type)] = 1
        root_note_hot[translate.note_to_index(chord_str[1])] = 1
        train_chord_roots_list.append(chord_root_hot)
        train_chord_types_list.append(chord_type_hot)
        train_root_notes_list.append(root_note_hot)

with open('C:\\Users\\James Jiang\\Documents\\ChordForMe\\app\\src\\main\\res\\raw\\test_out.txt') as f:
    for line in f:
        chord_str = line.rstrip('\n')[2:-2].split("\", \"")
        chord_root_hot = [0]*12
        chord_types_hot = [0]*translate.num_chord_types
        root_note_hot = [0]*12
        if len(chord_str[0]) == 1:
            chord_root = chord_str[0]
            chord_type = ""
        elif chord_str[0][1] == "#":
            chord_root = chord_str[0][:2]
            chord_type = chord_str[0][2:]
        else:
            chord_root = chord_str[0][0]
            chord_type = chord_str[0][1:]
        chord_root_hot[translate.note_to_index(chord_root)] = 1
        chord_type_hot[translate.type_to_index(chord_type)] = 1
        root_note_hot[translate.note_to_index(chord_str[1])] = 1
        test_chord_roots_list.append(chord_root_hot)
        test_chord_types_list.append(chord_type_hot)
        test_root_notes_list.append(root_note_hot)

def get_train_data():
    return(np.array(train_data_list))

def get_test_data():
    return(np.array(test_data_list))

def get_train_chord_roots():
    return(np.array(train_chord_roots_list))

def get_test_chord_roots():
    return(np.array(test_chord_roots_list))

def get_train_chord_types():
    return(np.array(train_chord_types_list))

def get_test_chord_types():
    return(np.array(test_chord_types_list))

def get_train_root_notes():
    return(np.array(train_root_notes_list))

def get_test_root_notes():
    return(np.array(test_root_notes_list))
