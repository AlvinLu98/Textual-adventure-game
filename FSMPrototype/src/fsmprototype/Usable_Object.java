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
public abstract class Usable_Object extends Object{
    private boolean is_Usable = true;
    
    public Usable_Object(String name){
        super(name);
    }
    
    public void make_Unusable(){
        this.is_Usable = false;
    }
    
    public abstract boolean use();
}
