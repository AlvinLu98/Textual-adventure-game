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
    private ArrayList<String> verbList;
    private State currentState;
    private LinkedList<Attribute> attribute;
    private ArrayList<String> alias;
    
    public abstract boolean sendAction();
    
    public abstract void setAttribute(String n, double value);
    
    public abstract void setAttribute(String n, boolean b);
}
