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
    
    public void addObjectToRoom(String r, Object o){
        for(Room rooms:this.rooms){
            if(rooms.getName().equals(r)){
                rooms.addObject(o);
            }
        }
    }
}
