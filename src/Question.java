package src;
import java.util.ArrayList;

public class Question {
    protected String ask;
    protected String answer;
    protected String[] potentialAnswers;
    protected String response;
        
   
    public Question(String ask, String answer, String[] potentialAnswers) {
        this.ask = ask;
        this.answer = answer;
        this.potentialAnswers = potentialAnswers;
    }
    
    public void addQuestion(String ask, String answer) {
        this.ask = ask;
        this.answer = answer; 
    }        

    public boolean isCorrect(int response) {
        if (potentialAnswers[response] == answer){
            return true;
        }
        else return false;
    }

    public String getAsk(){
        return ask;
    }

    public String getAnswer(){
        return answer;
    }

    public int getAnswerIndex(){
        for (int l = 0; l < potentialAnswers.length; l++){
            if (potentialAnswers[l] == answer){
                return l;
            }
        }
        return -1;
    }

    public String[] getPotentialAnswers(){
        return potentialAnswers;
    }
}
