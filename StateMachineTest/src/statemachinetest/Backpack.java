/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statemachinetest;

import java.util.ArrayList;

/**
 *
 * @author Alvin Lu
 */
public class Backpack 
{
    private ArrayList<Objects> items;
    private int max_weight;
    
    public Backpack(int max)
    {
        items = new ArrayList<>();
        max_weight = max;
    }
}
