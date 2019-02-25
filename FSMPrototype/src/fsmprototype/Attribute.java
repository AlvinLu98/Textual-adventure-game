package fsmprototype;

import java.io.Serializable;

/**
 *
 * @author Alvin Lu
 */
public abstract class Attribute implements Serializable 
{
    private String name;
    private String verb;
    
    public String getName(){
        return this.name;
    }
    
    public String getVerb(){
        return this.verb;
    }
}
