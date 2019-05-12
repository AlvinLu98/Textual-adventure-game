package fsmprototype;

import java.io.Serializable;

/**
 *
 * @author Alvin Lu
 */
public class Unlimited_Use_Object extends Usable_Object implements Serializable{
    private int use_Count = 0;
    
    /**
     * Constructor for unlimited use object
     * @param name 
     */
    public Unlimited_Use_Object(String name){
        super(name);
    }
    
    /**
     * Increments the amount of times the object is used
     * @return true when the object is used
     */
    @Override
    public boolean use(){
        use_Count++;
        return true;
    }
    
    /**
     * Returns the amount of times it has been used
     * @return number of times it has been used in int
     */
    public int getUseAmt(){
        return this.use_Count;
    }
}
