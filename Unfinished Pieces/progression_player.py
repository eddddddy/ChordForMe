"""
This module is used simply to play a chord progression (for testing purposes).

Scroll to the bottom for an example usage.
"""

import time
from pyknon.genmidi import Midi
from pyknon.music import Note, NoteSeq
import pygame as pg


def above_tonic(note, key):
    if "flattened" in note:
        return(above_tonic(note[9:].lower(), key) - 1)

    elif "sharpened" in note:
        return(above_tonic(note[9:].lower(), key) + 1)

    elif key == "major":
        if note == "tonic":
            return 0
        elif note == "supertonic":
            return 2
        elif note == "mediant":
            return 4
        elif note == "subdominant":
            return 5
        elif note == "dominant":
            return 7
        elif note == "submediant":
            return 9
        elif note == "subtonic":
            return 11
        else:
            pass

    elif key == "minor":
        if note == "tonic":
            return 0
        elif note == "supertonic":
            return 2
        elif note == "mediant":
            return 3
        elif note == "subdominant":
            return 5
        elif note == "dominant":
            return 7
        elif note == "submediant":
            return 8
        elif note == "subtonic":
            return 10
        else:
            pass

    print("Note:", note)
    print("Key:", key)
    raise ValueError("Something went wrong. Check that the above inputs are valid.")


def chord_notes(chord_list):
    if chord_list[0] == "major":
        return [0, 4, 7]
    elif chord_list[0] == "minor":
        return [0, 3, 7]
    elif chord_list[0] == "diminished":
        return [0, 3, 6]
    elif chord_list[0] == "augmented":
        return [0, 4, 8]
    elif chord_list[0] == "dominantSeventh":
        return [0, 4, 7, 10]
    elif chord_list[0] == "majorSeventh":
        return [0, 4, 7, 11]
    elif chord_list[0] == "minorSeventh":
        return [0, 3, 7, 10]
    elif chord_list[0] == "minorMajorSeventh":
        return [0, 3, 7, 11]
    elif chord_list[0] == "diminishedSeventh":
        return [0, 3, 6, 9]
    elif chord_list[0] == "halfDiminishedSeventh":
        return [0, 3, 6, 10]
    elif chord_list[0] == "augmentedSeventh":
        return [0, 4, 8, 10]
    elif chord_list[0] == "augmentedMajorSeventh":
        return [0, 4, 8, 11]
    elif chord_list[0] == "dominantSeventhFlatFive":
        return [0, 4, 6, 10]
    elif chord_list[0] == "minorSixth":
        return [0, 3, 7, 9]
    elif chord_list[0] == "germanAugmentedSixth":
        return [0, 4, 7, 10]
    elif chord_list[0] == "dominantNinth":
        return [0, 4, 7, 10, 14]

    print("Chord:", chord_list[0])
    raise ValueError("Something went wrong. Most likely, the above chord has not been coded yet.")


