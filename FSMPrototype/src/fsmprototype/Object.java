package fsmprototype;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Inherits object
 * @author Alvin Lu
 */
public abstract class Object implements Serializable
{
    private String name;
    private String description;
    private ArrayList<Verb> verbList = new ArrayList();
    private State currentState;
    private LinkedList<Attribute> attribute= new LinkedList();
    private ArrayList<String> alias = new ArrayList();
    
    /**
     * Constructor for object, creates an empty object
     * @param name name of object
     */
    public Object(String name){
        this.name = name;
        this.verbList = new ArrayList();
        this.attribute= new LinkedList();
        this.alias = new ArrayList();
        this.currentState = null;
    }
    
    /**
     * Constructor for Object, creates an object with starting state
     * @param name name of object
     * @param s starting state of object
     */
    public Object(String name, State s){
        this.name = name;
        verbList = new ArrayList();
        attribute= new LinkedList();
        alias = new ArrayList();
        this.currentState = s;
    }
    
    /**
     * Constructor for object, creates and object with description
     * @param name name of object
     * @param desc description of object
     */
    public Object(String name, String desc){
        this.name = name;
        this.description = desc;
    }

    /**
     * Returns the name of the object
     * @return name of object in String
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Set the name of the object
     * @param s name of object
     */
    public void setName(String s){
        this.name = s;
    }
    
    /**
     * Get the description of the object
     * @return description of object in String
     */
    public String getDesc(){
        return this.description;
    }
    
    /**
     * Sets the description of the object
     * @param d description of the object
     */
    public void setDesc(String d){
        this.description = d;
    }
    
    /**
     * Get the list of verbs for the object
     * @return list of verbs in ArrayList
     */
    public ArrayList<Verb> getVerbs(){
        return this.verbList;
    }
    
    /**
     * Add verb to the Object
     * @param v verb to be added
     */
    public void addVerb(Verb v){
        this.verbList.add(v);
    }
    
    /**
     * Set the current state to a given state
     * @param s state to be set
     */
    public void setState(State s){
        this.currentState = s;
    }
    
    /**
     * get the current state
     * @return current state as State object
     */
    public State getCurrentState(){
        return this.currentState;
    }
    
    /**
     * get the list of Attribute
     * @return a list of attribute in LinkedList
     */
    public LinkedList<Attribute> getAttributes(){
        return this.attribute;
    }
    
    /**
     * Add an attribute to the object
     * @param a attribute to be added
     */
    public void addAttribute(Attribute a){
        this.attribute.add(a);
    }
    
    /**
     * delete an attribute by its name
     * @param s name of attribute
     * @return attribute that has been deleted
     */
    public Attribute deleteAtrributebyName(String s){
        for(Attribute a: this.attribute){
            if(a.getName().equals(s)){
                this.attribute.remove(a);
                return a;
            }
        }
        return null;
    }
    
    /**
     * send the verb to be processed
     * @param verb action for transition
     * @return true if transition successful
     */
    public boolean sendAction(String verb){
        State s = currentState.changeState(verb);
        if(s != null){
            currentState = s;
            return true;
        }
        return false;
    }
    
    /**
     * Set an attribute's value using the name
     * @param n name of attribute
     * @param value value to be set
     */
    public void setAttribute(String n, double value){
        for(Attribute att:attribute){
            if(att.getName().equals(n)){
                if(att instanceof Number_Attribute){
                    Number_Attribute num_att = (Number_Attribute)att;
                    num_att.setValue(value);
                }
            }
        }
    }
    
    /**
     * Set an attribute's value using the name
     * @param n name of attribute
     * @param b value of attribute
     */
    public void setAttribute(String n, boolean b){
        for(Attribute att:attribute){
            if(att.getName().equals(n)){
                if(att instanceof Boolean_Attribute){
                    Boolean_Attribute bol_att = (Boolean_Attribute)att;
                    bol_att.explicitChange(b);
                }
            }
        }
    }
    
    /**
     * Find a transition by its name and end-state name
     * @param a name of verb
     * @param end name of end state
     * @return Transition that fits the verb and end state
     */
    public Transition findTransition(String a, String end){
        Transition trans;
        for(Transition t: this.currentState.getTransition()){
            if(t.getAction().equals(a) && end.equals(t.getEndState().getName())){
                return t;
            }
            else{
                State e = t.getEndState();
                trans = findTransition(a, e.getName());
                if(trans != null){
                    return trans;
                }
            }
        }
        return null;
    }
    
