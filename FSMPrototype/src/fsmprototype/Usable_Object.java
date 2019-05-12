package fsmprototype;

import java.io.Serializable;

/**
 *
 * @author Alvin Lu
 */
public abstract class Usable_Object extends Object implements Serializable{
    private boolean is_Usable = true;
    
    /**
     * Constructor for usable object
     * @param name 
     */
    public Usable_Object(String name){
        super(name);
    }
    
    /**
     * Make the object unusable
     */
    public void make_Unusable(){
        this.is_Usable = false;
    }
    
    /**
     * Return if the object is usable
     * @return true if object is usable
     */
    public boolean isUsable(){
        return this.is_Usable;
    }
    
    public abstract boolean use();
}
