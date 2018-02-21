package com.example.edward.chordforme;

import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/*

Need different code for training and for deployment

 */

public class AlternateActivity extends AppCompatActivity {

    InputStream Ab5root = getResources().openRawResource(R.raw.A_flat_major_A_flat_fifth_octave);

    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private String[] permissions = {Manifest.permission.RECORD_AUDIO};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alternate);
        ActivityCompat.requestPermissions(this,permissions,REQUEST_RECORD_AUDIO_PERMISSION);

        System.out.println(getBytes(Ab5root));

    }

    private void startRecording() {

    }

    private String getBytes(InputStream is) {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = is.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            is.close();
        } catch (IOException e) {

        }
        return outputStream.toString();

    }

}
