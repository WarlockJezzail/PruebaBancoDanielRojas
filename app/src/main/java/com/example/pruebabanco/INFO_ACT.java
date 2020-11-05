package com.example.pruebabanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class INFO_ACT extends AppCompatActivity {

    private VideoView Video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_n_f_o__a_c_t);
        Video=(VideoView)findViewById(R.id.videoView);
        String ruta= "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri= Uri.parse(ruta);
        Video.setVideoURI(uri);

        MediaController media = new MediaController(this);
        Video.setMediaController(media);
    }
    public void Maps (View view){
        Intent i = new Intent(this, MAPS_ACT.class);
        startActivity(i);

    }

}