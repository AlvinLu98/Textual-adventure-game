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
public class Game implements Serializable{
    private ArrayList<Room> rooms;
    private Player player;
    
     public Game(){
         rooms = new ArrayList<>();
    }
    
    public Game(ArrayList<Room> r, Player p){
        this.rooms = r;
        this.player = p;
    }
    
    public ArrayList<Room> getRooms(){
        return this.rooms;
    }
    
    public Player getPlayer(){
        return this.player;
    }
    
    public void addRoom(Room r){
        this.rooms.add(r);
    }
    
    public void addPlayer(Player p){
        this.player = p;
    }
    
    public ArrayList<Object> getRoomObjects(){
        return this.player.getLocation().getObject();
    }
    
    public ArrayList<Object> getPlayerObject(){
        return this.player.getItems();
    }
    
    public void givePlayer(Object o){
        this.player.pickup(o);
    }
    
    public void removeRoom(Room r){
        rooms.remove(r);
    }
    
    public void addObjectToRoom(String r, Object o){
        for(Room rooms:this.rooms){
            if(rooms.getName().equals(r)){
                rooms.addObject(o);
            }
        }
    }
    
    public void addObjectToRoom(Room r, Object o){
        for(Room rooms: this.rooms){
            if(rooms.getName().equals(r.getName())){
                rooms.addObject(o);
            }
        }
    }
    
    public Room findRoom(Room r){
        for(Room rooms: this.rooms){
            if(rooms.getName().equals(r.getName())){
                return rooms;
            }
        }
        return null;
    }
    
    public Room findRoomByName(String n){
        for(Room rooms: this.rooms){
            if(rooms.getName().equals(n)){
                return rooms;
            }
        }
        return null;
    }
    
    public Object findObject(Room r, Object o){
        Room room = findRoom(r);
        for(Object obj: room.getObject()){
            if(obj.getName().equals(o.getName())){
                return obj;
            }    
            else if(obj instanceof Container){
                return ((Container) obj).findObject(o);
            }
        }
        return null;
    }
}
