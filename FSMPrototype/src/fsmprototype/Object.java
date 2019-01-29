package fsmprototype;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Alvin Lu
 */
public abstract class Object 
{
    private String name;
    private ArrayList<Verb> verbList;
    private State currentState;
    private LinkedList<Attribute> attribute;
    private ArrayList<String> alias;
    
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
}
