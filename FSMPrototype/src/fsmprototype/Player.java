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
    Container inventory;
    Room currentLocation;
    
    public Room getLocation(){
     return currentLocation;
    }
    
    public ArrayList<Object> getItems(){
        return inventory.getObjects();
    }
}
