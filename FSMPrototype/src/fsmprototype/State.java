package fsmprototype;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Set;

/**
 * State object for a state machine
 * @author Alvin Lu
 */
public class State implements Serializable
{
    private String name;
    private LinkedList<Transition> transitions;
    private boolean allowMovement = true;
    private String entryEvent;
    private String exitEvent;
    
    /**
     * Empty constructor for state
     */
    public State(){
        this.transitions = new LinkedList();
    }
    
    /**
     * Constructor for State, creates an empty state
     * @param name name of state
     */
    public State(String name){
        this.name = name;
        this.transitions = new LinkedList();
    }
    
    /**
     * Constructor for State, creates a state with list of transitions
     * @param n name of state
     * @param t list of transition
     */
    public State(String n, LinkedList<Transition> t)
    {
        this.name = n;
        this.transitions = t;
    }
    
    /**
     * Returns the name of state
     * @return name of state in String
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Returns the list of transitions
     * @return list of transition in LinkedList
     */
    public LinkedList<Transition> getTransition(){
        return this.transitions;
    }
    
    /**
     * Sets the name of the state
     * @param name new name of the state
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Returns whether this state allows movement
     * @return true if allows movement
     */
    public boolean allowMovement(){
        return this.allowMovement;
    }
    
    /**
     * This state will not allow movement 
     */
    public void lock(){
        this.allowMovement = false;
    }
    
    /**
     * This state will allow movement
     */
    public void unlock(){
        this.allowMovement = true;
    }
    
    /**
     * Change the state given an action, returns null if transition fails
     * @param action verb to change the state
     * @return the current state
     */
    public State changeState(String action)
    {
        State s = null;
        for(int i = 0; i < transitions.size(); i++)
        {
            if(transitions.get(i).getAction().equalsIgnoreCase(action))
            {
                s = transitions.get(i).executeTrans();
            }
        }
        return s;
    }
    
    /**
     * Add a transition
     * @param act verb for transition
     * @param end end state of transition
     * @return true if transition added successfully
     */
    public boolean addTransition(String act, State end)
    {
        Transition t = new Transition(act, end);
        return transitions.add(t);
    }
    
    /**
     * Add a transition with set of conditions
     * @param act verb for transition
     * @param end end state of transition
     * @param c set of conditions
     * @return true if transition added successfully
     */
    public boolean addTransition(String act, State end, Set<Condition> c)
    {
        Transition t = new Transition(act, end, c);
        return transitions.add(t);
    }
    
    /**
     * Find a transition in the state given the verb and name of end state
     * @param act verb of the transition
     * @param end name of the end state
     * @return Transition that matches the verb and end state
     */
    public Transition findTransition(String act, String end){
        for(Transition t: this.transitions){
            if(t.getAction().equals(act) && 
                    t.getEndState().getName().equals(end)){
                return t;
            }
        }
        return null;
    }
    
    /**
     * Delete a transition given the verb and name of end state
     * @param act verb of the transition
     * @param end name of the end state
     * @return true if deleted successfully
     */
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