package com.example.musicplayer;

public class Song {
    /*Song id number*/
    private int idNumberSong;

    /*Song file name*/
    private String fileNameSong;

    /*Song image from file if yes*/
    private String fileImageSong;

    public Song(int numberSong, String nameSong, String imageSong) {
        idNumberSong = numberSong;
        fileNameSong = nameSong;
        fileImageSong = imageSong;
    }

    /* Get the default song id number*/
    public int getIdNumberSong() {
        return idNumberSong;
    }

    /* Get the default song file name */
    public String getFileNameSong() {
        return fileNameSong;
    }

    /*Get the default song image*/
    public String getFileImageSong() {
        return fileImageSong;
    }
}
