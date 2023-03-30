package src;
import java.util.ArrayList;

public class Quiz {

    public ArrayList<Question> questions;
    public double quizResult;    

    /**
     * constructor
     * @param questions
     */
    public Quiz(ArrayList<Question> questions) {
        this.questions = questions;
    }
      
    /**
     * adds question to arraylist of questions
     * @param ask
     * @param potentialAnswer
     * @param answer
     */
    public void addQuestion(String ask, ArrayList<String> potentialAnswer, int answer) {
        Question question = new Question(ask, answer, potentialAnswer);
        questions.add(question);
    }

    /**
     * 
     * @return quiz result
     */
    public double getQuizResult() {
        return quizResult;
    }

    /**
     * gets array list of questions
     * @return
     */
    public ArrayList<Question> getQuestions(){
        return questions;
    }

    /**
     * removes question from quiz based on index of question in arraylist
     * @param intInput
     */
    public void removeQuestion(int intInput) {
        questions.remove(intInput);
    }

    /**
     * sets result of users quiz
     * @param quizResult
     */
    public void setQuizResult(double quizResult) {
        this.quizResult = quizResult;
    }

    public ArrayList<String> getPotentialAnswers(){
        for (int k = 0; k < questions.size(); k++){
            return questions.get(k).getPotentialAnswers();
        };
        return null;
    }

    /**
     * gets result of a users quiz
     * @param numCorrect
     */
    public void calcQuizResult(int numCorrect) {
        quizResult = (numCorrect/questions.size())*100;
    }

    /**
     * returns a string description of a quiz
     */
    @Override
    public String toString() {
        String output = "";
        for (Question q: questions){
            output += "ASK: " + q.getAsk() + "\nANSWER: " + q.getAnswer() + "\nPOTENTIAL ANSWERS: ";
            for(String s: q.potentialAnswers){
                output += (s) + "\n";
            }
        }
        return output;
        }
}


