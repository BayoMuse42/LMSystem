package src;
import java.util.ArrayList;

public class Question {
    protected String ask;
    protected String answer;
    protected ArrayList<String> potentialAnswers;
    protected String correctAnswer;
    protected String response;
        
   
    public Question(String ask, String answer, ArrayList<String> potentialAnswers) {
        this.ask = ask;
        this.answer = answer;
                  
    }
    
    public void addQuestion(String ask, String answer, String correctAnswer) {
        this.ask = ask;
        this.answer = answer; 
        this.correctAnswer = correctAnswer;
        
    }        

    public boolean isCorrect(String response) {
        if (response == answer){
            return true;
        }
        else return false;
    }
}
