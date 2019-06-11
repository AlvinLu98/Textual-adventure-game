package fsmprototype;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Game object that is used for editing and playing
 * @author Alvin Lu
 */
public class Game implements Serializable{
    private ArrayList<Room> rooms;
    private Player player;
    private ArrayList<Verb> verbList;
    
    /**
     * Constructor for game, creates an empty game
     */
    public Game(){
        this.rooms = new ArrayList<>();
        this.verbList = new ArrayList();
    }
     
    /**
     * Constructor for game, creates a copy of another game
     * @param g 
     */
    public Game(Game g){
        this.rooms = g.rooms;
        this.player = g.getPlayer();
        this.verbList = new ArrayList();
    }
    
    /**
     * Constructor for game, creates a game with rooms and player
     * @param r list of rooms
     * @param p player object
     */
    public Game(ArrayList<Room> r, Player p){
        this.rooms = r;
        this.player = p;
    }
    
    /**
     * Returns the list of rooms
     * @return list of rooms in ArrayList
     */
    public ArrayList<Room> getRooms(){
        return this.rooms;
    }
    
    /**
     * Returns the player
     * @return the player in Player
     */
    public Player getPlayer(){
        return this.player;
    }
    
    /**
     * Add a room into the game
     * @param r room to be added
     */
    public void addRoom(Room r){
        this.rooms.add(r);
    }
    
    /**
     * Add a player into the game
     * @param p player to be added
     */
    public void addPlayer(Player p){
        this.player = p;
    }
    
    /**
     * Add a verb into the verb list
     * @param v verb to be added
     */
    public void addVerb(Verb v){
        this.verbList.add(v);
    }
    
    /**
     * Returns the list of objects in the current room
     * @return list of objects in ArrayList
     */
    public ArrayList<Object> getRoomObjects(){
        return this.player.getLocation().getObject();
    }
    
    /**
     * Returns the list of objects in the players inventory
     * @return list of objects in ArrayList
     */
    public ArrayList<Object> getPlayerObject(){
        return this.player.getItems();
    }
    
    /**
     * Returns the list of verbs in the game
     * @return list of verbs in ArrayList
     */
    public ArrayList<Verb> getVerbList(){
        return this.verbList;
    }
    
    /**
     * Delete a verb given its name
     * @param verb name of verb
     * @return true if verb is deleted
     */
    public boolean deleteVerb(String verb){
        for(int i = 0; i < this.verbList.size(); i++){
            if(verb.equalsIgnoreCase(this.verbList.get(i).getName())){
                this.verbList.remove(i);
                i = this.verbList.size();
            }
        }
        return false;
    }
    
    /**
     * Moves and object into player's inventory
     * @param o 
     */
    public void givePlayer(Object o){
        this.player.pickup(o);
        this.player.getLocation().pickedUp(o.getName());
    }
    
    /**
     * Removes a room from the game
     * @param r room to be removed
     */
    public void removeRoom(Room r){
        rooms.remove(r);
    }
    
    /**
     * Remove an object from the current room
     * @param o object to be removed
     */
    public void removeObjectFromCurrentRoom(Object o){
        Room room = player.getLocation();
        room.removeObject(o);
    }
    
    /**
     * Add an object into the a room
     * @param r name of room
     * @param o Object to be added to room
     */
    public void addObjectToRoom(String r, Object o){
        for(Room rooms:this.rooms){
            if(rooms.getName().equalsIgnoreCase(r)){
                rooms.addObject(o);
            }
        }
    }
    
    /**
     * Add an object into a room
     * @param r Room object
     * @param o Object to be added to room
     */
    public void addObjectToRoom(Room r, Object o){
        for(Room rooms: this.rooms){
            if(rooms.getName().equalsIgnoreCase(r.getName())){
                rooms.addObject(o);
            }
        }
    }
    
    /**
     * Add an object into the current room
     * @param o Object to be added to the room
     */
    public void addObjectToCurrentRoom(Object o){
        player.getLocation().addObject(o);
    }
    
