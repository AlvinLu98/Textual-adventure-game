/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmprototype;

import java.util.ArrayList;

/**
 *
 * @author Alvin Lu
 */
public class Human extends Living_Objects{
    ArrayList<Information> informations;
    Container inventory;
    
    public Human(String name){
        super(name);
    }
    
    public String ask(String prompt){
        for(Information i: informations){
            if(i.getPrompt().equals(prompt)){
                return i.getAnswer();
            }
        }
        return "No answer";
    }
}
