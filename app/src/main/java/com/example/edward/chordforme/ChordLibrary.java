package com.example.edward.chordforme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChordLibrary {

    // Yes, I know these names are vague
    private ArrayList<String> sortedNotes;
    private String chordClassificationScheme;
    private String key;
    private List<String> notes = Arrays.asList("C","C#","D","D#","E","F","F#","G","G#","A","A#","B");

    // current goal: can detect major, minor, and dominant 7ths. This is still very very ambitious
    // ex. "A","C#m","Bd7"
    private String chordName;

    public ChordLibrary(ArrayList<String> sortedNotes) {

        this.sortedNotes = sortedNotes;
        this.chordClassificationScheme = "abs";
        findChord();

    }

    public ChordLibrary(ArrayList<String> sortedNotes, String key) {

        this.sortedNotes = sortedNotes;
        this.chordClassificationScheme = "key";
        this.key = key;
        findChord();

    }

    // the main method for this class; any new chords should be implemented here (the logic is straightforward)
    private void findChord() {

        ArrayList<Integer> noteIDs = new ArrayList<>();

        for (String note : sortedNotes) {
            noteIDs.add(notes.indexOf(note));
        }

        // TODO: add key elifs
        // 3 notes in chord
        if (noteIDs.size() == 3) {

            int note1ID = noteIDs.get(0);
            int note2ID = noteIDs.get(1);
            int note3ID = noteIDs.get(2);

            // major chord in root position (ex. C E G)
            if (((note2ID - note1ID == 4) || (note2ID - note1ID == -8)) && ((note3ID - note1ID == 7) || (note3ID - note1ID == -5))) {
                if (chordClassificationScheme.equals("abs")){
                    chordName = notes.get(note1ID) + "/" + notes.get(note1ID);
                }
            }
            // major chord in root position (ex. C G E)
            else if (((note2ID - note1ID == 7) || (note2ID - note1ID == -5)) && ((note3ID - note1ID == 4) || (note3ID - note1ID == -8))) {
                if (chordClassificationScheme.equals("abs")){
                    chordName = notes.get(note1ID) + "/" + notes.get(note1ID);
                }
            }
            // major chord in first inversion (ex. E G C)
            else if (((note2ID - note1ID == 3) || (note2ID - note1ID == -9)) && ((note3ID - note1ID == -4) || (note3ID - note1ID == 8))) {
                if (chordClassificationScheme.equals("abs")){
                    chordName = notes.get(note3ID) + "/" + notes.get(note1ID);
                }
            }
            // major chord in first inversion (ex. E C G)
            else if (((note2ID - note1ID == -4) || (note2ID - note1ID == 8)) && ((note3ID - note1ID == 3) || (note3ID - note1ID == -9))) {
                if (chordClassificationScheme.equals("abs")){
                    chordName = notes.get(note2ID) + "/" + notes.get(note1ID);
                }
            }
        }

    }

    public String getChordName() {
        return chordName;
    }

}
