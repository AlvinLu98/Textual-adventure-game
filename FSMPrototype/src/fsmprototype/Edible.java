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
public class Edible extends Limited_Use_Object implements Serializable{ 
    public Edible(String name){
        super(name);
        super.uses_Left = 1; 
    }
    
    public boolean eat(){
        return super.use();
    }
}
