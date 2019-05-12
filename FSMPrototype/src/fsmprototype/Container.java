package fsmprototype;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Alvin Lu
 */
public class Container extends Object implements Serializable{
    private ArrayList<Object> objects;
    
    /**
     * Constructor for container, creates an empty container
     * @param name name of container
     */
    public Container(String name){
        super(name);
        objects = new ArrayList();
    } 
    
    /**
     * Get all objects in the container
     * @return all objects in the container as ArrayLust
     */
    public ArrayList<Object> getObjects(){
        return objects;
    }
    
    /**
     * Add an object into the container
     * @param o object to be added
     */
    public void addObjects(Object o){
        objects.add(o);
    }
    
    /**
     * Remove an object from the container
     * @param o object to remove
     * @return the object that is removed
     */
    public Object dropObject(Object o){
        if(objects.remove(o)){
            return o;
        }
        return null;
    }
    
    /**
     * Find an object in the container
     * @param o object to find
     * @return if the object is found
     */
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
    
    /**
     * Find an object by its name
     * @param o name of the object
     * @return the object if found
     */
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
    
    /**
     * Remove an object from the container
     * @param o object to be removed
     * @return true if object is removed
     */
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
