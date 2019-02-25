package fsmprototype;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author Alvin Lu
 */
public class State implements Serializable 
{
    private String name;
    private LinkedList<Transition> transitions;
    private Event entryEvent;
    private Event exitEvent;
    private LinkedList<State> innerStates;
    
    public State(String n, LinkedList<Transition> t)
    {
        this.name = n;
        this.transitions = t;
    }
    
    public State(String n, LinkedList<Transition> t, Event ent, Event ex)
    {
        this.name = n;
        this.transitions = t;
        this.entryEvent = ent;
        this.exitEvent = ex;
    }
    
    public State changeState(String action)
    {
        for(int i = 0; i < transitions.size(); i++)
        {
            if(transitions.get(i).getAction().equals(action))
            {
                return transitions.get(i).executeTrans();
            }
        }
        return null;
    }
    
    public boolean addTransition(String act, State end)
    {
        Transition t = new Transition(act, end);
        return transitions.add(t);
    }
    
    public boolean addTransition(String act, State end, Set<Condition> c)
    {
        Transition t = new Transition(act, end, c);
        return transitions.add(t);
    }
    
    public boolean addInnerState(State s)
    {
        return innerStates.add(s);
    }
    
    public String getInnerState()
    {
        //not implemented yet
        return "Not implemented yet";
    }
}