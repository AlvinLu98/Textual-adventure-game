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
public class Game implements Serializable, Cloneable{
    private ArrayList<Room> rooms;
    private Player player;
    
     public Game(){
         rooms = new ArrayList<>();
    }
    
    @Override
    public java.lang.Object clone() throws CloneNotSupportedException{
        return super.clone();
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
        removeObjectFromCurrentRoom(o);
    }
    
    public void removeRoom(Room r){
        rooms.remove(r);
    }
    
    public void removeObjectFromCurrentRoom(Object o){
        Room room = player.getLocation();
        room.removeObject(o);
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
    
    public void addObjectToCurrentRoom(Object o){
        player.getLocation().addObject(o);
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
    
    public Object findObjectInRoomByName(String o){
        for(Object obj: player.getLocation().getObject()){
            if(obj.getName().equals(o)){
                return obj;
            }    
            else if(obj instanceof Container){
                return ((Container) obj).findObjectByName(o);
            }
        }
        return null;
    }
    
    public boolean movePlayer(String direction){
        Room r = findRoom(player.getLocation());
        r.removeObject(player);

        r = findRoom(player.move(direction));
        if(r.addObject(player)){
            return true;
        }
        return false;
    }
}
