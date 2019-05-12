package fsmprototype;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Player object, users will control this object for movement
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
        Object f = null;
         for(Object obj: this.inventory.getObjects()){
            if(obj.getName().equalsIgnoreCase(o)){
                f = obj;
            }    
            else if(obj instanceof Container){
                f = ((Container) obj).findObjectByName(o);
            }
        }
        return f;
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
