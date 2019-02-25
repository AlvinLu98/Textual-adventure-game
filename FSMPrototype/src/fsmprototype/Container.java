/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmprototype;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Alvin Lu
 */
public class Container extends Object implements Serializable{
    ArrayList<Object> objects;
    
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
}
