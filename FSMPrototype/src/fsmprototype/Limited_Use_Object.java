package fsmprototype;

import java.io.Serializable;

/**
 * Object with limited usage
 * @author Alvin Lu
 */
public class Limited_Use_Object extends Usable_Object implements Serializable{
    protected int uses_Left;
    
    /**
     * Constructor for limited use object, creates an object without specifying
     * uses left
     * @param name name of limited use object
     */
    public Limited_Use_Object(String name){
        super(name);
    }
    
    /**
     * Constructor for limited use object
     * @param name name of limited use object
     * @param uses number of uses
     */
    public Limited_Use_Object(String name, int uses){
        super(name);
        this.uses_Left = uses;
    }
    
    /**
     * Get the amount of uses left
     * @return number of uses left in int
     */
    public int getUsesLeft(){
        return this.uses_Left;
    }
    
    /**
     * Set the amount of uses
     * @param i amount of uses
     */
    public void setUses(int i){
        this.uses_Left = i;
    }
    
    /**
     * use the object if there are uses left
     * @return true if object is still usable
     */
    @Override
    public boolean use(){
        if(uses_Left > 0){
            uses_Left--;
            return true;
        }
        return false;
    }
}
