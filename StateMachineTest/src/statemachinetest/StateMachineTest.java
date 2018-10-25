
package statemachinetest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Quick and dirty implementation of Finite state machine
 * Version 1.0
 * @author Alvin Lu
 */
public class StateMachineTest {

    public static FSM createObject()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("What's the name of the object?");
        String name = scan.nextLine();
        
        System.out.println("What's the starting state?");
        String startingState = scan.nextLine();
        
        FSM newObject = new FSM(name, new State(startingState));
        String keepGoing = " ";
        while(!keepGoing.equals("n"))
        {
            newObject.addTransistion(createTransition());
            System.out.println("Current transitions");
            newObject.listAllTransitions();
            System.out.println("");
            System.out.println("Any more transistions?");
            keepGoing = scan.nextLine();
        }
        return newObject;
    }
    
    public static Transition createTransition()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("New transition");
            System.out.println("What state is it transitioning from?");
            String fromState = scan.nextLine();
            System.out.println("What state is it transitioning to?");
            String toState = scan.nextLine();
            String conditions = " ";
            Set<Condition> conditionList = new HashSet<>();
            System.out.println("What is the action for this transition?");
            String action = scan.nextLine();
            while(!conditions.equals("n"))
            {
                System.out.println("What is the condition?");
                String condition = scan.nextLine();
                conditionList.add(new Condition(condition));
                System.out.println("Any more conditions?");
                conditions = scan.nextLine();
            }
            Transition t = new Transition(fromState, conditionList, action, toState);
            return t;
    }
    
    public static Room createRoom()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("What's the name of the room?");
        String room = scan.nextLine();
        Room newRoom = new Room(room);
        return newRoom;
    }
    
    public static void main(String[] args) 
    {   
        ArrayList<Room> roomList = new ArrayList<>();
        ArrayList<FSM> objectList = new ArrayList<>();
        boolean end = false;
        while(!end)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("What do you want to create?");
            String input = scan.nextLine();
            input = input.toLowerCase();
            switch(input)
            {
                case "room":
                    roomList.add(createRoom());
                    System.out.println("Room " + roomList.get(roomList.size() - 1).getName() + " Created");
                    break;
                
                case "object":
                    objectList.add(createObject());
                    System.out.println("Object " + objectList.get(objectList.size() - 1).getName() + " Created");
                    break;
                
                case "no":
                    end = true;
                    
                default:
                    System.out.println("Invalid!");
                    break;
            }
        }
        
        System.out.println("------------------Object list--------------------");
        for(Room r: roomList)
        {
            System.out.println("Room: " + r.getName());
        }

        for(FSM o: objectList)
        {
            System.out.println("Object: " + o.getName());
        }
    }
    
}
