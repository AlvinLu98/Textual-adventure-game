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
public class Pick_Able_Object extends Objects{
    boolean is_Picked_Up = false;
    Living_Objects owner;
    
    public Pick_Able_Object(){}
    
    public Pick_Able_Object(Living_Objects owner){
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
}