    /**
     * Find a state by its name
     * @param n name of the state
     * @return state that fits the name in State object
     */
    public State findState(String n){
        if(currentState.getName().equalsIgnoreCase(n)){
            return this.currentState;
        }
        State st;
        for(Transition t: this.currentState.getTransition()){
            if(n.equals(t.getEndState().getName())){
                return t.getEndState();
            }
            else{
                State e = t.getEndState();
                st = findState(e, n);
                if(st != null){
                    return st;
                }
            }
        }
        return null;
    }
    
    /**
     * Recursively finds the state
     * @param s current state
     * @param n name of the state
     * @return State with matching name
     */
    private State findState(State s, String n){
        if(s.getName().equals(n)){
            return s;
        }
        State st;
        for(Transition t: s.getTransition()){
            if(n.equals(t.getEndState().getName())){
                return t.getEndState();
            }
            else{
                State e = t.getEndState();
                st = findState(e, n);
                if(st != null){
                    return st;
                }
            }
        }
        return null;
    }
    
    /**
     * Returns a set of all states
     * @return a set of states in Sets
     */
    public Set<State> getAllStates(){
        Set<State> s = new HashSet<>();
        if(this.currentState != null){
            s.add(this.currentState);
            for(Transition t: this.currentState.getTransition()){
                s.addAll(getAllStates(t.getEndState()));
            }
        }
        return s;
    }
    
    /**
     * Recursively adds states into the set
     * @param s current state
     * @return a set of states
     */
    private Set<State> getAllStates(State s){
        Set<State> states = new HashSet<State>();
        states.add(s);
        for(Transition t: s.getTransition()){
            states.addAll(getAllStates(t.getEndState()));
        }
        return states;
    }
    
    /**
     * Returns all transitions in the object
     * @return list of transitions in ArrayList
     */
    public ArrayList<Transition> getAllTransitions(){
        ArrayList<Transition> transitions = new ArrayList<>();
        if(this.currentState != null){
            for(Transition t: this.currentState.getTransition()){
                transitions.add(t);
                transitions.addAll(getAllTransitions(t.getEndState()));
            }
        }
        return transitions;
    }
    
    /**
     * Recursively adds in the state to the list
     * @param s current state
     * @return list of Transitions in ArrayList
     */
    private ArrayList<Transition> getAllTransitions(State s){
        ArrayList<Transition> transitions = new ArrayList<>();
        if(s != null){
            for(Transition t: s.getTransition()){
                transitions.add(t);
                transitions.addAll(getAllTransitions(t.getEndState()));
            }
        }
        return transitions;
    }
    
    /**
     * delete a transition by its verb and end state
     * @param a name of the verb
     * @param end name of the end state
     * @return true if transition is deleted
     */
    public boolean deleteTransition(String a, String end){
        Transition trans;
        if(this.currentState.deleteTransition(a, end)){
            return true;
        }
        else{
            for(int i = 0; i < this.currentState.getTransition().size(); i++){
                State e = this.currentState.getTransition().get(i)
                        .getEndState();
                return deleteTransition(e, a ,end);
            }
        }
        
        return false;
    }
    
    /**
     * Recursively finds the transition that fits the verb and end state
     * @param s current state
     * @param a name of verb
     * @param end name of end state
     * @return true if transition is deleted
     */
    private boolean deleteTransition(State s, String a, String end){
        Transition trans;
        if(s.deleteTransition(a, end)){
            return true;
        }
        else{
            for(int i = 0; i < this.currentState.getTransition().size(); i++){
                State e = this.currentState.getTransition().get(i)
                        .getEndState();
                return deleteTransition(s, a, end);
            }
        }
        
        return false;
    }
    
    /**
     * Find the attribute given the name
     * @return Attribute with the matching name
     */
    public Attribute findAttribute(String name){
        for(Attribute a: this.attribute){
            if(name.equalsIgnoreCase(a.getName())){
                return a;
            }
        }
        return null;
    }
    
    /**
     * Returns the objects info
     * @return 
     */
    @Override
    public String toString(){
        return this.name;
    }
}
