package com.example.edward.chordforme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChordLibrary {

    private ArrayList<String> sortedNotes;
    private String chordClassificationScheme;
    private String key;
    private List<String> notes = Arrays.asList("C","C#","D","D#","E","F","F#","G","G#","A","A#","B");

    private String chordName;

    /*

          Chord      |      chordName if abs      |      chordName if key and C      |      chordName if key and E
    --------------------------------------------------------------------------------------------------------------------
          C E G      |            C/C             |               I0                 |               vi0
    --------------------------------------------------------------------------------------------------------------------
          C G E      |            C/C             |               I0                 |               vi0
    --------------------------------------------------------------------------------------------------------------------
          E G C      |            C/E             |               I1                 |               vi1
    --------------------------------------------------------------------------------------------------------------------
          E C G      |            C/E             |               I1                 |               vi1
    --------------------------------------------------------------------------------------------------------------------
          G C E      |            C/G             |               I2                 |               vi2
    --------------------------------------------------------------------------------------------------------------------
          G E C      |            C/G             |               I2                 |               vi2
    --------------------------------------------------------------------------------------------------------------------
          A C E      |            Am/A            |               VI0                |               IV0
    --------------------------------------------------------------------------------------------------------------------
          A E C      |            Am/A            |               VI0                |               IV0
    --------------------------------------------------------------------------------------------------------------------
          C E A      |            Am/C            |               VI1                |               IV1
    --------------------------------------------------------------------------------------------------------------------
          C A E      |            Am/C            |               VI1                |               IV1
    --------------------------------------------------------------------------------------------------------------------
          E A C      |            Am/E            |               VI2                |               IV2
    --------------------------------------------------------------------------------------------------------------------
          E C A      |            Am/E            |               VI2                |               IV2
    --------------------------------------------------------------------------------------------------------------------


    */

    public ChordLibrary(ArrayList<String> sortedNotes) {
        this.sortedNotes = sortedNotes;
        this.chordClassificationScheme = "abs";

        trim();
        findChord();
    }

    public ChordLibrary(ArrayList<String> sortedNotes, String key) {
        this.sortedNotes = sortedNotes;
        this.chordClassificationScheme = "key";
        this.key = key;

        trim();
        findChord();
    }

    // removes the octaves from sortedNotes
    private void trim() {
        for (int i = 0; i < sortedNotes.size(); i++) {
            String currentNote = sortedNotes.get(i);
            sortedNotes.set(i,currentNote.substring(0,currentNote.length()-1));
        }
    }

    // the main method for this class; any new chords should be implemented here (the logic is straightforward)
    private void findChord() {

        // TODO: add key elifs
        // 3 notes in chord
        if (sortedNotes.size() == 3) {

            int interval1 = (notes.indexOf(sortedNotes.get(1)) - notes.indexOf(sortedNotes.get(0)) + 12) % 12;
            int interval2 = (notes.indexOf(sortedNotes.get(2)) - notes.indexOf(sortedNotes.get(0)) + 12) % 12;

            // major chord in proper root position (ex. C E G)
            if ((interval1 == 4) && (interval2 == 7)) {
                if (chordClassificationScheme == "abs") {
                    chordName = sortedNotes.get(0) + "/" + sortedNotes.get(0);
                }
            }
            // major chord in improper root position (ex. C G E)
            else if ((interval1 == 7) && (interval2 == 4)) {
                if (chordClassificationScheme == "abs") {
                    chordName = sortedNotes.get(0) + "/" + sortedNotes.get(0);
                }
            }
            // major chord in proper first inversion (ex. E G C)
            else if ((interval1 == 3) && (interval2 == 8)) {
                if (chordClassificationScheme == "abs") {
                    chordName = sortedNotes.get(2) + "/" + sortedNotes.get(0);
                }
            }
            // major chord in improper first inversion (ex. E C G)
            else if ((interval1 == 8) && (interval2 == 3)) {
                if (chordClassificationScheme == "abs") {
                    chordName = sortedNotes.get(1) + "/" + sortedNotes.get(0);
                }
            }
            // major chord in proper second inversion (ex. G C E)
            else if ((interval1 == 5) && (interval2 == 9)) {
                if (chordClassificationScheme == "abs") {
                    chordName = sortedNotes.get(1) + "/" + sortedNotes.get(0);
                }
            }
            // major chord in improper second inversion (ex. G E C)
            else if ((interval1 == 9) && (interval2 == 5)) {
                if (chordClassificationScheme == "abs") {
                    chordName = sortedNotes.get(2) + "/" + sortedNotes.get(0);
                }
            }
            // minor chord in proper root position (ex. A C E)
            else if ((interval1 == 3) && (interval2 == 7)) {
                if (chordClassificationScheme == "abs") {
                    chordName = sortedNotes.get(0) + "m/" + sortedNotes.get(0);
                }
            }
            // minor chord in improper root position (ex. A E C)
            else if ((interval1 == 7) && (interval2 == 3)) {
                if (chordClassificationScheme == "abs") {
                    chordName = sortedNotes.get(0) + "m/" + sortedNotes.get(0);
                }
            }
            // minor chord in proper first inversion (ex. C E A)
            else if ((interval1 == 4) && (interval2 == 9)) {
                if (chordClassificationScheme == "abs") {
                    chordName = sortedNotes.get(2) + "m/" + sortedNotes.get(0);
                }
            }
            // minor chord in improper first inversion (ex. C A E)
            else if ((interval1 == 9) && (interval2 == 4)) {
                if (chordClassificationScheme == "abs") {
                    chordName = sortedNotes.get(1) + "m/" + sortedNotes.get(0);
                }
            }
            // minor chord in proper second inversion (ex. E A C)
            else if ((interval1 == 5) && (interval2 == 8)) {
                if (chordClassificationScheme == "abs") {
                    chordName = sortedNotes.get(1) + "m/" + sortedNotes.get(0);
                }
            }
            // minor chord in improper second inversion (ex. E C A)
            else if ((interval1 == 8) && (interval2 == 5)) {
                if (chordClassificationScheme == "abs") {
                    chordName = sortedNotes.get(2) + "m/" + sortedNotes.get(0);
                }
            }
        }

    }

    public String getChordName() {
        return chordName;
    }

}
