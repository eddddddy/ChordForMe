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

    private Key keyOfC = new Key("C");
    private Key keyOfG = new Key("G");
    private Key keyOfD = new Key("D");
    private Key keyOfA = new Key("A");
    private Key keyOfE = new Key("E");
    private Key keyOfB = new Key("B");
    private Key keyOfFsharp = new Key("F#");
    private Key keyOfCsharp = new Key("C#");
    private Key keyOfF = new Key("F");
    private Key keyOfBflat = new Key("Bb");
    private Key keyOfEflat = new Key("Eb");
    private Key keyOfAflat = new Key("Ab");
    private Key keyOfDflat = new Key("Db");
    private Key keyOfGflat = new Key("Gb");
    private Key keyOfCflat = new Key("Cb");

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
                return new String[] {};
            }

        }

        // never call this either
        public String[] getKeyedProgression(String tonic) {

            if (numOfChords == 1) {
                return new String[] {
                        translateFromTonic(tonic, first)};
            } else if (numOfChords == 2) {
                return new String[] {
                        translateFromTonic(tonic, first),
                        translateFromTonic(tonic, second)};
            } else if (numOfChords == 3) {
                return new String[] {
                        translateFromTonic(tonic, first),
                        translateFromTonic(tonic, second),
                        translateFromTonic(tonic, third)};
            } else if (numOfChords == 4) {
                return new String[] {
                        translateFromTonic(tonic, first),
                        translateFromTonic(tonic, second),
                        translateFromTonic(tonic, third),
                        translateFromTonic(tonic, fourth)};
            } else if (numOfChords == 5) {
                return new String[] {
                        translateFromTonic(tonic, first),
                        translateFromTonic(tonic, second),
                        translateFromTonic(tonic, third),
                        translateFromTonic(tonic, fourth),
                        translateFromTonic(tonic, fifth)};
            } else if (numOfChords == 6) {
                return new String[] {
                        translateFromTonic(tonic, first),
                        translateFromTonic(tonic, second),
                        translateFromTonic(tonic, third),
                        translateFromTonic(tonic, fourth),
                        translateFromTonic(tonic, fifth),
                        translateFromTonic(tonic, sixth)};
            } else if (numOfChords == 7) {
                return new String[] {
                        translateFromTonic(tonic, first),
                        translateFromTonic(tonic, second),
                        translateFromTonic(tonic, third),
                        translateFromTonic(tonic, fourth),
                        translateFromTonic(tonic, fifth),
                        translateFromTonic(tonic, sixth),
                        translateFromTonic(tonic, seventh)};
            }  else if (numOfChords == 8) {
                return new String[] {
                        translateFromTonic(tonic, first),
                        translateFromTonic(tonic, second),
                        translateFromTonic(tonic, third),
                        translateFromTonic(tonic, fourth),
                        translateFromTonic(tonic, fifth),
                        translateFromTonic(tonic, sixth),
                        translateFromTonic(tonic, seventh),
                        translateFromTonic(tonic, eighth)};
            }
            // this will never be called
            else {
                return new String[] {};
            }

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

    // Easier readability; see, I DO care about readability!
    private class Key {

        String key;
        public Key(String key) {
            this.key = key;
        }

        public String tonic() {
            return key;
        }

        public String diminishedSecondAboveTonic() {

            if (key.equals("C")) {return "Dbb";}
            else if (key.equals("C#")) {return "Dnb";}
            else if (key.equals("Db")) {return "Ebbb";}
            else if (key.equals("D")) {return "Ebb";}
            else if (key.equals("Eb")) {return "Fbb";}
            else if (key.equals("E")) {return "Fnb";}
            else if (key.equals("F")) {return "Gbb";}
            else if (key.equals("F#")) {return "Gnb";}
            else if (key.equals("Gb")) {return "Abbb";}
            else if (key.equals("G")) {return "Abb";}
            else if (key.equals("Ab")) {return "Bbbb";}
            else if (key.equals("A")) {return "Bbb";}
            else if (key.equals("Bb")) {return "Cbb";}
            else if (key.equals("B")) {return "Cnb";}
            else if (key.equals("Cb")) {return "Dbbb";}
            // will never get here
            else {return "";}

        }

        public String minorSecondAboveTonic() {

            if (key.equals("C")) {return "Db";}
            else if (key.equals("C#")) {return "Dn";}
            else if (key.equals("Db")) {return "Ebb";}
            else if (key.equals("D")) {return "Eb";}
            else if (key.equals("Eb")) {return "Fb";}
            else if (key.equals("E")) {return "Fn";}
            else if (key.equals("F")) {return "Gb";}
            else if (key.equals("F#")) {return "Gn";}
            else if (key.equals("Gb")) {return "Abb";}
            else if (key.equals("G")) {return "Ab";}
            else if (key.equals("Ab")) {return "Bbb";}
            else if (key.equals("A")) {return "Bb";}
            else if (key.equals("Bb")) {return "Cb";}
            else if (key.equals("B")) {return "Cn";}
            else if (key.equals("Cb")) {return "Dbb";}
            // will never get here
            else {return "";}

        }

        public String majorSecondAboveTonic() {

            if (key.equals("C")) {return "D";}
            else if (key.equals("C#")) {return "D#";}
            else if (key.equals("Db")) {return "Eb";}
            else if (key.equals("D")) {return "E";}
            else if (key.equals("Eb")) {return "F";}
            else if (key.equals("E")) {return "F#";}
            else if (key.equals("F")) {return "G";}
            else if (key.equals("F#")) {return "G#";}
            else if (key.equals("Gb")) {return "Ab";}
            else if (key.equals("G")) {return "A";}
            else if (key.equals("Ab")) {return "Bb";}
            else if (key.equals("A")) {return "B";}
            else if (key.equals("Bb")) {return "C";}
            else if (key.equals("B")) {return "C#";}
            else if (key.equals("Cb")) {return "Db";}
            // will never get here
            else {return "";}

        }

        public String augmentedSecondAboveTonic() {

            if (key.equals("C")) {return "D#";}
            else if (key.equals("C#")) {return "Dx";}
            else if (key.equals("Db")) {return "En";}
            else if (key.equals("D")) {return "E#";}
            else if (key.equals("Eb")) {return "F#";}
            else if (key.equals("E")) {return "Fx";}
            else if (key.equals("F")) {return "G#";}
            else if (key.equals("F#")) {return "Gx";}
            else if (key.equals("Gb")) {return "An";}
            else if (key.equals("G")) {return "A#";}
            else if (key.equals("Ab")) {return "Bn";}
            else if (key.equals("A")) {return "B#";}
            else if (key.equals("Bb")) {return "C#";}
            else if (key.equals("B")) {return "Cx";}
            else if (key.equals("Cb")) {return "Dn";}
            // will never get here
            else {return "";}

        }

        public String diminishedThirdAboveTonic() {

            if (key.equals("C")) {return "Ebb";}
            else if (key.equals("C#")) {return "Enb";}
            else if (key.equals("Db")) {return "Fbb";}
            else if (key.equals("D")) {return "Fnb";}
            else if (key.equals("Eb")) {return "Gbb";}
            else if (key.equals("E")) {return "Gnb";}
            else if (key.equals("F")) {return "Abb";}
            else if (key.equals("F#")) {return "Anb";}
            else if (key.equals("Gb")) {return "Bbbb";}
            else if (key.equals("G")) {return "Bbb";}
            else if (key.equals("Ab")) {return "Cbb";}
            else if (key.equals("A")) {return "Cnb";}
            else if (key.equals("Bb")) {return "Dbb";}
            else if (key.equals("B")) {return "Dnb";}
            else if (key.equals("Cb")) {return "Ebbb";}
            // will never get here
            else {return "";}

        }

        public String minorThirdAboveTonic() {

            if (key.equals("C")) {return "Eb";}
            else if (key.equals("C#")) {return "En";}
            else if (key.equals("Db")) {return "Fb";}
            else if (key.equals("D")) {return "Fn";}
            else if (key.equals("Eb")) {return "Gb";}
            else if (key.equals("E")) {return "Gn";}
            else if (key.equals("F")) {return "Ab";}
            else if (key.equals("F#")) {return "An";}
            else if (key.equals("Gb")) {return "Bbb";}
            else if (key.equals("G")) {return "Bb";}
            else if (key.equals("Ab")) {return "Cb";}
            else if (key.equals("A")) {return "Cn";}
            else if (key.equals("Bb")) {return "Db";}
            else if (key.equals("B")) {return "Dn";}
            else if (key.equals("Cb")) {return "Ebb";}
            // will never get here
            else {return "";}

        }

        public String majorThirdAboveTonic() {

            if (key.equals("C")) {return "E";}
            else if (key.equals("C#")) {return "E#";}
            else if (key.equals("Db")) {return "F";}
            else if (key.equals("D")) {return "F#";}
            else if (key.equals("Eb")) {return "G";}
            else if (key.equals("E")) {return "G#";}
            else if (key.equals("F")) {return "A";}
            else if (key.equals("F#")) {return "A#";}
            else if (key.equals("Gb")) {return "Bb";}
            else if (key.equals("G")) {return "B";}
            else if (key.equals("Ab")) {return "C";}
            else if (key.equals("A")) {return "C#";}
            else if (key.equals("Bb")) {return "D";}
            else if (key.equals("B")) {return "D#";}
            else if (key.equals("Cb")) {return "Eb";}
            // will never get here
            else {return "";}

        }

        public String augmentedThirdAboveTonic() {

            if (key.equals("C")) {return "E#";}
            else if (key.equals("C#")) {return "Ex";}
            else if (key.equals("Db")) {return "F#";}
            else if (key.equals("D")) {return "Fx";}
            else if (key.equals("Eb")) {return "G#";}
            else if (key.equals("E")) {return "Gx";}
            else if (key.equals("F")) {return "A#";}
            else if (key.equals("F#")) {return "Ax";}
            else if (key.equals("Gb")) {return "Bn";}
            else if (key.equals("G")) {return "B#";}
            else if (key.equals("Ab")) {return "C#";}
            else if (key.equals("A")) {return "Cx";}
            else if (key.equals("Bb")) {return "D#";}
            else if (key.equals("B")) {return "Dx";}
            else if (key.equals("Cb")) {return "En";}
            // will never get here
            else {return "";}

        }

    }

    private void findKeyInterval() {
        keyInterval = (notes.indexOf(endKey) - notes.indexOf(startKey) + 12) % 12;
    }

}
