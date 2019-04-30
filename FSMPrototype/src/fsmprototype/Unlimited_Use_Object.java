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
public class Unlimited_Use_Object extends Usable_Object implements Serializable{
    private int use_Count = 0;
    
    public Unlimited_Use_Object(String name){
        super(name);
    }
    
    @Override
    protected java.lang.Object clone() throws CloneNotSupportedException
    {
        Unlimited_Use_Object u = (Unlimited_Use_Object) super.clone();
        return u;
    } 
    
    @Override
    public boolean use(){
        use_Count++;
        return true;
    }
}
