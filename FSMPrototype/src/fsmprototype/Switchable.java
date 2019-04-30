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
public class Switchable extends Object implements Serializable{
    private boolean is_Switched_On = false;
    
    public Switchable(String name){
        super(name);
    }
    
    @Override
    protected java.lang.Object clone() throws CloneNotSupportedException
    {
        Switchable s = (Switchable) super.clone();
        return s;
    } 
    
    public boolean switchOn(){
        if(this.is_Switched_On){
            return false;
        }
        this.is_Switched_On = true;
        return true;
    }
    
    public boolean switchOff(){
        if(!this.is_Switched_On){
            return false;
        }
        this.is_Switched_On = false;
        return true;
    }
}
