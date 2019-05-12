package fsmprototype;

import java.io.Serializable;

/**
 *
 * @author Alvin Lu
 */
public class Wearable extends Object implements Serializable{
    private boolean is_Worn = false;
    private Living_Objects owner;
    
    /**
     * Constructor for wearable, Create a wearable object with no owner
     * @param name name of wearable
     */
    public Wearable(String name){
        super(name);
    }
    
    /**
     * Constructor for wearable, Create a wearable object with no owner
     * @param name name of wearable
     * @param owner owner of the wearable
     */
    public Wearable(String name, Living_Objects owner){
        super(name);
        this.owner = owner;
        this.is_Worn = true;
    }
    
    /**
     * allows an living object to wear the object, changes wearing to true
     * @return true if object is worn successfully
     */
    public boolean wear(Living_Objects owner){
        this.owner = owner;
        if(this.is_Worn){
            return false;
        }
        this.is_Worn = true;
        return true;
    }
    
    /**
     * Remove the object from the owner
     * @return true if object is taken off successfully
     */
    public boolean takeOff(){
        if(!this.is_Worn){
            return false;
        }
        this.is_Worn = false;
        return true;
    }
    
    /**
     * change the owner to the object
     * @param owner owner the object is changed to
     */
    public void changeOwner(Living_Objects owner){
        this.owner = owner;
    }
}
