package src;
import java.util.ArrayList;
import java.util.Arrays;

public class Question {
    protected String ask;
    protected int answer;
    protected String[] potentialAnswers;
    protected String response;
        
   
    public Question(String ask, int answer, String[] potentialAnswers) {
        this.ask = ask;
        this.answer = answer;
        this.potentialAnswers = potentialAnswers;
    }
    
    public void addQuestion(String ask, int answer) {
        this.ask = ask;
        this.answer = answer; 
    }        

    public boolean isCorrect(int response) {
        if (response == answer){
            return true;
        }
        else return false;
    }

    public String getAsk(){
        return ask;
    }

    public int getAnswer(){
        return answer;
    }

    public String[] getPotentialAnswers(){
        return potentialAnswers;
    }

    @Override
    public String toString() {
        return "Question [ask=" + ask + ", answer=" + answer + ", potentialAnswers=" + Arrays.toString(potentialAnswers)
                + ", response=" + response + "]";
    }
}
