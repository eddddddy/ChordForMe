package com.example.edward.chordforme;

import java.util.Arrays;
import java.util.List;

// This is where the magic happens

public class ProgressionLibrary {

    private String startKey;
    private String endKey;
    private String startChord;
    private String endChord;
    private int keyInterval;
    private List<String> notes = Arrays.asList("C","C#","D","D#","E","F","F#","G","G#","A","A#","B");

    /**
     * Like the ChordLibrary class, the Roman numerals represent an interval above the tonic.
     *
     * This list is still small; progressions should be added here when they are found. So far, it only
     * contains major to major key modulations.
     *
     * Sources:
     * [1] http://www.kevinboone.net/modulation_library.html
     *
    **/

    // TODO: add minor keys
    private List<List<Progression>> modulations = Arrays.asList(
            // identity modulation
            Arrays.asList(
                    new Progression("I0")
            ),
            // modulation up a minor second
            Arrays.asList(
                    new Progression("I0","II0","vi72","ii0")
            ),
            // modulation up a major second
            Arrays.asList(
                    new Progression("I0","I1","VI0","II0")
            ),
            // modulation up a minor third
            Arrays.asList(
                    new Progression("I0","I1","IV1","vii70","iii0")
            ),
            // modulation up a major third
            Arrays.asList(
                    new Progression("I0","I1","VII73","III0")
            ),
            // modulation up a perfect fourth
            Arrays.asList(
                    // from [1]
                    new Progression("I0","I1","I72","IV0"),
                    new Progression("I0","I1","Vm0","I72","IV0"),
                    new Progression("I0","I1","V70","I70","IV0"),
                    new Progression("I0","I1","ii1","I70","IV0"),
                    new Progression("I0","I1","ii70","I70","IV0"),
                    new Progression("I0","I1","IVm1","I71","IV0")
            ),
            // modulation up a diminished fifth / augmented fourth
            Arrays.asList(
                    // from [1]
                    new Progression("I0","II70","v2","ii70","v0"),
                    new Progression("I0","I1","ii1","ii70","v0"),
                    new Progression("I0","I1","ii70","v0")
            ),
            // modulation up a perfect fifth
            Arrays.asList(
                    // from [1]
                    new Progression("I0","II70","V0"),
                    new Progression("I0","I1","Im1","IIs40","II0","V0"),
                    new Progression("I0","I1","IV0","II71","V0"),
                    new Progression("I0","vi0","II1","II71","V0"),
                    new Progression("I0","I1","vi70","V0")
            ),
            // modulation up a minor sixth
            Arrays.asList(
                    new Progression("I0","iii70","vi0")
            ),
            // modulation up a major sixth
            Arrays.asList(
                    new Progression("I0","I1","V70","III70","VI2","VI0")
            ),
            // modulation up a minor seventh
            Arrays.asList(
                    new Progression("I0","V0","I2","IV70","IV73","vii1","vii0")
            ),
            // modulation up a major seventh
            Arrays.asList(
                    new Progression("I0","ii0","v70","VII0")
            )
    );

    public ProgressionLibrary(String start, String end, int type) {

        if (type == 0) {
            this.startKey = start;
            this.endKey = end;
        } else if (type == 1) {
            this.startChord = start;
            this.endChord = end;
        }

    }

    private class Progression {

        int numOfChords;
        String first;
        String second;
        String third;
        String fourth;
        String fifth;
        String sixth;
        String seventh;
        String eighth;

        public Progression(String first) {

            this.first = first;
            this.numOfChords = 1;

        }

        public Progression(String first, String second) {

            this.first = first;
            this.second = second;
            this.numOfChords = 2;

        }

        public Progression(String first, String second, String third) {

            this.first = first;
            this.second = second;
            this.third = third;
            this.numOfChords = 3;

        }

        public Progression(String first, String second, String third, String fourth) {

            this.first = first;
            this.second = second;
            this.third = third;
            this.fourth = fourth;
            this.numOfChords = 4;

        }

        public Progression(String first, String second, String third, String fourth, String fifth) {

            this.first = first;
            this.second = second;
            this.third = third;
            this.fourth = fourth;
            this.fifth = fifth;
            this.numOfChords = 5;

        }

        public Progression(String first, String second, String third, String fourth, String fifth, String sixth) {

            this.first = first;
            this.second = second;
            this.third = third;
            this.fourth = fourth;
            this.fifth = fifth;
            this.sixth = sixth;
            this.numOfChords = 6;

        }

        public Progression(String first, String second, String third, String fourth, String fifth, String sixth, String seventh) {

            this.first = first;
            this.second = second;
            this.third = third;
            this.fourth = fourth;
            this.fifth = fifth;
            this.sixth = sixth;
            this.seventh = seventh;
            this.numOfChords = 7;

        }

        public Progression(String first, String second, String third, String fourth, String fifth, String sixth, String seventh, String eighth) {

            this.first = first;
            this.second = second;
            this.third = third;
            this.fourth = fourth;
            this.fifth = fifth;
            this.sixth = sixth;
            this.seventh = seventh;
            this.eighth = eighth;
            this.numOfChords = 8;

        }

        // never call this; the memory is better used elsewhere
        public String[] getProgression() {

            if (numOfChords == 1) {
                return new String[] {first};
            } else if (numOfChords == 2) {
                return new String[] {first, second};
            } else if (numOfChords == 3) {
                return new String[] {first, second, third};
            } else if (numOfChords == 4) {
                return new String[] {first, second, third, fourth};
            } else if (numOfChords == 5) {
                return new String[] {first, second, third, fourth, fifth};
            } else if (numOfChords == 6) {
                return new String[] {first, second, third, fourth, fifth, sixth};
            } else if (numOfChords == 7) {
                return new String[] {first, second, third, fourth, fifth, sixth, seventh};
            } else if (numOfChords == 8) {
                return new String[] {first, second, third, fourth, fifth, sixth, seventh, eighth};
            }
            // this will never be called
            else {
                return new String[]{};
            }

        }

        // never call this either
        public List<String> getKeyedProgression(String tonic) {

        }

        // converts a chord built on an interval above a particular tonic note to a chord built on a key (ex. A, v70 -> D#70)
        private String translateFromTonic(String tonic, String chord) {

            List<String> numerals = Arrays.asList("I","ii","II","iii","III","IV","v","V","vi","VI","vii","VII");
            String chordRoot;
            String otherStuff;

            if (!(chord.substring(1,2).equals("i") || chord.substring(1,2).equals("I") || chord.substring(1,2).equals("v") || chord.substring(1,2).equals("V"))) {
                chordRoot = chord.substring(0,1);
                otherStuff = chord.substring(1);
            } else if (!(chord.substring(2,3).equals("i") || chord.substring(2,3).equals("I") || chord.substring(2,3).equals("v") || chord.substring(2,3).equals("V"))){
                chordRoot = chord.substring(0,2);
                otherStuff = chord.substring(2);
            } else {
                chordRoot = chord.substring(0,3);
                otherStuff = chord.substring(3);
            }

            return notes.get((notes.indexOf(tonic) + numerals.indexOf(chordRoot)) % 12) + otherStuff;

        }

    }

    private void findKeyInterval() {
        keyInterval = (notes.indexOf(endKey) - notes.indexOf(startKey) + 12) % 12;
    }

}
