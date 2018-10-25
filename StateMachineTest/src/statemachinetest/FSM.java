
package statemachinetest;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Alvin Lu
 */
public class FSM 
{
    String name;
    State currentState;
    List<Transition> transitions;
    
    FSM(String name, State start)
    {
        this.name = name;
        this.currentState = start;
        transitions = new LinkedList<>();
    }
    
    FSM(State start, List<Transition> transitions)
    {
        this.currentState = start;
        this.transitions = transitions;
    }
    
    String getName()
    {
        return name;
    }
    
    State getCurrentState()
    {
       return currentState; 
    }
    
    boolean addTransistion(Transition t)
    {
        return transitions.add(t);
    }
    
    boolean createTransition(String fromName, Set<Condition> c, String action, String toName)
    {
        Transition t = new Transition(fromName, c, action, toName);
        return transitions.add(t);
    }
    
    State changeState(String action)
    {
        for(Transition t: transitions)
        {
            if(t.getFrom().getName().equals(currentState.getName()))
            {
                if(t.getAction().equals(action))
                {
                    currentState = t.getTo();
                    return t.getTo();
                }
            }
        }
        return null;
    }
    
    void listAllTransitions()
    {
        for(Transition t: transitions)
        {
            System.out.println(t.toString());
        }
    }
}
