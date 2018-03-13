"""
Provides functions and constants for translating strings representing notes
and chord types to integers, and vice versa.
"""

NUM_CHORD_TYPES = 3
notes = ["C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C"]
chord_types = ["", "m", "7", "maj7", "min7", "mm7", "aug", "dim", "dim7", "dimm7"]

def note_to_index(note):
    """
    Returns index of note in global list variable notes
    """
    return(notes.index(note))

def type_to_index(chord_type):
    """
    Returns index of chord_type in global list variable chord_types
    """
    return(chord_types.index(chord_type))

def index_to_note(index):
    """
    Returns note at index in global list variable notes
    """
    return(notes[index])

def index_to_type(index):
    """
    Returns chord_type at index in global list variable chord_types
    """
    return(chord_types[index])

def increment_note_index(note_index, step):
    """
    Returns the index of the note in global list variable notes step number of
    semi-tones above note at note_index
    """
    return((note_index + step) % 12)

def possible_chord_roots(chord_type, root_note):
    """
    Returns a list of all possible chord roots of a chord with type chord_type
    and root (bottom) note root_note, both represented as indices in global
    list variables notes and chord_types
    """
    chord_roots = [root_note]
    if chord_type == 0:  # major chord
        chord_roots.extend([increment_note_index(root_note, 4), increment_note_index(root_note, 7)])  # root position
        chord_roots.extend([increment_note_index(root_note, 3), increment_note_index(root_note, 8)])  # first inversion
        chord_roots.extend([increment_note_index(root_note, 5), increment_note_index(root_note, 9)])  # second inversion
        return(chord_roots)
    if chord_type == 1:  # minor chord
        chord_roots.extend([increment_note_index(root_note, 3), increment_note_index(root_note, 7)])  # root position
        chord_roots.extend([increment_note_index(root_note, 4), increment_note_index(root_note, 9)])  # first inversion
        chord_roots.extend([increment_note_index(root_note, 5), increment_note_index(root_note, 8)])  # second inversion
        return(chord_roots)
    if chord_type == 2:  # dominant seventh chord
        chord_roots.extend([increment_note_index(root_note, 4), increment_note_index(root_note, 7), increment_note_index(root_note, 10)])  # root position
        chord_roots.extend([increment_note_index(root_note, 3), increment_note_index(root_note, 6), increment_note_index(root_note, 8)])  # first inversion
        chord_roots.extend([increment_note_index(root_note, 3), increment_note_index(root_note, 5), increment_note_index(root_note, 9)])  # second inversion
        chord_roots.extend([increment_note_index(root_note, 2), increment_note_index(root_note, 6), increment_note_index(root_note, 9)])  # third inversion
        return(chord_roots)

def possible_root_notes(chord_root, chord_type):
    """
    Returns a list of all possible root notes of a chord with chord root
    chord_root and type chord_type, both represented as indices in global list
    variables notes and chord_types
    """
    if chord_type == 0:  # major chord
        return([chord_root, increment_note_index(chord_root, 4), increment_note_index(chord_root, 7)])
    if chord_type == 1:  # minor chord
        return([chord_root, increment_note_index(chord_root, 3), increment_note_index(chord_root, 7)])
    if chord_type == 2:  # dominant seventh chord
        return([chord_root, increment_note_index(chord_root, 4), increment_note_index(chord_root, 7), increment_note_index(chord_root, 10)])
