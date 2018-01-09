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

    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|
    |      Chord      |      chordName if abs      |      chordName if key and C      |      chordName if key and E      |      Position of Chord Root      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|     ---
    |      C E G      |                            |                                  |                                  |                                  |      |
    |        or       |            C/C             |               I0                 |               vi0                |                0                 |      |  major root position
    |      C G E      |                            |                                  |                                  |                                  |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|     ---
    |      E G C      |            C/E             |               I1                 |               vi1                |                2                 |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|      |  major first inversion
    |      E C G      |            C/E             |               I1                 |               vi1                |                1                 |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|     ---
    |      G C E      |            C/G             |               I2                 |               vi2                |                1                 |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|      |  major second inversion
    |      G E C      |            C/G             |               I2                 |               vi2                |                2                 |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|     ---
    |      A C E      |                            |                                  |                                  |                                  |      |
    |        or       |            Am/A            |               VI0                |               IV0                |                0                 |      |  minor root position
    |      A E C      |                            |                                  |                                  |                                  |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|     ---
    |      C E A      |            Am/C            |               VI1                |               IV1                |                2                 |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|      |  minor first inversion
    |      C A E      |            Am/C            |               VI1                |               IV1                |                1                 |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|     ---
    |      E A C      |            Am/E            |               VI2                |               IV2                |                1                 |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|      |  minor second inversion
    |      E C A      |            Am/E            |               VI2                |               IV2                |                2                 |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|     ---
    |    D# G A# C#   |                            |                                  |                                  |                                  |      |
    |        or       |                            |                                  |                                  |                                  |      |
    |    D# G C# A#   |                            |                                  |                                  |                                  |      |
    |        or       |                            |                                  |                                  |                                  |      |
    |    D# A# G C#   |                            |                                  |                                  |                                  |      |
    |        or       |           Eb7/Eb           |              iii70               |              VII70               |                0                 |      |  dominant 7th root position
    |    D# A# C# G   |                            |                                  |                                  |                                  |      |
    |        or       |                            |                                  |                                  |                                  |      |
    |    D# C# G A#   |                            |                                  |                                  |                                  |      |
    |        or       |                            |                                  |                                  |                                  |      |
    |    D# C# A# G   |                            |                                  |                                  |                                  |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|     ---
    |    G A# C# D#   |                            |                                  |                                  |                                  |      |
    |        or       |           Eb7/G            |              iii71               |              VII71               |                3                 |      |
    |    G C# A# D#   |                            |                                  |                                  |                                  |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|      |
    |    G A# D# C#   |                            |                                  |                                  |                                  |      |
    |        or       |           Eb7/G            |              iii71               |              VII71               |                2                 |      |  dominant 7th first inversion
    |    G C# D# A#   |                            |                                  |                                  |                                  |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|      |
    |    G D# A# C#   |                            |                                  |                                  |                                  |      |
    |        or       |           Eb7/G            |              iii71               |              VII71               |                1                 |      |
    |    G D# C# A#   |                            |                                  |                                  |                                  |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|     ---
    |    A# C# D# G   |                            |                                  |                                  |                                  |      |
    |        or       |           Eb7/Bb           |              iii72               |              VII72               |                2                 |      |
    |    A# G D# C#   |                            |                                  |                                  |                                  |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|      |
    |    A# D# C# G   |                            |                                  |                                  |                                  |      |
    |        or       |           Eb7/Bb           |              iii72               |              VII72               |                1                 |      |  dominant 7th second inversion
    |    A# D# G C#   |                            |                                  |                                  |                                  |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|      |
    |    A# C# G D#   |                            |                                  |                                  |                                  |      |
    |        or       |           Eb7/Bb           |              iii72               |              VII72               |                3                 |      |
    |    A# G C# D#   |                            |                                  |                                  |                                  |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|     ---
    |    C# D# G A#   |                            |                                  |                                  |                                  |      |
    |        or       |           Eb7/Db           |              iii73               |              VII73               |                1                 |      |
    |    C# D# A# G   |                            |                                  |                                  |                                  |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|      |
    |    C# G A# D#   |                            |                                  |                                  |                                  |      |
    |        or       |           Eb7/Db           |              iii73               |              VII73               |                3                 |      |  dominant 7th third inversion
    |    C# A# G D#   |                            |                                  |                                  |                                  |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|      |
    |    C# G D# A#   |                            |                                  |                                  |                                  |      |
    |        or       |           Eb7/Db           |              iii73               |              VII73               |                2                 |      |
    |    C# A# D# G   |                            |                                  |                                  |                                  |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|     ---


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

            // major chord in proper or improper root position (ex. C E G) (ex. C G E)
            if (((interval1 == 4) && (interval2 == 7)) || ((interval1 == 7) && (interval2 == 4))) {
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
            // minor chord in proper or improper root position (ex. A C E) (ex. A E C)
            else if (((interval1 == 3) && (interval2 == 7)) || ((interval1 == 7) && (interval2 == 3))) {
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
        // 4 notes in chord
        else if (sortedNotes.size() == 4) {

            int interval1 = (notes.indexOf(sortedNotes.get(1)) - notes.indexOf(sortedNotes.get(0)) + 12) % 12;
            int interval2 = (notes.indexOf(sortedNotes.get(2)) - notes.indexOf(sortedNotes.get(0)) + 12) % 12;
            int interval3 = (notes.indexOf(sortedNotes.get(3)) - notes.indexOf(sortedNotes.get(0)) + 12) % 12;

            // dominant 7th chord in root position

        }

    }

    public String getChordName() {
        return chordName;
    }

}
