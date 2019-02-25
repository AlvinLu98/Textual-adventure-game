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
public class Pick_Able_Object extends Object implements Serializable{
    private boolean is_Picked_Up = false;
    private Living_Objects owner;
    
    public Pick_Able_Object(String name){
        super(name);
    }
    
    public Pick_Able_Object(String name, Living_Objects owner){
        super(name);
        this.owner = owner;
        this.is_Picked_Up =true;
    }
    
    public boolean pickUp(){
        if(this.is_Picked_Up){
            return false;
        }
        this.is_Picked_Up = true;
        return true;
    }
    
    public boolean drop(){
        if(!this.is_Picked_Up){
            return false;
        }
        this.is_Picked_Up = false;
        return true;
    }
    
    public void changeOwner(Living_Objects owner){
        this.owner = owner;
    }
}
