package fsmprototype;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 *
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
    
    public Object(String name){
        this.name = name;
        this.verbList = new ArrayList();
        this.attribute= new LinkedList();
        this.alias = new ArrayList();
        this.currentState = new State("Initial state");
    }
    
    public Object(String name, State s){
        this.name = name;
        verbList = new ArrayList();
        attribute= new LinkedList();
        alias = new ArrayList();
        this.currentState = s;
    }
    
    public Object(String name, String desc){
        this.name = name;
        this.description = desc;
    }

    public String getName(){
        return this.name;
    }
    
    public void setName(String s){
        this.name = s;
    }
    
    public String getDesc(){
        return this.description;
    }
    
    public void setDesc(String d){
        this.description = d;
    }
    
    public ArrayList<Verb> getVerbs(){
        return this.verbList;
    }
    
    public void addVerb(Verb v){
        this.verbList.add(v);
    }
    
    public void setState(State s){
        this.currentState = s;
    }
    
    public State getCurrentState(){
        return this.currentState;
    }
    
    public LinkedList<Attribute> getAttributes(){
        return this.attribute;
    }
    
    public void addAttribute(Attribute a){
        this.attribute.add(a);
    }
    
    public Attribute deleteAtrributebyName(String s){
        for(Attribute a: this.attribute){
            if(a.getName().equals(s)){
                this.attribute.remove(a);
                return a;
            }
        }
        return null;
    }
    
    public boolean sendAction(String verb){
        for(Verb v:verbList){
            
        }
        State s = currentState.changeState(verb);
        if(s != null){
            currentState = s;
            return true;
        }
        return false;
    }
    
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
    
    public State findState(String n){
        if(currentState.getName().equals(n)){
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
    
    public Set<State> getAllStates(){
        Set<State> s = new HashSet<>();
        s.add(this.currentState);
        for(Transition t: this.currentState.getTransition()){
            s.addAll(getAllStates(t.getEndState()));
        }
        return s;
    }
    
    private Set<State> getAllStates(State s){
        Set<State> states = new HashSet<State>();
        states.add(s);
        for(Transition t: s.getTransition()){
            states.addAll(getAllStates(t.getEndState()));
        }
        return states;
    }
    
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
 
    public Object destroy(){
        return this;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
