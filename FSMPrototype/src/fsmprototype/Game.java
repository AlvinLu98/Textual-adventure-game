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
public class Game implements Serializable{
    private ArrayList<Room> rooms;
    private Player player;
    
    public Game(ArrayList<Room> r, Player p){
        this.rooms = r;
        this.player = p;
    }
}
