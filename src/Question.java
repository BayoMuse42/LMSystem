package src;
import java.util.ArrayList;

public class Question {
    protected String ask;
    protected int answer;
    protected ArrayList<String> potentialAnswers;
    protected String response;
        
   /**
    * 
    * @param ask
    * @param answer
    * @param potentialAnswers
    * Constructor 
    */  
    public Question(String ask, int answer, ArrayList<String> potentialAnswers) {
        this.ask = ask;
        this.answer = answer;
        this.potentialAnswers = potentialAnswers;
    }
    
    /**
     * Adds question
     * @param ask
     * @param answer
     */
    public void addQuestion(String ask, int answer) {
        this.ask = ask;
        this.answer = answer; 
    }        

    /**
     * Checks if user response to quiz question is correct
     * @param response
     * @return
     */
    public boolean isCorrect(int response) {
        if (response == answer){
            return true;
        }
        else return false;
    }

    /**
     * 
     * @return string of quiz question
     */
    public String getAsk(){
        return ask;
    }

    /**
     * 
     * @return int mapped to correct answer
     */
    public int getAnswer(){
        return answer;
    }

    public ArrayList<String> getPotentialAnswers(){
        return potentialAnswers;
    }

    /**
     * @return string description of question
     */
    @Override
    public String toString() {
        return "Question [ask=" + ask + ", answer=" + answer + ", potentialAnswers=" + potentialAnswers
                + ", response=" + response + "]";
    }
}
