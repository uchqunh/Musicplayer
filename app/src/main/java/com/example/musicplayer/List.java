package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class List<S> extends AppCompatActivity {
    public ArrayList<Song> tempAudioList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_list_item);
        // Create an array of words
        //ArrayList<Song> songs = new ArrayList<Song>();
        //songs.add(new Song(idSong, ,"png"));
        //songs.add(new Song(2, "otiiko","png"));
        Song temp=new Song();
        temp.Song("/res/raw/bonu_uzicha.mp3","bonu_uzicha.mp3","Bonu","Uzicha");
        tempAudioList.set(0,temp);
        tempAudioList=getAllMp3FromDevice(this);
        SongAdapter itemsAdapter =
                new SongAdapter(this, getAllMp3FromDevice(this));

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);
    }

    public ArrayList<Song> getAllMp3FromDevice(final Context context) {
        final ArrayList<Song> tempAudioList = new ArrayList<>();

        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.Audio.AudioColumns.DATA, MediaStore.Audio.AudioColumns.ALBUM, MediaStore.Audio.ArtistColumns.ARTIST,};
        Cursor c = context.getContentResolver().query(uri,
                projection,
                MediaStore.Audio.Media.DATA + " like ? ",
                new String[]{"%.mp3%"},
                null);

        if (c != null) {
            while (c.moveToNext()) {

                Song audioModel = new Song();
                String path = c.getString(0);
                String album = c.getString(1);
                String artist = c.getString(2);

                String name = path.substring(path.lastIndexOf("/") + 1);

                audioModel.Song(path, name, artist, album);

                Log.e("Name :" + name, " Album :" + album);
                Log.e("Path :" + path, " Artist :" + artist);

                tempAudioList.add(audioModel);
            }
            c.close();
        }

        return tempAudioList;
    }

}