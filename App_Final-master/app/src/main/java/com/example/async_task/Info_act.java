package com.example.async_task;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.MediaController;
import android.widget.VideoView;

public class Info_act extends AppCompatActivity {
    private VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);

        video=(VideoView)findViewById(R.id.videoView);
        String ruta="android.resource://" +getPackageName()+"/"+R.raw.robin;
        Uri uri=Uri.parse(ruta);

        video.setVideoURI(uri);
        MediaController medio= new MediaController(this);
        video.setMediaController(medio);
    }
}