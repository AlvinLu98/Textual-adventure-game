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
public class Limited_Use_Object extends Usable_Object implements Serializable{
    protected int uses_Left;
    
    public Limited_Use_Object(String name){
        super(name);
    }
    
    public Limited_Use_Object(String name, int uses){
        super(name);
        this.uses_Left = uses;
    }
    
    @Override
    protected java.lang.Object clone() throws CloneNotSupportedException
    {
       Limited_Use_Object o = (Limited_Use_Object) super.clone();
       return o;
    } 
    
    public int getUsesLeft(){
        return this.uses_Left;
    }
    
    @Override
    public boolean use(){
        if(uses_Left > 0){
            uses_Left--;
            return true;
        }
        return false;
    }
}
