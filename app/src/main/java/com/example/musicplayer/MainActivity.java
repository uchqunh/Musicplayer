package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView songsList = findViewById(R.id.songs_list);
        songsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listsIntent = new Intent(MainActivity.this, List.class);
                startActivity(listsIntent);
            }
        });
        TextView fileName=findViewById(R.id.file_name);
        ImageView addSong = findViewById(R.id.add_song);

        addSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("audio/mp3");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                try {
                    startActivityForResult(intent.createChooser(intent,"Select MP3"),1010);

                }
                catch (ActivityNotFoundException e){

                }
                fileName.setText(intent.getData().getPath());
            }
        });
    }
}