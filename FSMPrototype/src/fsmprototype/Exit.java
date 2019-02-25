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
public class Exit implements Serializable{
    private String name;
    private Room exitRoom;
    
    public Exit(String name, Room exit){
        this.name = name;
        this.exitRoom = exit;
    }
    
    public String getName(){
        return this.name;
    }
    
    public Room takeExit(){
        return this.exitRoom;
    }
}
