/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statemachinetest;

import java.util.Set;

/**
 *
 * @author Alvin Lu
 */
public class Transition 
{
    State from;
    String action;
    Set<Condition> conditions;
    State to;
    
    Transition(String f, Set<Condition> c, String action, String t)
    {
        this.from = new State(f);
        this.action = action;
        this.conditions = c;
        this.to = new State(t);
    }
    
    @Override
    public String toString()
    {
        String s = "";
        s += from.getName() + " ---> " + to.getName() + "\n";
        s += "By: " + action + "\n";
        s += "If:\n";
        for(Condition i:conditions)
        {
            s += "   -" + i.getCondition() + "\n";
        }
        return s;
    }
}
