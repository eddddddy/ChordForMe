package com.example.edward.chordforme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ProgressionLibrary {

    // Order of sharps: F# C# G# D# A# E# B# Fx Cx Gx Dx Ax
    // Order of flats: Bb Eb Ab Db Gb Cb Fb Bbb Ebb Abb Dbb
    private Key keyOfC = new Key("C");
    private Key keyOfG = new Key("G");
    private Key keyOfD = new Key("D");
    private Key keyOfA = new Key("A");
    private Key keyOfE = new Key("E");
    private Key keyOfB = new Key("B");
    private Key keyOfFsharp = new Key("F#");
    private Key keyOfCsharp = new Key("C#");
    private Key keyOfGsharp = new Key("G#");
    private Key keyOfDsharp = new Key("D#");
    private Key keyOfAsharp = new Key("A#");
    private Key keyOfEsharp = new Key("E#");
    private Key keyOfBsharp = new Key("B#");
    private Key keyOfF = new Key("F");
    private Key keyOfBflat = new Key("Bb");
    private Key keyOfEflat = new Key("Eb");
    private Key keyOfAflat = new Key("Ab");
    private Key keyOfDflat = new Key("Db");
    private Key keyOfGflat = new Key("Gb");
    private Key keyOfCflat = new Key("Cb");
    private Key keyOfFflat = new Key("Fb");

    private Key keyOfAm = new Key("Am");
    private Key keyOfEm = new Key("Em");
    private Key keyOfBm = new Key("Bm");
    private Key keyOfFsharpm = new Key("F#m");
    private Key keyOfCsharpm = new Key("C#m");
    private Key keyOfGsharpm = new Key("G#m");
    private Key keyOfDsharpm = new Key("D#m");
    private Key keyOfAsharpm = new Key("A#m");
    private Key keyOfEsharpm = new Key("E#m");
    private Key keyOfBsharpm = new Key("B#m");
    private Key keyOfDm = new Key("Dm");
    private Key keyOfGm = new Key("Gm");
    private Key keyOfCm = new Key("Cm");
    private Key keyOfFm = new Key("Fm");
    private Key keyOfBflatm = new Key("Bbm");
    private Key keyOfEflatm = new Key("Ebm");
    private Key keyOfAflatm = new Key("Abm");
    private Key keyOfDflatm = new Key("Dbm");
    private Key keyOfGflatm = new Key("Gbm");
    private Key keyOfCflatm = new Key("Cbm");
    private Key keyOfFflatm = new Key("Fbm");

    private List<String> majorKeysAsStrings = Arrays.asList("C", "G", "D", "A", "E", "B", "F#", "C#", "F", "Bb", "Eb", "Ab", "Db", "Gb", "Cb");
    private List<String> minorKeysAsStrings = Arrays.asList("Am", "Em", "Bm", "F#m", "C#m", "G#m", "D#m", "A#m", "Dm", "Gm", "Cm", "Fm", "Bbm", "Ebm", "Abm");

    private List<Progression> generalProgressions = Arrays.asList(
            new Progression(
                    "major",
                    new Chord("major", "tonic", 0),
                    new Chord("major", "subdominant", 2),
                    new Chord("dominantSeventh", "dominant", 1),
                    new Chord("major", "tonic", 0)
            )
    );

    // Waltz in B minor, Op. 69 No. 2
    private List<Progression> chopinOp69No2 = Arrays.asList(
            new Progression("minor", new Chord("minor", "tonic", 0), new Chord("dominantSeventh", "dominant", 2), new Chord("dominantSeventh", "dominant", 1), new Chord("minor", "tonic", 0)),
            new Progression("minor", new Chord("minor", "tonic", 0), new Chord("diminishedSeventh", "sharpenedSubmediant", 1), new Chord("minor", "subdominant", 2), new Chord("minorSixth", "subdominant", 2), new Chord("dominantSeventh", "dominant", "tonicPedal")),
            new Progression("minor", new Chord("minor", "tonic", 0), new Chord("dominantSeventh", "dominant", 2), new Chord("dominantSeventh", "dominant", 0), new Chord("minor", "tonic", 0)),
            new Progression("minor", new Chord("minor", "tonic", 1), new Chord("minorSixth", "subdominant", 0), new Chord("minor", "tonic", 2), new Chord("dominantSeventh", "dominant", 0), new Chord("minor", "tonic", 0)),
            new Progression("major", new Chord("minor", "submediant", 1), new Chord("dominantSeventh", "dominant", 1), new Chord("major", "tonic", 0), new Chord("dominantSeventh", "dominant", 0), new Chord("major", "tonic", 0)),
            new Progression("major", new Chord("dominantSeventh", "dominant", 1), new Chord("major", "tonic", 0), new Chord("minor", "supertonic", 1), new Chord("dominantSeventh", "mediant", 0), new Chord("minorSixth", "supertonic", "mediantPedal")),
            new Progression("major", new Chord("dominantSeventh", "mediant", 0), new Chord("minor", "submediant", 0), new Chord("dominantSeventh", "dominant", 0), new Chord("major", "tonic", 0)),
            new Progression("major", new Chord("dominantSeventh", "dominant", 1), new Chord("major", "tonic", 0), new Chord("minor", "supertonic", 1), new Chord("dominantSeventh", "mediant", 0), new Chord("dominantSeventh", "mediant", 1)),
            new Progression("major", new Chord("major", "tonic", 0), new Chord("dominantNinth", "dominant", 1), new Chord("dominantSeventh", "dominant", 1), new Chord("major", "tonic", 0), new Chord("dominantNinth", "dominant", 1), new Chord("dominantSeventh", "dominant", 1)),
            new Progression("major", new Chord("major", "tonic", 0), new Chord("dominantSeventh", "dominant", 0), new Chord("major", "tonic", 0), new Chord("dominantSeventh", "dominant", 0)),
            new Progression("major", new Chord("major", "tonic", 0), new Chord("minor", "submediant", 1), new Chord("major", "dominant", 2), new Chord("dominantSeventh", "supertonic", 0), new Chord("dominantSeventh", "dominant", 0)),
            new Progression("major", new Chord("major", "tonic", 0), new Chord("dominantNinth", "dominant", 0), new Chord("dominantSeventh", "dominant", 0), new Chord("major", "tonic", 0), new Chord("dominantNinth", "dominant", 0), new Chord("dominantSeventh", "dominant", 0)),
            new Progression("minor", new Chord("minor", "tonic", 0), new Chord("dominantMinorNinth", "dominant", 0), new Chord("dominantSeventh", "dominant", 0), new Chord("minor", "tonic", 0), new Chord("dominantMinorNinth", "dominant", 0), new Chord("dominantSeventh", "dominant", 0)),
            new Progression("minor", new Chord("minor", "tonic", 0), new Chord("dominantSeventh", "dominant", "tonicPedal"), new Chord("minor", "tonic", 0), new Chord("major", "submediant", 0), new Chord("dominantSeventh", "supertonic", "submediantPedal"), new Chord("major", "dominant", 0), new Chord("dominantSeventh", "dominant", 0))
    );
    // notes:
    // scale positions depend on the keyType of the progression
    // new Chord("minorSixth", "supertonic", "mediantPedal") is a minor sixth ninth chord in 4th inversion
    // new Chord("dominantSeventh", "dominant", "tonicPedal") is a dominant seventh chord pedaled on a tonic minor triad

    // Waltz in C# minor, Op. 64 No. 2
    private List<Progression> chopinOp64no2 = Arrays.asList(
            // 1-4
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "supertonic", 0),
                    new Chord("dominantMinorNinth", "dominant", 0),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("dominantMinorNinth", "dominant", "tonicPedal"),
                    new Chord("minor", "tonic", 0)
            ),
            // 5-8
            new Progression(
                    "minor",
                    new Chord("major", "submediant", 2),
                    new Chord("diminishedSeventh", "supertonic", "mediantPedal"),
                    new Chord("dominantNinth", "mediant", 0),
                    new Chord("dominantSeventh", "mediant", 0),
                    new Chord("majorNinth", "flattenedSupertonic", 2),
                    new Chord("major", "submediant", "supertonicPedal") // I have no idea what this chord is
            ),
            // 9-12
            new Progression(
                    "minor",
                    new Chord("dominantMinorNinth", "dominant", 0),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0),
                    new Chord("minor", "subdominant", 2),
                    new Chord("dominantNinth", "subtonic", 0),
                    new Chord("dominantSeventh", "subtonic", 0),
                    new Chord("major", "mediant", 0),
                    new Chord("minorSixth", "tonic", 1)
            ),
            // 13-16
            new Progression(
                    "minor",
                    new Chord("minor", "dominant", 2),
                    new Chord("dominantSeventh", "supertonic", 0),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 17-24 identical to 1-8
            // 25-28
            new Progression(
                    "minor",
                    new Chord("dominantMinorNinth", "dominant", 0),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("dominantSeventh", "tonic", 0)
            )
    );
    // notes:
    // root note and inversion of diminished seventh chords are chosen arbitrarily

    // Prelude in B minor, Op. 28 No. 6
    private List<Progression> chopinOp28No6 = Arrays.asList(
            // 1-4
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0)
            ),
            // 5-6
            new Progression(
                    "minor",
                    new Chord("major", "submediant", 0),
                    new Chord("minor", "tonic", 2),
                    new Chord("halfDiminishedSeventh", "sharpenedSubmediant", 3),
                    new Chord("dominantSeventh", "supertonic", 1),
                    new Chord("diminishedSeventh", "sharpenedSubtonic", 2),
                    new Chord("minor", "tonic", 1)
            ),
            // 7
            new Progression(
                    "minor",
                    new Chord("diminishedSeventh", "sharpenedSubtonic", 1),
                    new Chord("minorSeventh", "subdominant", 3),
                    new Chord("diminishedSeventh", "sharpenedSubtonic", 1),
                    new Chord("major", "dominant", 1),
                    new Chord("minor", "tonic", 1)
            ),
            // 8
            new Progression(
                    "minor",
                    new Chord("diminishedSeventh", "sharpenedDominant", 3),
                    new Chord("diminishedSeventh", "sharpenedSubdominant", 0),
                    new Chord("minor", "tonic", 2),
                    new Chord("major", "dominant", 1)
            ),
            // 9-12
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("major", "submediant", 0),
                    new Chord("major", "flattenedSupertonic", 0)
            ),
            // 13-14
            new Progression(
                    "minor",
                    new Chord("major", "flattenedSupertonic", 0),
                    new Chord("minor", "subdominant", 0)
            ),
            // 15
            new Progression(
                    "minor",
                    new Chord("diminishedSeventh", "sharpenedSubtonic", 0),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0)
            ),
            // 16-18
            new Progression(
                    "minor",
                    new Chord("halfDiminishedSeventh", "supertonic", 0),
                    new Chord("diminishedSeventh", "sharpenedSubtonic", 0),
                    new Chord("major", "submediant", 0),
                    new Chord("minor", "tonic", 2),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("diminishedSeventh", "sharpenedSubtonic", 0),
                    new Chord("major", "submediant", 0)
            ),
            // 19 identical to 16
            // 20-22a
            new Progression(
                    "minor",
                    new Chord("halfDiminishedSeventh", "supertonic", 0),
                    new Chord("diminishedSeventh", "sharpenedSubtonic", 0),
                    new Chord("major", "submediant", 0),
                    new Chord("minor", "tonic", 2),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0)
            ),
            // 22b-26
            new Progression(
                    "minor",
                    new Chord("minorSeventh", "tonic", 0),
                    new Chord("minor", "tonic", 0)
            )
    );

    // Prelude in A major, Op. 28 No. 7
    private List<Progression> chopinOp28No7 = Arrays.asList(
            // 1-4
            new Progression(
                    "major",
                    new Chord("dominantNinth", "dominant", 0),
                    new Chord("major", "tonic", 0)
            ),
            // 5-8 identical to 1-4
            // 9-12
            new Progression(
                    "major",
                    new Chord("dominantNinth", "dominant", 0),
                    new Chord("major", "tonic", 0),
                    new Chord("dominantSeventh", "submediant", 0)
            ),
            // 13-16
            new Progression(
                    "major",
                    new Chord("minorSeventh", "supertonic", 0),
                    new Chord("dominantNinth", "dominant", 0),
                    new Chord("major", "tonic", 0)
            )
    );
    
    // Prelude in Db major, Op. 28 No. 15
    private List<Progression> chopinOp28No15 = Arrays.asList(
            // 1-2
            new Progression(
                    "major",
                    new Chord("major", "tonic", 0),
                    new Chord("minorSeventh", "submediant", 1),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 2)
            ),
            // 3-4
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("halfDiminishedSeventh", "subtonic", "dominantPedal"),
                    new Chord("major", "tonic", 2),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 2),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 5-6 identical to 1-2
            // 7-8
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("halfDiminishedSeventh", "subtonic", "dominantPedal"),
                    new Chord("major", "tonic", 2),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 2)
            ),
            // 9-10
            new Progression(
                    "major",
                    new Chord("major", "dominant", 0),
                    new Chord("minor", "dominant", 0),
                    new Chord("majorSeventh", "tonic", 0),
                    new Chord("major", "subdominant", 0),
                    new Chord("major", "tonic", 0)
            ),
            // 11-12a
            new Progression(
                    "major",
                    new Chord("minor", "dominant", 2),
                    new Chord("dominantSeventh", "supertonic", 0),
                    new Chord("minor", "dominant", 0)
            ),
            // 12b-14
            new Progression(
                    "major",
                    new Chord("minor", "dominant", 0),
                    new Chord("halfDiminishedSeventh", "submediant", 3),
                    new Chord("minor", "dominant", 0),
                    new Chord("minor", "mediant", 1),
                    new Chord("minor", "supertonic", 0),
                    new Chord("minor", "submediant", 0)
            ),
            // 15-16a
            new Progression(
                    "major",
                    new Chord("minor", "submediant", 2),
                    new Chord("dominantSeventh", "mediant", 0),
                    new Chord("minor", "submediant", 0)
            ),
            // 16b-18a
            new Progression(
                    "major",
                    new Chord("minor", "submediant", 0),
                    new Chord("diminished", "subtonic", "mediantPedal"),
                    new Chord("minor", "submediant", 2),
                    new Chord("dominantSeventh", "mediant", 0),
                    new Chord("minor", "submediant", 0)
            ),
            // 18b-19
            new Progression(
                    "major",
                    new Chord("diminished", "subtonic", "mediantPedal"),
                    new Chord("major", "tonic", 1),
                    new Chord("diminished", "subtonic", "mediantPedal"),
                    new Chord("major", "tonic", 1),
                    new Chord("majorSeventh", "subdominant", 0),
                    new Chord("major", "dominant", 0)
            ),
            // 20-23 identical to 1-4
            // 24-25 identical to 1-2
            // 26-27
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("halfDiminishedSeventh", "subtonic", "dominantPedal"),
                    new Chord("major", "dominant", 0),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 28
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("major", "dominant", 2),
                    new Chord("minor", "tonic", 1),
                    new Chord("major", "dominant", 2)
            ),
            // 29
            new Progression(
                    "minor",
                    new Chord("major", "dominant", 2),
                    new Chord("minor", "tonic", 1),
                    new Chord("dominantSeventh", "dominant", 3),
                    new Chord("minor", "tonic", 1)
            ),
            // 30-31
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 1),
                    new Chord("major", "dominant", 0),
                    new Chord("minor", "tonic", 0),
                    new Chord("major", "dominant", 0)
            ),
            // 32
            new Progression(
                    "minor",
                    new Chord("major", "dominant", 0),
                    new Chord("minor", "tonic", 0),
                    new Chord("major", "dominant", 0),
                    new Chord("minor", "tonic", 1)
            ),
            // 33
            new Progression(
                    "minor",
                    new Chord("major", "dominant", 0),
                    new Chord("minor", "tonic", 1),
                    new Chord("major", "dominant", 2),
                    new Chord("minor", "tonic", 0)
            ),
            // 34-35
            new Progression(
                    "minor",
                    new Chord("major", "dominant", 2),
                    new Chord("minor", "tonic", 1),
                    new Chord("major", "dominant", 2),
                    new Chord("minor", "tonic", 0),
                    new Chord("major", "dominant", 0)
            ),
            // 36-39 identical to 28-31
            // 40-43
            new Progression(
                    "minor",
                    new Chord("major", "mediant", 0),
                    new Chord("minor", "dominant", 1),
                    new Chord("major", "mediant", 0),
                    new Chord("minor", "dominant", 1),
                    new Chord("minor", "dominant", 0),
                    new Chord("augmented", "subtonic", 1),
                    new Chord("minor", "dominant", 0)
            ),
            // 44-59 identical to 28-43
            // 60-61
            new Progression(
                    "minor",
                    new Chord("dominantSeventh", "dominant", 3),
                    new Chord("minor", "tonic", 1),
                    new Chord("minor", "tonic", 0),
                    new Chord("major", "dominant", 0)
            ),
            // 62-63
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("major", "dominant", 0),
                    new Chord("majorSeventh", "submediant", 0),
                    new Chord("minor", "subdominant", 1),
                    new Chord("minor", "tonic", 2),
                    new Chord("minor", "subdominant", 0)
            ),
            // 64-65a
            new Progression(
                    "minor",
                    new Chord("major", "dominant", 0),
                    new Chord("minor", "tonic", 0),
                    new Chord("halfDiminishedSeventh", "sharpenedSubmediant", 1),
                    new Chord("major", "dominant", 0)
            ),
            // 65b-67
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("halfDiminishedSeventh", "sharpenedSubmediant", 1),
                    new Chord("minor", "tonic", 0),
                    new Chord("major", "dominant", 0),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0),
                    new Chord("major", "dominant", 0)
            ),
            // 68-69 identical to 60-61
            // 70-71
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("major", "dominant", 0),
                    new Chord("dominantSeventh", "tonic", 2),
                    new Chord("minor", "subdominant", 0)
            ),
            // 72-73a
            new Progression(
                    "minor",
                    new Chord("dominantSeventh", "dominant", 1),
                    new Chord("minor", "tonic", 0),
                    new Chord("halfDiminishedSeventh", "sharpenedSubmediant", 1),
                    new Chord("halfDiminishedSeventh", "sharpenedSubmediant", 3),
                    new Chord("major", "dominant", 0)
            ),
            // 73b-74a
            new Progression(
                    "minor",
                    new Chord("halfDiminishedSeventh", "sharpenedSubmediant", 1),
                    new Chord("halfDiminishedSeventh", "sharpenedSubmediant", 3),
                    new Chord("major", "dominant", 0),
            ),
            // 74b-75a identical to 73b-74a
            // 75b
            new Progression(
                    "major",
                    new Chord("major", "dominant", 0),
                    new Chord("major", "tonic", 1),
                    new Chord("dominantSeventh", "dominant", 3),
                    new Chord("dominantSeventh", "dominant", 2)
            ),
            // 76-79 identical to 1-4
            // 80-81
            new Progression(
                    "major",
                    new Chord("major", "tonic", 0),
                    new Chord("minorSeventh", "submediant", 1),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 82-83 is a solo RH passage
            // 84-89
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 0),
                    new Chord("major", "tonic", 2),
                    new Chord("major", "tonic", 0)
            )
    );
    
    // Prelude in C minor, Op. 28 No. 20
    private List<Progression> chopinOp28No20 = Arrays.asList(
            // 1-2
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("minorSeventh", "subdominant", 0),
                    new Chord("dominantMinorThirteenth", "dominant", 0),
                    new Chord("minor", "tonic", 0),
                    new Chord("major", "submediant", 0),
                    new Chord("major", "flattenedSupertonic", 0),
                    new Chord("dominantMajorThirteenth", "mediant", 0),
                    new Chord("major", "submediant", 0)
            ),
            // 3-4
            new Progression(
                    "minor",
                    new Chord("major", "dominant", 0),
                    new Chord("dominantSeventh", "tonic", 0),
                    new Chord("minor", "subdominant", 0),
                    new Chord("major", "tonic", 0),
                    new Chord("dominantSeventh", "supertonic", 0),
                    new Chord("major", "dominant", 0),
                    new Chord("dominantMajorThirteenth", "supertonic", 0),
                    new Chord("major", "dominant", 0)
            ),
            // 5-6
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("major", "submediant", 1),
                    new Chord("diminishedSeventh", "sharpenedSubtonic", 0),
                    new Chord("minor", "dominant", 1),
                    new Chord("minorSeventh", "sharpenedSubmediant", 0),
                    new Chord("dominantSeventhFlatFive", "supertonic", 2),
                    new Chord("major", "dominant", 0),
                    new Chord("dominantSeventh", "dominant", 3)
            ),
            // 7-8
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 1),
                    new Chord("minor", "subdominant", 0),
                    new Chord("dominantSeventh", "dominant", 1),
                    new Chord("minor", "tonic", 0),
                    new Chord("major", "submediant", 0),
                    new Chord("major", "flattenedSupertonic", 0),
                    new Chord("dominantMinorThirteenth", "dominant", 0),
                    new Chord("minor", "tonic", 0)
            ),
            // 9-12 identical to 5-8
            // 13
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0)
            )
    );
    
    // Nocturne No. 1 in Bb minor, Op. 9 No. 1
    private List<Progression> chopinOp9No1 = Arrays.asList(
            // 0b-2a
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", "tonicPedal"),
                    new Chord("minor", "tonic", 0)
            ),
            // 2b-4a identical to 0b-2a
            // 4b-6a
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("major", "mediant", 0),
                    new Chord("major", "submediant", 0),
                    new Chord("major", "mediant", 0)
            ),
            // 6b-8a
            new Progression(
                    "minor",
                    new Chord("halfDiminishedSeventh", "subdominant", 1),
                    new Chord("major", "mediant", 0),
                    new Chord("halfDiminishedSeventh", "subdominant", 1),
                    new Chord("diminishedSeventh", "supertonic", 2),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 8b-12a identical to 0b-4a
            // 12b-14
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("major", "tonic", 0),
                    new Chord("minor", "subdominant", 0),
                    new Chord("major", "supertonic", 0),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 15
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("minor", "subdominant", 0),
                    new Chord("minor", "tonic", 2),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 16 identical to 15
            // 17-18
            new Progression(
                    "minor",
                    new Chord("dominantSeventh", "submediant", 0),
                    new Chord("major", "flattenedSupertonic", 1),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0)
            ),
            // 19-22
            new Progression(
                    "major",
                    new Chord("major", "tonic", 0),
                    new Chord("diminished", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", "tonicPedal"),
                    new Chord("major", "tonic", 0)
            ),
            // 23-26
            new Progression(
                    "major",
                    new Chord("major", "tonic", 0),
                    new Chord("dominantSeventh", "sharpenedDominant", 1),
                    new Chord("major", "sharpenedTonic", 0),
                    new Chord("major", "sharpenedSubdominant", 2),
                    new Chord("major", "sharpenedTonic", 0),
                    new Chord("diminishedSeventh", "sharpenedSubtonic", 2),
                    new Chord("dominantMinorNinth", "dominant", 0),
                    new Chord("major", "tonic", 0)
            ),
            // 27-30 identical to 19-22
            // 31-34 identical to 23-26
            // 35-36
            new Progression(
                    "major",
                    new Chord("major", "dominant", 0),
                    new Chord("dominantSeventh", "submediant", 3),
                    new Chord("minor", "supertonic", 1),
                    new Chord("dominantSeventh", "dominant", 3)
            ),
            // 37-38
            new Progression(
                    "major",
                    new Chord("major", "tonic", 1),
                    new Chord("major", "tonic", 0),
                    new Chord("major", "supertonic", "tonicPedal"),
                    new Chord("diminishedSeventh", "sharpenedDominant", "tonicPedal"),
                    new Chord("augmentedSeventh", "dominant", "tonicPedal")
            ),
            // 39-42 identical to 23-26
            // 43-44 identical to 35-36
            // 45-46 identical to 37-38
            // 47-50 identical to 23-26
            // 51-52
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "tonic", 0),
                    new Chord("halfDiminishedSeventh", "mediant", "tonicPedal"),
                    new Chord("dominantSeventh", "tonic", 0)
            ),
            // 53-54 identical to 51-52
            // 55-56
            new Progression(
                    "major",
                    new Chord("major", "tonic", 0),
                    new Chord("halfDiminishedSeventh", "mediant", "tonicPedal"),
                    new Chord("minorNinth", "dominant", "tonicPedal"),
                    new Chord("dominantSeventh", "tonic", 0)
            ),
            // 57-60
            new Progression(
                    "major",
                    new Chord("major", "tonic", 0),
                    new Chord("halfDiminishedSeventh", "mediant", "tonicPedal"),
                    new Chord("minorNinth", "dominant", "tonicPedal"),
                    new Chord("dominantSeventh", "tonic", 0),
                    new Chord("major", "tonic", 0)
            ),
            // 61-62
            new Progression(
                    "major",
                    new Chord("major", "tonic", 0),
                    new Chord("major", "dominant", "tonicPedal"),
                    new Chord("major", "tonic", 0)
            ),
            // 63-64 identical to 61-62
            // 65-70a
            new Progression(
                    "major",
                    new Chord("major", "tonic", 0),
                    new Chord("minor", "supertonic", "tonicPedal"),
                    new Chord("major", "tonic", 0)
                    // 67-70a is atonal with a held tonic major triad
            ),
            // 70b-72a
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 1),
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", "tonicPedal"),
                    new Chord("minor", "tonic", 0)
            ),
            // 72b-74a identical to 0b-2a
            // 74b-80a identical to 12b-18a
            // 80b-84a
            new Progression(
                    "minor",
                    new Chord("germanAugmentedSixth", "flattenedSupertonic", "tonicPedal"),
                    new Chord("minor", "tonic", 0),
                    new Chord("germanAugmentedSixth", "flattenedSupertonic", "tonicPedal"),
                    new Chord("minor", "tonic", 0),
                    new Chord("germanAugmentedSixth", "flattenedSupertonic", "tonicPedal"),
                    new Chord("major", "tonic", 0)
            ),
            // 84b-85
            new Progression(
                    "minor",
                    new Chord("major", "tonic", 0),
                    new chord("major", "submediant", 1),
                    new Chord("major", "tonic", 0)
            )
    );   

    // Nocturne No. 2 in Eb major, Op. 9 No. 2
    private List<Progression> chopinOp9No2 = Arrays.asList(
            // 1
            new Progression(
                    "major",
                    new Chord("major", "tonic", 0),
                    new Chord("diminishedSeventh", "subtonic", "tonicPedal"),
                    new Chord("major", "tonic", 0),
                    new Chord("majorSeventh", "tonic", 3)
            ),
            // 2
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "submediant", 0),
                    new Chord("minor", "dominant", 2),
                    new Chord("diminishedSeventh", "sharpenedTonic", "supertonicPedal"),
                    new Chord("minor", "supertonic", 0)
            ),
            // 3-4
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("dominantSeventh", "mediant", 1),
                    new Chord("minor", "submediant", 0),
                    new Chord("diminishedSeventh", "sharpenedSubdominant", 0),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 0)
            ),
            // 5-8 identical to 1-4
            // 9-10
            new Progression(
                    "major",
                    new Chord("major", "dominant", 0),
                    new Chord("minorSeventh", "mediant", 1),
                    new Chord("major", "supertonic", 1),
                    new Chord("major", "subdominant", 0),
                    new Chord("minor", "subdominant", 0),
                    new Chord("major", "tonic", 0)
            ),
            // 11
            new Progression(
                    "major",
                    new Chord("diminishedSeventh", "sharpenedTonic", 0),
                    new Chord("minor", "sharpenedSubdominant", 2),
                    new Chord("dominantSeventh", "submediant", 1),
                    new Chord("dominantSeventh", "supertonic", 0),
                    new Chord("minor", "mediant", 0)
            ),
            // 12a
            new Progression(
                    "major",
                    new Chord("minor", "submediant", 0),
                    new Chord("minor", "subtonic", 1),
                    new Chord("dominantMajorThirteenth", "supertonic", 0),
                    new Chord("major", "dominant", 0)
            ),
            // 12b
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "sharpenedDominant", 3),
                    new Chord("major", "sharpenedTonic", 1),
                    new Chord("dominantSeventh", "submediant", 2),
                    new Chord("dominantSeventh", "supertonic", 0),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 13-16 identical to 1-4
            // 17-20 identical to 9-12
            // 21-24 identical to 1-4
            // 25-26
            new Progression(
                    "major",
                    new Chord("minor", "subdominant", 2),
                    new Chord("major", "tonic", 0),
                    new Chord("minor", "subdominant", 2),
                    new Chord("major", "tonic", 0)
            ),
            // 27-28
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "dominant", "tonicPedal"),
                    new Chord("major", "tonic", 0),
                    new Chord("dominantMajorThirteenth", "dominant", 1),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 0)
            ),
            // 29-30a identical to 25-26
            // 30b-33
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "supertonic", 1),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("dominantSeventh", "mediant", 1),
                    new Chord("minor", "submediant", 0),
                    new Chord("dominantSeventh", "supertonic", 1),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 34-35
            new Progression(
                    "major",
                    new Chord("major", "tonic", 0)
            )
    );
    
    // Nocturne No. 4 in F major, Op. 15 No. 1
    private List<Progression> chopinOp15No1 = Arrays.asList(
            // 1-2
            new Progression(
                    "major",
                    new Chord("major", "tonic", 0),
                    new Chord("majorSeventh", "tonic", 0),
                    new Chord("majorSeventh", "subdominant", 2),
                    new Chord("dominantSeventh", "dominant", "tonicPedal")
            ),
            // 3-4
            new Progression(
                    "major",
                    new Chord("minorSeventh", "supertonic", 3),
                    new Chord("dominantSeventh", "dominant", "tonicPedal"),
                    new Chord("major", "tonic", 0),
                    new Chord("dominantSeventh", "mediant", 2),
                    new Chord("minor", "submediant", 0)
            ),
            // 5-7a
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "supertonic", 2),
                    new Chord("halfDiminishedSeventh", "supertonic", 2),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 2),
                    new Chord("minorSeventh", "sharpenedSubdominant", 0),
                    new Chord("dominantSeventh", "subtonic", 2),
                    new Chord("minor", "mediant", 0)
            ),
            // 7b-9a
            new Progression(
                    "major",
                    new Chord("halfDiminishedSeventh", "sharpenedSubdominant", 2),
                    new Chord("major", "subtonic", 0),
                    new Chord("dominantSeventh", "dominant", 2),
                    new Chord("major", "tonic", 0)
            ),
            // 9-10 identical to 1-2
            // 11-12
            new Progression(
                    "major",
                    new Chord("minorSeventh", "supertonic", 3),
                    new Chord("dominantSeventh", "dominant", "tonicPedal"),
                    new Chord("major", "tonic", 0),
                    new Chord("dominantSeventh", "mediant", 2),
            ),
            // 13-14
            new Progression(
                    "major",
                    new Chord("diminishedSeventh", "subtonic", 0),
                    new Chord("dominantSeventh", "dominant", 1),
                    new Chord("dominantSeventh", "submediant", 1),
                    new Chord("dominantSeventh", "dominant", 2),
                    new Chord("major", "tonic", 0),
                    new Chord("diminishedSeventh", "sharpenedSupertonic", 1)
            ),
            // 15-16
            new Progression(
                    "major",
                    new Chord("major", "tonic", 2),
                    new Chord("major", "dominant", 2),
                    new Chord("dominantSeventhFlatFive", "supertonic", 3),
                    new Chord("diminishedSeventh", "subtonic", 0)
            ),
            // 17-19a
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "flattenedSubtonic", 0),
                    new Chord("halfDiminishedSeventh", "flattenedSubtonic", 0),
                    new Chord("dominantSeventhFlatFive", "mediant", 2),
                    new Chord("dominantSeventh", "submediant", 0),
                    new Chord("dominantSeventh", "supertonic", 2),
                    new Chord("major", "dominant", 0)
            ),
            // 19b-20a
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 0)
            ),
            // 20b-21a
            new Progression(
                    "major",
                    new Chord("diminishedSeventh", "sharpenedSubdominant", 0),
                    new Chord("diminished", "submediant", 1),
                    new Chord("major", "dominant", 0)
            ),
            // 21b-24
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 0),
                    new Chord("majorSeventh", "tonic", 0),
                    new Chord("majorSeventh", "subdominant", 2),
                    new Chord("dominantSeventh", "dominant", "tonicPedal"),
                    new Chord("halfDiminishedSeventh", "supertonic", 3),
                    new Chord("diminished", "subtonic", "tonicPedal")
            ),
            // 25-26
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("minorSeventh", "subdominant", 2),
                    new Chord("halfDiminishedSeventh", "supertonic", 0)
            ),
            // 27-28
            new Progression(
                    "minor",
                    new Chord("halfDiminishedSeventh", "supertonic", 3),
                    new Chord("halfDiminishedSeventh", "dominant", "tonicPedal"),
                    new Chord("halfDiminishedSeventh", "sharpenedMediant", 0)
            ),
            // 29-30
            new Progression(
                    "minor",
                    new Chord("augmentedMajorSeventh", "submediant", 0),
                    new Chord("minor", "subdominant", 1),
                    new Chord("dominantMajorThirteenth", "submediant", 0),
                    new Chord("major", "flattenedSupertonic", 2),
                    new Chord("dominantSeventh", "submediant", 0)
            ),
            // 31-32
            new Progression(
                    "minor",
                    new Chord("dominantMajorThirteenth", "submediant", "flattenedSupertonicPedal"),
                    new Chord("major", "flattenedSupertonic", 0),
                    new Chord("major", "submediant", "flattenedSupertonicPedal"),
                    new Chord("minorSeventh", "subtonic", 3),
                    new Chord("major", "submediant", 0)
            ),
            // 33-34
            new Progression(
                    "minor",
                    new Chord("dominantMajorThirteenth", "submediant", 0),
                    new Chord("major", "flattenedSupertonic", 2),
                    new Chord("major", "submediant", 0),
                    new Chord("minorSeventh", "subtonic", 3),
                    new Chord("major", "submediant", 0),
                    new Chord("minor", "tonic", 0),
                    new Chord("diminished", "sharpenedSubdominant", 2)
            ),
            // 35a
            new Progression(
                    "minor",
                    new Chord("dominantMinorThirteenth", "dominant", 0),
                    new Chord("minor", "tonic", 0)
            ),
            // 35b-36a
            new Progression(
                    "minor",
                    new Chord("major", "subtonic", 1),
                    new Chord("major", "submediant", 1),
                    new Chord("minor", "dominant", 1),
                    new Chord("minor", "subdominant", 1),
                    new Chord("major", "mediant", 1),
                    new Chord("diminished", "supertonic", 1),
                    new Chord("minor", "tonic", 1)
            ),
            // 36b
            new Progression(
                    "minor",
                    new Chord("diminished", "supertonic", 1),
                    new Chord("minor", "tonic", 1),
                    new Chord("major", "dominant", 2)
            ),
            // 37-40 identical to 25-28
            // 41-42
            new Progression(
                    "minor",
                    new Chord("dominantMajorThirteenth", "mediant", 0),
                    new Chord("major", "submediant", 2),
                    new Chord("dominantSeventh", "mediant", 0),
                    new Chord("minorSeventh", "mediant", 1),
                    new Chord("dominantSeventh", "mediant", 1),
                    new Chord("dominantSeventh", "mediant", 0)
            ),
            // 43-44
            new Progression(
                    "minor",
                    new Chord("dominantMinorThirteenth", "subdominant", 0),
                    new Chord("minor", "subtonic", 2),
                    new Chord("dominantSeventh", "subdominant", 0),
                    new Chord("minorSeventh", "subdominant", 1),
                    new Chord("dominantSeventh", "subdominant", 1),
                    new Chord("dominantSeventh", "subdominant", 0)
            ),
            // 45-47a
            new Progression(
                    "minor",
                    new Chord("dominantMinorThirteenth", "subdominant", 0),
                    new Chord("minor", "subtonic", 0),
                    new Chord("dominantMinorThirteenth", "subdominant", 0),
                    new Chord("minor", "subtonic", 0),
                    new Chord("dominantMajorThirteenth", "mediant", 0),
                    new Chord("major", "submediant", 0)
            ),
            // 47b-48
            new Progression(
                    "minor",
                    new Chord("dominantMinorThirteenth", "tonic", 0),
                    new Chord("minor", "subdominant", 0),
                    new Chord("minorMajorSeventh", "subdominant", 0),
                    new Chord("halfDiminishedSeventh", "supertonic", 0)
            ),
            // 49-72a identical to 1-24
            // 72b-74
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "dominant", "tonicPedal"),
                    new Chord("major", "tonic", 0)
            )
    );
     
    // Nocturne No. 9 in B major, Op. 32 No. 1
    private List<Progression> chopinOp32No1 = Arrays.asList(
            // 1-2
            new Progression(
                    "major",
                    new Chord("major", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("dominantMajorThirteenth", "dominant", 0),
                    new Chord("major", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 3-4 identical to 1-2
            // 5-6
            new Progression(
                    "major",
                    new Chord("major", "tonic", 0),
                    new Chord("dominantSeventh", "tonic", 0),
                    new Chord("dominantSeventh", "subtonic", 0),
                    new Chord("minor", "mediant", 0),
                    new Chord("minor", "supertonic", 1)
            ),
            // 7-8a
            new Progression(
                    "major",
                    new Chord("minor", "subdominant", 1),
                    new Chord("dominantMajorThirteenth", "dominant", 0),
                    new Chord("major", "tonic", 0)
            ),
            // 8b-10a
            new Progression(
                    "major",
                    new Chord("diminishedSeventh", "submediant", "dominantPedal"),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("diminishedSeventh", "sharpenedTonic", 2),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 2),
                    new Chord("major", "supertonic", "dominantPedal"),
                    new Chord("major", "dominant", 0)
            ),
            // 10b-12a
            new Progression(
                    "major",
                    new Chord("diminished", "sharpenedSubdominant", "dominantPedal"),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("diminishedSeventh", "sharpenedTonic", 2),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("diminishedSeventh", "sharpenedDominant", 0),
                    new Chord("minor", "submediant", 0),
                    new Chord("minorSeventh", "supertonic", 1),
                    new Chord("major", "dominant", 0)
            ),
            // 12b
            new Progression(
                    "major",
                    new Chord("majorSeventh", "subdominant", "dominantPedal"),
                    new Chord("major", "dominant", 0),
                    new Chord("augmentedSeventh", "dominant", 0)
            ),
            // 13-20a identical to 1-8a
            // 20b-22
            new Progression(
                    "major",
                    new Chord("major", "tonic", 2),
                    new Chord("minor", "supertonic", "dominantPedal"),
                    new Chord("major", "tonic", 2),
                    new Chord("major", "dominant", 0),
                    new Chord("dominantSeventh", "supertonic", 0),
                    new Chord("major", "dominant", 0)
            ),
            // 23-24
            new Progression(
                    "major",
                    new Chord("major", "dominant", 0),
                    new Chord("dominantSeventh", "supertonic", 0),
                    new Chord("major", "dominant", 0),
                    new Chord("augmented", "dominant", 0)
            ),
            // 25-26
            new Progression(
                    "major",
                    new Chord("minor", "mediant", 0),
                    new Chord("dominantSeventh", "subtonic", 0),
                    new Chord("minor", "mediant", 0)
            ),
            // 27-28
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "sharpenedSubdominant", 1),
                    new Chord("minor", "subtonic", 0),
                    new Chord("halfDiminishedSeventh", "sharpenedTonic", 1),
                    new Chord("dominantSeventh", "sharpenedSubdominant", 0),
                    new Chord("minor", "subtonic", 0),
                    new Chord("halfDiminishedSeventh", "subtonic", 0)
            ),
            // 29-30
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "mediant", 0),
                    new Chord("minor", "submediant", 0),
                    new Chord("halfDiminishedSeventh", "subtonic", 1),
                    new Chord("dominantSeventh", "mediant", 0),
                    new Chord("minor", "submediant", 0)
            ),
            // 31-33a
            new Progression(
                    "major",
                    new Chord("major", "mediant", 0),
                    new Chord("major", "subdominant", "mediantPedal"),
                    new Chord("halfDiminishedSeventh", "sharpenedDominant", "mediantPedal"),
                    new Chord("major", "subdominant", "mediantPedal"),
                    new Chord("dominantSeventh", "mediant", 0),
                    new Chord("minor", "submediant", 2),
                    new Chord("major", "subtonic", "mediantPedal"),
                    new Chord("major", "mediant", 0)
            ),
            // 33b-35
            new Progression(
                    "major",
                    new Chord("major", "subdominant", "mediantPedal"),
                    new Chord("halfDiminishedSeventh", "sharpenedDominant", "mediantPedal"),
                    new Chord("major", "subdominant", "mediantPedal"),
                    new Chord("dominantSeventh", "mediant", 0),
                    new Chord("minor", "submediant", 2),
                    new Chord("major", "subtonic", "mediantPedal"),
                    new Chord("major", "mediant", 0),
                    new Chord("minor", "supertonic", 1)
            ),
            // 36-38
            new Progression(
                    "major",
                    new Chord("minor", "subdominant", 1),
                    new Chord("dominantMajorThirteenth", "dominant", 0),
                    new Chord("dominantSeventh", "submediant", 1),
                    new Chord("dominantSeventh", "supertonic", 0),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 0)
                    
            ),
            // 39-41a
            new Progression(
                    "major",
                    new Chord("majorSeventh", "subdominant", 0),
                    new Chord("minor", "mediant", 1),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 0)
            ),
            // 41b-59 identical to 20b-38
            // 60-61
            new Progression(
                    "major",
                    new Chord("majorSeventh", "subdominant", 0),
                    new Chord("minor", "mediant", 1),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 62 to the end is atonal (i.e. take these last progressions with a grain of salt)
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "flattenedSubmediant", 3),
                    new Chord("dominantSeventh", "tonic", 2),
                    new Chord("major", "tonic", 2),
                    new Chord("minor", "tonic", 2)
            ),
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "supertonic", "dominantPedal"),
                    new Chord("diminishedSeventh", "subtonic", "dominantPedal")
            ),
            // final cadence
            new Progression(
                    "major",
                    new Chord("minor", "subdominant", 0),
                    new Chord("major", "tonic", 0)
            )
    );
    
    // Nocturne No. 14 in F# minor, Op. 48 No. 2
    private List<Progression> chopinOp48No2 = Arrays.asList(
            // 1-2
            new Progression(
                    "minor",
                    new Chord("minor", "dominant", 0),
                    new Chord("halfDiminishedSeventh", "sharpenedSubmediant", 3),
                    new Chord("major", "dominant", 0),
                    new Chord("minor", "tonic", 2),
                    new Chord("augmented", "mediant", 1),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 3-5a
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "tonic", 0),
                    new Chord("halfDiminishedSeventh", "supertonic", 1),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0)
            ),
            // 5b-7a
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "tonic", 1),
                    new Chord("halfDiminishedSeventh", "supertonic", 1),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("majorSeventh", "submediant", 1)
            ),
            // 7b-9a
            new Progression(
                    "minor",
                    new Chord("frenchAugmentedSixth", "flattenedTonic", 0),
                    new Chord("major", "mediant", 2)
                    new Chord("dominantSeventh", "subtonic", 0),
                    new Chord("major", "mediant", 0)
            ),
            // 9b-11a
            new Progression(
                    "minor",
                    new Chord("frenchAugmentedSixth", "mediant", 0),
                    new Chord("minor", "dominant", 2),
                    new Chord("major", "supertonic", 0),
                    new Chord("minor", "dominant", 0)
            ),
            // 11b-13a
            new Progression(
                    "minor",
                    new Chord("dominantSeventh", "dominant", 1),
                    new Chord("halfDiminishedSeventh", "sharpenedSubmediant", 1),
                    new Chord("dominantSeventh", "supertonic", 0),
                    new Chord("minor", "dominant", 0)
            ),
            // 13b-15a identical to 11b-13a
            // 15b-17a
            new Progression(
                    "minor",
                    new Chord("frenchAugmentedSixth", "flattenedDominant", 0),
                    new Chord("major", "subtonic", 2),
                    new Chord("dominantSeventh", "subdominant", 0),
                    new Chord("majorSeventh", "subtonic", 2)
            ),
            // 17b-20a
            new Progression(
                    "minor",
                    new Chord("frenchAugmentedSixth", "subtonic", 0),
                    new Chord("minor", "supertonic", 2),
                    new Chord("diminishedSeventh", "sharpenedTonic", 2),
                    new Chord("minor", "supertonic", 1),
                    new Chord("halfDiminishedSeventh", "sharpenedMediant", 1),
                    new Chord("minor", "supertonic", 2)
            ),
            // 20b-23a
            new Progression(
                    "minor",
                    new Chord("major", "subtonic", 0),
                    new Chord("minor", "supertonic", 0),
                    new Chord("minorSeventh", "dominant", 0),
                    new Chord("minor", "supertonic", 2),
                    new Chord("major", "sharpenedSubmediant", 0),
                    new Chord("major", "supertonic", 0)
            ),
            // 23b-25a
            new Progression(
                    "minor",
                    new Chord("major", "supertonic", 0),
                    new Chord("halfDiminishedSeventh", "sharpenedMediant", 3),
                    new Chord("major", "supertonic", 0)
            ),
            // 25b-28
            new Progression(
                    "minor",
                    new Chord("major", "supertonic", 0),
                    new Chord("halfDiminishedSeventh", "sharpenedMediant", 1),
                    new Chord("dominantSeventh", "sharpenedSubmediant", 0),
                    new Chord("major", "supertonic", 0)
            ),
            // 29-48a identical to 1-20a
            // 48b-51a
            new Progression(
                    "minor",
                    new Chord("major", "subtonic", 0),
                    new Chord("minor", "supertonic", 0),
                    new Chord("halfDiminishedSeventh", "sharpenedMediant", 1)
                    new Chord("minor", "supertonic", 2),
                    new Chord("major", "sharpenedSubmediant", 0),
                    new Chord("major", "supertonic", 0)
            ),
            // 51b-53a identical to 23b-25a
            // 53b-56
            new Progression(
                    "minor",
                    new Chord("major", "supertonic", 0),
                    new Chord("halfDiminishedSeventh", "sharpenedMediant", 1),
                    new Chord("dominantSeventh", "sharpenedSubmediant", 0),
                    new Chord("major", "supertonic", 0),
                    new Chord("major", "subtonic", 1)
            ),
            // 57-60
            new Progression(
                    "major",
                    new Chord("major", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", 2),
                    new Chord("major", "tonic", 1),
                    new Chord("major", "subdominant", 0)
            ),
            // 61-62
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("dominantMajorThirteenth", "dominant", 0),
                    new Chord("diminishedSeventh", "sharpenedSupertonic", 3),
                    new Chord("major", "tonic", 0)
            ),
            // 63-64a
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("dominantMajorThirteenth", "dominant", 0),
                    new Chord("minor", "subdominant", 2),
                    new Chord("major", "tonic", 0)
            ),
            // 64b-66
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "mediant", 2),
                    new Chord("minor", "submediant", 0),
                    new Chord("minor", "submediant", 1),
                    new Chord("dominantMajorThirteenth", "supertonic", 0),
                    new Chord("major", "dominant", 0),
                    new Chord("major", "supertonic", 0),
                    new Chord("major", "dominant", 0)
            ),
            // 67-68a
            new Progression(
                    "major",
                    new Chord("minor", "dominant", 0),
                    new Chord("minor", "dominant", 1),
                    new Chord("dominantMajorThirteenth", "tonic", 0),
                    new Chord("major", "subdominant", 0),
                    new Chord("major", "tonic", 0),
                    new Chord("major", "subdominant", 0)
            ),
            // 68b-70a
            new Progression(
                    "major",
                    new Chord("major", "tonic", 0),
                    new Chord("major", "subdominant", 0),
                    new Chord("minorSeventh", "subtonic", 1),
                    new Chord("dominantSeventh", "mediant", 0),
                    new Chord("halfDiminishedSeventh", "subtonic", 3),
                    new Chord("minor", "submediant", 0)
            ),
            // 70b-72
            new Progression(
                    "major",
                    new Chord("diminishedSeventh", "sharpenedSubmediant", 0),
                    new Chord("major", "subtonic", 0),
                    new Chord("diminishedSeventh", "sharpenedSubmediant", "subtonicPedal"),
                    new Chord("major", "subtonic", 0),
                    new Chord("dominantSeventh", "dominant", 1)
            ),
            // 73-76
            new Progression(
                    "major",
                    new Chord("major", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", 2),
                    new Chord("major", "sharpenedSupertonic", 0),
                    new Chord("dominantSeventh", "sharpenedSubmediant", 2)
            ),
            // 77-88 identical to 61-72
            // 89-92 identical to 73-76
            // 93-94
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("dominantMajorThirteenth", "dominant", 0),
                    new Chord("diminishedSeventh", "sharpenedSupertonic", 3),
                    new Chord("majorSeventh", "tonic", 0)
            ),
            // 95-96
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "subtonic", 0),
                    new Chord("dominantMinorThirteenth", "subtonic", 0),
                    new Chord("diminishedSeventh", "sharpenedSupertonic", "mediantPedal"),
                    new Chord("minor", "mediant", 0),
                    new Chord("diminishedSeventh", "sharpenedSupertonic", "mediantPedal"),
                    new Chord("minor", "mediant", 0)
            ),
            // 97-99a
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("dominantMajorThirteenth", "dominant", 0),
                    new Chord("diminishedSeventh", "sharpenedSupertonic", 3),
                    new Chord("major", "tonic", 0),
                    new Chord("minorSeventh", "submediant", 0),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 99b-100
            new Progression(
                    "major",
                    new Chord("dominantMajorThirteenth", "dominant", 0),
                    new Chord("minor", "sharpenedMediant", 1)
            ),
            // 101-103a
            new Progression(
                    "minor",
                    new Chord("dominantSeventh", "tonic", 1),
                    new Chord("halfDiminishedSeventh", "supertonic", 1),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0)
            ),
            // 103b-105a
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "tonic", 1),
                    new Chord("halfDiminishedSeventh", "supertonic", 1),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0),
            ),
            // 105b-107a
            new Progression(
                    "minor",
                    new Chord("diminishedSeventh", "sharpenedTonic", 3),
                    new Chord("diminishedSeventh", "sharpenedTonic", 2),
                    new Chord("diminishedSeventh", "sharpenedMediant", 0),
                    new Chord("major", "subdominant", 1)
            ),
            // 107b-109a
            new Progression(
                    "minor",
                    new Chord("diminishedSeventh", "sharpenedSubdominant", 2),
                    new Chord("diminishedSeventh", "sharpenedSubdominant", 0),
                    new Chord("diminishedSeventh", "sharpenedSubtonic", 2)
            ),
            // 109b-112
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 1),
                    new Chord("dominantSeventh", "dominant", 1),
                    new Chord("minor", "tonic", 0),
                    new Chord("minorSeventh", "subdominant", 0),
                    new Chord("minor", "tonic", 2),
                    new Chord("halfDiminishedSeventh", "supertonic", 2)
            ),
            // 113-114 is a solo RH (atonal) passage
            // 115-118
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 2),
                    new Chord("major", "dominant", 0)
            ),
            // 119-122
            new Progression(
                    "minor",
                    new Chord("minor", "dominant", 0),
                    new Chord("major", "supertonic", 0),
                    new Chord("major", "subdominant", 0),
                    new Chord("major", "tonic", 0),
                    new Chord("diminishedSeventh", "sharpenedSubdominant", 2),
                    new Chord("germanAugmentedSixth", "flattenedTonic", 0),
                    new Chord("major", "mediant", 2),
                    new Chord("dominantSeventh", "dominant", 1)
            ),
            // 123-126
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 1),
                    new Chord("major", "supertonic", 0),
                    new Chord("frenchAugmentedSixth", "flattenedSupertonic", 0),
                    new Chord("major", "tonic", 0),
                    new Chord("dominantSeventh", "subdominant", 1),
                    new Chord("germanAugmentedSixth", "submediant", 0),
                    new Chord("minor", "tonic", 2),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 127-129a
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "tonic", 0),
                    new Chord("minor", "subdominant", 2),
                    new Chord("halfDiminishedSeventh", "supertonic", 3),
                    new Chord("major", "tonic", 0)
            ),
            // 129b-131a
            new Progression(
                    "minor",
                    new Chord("major", "tonic", 0),
                    new Chord("dominantSeventh", "tonic", 0),
                    new Chord("halfDiminishedSeventh", "supertonic", 1),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 0)
            ),
            // 131b-133a
            new Progression(
                    "minor",
                    new Chord("major", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", "tonicPedal"),
                    new Chord("major", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", "tonicPedal"),
                    new Chord("major", "tonic", 0)
            ),
            // 133b-135a identical to 131b-133a
            // 135b-137
            new Progression(
                    "minor",
                    new Chord("major", "tonic", 0),
                    new Chord("majorSeventh", "tonic", 3),
                    new Chord("minorSeventh", "sharpenedSubmediant", 0),
                    new Chord("major", "tonic", 2),
                    new Chord("major", "tonic", 0)
            )
    );
            
    // Nocturne No. 15 in F minor, Op. 55 No. 1
    private List<Progression> chopinOp55No1 = Arrays.asList(
            // 1-2
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "subtonic", 1),
                    new Chord("major", "mediant", 0),
                    new Chord("dominantSeventh", "dominant", 1)
            ),
            // 3-4 identical to 1-2
            // 5-8a
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "subtonic", 1),
                    new Chord("major", "mediant", 0),
                    new Chord("major", "flattenedSupertonic", 1),
                    new Chord("minor", "tonic", 2),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0)
            ),
            // 8b
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("major", "dominant", "tonicPedal")
            ),
            // 9-16a identical to 1-8a
            // 16b-18a
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("italianAugmentedSixth", "flattenedTonic", 0),
                    new Chord("dominantSeventh", "subtonic", 0),
                    new Chord("major", "mediant", 0)
            ),
            // 18b-20a
            new Progression(
                    "minor",
                    new Chord("minorSeventh", "sharpenedSubmediant", 2),
                    new Chord("dominantSeventh", "supertonic", 0),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 20b-24
            new Progression(
                    "minor",
                    new Chord("minorSeventh", "tonic", 2),
                    new Chord("minor", "dominant", 0),
                    new Chord("majorSeventh", "submediant", 3),
                    new Chord("major", "mediant", 2)
                    new Chord("dominantSeventh", "supertonic", "dominantPedal"),
                    new Chord("major", "dominant", 0),
                    new Chord("dominantSeventh", "supertonic", "dominantPedal"),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 25-32a identical to 1-8a
            // 32b-40 identical to 16b-24
            // 41-48a identical to 1-8a
            // 48b-50a
            new Progression(
                    "minor",
                    new Chord("diminishedSeventh", "sharpenedSubtonic", 0),
                    new Chord("minor", "tonic", 0),
                    new Chord("halfDiminishedSeventh", "supertonic", 3),
                    new Chord("minor", "tonic", 0)
            ),
            // 50b-52a
            new Progression(
                    "minor",
                    new Chord("diminishedSeventh", "sharpenedSubtonic", 0),
                    new Chord("minor", "dominant", 2),
                    new Chord("dominantSeventh", "supertonic", 0),
                    new Chord("minor", "dominant", 0),
                    new Chord("dominantSeventh", "supertonic", "dominantPedal"),
                    new Chord("minor", "dominant", 0)
            ),
            // 52b-54a
            new Progression(
                    "minor",
                    new Chord("major", "supertonic", 0),
                    new Chord("minor", "dominant", 0),
                    new Chord("halfDiminishedSeventh", "sharpenedSubmediant", 3),
                    new Chord("minor", "dominant", 0)
            ),
            // 54b-56
            new Progression(
                    "minor",
                    new Chord("diminishedSeventh", "sharpenedSubdominant", 0),
                    new Chord("major", "supertonic", 2),
                    new Chord("dominantSeventh", "sharpenedSubmediant", 0),
                    new Chord("major", "supertonic", 0),
                    new Chord("dominantSeventh", "sharpenedSubmediant", "supertonicPedal"),
                    new Chord("major", "supertonic", 0)
            ),
            // 57-58
            new Progression(
                    "minor",
                    new Chord("diminishedSeventh", "sharpenedSubtonic", 0),
                    new Chord("minor", "tonic", 0),
                    new Chord("minor", "tonic", 1)
            ),
            // 59-60
            new Progression(
                    "minor",
                    new Chord("halfDiminishedSeventh", "supertonic", 0),
                    new Chord("diminishedSeventh", "sharpenedSubtonic", 1),
                    new Chord("majorSeventh", "mediant", 0),
                    new Chord("minor", "tonic", 1)
            ),
            // 61-62
            new Progression(
                    "minor",
                    new Chord("diminishedSeventh", "sharpenedMediant", 0),
                    new Chord("minor", "subdominant", 0),
                    new Chord("minor", "subdominant", 1)
            ),
            // 63-64
            new Progression(
                    "minor",
                    new Chord("halfDiminishedSeventh", "dominant", 0),
                    new Chord("diminishedSeventh", "sharpenedMediant", 1),
                    new Chord("majorSeventh", "submediant", 0),
                    new Chord("minor", "subdominant", 1)
            ),
            // 65-69a
            new Progression(
                    "minor",
                    new Chord("major", "flattenedSupertonic", 2),
                    new Chord("halfDiminishedSeventh", "supertonic", 2),
                    new Chord("diminishedSeventh", "sharpenedSubtonic", 3),
                    new Chord("dominantSeventh", "submediant", 0)
            ),
            // 69b-70 is a solo RH passage
            // 71-72
            new Progression(
                    "minor",
                    new Chord("major", "dominant", 0),
                    new Chord("dominantSeventh", "submediant", 3),
                    new Chord("dominantSeventh", "subdominant", 0),
                    new Chord("dominantSeventh", "sharpenedSubtonic", 0),
                    new Chord("dominantSeventh", "sharpenedMediant", 0),
                    new Chord("minor", "tonic", 1),
                    new Chord("diminishedSeventh", "sharpenedSubdominant", "supertonicPedal"),
                    new chord("dominantSeventh", "dominant", 0)
            ),
            // 73-76 identical to 1-4
            // 77-78
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("diminished", "sharpenedSubtonic", "tonicPedal"),
                    new Chord("dominantSeventh", "tonic", 0),
                    new Chord("major", "subdominant", 0),
                    new Chord("minor", "subdominant", 0),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 79-80
            new Progression(
                    "minor",
                    new Chord("augmented", "submediant", 0),
                    new Chord("major", "submediant", 0),
                    new Chord("major", "flattenedSupertonic", 1),
                    new Chord("minor", "tonic", 2),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 81-82 identical to 77-78
            // 83-84
            new Progression(
                    "minor",
                    new Chord("augmented", "submediant", 0),
                    new Chord("major", "submediant", 0),
                    new Chord("major", "flattenedSupertonic", 1),
                    new Chord("dominantSeventh", "submediant", 3),
                    new Chord("major", "flattenedSupertonic", 1),
                    new Chord("dominantSeventh", "submediant", 3),
                    new Chord("minor", "tonic", 2),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 85-97
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("diminishedSeventh", "sharpenedMediant", "tonicPedal"),
                    new Chord("halfDiminishedSeventh", "supertonic", "tonicPedal"),
                    new Chord("diminishedSeventh", "sharpenedSubtonic", "tonicPedal"),
                    new Chord("major", "tonic", 0)
            ),
            // 98-101
            new Progression(
                    "minor",
                    new Chord("halfDiminishedSeventh", "supertonic", 1),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 0)
            )
    );
    
    // Nocturne No. 20 in C# minor, Op. posth B.49
    private List<Progression> chopinB49 = Arrays.asList(
            // 1-2
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("minorSeventh", "tonic", 0),
                    new Chord("minor", "subdominant", 0),
                    new Chord("minor", "tonic", 0),
                    new Chord("germanAugmentedSixth", "submediant", 0),
                    new Chord("major", "dominant", 0)
            ),
            // 3-4 identical to 1-2
            // 5-8
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("halfDiminishedSeventh", "supertonic", 3),
                    new Chord("minor", "tonic", 0),
                    new Chord("major", "tonic", 0),
                    new Chord("halfDiminishedSeventh", "supertonic", 0)
            ),
            // 9-12
            new Progression(
                    "minor",
                    new Chord("major", "dominant", 1),
                    new Chord("minor", "tonic", 0),
                    new Chord("halfDiminishedSeventh", "supertonic", 2),
                    new Chord("halfDiminishedSeventh", "supertonic", "dominantPedal"),
                    new Chord("major", "dominant", 0),
                    new Chord("halfDiminishedSeventh", "sharpenedSubmediant", 3),
                    new Chord("major", "dominant", 0)
            ),
            // 13-16
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("halfDiminishedSeventh", "supertonic", 3),
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "tonic", 0),
                    new Chord("minor", "subdominant", 0)
            ),
            // 17-20
            new Progression(
                    "minor",
                    new Chord("major", "flattenedSupertonic", 1),
                    new Chord("diminishedSeventh", "sharpenedSubtonic", 2),
                    new Chord("germanAugmentedSixth", "submediant", 3),
                    new Chord("majorSeventh", "submediant", 3),
                    new Chord("dominantNinth", "dominant", 0),
                    new Chord("minor", "tonic", 0)
            ),
            // 21-24
            new Progression(
                    "major",
                    new Chord("major", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", "tonicPedal"),
                    new Chord("major", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", "tonicPedal"),
                    new Chord("major", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", "tonicPedal"),
                    new Chord("major", "tonic", 0)
            ),
            // 25-28
            new Progression(
                    "minor",
                    new Chord("minor", "subdominant", 0),
                    new Chord("dominantSeventh", "tonic", "subdominantPedal"),
                    new Chord("minor", "subdominant", 0),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0)
            ),
            // 29-30
            new Progression(
                    "major",
                    new Chord("dominantSeventhFlatFive", "dominant", 2),
                    new Chord("augmentedMajorSeventh", "flattenedSubmediant", 1),
                    new Chord("dominantSeventhFlatFive", "dominant", 2),
                    new Chord("major", "tonic", 0)
            ),
            // 31-33
            new Progression(
                    "major",
                    new Chord("diminishedSeventh", "sharpenedSubdominant", 0),
                    new Chord("augmentedMajorSeventh", "flattenedSubmediant", 3),
                    new Chord("diminished", "sharpenedTonic", 2),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 0)
            ),
            // 34-37
            new Progression(
                    "minor",
                    new Chord("dominantSeventhFlatFive", "dominant", 2),
                    new Chord("major", "tonic", 0),
                    new Chord("minor", "mediant", 1),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 0)
            ),
            // 38-41 identical to 34-37
            // 42-43 identical to 36-37
            // 44-46 identical to 36-37 (with last chord extended by one measure)
            // 47-50 identical to 13-16
            // 51-54a
            new Progression(
                    "minor",
                    new Chord("dominantSeventh", "dominant", 1),
                    new Chord("minor", "tonic", 0),
                    new Chord("halfDiminishedSeventh", "supertonic", 2),
                    new Chord("halfDiminishedSeventh", "supertonic", "dominantPedal"),
                    new Chord("dominantSeventh", "dominant", 0)
                    new Chord("diminishedSeventh", "sharpenedSubdominant", 0)
            ),
            // 54b-58a
            new Progression(
                    "minor",
                    new Chord("minorSeventh", "supertonic", 1),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("dominantSeventh", "dominant", 1),
                    new Chord("minor", "tonic", 0),
                    new Chord("halfDiminishedSeventh", "supertonic", 2),
                    new Chord("halfDiminishedSeventh", "supertonic", "dominantPedal"),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0)
            ),
            // 58b-60a
            new Progression(
                    "minor",
                    new Chord("halfDiminishedSeventh", "supertonic", 3),
                    new Chord("minor", "tonic", 0),
                    new Chord("halfDiminishedSeventh", "supertonic", 3),
                    new Chord("minor", "tonic", 0)
            ),
            // 60b-62a identical to 58b-60a
            // 62b-65
            new Progression(
                    "minor",
                    new Chord("halfDiminishedSeventh", "supertonic", 3),
                    new Chord("minor", "tonic", 0),
                    new Chord("halfDiminishedSeventh", "supertonic", 3),
                    new Chord("major", "tonic", 0)
            )
    );
    
    // Nocturne No. 21 in C minor, Op. posth B.108
    private List<Progression> chopinB108 = Arrays.asList(
            // 1-4
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", "tonicPedal"),
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0),
                    new Chord("minor", "tonic", 2),
                    new Chord("major", "dominant", 0)
            ),
            // 5-8
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", "tonicPedal"),
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0)
            ),
            // 9-12
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", "tonicPedal"),
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0),
                    new Chord("diminishedSeventh", "sharpenedSubdominant", "dominantPedal"),
                    new Chord("major", "dominant", 0)
            ),
            // 13-16
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "tonic", 0),
                    new Chord("minor", "subdominant", 0),
                    new Chord("halfDiminishedSeventh", "supertonic", 1),
                    new Chord("minor", "tonic", 2),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0)
            ),
            // 17-18
            new Progression(
                    "minor",
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0),
                    new Chord("major", "submediant", "dominantPedal"),
                    new Chord("major", "dominant", 0)
            ),
            // 19-20 identical to 17-18
            // 21-24
            new Progression(
                    "minor",
                    new Chord("dominantSeventh", "dominant", 1),
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", 2),
                    new Chord("minor", "tonic", 1),
                    new Chord("halfDiminishedSeventh", "supertonic", 1),
                    new Chord("minor", "tonic", 2),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0)
            ),
            // 25-28
            new Progression(
                    "minor",
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", 2),
                    new Chord("minor", "tonic", 1),
                    new Chord("halfDiminishedSeventh", "supertonic", 1),
                    new Chord("minor", "tonic", 2),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0)
            ),
            // 29-32
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 2),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 2),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 2),
                    new Chord("dominantSeventh", "dominant", 0,
                    new Chord("major", "tonic", 0),
            ),
            // 33-34
            new Progression(
                    "minor",
                    new Chord("dominantSeventh", "dominant", 1),
                    new Chord("minor", "tonic", 0),
                    new Chord("major", "submediant", "dominantPedal"),
                    new Chord("major", "dominant", 0)
            ),
            // 35-36
            new Progression(
                    "minor",
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 2),
                    new Chord("major", "submediant", "dominantPedal"),
                    new Chord("major", "dominant", 0)
            )
            // 37-40 identical to 21-24
            // 41-44 identical to 25-28
    );
                
    // Nocturne No. 22 in C# minor, Op. A1 No. 6
    private List<Progression> chopinOpA1No6 = Arrays.asList(
            // 1-4
            new Progression(
                    "minor",
                    new Chord("minor", "tonic", 0),
                    new Chord("diminished", "sharpenedSubtonic", 0),
                    new Chord("minor", "tonic", 0),
                    new Chord("halfDiminishedSeventh", "supertonic", 0),
                    new Chord("diminishedSeventh", "sharpenedSubtonic", 1)
            ),
            // 5-8
            new Progression(
                    "minor",
                    new Chord("dominantSeventh", "dominant", 1),
                    new Chord("minor", "tonic", 2),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("dominantSeventh", "dominant", "tonicPedal"),
                    new Chord("minor", "tonic", 0)
            ),
            // 9-13
            new Progression(
                    "major",
                    new Chord("dominantNinth", "dominant", 1),
                    new Chord("dominantSeventh", "dominant", 1),
                    new Chord("major", "tonic", 0),
                    new Chord("halfDiminishedSeventh", "subtonic", 2),
                    new Chord("major", "subdominant", 1),
                    new Chord("minor", "supertonic", 0),
                    new Chord("diminished", "supertonic", 1),
                    new Chord("major", "tonic", 2)
            ),
            // 14-15a
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("diminishedSeventh", "sharpenedSubmediant", 3),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("diminishedSeventh", "sharpenedSubmediant", 3),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 0)
            ),
            // 15b-16 is a solo RH atonal passage
            // 17-21
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "submediant", 1),
                    new Chord("minor", "supertonic", 0),
                    new Chord("dominantSeventh", "submediant", 2),
                    new Chord("minor", "supertonic", 1),
                    new Chord("diminished", "supertonic", 1),
                    new Chord("dominantSeventh", "dominant", 0),
            ),
            // 22-26a
            new Progression(
                    "minor",
                    new Chord("diminishedSeventh", "sharpenedSubtonic", 0),
                    new Chord("minor", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", 2),
                    new Chord("minor", "tonic", 1),
                    new Chord("dominantSeventh", "sharpenedSubmediant", 2),
                    new Chord("major", "supertonic", 0),
                    new Chord("dominantSeventh", "dominant", 2),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 26b-28 is a solo RH atonal passage
            // 29-36 identical to 1-8
            // 37-44a
            new Progression(
                    "minor",
                    new Chord("dominantSeventh", "tonic", 1),
                    new Chord("minor", "subdominant", 0),
                    new Chord("diminishedSeventh", "sharpenedSubdominant", 0),
                    new Chord("minor", "tonic", 2),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("minor", "tonic", 0)
            ),
            // 45-64 has a fast harmonic tempo. I'm not sure whether or not to keep the entire 
            // two-bar progressions intact or to split it into one-bar or half-bar phrases.
            // 44b-46a
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "dominant", 1),
                    new Chord("major", "tonic", 0),
                    new Chord("diminishedSeventh", "sharpenedSupertonic", 3),
                    new Chord("major", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", 1),
                    new Chord("major", "tonic", 0),
                    new Chord("minor", "supertonic", 0),
                    new Chord("dominantSeventh", "dominant", 2)
            ),
            // 46b-48a
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "dominant", 3),
                    new Chord("dominantSeventh", "dominant", 2),
                    new Chord("dominantSeventh", "dominant", 1),
                    new Chord("major", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", 2),
                    new Chord("minorSeventh", "submediant", 2),
                    new Chord("diminishedSeventh", "sharpenedSupertonic", 0),
                    new Chord("major", "tonic", 1),
            ),
            // 48b-50a
            new Progression(
                    "major",
                    new Chord("diminishedSeventh", "sharpenedTonic", 1),
                    new Chord("dominantSeventh", "supertonic", 0),
                    new Chord("diminishedSeventh", "subtonic", 1),
                    new Chord("major", "tonic", 0)
            ),
            // 50b-52a
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "submediant", 0)
                    new Chord("dominantSeventh", "supertonic", 0),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("major", "tonic", 0)
            ),
            // 52b-53a
            new Progression(
                    "major",
                    new Chord("major", "tonic", 1),
                    new Chord("dominantSeventh", "dominant", 2),
                    new Chord("major", "tonic", 0),
                    new Chord("dominantSeventh", "dominant", 0),
                    new Chord("diminishedSeventh", "sharpenedSubmediant", 3),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 53b-54
            new Progression(
                    "major",
                    new Chord("dominantSeventh", "subtonic", 3),
                    new Chord("minor", "subdominant", 1),
                    new Chord("dominantSeventh", "dominant", 0)
            ),
            // 55a identical to 53a
            // 55b-56 identical to 53b-54
            // 57-64 identical to 45-52a
            // 65
            new Progression(
                    "minor",
                    new Chord("dominantSeventh", "dominant", 0)
            )
            // 66-109 identical to 1-44a
    );
 
    public ProgressionLibrary() {

    }

    private class Progression {

        int numOfChords;
        String keyType;
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

        public Progression(String keyType, Chord first) {

            this.keyType = keyType;
            this.first = first;
            this.numOfChords = 1;

        }

        public Progression(String keyType, Chord first, Chord second) {

            this.keyType = keyType;
            this.first = first;
            this.second = second;
            this.numOfChords = 2;

        }

        public Progression(String keyType, Chord first, Chord second, Chord third) {

            this.keyType = keyType;
            this.first = first;
            this.second = second;
            this.third = third;
            this.numOfChords = 3;

        }

        public Progression(String keyType, Chord first, Chord second, Chord third, Chord fourth) {

            this.keyType = keyType;
            this.first = first;
            this.second = second;
            this.third = third;
            this.fourth = fourth;
            this.numOfChords = 4;

        }

        public Progression(String keyType, Chord first, Chord second, Chord third, Chord fourth, Chord fifth) {

            this.keyType = keyType;
            this.first = first;
            this.second = second;
            this.third = third;
            this.fourth = fourth;
            this.fifth = fifth;
            this.numOfChords = 5;

        }

        public Progression(String keyType, Chord first, Chord second, Chord third, Chord fourth, Chord fifth, Chord sixth) {

            this.keyType = keyType;
            this.first = first;
            this.second = second;
            this.third = third;
            this.fourth = fourth;
            this.fifth = fifth;
            this.sixth = sixth;
            this.numOfChords = 6;

        }

        public Progression(String keyType, Chord first, Chord second, Chord third, Chord fourth, Chord fifth, Chord sixth, Chord seventh) {

            this.keyType = keyType;
            this.first = first;
            this.second = second;
            this.third = third;
            this.fourth = fourth;
            this.fifth = fifth;
            this.sixth = sixth;
            this.seventh = seventh;
            this.numOfChords = 7;

        }

        public Progression(String keyType, Chord first, Chord second, Chord third, Chord fourth, Chord fifth, Chord sixth, Chord seventh, Chord eighth) {

            this.keyType = keyType;
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

        public Progression(String keyType, Chord first, Chord second, Chord third, Chord fourth, Chord fifth, Chord sixth, Chord seventh, Chord eighth, Chord ninth) {

            this.keyType = keyType;
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

        public Progression(String keyType, Chord first, Chord second, Chord third, Chord fourth, Chord fifth, Chord sixth, Chord seventh, Chord eighth, Chord ninth, Chord tenth) {

            this.keyType = keyType;
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

        public Progression(String keyType, Chord first, Chord second, Chord third, Chord fourth, Chord fifth, Chord sixth, Chord seventh, Chord eighth, Chord ninth, Chord tenth, Chord eleventh) {

            this.keyType = keyType;
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

        public Progression(String keyType, Chord first, Chord second, Chord third, Chord fourth, Chord fifth, Chord sixth, Chord seventh, Chord eighth, Chord ninth, Chord tenth, Chord eleventh, Chord twelfth) {

            this.keyType = keyType;
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

        public int getNumOfChords() {
            return numOfChords;
        }

        public String getKeyType() {
            return keyType;
        }

        public ArrayList<ArrayList<String>> getChords(Key key) {

            ArrayList<ArrayList<String>> chords = new ArrayList<>();

            if (this.keyType.equals(key.getKeyType())) {

                if (this.keyType.equals("major")) {

                    if (numOfChords == 1) {

                        chords.add(first.getNotesInMajorKey(key));
                        return chords;

                    } else if (numOfChords == 2) {

                        chords.add(first.getNotesInMajorKey(key));
                        chords.add(second.getNotesInMajorKey(key));
                        return chords;

                    } else if (numOfChords == 3) {

                        chords.add(first.getNotesInMajorKey(key));
                        chords.add(second.getNotesInMajorKey(key));
                        chords.add(third.getNotesInMajorKey(key));
                        return chords;

                    } else if (numOfChords == 4) {

                        chords.add(first.getNotesInMajorKey(key));
                        chords.add(second.getNotesInMajorKey(key));
                        chords.add(third.getNotesInMajorKey(key));
                        chords.add(fourth.getNotesInMajorKey(key));
                        return chords;

                    } else if (numOfChords == 5) {

                        chords.add(first.getNotesInMajorKey(key));
                        chords.add(second.getNotesInMajorKey(key));
                        chords.add(third.getNotesInMajorKey(key));
                        chords.add(fourth.getNotesInMajorKey(key));
                        chords.add(fifth.getNotesInMajorKey(key));
                        return chords;

                    } else if (numOfChords == 6) {

                        chords.add(first.getNotesInMajorKey(key));
                        chords.add(second.getNotesInMajorKey(key));
                        chords.add(third.getNotesInMajorKey(key));
                        chords.add(fourth.getNotesInMajorKey(key));
                        chords.add(fifth.getNotesInMajorKey(key));
                        chords.add(sixth.getNotesInMajorKey(key));
                        return chords;

                    } else if (numOfChords == 7) {

                        chords.add(first.getNotesInMajorKey(key));
                        chords.add(second.getNotesInMajorKey(key));
                        chords.add(third.getNotesInMajorKey(key));
                        chords.add(fourth.getNotesInMajorKey(key));
                        chords.add(fifth.getNotesInMajorKey(key));
                        chords.add(sixth.getNotesInMajorKey(key));
                        chords.add(seventh.getNotesInMajorKey(key));
                        return chords;

                    } else if (numOfChords == 8) {

                        chords.add(first.getNotesInMajorKey(key));
                        chords.add(second.getNotesInMajorKey(key));
                        chords.add(third.getNotesInMajorKey(key));
                        chords.add(fourth.getNotesInMajorKey(key));
                        chords.add(fifth.getNotesInMajorKey(key));
                        chords.add(sixth.getNotesInMajorKey(key));
                        chords.add(seventh.getNotesInMajorKey(key));
                        chords.add(eighth.getNotesInMajorKey(key));
                        return chords;

                    } else if (numOfChords == 9) {

                        chords.add(first.getNotesInMajorKey(key));
                        chords.add(second.getNotesInMajorKey(key));
                        chords.add(third.getNotesInMajorKey(key));
                        chords.add(fourth.getNotesInMajorKey(key));
                        chords.add(fifth.getNotesInMajorKey(key));
                        chords.add(sixth.getNotesInMajorKey(key));
                        chords.add(seventh.getNotesInMajorKey(key));
                        chords.add(eighth.getNotesInMajorKey(key));
                        chords.add(ninth.getNotesInMajorKey(key));
                        return chords;

                    } else if (numOfChords == 10) {

                        chords.add(first.getNotesInMajorKey(key));
                        chords.add(second.getNotesInMajorKey(key));
                        chords.add(third.getNotesInMajorKey(key));
                        chords.add(fourth.getNotesInMajorKey(key));
                        chords.add(fifth.getNotesInMajorKey(key));
                        chords.add(sixth.getNotesInMajorKey(key));
                        chords.add(seventh.getNotesInMajorKey(key));
                        chords.add(eighth.getNotesInMajorKey(key));
                        chords.add(ninth.getNotesInMajorKey(key));
                        chords.add(tenth.getNotesInMajorKey(key));
                        return chords;

                    } else if (numOfChords == 11) {

                        chords.add(first.getNotesInMajorKey(key));
                        chords.add(second.getNotesInMajorKey(key));
                        chords.add(third.getNotesInMajorKey(key));
                        chords.add(fourth.getNotesInMajorKey(key));
                        chords.add(fifth.getNotesInMajorKey(key));
                        chords.add(sixth.getNotesInMajorKey(key));
                        chords.add(seventh.getNotesInMajorKey(key));
                        chords.add(eighth.getNotesInMajorKey(key));
                        chords.add(ninth.getNotesInMajorKey(key));
                        chords.add(tenth.getNotesInMajorKey(key));
                        chords.add(eleventh.getNotesInMajorKey(key));
                        return chords;

                    } else if (numOfChords == 12) {

                        chords.add(first.getNotesInMajorKey(key));
                        chords.add(second.getNotesInMajorKey(key));
                        chords.add(third.getNotesInMajorKey(key));
                        chords.add(fourth.getNotesInMajorKey(key));
                        chords.add(fifth.getNotesInMajorKey(key));
                        chords.add(sixth.getNotesInMajorKey(key));
                        chords.add(seventh.getNotesInMajorKey(key));
                        chords.add(eighth.getNotesInMajorKey(key));
                        chords.add(ninth.getNotesInMajorKey(key));
                        chords.add(tenth.getNotesInMajorKey(key));
                        chords.add(eleventh.getNotesInMajorKey(key));
                        chords.add(twelfth.getNotesInMajorKey(key));
                        return chords;

                    } else {
                        return chords;
                    }

                } else if (this.keyType.equals("minor")) {

                    if (numOfChords == 1) {

                        chords.add(first.getNotesInMinorKey(key));
                        return chords;

                    } else if (numOfChords == 2) {

                        chords.add(first.getNotesInMinorKey(key));
                        chords.add(second.getNotesInMinorKey(key));
                        return chords;

                    } else if (numOfChords == 3) {

                        chords.add(first.getNotesInMinorKey(key));
                        chords.add(second.getNotesInMinorKey(key));
                        chords.add(third.getNotesInMinorKey(key));
                        return chords;

                    } else if (numOfChords == 4) {

                        chords.add(first.getNotesInMinorKey(key));
                        chords.add(second.getNotesInMinorKey(key));
                        chords.add(third.getNotesInMinorKey(key));
                        chords.add(fourth.getNotesInMinorKey(key));
                        return chords;

                    } else if (numOfChords == 5) {

                        chords.add(first.getNotesInMinorKey(key));
                        chords.add(second.getNotesInMinorKey(key));
                        chords.add(third.getNotesInMinorKey(key));
                        chords.add(fourth.getNotesInMinorKey(key));
                        chords.add(fifth.getNotesInMinorKey(key));
                        return chords;

                    } else if (numOfChords == 6) {

                        chords.add(first.getNotesInMinorKey(key));
                        chords.add(second.getNotesInMinorKey(key));
                        chords.add(third.getNotesInMinorKey(key));
                        chords.add(fourth.getNotesInMinorKey(key));
                        chords.add(fifth.getNotesInMinorKey(key));
                        chords.add(sixth.getNotesInMinorKey(key));
                        return chords;

                    } else if (numOfChords == 7) {

                        chords.add(first.getNotesInMinorKey(key));
                        chords.add(second.getNotesInMinorKey(key));
                        chords.add(third.getNotesInMinorKey(key));
                        chords.add(fourth.getNotesInMinorKey(key));
                        chords.add(fifth.getNotesInMinorKey(key));
                        chords.add(sixth.getNotesInMinorKey(key));
                        chords.add(seventh.getNotesInMinorKey(key));
                        return chords;

                    } else if (numOfChords == 8) {

                        chords.add(first.getNotesInMinorKey(key));
                        chords.add(second.getNotesInMinorKey(key));
                        chords.add(third.getNotesInMinorKey(key));
                        chords.add(fourth.getNotesInMinorKey(key));
                        chords.add(fifth.getNotesInMinorKey(key));
                        chords.add(sixth.getNotesInMinorKey(key));
                        chords.add(seventh.getNotesInMinorKey(key));
                        chords.add(eighth.getNotesInMinorKey(key));
                        return chords;

                    } else if (numOfChords == 9) {

                        chords.add(first.getNotesInMinorKey(key));
                        chords.add(second.getNotesInMinorKey(key));
                        chords.add(third.getNotesInMinorKey(key));
                        chords.add(fourth.getNotesInMinorKey(key));
                        chords.add(fifth.getNotesInMinorKey(key));
                        chords.add(sixth.getNotesInMinorKey(key));
                        chords.add(seventh.getNotesInMinorKey(key));
                        chords.add(eighth.getNotesInMinorKey(key));
                        chords.add(ninth.getNotesInMinorKey(key));
                        return chords;

                    } else if (numOfChords == 10) {

                        chords.add(first.getNotesInMinorKey(key));
                        chords.add(second.getNotesInMinorKey(key));
                        chords.add(third.getNotesInMinorKey(key));
                        chords.add(fourth.getNotesInMinorKey(key));
                        chords.add(fifth.getNotesInMinorKey(key));
                        chords.add(sixth.getNotesInMinorKey(key));
                        chords.add(seventh.getNotesInMinorKey(key));
                        chords.add(eighth.getNotesInMinorKey(key));
                        chords.add(ninth.getNotesInMinorKey(key));
                        chords.add(tenth.getNotesInMinorKey(key));
                        return chords;

                    } else if (numOfChords == 11) {

                        chords.add(first.getNotesInMinorKey(key));
                        chords.add(second.getNotesInMinorKey(key));
                        chords.add(third.getNotesInMinorKey(key));
                        chords.add(fourth.getNotesInMinorKey(key));
                        chords.add(fifth.getNotesInMinorKey(key));
                        chords.add(sixth.getNotesInMinorKey(key));
                        chords.add(seventh.getNotesInMinorKey(key));
                        chords.add(eighth.getNotesInMinorKey(key));
                        chords.add(ninth.getNotesInMinorKey(key));
                        chords.add(tenth.getNotesInMinorKey(key));
                        chords.add(eleventh.getNotesInMinorKey(key));
                        return chords;

                    } else if (numOfChords == 12) {

                        chords.add(first.getNotesInMinorKey(key));
                        chords.add(second.getNotesInMinorKey(key));
                        chords.add(third.getNotesInMinorKey(key));
                        chords.add(fourth.getNotesInMinorKey(key));
                        chords.add(fifth.getNotesInMinorKey(key));
                        chords.add(sixth.getNotesInMinorKey(key));
                        chords.add(seventh.getNotesInMinorKey(key));
                        chords.add(eighth.getNotesInMinorKey(key));
                        chords.add(ninth.getNotesInMinorKey(key));
                        chords.add(tenth.getNotesInMinorKey(key));
                        chords.add(eleventh.getNotesInMinorKey(key));
                        chords.add(twelfth.getNotesInMinorKey(key));
                        return chords;

                    } else {
                        return chords;
                    }

                } else {
                    return chords;
                }

            } else {
                return chords;
            }

        }

    }

    // TODO: finish minor keys
    private class Key {

        String key;
        String keyType;

        public Key(String key) {

            this.key = key;
            if (majorKeysAsStrings.contains(key)) {
                this.keyType = "major";
            } else if (minorKeysAsStrings.contains(key)) {
                this.keyType = "minor";
            }

        }

        public String diminishedSecondAboveTonic() {
            if (key.equals("C") || key.equals("Cm")) {
                return "Dbb";
            } else if (key.equals("C#") || key.equals("C#m")) {
                return "Dnb";
            } else if (key.equals("Db")) {
                return "Ebbb";
            } else if (key.equals("D") || key.equals("Dm")) {
                return "Ebb";
            } else if (key.equals("D#m")) {
                return "Enb";
            } else if (key.equals("Eb") || key.equals("Ebm")) {
                return "Fbb";
            } else if (key.equals("E") || key.equals("Em")) {
                return "Fnb";
            } else if (key.equals("F") || key.equals("Fm")) {
                return "Gbb";
            } else if (key.equals("F#") || key.equals("F#m")) {
                return "Gnb";
            } else if (key.equals("Gb")) {
                return "Abbb";
            } else if (key.equals("G") || key.equals("Gm")) {
                return "Abb";
            } else if (key.equals("G#m")) {
                return "Anb";
            } else if (key.equals("Ab") || key.equals("Abm")) {
                return "Bbbb";
            } else if (key.equals("A") || key.equals("Am")) {
                return "Bbb";
            } else if (key.equals("A#m")) {
                return "Bnb";
            } else if (key.equals("Bb") || key.equals("Bbm")) {
                return "Cbb";
            } else if (key.equals("B") || key.equals("Bm")) {
                return "Cnb";
            } else if (key.equals("Cb")) {
                return "Dbbb";
            } else {
                return "";
            }
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

        public String getKeyType() {
            return keyType;
        }

    }

    /**
     * Chord.getNotes(Key key) currently has no support for pedaled chords and no support for minor keys
     * <p>
     * Chromatic note names (major key): sharpened subtonic / tonic
     * sharpened tonic / flattened supertonic
     * supertonic
     * sharpened supertonic / flattened mediant
     * mediant / flattened subdominant
     * sharpened mediant / subdominant
     * sharpened subdominant / flattened dominant
     * dominant
     * sharpened dominant / flattened submediant
     * submediant
     * sharpened submediant / flattened subtonic
     * subtonic / flattened tonic
     * <p>
     * Chromatic note names (minor key): tonic
     * sharpened tonic / flattened supertonic
     * supertonic / flattened mediant
     * sharpened supertonic / mediant
     * sharpened mediant / flattened subdominant
     * subdominant
     * sharpened subdominant / flattened dominant
     * dominant / flattened submediant
     * sharpened dominant / submediant
     * sharpened submediant / flattened subtonic
     * subtonic
     * sharpened subtonic / flattened tonic
     * <p>
     * These are the chords currently supported. All inversions of these chords are also supported
     * unless otherwise stated.
     * <p>
     * Major Chords: tonic, flattened supertonic, supertonic, flattened mediant, mediant, subdominant,
     * sharpened subdominant, flattened dominant, dominant, flattened submediant, submediant,
     * flattened subtonic, subtonic
     * <p>
     * Minor Chords: tonic, flattened supertonic, supertonic, flattened mediant, mediant, subdominant,
     * sharpened subdominant, flattened dominant, dominant, flattened submediant, submediant,
     * flattened subtonic, subtonic
     * <p>
     * Dominant Seventh Chords: tonic, flattened supertonic, supertonic, flattened mediant, mediant,
     * subdominant, dominant, flattened submediant, submediant, flattened subtonic,
     * subtonic
     * <p>
     * Augmented Chord: tonic, flattened supertonic, supertonic, flattened mediant, mediant, subdominant,
     * flattened dominant, dominant
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

        public ArrayList<String> getNotesInMajorKey(Key key) {
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
            } else if (chordType.equals("augmented")) {
                if (chordRoot.equals("tonic")) {
                    if (inversion == 0) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.perfectOctaveAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.perfectOctaveAboveTonic()
                                },
                                new String[]{
                                        key.majorThirdAboveTonic(),
                                        key.augmentedFifthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorThirdAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorThirdAboveTonic()
                                },
                                new String[]{
                                        key.augmentedFifthAboveTonic(),
                                        key.perfectOctaveAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedFifthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedFifthAboveTonic()
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
                                        key.minorSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSixthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSixthAboveTonic()
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
                                        key.augmentedSixthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedFourthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedFourthAboveTonic()
                                },
                                new String[]{
                                        key.augmentedSixthAboveTonic(),
                                        key.majorSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedSixthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedSixthAboveTonic()
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
                                        key.minorThirdAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSeventhAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSeventhAboveTonic()
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
                                        key.augmentedSeventhAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedFifthAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedFifthAboveTonic()
                                },
                                new String[]{
                                        key.augmentedSeventhAboveTonic(),
                                        key.majorThirdAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedSeventhAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedSeventhAboveTonic()
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
                                        key.perfectFourthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedOctaveAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedOctaveAboveTonic()
                                },
                                new String[]{
                                        key.perfectFourthAboveTonic(),
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
                                        key.diminishedFifthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSecondAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSecondAboveTonic()
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
                                        key.augmentedSecondAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 1) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.majorSeventhAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.majorSeventhAboveTonic()
                                },
                                new String[]{
                                        key.augmentedSecondAboveTonic(),
                                        key.perfectFifthAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else if (inversion == 2) {
                        ArrayList<String> notesInChord = new ArrayList<>(Arrays.asList(key.augmentedSecondAboveTonic()));
                        notesInChord.addAll(randomizeVoicing(
                                new String[]{
                                        key.augmentedSecondAboveTonic()
                                },
                                new String[]{
                                        key.perfectFifthAboveTonic(),
                                        key.majorSeventhAboveTonic()
                                }, 1));
                        return notesInChord;
                    } else {
                        return new ArrayList<>();
                    }
                }
                //
                else {
                    return new ArrayList<>();
                }
            }
            // will never get here
            else {
                return new ArrayList<>();
            }
        }

        public ArrayList<String> getNotesInMinorKey(Key key) {
            return new ArrayList<>();
        }
    }

}
