package com.example.musicplayer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
//*import android.support.annotation.NonNull;
//*import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.ArrayList;

public class SongAdapter {
    private static final String LOG_TAG = SongAdapter.class.getSimpleName();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param androidFlavors A List of AndroidFlavor objects to display in a list
     */
    public SongAdapter(Activity context, ArrayList<Song> androidFlavors) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, androidFlavors);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_list, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Song currentAndroidFlavor = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView orderNumberSongs = (TextView) listItemView.findViewById(R.id.order_number_songs);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        orderNumberSongs.setText(currentAndroidFlavor.getIdNumberSong());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView songsName = (TextView) listItemView.findViewById(R.id.songs_name);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        songsName.setText(currentAndroidFlavor.getFileNameSong());


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        ImageView 
        return listItemView;
    }
}
