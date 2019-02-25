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
public class Boolean_Attribute extends Attribute implements Serializable 
{
    private boolean condition;
    
    public Boolean_Attribute(){}
    
    public boolean changeCondition()
    {
        this.condition = !this.condition;
        return this.condition;
    }
    
    public boolean explicitChange(boolean b){
        this.condition = b;
        return this.condition;
    }
}
