/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmprototype;

/**
 *
 * @author Alvin Lu
 */
public class Number_Attribute 
{
    private double value = 0;
    
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
