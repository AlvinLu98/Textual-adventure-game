package fsmprototype;

import java.io.Serializable;

/**
 * Abstract class for attribute, extends into number attribute and  boolean
 * attribute
 * @author Alvin Lu
 */
public abstract class Attribute implements Serializable
{
    private String name;
    private Verb verb;
    private boolean inRoom = false;
    
    /**
     * Empty constructor
     */
    public Attribute(){ }
    
    /**
     * Constructor for attribute, creates a full attribute
     * @param name
     * @param verb
     * @param o
     * @param own 
     */
    public Attribute(String name, String verb, Object o, Object own){
        this.name = name;
        this.verb = new Verb(verb, o, own);
    }
    
    /**
     * Constructor for attribute, creates a full attribute
     * @param name
     * @param verb
     * @param o
     * @param own 
     */
    public Attribute(String name, String verb, Object o, Object own, 
            boolean val){
        this.name = name;
        this.verb = new Verb(verb, o, own, val);
    }
    
    /**
     * Returns the name of the attribute
     * @return name of attribute in String
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Returns the verb of the attribute
     * @return verb associated with attribute as Verb
     */
    public Verb getVerb(){
        return this.verb;
    }
    
    /**
     * Makes the attribute only call-able in the same room
     */
    public void usableInSameRoom(){
        this.inRoom = true;
    }
    
    /**
     * Returns if the attribute is only call-able in the same room
     * @return true if attribute can only be modified if player is in the room
     */
    public boolean inRoom(){
        return this.inRoom;
    }
    
    /**
     * Abstract method, modifies the attribute value
     * @param b
     * @return 
     */
    public abstract boolean modify(boolean b);
}
