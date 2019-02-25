/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmprototype;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Alvin Lu
 */
public class Transition implements Serializable 
{
    private String action;
    private State endState;
    private Set<Condition> conditions;
    
    public Transition(String verb, State end)
    {
        this.action = verb;
        this.endState = end;
        this.conditions = new HashSet<>();
    }
    
    public Transition(String verb, State end, Set<Condition> con)
    {
        this.action = verb;
        this.endState = end;
        this.conditions = con;
    }
    
    public String getAction()
    {
        return this.action;
    }
   
    public boolean addCondition(Condition c)
    {
       return conditions.add(c);
    }
    
    private boolean checkCondition()
    {
      return false;  
    }
    
    public State executeTrans()
    {
        if(checkCondition())
        {
            return this.endState;
        }
        return null;
    }
}
