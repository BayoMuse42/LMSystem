package src;
import java.util.ArrayList;

public class Quiz {

    public ArrayList<Question> questions;
    public double quizResult;    

    public Quiz(ArrayList<Question> questions) {
        this.questions = questions;
    }
      
    public void addQuestion(String ask, String[] potentialAnswer, int answer) {
        Question question = new Question(ask, answer, potentialAnswer);
        questions.add(question);
    }

    public double getQuizResult() {
        return quizResult;
    }

    public ArrayList<Question> getQuestions(){
        return questions;
    }

    public void removeQuestion(int intInput) {
        questions.remove(intInput);
    }

    // To do 
    public void setQuizResult(double quizResult) {
        this.quizResult = quizResult;
    }

    public String[] getPotentialAnswers(){
        for (int k = 0; k < questions.size(); k++){
            return questions.get(k).getPotentialAnswers();
        };
        return null;
    }

    public void calcQuizResult(int numCorrect) {
        quizResult = (numCorrect/questions.size())*100;
    }

    @Override
    public String toString() {
        for (Question q: questions){
            System.out.println("ASK: " + q.getAsk() + "\nANSWER: " + q.getAnswer() + "\nPOTENTIAL ANSWERS: ");
            for(String s: q.potentialAnswers){
                System.out.println((s) + "\n");
            }
        }
        return null;
        }
}