    /**
     * Find a room given a room object
     * @param r Room to find
     * @return room with the same name
     */
    public Room findRoom(Room r){
        for(Room rooms: this.rooms){
            if(rooms.getName().equalsIgnoreCase(r.getName())){
                return rooms;
            }
        }
        return null;
    }
    
    /**
     * Find a room given the name
     * @param n name of room
     * @return Room object with the same name
     */
    public Room findRoomByName(String n){
        for(Room rooms: this.rooms){
            if(rooms.getName().equalsIgnoreCase(n)){
                return rooms;
            }
        }
        return null;
    }
    
    /**
     * Find an object given a room and object
     * @param r room the object is in
     * @param o object to find
     * @return Object if found in room
     */
    public Object findObject(Room r, Object o){
        Room room = findRoom(r);
        Object f = null;
        for(Object obj: room.getObject()){
            if(obj.getName().equalsIgnoreCase(o.getName())){
                f = obj;
            }    
            else if(obj instanceof Container){
                f = ((Container) obj).findObject(o);
            }
            else if (obj instanceof Player){
                f = ((Player) obj).findObject(o);
            }
        }
        return f;
    }
    
    /**
     * Find an object in the current room by its name
     * @param o name of object
     * @return Object that matches given name
     */
    public Object findObjectInRoomByName(String o){
        Object f = null;
        for(Object obj: player.getLocation().getObject()){
            if(f != null){
                break;
            }
            if(obj.getName().equalsIgnoreCase(o)){
                return obj;
            }    
            else if(obj instanceof Container){
                f  = ((Container) obj).findObjectByName(o);
            }
            else if(obj instanceof Player){
                f =  ((Player) obj).findObject(f);
            }
        }
        return f;
    }
    
    /**
     * Find a object in a room given both room and object name
     * @param r name of room
     * @param o name of object
     * @return Object that matches the given name
     */
    public Object findObjectandRoomByName(String r, String o){
        Room room = findRoomByName(r);
        Object j = null;
        if(room != null){
            for(Object obj: room.getObject()){
                if(obj.getName().equalsIgnoreCase(o)){
                    j = obj;
                }    
                else if(obj instanceof Container){
                    j = ((Container) obj).findObjectByName(o);
                }
                else if(obj instanceof Player){
                    j = ((Player) obj).findObjectByName(o);
                }
            }
        }
        return j;
    }
    
    /**
     * Find the object associated with the verb given the verb and subject
     * @param verb name of the verb
     * @param dep name of associated object
     * @return Associated object that matches the name and verb
     */
    public Object findAssociatedObjinVerb(String verb, String dep){
        for(Verb v: this.verbList){
            if(v.getName().equalsIgnoreCase(verb)){
                if(v.getAssociatedObject().getName().equalsIgnoreCase(dep)){
                    return v.getAssociatedObject();
                }
            }
        }
        return null;
    }
    
    /**
     * Find the attribute of an associated object
     * @param verbName name of the verb
     * @param o Associated object
     * @return Attribute of the associated object
     */
    public Attribute findAttByAssociatedObject(String verbName, Object o){
        for(Verb v: this.verbList){
            if(v.getAssociatedObject() != null){
                if(v.getAssociatedObject().getName().equalsIgnoreCase(
                        o.getName())){
                    for(Attribute a: v.getOwnerObject().getAttributes()){
                        if(a.getVerb().getName().equals(verbName)){
                            return a;
                        }
                    }
                }
            }
        }
        return null;
    }
    
    /**
     * Move player towards a direction
     * @param direction name of the exit
     * @return true if the player has moved
     */
    public boolean movePlayer(String direction){
        Room r = player.getLocation();
        player.move(direction);
        r.getObject().remove(player);
        
        Room dest = player.getLocation();
        
        System.out.println(r.getObject());
        System.out.println(dest.getObject());
        
        if(!r.getName().equals(dest.getName())){
            if(dest.addObject(player)){
               return true; 
            }
        }
        return false;
    }
}
