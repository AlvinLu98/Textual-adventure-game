package fsmprototype;

import java.io.Serializable;

/**
 * @author Alvin Lu
 */
public class Boolean_Attribute extends Attribute implements Serializable
{
    private boolean condition;
    
    /**
     * Empty constructor
     */
    public Boolean_Attribute(){}
    
    /**
     * Constructor for Boolean attribute
     * @param n name of attribute
     * @param verb verb associated
     * @param v default value
     * @param o object associated
     * @param own owner of object
     */
    public Boolean_Attribute(String n, String verb, boolean v, Object o,
            Object own){
        super(n, verb, o, own);
        this.condition = v;
    }
    
    /**
     * Returns the current condition of the attribute
     * @return current condition of the attribute
     */
    public boolean getCondition(){
        return this.condition;
    }
    
    /**
     * Explicitly change the condition of the attribute
     * @param b boolean attribute to change to
     * @return the current condition
     */
    public boolean explicitChange(boolean b){
        this.condition = b;
        return this.condition;
    }
    
    /**
     * Modify the current condition
     * @param b 
     * @return current condition value
     */
    public boolean modify(boolean b){
        this.condition = !this.condition;
        return this.condition;
    }
}
