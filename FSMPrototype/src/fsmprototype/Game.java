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
    private ArrayList<Verb> verbList;
    
     public Game(){
         this.rooms = new ArrayList<>();
         this.verbList = new ArrayList();
    }
     
    public Game(Game g){
        this.rooms = g.rooms;
        this.player = g.getPlayer();
        this.verbList = new ArrayList();
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
    
    public void addVerb(Verb v){
        this.verbList.add(v);
    }
    
    public ArrayList<Object> getRoomObjects(){
        return this.player.getLocation().getObject();
    }
    
    public ArrayList<Object> getPlayerObject(){
        return this.player.getItems();
    }
    
    public ArrayList<Verb> getVerbList(){
        return this.verbList;
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
            else{
                player.findObjectByName(o);
            }
        }
        return null;
    }
    
    public Object findObjectandRoomByName(String r, String o){
        Room room = findRoomByName(r);
        for(Object obj: room.getObject()){
            if(obj.getName().equals(o)){
                return obj;
            }    
            else if(obj instanceof Container){
                return ((Container) obj).findObjectByName(o);
            }
            else{
                player.findObjectByName(o);
            }
        }
        return null;
    }
    
    public Object findAssociatedObjinVerb(String verb, String dep){
        for(Verb v: this.verbList){
            if(v.getName().equals(verb)){
                if(v.getAssociatedObject().getName().equals(dep)){
                    return v.getAssociatedObject();
                }
            }
        }
        return null;
    }
    
    public Attribute findAttByAssociatedObject(String verbName, Object o){
        for(Verb v: this.verbList){
            if(v.getAssociatedObject().getName().equals(o.getName())){
                for(Attribute a: v.getOwnerObject().getAttributes()){
                    if(a.getVerb().getName().equals(verbName)){
                        return a;
                    }
                }
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
