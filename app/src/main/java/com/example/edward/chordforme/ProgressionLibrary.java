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

        List<String> chordsInProgression;
        List<String> chordsInKeyedProgression = Arrays.asList();

        public Progression(String first) {

            List<String> formChordsInProgression = Arrays.asList();
            formChordsInProgression.add(first);
            this.chordsInProgression = formChordsInProgression;

        }

        public Progression(String first, String second) {

            List<String> formChordsInProgression = Arrays.asList();
            formChordsInProgression.add(first);
            formChordsInProgression.add(second);
            this.chordsInProgression = formChordsInProgression;

        }

        public Progression(String first, String second, String third) {

            List<String> formChordsInProgression = Arrays.asList();
            formChordsInProgression.add(first);
            formChordsInProgression.add(second);
            formChordsInProgression.add(third);
            this.chordsInProgression = formChordsInProgression;

        }

        public Progression(String first, String second, String third, String fourth) {

            List<String> formChordsInProgression = Arrays.asList();
            formChordsInProgression.add(first);
            formChordsInProgression.add(second);
            formChordsInProgression.add(third);
            formChordsInProgression.add(fourth);
            this.chordsInProgression = formChordsInProgression;

        }

        public Progression(String first, String second, String third, String fourth, String fifth) {

            List<String> formChordsInProgression = Arrays.asList();
            formChordsInProgression.add(first);
            formChordsInProgression.add(second);
            formChordsInProgression.add(third);
            formChordsInProgression.add(fourth);
            formChordsInProgression.add(fifth);
            this.chordsInProgression = formChordsInProgression;

        }

        public Progression(String first, String second, String third, String fourth, String fifth, String sixth) {

            List<String> formChordsInProgression = Arrays.asList();
            formChordsInProgression.add(first);
            formChordsInProgression.add(second);
            formChordsInProgression.add(third);
            formChordsInProgression.add(fourth);
            formChordsInProgression.add(fifth);
            formChordsInProgression.add(sixth);
            this.chordsInProgression = formChordsInProgression;

        }

        public Progression(String first, String second, String third, String fourth, String fifth, String sixth, String seventh) {

            List<String> formChordsInProgression = Arrays.asList();
            formChordsInProgression.add(first);
            formChordsInProgression.add(second);
            formChordsInProgression.add(third);
            formChordsInProgression.add(fourth);
            formChordsInProgression.add(fifth);
            formChordsInProgression.add(sixth);
            formChordsInProgression.add(seventh);
            this.chordsInProgression = formChordsInProgression;

        }

        public Progression(String first, String second, String third, String fourth, String fifth, String sixth, String seventh, String eighth) {

            List<String> formChordsInProgression = Arrays.asList();
            formChordsInProgression.add(first);
            formChordsInProgression.add(second);
            formChordsInProgression.add(third);
            formChordsInProgression.add(fourth);
            formChordsInProgression.add(fifth);
            formChordsInProgression.add(sixth);
            formChordsInProgression.add(seventh);
            formChordsInProgression.add(eighth);
            this.chordsInProgression = formChordsInProgression;

        }

        // never call this
        public List<String> getProgression() {
            return chordsInProgression;
        }

        public List<String> getKeyedProgression(String key) {
            return chordsInKeyedProgression;
        }

    }

    private void findKeyInterval() {
        keyInterval = (notes.indexOf(endKey) - notes.indexOf(startKey) + 12) % 12;
    }

}
