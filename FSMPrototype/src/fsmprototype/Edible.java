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
public class Edible extends Limited_Use_Object{ 
    public Edible(){
       super.uses_Left = 1; 
    }
    
    public boolean eat(){
        return super.use();
    }
}
