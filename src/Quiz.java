package src;
import java.util.ArrayList;

public abstract class Quiz {
    public ArrayList<Question> question;
    protected String ask;
    protected int correctAnswer;
    protected ArrayList<String> answer;

    public Quiz(Question question) {

    }
    /*
     * this class add questions in the parm of ask
     * answer, and the correct answer. 
     *      */
    public void addQuestion(String ask,ArrayList<String> answer, int correctAnswer) {
        this.ask = ask;
        
    } 

}
