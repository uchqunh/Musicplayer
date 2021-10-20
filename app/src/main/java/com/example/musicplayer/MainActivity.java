package com.example.musicplayer;

import androidx.annotation.Nullable;
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
    TextView fileName;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fileName=findViewById(R.id.file_name);
        ImageView songsList = findViewById(R.id.songs_list);
        songsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listsIntent = new Intent(MainActivity.this, List.class);
                startActivity(listsIntent);
            }
        });

        ImageView addSong = findViewById(R.id.add_song);

        addSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("audio/mp3");
                try {
                    startActivityForResult(intent,10);

                }
                catch (ActivityNotFoundException e){

                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK) {
                    String path = data.getData().getPath();
                    fileName.setText(path);
                }
                break;
        }
    }
}