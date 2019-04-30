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
    
    @Override
    protected java.lang.Object clone() throws CloneNotSupportedException
    {
        Number_Attribute n = (Number_Attribute) super.clone();
        return n;
    } 
    
    public void setValue(double v)
    {
        this.value  = v;
    }
    
    public void increment()
    {
        this.value++;
    }
    
    public void decrement()
    {
        this.value--;
    }
}
