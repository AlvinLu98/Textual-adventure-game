/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmprototype;

import java.util.Scanner;

public class FSMPrototype {

    public static void determineAction(String action){
        action = action.toLowerCase();
        switch(action){
            case "room":
                System.out.println("----- Creating room -----");
                //do something
                break;
            case "item":
                System.out.println("----- Creating item -----");
                //do something
                break;
            case "player":
                System.out.println("----- Creating player -----");
                //do something
                break;
            default:
                System.out.println("----- Apaansih -----");
                break;
        }
    }
    
    public static Object createRoom(){
        Object room = new Room("test");
        return room;
    }
    
    public static void main(String[] args) 
    {
        Scanner item = new Scanner(System.in);
        System.out.println("What do you want to create?");
        String object = item.next();
        
        determineAction(object);
    }
    
}
