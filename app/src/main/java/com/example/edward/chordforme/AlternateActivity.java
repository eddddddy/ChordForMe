package com.example.edward.chordforme;

import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import android.util.Log;

/*

Need different code for training and for deployment

 */

public class AlternateActivity extends AppCompatActivity {

    InputStream chord;

    //private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    //private String[] permissions = {Manifest.permission.RECORD_AUDIO};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alternate);
        System.out.println("hi");
        //ActivityCompat.requestPermissions(this,permissions,REQUEST_RECORD_AUDIO_PERMISSION);

        chord = getResources().openRawResource(R.raw.b_flat_major_b_flat_fifth_octave);
        getBytes(chord);

    }

    private void startRecording() {

    }

    // skip the first 2048 bytes, and get as many full blocks of 2048 bytes in between leaving at least 1024 bytes at the end
    private void getBytes(InputStream is) {

        int[] t = new int[2048];

        try {

            is.skip(2048);

            while (is.available() > 3072) {

                for (int i = 0; i < 2048; i++) {
                    t[i] = is.read();
                }

                int[] a = new int[512];
                int[] b = new int[512];
                int[] c = new int[512];
                int[] d = new int[512];

                for (int i = 0; i < 512; i++) {
                    a[i] = t[i];
                    b[i] = t[i + 512];
                    c[i] = t[i + 1024];
                    d[i] = t[i + 1536];
                }

                System.out.println(Arrays.toString(a));
                System.out.println(Arrays.toString(b));
                System.out.println(Arrays.toString(c));
                System.out.println(Arrays.toString(d));


            }

            is.close();

        } catch (IOException e) {

        }

    }

}
