/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.movieappspring.models;

import org.springframework.stereotype.Component;

/**
 *
 * @author sho7
 */
@Component
public class Search {
    private String searchBy;
    private String keyword;

    public Search() {
    }

    public Search(String searchBy, String keyword) {
        this.searchBy = searchBy;
        this.keyword = keyword;
    }

    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
}
