package src;
import java.util.ArrayList;

public abstract class Quiz {
<<<<<<< HEAD
    
    protected String ask;
    protected int correctAnswer;
    protected ArrayList<String> answer;
    protected Object ArrayList;

    public Quiz(Question question) {
         question.ask(question);
    }
    
    } 
=======

    public Question question;

    public Quiz(Question question) {
        this.question = question;
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
        return quiz;
    }

}
>>>>>>> a57ac3db7af38e368ba37b6542e7bd7ce835e22b
