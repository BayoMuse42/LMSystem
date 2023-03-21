package src;
import java.util.ArrayList;

public abstract class Quiz {

    public ArrayList<Question> questions;

    public Quiz(Question question) {
        questions = new ArrayList<Question>();
        questions.add(question);
    }

    /*
     * this class add questions in the parm of ask
     * answer, and the correct answer. 
     *      
    public void addQuestion(String ask, ArrayList<String> potentialAnswer, String answer) {
        Question question = new Question(ask, answer, potentialAnswer);
        this.questions.add(question);
    } */

    public Quiz getQuiz(){

    }

}
