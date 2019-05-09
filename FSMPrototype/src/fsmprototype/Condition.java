package fsmprototype;

import java.io.Serializable;

public class Condition implements Serializable {
    private String name;
    private int defaultAmt = 0;
    private boolean defaultBool = true;
    private Type condType;
    private Attribute condition;
    
    enum Type{
    BOOLEAN, NUMERICEQ, NUMERICST, NUMERICBT
    }
    
    public Condition(String name)
    {
        this.name = name;
    }
    
    public Condition(String name, Attribute at, int val, int det){
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
    
    public Condition(String name, Attribute at, boolean val){
        this.name = name;
        this.condition = at;
        this.defaultBool= val;
        this.condType = Type.BOOLEAN;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public Type getType(){
        return this.condType;
    }
    
    public Attribute getAtt(){
        return this.condition;
    }
    
    public int getValueAmt(){
        return this.defaultAmt;
    }
    
    public boolean getValueBool(){
        return this.defaultBool;
    }
    
    public boolean checkCondition(){
        if(this.condition instanceof Number_Attribute){
            if(this.condType == Type.NUMERICEQ){
                if(this.defaultAmt == ((Number_Attribute)this.condition).getValue()){
                    return true;
                }
            }
            else if(this.condType == Type.NUMERICBT){
                if(this.defaultAmt > ((Number_Attribute)this.condition).getValue()){
                    return true;
                }
            }
            else{
                if(this.defaultAmt < ((Number_Attribute)this.condition).getValue()){
                    return true;
                }
            }
        }
        else{
            if(this.defaultBool == ((Boolean_Attribute)this.condition).getCondition()){
                return true;
            }
        }
        return false;
    }
}
