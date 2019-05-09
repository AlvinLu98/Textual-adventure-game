package fsmprototype;

import java.io.Serializable;
import java.util.Iterator;
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
    private LinkedList<State> innerStates;
    
    
    public State(){}
    
    public State(String name){
        this.name = name;
        this.transitions = new LinkedList();
    }
    
    public State(String n, LinkedList<Transition> t)
    {
        this.name = n;
        this.transitions = t;
    }
    
    public String getName(){
        return this.name;
    }
    
    public LinkedList<Transition> getTransition(){
        return this.transitions;
    }
    
    public void setName(String name){
        this.name = name;
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
    
    public Transition findTransition(String act, String end){
        for(Transition t: this.transitions){
            if(t.getAction().equals(act) && 
                    t.getEndState().getName().equals(end)){
                return t;
            }
        }
        return null;
    }
    
    public boolean deleteTransition(String act, String end){
        for(Transition t: this.transitions){
            if(t.getAction().equals(act) && 
                    t.getEndState().getName().equals(end)){
                return this.transitions.remove(t);
            }
        }
        return false;
    }
}