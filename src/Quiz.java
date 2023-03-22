package src;
import java.util.ArrayList;
import java.util.function.BooleanSupplier;

public abstract class Quiz {

    public Question question;
    public String answer; 
    public String correct;
    public String quizResult;

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

    public Quiz getQuizResult(){
        return quiz;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public void setQuizResult(String quizResult) {
        this.quizResult = quizResult;
    }
    else return flase;

}
