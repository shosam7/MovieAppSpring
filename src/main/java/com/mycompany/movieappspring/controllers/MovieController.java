/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.movieappspring.controllers;

import com.mycompany.movieappspring.pojo.Action;
import com.mycompany.movieappspring.pojo.Movie;
import com.mycompany.movieappspring.pojo.Search;
import com.mycompany.movieappspring.service.BrowseMoviesService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sho7
 */
@Controller
public class MovieController {
    
    @Autowired
    BrowseMoviesService browseService;
    
    @GetMapping("/index.htm")
    public String showIndexGetHandler(ModelMap model, Action action) {
        model.addAttribute("action", action);
        return "index";
    }
    
    @PostMapping("/action")
    public ModelAndView actionHandler(@ModelAttribute("action") Action action) {
        ModelAndView mv = new ModelAndView();
        String selectAction = action.getSelectAction();
        if(selectAction.equalsIgnoreCase("browse")) {
            mv.setViewName("search");
            Search search = new Search();
            mv.addObject("search", search);
            return mv;
        } else {
            return mv;
        }
    }
    
    @ModelAttribute("searchRadioOptions")
    public List<String> getSearchRadioOptions() {
        return Arrays.asList("Title", "Actor", "Actress");
    }
    
    @PostMapping("/search")
    public ModelAndView searchHandler(@ModelAttribute("search") Search search) {
        List<Movie> movies = browseService.getMovies(search);
        for(Movie movie : movies) {
            System.out.println(movie.getActor());
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("result");
        mv.addObject("search", search);
        mv.addObject("movies", movies);
        return mv;
    }
    
//    @RequestMapping(value = "/MovieAppSpring/browse", method = RequestMethod.GET)
//    public String browseMovies() {
//        System.out.println("Inside");
//        return "search";
//    }
}