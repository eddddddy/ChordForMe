package com.example.edward.chordforme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ProgressionLibrary {

    // Order of sharps: F# C# G# D# A# E# B# Fx Cx Gx Dx Ax Ex Bx
    // Order of flats: Bb Eb Ab Db Gb Cb Fb Bbb Ebb Abb Dbb Gbb Cbb Fbb
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
    private Key keyOfAm = new Key("Am");
    private Key keyOfEm = new Key("Em");
    private Key keyOfBm = new Key("Bm");
    private Key keyOfFsharpm = new Key("F#m");
    private Key keyOfCsharpm = new Key("C#m");
    private Key keyOfGsharpm = new Key("G#m");
    private Key keyOfDsharpm = new Key("D#m");
    private Key keyOfAsharpm = new Key("A#m");
    private Key keyOfDm = new Key("Dm");
    private Key keyOfGm = new Key("Gm");
    private Key keyOfCm = new Key("Cm");
    private Key keyOfFm = new Key("Fm");
    private Key keyOfBflatm = new Key("Bbm");
    private Key keyOfEflatm = new Key("Ebm");
    private Key keyOfAflatm = new Key("Abm");

    // TODO: add minor keys
    private List<Progression> generalProgressions = Arrays.asList(
            new Progression(
                    new Chord("major", "tonic", 0),
                    new Chord("major", "subdominant", 2),
                    new Chord("dominantSeventh", "dominant", 1),
                    new Chord("major", "tonic", 0))
    );

    public ProgressionLibrary() {

    }

    private class Progression {

        int numOfChords;
        Chord first;
        Chord second;
        Chord third;
        Chord fourth;
        Chord fifth;
        Chord sixth;
        Chord seventh;
        Chord eighth;
        Chord ninth;
        Chord tenth;
        Chord eleventh;
        Chord twelfth;

        public Progression(Chord first) {

            this.first = first;
            this.numOfChords = 1;

        }

        public Progression(Chord first, Chord second) {

            this.first = first;
            this.second = second;
            this.numOfChords = 2;

        }

        public Progression(Chord first, Chord second, Chord third) {

            this.first = first;
            this.second = second;
            this.third = third;
            this.numOfChords = 3;

        }

        public Progression(Chord first, Chord second, Chord third, Chord fourth) {

            this.first = first;
            this.second = second;
            this.third = third;
            this.fourth = fourth;
            this.numOfChords = 4;

        }

        public Progression(Chord first, Chord second, Chord third, Chord fourth, Chord fifth) {

            this.first = first;
            this.second = second;
            this.third = third;
            this.fourth = fourth;
            this.fifth = fifth;
            this.numOfChords = 5;

        }

        public Progression(Chord first, Chord second, Chord third, Chord fourth, Chord fifth, Chord sixth) {

            this.first = first;
            this.second = second;
            this.third = third;
            this.fourth = fourth;
            this.fifth = fifth;
            this.sixth = sixth;
            this.numOfChords = 6;

        }

        public Progression(Chord first, Chord second, Chord third, Chord fourth, Chord fifth, Chord sixth, Chord seventh) {

            this.first = first;
            this.second = second;
            this.third = third;
            this.fourth = fourth;
            this.fifth = fifth;
            this.sixth = sixth;
            this.seventh = seventh;
            this.numOfChords = 7;

        }

        public Progression(Chord first, Chord second, Chord third, Chord fourth, Chord fifth, Chord sixth, Chord seventh, Chord eighth) {

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

        public Progression(Chord first, Chord second, Chord third, Chord fourth, Chord fifth, Chord sixth, Chord seventh, Chord eighth, Chord ninth) {

            this.first = first;
            this.second = second;
            this.third = third;
            this.fourth = fourth;
            this.fifth = fifth;
            this.sixth = sixth;
            this.seventh = seventh;
            this.eighth = eighth;
            this.ninth = ninth;
            this.numOfChords = 9;

        }

        public Progression(Chord first, Chord second, Chord third, Chord fourth, Chord fifth, Chord sixth, Chord seventh, Chord eighth, Chord ninth, Chord tenth) {

            this.first = first;
            this.second = second;
            this.third = third;
            this.fourth = fourth;
            this.fifth = fifth;
            this.sixth = sixth;
            this.seventh = seventh;
            this.eighth = eighth;
            this.ninth = ninth;
            this.tenth = tenth;
            this.numOfChords = 10;

        }

        public Progression(Chord first, Chord second, Chord third, Chord fourth, Chord fifth, Chord sixth, Chord seventh, Chord eighth, Chord ninth, Chord tenth, Chord eleventh) {

            this.first = first;
            this.second = second;
            this.third = third;
            this.fourth = fourth;
            this.fifth = fifth;
            this.sixth = sixth;
            this.seventh = seventh;
            this.eighth = eighth;
            this.ninth = ninth;
            this.tenth = tenth;
            this.eleventh = eleventh;
            this.numOfChords = 11;

        }

        public Progression(Chord first, Chord second, Chord third, Chord fourth, Chord fifth, Chord sixth, Chord seventh, Chord eighth, Chord ninth, Chord tenth, Chord eleventh, Chord twelfth) {

            this.first = first;
            this.second = second;
            this.third = third;
            this.fourth = fourth;
            this.fifth = fifth;
            this.sixth = sixth;
            this.seventh = seventh;
            this.eighth = eighth;
            this.ninth = ninth;
            this.tenth = tenth;
            this.eleventh = eleventh;
            this.twelfth = twelfth;
            this.numOfChords = 12;

        }

        // never call this; the memory is better used elsewhere
        /* public String[] getProgression() {

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

        }*/

        // never call this either
        /*public String[] getKeyedProgression(String tonic) {

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

        }*/

        // converts a chord built on an interval above a particular tonic note to a chord built on a key (ex. A, v70 -> D#70)
        /*private String translateFromTonic(String tonic, String chord) {

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

        }*/

    }

    // TODO: finish minor keys
    private class Key {

        String key;

        public Key(String key) {
            this.key = key;
        }

        public String diminishedSecondAboveTonic() {
            if (key.equals("C") || key.equals("Cm")) {return "Dbb";}
            else if (key.equals("C#") || key.equals("C#m")) {return "Dnb";}
            else if (key.equals("Db")) {return "Ebbb";}
            else if (key.equals("D") || key.equals("Dm")) {return "Ebb";}
            else if (key.equals("D#m")) {return "Enb";}
            else if (key.equals("Eb") || key.equals("Ebm")) {return "Fbb";}
            else if (key.equals("E") || key.equals("Em")) {return "Fnb";}
            else if (key.equals("F") || key.equals("Fm")) {return "Gbb";}
            else if (key.equals("F#") || key.equals("F#m")) {return "Gnb";}
            else if (key.equals("Gb")) {return "Abbb";}
            else if (key.equals("G") || key.equals("Gm")) {return "Abb";}
            else if (key.equals("G#m")) {return "Anb";}
            else if (key.equals("Ab") || key.equals("Abm")) {return "Bbbb";}
            else if (key.equals("A") || key.equals("Am")) {return "Bbb";}
            else if (key.equals("A#m")) {return "Bnb";}
            else if (key.equals("Bb") || key.equals("Bbm")) {return "Cbb";}
            else if (key.equals("B") || key.equals("Bm")) {return "Cnb";}
            else if (key.equals("Cb")) {return "Dbbb";}
            else {return "";}
        }

        public String minorSecondAboveTonic() {

            if (key.equals("C")) {
                return "Db";
            } else if (key.equals("C#")) {
                return "Dn";
            } else if (key.equals("Db")) {
                return "Ebb";
            } else if (key.equals("D")) {
                return "Eb";
            } else if (key.equals("Eb")) {
                return "Fb";
            } else if (key.equals("E")) {
                return "Fn";
            } else if (key.equals("F")) {
                return "Gb";
            } else if (key.equals("F#")) {
                return "Gn";
            } else if (key.equals("Gb")) {
                return "Abb";
            } else if (key.equals("G")) {
                return "Ab";
            } else if (key.equals("Ab")) {
                return "Bbb";
            } else if (key.equals("A")) {
                return "Bb";
            } else if (key.equals("Bb")) {
                return "Cb";
            } else if (key.equals("B")) {
                return "Cn";
            } else if (key.equals("Cb")) {
                return "Dbb";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String majorSecondAboveTonic() {

            if (key.equals("C")) {
                return "D";
            } else if (key.equals("C#")) {
                return "D#";
            } else if (key.equals("Db")) {
                return "Eb";
            } else if (key.equals("D")) {
                return "E";
            } else if (key.equals("Eb")) {
                return "F";
            } else if (key.equals("E")) {
                return "F#";
            } else if (key.equals("F")) {
                return "G";
            } else if (key.equals("F#")) {
                return "G#";
            } else if (key.equals("Gb")) {
                return "Ab";
            } else if (key.equals("G")) {
                return "A";
            } else if (key.equals("Ab")) {
                return "Bb";
            } else if (key.equals("A")) {
                return "B";
            } else if (key.equals("Bb")) {
                return "C";
            } else if (key.equals("B")) {
                return "C#";
            } else if (key.equals("Cb")) {
                return "Db";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String augmentedSecondAboveTonic() {

            if (key.equals("C")) {
                return "D#";
            } else if (key.equals("C#")) {
                return "Dx";
            } else if (key.equals("Db")) {
                return "En";
            } else if (key.equals("D")) {
                return "E#";
            } else if (key.equals("Eb")) {
                return "F#";
            } else if (key.equals("E")) {
                return "Fx";
            } else if (key.equals("F")) {
                return "G#";
            } else if (key.equals("F#")) {
                return "Gx";
            } else if (key.equals("Gb")) {
                return "An";
            } else if (key.equals("G")) {
                return "A#";
            } else if (key.equals("Ab")) {
                return "Bn";
            } else if (key.equals("A")) {
                return "B#";
            } else if (key.equals("Bb")) {
                return "C#";
            } else if (key.equals("B")) {
                return "Cx";
            } else if (key.equals("Cb")) {
                return "Dn";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String diminishedThirdAboveTonic() {

            if (key.equals("C")) {
                return "Ebb";
            } else if (key.equals("C#")) {
                return "Enb";
            } else if (key.equals("Db")) {
                return "Fbb";
            } else if (key.equals("D")) {
                return "Fnb";
            } else if (key.equals("Eb")) {
                return "Gbb";
            } else if (key.equals("E")) {
                return "Gnb";
            } else if (key.equals("F")) {
                return "Abb";
            } else if (key.equals("F#")) {
                return "Anb";
            } else if (key.equals("Gb")) {
                return "Bbbb";
            } else if (key.equals("G")) {
                return "Bbb";
            } else if (key.equals("Ab")) {
                return "Cbb";
            } else if (key.equals("A")) {
                return "Cnb";
            } else if (key.equals("Bb")) {
                return "Dbb";
            } else if (key.equals("B")) {
                return "Dnb";
            } else if (key.equals("Cb")) {
                return "Ebbb";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String minorThirdAboveTonic() {

            if (key.equals("C")) {
                return "Eb";
            } else if (key.equals("C#")) {
                return "En";
            } else if (key.equals("Db")) {
                return "Fb";
            } else if (key.equals("D")) {
                return "Fn";
            } else if (key.equals("Eb")) {
                return "Gb";
            } else if (key.equals("E")) {
                return "Gn";
            } else if (key.equals("F")) {
                return "Ab";
            } else if (key.equals("F#")) {
                return "An";
            } else if (key.equals("Gb")) {
                return "Bbb";
            } else if (key.equals("G")) {
                return "Bb";
            } else if (key.equals("Ab")) {
                return "Cb";
            } else if (key.equals("A")) {
                return "Cn";
            } else if (key.equals("Bb")) {
                return "Db";
            } else if (key.equals("B")) {
                return "Dn";
            } else if (key.equals("Cb")) {
                return "Ebb";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String majorThirdAboveTonic() {

            if (key.equals("C")) {
                return "E";
            } else if (key.equals("C#")) {
                return "E#";
            } else if (key.equals("Db")) {
                return "F";
            } else if (key.equals("D")) {
                return "F#";
            } else if (key.equals("Eb")) {
                return "G";
            } else if (key.equals("E")) {
                return "G#";
            } else if (key.equals("F")) {
                return "A";
            } else if (key.equals("F#")) {
                return "A#";
            } else if (key.equals("Gb")) {
                return "Bb";
            } else if (key.equals("G")) {
                return "B";
            } else if (key.equals("Ab")) {
                return "C";
            } else if (key.equals("A")) {
                return "C#";
            } else if (key.equals("Bb")) {
                return "D";
            } else if (key.equals("B")) {
                return "D#";
            } else if (key.equals("Cb")) {
                return "Eb";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String augmentedThirdAboveTonic() {

            if (key.equals("C")) {
                return "E#";
            } else if (key.equals("C#")) {
                return "Ex";
            } else if (key.equals("Db")) {
                return "F#";
            } else if (key.equals("D")) {
                return "Fx";
            } else if (key.equals("Eb")) {
                return "G#";
            } else if (key.equals("E")) {
                return "Gx";
            } else if (key.equals("F")) {
                return "A#";
            } else if (key.equals("F#")) {
                return "Ax";
            } else if (key.equals("Gb")) {
                return "Bn";
            } else if (key.equals("G")) {
                return "B#";
            } else if (key.equals("Ab")) {
                return "C#";
            } else if (key.equals("A")) {
                return "Cx";
            } else if (key.equals("Bb")) {
                return "D#";
            } else if (key.equals("B")) {
                return "Dx";
            } else if (key.equals("Cb")) {
                return "En";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String diminishedFourthAboveTonic() {

            if (key.equals("C")) {
                return "Fb";
            } else if (key.equals("C#")) {
                return "Fn";
            } else if (key.equals("Db")) {
                return "Gbb";
            } else if (key.equals("D")) {
                return "Gb";
            } else if (key.equals("Eb")) {
                return "Abb";
            } else if (key.equals("E")) {
                return "Ab";
            } else if (key.equals("F")) {
                return "Bbb";
            } else if (key.equals("F#")) {
                return "Bb";
            } else if (key.equals("Gb")) {
                return "Cbb";
            } else if (key.equals("G")) {
                return "Cb";
            } else if (key.equals("Ab")) {
                return "Dbb";
            } else if (key.equals("A")) {
                return "Db";
            } else if (key.equals("Bb")) {
                return "Ebb";
            } else if (key.equals("B")) {
                return "Eb";
            } else if (key.equals("Cb")) {
                return "Fbb";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String perfectFourthAboveTonic() {

            if (key.equals("C")) {
                return "F";
            } else if (key.equals("C#")) {
                return "F#";
            } else if (key.equals("Db")) {
                return "Gb";
            } else if (key.equals("D")) {
                return "G";
            } else if (key.equals("Eb")) {
                return "Ab";
            } else if (key.equals("E")) {
                return "A";
            } else if (key.equals("F")) {
                return "Bb";
            } else if (key.equals("F#")) {
                return "B";
            } else if (key.equals("Gb")) {
                return "Cb";
            } else if (key.equals("G")) {
                return "C";
            } else if (key.equals("Ab")) {
                return "Db";
            } else if (key.equals("A")) {
                return "D";
            } else if (key.equals("Bb")) {
                return "Eb";
            } else if (key.equals("B")) {
                return "E";
            } else if (key.equals("Cb")) {
                return "Fb";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String augmentedFourthAboveTonic() {

            if (key.equals("C")) {
                return "F#";
            } else if (key.equals("C#")) {
                return "Fx";
            } else if (key.equals("Db")) {
                return "Gn";
            } else if (key.equals("D")) {
                return "G#";
            } else if (key.equals("Eb")) {
                return "An";
            } else if (key.equals("E")) {
                return "A#";
            } else if (key.equals("F")) {
                return "Bn";
            } else if (key.equals("F#")) {
                return "B#";
            } else if (key.equals("Gb")) {
                return "Cn";
            } else if (key.equals("G")) {
                return "C#";
            } else if (key.equals("Ab")) {
                return "Dn";
            } else if (key.equals("A")) {
                return "D#";
            } else if (key.equals("Bb")) {
                return "En";
            } else if (key.equals("B")) {
                return "E#";
            } else if (key.equals("Cb")) {
                return "Fn";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String diminishedFifthAboveTonic() {

            if (key.equals("C")) {
                return "Gb";
            } else if (key.equals("C#")) {
                return "Gn";
            } else if (key.equals("Db")) {
                return "Abb";
            } else if (key.equals("D")) {
                return "Ab";
            } else if (key.equals("Eb")) {
                return "Bbb";
            } else if (key.equals("E")) {
                return "Bb";
            } else if (key.equals("F")) {
                return "Cb";
            } else if (key.equals("F#")) {
                return "Cn";
            } else if (key.equals("Gb")) {
                return "Dbb";
            } else if (key.equals("G")) {
                return "Db";
            } else if (key.equals("Ab")) {
                return "Ebb";
            } else if (key.equals("A")) {
                return "Eb";
            } else if (key.equals("Bb")) {
                return "Fb";
            } else if (key.equals("B")) {
                return "Fn";
            } else if (key.equals("Cb")) {
                return "Gbb";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String perfectFifthAboveTonic() {

            if (key.equals("C")) {
                return "G";
            } else if (key.equals("C#")) {
                return "G#";
            } else if (key.equals("Db")) {
                return "Ab";
            } else if (key.equals("D")) {
                return "A";
            } else if (key.equals("Eb")) {
                return "Bb";
            } else if (key.equals("E")) {
                return "B";
            } else if (key.equals("F")) {
                return "C";
            } else if (key.equals("F#")) {
                return "C#";
            } else if (key.equals("Gb")) {
                return "Db";
            } else if (key.equals("G")) {
                return "D";
            } else if (key.equals("Ab")) {
                return "Eb";
            } else if (key.equals("A")) {
                return "E";
            } else if (key.equals("Bb")) {
                return "F";
            } else if (key.equals("B")) {
                return "F#";
            } else if (key.equals("Cb")) {
                return "Gb";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String augmentedFifthAboveTonic() {

            if (key.equals("C")) {
                return "G#";
            } else if (key.equals("C#")) {
                return "Gx";
            } else if (key.equals("Db")) {
                return "An";
            } else if (key.equals("D")) {
                return "A#";
            } else if (key.equals("Eb")) {
                return "Bn";
            } else if (key.equals("E")) {
                return "B#";
            } else if (key.equals("F")) {
                return "C#";
            } else if (key.equals("F#")) {
                return "Cx";
            } else if (key.equals("Gb")) {
                return "Dn";
            } else if (key.equals("G")) {
                return "D#";
            } else if (key.equals("Ab")) {
                return "En";
            } else if (key.equals("A")) {
                return "E#";
            } else if (key.equals("Bb")) {
                return "F#";
            } else if (key.equals("B")) {
                return "Fx";
            } else if (key.equals("Cb")) {
                return "Gn";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String diminishedSixthAboveTonic() {

            if (key.equals("C")) {
                return "Abb";
            } else if (key.equals("C#")) {
                return "Anb";
            } else if (key.equals("Db")) {
                return "Bbbb";
            } else if (key.equals("D")) {
                return "Bbb";
            } else if (key.equals("Eb")) {
                return "Cbb";
            } else if (key.equals("E")) {
                return "Cnb";
            } else if (key.equals("F")) {
                return "Dbb";
            } else if (key.equals("F#")) {
                return "Dnb";
            } else if (key.equals("Gb")) {
                return "Ebbb";
            } else if (key.equals("G")) {
                return "Ebb";
            } else if (key.equals("Ab")) {
                return "Fbb";
            } else if (key.equals("A")) {
                return "Fnb";
            } else if (key.equals("Bb")) {
                return "Gbb";
            } else if (key.equals("B")) {
                return "Gnb";
            } else if (key.equals("Cb")) {
                return "Abbb";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String minorSixthAboveTonic() {

            if (key.equals("C")) {
                return "Ab";
            } else if (key.equals("C#")) {
                return "An";
            } else if (key.equals("Db")) {
                return "Bbb";
            } else if (key.equals("D")) {
                return "Bb";
            } else if (key.equals("Eb")) {
                return "Cb";
            } else if (key.equals("E")) {
                return "Cn";
            } else if (key.equals("F")) {
                return "Db";
            } else if (key.equals("F#")) {
                return "Dn";
            } else if (key.equals("Gb")) {
                return "Ebb";
            } else if (key.equals("G")) {
                return "Eb";
            } else if (key.equals("Ab")) {
                return "Fb";
            } else if (key.equals("A")) {
                return "Fn";
            } else if (key.equals("Bb")) {
                return "Gb";
            } else if (key.equals("B")) {
                return "Gn";
            } else if (key.equals("Cb")) {
                return "Abb";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String majorSixthAboveTonic() {

            if (key.equals("C")) {
                return "A";
            } else if (key.equals("C#")) {
                return "A#";
            } else if (key.equals("Db")) {
                return "Bb";
            } else if (key.equals("D")) {
                return "B";
            } else if (key.equals("Eb")) {
                return "C";
            } else if (key.equals("E")) {
                return "C#";
            } else if (key.equals("F")) {
                return "D";
            } else if (key.equals("F#")) {
                return "D#";
            } else if (key.equals("Gb")) {
                return "Eb";
            } else if (key.equals("G")) {
                return "E";
            } else if (key.equals("Ab")) {
                return "F";
            } else if (key.equals("A")) {
                return "F#";
            } else if (key.equals("Bb")) {
                return "G";
            } else if (key.equals("B")) {
                return "G#";
            } else if (key.equals("Cb")) {
                return "Ab";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String augmentedSixthAboveTonic() {

            if (key.equals("C")) {
                return "A#";
            } else if (key.equals("C#")) {
                return "Ax";
            } else if (key.equals("Db")) {
                return "Bn";
            } else if (key.equals("D")) {
                return "B#";
            } else if (key.equals("Eb")) {
                return "C#";
            } else if (key.equals("E")) {
                return "Cx";
            } else if (key.equals("F")) {
                return "D#";
            } else if (key.equals("F#")) {
                return "Dx";
            } else if (key.equals("Gb")) {
                return "En";
            } else if (key.equals("G")) {
                return "E#";
            } else if (key.equals("Ab")) {
                return "F#";
            } else if (key.equals("A")) {
                return "Fx";
            } else if (key.equals("Bb")) {
                return "G#";
            } else if (key.equals("B")) {
                return "Gx";
            } else if (key.equals("Cb")) {
                return "An";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String diminishedSeventhAboveTonic() {

            if (key.equals("C")) {
                return "Bbb";
            } else if (key.equals("C#")) {
                return "Bnb";
            } else if (key.equals("Db")) {
                return "Cbb";
            } else if (key.equals("D")) {
                return "Cnb";
            } else if (key.equals("Eb")) {
                return "Dbb";
            } else if (key.equals("E")) {
                return "Dnb";
            } else if (key.equals("F")) {
                return "Ebb";
            } else if (key.equals("F#")) {
                return "Enb";
            } else if (key.equals("Gb")) {
                return "Fbb";
            } else if (key.equals("G")) {
                return "Fnb";
            } else if (key.equals("Ab")) {
                return "Gbb";
            } else if (key.equals("A")) {
                return "Gnb";
            } else if (key.equals("Bb")) {
                return "Abb";
            } else if (key.equals("B")) {
                return "Anb";
            } else if (key.equals("Cb")) {
                return "Bbbb";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String minorSeventhAboveTonic() {

            if (key.equals("C")) {
                return "Bb";
            } else if (key.equals("C#")) {
                return "Bn";
            } else if (key.equals("Db")) {
                return "Cb";
            } else if (key.equals("D")) {
                return "Cn";
            } else if (key.equals("Eb")) {
                return "Db";
            } else if (key.equals("E")) {
                return "Dn";
            } else if (key.equals("F")) {
                return "Eb";
            } else if (key.equals("F#")) {
                return "En";
            } else if (key.equals("Gb")) {
                return "Fb";
            } else if (key.equals("G")) {
                return "Fn";
            } else if (key.equals("Ab")) {
                return "Gb";
            } else if (key.equals("A")) {
                return "Gn";
            } else if (key.equals("Bb")) {
                return "Ab";
            } else if (key.equals("B")) {
                return "An";
            } else if (key.equals("Cb")) {
                return "Bbb";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String majorSeventhAboveTonic() {

            if (key.equals("C")) {
                return "B";
            } else if (key.equals("C#")) {
                return "B#";
            } else if (key.equals("Db")) {
                return "C";
            } else if (key.equals("D")) {
                return "C#";
            } else if (key.equals("Eb")) {
                return "D";
            } else if (key.equals("E")) {
                return "D#";
            } else if (key.equals("F")) {
                return "E";
            } else if (key.equals("F#")) {
                return "E#";
            } else if (key.equals("Gb")) {
                return "F";
            } else if (key.equals("G")) {
                return "F#";
            } else if (key.equals("Ab")) {
                return "G";
            } else if (key.equals("A")) {
                return "G#";
            } else if (key.equals("Bb")) {
                return "A";
            } else if (key.equals("B")) {
                return "A#";
            } else if (key.equals("Cb")) {
                return "Bb";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String augmentedSeventhAboveTonic() {

            if (key.equals("C")) {
                return "B#";
            } else if (key.equals("C#")) {
                return "Bx";
            } else if (key.equals("Db")) {
                return "C#";
            } else if (key.equals("D")) {
                return "Cx";
            } else if (key.equals("Eb")) {
                return "D#";
            } else if (key.equals("E")) {
                return "Dx";
            } else if (key.equals("F")) {
                return "E#";
            } else if (key.equals("F#")) {
                return "Ex";
            } else if (key.equals("Gb")) {
                return "F#";
            } else if (key.equals("G")) {
                return "Fx";
            } else if (key.equals("Ab")) {
                return "G#";
            } else if (key.equals("A")) {
                return "Gx";
            } else if (key.equals("Bb")) {
                return "A#";
            } else if (key.equals("B")) {
                return "Ax";
            } else if (key.equals("Cb")) {
                return "Bn";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String diminishedOctaveAboveTonic() {

            if (key.equals("C")) {
                return "Cb";
            } else if (key.equals("C#")) {
                return "Cn";
            } else if (key.equals("Db")) {
                return "Dbb";
            } else if (key.equals("D")) {
                return "Db";
            } else if (key.equals("Eb")) {
                return "Ebb";
            } else if (key.equals("E")) {
                return "Eb";
            } else if (key.equals("F")) {
                return "Fb";
            } else if (key.equals("F#")) {
                return "Fn";
            } else if (key.equals("Gb")) {
                return "Gbb";
            } else if (key.equals("G")) {
                return "Gb";
            } else if (key.equals("Ab")) {
                return "Abb";
            } else if (key.equals("A")) {
                return "Ab";
            } else if (key.equals("Bb")) {
                return "Bbb";
            } else if (key.equals("B")) {
                return "Bb";
            } else if (key.equals("Cb")) {
                return "Cbb";
            }
            // will never get here
            else {
                return "";
            }

        }

        public String perfectOctaveAboveTonic() {

            return key;

        }

        public String augmentedOctaveAboveTonic() {

            if (key.equals("C")) {
                return "C#";
            } else if (key.equals("C#")) {
                return "Cx";
            } else if (key.equals("Db")) {
                return "Dn";
            } else if (key.equals("D")) {
                return "D#";
            } else if (key.equals("Eb")) {
                return "En";
            } else if (key.equals("E")) {
                return "E#";
            } else if (key.equals("F")) {
                return "F#";
            } else if (key.equals("F#")) {
                return "Fx";
            } else if (key.equals("Gb")) {
                return "Gn";
            } else if (key.equals("G")) {
                return "G#";
            } else if (key.equals("Ab")) {
                return "An";
            } else if (key.equals("A")) {
                return "A#";
            } else if (key.equals("Bb")) {
                return "Bn";
            } else if (key.equals("B")) {
                return "B#";
            } else if (key.equals("Cb")) {
                return "Cn";
            }
            // will never get here
            else {
                return "";
            }

        }

    }

    /**

     Chord.getNotes(Key key) currently has no support for pedaled chords and no support for minor keys

     Chromatic note names (major key): sharpened subtonic / tonic
                                       sharpened tonic / flattened supertonic
                                       supertonic
                                       sharpened supertonic / flattened mediant
                                       mediant / flattened subdominant
                                       sharpened mediant / subdominant
                                       sharpened subdominant / flattened dominant
                                       dominant
                                       sharpened dominant / flattened submediant
                                       submediant
                                       sharpened submediant / flattened subtonic
                                       subtonic / flattened tonic

     Chromatic note names (minor key): tonic
                                       sharpened tonic / flattened supertonic
                                       supertonic / flattened mediant
                                       sharpened supertonic / mediant
                                       sharpened mediant / flattened subdominant
                                       subdominant
                                       sharpened subdominant / flattened dominant
                                       dominant / flattened submediant
                                       sharpened dominant / submediant
                                       sharpened submediant / flattened subtonic
                                       subtonic
                                       sharpened subtonic / flattened tonic

     These are the chords currently supported. All inversions of these chords are also supported
     unless otherwise stated.

     Major Chords: tonic, flattened supertonic, supertonic, flattened mediant, mediant, subdominant,
                   sharpened subdominant, flattened dominant, dominant, flattened submediant, submediant,
                   flattened subtonic, subtonic
     Minor Chords: tonic, flattened supertonic, supertonic, flattened mediant, mediant, subdominant,
                   sharpened subdominant, flattened dominant, dominant, flattened submediant, submediant,
                   flattened subtonic, subtonic
     Dominant Seventh Chords: tonic, flattened supertonic, supertonic, flattened mediant, mediant,
                              subdominant, dominant, flattened submediant, submediant, flattened subtonic,
                              subtonic


     **/

    private class Chord {

        String chordType;
        String chordRoot;
        String pedalNote;
        boolean isPedaled;
        int inversion;

        public Chord(String chordType, String chordRoot, int inversion) {
            this.chordType = chordType;
            this.chordRoot = chordRoot;
            this.inversion = inversion;
            this.isPedaled = false;
        }

        public Chord(String chordType, String chordRoot, String pedalNote) {
            this.chordType = chordType;
            this.chordRoot = chordRoot;
            this.pedalNote = pedalNote;
            this.isPedaled = true;
        }

        private ArrayList<String> randomizeVoicing(String[] optionalNotes, String[] requiredNotes, int extent) {

            int numOfAddedNotes = new Random().nextInt(optionalNotes.length + extent + 1);

            // add required notes
            ArrayList<String> randomizedVoicing = new ArrayList<>();
            for (String note : requiredNotes) {
                randomizedVoicing.add(note);
            }
            Collections.shuffle(randomizedVoicing);

            // add random notes in random positions
            ArrayList<String> notesToAdd = new ArrayList<>(Arrays.asList(optionalNotes));
            notesToAdd.addAll(new ArrayList<>(Arrays.asList(requiredNotes)));
            Random randomGenerator = new Random();
            int numOfTotalNotes = notesToAdd.size();
            for (int i = 0; i < numOfAddedNotes; i++) {
                randomizedVoicing.add(randomGenerator.nextInt(randomizedVoicing.size() + 1), notesToAdd.get(randomGenerator.nextInt(numOfTotalNotes)));
            }

            return randomizedVoicing;

        }

        public ArrayList<String> getNotes(Key key) {
            if (chordType.equals("major")) {
                if (chordRoot.equals("tonic")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectOctaveAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectOctaveAboveTonic()
                                },
                                new String[]{
                                        key.majorThirdAboveTonic(),
                                        key.perfectFifthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorThirdAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorThirdAboveTonic()
                                },
                                new String[]{
                                        key.perfectFifthAboveTonic(),
                                        key.perfectOctaveAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectFifthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectFifthAboveTonic()
                                },
                                new String[]{
                                        key.perfectOctaveAboveTonic(),
                                        key.majorThirdAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("flattenedSupertonic")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSecondAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSecondAboveTonic()
                                },
                                new String[]{
                                        key.perfectFourthAboveTonic(),
                                        key.minorSixthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectFourthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectFourthAboveTonic()
                                },
                                new String[]{
                                        key.minorSixthAboveTonic(),
                                        key.minorSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSixthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSixthAboveTonic()
                                },
                                new String[]{
                                        key.minorSecondAboveTonic(),
                                        key.perfectFourthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("supertonic")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSecondAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSecondAboveTonic()
                                },
                                new String[]{
                                        key.augmentedFourthAboveTonic(),
                                        key.majorSixthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedFourthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedFourthAboveTonic()
                                },
                                new String[]{
                                        key.majorSixthAboveTonic(),
                                        key.majorSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSixthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSixthAboveTonic()
                                },
                                new String[]{
                                        key.majorSecondAboveTonic(),
                                        key.augmentedFourthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("flattenedMediant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorThirdAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorThirdAboveTonic()
                                },
                                new String[]{
                                        key.perfectFifthAboveTonic(),
                                        key.minorSeventhAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectFifthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectFifthAboveTonic()
                                },
                                new String[]{
                                        key.minorSeventhAboveTonic(),
                                        key.minorThirdAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSeventhAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSeventhAboveTonic()
                                },
                                new String[]{
                                        key.minorThirdAboveTonic(),
                                        key.perfectFifthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("mediant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorThirdAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorThirdAboveTonic()
                                },
                                new String[]{
                                        key.augmentedFifthAboveTonic(),
                                        key.majorSeventhAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedFifthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedFifthAboveTonic()
                                },
                                new String[]{
                                        key.majorSeventhAboveTonic(),
                                        key.majorThirdAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSeventhAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSeventhAboveTonic()
                                },
                                new String[]{
                                        key.majorThirdAboveTonic(),
                                        key.augmentedFifthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("subdominant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectFourthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectFourthAboveTonic()
                                },
                                new String[]{
                                        key.majorSixthAboveTonic(),
                                        key.perfectOctaveAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSixthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSixthAboveTonic()
                                },
                                new String[]{
                                        key.perfectOctaveAboveTonic(),
                                        key.perfectFourthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectOctaveAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectOctaveAboveTonic()
                                },
                                new String[]{
                                        key.perfectFourthAboveTonic(),
                                        key.majorSixthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("sharpenedSubdominant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedFourthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedFourthAboveTonic()
                                },
                                new String[]{
                                        key.augmentedSixthAboveTonic(),
                                        key.augmentedOctaveAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedSixthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedSixthAboveTonic()
                                },
                                new String[]{
                                        key.augmentedOctaveAboveTonic(),
                                        key.augmentedFourthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedOctaveAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedOctaveAboveTonic()
                                },
                                new String[]{
                                        key.augmentedFourthAboveTonic(),
                                        key.augmentedSixthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("flattenedDominant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.diminishedFifthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.diminishedFifthAboveTonic()
                                },
                                new String[]{
                                        key.minorSeventhAboveTonic(),
                                        key.minorSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSeventhAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSeventhAboveTonic()
                                },
                                new String[]{
                                        key.minorSecondAboveTonic(),
                                        key.diminishedFifthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSecondAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSecondAboveTonic()
                                },
                                new String[]{
                                        key.diminishedFifthAboveTonic(),
                                        key.minorSeventhAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("dominant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectFifthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectFifthAboveTonic()
                                },
                                new String[]{
                                        key.majorSeventhAboveTonic(),
                                        key.majorSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSeventhAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSeventhAboveTonic()
                                },
                                new String[]{
                                        key.majorSecondAboveTonic(),
                                        key.perfectFifthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSecondAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSecondAboveTonic()
                                },
                                new String[]{
                                        key.perfectFifthAboveTonic(),
                                        key.majorSeventhAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("flattenedSubmediant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSixthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSixthAboveTonic()
                                },
                                new String[]{
                                        key.perfectOctaveAboveTonic(),
                                        key.minorThirdAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectOctaveAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectOctaveAboveTonic()
                                },
                                new String[]{
                                        key.minorThirdAboveTonic(),
                                        key.minorSixthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorThirdAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorThirdAboveTonic()
                                },
                                new String[]{
                                        key.minorSixthAboveTonic(),
                                        key.perfectOctaveAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("submediant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSixthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSixthAboveTonic()
                                },
                                new String[]{
                                        key.augmentedOctaveAboveTonic(),
                                        key.majorThirdAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedOctaveAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedOctaveAboveTonic()
                                },
                                new String[]{
                                        key.majorThirdAboveTonic(),
                                        key.majorSixthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorThirdAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorThirdAboveTonic()
                                },
                                new String[]{
                                        key.majorSixthAboveTonic(),
                                        key.augmentedOctaveAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("flattenedSubtonic")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSeventhAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSeventhAboveTonic()
                                },
                                new String[]{
                                        key.majorSecondAboveTonic(),
                                        key.perfectFourthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSecondAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSecondAboveTonic()
                                },
                                new String[]{
                                        key.perfectFourthAboveTonic(),
                                        key.minorSeventhAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectFourthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectFourthAboveTonic()
                                },
                                new String[]{
                                        key.minorSeventhAboveTonic(),
                                        key.majorSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("subtonic")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSeventhAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSeventhAboveTonic()
                                },
                                new String[]{
                                        key.augmentedSecondAboveTonic(),
                                        key.augmentedFourthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedSecondAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedSecondAboveTonic()
                                },
                                new String[]{
                                        key.augmentedFourthAboveTonic(),
                                        key.majorSeventhAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedFourthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedFourthAboveTonic()
                                },
                                new String[]{
                                        key.majorSeventhAboveTonic(),
                                        key.augmentedSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else {
                    return new ArrayList<>();
                }
            } else if (chordType.equals("minor")) {
                if (chordRoot.equals("tonic")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectOctaveAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectOctaveAboveTonic()
                                },
                                new String[]{
                                        key.minorThirdAboveTonic(),
                                        key.perfectFifthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorThirdAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorThirdAboveTonic()
                                },
                                new String[]{
                                        key.perfectFifthAboveTonic(),
                                        key.perfectOctaveAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectFifthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectFifthAboveTonic()
                                },
                                new String[]{
                                        key.perfectOctaveAboveTonic(),
                                        key.minorThirdAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("flattenedSupertonic")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSecondAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSecondAboveTonic()
                                },
                                new String[]{
                                        key.diminishedFourthAboveTonic(),
                                        key.minorSixthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.diminishedFourthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.diminishedFourthAboveTonic()
                                },
                                new String[]{
                                        key.minorSixthAboveTonic(),
                                        key.minorSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSixthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSixthAboveTonic()
                                },
                                new String[]{
                                        key.minorSecondAboveTonic(),
                                        key.diminishedFourthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("supertonic")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSecondAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSecondAboveTonic()
                                },
                                new String[]{
                                        key.perfectFourthAboveTonic(),
                                        key.majorSixthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectFourthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectFourthAboveTonic()
                                },
                                new String[]{
                                        key.majorSixthAboveTonic(),
                                        key.majorSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSixthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSixthAboveTonic()
                                },
                                new String[]{
                                        key.majorSecondAboveTonic(),
                                        key.perfectFourthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("flattenedMediant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorThirdAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorThirdAboveTonic()
                                },
                                new String[]{
                                        key.diminishedFifthAboveTonic(),
                                        key.minorSeventhAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.diminishedFifthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.diminishedFifthAboveTonic()
                                },
                                new String[]{
                                        key.minorSeventhAboveTonic(),
                                        key.minorThirdAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSeventhAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSeventhAboveTonic()
                                },
                                new String[]{
                                        key.minorThirdAboveTonic(),
                                        key.diminishedFifthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("mediant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorThirdAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorThirdAboveTonic()
                                },
                                new String[]{
                                        key.perfectFifthAboveTonic(),
                                        key.majorSeventhAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectFifthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectFifthAboveTonic()
                                },
                                new String[]{
                                        key.majorSeventhAboveTonic(),
                                        key.majorThirdAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSeventhAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSeventhAboveTonic()
                                },
                                new String[]{
                                        key.majorThirdAboveTonic(),
                                        key.perfectFifthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("subdominant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectFourthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectFourthAboveTonic()
                                },
                                new String[]{
                                        key.minorSixthAboveTonic(),
                                        key.perfectOctaveAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSixthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSixthAboveTonic()
                                },
                                new String[]{
                                        key.perfectOctaveAboveTonic(),
                                        key.perfectFourthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectOctaveAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectOctaveAboveTonic()
                                },
                                new String[]{
                                        key.perfectFourthAboveTonic(),
                                        key.minorSixthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("sharpenedSubdominant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedFourthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedFourthAboveTonic()
                                },
                                new String[]{
                                        key.majorSixthAboveTonic(),
                                        key.augmentedOctaveAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSixthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSixthAboveTonic()
                                },
                                new String[]{
                                        key.augmentedOctaveAboveTonic(),
                                        key.augmentedFourthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedOctaveAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedOctaveAboveTonic()
                                },
                                new String[]{
                                        key.augmentedFourthAboveTonic(),
                                        key.majorSixthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("flattenedDominant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.diminishedFifthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.diminishedFifthAboveTonic()
                                },
                                new String[]{
                                        key.diminishedSeventhAboveTonic(),
                                        key.minorSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.diminishedSeventhAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.diminishedSeventhAboveTonic()
                                },
                                new String[]{
                                        key.minorSecondAboveTonic(),
                                        key.diminishedFifthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSecondAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSecondAboveTonic()
                                },
                                new String[]{
                                        key.diminishedFifthAboveTonic(),
                                        key.diminishedSeventhAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("dominant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectFifthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectFifthAboveTonic()
                                },
                                new String[]{
                                        key.minorSeventhAboveTonic(),
                                        key.majorSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSeventhAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSeventhAboveTonic()
                                },
                                new String[]{
                                        key.majorSecondAboveTonic(),
                                        key.perfectFifthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSecondAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSecondAboveTonic()
                                },
                                new String[]{
                                        key.perfectFifthAboveTonic(),
                                        key.minorSeventhAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("flattenedSubmediant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSixthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSixthAboveTonic()
                                },
                                new String[]{
                                        key.diminishedOctaveAboveTonic(),
                                        key.minorThirdAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.diminishedOctaveAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.diminishedOctaveAboveTonic()
                                },
                                new String[]{
                                        key.minorThirdAboveTonic(),
                                        key.minorSixthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorThirdAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorThirdAboveTonic()
                                },
                                new String[]{
                                        key.minorSixthAboveTonic(),
                                        key.diminishedOctaveAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("submediant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSixthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSixthAboveTonic()
                                },
                                new String[]{
                                        key.perfectOctaveAboveTonic(),
                                        key.majorThirdAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectOctaveAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectOctaveAboveTonic()
                                },
                                new String[]{
                                        key.majorThirdAboveTonic(),
                                        key.majorSixthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorThirdAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorThirdAboveTonic()
                                },
                                new String[]{
                                        key.majorSixthAboveTonic(),
                                        key.perfectOctaveAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("flattenedSubtonic")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSeventhAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSeventhAboveTonic()
                                },
                                new String[]{
                                        key.minorSecondAboveTonic(),
                                        key.perfectFourthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSecondAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSecondAboveTonic()
                                },
                                new String[]{
                                        key.perfectFourthAboveTonic(),
                                        key.minorSeventhAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectFourthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectFourthAboveTonic()
                                },
                                new String[]{
                                        key.minorSeventhAboveTonic(),
                                        key.minorSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("subtonic")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSeventhAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSeventhAboveTonic()
                                },
                                new String[]{
                                        key.augmentedSecondAboveTonic(),
                                        key.augmentedFourthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedSecondAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedSecondAboveTonic()
                                },
                                new String[]{
                                        key.augmentedFourthAboveTonic(),
                                        key.majorSeventhAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedFourthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedFourthAboveTonic()
                                },
                                new String[]{
                                        key.majorSeventhAboveTonic(),
                                        key.augmentedSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else {
                    return new ArrayList<>();
                }
            } else if (chordType.equals("dominantSeventh")) {
                if (chordRoot.equals("tonic")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectOctaveAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectOctaveAboveTonic(),
                                        key.perfectFifthAboveTonic()
                                },
                                new String[]{
                                        key.majorThirdAboveTonic(),
                                        key.minorSeventhAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorThirdAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorThirdAboveTonic(),
                                        key.perfectFifthAboveTonic()
                                },
                                new String[]{
                                        key.perfectOctaveAboveTonic(),
                                        key.minorSeventhAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectFifthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectFifthAboveTonic()
                                },
                                new String[]{
                                        key.perfectOctaveAboveTonic(),
                                        key.majorThirdAboveTonic(),
                                        key.minorSeventhAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 3) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSeventhAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSeventhAboveTonic(),
                                        key.perfectFifthAboveTonic()
                                },
                                new String[]{
                                        key.perfectOctaveAboveTonic(),
                                        key.majorThirdAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("flattenedSupertonic")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSecondAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSecondAboveTonic(),
                                        key.minorSixthAboveTonic()
                                },
                                new String[]{
                                        key.perfectFourthAboveTonic(),
                                        key.diminishedOctaveAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectFourthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectFourthAboveTonic(),
                                        key.minorSixthAboveTonic()
                                },
                                new String[]{
                                        key.minorSecondAboveTonic(),
                                        key.diminishedOctaveAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSixthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSixthAboveTonic()
                                },
                                new String[]{
                                        key.minorSecondAboveTonic(),
                                        key.perfectFourthAboveTonic(),
                                        key.diminishedOctaveAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 3) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.diminishedOctaveAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.diminishedOctaveAboveTonic(),
                                        key.minorSixthAboveTonic()
                                },
                                new String[]{
                                        key.minorSecondAboveTonic(),
                                        key.perfectFourthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("supertonic")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSecondAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSecondAboveTonic(),
                                        key.majorSixthAboveTonic()
                                },
                                new String[]{
                                        key.augmentedFourthAboveTonic(),
                                        key.perfectOctaveAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedFourthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedFourthAboveTonic(),
                                        key.majorSixthAboveTonic()
                                },
                                new String[]{
                                        key.majorSecondAboveTonic(),
                                        key.perfectOctaveAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSixthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSixthAboveTonic()
                                },
                                new String[]{
                                        key.majorSecondAboveTonic(),
                                        key.augmentedFourthAboveTonic(),
                                        key.perfectOctaveAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 3) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectOctaveAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectOctaveAboveTonic(),
                                        key.majorSixthAboveTonic()
                                },
                                new String[]{
                                        key.majorSecondAboveTonic(),
                                        key.augmentedFourthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("flattenedMediant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorThirdAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorThirdAboveTonic(),
                                        key.minorSeventhAboveTonic()
                                },
                                new String[]{
                                        key.perfectFifthAboveTonic(),
                                        key.minorSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectFifthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectFifthAboveTonic(),
                                        key.minorSeventhAboveTonic()
                                },
                                new String[]{
                                        key.minorThirdAboveTonic(),
                                        key.minorSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSeventhAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSeventhAboveTonic()
                                },
                                new String[]{
                                        key.minorThirdAboveTonic(),
                                        key.perfectFifthAboveTonic(),
                                        key.minorSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 3) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSecondAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSecondAboveTonic(),
                                        key.minorSeventhAboveTonic()
                                },
                                new String[]{
                                        key.minorThirdAboveTonic(),
                                        key.perfectFifthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("mediant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorThirdAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorThirdAboveTonic(),
                                        key.majorSeventhAboveTonic()
                                },
                                new String[]{
                                        key.augmentedFifthAboveTonic(),
                                        key.majorSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedFifthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedFifthAboveTonic(),
                                        key.majorSeventhAboveTonic()
                                },
                                new String[]{
                                        key.majorThirdAboveTonic(),
                                        key.majorSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSeventhAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSeventhAboveTonic()
                                },
                                new String[]{
                                        key.majorThirdAboveTonic(),
                                        key.augmentedFifthAboveTonic(),
                                        key.majorSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 3) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSecondAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSecondAboveTonic(),
                                        key.majorSeventhAboveTonic()
                                },
                                new String[]{
                                        key.majorThirdAboveTonic(),
                                        key.augmentedFifthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("subdominant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectFourthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectFourthAboveTonic(),
                                        key.perfectOctaveAboveTonic()
                                },
                                new String[]{
                                        key.majorSixthAboveTonic(),
                                        key.minorThirdAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSixthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSixthAboveTonic(),
                                        key.perfectOctaveAboveTonic()
                                },
                                new String[]{
                                        key.perfectFourthAboveTonic(),
                                        key.minorThirdAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectOctaveAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectOctaveAboveTonic()
                                },
                                new String[]{
                                        key.perfectFourthAboveTonic(),
                                        key.majorSixthAboveTonic(),
                                        key.minorThirdAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 3) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorThirdAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorThirdAboveTonic(),
                                        key.perfectOctaveAboveTonic()
                                },
                                new String[]{
                                        key.perfectFourthAboveTonic(),
                                        key.majorSixthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("dominant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectFifthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectFifthAboveTonic(),
                                        key.majorSecondAboveTonic()
                                },
                                new String[]{
                                        key.majorSeventhAboveTonic(),
                                        key.perfectFourthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSeventhAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSeventhAboveTonic(),
                                        key.majorSecondAboveTonic()
                                },
                                new String[]{
                                        key.perfectFifthAboveTonic(),
                                        key.perfectFourthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSecondAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSecondAboveTonic()
                                },
                                new String[]{
                                        key.perfectFifthAboveTonic(),
                                        key.majorSeventhAboveTonic(),
                                        key.perfectFourthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 3) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectFourthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectFourthAboveTonic(),
                                        key.majorSecondAboveTonic()
                                },
                                new String[]{
                                        key.perfectFifthAboveTonic(),
                                        key.majorSeventhAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("flattenedSubmediant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSixthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSixthAboveTonic(),
                                        key.minorThirdAboveTonic()
                                },
                                new String[]{
                                        key.perfectOctaveAboveTonic(),
                                        key.diminishedFifthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectOctaveAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectOctaveAboveTonic(),
                                        key.minorThirdAboveTonic()
                                },
                                new String[]{
                                        key.minorSixthAboveTonic(),
                                        key.diminishedFifthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorThirdAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorThirdAboveTonic()
                                },
                                new String[]{
                                        key.minorSixthAboveTonic(),
                                        key.perfectOctaveAboveTonic(),
                                        key.diminishedFifthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 3) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.diminishedFifthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.diminishedFifthAboveTonic(),
                                        key.minorThirdAboveTonic()
                                },
                                new String[]{
                                        key.minorSixthAboveTonic(),
                                        key.perfectOctaveAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("submediant")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSixthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSixthAboveTonic(),
                                        key.majorThirdAboveTonic()
                                },
                                new String[]{
                                        key.augmentedOctaveAboveTonic(),
                                        key.perfectFifthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedOctaveAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedOctaveAboveTonic(),
                                        key.majorThirdAboveTonic()
                                },
                                new String[]{
                                        key.majorSixthAboveTonic(),
                                        key.perfectFifthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorThirdAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorThirdAboveTonic()
                                },
                                new String[]{
                                        key.majorSixthAboveTonic(),
                                        key.augmentedOctaveAboveTonic(),
                                        key.perfectFifthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 3) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectFifthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectFifthAboveTonic(),
                                        key.majorThirdAboveTonic()
                                },
                                new String[]{
                                        key.majorSixthAboveTonic(),
                                        key.augmentedOctaveAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("flattenedSubtonic")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSeventhAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSeventhAboveTonic(),
                                        key.perfectFourthAboveTonic()
                                },
                                new String[]{
                                        key.majorSecondAboveTonic(),
                                        key.minorSixthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSecondAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSecondAboveTonic(),
                                        key.perfectFourthAboveTonic()
                                },
                                new String[]{
                                        key.minorSeventhAboveTonic(),
                                        key.minorSixthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectFourthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectFourthAboveTonic()
                                },
                                new String[]{
                                        key.minorSeventhAboveTonic(),
                                        key.majorSecondAboveTonic(),
                                        key.minorSixthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 3) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.minorSixthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.minorSixthAboveTonic(),
                                        key.perfectFourthAboveTonic()
                                },
                                new String[]{
                                        key.minorSeventhAboveTonic(),
                                        key.majorSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else if (chordRoot.equals("subtonic")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSeventhAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSeventhAboveTonic(),
                                        key.augmentedFourthAboveTonic()
                                },
                                new String[]{
                                        key.augmentedSecondAboveTonic(),
                                        key.majorSixthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedSecondAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedSecondAboveTonic(),
                                        key.augmentedFourthAboveTonic()
                                },
                                new String[]{
                                        key.majorSeventhAboveTonic(),
                                        key.majorSixthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedFourthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedFourthAboveTonic()
                                },
                                new String[]{
                                        key.majorSeventhAboveTonic(),
                                        key.augmentedSecondAboveTonic(),
                                        key.majorSixthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 3) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSixthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSixthAboveTonic(),
                                        key.augmentedFourthAboveTonic()
                                },
                                new String[]{
                                        key.majorSeventhAboveTonic(),
                                        key.augmentedSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                } else {
                    return new ArrayList<>();
                }
            }
            // will never get here
            else {
                return new ArrayList<>();
            }
        }
    }

}
