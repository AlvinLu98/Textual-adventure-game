package fsmprototype;

import java.io.Serializable;

/**
 *
 * @author Alvin Lu
 */
public class Condition implements Serializable {
    private String name;
    private boolean condition;
    
    public Condition(String name)
    {
        this.name = name;
    }
    
    public boolean changeCondition()
    {
        this.condition = !this.condition;
        return this.condition;
    }
}
