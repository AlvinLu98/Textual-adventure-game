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
public class Limited_Use_Object extends Usable_Object{
    protected int uses_Left;
    
    public Limited_Use_Object(){}
    
    public Limited_Use_Object(int uses){
        this.uses_Left = uses;
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
