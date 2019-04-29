package fsmprototype;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Alvin Lu
 */
public abstract class Object implements Serializable
{
    protected String name;
    protected String description;
    private ArrayList<Verb> verbList;
    private State currentState;
    private LinkedList<Attribute> attribute;
    private ArrayList<String> alias;
    
    public Object(String name){
        this.name = name;
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
    
    public State getCurrentState(){
        return this.currentState;
    }
    
    public LinkedList<Attribute> getAttributes(){
        return this.attribute;
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
 
    public Object destroy(){
        Object j = new Room("test");
        return j;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
