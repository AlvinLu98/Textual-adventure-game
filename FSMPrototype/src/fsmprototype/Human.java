package fsmprototype;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Alvin Lu
 */
public class Human extends Living_Objects implements Serializable{
    ArrayList<Information> informations;
    Container inventory;
    
    /**
     * Constructor for human
     * @param name name of human
     */
    public Human(String name){
        super(name);
    }
   
    /**
     * Given a prompt, return the relevant information
     * @param prompt
     * @return 
     */
    public String ask(String prompt){
        for(Information i: informations){
            if(i.getPrompt().equals(prompt)){
                return i.getAnswer();
            }
        }
        return "No answer";
    }
}
