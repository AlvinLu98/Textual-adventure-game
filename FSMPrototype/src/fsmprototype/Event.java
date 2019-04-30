/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmprototype;

import java.io.Serializable;

/**
 *
 * @author Alvin Lu
 */
public class Event implements Serializable, Cloneable
{
    private String name;
    private String message;
    
    public Event(){
        
    }
    
    @Override
    protected java.lang.Object clone() throws CloneNotSupportedException
    {
        Event e = (Event)super.clone();
        return e;
    } 
    
    public Event(String n, String m)
    {
        this.name  = n;
        this.message = m;
    }
}
