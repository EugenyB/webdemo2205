package com.example.webdemo2205.dao;

import com.example.webdemo2205.data.Artist;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ArtistDao {

    @Resource(name = "jdbc/chinook")
    private DataSource ds;

    @SneakyThrows
    public List<Artist> findAll() {
        List<Artist> result = new ArrayList<>();
        try (Connection connection = ds.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("select * from artist")
        ) {
            while (rs.next()) {
                result.add(new Artist(rs.getInt("ArtistId"), rs.getString("Name")));
            }
        }
        return result;
    }

    @SneakyThrows
    public void addArtist(Artist artist) {
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement("insert into artist (Name) values (?)")) {
            ps.setString(1, artist.getName());
            ps.executeUpdate();
        }
    }

    @SneakyThrows
    public void deleteArtistById(int id) {
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement("delete from artist where ArtistId = ?")
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
