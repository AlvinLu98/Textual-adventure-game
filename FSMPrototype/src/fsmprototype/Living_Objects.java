/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmprototype;

import java.io.Serializable;

/**
 *
 * @author Alvin Lu
 */
public class Living_Objects extends Object implements Serializable{
    private char gender;
    private String prefix;
    private String suffix;
    private String article;
    private String possesive;
    
    public Living_Objects(String name){
        super(name);
    }
}
