package fsmprototype;

import java.io.Serializable;

/**
 * Exit class for Room exits
 * @author Alvin Lu
 */
public class Exit implements Serializable{
    private String name;
    private Room exitRoom;
    
    /**
     * Constructor for exit
     * @param name name of exit
     * @param exit Room the exit leads to
     */
    public Exit(String name, Room exit){
        this.name = name;
        this.exitRoom = exit;
    }
    
    /**
     * Return the name of the exit
     * @return the name of the exit in String
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Return the Room the exit leads to
     * @return Room the exit leads to
     */
    public Room takeExit(){
        return this.exitRoom;
    }
}
