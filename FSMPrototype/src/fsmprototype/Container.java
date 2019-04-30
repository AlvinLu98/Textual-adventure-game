/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmprototype;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Alvin Lu
 */
public class Container extends Object implements Serializable{
    private ArrayList<Object> objects;
    
    public Container(String name){
        super(name);
        objects = new ArrayList();
    } 
    
    public ArrayList<Object> getObjects(){
        return objects;
    }
    
    public void addObjects(Object o){
        objects.add(o);
    }
    
    public Object dropObject(Object o){
        if(objects.remove(o)){
            return o;
        }
        return null;
    }
    
    public Object findObject(Object o){
        for(Object obj: this.objects){
            if(obj.getName().equals(o.getName())){
                return obj;
            }
            
            else if(obj instanceof Container){
                findObject(o);
            }
        }
        return null;
    }
    
    public Object findObjectByName(String o){
        for(Object obj: this.objects){
            if(obj.getName().equals(o)){
                return obj;
            }
            
            else if(obj instanceof Container){
                findObjectByName(o);
            }
        }
        return null;
    }
    
    public boolean removeObject(Object o){
        for(Object obj: this.objects){
            if(obj.getName().equals(o.getName())){
                return this.objects.remove(obj);
            }
            
            else if(obj instanceof Container){
                findObject(o);
            }
        }
        return false;
    }
}
