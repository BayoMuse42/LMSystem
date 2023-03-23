package src;
import java.util.ArrayList;
import java.util.function.BooleanSupplier;

public class Quiz {

    public Question question;
    public String answer; 
    public String correct;
    public String quizResult;
    public Quiz quiz;
    ; 

    public Quiz(Question question) {
        this.question = question;
    }

      
    public void addQuestion(String ask, ArrayList<String> potentialAnswer, String answer) {
        Question question = new Question(ask, answer, potentialAnswer);
        this.question = question;
    }

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
        return this.correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public void setQuizResult(String quizResult) {
        this.quizResult = quizResult;
    }

    public String getAsk(){
        return this.question.getAsk();
    }

    public ArrayList<String> getPotentialAnswers(){
        return this.question.getPotentialAnswers();
    }


}
