package fsmprototype;


import java.io.Serializable;

/**
 * Condition class in Transition
 * @author Alvin Lu
 */
public class Condition implements Serializable {
    private String name; //name of condition
    private double defaultAmt = 0; //default numeric value
    private boolean defaultBool = true; //default boolean value
    private Type condType; //Type of condition in enum Type
    private Attribute condition; //Attribute the condition is associated with
    
    /**
     * Enum Type used to determine type of condition
     */
    enum Type{
    BOOLEAN, NUMERICEQ, NUMERICST, NUMERICBT
    }
    
    /**
     * Constructor for condition, creates an empty Condition object
     * @param name name of condition
     */
    public Condition(String name)
    {
        this.name = name;
    }
    
    /**
     * Constructor for condition, creates a numeric condition
     * @param name name of condition
     * @param at attribute associated with condition
     * @param val value of condition to be checked against
     * @param det determines which type of condition 0 for equals
     *  bigger than 0 for larger than, smaller than 0 for smaller than
     */
    public Condition(String name, Attribute at, double val, int det){
        this.name = name;
        this.condition = at;
        this.defaultAmt = val;
        if(det == 0){
            this.condType = Type.NUMERICEQ;
        }
        else if(det < 0){
            this.condType = Type.NUMERICST;
        }
        else if(det > 0){
            this.condType = Type.NUMERICBT;
        }
    }
    
    /**
     * Constructor for condition, creates a boolean condition
     * @param name name of condition
     * @param at attribute associated
     * @param val value to be compared to
     */
    public Condition(String name, Attribute at, boolean val){
        this.name = name;
        this.condition = at;
        this.defaultBool= val;
        this.condType = Type.BOOLEAN;
    }
    
    /**
     * return the name of condition
     * @return name of condition in String
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * return type of condition in Type
     * @return type of condition in Enum Type
     */
    public Type getType(){
        return this.condType;
    }
    
    /**
     * Return the attribute associated with the condition
     * @return attribute associated in Attribute
     */
    public Attribute getAtt(){
        return this.condition;
    }
    
    /**
     * return the numeric value to be compared to
     * @return numeric comparison in double
     */
    public double getValueAmt(){
        return this.defaultAmt;
    }
    
    /**
     * return the boolean value to be compared to
     * @return boolean value of condition
     */
    public boolean getValueBool(){
        return this.defaultBool;
    }
    
    /**
     * Check the condition to the attribute value, return true if value matches
     * @return true if condition matches
     */
    public boolean checkCondition(){
        if(this.condition instanceof Number_Attribute){
            if(null == this.condType){
                if(this.defaultAmt < ((Number_Attribute)this.condition)
                        .getValue()){
                    return true;
                }
            }
            else switch (this.condType) {
                case NUMERICEQ:
                    if(this.defaultAmt == ((Number_Attribute)this.condition)
                            .getValue()){
                        return true;
                    }   break;
                case NUMERICBT:
                    if(this.defaultAmt < ((Number_Attribute)this.condition)
                            .getValue()){
                        return true;
                    }   break;
                default:
                    if(this.defaultAmt > ((Number_Attribute)this.condition)
                            .getValue()){
                        return true;
                    }   break;
            }
        }
        else{
            if(this.defaultBool == ((Boolean_Attribute)this.condition)
                    .getCondition()){
                return true;
            }
        }
        return false;
    }
}