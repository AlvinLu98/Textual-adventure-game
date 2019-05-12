package fsmprototype;

import java.io.Serializable;

/**
 * Verb class to define a verb
 * @author Alvin Lu
 */
public class Verb implements Serializable
{
    private String name;
    private boolean effect;
    private Object associated;
    private Object owner;
    
    /**
     * Constructor for verb, creates a verb without stating the effect
     * @param name name of verb
     * @param o object associated with verb
     * @param own owner of the verb the attribute or transition is associated to 
     */
    public Verb(String name, Object o, Object own){
        this.name = name;
        this.associated = o;
        this.owner = own;
    }
    
    /**
     * Constructor of verb
     * @param name name of verb
     * @param o object associated with the verb
     * @param own owner of the verb the attribute or transition is associated to
     * @param b determines whether if the verb affects poisitively or negatively
     */
    public Verb(String name, Object o, Object own, boolean b){
        this.name = name;
        this.associated = o;
        this.owner = own;
        this.effect = b;
    }
    
    /**
     * Get the name of the verb
     * @return 
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Get the object associated to the verb
     * @return the associated object
     */
    public Object getAssociatedObject(){
        return this.associated;
    }
    
    /**
     * Get the object that the contains the attribute or transition that owns
     * the verb
     * @return Object that owns the verb
     */
    public Object getOwnerObject(){
        return this.owner;
    }
    
    /**
     * Get the effect of the verb
     * @return true if it's positive effect and false otherwise
     */
    public boolean getEffect(){
        return this.effect;
    }
}
