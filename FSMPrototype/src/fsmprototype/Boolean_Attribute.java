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
public class Boolean_Attribute extends Attribute 
{
    private boolean condition;
    
    public Boolean_Attribute(){}
    
    public boolean changeCondition()
    {
        this.condition = !this.condition;
        return this.condition;
    }
}
