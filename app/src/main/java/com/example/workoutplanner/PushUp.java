package com.example.workoutplanner;

import static com.example.workoutplanner.R.layout.activity_push_up;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.workoutplanner.R;

public class PushUp extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_push_up);
        VideoView videoView = findViewById(R.id.video_push_up);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.push_up_25s;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

    }

}