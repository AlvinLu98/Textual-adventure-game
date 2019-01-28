/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmprototype;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Alvin Lu
 */
public class Room extends Object{
    private String name;
    private ArrayList<Object> objects;
    private LinkedList<Exit> exits;
    
    public Room(String name){
        this.name = name;
    }
    
    public Room(String name, ArrayList<Object> objects){
        this.name = name;
        this.objects = objects;
    }
    
    public Room(String name, LinkedList<Exit> exits){
        this.name = name;
        this.exits = exits;
    }
    
    public Room(String name, ArrayList<Object> objects, LinkedList<Exit> exits){
        this.name = name;
        this.objects = objects;
        this.exits = exits;
    }
    
    public void addObject(Object obj){
        this.objects.add(obj);
    }
    
    @Override
    public boolean sendAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAttribute(String n, double value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAttribute(String n, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
