package com.example.musicplayer;

public class Song {
    /*Song path*/
    private String pathSong;

    /*Song  name*/
    private String nameSong;

    /*Song artist name*/
    private String nameArtist;

    /*Song album*/
    private String albumSong;

    public void Song(String pathSong, String nameSong, String nameArtist, String albumSong) {
        this.pathSong = pathSong;
        this.nameSong = nameSong;
        this.nameArtist = nameArtist;
        this.albumSong = albumSong;
    }

    /* Get the default song path*/
    public String getPathSong() {
        return pathSong;
    }

    /* Get the default song  name */
    public String getNameSong() {
        return nameSong;
    }

    /*Get the default song artist*/
    public String getNameArtist() {
        return nameArtist;
    }

    /*Get the default song album*/
    public String getAlbumSong() {
        return albumSong;
    }
}
