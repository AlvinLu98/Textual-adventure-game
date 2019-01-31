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
public class Room_Creator {
    
    private ArrayList<Room> room_List;
    
    public Room_Creator(){}
    
    public Object createRoom(String name){
        Object room = new Room("test");
        return room;
    }
    
    public boolean addObjectToRoom(String room, Object obj){
        for(Room r: room_List){
            if(r.getName().equals(room)){
                return r.addObject(obj);
            }
        }
        return false;
    }
}
