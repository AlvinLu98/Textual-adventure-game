package fsmprototype;

import java.io.Serializable;

/**
 *
 * @author Alvin Lu
 */
public class Pick_Able_Object extends Object implements Serializable{
    private boolean is_Picked_Up = false;
    
    public Pick_Able_Object(String name){
        super(name);
    }
    
    /**
     * Check if the object has been picked up
     * @return true if object is not picked up
     */
    public boolean pickUp(){
        if(this.is_Picked_Up){
            return false;
        }
        this.is_Picked_Up = true;
        return true;
    }
    
    /**
     * Drop the object and changed the picked up boolean to false
     * @return true if object dropped successfully
     */
    public boolean drop(){
        if(!this.is_Picked_Up){
            return false;
        }
        this.is_Picked_Up = false;
        return true;
    }
}
