/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmprototype;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Alvin Lu
 */
public class Verb implements Serializable
{
    private String name;
    private boolean effect;
    private Object associated;
    private Object owner;
    
    public Verb(String name, Object o, Object own){
        this.name = name;
        this.associated = o;
        this.owner = own;
    }
    
    public Verb(String name, Object o, Object own, boolean b){
        this.name = name;
        this.associated = o;
        this.owner = own;
        this.effect = b;
    }
    
    public String getName(){
        return this.name;
    }
    
    public Object getAssociatedObject(){
        return this.associated;
    }
    
    public Object getOwnerObject(){
        return this.owner;
    }
    
    public boolean getEffect(){
        return this.effect;
    }
}
