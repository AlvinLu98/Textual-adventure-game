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
public class Wearable extends Object{
    private boolean is_Worn = false;
    private Living_Objects owner;
    
    public Wearable(String name){
        super(name);
    }
    
    public Wearable(String name, Living_Objects owner){
        super(name);
        this.owner = owner;
        this.is_Worn = true;
    }
    
    public boolean wear(){
        if(this.is_Worn){
            return false;
        }
        this.is_Worn = true;
        return true;
    }
    
    public boolean takeOff(){
        if(!this.is_Worn){
            return false;
        }
        this.is_Worn = false;
        return true;
    }
    
    public void changeOwner(Living_Objects owner){
        this.owner = owner;
    }
}
