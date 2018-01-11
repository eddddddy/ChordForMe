package com.example.edward.chordforme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ChordLibrary {

    private ArrayList<String> sortedNotes;
    private String chordClassificationScheme;
    private String key;
    private List<String> notes = Arrays.asList("C","C#","D","D#","E","F","F#","G","G#","A","A#","B");
    private HashMap<String,String> enharmonics = new HashMap<String,String>() {{
        put("C","B#");put("C#","Db");put("D","D");put("D#","Eb");put("E","Fb");put("F","E#");
        put("F#","Gb");put("G","G");put("G#","Ab");put("A","A");put("A#","Bb");put("B","Cb");
    }};
    private HashMap<String,Integer> majorKeySignatures = new HashMap<String,Integer>() {{
        put("C",0);put("C#",7);put("Db",5);put("D",2);put("D#",9);put("Eb",3);put("E",4);put("Fb",8);put("E#",11);put("F",1);put("F#",6);
        put("Gb",6);put("G",1);put("G#",8);put("Ab",4);put("A",3);put("A#",10);put("Bb",2);put("B",5);put("Cb",7);put("B#",12);put("H",99);
    }};
    private HashMap<String,Integer> minorKeySignatures = new HashMap<String,Integer>() {{
        put("C",3);put("C#",4);put("Db",8);put("D",1);put("D#",6);put("Eb",6);put("E",1);put("Fb",11);put("F",4);put("E#",8);put("F#",3);
        put("Gb",9);put("G",2);put("G#",5);put("Ab",7);put("A",0);put("A#",7);put("Bb",5);put("B",2);put("Cb",10);put("B#",9);put("H",99);
    }};
    private String chordName;

    /*

    Despite convention, the capitalization of the Roman numerals in the key forms represent the interval from the tonic, not the chord type. For example, iii0
    denotes a major chord built on the note a minor third above the tonic (Eb if C), not a minor chord built on the note a major third above the tonic. And Vm0
    denotes a minor chord build on the note a perfect fifth above the tonic (G if C).

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
    |        or       |            Am/A            |              VIm0                |              IVm0                |                0                 |      |  minor root position
    |      A E C      |                            |                                  |                                  |                                  |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|     ---
    |      C E A      |            Am/C            |              VIm1                |              IVm1                |                2                 |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|      |  minor first inversion
    |      C A E      |            Am/C            |              VIm1                |              IVm1                |                1                 |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|     ---
    |      E A C      |            Am/E            |              VIm2                |              IVm2                |                1                 |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|      |  minor second inversion
    |      E C A      |            Am/E            |              VIm2                |              IVm2                |                2                 |      |
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
    |      D F# A#    |           Daug/D           |              IIaug0              |             viiaug0              |                0                 |      |  augmented (always root position)
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|     ---
    |      F G# B     |                            |                                  |                                  |                                  |      |
    |        or       |           Fdim/F           |              IVdim0              |              iidim0              |                0                 |      |  diminished root position
    |      F B G#     |                            |                                  |                                  |                                  |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|     ---
    |      G# B F     |          Fdim/Ab           |              IVdim1              |              iidim1              |                2                 |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|      |  diminished first inversion
    |      G# F B     |          Fdim/Ab           |              IVdim1              |              iidim1              |                1                 |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|     ---
    |      B F G#     |          Fdim/B            |              IVdim2              |              iidim2              |                1                 |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|      |  diminished second inversion
    |      B G# F     |          Fdim/B            |              IVdim2              |              iidim2              |                2                 |      |
    |-----------------|----------------------------|----------------------------------|----------------------------------|----------------------------------|     ---


    */

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

    // produces whichever enharmonic chord is more common
    private String enharmonize(String rootNote, String chordType) {

        String rootNoteEnharmonic = enharmonics.get(rootNote);

        if (chordType.equals("major")) {
            if (majorKeySignatures.get(rootNote) <= majorKeySignatures.get(rootNoteEnharmonic)) {
                return rootNote;
            } else {
                return rootNoteEnharmonic;
            }
        } else if (chordType.equals("minor")) {
            if (minorKeySignatures.get(rootNote) <= minorKeySignatures.get(rootNoteEnharmonic)) {
                return rootNote;
            } else {
                return rootNoteEnharmonic;
            }
        } else {
            return rootNote;
        }

    }

    // the main method for this class; any new chords should be implemented here (the logic is straightforward)
    // might need additional processing to meet user's preferences (flats or sharps, etc.)
    private void findChord() {

        // TODO: add key elifs
        // 3 notes in chord
        if (sortedNotes.size() == 3) {

            int interval1 = (notes.indexOf(sortedNotes.get(1)) - notes.indexOf(sortedNotes.get(0)) + 12) % 12;
            int interval2 = (notes.indexOf(sortedNotes.get(2)) - notes.indexOf(sortedNotes.get(0)) + 12) % 12;

            // major chord in proper or improper root position (ex. C E G) (ex. C G E)
            if (((interval1 == 4) && (interval2 == 7)) || ((interval1 == 7) && (interval2 == 4))) {
                if (chordClassificationScheme.equals("abs")) {
                    chordName = sortedNotes.get(0) + "/" + sortedNotes.get(0);
                }
            }
            // major chord in proper first inversion (ex. E G C)
            else if ((interval1 == 3) && (interval2 == 8)) {
                if (chordClassificationScheme.equals("abs")) {
                    chordName = sortedNotes.get(2) + "/" + sortedNotes.get(0);
                }
            }
            // major chord in improper first inversion (ex. E C G)
            else if ((interval1 == 8) && (interval2 == 3)) {
                if (chordClassificationScheme.equals("abs")) {
                    chordName = sortedNotes.get(1) + "/" + sortedNotes.get(0);
                }
            }
            // major chord in proper second inversion (ex. G C E)
            else if ((interval1 == 5) && (interval2 == 9)) {
                if (chordClassificationScheme.equals("abs")) {
                    chordName = sortedNotes.get(1) + "/" + sortedNotes.get(0);
                }
            }
            // major chord in improper second inversion (ex. G E C)
            else if ((interval1 == 9) && (interval2 == 5)) {
                if (chordClassificationScheme.equals("abs")) {
                    chordName = sortedNotes.get(2) + "/" + sortedNotes.get(0);
                }
            }
            // minor chord in proper or improper root position (ex. A C E) (ex. A E C)
            else if (((interval1 == 3) && (interval2 == 7)) || ((interval1 == 7) && (interval2 == 3))) {
                if (chordClassificationScheme.equals("abs")) {
                    chordName = sortedNotes.get(0) + "m/" + sortedNotes.get(0);
                }
            }
            // minor chord in proper first inversion (ex. C E A)
            else if ((interval1 == 4) && (interval2 == 9)) {
                if (chordClassificationScheme.equals("abs")) {
                    chordName = sortedNotes.get(2) + "m/" + sortedNotes.get(0);
                }
            }
            // minor chord in improper first inversion (ex. C A E)
            else if ((interval1 == 9) && (interval2 == 4)) {
                if (chordClassificationScheme.equals("abs")) {
                    chordName = sortedNotes.get(1) + "m/" + sortedNotes.get(0);
                }
            }
            // minor chord in proper second inversion (ex. E A C)
            else if ((interval1 == 5) && (interval2 == 8)) {
                if (chordClassificationScheme.equals("abs")) {
                    chordName = sortedNotes.get(1) + "m/" + sortedNotes.get(0);
                }
            }
            // minor chord in improper second inversion (ex. E C A)
            else if ((interval1 == 8) && (interval2 == 5)) {
                if (chordClassificationScheme.equals("abs")) {
                    chordName = sortedNotes.get(2) + "m/" + sortedNotes.get(0);
                }
            }
            // augmented triad (ex. D F# A#)
            else if ((interval1 == 4) && (interval2 == 8)) {
                if (chordClassificationScheme.equals("abs")) {
                    chordName = sortedNotes.get(0) + "aug/" + sortedNotes.get(0);
                }
            }

        }
        // 4 notes in chord
        else if (sortedNotes.size() == 4) {

            int interval1 = (notes.indexOf(sortedNotes.get(1)) - notes.indexOf(sortedNotes.get(0)) + 12) % 12;
            int interval2 = (notes.indexOf(sortedNotes.get(2)) - notes.indexOf(sortedNotes.get(0)) + 12) % 12;
            int interval3 = (notes.indexOf(sortedNotes.get(3)) - notes.indexOf(sortedNotes.get(0)) + 12) % 12;

            // dominant 7th chord in root position (ex. D# G A# C#) (ex. D# G C# A#) (ex. D# A# G C#) (ex. D# A# C# G) (ex. D# C# G A#) (ex. D# C# A# G)
            if (((interval1 == 4) && (interval2 == 7) && (interval3 == 10)) ||
                    ((interval1 == 4) && (interval2 == 10) && (interval3 == 7)) ||
                    ((interval1 == 7) && (interval2 == 4) && (interval3 == 10)) ||
                    ((interval1 == 7) && (interval2 == 10) && (interval3 == 4)) ||
                    ((interval1 == 10) && (interval2 == 4) && (interval3 == 7)) ||
                    ((interval1 == 10) && (interval2 == 7) && (interval3 == 4))) {
                if (chordClassificationScheme.equals("abs")) {
                    chordName = sortedNotes.get(0) + "7/" + sortedNotes.get(0);
                }
            }
            // dominant 7th chord in type one first inversion (ex. G A# C# D#) (ex. G C# A# D#)
            else if (((interval1 == 3) && (interval2 == 6) && (interval3 == 8)) ||
                    ((interval1 == 6) && (interval2 == 3) && (interval3 == 8))) {
                if (chordClassificationScheme.equals("abs")) {
                    chordName = sortedNotes.get(3) + "7/" + sortedNotes.get(0);
                }
            }
            // dominant 7th chord in type two first inversion (ex. G A# D# C#) (ex. G C# D# A#)
            else if (((interval1 == 3) && (interval2 == 8) && (interval3 == 6)) ||
                    ((interval1 == 6) && (interval2 == 8) && (interval3 == 3))) {
                if (chordClassificationScheme.equals("abs")) {
                    chordName = sortedNotes.get(2) + "7/" + sortedNotes.get(0);
                }
            }
            // dominant 7th chord in type three first inversion (ex. G D# A# C#) (ex. G D# C# A#)
            else if (((interval1 == 8) && (interval2 == 3) && (interval3 == 6)) ||
                    ((interval1 == 8) && (interval2 == 6) && (interval3 == 3))) {
                if (chordClassificationScheme.equals("abs")) {
                    chordName = sortedNotes.get(1) + "7/" + sortedNotes.get(0);
                }
            }
            // dominant 7th chord in type one second inversion (ex. A# C# D# G) (ex. A# G D# C#)
            else if (((interval1 == 3) && (interval2 == 5) && (interval3 == 9)) ||
                    ((interval1 == 9) && (interval2 == 5) && (interval3 == 3))) {
                if (chordClassificationScheme.equals("abs")) {
                    chordName = sortedNotes.get(2) + "7/" + sortedNotes.get(0);
                }
            }
            // dominant 7th chord in type two second inversion (ex. A# D# C# G) (ex. A# D# G C#)
            else if (((interval1 == 5) && (interval2 == 3) && (interval3 == 9)) ||
                    ((interval1 == 5) && (interval2 == 9) && (interval3 == 3))) {
                if (chordClassificationScheme.equals("abs")) {
                    chordName = sortedNotes.get(1) + "7/" + sortedNotes.get(0);
                }
            }
            // dominant 7th chord in type three second inversion (ex. A# C# G D#) (ex. A# G C# D#)
            else if (((interval1 == 3) && (interval2 == 9) && (interval3 == 5)) ||
                    ((interval1 == 9) && (interval2 == 3) && (interval3 == 5))) {
                if (chordClassificationScheme.equals("abs")) {
                    chordName = sortedNotes.get(3) + "7/" + sortedNotes.get(0);
                }
            }
            // dominant 7th chord in type one third inversion (ex. C# D# G A#) (ex. C# D# A# G)
            else if (((interval1 == 2) && (interval2 == 6) && (interval3 == 9)) ||
                    ((interval1 == 2) && (interval2 == 9) && (interval3 == 6))) {
                if (chordClassificationScheme.equals("abs")) {
                    chordName = sortedNotes.get(1) + "7/" + sortedNotes.get(0);
                }
            }
            // dominant 7th chord in type two third inversion (ex. C# G A# D#) (ex. C# A# G D#)
            else if (((interval1 == 6) && (interval2 == 9) && (interval3 == 2)) ||
                    ((interval1 == 9) && (interval2 == 6) && (interval3 == 2))) {
                if (chordClassificationScheme.equals("abs")) {
                    chordName = sortedNotes.get(3) + "7/" + sortedNotes.get(0);
                }
            }
            // dominant 7th chord in type three third inversion (ex. C# G D# A#) (ex. C# A# D# G)
            else if (((interval1 == 6) && (interval2 == 2) && (interval3 == 9)) ||
                    ((interval1 == 9) && (interval2 == 2) && (interval3 == 6))) {
                if (chordClassificationScheme.equals("abs")) {
                    chordName = sortedNotes.get(2) + "7/" + sortedNotes.get(0);
                }
            }

        }

    }

    public String getChordName() {
        return chordName;
    }

}
