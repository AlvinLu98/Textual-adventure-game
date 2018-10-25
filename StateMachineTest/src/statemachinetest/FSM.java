
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
    State startState;
    List<Transition> transitions;
    
    FSM(String name, State start)
    {
        this.name = name;
        this.startState = start;
        transitions = new LinkedList<>();
    }
    
    FSM(State start, List<Transition> transitions)
    {
        this.startState = start;
        this.transitions = transitions;
    }
    
    String getName()
    {
        return name;
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
    
    void listAllTransitions()
    {
        for(Transition t: transitions)
        {
            System.out.println(t.toString());
        }
    }
}
