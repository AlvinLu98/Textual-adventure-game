/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmprototype;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Alvin Lu
 */
public class Game_Player {
    private Game currentGame;
    private ArrayList<Room> rooms;
    private Player player;
    
    public Game_Player(ArrayList<Room> r, Player p){
        this.rooms = r;
        this.player = p;
    }
    
    public Game_Player(Game g){
        this.currentGame = g;
    }
    
    public void playGame(){
        boolean play = true;
        while(play)
        {
            System.out.println("You're in " + player.getLocation().getName());
            System.out.print("There's...");
            displayItem();
            Scanner scan = new Scanner(System.in);
            System.out.println("What do you want to do?");
            String input = scan.nextLine();
            input = input.toLowerCase();
            switch(input)
            {
                case "take wallet":
                    player.pickup(player.getLocation().pickedUp("Wallet"));
                    System.out.println("You've picked up wallet");
                    System.out.println("***Inventory***");
                    for(Object o: player.getItems()){
                        System.out.print(o.getName() + ", ");
                    }
                    System.out.println("");
                    break;

                case "take phone":
                    player.pickup(player.getLocation().pickedUp("Phone"));
                    System.out.println("You've picked up phone");
                    System.out.println("***Inventory***");
                    for(Object o: player.getItems()){
                        System.out.print(o.getName() + ", ");
                    }
                    System.out.println("");
                    break;

                case "drop phone":
                    Room r = rooms.get(rooms.indexOf(player.getLocation()));
                    r.addObject(player.drop("Phone"));
                    System.out.println("Phone dropped");
                    System.out.println("***Inventory***");
                    for(Object o: player.getItems()){
                        System.out.print(o.getName() + ", ");
                    }
                    System.out.println("");
                    break;
                    
                case "drop wallet":
                    Room r1 = rooms.get(rooms.indexOf(player.getLocation()));
                    r1.addObject(player.drop("Wallet"));
                    System.out.println("Wallet dropped");
                    System.out.println("***Inventory***");
                    for(Object o: player.getItems()){
                        System.out.print(o.getName() + ", ");
                    }
                    System.out.println("");
                    break;

                case "go living room":
                    player.move("South");
                    System.out.println("You're currently in: " + player.getLocation().getName());
                    break;

                case "go garden":
                    player.move("North");
                    System.out.println("You're currently in: " + player.getLocation().getName());
                    break;

                default:
                    play = false;
            }
            System.out.println("------------------------------------------");
        }
    }
    
    public ArrayList<Object> displayItem(){
        ArrayList<Object> items = player.getLocation().getObject();
        for(Object p:items){
            System.out.print(p.name + ", ");
        }
        System.out.println("");
        return items;
    }
    
    public static void main(String[] args) {
        ArrayList<Object> o = new ArrayList();
        LinkedList<Exit> e = new LinkedList();
        ArrayList<Room> r = new ArrayList();
        
        
        Pick_Able_Object o1 = new Pick_Able_Object("Rock");
        Edible o2 = new Edible("Bread");
        Unlimited_Use_Object o3 = new Unlimited_Use_Object("Mirror");
        
        Pick_Able_Object o4 = new Pick_Able_Object("Phone");
        Pick_Able_Object o5 = new Pick_Able_Object("Wallet");
        
        Room r1 = new Room("Living Room");
        Room r2 = new Room("Garden");
        
        Player p = new Player("Player", r1);
        p.pickup(o4);
        
        r1.addObject(p);
        r1.addObject(o3);
        r1.addObject(o5);
        r1.addExit("North", r2);
        
        r2.addObject(o2);
        r2.addObject(o1);
        r2.addExit("South", r1);
        
        r.add(r1);
        r.add(r2);
        
        Game_Player gp = new Game_Player(r, p);
        gp.playGame();
    }
}
