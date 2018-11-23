/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statemachinetest;

/**
 *
 * @author Alvin Lu
 */
public abstract class Objects 
{
    private String name;
    private int weight;
    private String description;
    
    public String lookat()
    {
        return description;
    }
    
    abstract void interact();
}
