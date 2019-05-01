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
public class Player extends Living_Objects implements Serializable{
    private Container inventory;
    private Room currentLocation;
    
    public Player(String name){
        super(name);
        this.inventory = new Container("Inventory");
    }
    
    public Player(String name, Room r){
        super(name);
        this.currentLocation = r;
        this.inventory = new Container("Inventory");
    }
    
    public Player(String name, Container c, Room r){
        super(name);
        this.inventory = c;
        this.currentLocation = r;
    }
    
    public Room getLocation(){
     return currentLocation;
    }
    
    public ArrayList<Object> getItems(){
        return inventory.getObjects();
    }
    
    public void setLocation(Room r){
        this.currentLocation = r;
    }
    
    public void pickup(Object o){
        inventory.addObjects(o);
    }
    
    public Object drop(String name){
        Object obj = null;
        for(Object o:inventory.getObjects()){
            if(o.getName().equals(name)){
                obj = o;
            }
        }
        return inventory.dropObject(obj);
    }
    
     public Object findObject(Object o){
        for(Object obj: this.inventory.getObjects()){
            if(obj.getName().equals(o.getName())){
                return obj;
            }    
            else if(obj instanceof Container){
                return ((Container) obj).findObject(o);
            }
        }
        return null;
    }
     
     public Object findObjectByName(String o){
        for(Object obj: this.inventory.getObjects()){
            if(obj.getName().equals(o)){
                return obj;
            }    
            else if(obj instanceof Container){
                return ((Container) obj).findObjectByName(o);
            }
        }
        return null;
    }
    
    public Room move(String direction){
        LinkedList<Exit> exit = this.currentLocation.getExit();
        for(Exit e: exit){
            System.out.println(e.getName());
            if(e.getName().equals(direction)){
                this.currentLocation = e.takeExit();
                return e.takeExit();
            }
        }
        return null;
    }
}
