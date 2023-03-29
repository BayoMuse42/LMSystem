package src;
import java.util.ArrayList;
import java.util.function.BooleanSupplier;

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
    
    /* We wont need this, it's in the UI already
     public void startQuiz(){
        int score = 0;
        for (int i = 0; i < questions.size(); i++){
            System.out.println("Question " + (i + 1) + ": " + questions.get(i).getAsk());

            String[] options = questions.get(i).getPotentialAnswers();
            for (int j = 0; j < options.length; j++){
                System.out.println((j + 1) + ") " + options[j]);
            } 
            
            Scanner scanner = new Scanner(System.in);
            int userAnswerIndex = scanner.nextInt();
            String userAnswer = options[userAnswerIndex - 1];

            if (userAnswer.equals(questions[i].getAnswer())) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect.");
            }
        }
        System.out.println("Quiz finished. Your score is " + score + "/" + questions.size());
        this.quizResult = score / questions.size();
        } */
    }


