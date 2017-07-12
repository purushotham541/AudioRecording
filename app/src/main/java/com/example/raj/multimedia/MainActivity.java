package com.example.raj.multimedia;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity
{
    MediaRecorder mr;
    MediaPlayer mp;
    String audiofilee=null;
    //String path;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audiofilee=Environment.getExternalStorageDirectory().getAbsolutePath()+"/recording.3gp";
        mr=new MediaRecorder();

        mr=new MediaRecorder();
        mp=new MediaPlayer();
        mr.setAudioSource(MediaRecorder.AudioSource.MIC);
        mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mr.setOutputFile(audiofilee);
        mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
    }
    public void startRecording(View v)
    {

        try {
            mr.prepare();
            mr.start();
            Toast.makeText(this,"Audio Recording started",Toast.LENGTH_SHORT).show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void stopRecord(View v)
    {
        mr.stop();
        mr.release();
        mr=null;
        Toast.makeText(this,"Audio Recording stopped",Toast.LENGTH_SHORT).show();

    }
    public void startPlay(View v)
    {
        try {
            mp.setDataSource(audiofilee);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mp.prepare();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        mp.start();
        Toast.makeText(this,"Audio playing",Toast.LENGTH_SHORT).show();
    }
}
