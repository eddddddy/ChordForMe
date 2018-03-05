num_chord_types = 3
notes = ["C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C"]
chord_types = ["", "m", "7", "maj7", "min7", "mm7", "aug", "dim", "dim7", "dimm7"]

def note_to_index(note):
    if note not in notes:
        raise NameError("Shit's fucked yo!")
    return(notes.index(note))

def type_to_index(chord_type):
    if chord_type not in chord_types:
        raise NameError("Shit's fucked yo!")
    return(chord_types.index(chord_type))

def index_to_note(index):
    return(notes[index])

def index_to_type(index):
    return(chord_types[index])
