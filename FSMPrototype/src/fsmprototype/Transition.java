package fsmprototype;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import fsmprototype.Condition.Type;

/**
 * Transition object for State transition
 * @author Alvin Lu
 */
public class Transition implements Serializable 
{
    private String action; //action to change state
    private State endState; //end state of transition
    private Set<Condition> conditions; //list of condition
    
    /**
     * Constructor for Transition, creates a transition with the action and 
     * end state
     * @param verb verb to initiate transition
     * @param end end state of transition
     */
    public Transition(String verb, State end)
    {
        this.action = verb;
        this.endState = end;
        this.conditions = new HashSet<>();
    }
    
    /**
     * Constructor for Transition, creates a transition with conditions
     * @param verb verb to initiate transition
     * @param end end state of transition
     * @param con a set of conditions
     */
    public Transition(String verb, State end, Set<Condition> con)
    {
        this.action = verb;
        this.endState = end;
        this.conditions = con;
    }
    
    /**
     * Return the action to initiate transition
     * @return action/verb in String
     */
    public String getAction()
    {
        return this.action;
    }
    
    /**
     * Sets the action of transition to given action
     * @param a String to be set to action
     */
    public void setAction(String a){
        this.action = a;
    }
    
    /**
     * Returns the end state of the transition
     * @return end state in State object
     */
    public State getEndState(){
        return this.endState;
    }
    
    /**
     * Sets the end state to the given state
     * @param s state to be set to end state
     */
    public void setEndState(State s){
        this.endState = s;
    }
    
    /**
     * Returns a list of conditions
     * @return 
     */
    public Set<Condition> getConditions(){
        return this.conditions;
    }
   
    /**
     * Add a condition to the list
     * @param c condition to be added
     * @return true if condition is added successfully
     */
    public boolean addCondition(Condition c)
    {
       return conditions.add(c);
    }
    
    /**
     * Checks all condition and returns true if all condition match
     * @return true if all condition matches, false otherwise
     */
    private boolean checkCondition()
    {
      for(Condition c: this.conditions){
          if(!c.checkCondition()){
              return false;
          }
      }
      return true;
    }
    
    /**
     * Execute the transition,returns the end state if all conditions are met
     * @return end state if all conditions are met
     */
    public State executeTrans()
    {
        if(checkCondition())
        {
            return this.endState;
        }
        return null;
    }
    
    /**
     * Delete a condition given a name
     * @param name name of condition to be deleted
     * @return true if successfully deleted
     */
    public boolean deleteCondition(String name){
        for(Condition c: this.conditions){
            if(c.getName().equalsIgnoreCase(name)){
                return this.conditions.remove(c);
            }
        }
        return false;
    }
    
    /**
     * Find a condition given a name
     * @param name name of the condition to find
     * @return condition matching the name
     */
    public Condition findCondition(String name){
        for(Condition c: this.conditions){
            if(c.getName().equalsIgnoreCase(name)){
                return c;
            }
        }
        return null;
    }
}