def bass_note(chord_list, key):
    if chord_list[0] == "major":
        if chord_list[2] == 0:
            return 0
        elif chord_list[2] == 1:
            return 4
        elif chord_list[2] == 2:
            return 7
        else:  # pedal
            pass

    elif chord_list[0] == "minor":
        if chord_list[2] == 0:
            return 0
        elif chord_list[2] == 1:
            return 3
        elif chord_list[2] == 2:
            return 7
        else:  # pedal
            pass

    elif chord_list[0] == "diminished":
        if chord_list[2] == 0:
            return 0
        elif chord_list[2] == 1:
            return 3
        elif chord_list[2] == 2:
            return 6
        else:  # pedal
            pass

    elif chord_list[0] == "augmented":
        if chord_list[2] == 0:
            return 0
        elif chord_list[2] == 1:
            return 4
        elif chord_list[2] == 2:
            return 8
        else:  # pedal
            pass

    elif chord_list[0] == "dominantSeventh":
        if chord_list[2] == 0:
            return 0
        elif chord_list[2] == 1:
            return 4
        elif chord_list[2] == 2:
            return 7
        elif chord_list[2] == 3:
            return 10
        else:  # pedal
            pass

    elif chord_list[0] == "majorSeventh":
        if chord_list[2] == 0:
            return 0
        elif chord_list[2] == 1:
            return 4
        elif chord_list[2] == 2:
            return 7
        elif chord_list[2] == 3:
            return 11
        else:  # pedal
            pass

    elif chord_list[0] == "minorSeventh":
        if chord_list[2] == 0:
            return 0
        elif chord_list[2] == 1:
            return 3
        elif chord_list[2] == 2:
            return 7
        elif chord_list[2] == 3:
            return 10
        else:  # pedal
            pass

    elif chord_list[0] == "minorMajorSeventh":
        if chord_list[2] == 0:
            return 0
        elif chord_list[2] == 1:
            return 3
        elif chord_list[2] == 2:
            return 7
        elif chord_list[2] == 3:
            return 11
        else:  # pedal
            pass

    elif chord_list[0] == "diminishedSeventh":
        if chord_list[2] == 0:
            return 0
        elif chord_list[2] == 1:
            return 3
        elif chord_list[2] == 2:
            return 6
        elif chord_list[2] == 3:
            return 9
        else:  # pedal
            pass

    elif chord_list[0] == "halfDiminishedSeventh":
        if chord_list[2] == 0:
            return 0
        elif chord_list[2] == 1:
            return 3
        elif chord_list[2] == 2:
            return 6
        elif chord_list[2] == 3:
            return 10
        else:  # pedal
            pass

    elif chord_list[0] == "augmentedSeventh":
        if chord_list[2] == 0:
            return 0
        elif chord_list[2] == 1:
            return 4
        elif chord_list[2] == 2:
            return 8
        elif chord_list[2] == 3:
            return 10
        else:  # pedal
            pass

    elif chord_list[0] == "augmentedMajorSeventh":
        if chord_list[2] == 0:
            return 0
        elif chord_list[2] == 1:
            return 4
        elif chord_list[2] == 2:
            return 8
        elif chord_list[2] == 3:
            return 11
        else:  # pedal
            pass

    elif chord_list[0] == "dominantSeventhFlatFive":
        if chord_list[2] == 0:
            return 0
        elif chord_list[2] == 1:
            return 4
        elif chord_list[2] == 2:
            return 6
        elif chord_list[2] == 3:
            return 10
        else:  # pedal
            pass

    elif chord_list[0] == "minorSixth":
        if chord_list[2] == 0:
            return 0
        elif chord_list[2] == 1:
            return 3
        elif chord_list[2] == 2:
            return 7
        elif chord_list[2] == 3:
            return 9
        else:  # pedal
            pass

    elif chord_list[0] == "germanAugmentedSixth":
        if chord_list[2] == 0:
            return 0
        elif chord_list[2] == 1:
            return 4
        elif chord_list[2] == 2:
            return 7
        elif chord_list[2] == 3:
            return 10
        else:  # pedal
            pass

    elif chord_list[0] == "dominantNinth":
        if chord_list[2] == 0:
            return 0
        elif chord_list[2] == 1:
            return 4
        elif chord_list[2] == 2:
            return 7
        elif chord_list[2] == 3:
            return 10
        elif chord_list[2] == 4:
            return 14
        else:  # pedal
            pass

    try:
        if chord_list[2].find("Pedal") == (len(chord_list[2]) - 5):
            difference = above_tonic(chord_list[2][:-5], key) - above_tonic(chord_list[1], key)
            if difference >= 0:
                return difference
            else:
                return(12 + difference)
    except AttributeError:
        pass

    print("Chord:", chord_list[0])
    print("Inversion:", chord_list[2])

    raise ValueError("Something went wrong. Most likely, the above chord has not been coded yet."
                     " Also, check that the inversion is valid.")


def chord_tonic(chord_list, key):
    bass = bass_note(chord_list, key) + above_tonic(chord_list[1], key)
    notes = [note + above_tonic(chord_list[1], key) + 12 for note in chord_notes(chord_list)]
    return([bass] + notes)


def create_progression_midi(progression_list, tempo):
    key = progression_list[0]
    progression = []

    for i in range(1, len(progression_list)):
        chord = []
        chord_notes_tonic = chord_tonic(progression_list[i], key)

        for chord_note in chord_notes_tonic:
            value = chord_note % 12
            octave_offset = chord_note//12
            note = Note(value=value, octave=(octave_offset + 4), dur=1/4)
            chord.append(note)

        progression.append([NoteSeq(chord), i])

    midi = Midi(tempo=tempo)
    for chord in progression:
        midi.seq_chords([chord[0]], time=chord[1])

    midi.write("progression.mid")
    return(len(progression_list))


def play_progression_midi(progression_list, tempo):
    length = create_progression_midi(progression_list, tempo)
    pg.init()
    pg.mixer.music.load("progression.mid")
    pg.mixer.music.play()
    time.sleep(length*60/tempo)


if __name__ == "__main__":
    # simply modify the below list and run
    progression = [
            "minor",
            ["minor", "tonic", 0],
            ["major", "mediant", 0],
            ["major", "submediant", 0],
            ["major", "mediant", 0]
    ]

    tempo = 40
    play_progression_midi(progression, tempo)
