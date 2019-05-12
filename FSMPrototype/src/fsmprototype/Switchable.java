package fsmprototype;

import java.io.Serializable;

/**
 *
 * @author Alvin Lu
 */
public class Switchable extends Object implements Serializable{
    private boolean is_Switched_On = false;
    
    /**
     * Creates and empty switchable object
     * @param name 
     */
    public Switchable(String name){
        super(name);
    }

    /**
     * Switch on the object, changes the boolean value to true
     * @return true if object is switched on successfully
     */
    public boolean switchOn(){
        if(this.is_Switched_On){
            return false;
        }
        this.is_Switched_On = true;
        return true;
    }
    
    /**
     * Switch on the object, changes the boolean value to false
     * @return true if object is switched off successfully
     */
    public boolean switchOff(){
        if(!this.is_Switched_On){
            return false;
        }
        this.is_Switched_On = false;
        return true;
    }
}
