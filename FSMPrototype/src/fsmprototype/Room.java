package fsmprototype;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Inherits Object  
 * @author Alvin Lu
 */
public class Room extends Object implements Serializable{
    private ArrayList<Object> objects;
    private LinkedList<Exit> exits;
    
    /**
     * Constructor for Room, creates a room without exits and objects
     * @param name Name of the room
     */
    public Room(String name){
        super(name, new State("Unlocked"));
        this.objects = new ArrayList();
        this.exits = new LinkedList();
    }
    
    /**
     * Constructor for Room, creates a room with list of objects
     * @param name Name of the room
     * @param objects List of objects
     */
    public Room(String name, ArrayList<Object> objects){
        super(name);
        this.objects = objects;
    }
    
    /**
     * Constructor for Room, creates a room with a description and list of
     * objects
     * @param name Name of the room
     * @param desc description of room
     * @param objects list of objects
     */
    public Room(String name, String desc, ArrayList<Object> objects){
        super(name, desc);
        this.objects = objects;
    }
    
    /**
     * Constructor for Room, creates a room with Exits
     * @param name name of room
     * @param exits list of exits
     */
    public Room(String name, LinkedList<Exit> exits){
        super(name);
        this.exits = exits;
    }
    
    /**
     * Constructor for Room, creates a room with objects and exits
     * @param name name of room
     * @param objects list of objects
     * @param exits list of exits
     */
    public Room(String name, ArrayList<Object> objects, LinkedList<Exit> exits){
        super(name);
        this.objects = objects;
        this.exits = exits;
    } 
    
    /**
     * Returns the name of the room
     * @return name of room in String
     */
    public String getName(){
        return super.getName();
    }
    
    /**
     * Returns the description of room
     * @return room description in String
     */
    public String getDescription(){
        return super.getDesc();
    }
    
    /**
     * Returns the list of Exits
     * @return list of exits in LinkedList
     */
    public LinkedList<Exit> getExit(){
        return this.exits;
    }
    
    /**
     * Returns a list of Object
     * @return a list of objects in room as ArrayList
     */
    public ArrayList<Object> getObject(){
        return this.objects;
    }
    
    /**
     * Add an object to the room
     * @param obj object to be added
     * @return true if added successfully
     */
    public boolean addObject(Object obj){
        return this.objects.add(obj);
    }
    
    /**
     * Add an exit to the room
     * @param name name of the exit
     * @param exit room that the exit leads to
     * @return true if exit added successfully
     */
    public boolean addExit(String name, Room exit){
        Exit e = new Exit(name, exit);
        if(!exits.contains(e)){
            return this.exits.add(e);
        }
        return false;
    }
    
    /**
     * Remove an exit given the name
     * @param n name of the exit
     */
    public void removeExit(String n){
        for(Exit e: exits){
            if(e.getName().equals(n)){
                exits.remove(e);
            }
        }
    }
    
    /**
     * Remove and object given an object
     * @param o object to be removed
     * @return true if removed successfully
     */
    public boolean removeObject(Object o){
        for(Object obj: this.objects){
            if(obj.getName().equals(o.getName())){
                return this.objects.remove(o);
            }    
            else if(obj instanceof Container){
                return ((Container) obj).removeObject(o);
            }
        }
        return false;
    }
    
    /**
     * Object picked up by Player, Object with the given name removed from Room
     * and returned
     * @param name of object to be picked up
     * @return Object that matches the name
     */
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
    
    /**
     * Find an object given an object
     * @param o Object to find in the room
     * @return Object that matches the given Object
     */
    public Object findObject(Object o){
        for(Object obj: this.objects){
            if(obj.getName().equals(o.getName())){
                return obj;
            }    
            else if(obj instanceof Container){
                return ((Container) obj).findObject(o);
            }
        }
        return null;
    }

    /**
     * Sets the attribute to the given value
     * @param n name of attribute
     * @param value value of attribute
     */
    @Override
    public void setAttribute(String n, double value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Sets the attribute to the given value
     * @param n name of attribute
     * @param b value of attribute
     */
    @Override
    public void setAttribute(String n, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
