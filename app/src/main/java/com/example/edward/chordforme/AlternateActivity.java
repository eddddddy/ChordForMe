package com.example.edward.chordforme;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*

Need different code for training and for deployment

 */

public class AlternateActivity extends AppCompatActivity {

    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private String[] permissions = {Manifest.permission.RECORD_AUDIO};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alternate);
        ActivityCompat.requestPermissions(this,permissions,REQUEST_RECORD_AUDIO_PERMISSION);

    }

    private void startRecording() {

    }

}
