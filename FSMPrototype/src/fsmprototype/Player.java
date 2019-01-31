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
public class Player extends Living_Objects{
    private Container inventory;
    private Room currentLocation;
    
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
    
    public void pickup(Object o){
        inventory.addObjects(o);
    }
}
