/*

Pitch Classification (Don't worry about this unless you're Edward):

5 -> 85
    5 -> 31 -------------------------------------------------------------------------------------------------------------- order A: C#1 -> D#3
        5 -> 13 -------------------------------------------------------- family A                             |
            5 -> 7 ---------- genus A                         |                                               |
            8 -> 10 --------- genus B                         |                                               |
            11 -> 13 -------- genus C -------------------------                                               |
        14 -> 22 ------------------------------------------------------- family B                             |
            14 -> 16 -------- genus A                         |                                               |
            17 -> 19 -------- genus B                         |                                               |
            20 -> 22 -------- genus C -------------------------                                               |
        23 -> 31 ------------------------------------------------------- family C                             |
            23 -> 25 -------- genus A                         |                                               |
            26 -> 28 -------- genus B                         |                                               |
            29 -> 31 -------- genus C -------------------------------------------------------------------------
    32 -> 58 ------------------------------------------------------------------------------------------------------------- order B: E3 -> F#5
        32 -> 40 ------------------------------------------------------- family A                             |
            32 -> 34 -------- genus A                         |                                               |
            35 -> 37 -------- genus B                         |                                               |
            38 -> 40 -------- genus C -------------------------                                               |
        41 -> 49 ------------------------------------------------------- family B                             |
            41 -> 43 -------- genus A                         |                                               |
            44 -> 46 -------- genus B                         |                                               |
            47 -> 49 -------- genus C -------------------------                                               |
        50 -> 58 ------------------------------------------------------- family C                             |
            50 -> 52 -------- genus A                         |                                               |
            53 -> 55 -------- genus B                         |                                               |
            56 -> 58 -------- genus C ------------------------------------------------------------------------|
    59 -> 85 ------------------------------------------------------------------------------------------------------------- order C: G5 -> A7
        59 -> 67 ------------------------------------------------------- family A                             |
            59 -> 61 -------- genus A                         |                                               |
            62 -> 64 -------- genus B                         |                                               |
            65 -> 67 -------- genus C -------------------------                                               |
        68 -> 76 ------------------------------------------------------- family B                             |
            68 -> 70 -------- genus A                         |                                               |
            71 -> 73 -------- genus B                         |                                               |
            74 -> 76 -------- genus C -------------------------                                               |
        77 -> 85 ------------------------------------------------------- family C                             |
            77 -> 79 -------- genus A                         |                                               |
            80 -> 82 -------- genus B                         |                                               |
            83 -> 85 -------- genus C -------------------------------------------------------------------------


order A: 33.68f,160.19f
    -> family A: 33.68f,56.64f
        -> genus A: 33.68f,40.05f
            -> species A: 33.68f,35.68f
            -> species B: 35.68f,37.80f
            -> species C: 37.80f,40.05f
        -> genus B: 40.05f,47.62f
            -> species A: 40.05f,42.43f
            -> species B: 42.43f,44.95f
            -> species C: 44.95f,47.62f
        -> genus C: 47.62f,56.64f
            -> species A: 47.62f,50.46f
            -> species B: 50.46f,53.46f
            -> species C: 53.46f,56.64f
    -> family B: 56.64f,95.25f
        -> genus A: 56.64f,67.35f
            -> species A: 56.64f,60.00f
            -> species B: 60.00f,63.57f
            -> species C: 63.57f,67.35f
        -> genus B: 67.35f,80.10f
            -> species A: 67.35f,71.36f
            -> species B: 71.36f,75.60f
            -> species C: 75.60f,80.10f
        -> genus C: 80.10f,95.25f
            -> species A: 80.10f,84.86f
            -> species B: 84.86f,89.90f
            -> species C: 89.90f,95.25f
    -> family C: 95.25f,160.19f
        -> genus A: 95.25f,113.27f
            -> species A: 95.25f,100.91f
            -> species B: 100.91f,106.91f
            -> species C: 106.91f,113.27f
        -> genus B: 113.27f,134.70f
            -> species A: 113.27f,120.01f
            -> species B: 120.01f,127.14f
            -> species C: 127.14f,134.70f
        -> genus C: 134.70f,160.19f
            -> species A: 134.70f,142.71f
            -> species B: 142.71f,151.20f
            -> species C: 151.20f,160.19f
order B: 160.19f,761.99f
    -> family A: 160.19f,269.40f
        -> genus A: 160.19f,190.50f
            -> species A: 160.19f,169.71f
            -> species B: 169.71f,179.81f
            -> species C: 179.81f,190.50f
        -> genus B: 190.50f,226.54f
            -> species A: 190.50f,201.83f
            -> species B: 201.83f,213.83f
            -> species C: 213.83f,226.54f
        -> genus C: 226.54f,269.40f
            -> species A: 226.54f,240.01f
            -> species B: 240.01f,254.28f
            -> species C: 254.28f,269.40f
    -> family B: 269.40f,453.08f
        -> genus A: 269.40f,320.38f
            -> species A: 269.40f,285.42f
            -> species B: 285.42f,302.40f
            -> species C: 302.40f,320.38f
        -> genus B: 320.38f,380.99f
            -> species A: 320.38f,339.43f
            -> species B: 339.43f,359.61f
            -> species C: 359.61f,380.99f
        -> genus C: 380.99f,453.08f
            -> species A: 380.99f,403.65f
            -> species B: 403.65f,427.65f
            -> species C: 427.65f,453.08f
    -> family C: 453.08f,761.99f
        -> genus A: 453.08f,538.81f
            -> species A: 453.08f,480.02f
            -> species B: 480.02f,508.57f
            -> species C: 508.57f,538.81f
        -> genus B: 538.81f,640.75f
            -> species A: 538.81f,570.85f
            -> species B: 570.85f,604.79f
            -> species C: 604.79f,640.75f
        -> genus C: 640.75f,761.99f
            -> species A: 640.75f,678.86f
            -> species B: 678.86f,719.22f
            -> species C: 719.22f,761.99f
order C: 761.99f,3624.66f
    -> family A: 761.99f,1281.51f
        -> genus A: 761.99f,906.16f
            -> species A: 761.99f,807.30f
            -> species B: 807.30f,855.30f
            -> species C: 855.30f,906.16f
        -> genus B: 906.16f,1077.62f
            -> species A: 906.16f,960.05f
            -> species B: 960.05f,1017.13f
            -> species C: 1017.13f,1077.62f
        -> genus C: 1077.62f,1281.51f
            -> species A: 1077.62f,1141.70f
            -> species B: 1141.70f,1209.59f
            -> species C: 1209.59f,1281.51f
    -> family B: 1281.51f,2155.23f
        -> genus A: 1281.51f,1523.98f
            -> species A: 1281.51f,1357.71f
            -> species B: 1357.71f,1438.45f
            -> species C: 1438.45f,1523.98f
        -> genus B: 1523.98f,1812.33f
            -> species A: 1523.98f,1614.60f
            -> species B: 1614.60f,1710.61f
            -> species C: 1710.61f,1812.33f
        -> genus C: 1812.33f,2155.23f
            -> species A: 1812.33f,1920.10f
            -> species B: 1920.10f,2034.27f
            -> species C: 2034.27f,2155.23f
    -> family C: 2155.23f,3624.66f
        -> genus A: 2155.23f,2563.02f
            -> species A: 2155.23f,2283.39f
            -> species B: 2283.39f,2419.17f
            -> species C: 2419.17f,2563.02f
        -> genus B: 2563.02f,3047.96f
            -> species A: 2563.02f,2715.43f
            -> species B: 2715.43f,2876.90f
            -> species C: 2876.90f,3047.96f
        -> genus C: 3047.96f,3624.66f
            -> species A: 3047.96f,3229.20f
            -> species B: 3229.20f,3421.22f
            -> species C: 3421.22f,3624.66f

*/

