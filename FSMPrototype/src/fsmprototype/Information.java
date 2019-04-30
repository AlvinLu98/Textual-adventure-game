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
public class Information implements Serializable {
    private String prompt;
    private String answer;
    
    @Override
    protected java.lang.Object clone() throws CloneNotSupportedException
    {
        Information i = (Information) super.clone();
        return i;
    } 
    
    public String getPrompt(){
        return this.prompt;
    }
    
    public String getAnswer(){
        return this.answer;
    }
}
