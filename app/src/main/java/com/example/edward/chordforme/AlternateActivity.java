package com.example.edward.chordforme;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.widget.TextView;

import com.goebl.david.Webb;
import com.goebl.david.WebbException;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;


public class AlternateActivity extends AppCompatActivity {

    private int SAMPLE_RATE = 44100;
    private int bufferSize;
    private boolean mIsRecording = false;
    private float[] mBuffer;
    private File mRecording;
    private AudioRecord mRecorder;
    private String audioFilePath;
    private String RECORD_WAV_PATH = Environment.getExternalStorageDirectory() + File.separator + "AudioRecord";
    private static TextView textView;
    private static String response;
    private final Handler responseHandler = new responseHandler(this);
    private static final String postURL = "https://edddy.pythonanywhere.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alternate);
        textView = (TextView) findViewById(R.id.textView);

        bufferSize = AudioRecord.getMinBufferSize(SAMPLE_RATE, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_FLOAT);
        mRecorder = new AudioRecord(MediaRecorder.AudioSource.MIC, SAMPLE_RATE, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_FLOAT, bufferSize);
        mBuffer = new float[bufferSize];
        new File(RECORD_WAV_PATH).mkdir();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    callWebScript();
                } catch (WebbException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private static class responseHandler extends Handler {

        private final WeakReference<AlternateActivity> mActivity;

        public responseHandler(AlternateActivity activity) {
            mActivity = new WeakReference<AlternateActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            AlternateActivity activity = mActivity.get();
            if (activity != null) {
                int what = msg.what;
                if (what == 1) {
                    updateView();
                }
            }
        }
    }

    private static void updateView() {
        textView.setText(response);
    }

    public void recordWavStart() {
        mIsRecording = true;
        mRecorder.startRecording();
        mRecording = getFile("raw");
        startBufferedWrite(mRecording);
    }

    public String recordWavStop() {
        try {
            mIsRecording = false;
            mRecorder.stop();
            File waveFile = getFile("wav");
            rawToWave(mRecording, waveFile);
            return audioFilePath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void releaseRecord() {
        mRecorder.release();
    }

    private void startBufferedWrite(final File file) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                DataOutputStream output = null;
                try {
                    output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                    while (mIsRecording) {
                        int readSize = mRecorder.read(mBuffer, 0, mBuffer.length, AudioRecord.READ_NON_BLOCKING);
                        for (int i = 0; i < readSize; i++) {
                            output.writeFloat(mBuffer[i]);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (output != null) {
                        try {
                            output.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                output.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
    }

    public void callWebScript() throws WebbException {
        Webb webb = Webb.create();
        response = webb.post(postURL).param("list", "[8,2,7,5,6,0,3,9,1,4]").ensureSuccess().asString().getBody();
        responseHandler.sendEmptyMessage(1);
    }

    /*
    private void anotherTest() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                InputStream assetBinary = null;
                FileOutputStream installedBinary = null;
                InputStream stdout = null;

                try {

                    assetBinary = getAssets().open("simple.exe");
                    installedBinary = new FileOutputStream("/data/data/com.example.edward.chordforme/simple.exe");
                    int b;
                    ArrayList<Integer> bytes = new ArrayList<>();
                    while ((b = assetBinary.read()) != -1) {
                        installedBinary.write(b);
                        bytes.add(b);
                    }
                    System.out.print(Arrays.toString(bytes.toArray()));
                    assetBinary.close();
                    installedBinary.close();

                    Process initialize = Runtime.getRuntime().exec("/system/bin/chmod 744 /data/data/com.example.edward.chordforme/simple.exe");
                    initialize.waitFor();

                    Process simple = Runtime.getRuntime().exec("/data/data/com.example.edward.chordforme/simple.exe");
                    simple.waitFor();

                    stdout = simple.getInputStream();
                    System.out.println(stdout.read());
                    System.out.println(stdout.read());
                    System.out.println(stdout.read());
                    System.out.println(stdout.read());
                    System.out.println(stdout.read());
                    System.out.println(stdout.read());
                    stdout.close();

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }*/

    /*
    private void test() {

        DataInputStream input = new DataInputStream(getResources().openRawResource(R.raw.a_major_a_fourth_octave));
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();

        while (true) {
            try {
                byteStream.write(input.readByte());
            } catch (IOException e) {
                break;
            }
        }

        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] rawData = byteStream.toByteArray();

        float[] floats = new float[rawData.length / 4];
        ByteBuffer.wrap(rawData).order(ByteOrder.LITTLE_ENDIAN).asFloatBuffer().get(floats);

        System.out.println(Arrays.toString(floats));

    }
    */

    private void rawToWave(final File rawFile, final File waveFile) throws IOException {

        byte[] rawData = new byte[(int) rawFile.length()];
        DataInputStream input = null;
        try {
            input = new DataInputStream(new FileInputStream(rawFile));
            input.read(rawData);
        } finally {
            if (input != null) {
                input.close();
            }
        }
        DataOutputStream output = null;
        try {

            // modified write to wave (32 bit float encoding)
            output = new DataOutputStream(new FileOutputStream(waveFile));
            // WAVE header
            writeString(output, "RIFF"); // chunk id
            writeInt(output, 36 + rawData.length); // chunk size
            writeString(output, "WAVE"); // format

            writeString(output, "fmt "); // subchunk 1 id
            writeInt(output, 16); // subchunk 1 size
            writeShort(output, (short) 3); // audio format (1 = PCM, 3 = IEEE float)
            writeShort(output, (short) 1); // number of channels
            writeInt(output, SAMPLE_RATE); // sample rate
            writeInt(output, SAMPLE_RATE * 4); // byte rate
            writeShort(output, (short) 4); // block align
            writeShort(output, (short) 32); // bits per sample

            writeString(output, "data"); // subchunk 2 id
            writeInt(output, rawData.length); // subchunk 2 size
            // Audio data (conversion big endian -> little endian)
            float[] floats = new float[rawData.length / 4];
            ByteBuffer.wrap(rawData).order(ByteOrder.LITTLE_ENDIAN).asFloatBuffer().get(floats);
            ByteBuffer bytes = ByteBuffer.allocate(floats.length * 4);
            for (float f : floats) {
                bytes.putFloat(f);
            }
            output.write(bytes.array());

        } finally {
            if (output != null) {
                output.close();
                rawFile.delete();
            }
        }

    }

    /* Get file name */
    private File getFile(final String suffix) {
        Time time = new Time();
        time.setToNow();
        audioFilePath = time.format("%Y%m%d%H%M%S");
        return new File(RECORD_WAV_PATH, time.format("%Y%m%d%H%M%S") + "." + suffix);
    }

    // This function and the next two write to the DataOutputStream in little endian
    private void writeInt(final DataOutputStream output, final int value) throws IOException {
        output.write(value >> 0);
        output.write(value >> 8);
        output.write(value >> 16);
        output.write(value >> 24);
    }

    private void writeShort(final DataOutputStream output, final short value) throws IOException {
        output.write(value >> 0);
        output.write(value >> 8);
    }

    private void writeString(final DataOutputStream output, final String value) throws IOException {
        for (int i = 0; i < value.length(); i++) {
            output.write(value.charAt(i));
        }
    }

    public String getFileName(final String time_suffix) {
        return (RECORD_WAV_PATH + time_suffix + "." + "wav");
    }

}
