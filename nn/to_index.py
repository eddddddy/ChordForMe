num_chord_types = 10

def note_to_index(note_name):
    #[C#, D, D#, E, F, F#, G, G#, A, A#, B, C]
    if note_name == "C#":
        return(0)
    if note_name == "D":
        return(1)
    if note_name == "D#":
        return(2)
    if note_name == "E":
        return(3)
    if note_name == "F":
        return(4)
    if note_name == "F#":
        return(5)
    if note_name == "G":
        return(6)
    if note_name == "G#":
        return(7)
    if note_name == "A":
        return(8)
    if note_name == "A#":
        return(9)
    if note_name == "B":
        return(10)
    if note_name == "C":
        return(11)

def type_to_index(chord_type):
    #[major, minor, V7, maj7, min7, maj-min7, aug, dim, dim7, dimm7]
    if chord_type == "":
        return(0)
    if chord_type == "m":
        return(1)
    if chord_type == "7":
        return(2)
    if chord_type == "maj7":
        return(3)
    if chord_type == "min7":
        return(4)
    if chord_type == "mm7":
        return(5)
    if chord_type == "aug":
        return(6)
    if chord_type == "dim":
        return(7)
    if chord_type == "dim7":
        return(8)
    if chord_type == "dimm7":
        return(9)