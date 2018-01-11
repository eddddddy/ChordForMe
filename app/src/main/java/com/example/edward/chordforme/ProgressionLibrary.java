package com.example.edward.chordforme;

import java.util.Arrays;
import java.util.List;

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
     * http://www.kevinboone.net/modulation_library.html
     *
    **/
    // TODO: add minor keys
    private List<List<List<String>>> modulations = Arrays.asList(
            // identity modulation
            Arrays.asList(
                    Arrays.asList("I0")
            ),
            // modulation up a minor second
            Arrays.asList(
                    Arrays.asList("I0","II0","vi72","ii0")
            ),
            // modulation up a major second
            Arrays.asList(
                    Arrays.asList("I0","I1","VI0","II0")
            ),
            // modulation up a minor third
            Arrays.asList(
                    Arrays.asList("I0","I1","IV1","vii70","iii0")
            ),
            // modulation up a major third
            Arrays.asList(
                    Arrays.asList("I0","I1","VII73","III0")
            ),
            // modulation up a perfect fourth
            Arrays.asList(
                    Arrays.asList("I0","I1","I72","IV0")
            ),
            // modulation up a diminished fifth / augmented fourth
            Arrays.asList(
                    Arrays.asList("I0","II70","v2","ii70","v0")
            ),
            // modulation up a perfect fifth
            Arrays.asList(
                    Arrays.asList("I0","II70","V0")
            ),
            // modulation up a minor sixth
            Arrays.asList(
                    Arrays.asList("I0","iii70","vi0")
            ),
            // modulation up a major sixth
            Arrays.asList(
                    Arrays.asList("I0","I1","V70","III70","VI2","VI0")
            ),
            // modulation up a minor seventh
            Arrays.asList(
                    Arrays.asList("I0","V0","I2","IV70","IV73","vii1","vii0")
            ),
            // modulation up a major seventh
            Arrays.asList(
                    Arrays.asList("I0","ii0","v70","VII0")
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

    private void findKeyInterval() {
        keyInterval = (notes.indexOf(endKey) - notes.indexOf(startKey) + 12) % 12;
    }

}
