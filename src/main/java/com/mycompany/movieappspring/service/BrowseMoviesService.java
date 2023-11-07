/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.movieappspring.service;

import com.mycompany.movieappspring.pojo.Movie;
import com.mycompany.movieappspring.pojo.Search;
import jakarta.servlet.RequestDispatcher;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class BrowseMoviesService {

    Connection con;

    public BrowseMoviesService() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/moviedb", "root", "12345678");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BrowseMoviesService.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(BrowseMoviesService.class.getName()).log(Level.SEVERE, null, ex);
            //out.println("SQL Error " + ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                System.out.println("All connections closed in search");
            } catch (SQLException e) {
                Logger.getLogger(BrowseMoviesService.class.getName()).log(Level.SEVERE, null, e);
                //out.println("SQL Error during closing connections in search" + e);
            }
        }
        return null;
    }
}
