package com.example.musicplayer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    private static final String LOG_TAG = SongAdapter.class.getSimpleName();


    public SongAdapter(Activity context, ArrayList<Song> androidFlavors) {

        super(context, 0, androidFlavors);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_list, parent, false);
        }


        Song currentAndroidFlavor = getItem(position);

        TextView orderNumberSongs = (TextView) listItemView.findViewById(R.id.order_number_songs);

        orderNumberSongs.setText(currentAndroidFlavor.getIdNumberSong());

        TextView songsName = (TextView) listItemView.findViewById(R.id.songs_name);
      
        songsName.setText(currentAndroidFlavor.getFileNameSong());

        return listItemView;
    }


}
