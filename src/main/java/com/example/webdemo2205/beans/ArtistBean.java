package com.example.webdemo2205.beans;

import com.example.webdemo2205.dao.ArtistDao;
import com.example.webdemo2205.data.Artist;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ArtistBean implements Serializable {

    @EJB
    private ArtistDao artistDao;

    private Artist artist = new Artist();

    public List<Artist> getArtists() {
        return artistDao.findAll();
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void addArtist() {
        artistDao.addArtist(artist);
        artist = new Artist();
    }

    public void deleteArtist(int id) {
        artistDao.deleteArtistById(id);
    }

    public String edit(Artist artist) {
        this.artist = artist;
        return "editartist";
    }

    public String updateArtist() {
        artistDao.update(artist);
        artist = new Artist();
        return "artists";
    }
}
