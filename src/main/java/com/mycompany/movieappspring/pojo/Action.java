/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.movieappspring.pojo;

import org.springframework.stereotype.Component;

/**
 *
 * @author sho7
 */
@Component
public class Action {
    private String selectAction;

    public Action() {
    }

    public Action(String selectAction) {
        this.selectAction = selectAction;
    }

    public String getSelectAction() {
        return selectAction;
    }

    public void setSelectAction(String selectAction) {
        this.selectAction = selectAction;
    }
    
}
