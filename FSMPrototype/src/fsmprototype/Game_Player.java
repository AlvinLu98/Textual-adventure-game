/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fsmprototype;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Alvin Lu
 */
public class Game_Player implements Serializable{
    private Game currentGame;
    
    public Game_Player(Game g){
        this.currentGame = g;
    }
    
    public void playGame(){
        boolean play = true;
        while(play)
        {
            Room current = currentGame.getPlayer().getLocation();
            System.out.println("You're in " + currentGame.getPlayer().getLocation().getName());
            System.out.print("There's...");
            displayItem();
            System.out.print("You can go: ");
            for(Exit e: current.getExit()){
                System.out.print(e.getName() + ", ");
            }
            System.out.println("");
            Scanner scan = new Scanner(System.in);
            System.out.println("What do you want to do?");
            String input = scan.nextLine();
            input = input.toLowerCase();
            String[] inp = input.split(" ", 2);
            System.out.println(inp[1]);
            switch(inp[0])
            {
                case "take":
                    Object take = currentGame.getPlayer().getLocation().pickedUp(inp[1]);
                    if(take == null){
                        System.out.println("No such item");
                        break;
                    }
                    else{
                        currentGame.givePlayer(take);
                        System.out.println("You've picked up " + inp[1]);
                        System.out.println("***Inventory***");
                        for(Object o: currentGame.getPlayerObject()){
                            System.out.print(o.getName() + ", ");
                        }
                        System.out.println("");
                    }
                    break;

                case "drop":
                    Room r = currentGame.getRooms().get(currentGame.getRooms().indexOf(currentGame.getPlayer().getLocation()));
                    Object drop = currentGame.getPlayer().drop(inp[1]);
                    if(drop == null){
                        System.out.println("No such item");
                        break;
                    }
                    else{
                        r.addObject(drop);
                        System.out.println(inp[1] + " dropped");
                        System.out.println("***Inventory***");
                        for(Object o: currentGame.getPlayer().getItems()){
                            System.out.print(o.getName() + ", ");
                        }
                        System.out.println("");
                    }
                    break;

                case "go":
                    if(currentGame.getPlayer().move(inp[1]) == null){
                        System.out.println("No such room");
                        break;
                    }
                    System.out.println("You're currently in: " +currentGame.getPlayer().getLocation().getName());
                    break;
                    
                default:
                    play = false;
            }
            System.out.println("------------------------------------------");
        }
    }
    
    
    
    public ArrayList<Object> displayItem(){
        ArrayList<Object> items = currentGame.getRoomObjects();
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
        
        
        Pick_Able_Object o1 = new Pick_Able_Object("rock");
        Edible o2 = new Edible("bread");
        Unlimited_Use_Object o3 = new Unlimited_Use_Object("mirror");
        
        Pick_Able_Object o4 = new Pick_Able_Object("phone");
        Pick_Able_Object o5 = new Pick_Able_Object("wallet");
        
        Room r1 = new Room("living room");
        Room r2 = new Room("garden");
        
        Player p = new Player("player", r1);
        p.pickup(o4);
        
        r1.addObject(p);
        r1.addObject(o3);
        r1.addObject(o5);
        r1.addExit("north", r2);
        
        r2.addObject(o2);
        r2.addObject(o1);
        r2.addExit("south", r1);
        
        r.add(r1);
        r.add(r2);
        Game g = new Game(r,p);
        Game_Player gp = new Game_Player(g);
        gp.playGame();
    }
}
