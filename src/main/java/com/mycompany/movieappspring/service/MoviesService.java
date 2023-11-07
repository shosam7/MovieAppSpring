/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.movieappspring.service;

import com.mycompany.movieappspring.pojo.Movie;
import com.mycompany.movieappspring.pojo.Search;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author sho7
 */
@Component
public class MoviesService {

    Connection con;

    public MoviesService() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/moviedb", "root", "12345678");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MoviesService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Movie> getMovies(Search search) {
        ResultSet rs = null;
        Statement stmt = null;
        try {
            //System.out.println("Inside search");
            String keyword = search.getKeyword();
            String searchBy = search.getSearchBy();
            System.out.println(searchBy);
            stmt = con.createStatement();
            StringBuilder sql = new StringBuilder("SELECT * from movies where ");
            sql.append(searchBy);
            sql.append(" = ");
            sql.append("'");
            sql.append(keyword);
            sql.append("'");
            sql.append(";");
            System.out.println(sql);
            rs = stmt.executeQuery(sql.toString());
            List<Movie> movieList = new ArrayList<Movie>();
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setTitle(rs.getString("title"));
                movie.setActor(rs.getString("actor"));
                movie.setActress(rs.getString("actress"));
                movie.setGenre(rs.getString("genre"));
                movie.setYear(rs.getInt("year"));
                movieList.add(movie);
            }
            return movieList;
        } catch (SQLException ex) {
            Logger.getLogger(MoviesService.class.getName()).log(Level.SEVERE, null, ex);
            //out.println("SQL Error " + ex);
        }
        return null;
    }

    public boolean addMovie(Movie movie) {
        PreparedStatement preparedStatement = null;
        try {
            String sql = "INSERT INTO movies (title,actor,actress,genre,year) VALUES (?,?,?,?,?)";
            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getActor());
            preparedStatement.setString(3, movie.getActress());
            preparedStatement.setString(4, movie.getGenre());
            preparedStatement.setInt(5, movie.getYear());
            int affectedRows = preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            //out.println("SQL Error " + ex);
            Logger.getLogger(MoviesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
