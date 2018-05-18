package com.example.mamad.fara2form;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener{
    private Button playBtn,pauseBtn;
    private MediaPlayer mediaPlayer;
    private SeekBar volumeBar;
    private SeekBar scrubbar;
    private TextView textSeek;
    AudioManager audioManager; // It's a class for reading phone's volume
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // putting back image in top
        }
        //player
        mediaPlayer=MediaPlayer.create(this,R.raw.demo_music1);
        textSeek = (TextView) findViewById(R.id.textSeek);

        //buttons
        playBtn = (Button) findViewById(R.id.playBtn);
        pauseBtn = (Button) findViewById(R.id.pauseBtn);
        playBtn.setOnClickListener(this);       // impeleminting set on click listener
        pauseBtn.setOnClickListener(this);
        volumeBar = (SeekBar) findViewById(R.id.volumeBar);
        scrubbar = (SeekBar) findViewById(R.id.scubbar);
        //audioManager
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolume= audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
       //volume
        volumeBar.setMax(maxVolume);
        volumeBar.setProgress(curVolume);
        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {      // it will override 3 methode and they all should exist
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //change volume
                audioManager.setStreamVolume(audioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //position
        scrubbar.setMax(mediaPlayer.getDuration());
        scrubbar.setProgress(0);
        // *** timer from java
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scrubbar.setProgress(mediaPlayer.getCurrentPosition());

            }
        },0,100);
        scrubbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (mediaPlayer != null && fromUser){  // ***** only the change will happen if user change it himself
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

}

// back symbol
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){       // when you use from android library android.R.id.????
            finish();   // close this page back to were you were before
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == playBtn.getId()){
           mediaPlayer.start();
        }
        if (v.getId() == pauseBtn.getId()){
            mediaPlayer.pause();        // if you use stop you cant resume the song it will be terminated
        }
    }

   /* @Override
    protected void onResume() {
        super.onResume();

                String s = String.valueOf(volumeBar.getProgress());
                textSeek.setText(s);

    }*/
}
