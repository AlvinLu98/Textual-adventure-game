package fsmprototype;

import java.io.Serializable;

/**
 *
 * @author Alvin Lu
 */
public abstract class Attribute implements Serializable
{
    private String name;
    private Verb verb;
    private boolean inRoom = false;
    
    public Attribute(){ }
    
    public Attribute(String name, String verb, Object o, Object own){
        this.name = name;
        this.verb = new Verb(verb, o, own);
    }
    
    public String getName(){
        return this.name;
    }
    
    public Verb getVerb(){
        return this.verb;
    }
    
    public void usableInSameRoom(){
        this.inRoom = true;
    }
    
    public boolean inRoom(){
        return this.inRoom;
    }
    
    public abstract boolean modify();
}
