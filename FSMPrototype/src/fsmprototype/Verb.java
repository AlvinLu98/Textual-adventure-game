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
public class Verb implements Serializable, Cloneable 
{
    String name;
    ArrayList<String> alias;
    
    @Override
    protected java.lang.Object clone() throws CloneNotSupportedException
    {
        Verb v = (Verb) super.clone();
        return v;
    } 
}
