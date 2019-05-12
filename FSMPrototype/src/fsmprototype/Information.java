package fsmprototype;

import java.io.Serializable;

/**
 * Information contained in human objects
 * @author Alvin Lu
 */
public class Information implements Serializable {
    private String prompt;
    private String answer;
    
    /**
     * Returns the prompt for information
     * @return prompt in string
     */
    public String getPrompt(){
        return this.prompt;
    }
    
    /**
     * Returns the answer from the prompt
     * @return the answer in string
     */
    public String getAnswer(){
        return this.answer;
    }
}
