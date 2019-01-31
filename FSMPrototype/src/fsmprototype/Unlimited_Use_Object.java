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
public class Unlimited_Use_Object extends Usable_Object{
    private int use_Count = 0;
    
    public Unlimited_Use_Object(String name){
        super(name);
    }
    
    @Override
    public boolean use(){
        use_Count++;
        return true;
    }
}
