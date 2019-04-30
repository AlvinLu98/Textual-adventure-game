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
public class Edible extends Limited_Use_Object implements Serializable, Cloneable{ 
    public Edible(String name){
        super(name);
        super.uses_Left = 1; 
    }
    
    @Override
    protected java.lang.Object clone() throws CloneNotSupportedException
    {
        Edible e = (Edible) super.clone();
        return e;
    } 
    
    public boolean eat(){
        return super.use();
    }
}
