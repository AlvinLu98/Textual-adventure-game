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
public class Switchable extends Object{
    private boolean is_Switched_On = false;
    
    public Switchable(String name){
        super(name);
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
