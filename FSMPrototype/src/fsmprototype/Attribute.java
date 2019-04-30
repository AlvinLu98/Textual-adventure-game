package fsmprototype;

import java.io.Serializable;

/**
 *
 * @author Alvin Lu
 */
public abstract class Attribute implements Serializable, Cloneable 
{
    private String name;
    private String verb;
    
    public Attribute(){
        
    }
    
    public Attribute(String name, String verb){
        
    }
    
    @Override
    protected java.lang.Object clone() throws CloneNotSupportedException
    {
        Attribute a = (Attribute)super.clone();
        return a;
    } 
    
    public String getName(){
        return this.name;
    }
    
    public String getVerb(){
        return this.verb;
    }
}
