package fsmprototype;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author Alvin Lu
 */
public class State implements Serializable, Cloneable 
{
    private String name;
    private LinkedList<Transition> transitions;
    private LinkedList<State> innerStates;
    
    
    public State(){}
    
    public State(String name){
        this.name = name;
    }
    
    public State(String n, LinkedList<Transition> t)
    {
        this.name = n;
        this.transitions = t;
    }
    
    @Override
    protected java.lang.Object clone() throws CloneNotSupportedException
    {
        State s = (State) super.clone();
        if(transitions != null){
           Iterator<Transition> i1 = transitions.iterator();
            while(i1.hasNext()){
                s.transitions.add((Transition) i1.next().clone());
            } 
        }
        
        if(innerStates != null){
           Iterator<State> i2 = innerStates.iterator();
            while(i2.hasNext()){
                s.innerStates.add((State) i2.next().clone());
            } 
        }
        
        return s;
    } 
    
    public String getName(){
        return this.name;
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
}