package com.example.edward.chordforme;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.filters.BandPass;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;
import be.tarsos.dsp.synthesis.NoiseGenerator;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private boolean permissionToRecordAccepted = false;
    private String[] permissions = {Manifest.permission.RECORD_AUDIO};

    private int samplingRate = 22050;
    private int bufferSize = 1024;
    private AudioDispatcher dispatcher;
    private float probabilityThreshold = 0.9f;

    private String orderLoopState = "A";
    private String familyLoopState = "A";
    private String genusLoopState = "A";
    private String speciesLoopState = "A";
    private String loopState = "O";
    private ConcurrentHashMap<String,Integer> detectedNotes = new ConcurrentHashMap();
    private boolean searchInProgress = false;
    private boolean filterReplaceInProgress = false;

    private AudioProcessor filter;
    private AudioProcessor noise;
    private AudioProcessor iterate;

    // TODO: consider using noise generator

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,permissions,REQUEST_RECORD_AUDIO_PERMISSION);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_RECORD_AUDIO_PERMISSION:
                permissionToRecordAccepted  = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                break;
        }
        if (!permissionToRecordAccepted ) {
            finish();
        }
        else {
            startRecording();
        }

    }

    // call this method to increment the detectedNotes dictionary
    private void incrementNotes() {
        for (String note : detectedNotes.keySet()) {
            detectedNotes.put(note, detectedNotes.get(note) + 1);
        }
    }

    // call this method to remove keys in the detectedNotes dictionary that have been in there for a long time
    private void pruneNotes() {
        for (String note : detectedNotes.keySet()) {
            if (detectedNotes.get(note) > 2) {
                detectedNotes.remove(note);
            }
        }
    }

    // produces an ArrayList of the detected notes, sorted in increasing order by pitch
    private ArrayList<String> sortNotes() {

        ArrayList<String> sortedNotes = new ArrayList<>();
        ArrayList<String> unsortedNotes = new ArrayList<>();

        // locals
        class CompareNotes {

            HashMap<String,Integer> noteOrder = new HashMap();
            private void initialize() {

                noteOrder.put("C",0);
                noteOrder.put("C#",1);
                noteOrder.put("D",2);
                noteOrder.put("D#",3);
                noteOrder.put("E",4);
                noteOrder.put("F",5);
                noteOrder.put("F#",6);
                noteOrder.put("G",7);
                noteOrder.put("G#",8);
                noteOrder.put("A",9);
                noteOrder.put("A#",10);
                noteOrder.put("B",11);

            }

            // produces true if note1 is lower than note2, else false
            private boolean compareNotes(String note1, String note2) {

                int octave1 = Character.getNumericValue(note1.charAt(note1.length()-1));
                int octave2 = Character.getNumericValue(note2.charAt(note2.length()-1));
                String pitch1 = note1.substring(0,note1.length()-1);
                String pitch2 = note2.substring(0,note2.length()-1);
                initialize();

                if (octave1 < octave2) {
                    return true;
                } else if (octave1 > octave2) {
                    return false;
                } else {
                    if (noteOrder.get(pitch1) < noteOrder.get(pitch2)) {
                        return true;
                    } else {
                        return false;
                    }
                }

            }

            // produces the lowest note in a (non-empty) list
            private String lowestNote(ArrayList<String> notes) {

                String currentLowest = notes.get(0);

                for (String note : notes) {
                    if (compareNotes(note,currentLowest)) {
                        currentLowest = note;
                    }
                }

                return currentLowest;

            }

        }

        for (String note : detectedNotes.keySet()) {
            unsortedNotes.add(note);
        }

        // for all practical purposes, this list will be of relatively small size, whence quicksort is unnecessary
        while (! (unsortedNotes.size() == 0)) {

            String currentLowest = new CompareNotes().lowestNote(unsortedNotes);
            sortedNotes.add(currentLowest);
            unsortedNotes.remove(currentLowest);

        }

        return sortedNotes;

    }

    private String findNote(float pitch){
        if (pitch < 26.68) {return null;}
        else if (pitch < 28.32) {return "A0";}
        else if (pitch < 30.00) {return "A#0";}
        else if (pitch < 31.79) {return "B0";}
        else if (pitch < 33.68) {return "C1";}
        else if (pitch < 35.68) {return "C#1";}
        else if (pitch < 37.80) {return "D1";}
        else if (pitch < 40.05) {return "D#1";}
        else if (pitch < 42.43) {return "E1";}
        else if (pitch < 44.95) {return "F1";}
        else if (pitch < 47.62) {return "F#1";}
        else if (pitch < 50.46) {return "G1";}
        else if (pitch < 53.46) {return "G#1";}
        else if (pitch < 56.64) {return "A1";}
        else if (pitch < 60.00) {return "A#1";}
        else if (pitch < 63.57) {return "B1";}
        else if (pitch < 67.35) {return "C2";}
        else if (pitch < 71.36) {return "C#2";}
        else if (pitch < 75.60) {return "D2";}
        else if (pitch < 80.10) {return "D#2";}
        else if (pitch < 84.86) {return "E2";}
        else if (pitch < 89.90) {return "F2";}
        else if (pitch < 95.25) {return "F#2";}
        else if (pitch < 100.91) {return "G2";}
        else if (pitch < 106.91) {return "G#2";}
        else if (pitch < 113.27) {return "A2";}
        else if (pitch < 120.01) {return "A#2";}
        else if (pitch < 127.14) {return "B2";}
        else if (pitch < 134.70) {return "C3";}
        else if (pitch < 142.71) {return "C#3";}
        else if (pitch < 151.20) {return "D3";}
        else if (pitch < 160.19) {return "D#3";}
        else if (pitch < 169.71) {return "E3";}
        else if (pitch < 179.81) {return "F3";}
        else if (pitch < 190.50) {return "F#3";}
        else if (pitch < 201.83) {return "G3";}
        else if (pitch < 213.83) {return "G#3";}
        else if (pitch < 226.54) {return "A3";}
        else if (pitch < 240.01) {return "A#3";}
        else if (pitch < 254.28) {return "B3";}
        else if (pitch < 269.40) {return "C4";}
        else if (pitch < 285.42) {return "C#4";}
        else if (pitch < 302.40) {return "D4";}
        else if (pitch < 320.38) {return "D#4";}
        else if (pitch < 339.43) {return "E4";}
        else if (pitch < 359.61) {return "F4";}
        else if (pitch < 380.99) {return "F#4";}
        else if (pitch < 403.65) {return "G4";}
        else if (pitch < 427.65) {return "G#4";}
        else if (pitch < 453.08) {return "A4";}
        else if (pitch < 480.02) {return "A#4";}
        else if (pitch < 508.57) {return "B4";}
        else if (pitch < 538.81) {return "C5";}
        else if (pitch < 570.85) {return "C#5";}
        else if (pitch < 604.79) {return "D5";}
        else if (pitch < 640.75) {return "D#5";}
        else if (pitch < 678.86) {return "E5";}
        else if (pitch < 719.22) {return "F5";}
        else if (pitch < 761.99) {return "F#5";}
        else if (pitch < 807.30) {return "G5";}
        else if (pitch < 855.30) {return "G#5";}
        else if (pitch < 906.16) {return "A5";}
        else if (pitch < 960.05) {return "A#5";}
        else if (pitch < 1017.13) {return "B5";}
        else if (pitch < 1077.62) {return "C6";}
        else if (pitch < 1141.70) {return "C#6";}
        else if (pitch < 1209.59) {return "D6";}
        else if (pitch < 1281.51) {return "D#6";}
        else if (pitch < 1357.71) {return "E6";}
        else if (pitch < 1438.45) {return "F6";}
        else if (pitch < 1523.98) {return "F#6";}
        else if (pitch < 1614.60) {return "G6";}
        else if (pitch < 1710.61) {return "G#6";}
        else if (pitch < 1812.33) {return "A6";}
        else if (pitch < 1920.10) {return "A#6";}
        else if (pitch < 2034.27) {return "B6";}
        else if (pitch < 2155.23) {return "C7";}
        else if (pitch < 2283.39) {return "C#7";}
        else if (pitch < 2419.17) {return "D7";}
        else if (pitch < 2563.02) {return "D#7";}
        else if (pitch < 2715.43) {return "E7";}
        else if (pitch < 2876.90) {return "F7";}
        else if (pitch < 3047.96) {return "F#7";}
        else if (pitch < 3229.20) {return "G7";}
        else if (pitch < 3421.22) {return "G#7";}
        else if (pitch < 3624.66) {return "A7";}
        else if (pitch < 3840.19) {return "A#7";}
        else if (pitch < 4068.54) {return "B7";}
        else if (pitch < 4303.48) {return "C8";}
        else {return null;}
    }

    private void searchOrders(float probability) {

        if (orderLoopState.equals("A")) {
            if (probability > probabilityThreshold) {
                replaceFilters(33.68f,56.64f); // TODO: order A -> family A
                loopState = "F";
            } else {
                replaceFilters(160.19f,761.99f); // TODO: order B
                loopState = "O";
                orderLoopState = "B";
            }
        } else if (orderLoopState.equals("B")) {
            if (probability > probabilityThreshold) {
                replaceFilters(160.19f,269.40f); // TODO: order B -> family A
                loopState = "F";
            } else {
                replaceFilters(761.99f,3624.66f); // TODO: order C
                loopState = "O";
                orderLoopState = "C";
            }
        } else if (orderLoopState.equals("C")) {
            if (probability > probabilityThreshold) {
                replaceFilters(761.99f,1281.51f); // TODO: order C -> family A
                loopState = "F";
            } else {
                replaceFilters(33.68f,160.19f); // TODO: order A
                loopState = "O";
                orderLoopState = "A";
                incrementNotes();
                pruneNotes();
            }
        }

        searchInProgress = false;

    }

    private void searchFamilies(float probability) {

        if (familyLoopState.equals("A")) {
            if (probability > probabilityThreshold) {
                if (orderLoopState.equals("A")) {
                    replaceFilters(33.68f,40.05f); // TODO: order A -> family A -> genus A
                    loopState = "G";
                } else if (orderLoopState.equals("B")) {
                    replaceFilters(160.19f,190.50f); // TODO: order B -> family A -> genus A
                    loopState = "G";
                } else if (orderLoopState.equals("C")) {
                    replaceFilters(761.99f,906.16f); // TODO: order C -> family A -> genus A
                    loopState = "G";
                }
            } else {
                if (orderLoopState.equals("A")) {
                    replaceFilters(56.64f,95.25f); // TODO: order A -> family B
                    loopState = "F";
                } else if (orderLoopState.equals("B")) {
                    replaceFilters(269.40f,453.08f); // TODO: order B -> family B
                    loopState = "F";
                } else if (orderLoopState.equals("C")) {
                    replaceFilters(1281.51f,2155.23f); // TODO: order C -> family B
                    loopState = "F";
                }
                familyLoopState = "B";
            }
        } else if (familyLoopState.equals("B")) {
            if (probability > probabilityThreshold) {
                if (orderLoopState.equals("A")) {
                    replaceFilters(56.64f,67.35f); // TODO: order A -> family B -> genus A
                    loopState = "G";
                } else if (orderLoopState.equals("B")) {
                    replaceFilters(269.40f,320.38f); // TODO: order B -> family B -> genus A
                    loopState = "G";
                } else if (orderLoopState.equals("C")) {
                    replaceFilters(1281.51f,1523.98f); // TODO: order C -> family B -> genus A
                    loopState = "G";
                }
            } else {
                if (orderLoopState.equals("A")) {
                    replaceFilters(95.25f,160.19f); // TODO: order A -> family C
                    loopState = "F";
                } else if (orderLoopState.equals("B")) {
                    replaceFilters(453.08f,761.99f); // TODO: order B -> family C
                    loopState = "F";
                } else if (orderLoopState.equals("C")) {
                    replaceFilters(2155.23f,3624.66f); // TODO: order C -> family C
                    loopState = "F";
                }
                familyLoopState = "C";
            }
        } else if (familyLoopState.equals("C")) {
            if (probability > probabilityThreshold) {
                if (orderLoopState.equals("A")) {
                    replaceFilters(95.25f,113.27f); // TODO: order A -> family C -> genus A
                    loopState = "G";
                } else if (orderLoopState.equals("B")) {
                    replaceFilters(453.08f,538.81f); // TODO: order B -> family C -> genus A
                    loopState = "G";
                } else if (orderLoopState.equals("C")) {
                    replaceFilters(2155.23f,2563.02f); // TODO: order C -> family C -> genus A
                    loopState = "G";
                }
            } else {
                if (orderLoopState.equals("A")) {
                    replaceFilters(160.19f,761.99f); // TODO: order B
                    loopState = "O";
                    orderLoopState = "B";
                } else if (orderLoopState.equals("B")) {
                    replaceFilters(761.99f,3624.66f); // TODO: order C
                    loopState = "O";
                    orderLoopState = "C";
                } else if (orderLoopState.equals("C")) {
                    replaceFilters(33.68f,160.19f); // TODO: order A
                    loopState = "O";
                    orderLoopState = "A";
                    incrementNotes();
                    pruneNotes();
                }
                familyLoopState = "A";
            }
        }

        searchInProgress = false;

    }

    private void searchGenera(float probability) {

        if (genusLoopState.equals("A")) {
            if (probability > probabilityThreshold) {
                if (orderLoopState.equals("A")) {
                    if (familyLoopState.equals("A")) {
                        replaceFilters(33.68f,35.68f); // TODO: order A -> family A -> genus A -> species A
                        loopState = "S";
                    } else if (familyLoopState.equals("B")) {
                        replaceFilters(56.64f,60.00f); // TODO: order A -> family B -> genus A -> species A
                        loopState = "S";
                    } else if (familyLoopState.equals("C")) {
                        replaceFilters(95.25f,100.91f); // TODO: order A -> family C -> genus A -> species A
                        loopState = "S";
                    }
                } else if (orderLoopState.equals("B")) {
                    if (familyLoopState.equals("A")) {
                        replaceFilters(160.19f,169.71f); // TODO: order B -> family A -> genus A -> species A
                        loopState = "S";
                    } else if (familyLoopState.equals("B")) {
                        replaceFilters(269.40f,285.42f); // TODO: order B -> family B -> genus A -> species A
                        loopState = "S";
                    } else if (familyLoopState.equals("C")) {
                        replaceFilters(453.08f,480.02f); // TODO: order B -> family C -> genus A -> species A
                        loopState = "S";
                    }
                } else if (orderLoopState.equals("C")) {
                    if (familyLoopState.equals("A")) {
                        replaceFilters(761.99f,807.30f); // TODO: order C -> family A -> genus A -> species A
                        loopState = "S";
                    } else if (familyLoopState.equals("B")) {
                        replaceFilters(1281.51f,1357.71f); // TODO: order C -> family B -> genus A -> species A
                        loopState = "S";
                    } else if (familyLoopState.equals("C")) {
                        replaceFilters(2155.23f,2283.39f); // TODO: order C -> family C -> genus A -> species A
                        loopState = "S";
                    }
                }
            } else {
                if (orderLoopState.equals("A")) {
                    if (familyLoopState.equals("A")) {
                        replaceFilters(40.05f,47.62f); // TODO: order A -> family A -> genus B
                        loopState = "G";
                    } else if (familyLoopState.equals("B")) {
                        replaceFilters(67.35f,80.10f); // TODO: order A -> family B -> genus B
                        loopState = "G";
                    } else if (familyLoopState.equals("C")) {
                        replaceFilters(113.27f,134.70f); // TODO: order A -> family C -> genus B
                        loopState = "G";
                    }
                } else if (orderLoopState.equals("B")) {
                    if (familyLoopState.equals("A")) {
                        replaceFilters(190.50f,226.54f); // TODO: order B -> family A -> genus B
                        loopState = "G";
                    } else if (familyLoopState.equals("B")) {
                        replaceFilters(320.38f,380.99f); // TODO: order B -> family B -> genus B
                        loopState = "G";
                    } else if (familyLoopState.equals("C")) {
                        replaceFilters(538.81f,640.75f); // TODO: order B -> family C -> genus B
                        loopState = "G";
                    }
                } else if (orderLoopState.equals("C")) {
                    if (familyLoopState.equals("A")) {
                        replaceFilters(906.16f,1077.62f); // TODO: order C -> family A -> genus B
                        loopState = "G";
                    } else if (familyLoopState.equals("B")) {
                        replaceFilters(1523.98f,1812.33f); // TODO: order C -> family B -> genus B
                        loopState = "G";
                    } else if (familyLoopState.equals("C")) {
                        replaceFilters(2563.02f,3047.96f); // TODO: order C -> family C -> genus B
                        loopState = "G";
                    }
                }
                genusLoopState = "B";
            }
        } else if (genusLoopState.equals("B")) {
            if (probability > probabilityThreshold) {
                if (orderLoopState.equals("A")) {
                    if (familyLoopState.equals("A")) {
                        replaceFilters(40.05f,42.43f); // TODO: order A -> family A -> genus B -> species A
                        loopState = "S";
                    } else if (familyLoopState.equals("B")) {
                        replaceFilters(67.35f,71.36f); // TODO: order A -> family B -> genus B -> species A
                        loopState = "S";
                    } else if (familyLoopState.equals("C")) {
                        replaceFilters(113.27f,120.01f); // TODO: order A -> family C -> genus B -> species A
                        loopState = "S";
                    }
                } else if (orderLoopState.equals("B")) {
                    if (familyLoopState.equals("A")) {
                        replaceFilters(190.50f,201.83f); // TODO: order B -> family A -> genus B -> species A
                        loopState = "S";
                    } else if (familyLoopState.equals("B")) {
                        replaceFilters(320.38f,339.43f); // TODO: order B -> family B -> genus B -> species A
                        loopState = "S";
                    } else if (familyLoopState.equals("C")) {
                        replaceFilters(538.81f,570.85f); // TODO: order B -> family C -> genus B -> species A
                        loopState = "S";
                    }
                } else if (orderLoopState.equals("C")) {
                    if (familyLoopState.equals("A")) {
                        replaceFilters(906.16f,960.05f); // TODO: order C -> family A -> genus B -> species A
                        loopState = "S";
                    } else if (familyLoopState.equals("B")) {
                        replaceFilters(1523.98f,1614.60f); // TODO: order C -> family B -> genus B -> species A
                        loopState = "S";
                    } else if (familyLoopState.equals("C")) {
                        replaceFilters(2563.02f,2715.43f); // TODO: order C -> family C -> genus B -> species A
                        loopState = "S";
                    }
                }
            } else {
                if (orderLoopState.equals("A")) {
                    if (familyLoopState.equals("A")) {
                        replaceFilters(47.62f,56.64f); // TODO: order A -> family A -> genus C
                        loopState = "G";
                    } else if (familyLoopState.equals("B")) {
                        replaceFilters(80.10f,95.25f); // TODO: order A -> family B -> genus C
                        loopState = "G";
                    } else if (familyLoopState.equals("C")) {
                        replaceFilters(134.70f,160.19f); // TODO: order A -> family C -> genus C
                        loopState = "G";
                    }
                } else if (orderLoopState.equals("B")) {
                    if (familyLoopState.equals("A")) {
                        replaceFilters(226.54f,269.40f); // TODO: order B -> family A -> genus C
                        loopState = "G";
                    } else if (familyLoopState.equals("B")) {
                        replaceFilters(380.99f,453.08f); // TODO: order B -> family B -> genus C
                        loopState = "G";
                    } else if (familyLoopState.equals("C")) {
                        replaceFilters(640.75f,761.99f); // TODO: order B -> family C -> genus C
                        loopState = "G";
                    }
                } else if (orderLoopState.equals("C")) {
                    if (familyLoopState.equals("A")) {
                        replaceFilters(1077.62f,1281.51f); // TODO: order C -> family A -> genus C
                        loopState = "G";
                    } else if (familyLoopState.equals("B")) {
                        replaceFilters(1812.33f,2155.23f); // TODO: order C -> family B -> genus C
                        loopState = "G";
                    } else if (familyLoopState.equals("C")) {
                        replaceFilters(3047.96f,3624.66f); // TODO: order C -> family C -> genus C
                        loopState = "G";
                    }
                }
                genusLoopState = "C";
            }
        } else if (genusLoopState.equals("C")) {
            if (probability > probabilityThreshold) {
                if (orderLoopState.equals("A")) {
                    if (familyLoopState.equals("A")) {
                        replaceFilters(47.62f,50.46f); // TODO: order A -> family A -> genus C -> species A
                        loopState = "S";
                    } else if (familyLoopState.equals("B")) {
                        replaceFilters(80.10f,84.86f); // TODO: order A -> family B -> genus C -> species A
                        loopState = "S";
                    } else if (familyLoopState.equals("C")) {
                        replaceFilters(134.70f,142.71f); // TODO: order A -> family C -> genus C -> species A
                        loopState = "S";
                    }
                } else if (orderLoopState.equals("B")) {
                    if (familyLoopState.equals("A")) {
                        replaceFilters(226.54f,240.01f); // TODO: order B -> family A -> genus C -> species A
                        loopState = "S";
                    } else if (familyLoopState.equals("B")) {
                        replaceFilters(380.99f,403.65f); // TODO: order B -> family B -> genus C -> species A
                        loopState = "S";
                    } else if (familyLoopState.equals("C")) {
                        replaceFilters(640.75f,678.86f); // TODO: order B -> family C -> genus C -> species A
                        loopState = "S";
                    }
                } else if (orderLoopState.equals("C")) {
                    if (familyLoopState.equals("A")) {
                        replaceFilters(1077.62f,1141.70f); // TODO: order C-> family A -> genus C -> species A
                        loopState = "S";
                    } else if (familyLoopState.equals("B")) {
                        replaceFilters(1812.33f,1920.10f); // TODO: order C -> family B -> genus C -> species A
                        loopState = "S";
                    } else if (familyLoopState.equals("C")) {
                        replaceFilters(3047.96f,3229.20f); // TODO: order C -> family C -> genus C -> species A
                        loopState = "S";
                    }
                }
            } else {
                if (familyLoopState.equals("A")) {
                    if (orderLoopState.equals("A")) {
                        replaceFilters(56.64f,95.25f); // TODO: order A -> family B
                        loopState = "F";
                        familyLoopState = "B";
                    } else if (orderLoopState.equals("B")) {
                        replaceFilters(269.40f,453.08f); // TODO: order B -> family B
                        loopState = "F";
                        familyLoopState = "B";
                    } else if (orderLoopState.equals("C")) {
                        replaceFilters(1281.51f,2155.23f); // TODO: order C -> family B
                        loopState = "F";
                        familyLoopState = "B";
                    }
                } else if (familyLoopState.equals("B")) {
                    if (orderLoopState.equals("A")) {
                        replaceFilters(95.25f,160.19f); // TODO order A -> family C
                        loopState = "F";
                        familyLoopState = "C";
                    } else if (orderLoopState.equals("B")) {
                        replaceFilters(453.08f,761.99f); // TODO: order B -> family C
                        loopState = "F";
                        familyLoopState = "C";
                    } else if (orderLoopState.equals("C")) {
                        replaceFilters(2155.23f,3624.66f); // TODO: order C -> family C
                        loopState = "F";
                        familyLoopState = "C";
                    }
                } else if (familyLoopState.equals("C")) {
                    if (orderLoopState.equals("A")) {
                        replaceFilters(160.19f,761.99f); // TODO: order B
                        loopState = "O";
                        orderLoopState = "B";
                    } else if (orderLoopState.equals("B")) {
                        replaceFilters(761.99f,3624.66f); // TODO: order C
                        loopState = "O";
                        orderLoopState = "C";
                    } else if (orderLoopState.equals("C")) {
                        replaceFilters(33.68f,160.19f); // TODO: order A
                        loopState = "O";
                        orderLoopState = "A";
                        incrementNotes();
                        pruneNotes();
                    }
                    familyLoopState = "A";
                }
                genusLoopState = "A";
            }
        }

        searchInProgress = false;

    }

    private void searchSpecies(float probability, float pitch) {

        if (speciesLoopState.equals("A")) {
            if (probability > probabilityThreshold) {
                detectedNotes.put(findNote(pitch),0);
            }
            if (orderLoopState.equals("A")) {
                if (familyLoopState.equals("A")) {
                    if (genusLoopState.equals("A")) {
                        replaceFilters(35.68f,37.80f); // TODO: order A -> family A -> genus A -> species B
                    } else if (genusLoopState.equals("B")) {
                        replaceFilters(42.43f,44.95f); // TODO: order A -> family A -> genus B -> species B
                    } else if (genusLoopState.equals("C")) {
                        replaceFilters(50.46f,53.46f); // TODO: order A -> family A -> genus C -> species B
                    }
                } else if (familyLoopState.equals("B")) {
                    if (genusLoopState.equals("A")) {
                        replaceFilters(60.00f,63.57f); // TODO: order A -> family B -> genus A -> species B
                    } else if (genusLoopState.equals("B")) {
                        replaceFilters(71.36f,75.60f); // TODO: order A -> family B -> genus B -> species B
                    } else if (genusLoopState.equals("C")) {
                        replaceFilters(84.86f,89.90f); // TODO: order A -> family B -> genus C -> species B
                    }
                } else if (familyLoopState.equals("C")) {
                    if (genusLoopState.equals("A")) {
                        replaceFilters(100.91f,106.91f); // TODO: order A -> family C -> genus A -> species B
                    } else if (genusLoopState.equals("B")) {
                        replaceFilters(120.01f,127.14f); // TODO: order A -> family C -> genus B -> species B
                    } else if (genusLoopState.equals("C")) {
                        replaceFilters(142.71f,151.20f); // TODO: order A -> family C -> genus C -> species B
                    }
                }
            } else if (orderLoopState.equals("B")) {
                if (familyLoopState.equals("A")) {
                    if (genusLoopState.equals("A")) {
                        replaceFilters(169.71f,179.81f); // TODO: order B -> family A -> genus A -> species B
                    } else if (genusLoopState.equals("B")) {
                        replaceFilters(201.83f,213.83f); // TODO: order B -> family A -> genus B -> species B
                    } else if (genusLoopState.equals("C")) {
                        replaceFilters(240.01f,254.28f); // TODO: order B -> family A -> genus C -> species B
                    }
                } else if (familyLoopState.equals("B")) {
                    if (genusLoopState.equals("A")) {
                        replaceFilters(285.42f,302.40f); // TODO: order B -> family B -> genus A -> species B
                    } else if (genusLoopState.equals("B")) {
                        replaceFilters(339.43f,359.61f); // TODO: order B -> family B -> genus B -> species B
                    } else if (genusLoopState.equals("C")) {
                        replaceFilters(403.65f,427.65f); // TODO: order B -> family B -> genus C -> species B
                    }
                } else if (familyLoopState.equals("C")) {
                    if (genusLoopState.equals("A")) {
                        replaceFilters(480.02f,508.57f); // TODO: order B -> family C -> genus A -> species B
                    } else if (genusLoopState.equals("B")) {
                        replaceFilters(570.85f,604.79f); // TODO: order B -> family C -> genus B -> species B
                    } else if (genusLoopState.equals("C")) {
                        replaceFilters(678.86f,719.22f); // TODO: order B -> family C -> genus C -> species B
                    }
                }
            } else if (orderLoopState.equals("C")) {
                if (familyLoopState.equals("A")) {
                    if (genusLoopState.equals("A")) {
                        replaceFilters(807.30f,855.30f); // TODO: order C -> family A -> genus A -> species B
                    } else if (genusLoopState.equals("B")) {
                        replaceFilters(960.05f,1017.13f); // TODO: order C -> family A -> genus B -> species B
                    } else if (genusLoopState.equals("C")) {
                        replaceFilters(1141.70f,1209.59f); // TODO: order C -> family A -> genus C -> species B
                    }
                } else if (familyLoopState.equals("B")) {
                    if (genusLoopState.equals("A")) {
                        replaceFilters(1357.71f,1438.45f); // TODO: order C -> family B -> genus A -> species B
                    } else if (genusLoopState.equals("B")) {
                        replaceFilters(1614.60f,1710.61f); // TODO: order C -> family B -> genus B -> species B
                    } else if (genusLoopState.equals("C")) {
                        replaceFilters(1920.10f,2034.27f); // TODO: order C -> family B -> genus C -> species B
                    }
                } else if (familyLoopState.equals("C")) {
                    if (genusLoopState.equals("A")) {
                        replaceFilters(2283.39f,2419.17f); // TODO: order C -> family C -> genus A -> species B
                    } else if (genusLoopState.equals("B")) {
                        replaceFilters(2715.43f,2876.90f); // TODO: order C -> family C -> genus B -> species B
                    } else if (genusLoopState.equals("C")) {
                        replaceFilters(3229.20f,3421.22f); // TODO: order C -> family C -> genus C -> species B
                    }
                }
            }
            speciesLoopState = "B";
        } else if (speciesLoopState.equals("B")) {
            if (probability > probabilityThreshold) {
                detectedNotes.put(findNote(pitch),0);
            }
            if (orderLoopState.equals("A")) {
                if (familyLoopState.equals("A")) {
                    if (genusLoopState.equals("A")) {
                        replaceFilters(37.80f,40.05f); // TODO: order A -> family A -> genus A -> species C
                    } else if (genusLoopState.equals("B")) {
                        replaceFilters(44.95f,47.62f); // TODO: order A -> family A -> genus B -> species C
                    } else if (genusLoopState.equals("C")) {
                        replaceFilters(53.46f,56.64f); // TODO: order A -> family A -> genus C -> species C
                    }
                } else if (familyLoopState.equals("B")) {
                    if (genusLoopState.equals("A")) {
                        replaceFilters(63.57f,67.35f); // TODO: order A -> family B -> genus A -> species C
                    } else if (genusLoopState.equals("B")) {
                        replaceFilters(75.60f,80.10f); // TODO: order A -> family B -> genus B -> species C
                    } else if (genusLoopState.equals("C")) {
                        replaceFilters(89.90f,95.25f); // TODO: order A -> family B -> genus C -> species C
                    }
                } else if (familyLoopState.equals("C")) {
                    if (genusLoopState.equals("A")) {
                        replaceFilters(106.91f,113.27f); // TODO: order A -> family C -> genus A -> species C
                    } else if (genusLoopState.equals("B")) {
                        replaceFilters(127.14f,134.70f); // TODO: order A -> family C -> genus B -> species C
                    } else if (genusLoopState.equals("C")) {
                        replaceFilters(151.20f,160.19f); // TODO: order A -> family C -> genus C -> species C
                    }
                }
            } else if (orderLoopState.equals("B")) {
                if (familyLoopState.equals("A")) {
                    if (genusLoopState.equals("A")) {
                        replaceFilters(179.81f,190.50f); // TODO: order B -> family A -> genus A -> species C
                    } else if (genusLoopState.equals("B")) {
                        replaceFilters(213.83f,226.54f); // TODO: order B -> family A -> genus B -> species C
                    } else if (genusLoopState.equals("C")) {
                        replaceFilters(254.28f,269.40f); // TODO: order B -> family A -> genus C -> species C
                    }
                } else if (familyLoopState.equals("B")) {
                    if (genusLoopState.equals("A")) {
                        replaceFilters(302.40f,320.38f); // TODO: order B -> family B -> genus A -> species C
                    } else if (genusLoopState.equals("B")) {
                        replaceFilters(359.61f,380.99f); // TODO: order B -> family B -> genus B -> species C
                    } else if (genusLoopState.equals("C")) {
                        replaceFilters(427.65f,453.08f); // TODO: order B -> family B -> genus C -> species C
                    }
                } else if (familyLoopState.equals("C")) {
                    if (genusLoopState.equals("A")) {
                        replaceFilters(508.57f,538.81f); // TODO: order B -> family C -> genus A -> species C
                    } else if (genusLoopState.equals("B")) {
                        replaceFilters(604.79f,640.75f); // TODO: order B -> family C -> genus B -> species C
                    } else if (genusLoopState.equals("C")) {
                        replaceFilters(719.22f,761.99f); // TODO: order B -> family C -> genus C -> species C
                    }
                }
            } else if (orderLoopState.equals("C")) {
                if (familyLoopState.equals("A")) {
                    if (genusLoopState.equals("A")) {
                        replaceFilters(855.30f,906.16f); // TODO: order C -> family A -> genus A -> species C
                    } else if (genusLoopState.equals("B")) {
                        replaceFilters(1017.13f,1077.62f); // TODO: order C -> family A -> genus B -> species C
                    } else if (genusLoopState.equals("C")) {
                        replaceFilters(1209.59f,1281.51f); // TODO: order C -> family A -> genus C -> species C
                    }
                } else if (familyLoopState.equals("B")) {
                    if (genusLoopState.equals("A")) {
                        replaceFilters(1438.45f,1523.98f); // TODO: order C -> family B -> genus A -> species C
                    } else if (genusLoopState.equals("B")) {
                        replaceFilters(1710.61f,1812.33f); // TODO: order C -> family B -> genus B -> species C
                    } else if (genusLoopState.equals("C")) {
                        replaceFilters(2034.27f,2155.23f); // TODO: order C -> family B -> genus C -> species C
                    }
                } else if (familyLoopState.equals("C")) {
                    if (genusLoopState.equals("A")) {
                        replaceFilters(2419.17f,2563.02f); // TODO: order C -> family C -> genus A -> species C
                    } else if (genusLoopState.equals("B")) {
                        replaceFilters(2876.90f,3047.96f); // TODO: order C -> family C -> genus B -> species C
                    } else if (genusLoopState.equals("C")) {
                        replaceFilters(3421.22f,3624.66f); // TODO: order C -> family C -> genus C -> species C
                    }
                }
            }
            speciesLoopState = "C";
        } else if (speciesLoopState.equals("C")) {
            if (probability > probabilityThreshold) {
                detectedNotes.put(findNote(pitch),0);
            }
            if (genusLoopState.equals("A")) {
                if (familyLoopState.equals("A")) {
                    if (orderLoopState.equals("A")) {
                        replaceFilters(40.05f,47.62f); // TODO: order A -> family A -> genus B
                        loopState = "G";
                        genusLoopState = "B";
                    } else if (orderLoopState.equals("B")) {
                        replaceFilters(190.50f,226.54f); // TODO: order B -> family A -> genus B
                        loopState = "G";
                        genusLoopState = "B";
                    } else if (orderLoopState.equals("C")) {
                        replaceFilters(906.16f,1077.62f); // TODO: order C -> family A -> genus B
                        loopState = "G";
                        genusLoopState = "B";
                    }
                } else if (familyLoopState.equals("B")) {
                    if (orderLoopState.equals("A")) {
                        replaceFilters(67.35f,80.10f); // TODO: order A -> family B -> genus B
                        loopState = "G";
                        genusLoopState = "B";
                    } else if (orderLoopState.equals("B")) {
                        replaceFilters(320.38f,380.99f); // TODO: order B -> family B -> genus B
                        loopState = "G";
                        genusLoopState = "B";
                    } else if (orderLoopState.equals("C")) {
                        replaceFilters(1523.98f,1812.33f); // TODO: order C -> family B -> genus B
                        loopState = "G";
                        genusLoopState = "B";
                    }
                } else if (familyLoopState.equals("C")) {
                    if (orderLoopState.equals("A")) {
                        replaceFilters(113.27f,134.70f); // TODO: order A -> family C -> genus B
                        loopState = "G";
                        genusLoopState = "B";
                    } else if (orderLoopState.equals("B")) {
                        replaceFilters(538.81f,640.75f); // TODO: order B -> family C -> genus B
                        loopState = "G";
                        genusLoopState = "B";
                    } else if (orderLoopState.equals("C")) {
                        replaceFilters(2563.02f,3047.96f); // TODO: order C -> family C -> genus B
                        loopState = "G";
                        genusLoopState = "B";
                    }
                }
            } else if (genusLoopState.equals("B")) {
                if (familyLoopState.equals("A")) {
                    if (orderLoopState.equals("A")) {
                        replaceFilters(47.62f,56.64f); // TODO: order A -> family A -> genus C
                        loopState = "G";
                        genusLoopState = "C";
                    } else if (orderLoopState.equals("B")) {
                        replaceFilters(226.54f,269.40f); // TODO order B -> family A -> genus C
                        loopState = "G";
                        genusLoopState = "C";
                    } else if (orderLoopState.equals("C")) {
                        replaceFilters(1077.62f,1281.51f); // TODO: order C -> family A -> genus C
                        loopState = "G";
                        genusLoopState = "C";
                    }
                } else if (familyLoopState.equals("B")) {
                    if (orderLoopState.equals("A")) {
                        replaceFilters(80.10f,95.25f); // TODO: order A -> family B -> genus C
                        loopState = "G";
                        genusLoopState = "C";
                    } else if (orderLoopState.equals("B")) {
                        replaceFilters(380.99f,453.08f); // TODO: order B -> family B -> genus C
                        loopState = "G";
                        genusLoopState = "C";
                    } else if (orderLoopState.equals("C")) {
                        replaceFilters(1812.33f,2155.23f); // TODO: order C -> family B -> genus C
                        loopState = "G";
                        genusLoopState = "C";
                    }
                } else if (familyLoopState.equals("C")) {
                    if (orderLoopState.equals("A")) {
                        replaceFilters(134.70f,160.19f); // TODO: order A -> family C -> genus C
                        loopState = "G";
                        genusLoopState = "C";
                    } else if (orderLoopState.equals("B")) {
                        replaceFilters(640.75f,761.99f); // TODO: order B -> family C -> genus C
                        loopState = "G";
                        genusLoopState = "C";
                    } else if (orderLoopState.equals("C")) {
                        replaceFilters(3047.96f,3624.66f); // TODO: order C -> family C -> genus C
                        loopState = "G";
                        genusLoopState = "C";
                    }
                }
            } else if (genusLoopState.equals("C")) {
                if (familyLoopState.equals("A")) {
                    if (orderLoopState.equals("A")) {
                        replaceFilters(56.64f,95.25f); // TODO: order A -> family B
                        loopState = "F";
                        familyLoopState = "B";
                    } else if (orderLoopState.equals("B")) {
                        replaceFilters(269.40f,453.08f); // TODO: order B -> family B
                        loopState = "F";
                        familyLoopState = "B";
                    } else if (orderLoopState.equals("C")) {
                        replaceFilters(1281.51f,2155.23f); // TODO: order C -> family B
                        loopState = "F";
                        familyLoopState = "B";
                    }
                } else if (familyLoopState.equals("B")) {
                    if (orderLoopState.equals("A")) {
                        replaceFilters(95.25f,160.19f); // TODO: order A -> family C
                        loopState = "F";
                        familyLoopState = "C";
                    } else if (orderLoopState.equals("B")) {
                        replaceFilters(453.08f,761.99f); // TODO: order B -> family C
                        loopState = "F";
                        familyLoopState = "C";
                    } else if (orderLoopState.equals("C")) {
                        replaceFilters(2155.23f,3624.66f); // TODO: order C -> family C
                        loopState = "F";
                        familyLoopState = "C";
                    }
                } else if (familyLoopState.equals("C")) {
                    if (orderLoopState.equals("A")) {
                        replaceFilters(160.19f,761.99f); // TODO: order B
                        loopState = "O";
                        orderLoopState = "B";
                    } else if (orderLoopState.equals("B")) {
                        replaceFilters(761.99f,3624.66f); // TODO: order C
                        loopState = "O";
                        orderLoopState = "C";
                    } else if (orderLoopState.equals("C")) {
                        replaceFilters(33.68f,160.19f); // TODO: order A
                        loopState = "O";
                        orderLoopState = "A";
                        incrementNotes();
                        pruneNotes();
                    }
                    familyLoopState = "A";
                }
                genusLoopState = "A";
            }
            speciesLoopState = "A";
        }

        searchInProgress = false;

    }

    PitchDetectionHandler pdh = new PitchDetectionHandler() {
        @Override
        public void handlePitch(PitchDetectionResult result, AudioEvent e) {

            final float probability = result.getProbability();
            final float pitch = result.getPitch();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    // Checks to see if no other processes are currently in progress. This is crucial.
                    if (! (searchInProgress || filterReplaceInProgress)) {

                        searchInProgress = true;
                        filterReplaceInProgress = true;

                        TextView textView = findViewById(R.id.displayInfo);
                        String notesToDisplay = "";

                        if (loopState.equals("O")) {
                            searchOrders(probability);
                        } else if (loopState.equals("F")) {
                            searchFamilies(probability);
                        } else if (loopState.equals("G")) {
                            searchGenera(probability);
                        } else if (loopState.equals("S")) {
                            searchSpecies(probability,pitch);
                        }

                        for (String note : detectedNotes.keySet()) {
                            notesToDisplay = notesToDisplay + note;
                        }

                        textView.setText(notesToDisplay);
                    }

                }
            });
        }
    };

    private void replaceFilters(float minFrequency, float maxFrequency) {

        // When replacing BandPass filters, we want to remove and re-add the PitchProcessor so it
        // executes last.

        float center = (minFrequency + maxFrequency) / 2f;
        float diameter = maxFrequency - minFrequency;

        if (! (iterate == null)) {
            dispatcher.removeAudioProcessor(iterate);
        }

        if (! (noise == null)) {
            dispatcher.removeAudioProcessor(noise);
        }

        if (! (filter == null)) {
            dispatcher.removeAudioProcessor(filter);
        }

        iterate = new PitchProcessor(PitchProcessor.PitchEstimationAlgorithm.FFT_YIN, samplingRate, bufferSize, pdh);
        filter = new BandPass(center,diameter,samplingRate);
        noise = new NoiseGenerator(0.01);

        // add the filter first, then pad it with noise, then see if it still recognizes a pitch
        dispatcher.addAudioProcessor(filter);
        dispatcher.addAudioProcessor(noise);
        dispatcher.addAudioProcessor(iterate);

        filterReplaceInProgress = false;

    }

    private void startRecording(){

        dispatcher = AudioDispatcherFactory.fromDefaultMicrophone(samplingRate, bufferSize, 0);

        replaceFilters(33.68f,160.19f); // TODO: order A
        new Thread(dispatcher).start();

    }

}
