package statemachinetest;

import java.util.ArrayList;

/**
 * @author Alvin Lu
 */
public class Room 
{
    String name;
    ArrayList<FSM> interactable;
    ArrayList<FSM> background;
    
    Room(String name)
    {
        this.name = name;
        interactable = new ArrayList<>();
        background = new ArrayList<>();
    }
    
    String getName()
    {
        return name;
    }
}
