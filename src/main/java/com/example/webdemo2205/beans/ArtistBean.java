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

    public List<Artist> getArtists() {
        return artistDao.findAll();
    }
}
