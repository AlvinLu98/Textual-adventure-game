/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmprototype;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Alvin Lu
 */
public class Room extends Object implements Serializable{
    private ArrayList<Object> objects;
    private LinkedList<Exit> exits;
    
    public Room(String name){
        super(name);
        this.objects = new ArrayList();
        this.exits = new LinkedList();
    }
    
    public Room(String name, ArrayList<Object> objects){
        super(name);
        this.objects = objects;
    }
    
    public Room(String name, LinkedList<Exit> exits){
        super(name);
        this.exits = exits;
    }
    
    public Room(String name, ArrayList<Object> objects, LinkedList<Exit> exits){
        super(name);
        this.objects = objects;
        this.exits = exits;
    }
    
    public String getName(){
        return super.getName();
    }
    
    public LinkedList<Exit> getExit(){
        return this.exits;
    }
    
    public ArrayList<Object> getObject(){
        return this.objects;
    }
    
    public boolean addObject(Object obj){
        return this.objects.add(obj);
    }
    
    public boolean addExit(String name, Room exit){
        Exit e = new Exit(name, exit);
        return this.exits.add(e);
    }
    
    public Object pickedUp(String name){
        Object obj = null;
        for(Object o: objects){
            if(o.getName().equals(name)){
                obj = o;
                break;
            }
        }
        objects.remove(obj);
        return obj;
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
