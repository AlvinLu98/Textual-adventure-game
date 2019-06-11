package fsmprototype;

import java.io.Serializable;

/**
 * Child of attribute class
 * @author Alvin Lu
 */
public class Number_Attribute extends Attribute implements Serializable
{
    private double value = 0;
    private double amtChange = 1;
    private boolean incDec = true;
    
    /**
     * Constructor for number attribute
     * @param s Name of attribute
     * @param v verb associated
     * @param def current value
     * @param val value changed each modification
     * @param incDec determines whether if it's increment or decrement
     * @param o object associated with the attribute
     * @param own object that owns the attribute
     */
    public Number_Attribute(String s, String v, double def, double val, 
            boolean incDec, Object o, Object own, boolean effect){
        super(s,v,o, own, effect);
        this.value = def;
        this.amtChange = val;
        this.incDec = incDec;
    }
    
    /**
     * Get the current value of the attribute
     * @return current value of attribute in double
     */
    public double getValue(){
        return this.value;
    }
    
    /**
     * Get the amount the attribute is modified each call
     * @return the amount modified
     */
    public double getAmount(){
        return this.amtChange;
    }
    
    /**
     * Check if the attribute is increment of decrement
     * @return true if it's incrementing
     */
    public boolean isIncrement(){
        return this.incDec;
    }
    
    /**
     * Set the value to the given value
     * @param v given numeric value
     */
    public void setValue(double v)
    {
        this.value  = v;
    }
    
    /**
     * Modify the value by incrementing if true and decrement if false
     * @param b increment the attribute if it's false
     * @return true if the value has been modified
     */
    @Override
    public boolean modify(boolean b)
    {
        if(b){
            this.value += this.amtChange;
            return true;
        }
        else{
            if(this.value >= this.amtChange){
                this.value -= this.amtChange;
                return true;
            }
        }
        return false;
    }
}
