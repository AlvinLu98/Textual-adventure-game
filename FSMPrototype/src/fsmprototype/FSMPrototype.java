/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmprototype;

import java.io.Serializable;
import java.util.Scanner;

public class FSMPrototype implements Serializable{

    static Game g = new Game();
    
    public static Room roomPrompt(){
        Scanner scan = new Scanner(System.in);
        Room r = new Room("start");
        System.out.println("What is the name of the room?");
        String name = scan.nextLine();
        r = new Room(name);
        System.out.println("Any objects in " + r.getName() + " ? y/n");
        String obj = scan.nextLine();

        while(obj.equals("y")){
            r.addObject(objectPrompt(r));
            System.out.println("Any more objects in " + r.getName() + " ? y/n");
            obj = scan.next();
        }
        g.addRoom(r);
        System.out.println("Any exit in " + r.getName() + " ? y/n");
        String ex = scan.next();
        while(ex.equals("y")){
            System.out.println("Exit room");
            Room exit = roomPrompt();
            exit.addExit(r.getName(), r);
            r.addExit(exit.getName(), exit);
            System.out.println("Any more exit in " + r.getName() + " ? y/n");
            ex = scan.next();
        }
        return r;
    }
    
    public static Object objectPrompt(Room r){
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the name of the object?");
        String name = scan.next();
        System.out.println("What is the type of the object?");
        String type = scan.next();
        Object o;
        String obj;
        switch(type){
            case "player":
                o = playerPrompt(name, r);
                break;
            case "container":
                Container c = new Container(name);
                System.out.println("Any objects in " + c.getName() + " ? y/n");
                obj = scan.next();
                while(obj.equals("y")){
                    c.addObjects(objectPrompt(r));
                    System.out.println("Any more objects in " + c.getName() + " ? y/n");
                    obj = scan.next();
                }
                o = c;
                break;
            default:
                o = new Pick_Able_Object(name);
                break;
        }  
        return o;
    }
    
    public static Player playerPrompt(String name, Room r){
        Scanner scan = new Scanner(System.in);
        String obj;
        Player p= new Player(name);
        p.setLocation(r);
            System.out.println("Any objects on player? y/n");
            obj = scan.next();
            while(obj.equals("y")){
                p.pickup(objectPrompt(r));
                System.out.println("Any more objects on player? y/n");
                obj = scan.next();
            }
            g.addPlayer(p);
        return p;
    }
    
    public static void main(String[] args) 
    {
        roomPrompt();
        
        Game_Saver.save_Created_Game(g);
        g = Game_Saver.load_Created_Game();
        
        
        Game_Player gp = new Game_Player(g);
        System.out.println("------------------------------------");
        
        gp.playGame();
    }
    
}
