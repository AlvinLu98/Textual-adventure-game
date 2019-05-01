/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmprototype;

import java.io.Serializable;

/**
 *
 * @author Alvin Lu
 */
public class Number_Attribute extends Attribute implements Serializable
{
    private double value = 0;
    private double amtChange = 1;
    private boolean incDec = true;
    
    
    public Number_Attribute(String s, String v, double def, double val, boolean incDec, Object o, Object own){
        super(s,v,o, own);
        this.value = def;
        this.amtChange = val;
        this.incDec = incDec;
    }
    
    public double getValue(){
        return this.value;
    }
    
    public double getAmount(){
        return this.amtChange;
    }
    
    public boolean isIncrement(){
        return this.incDec;
    }
    
    public void setValue(double v)
    {
        this.value  = v;
    }
    
    @Override
    public boolean modify()
    {
        if(this.incDec){
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
