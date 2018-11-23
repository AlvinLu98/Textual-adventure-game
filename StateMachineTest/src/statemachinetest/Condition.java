/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statemachinetest;

/**
 *
 * @author Alvin Lu
 */
public class Condition 
{
    private String condition;
    private boolean state;
   
    Condition(String c)
    {
        condition = c;
        state = true;
    }
    
    String getCondition()
    {
        return condition;
    }
    
    boolean changeState()
    {
        state = !state;
        return state;
    }
}
