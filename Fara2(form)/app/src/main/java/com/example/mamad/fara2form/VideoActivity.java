package com.example.mamad.fara2form;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // putting back image in top
        }
        VideoView videoView= (VideoView) findViewById(R.id.videoView);
        videoView.setVideoPath(String.valueOf("android.resource://" + getPackageName() + "/" + R.raw.git)); // **** how to place a video address***
        MediaController mediaController = new MediaController(this);    // *** controler for videos it should be before start
        mediaController.setAnchorView(videoView); //introducing the video to controller
        videoView.setMediaController(mediaController); // introducing the controller to video
        videoView.start();      // remember to start the video
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){       // when you use from android library android.R.id.????
            finish();   // close this page back to were you were before
        }
        return super.onOptionsItemSelected(item);
    }


}
