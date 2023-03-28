package src;
import java.util.ArrayList;
import java.util.function.BooleanSupplier;
import java.util.Scanner;

public class Quiz {

    public Question[] questions;
    public String answer; 
    public String correct;
    public double quizResult;
    public Quiz quiz;
    ; 

    public Quiz(Question[] questions) {
        this.questions = questions;
    }

      
    public void addQuestion(String ask, String[] potentialAnswer, String answer) {
        Question question = new Question(ask, answer, potentialAnswer);
        questions[questions.length + 1] = question;
    }

    public double getQuizResult(int input){
        return this.quizResult;
    }

    public double getQuizResult(String input){
        if (input.equals(answer)){
            return 100;
        }
        else return 0;
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

    // To do 
    public void setQuizResult(String quizResult) {
        this.quizResult = quizResult;
    }

    public String getAsk(){
        for (int k = 0; k < questions.length; k++){
            return questions[k].getAsk();
        };
    }

    public String[] getOptions(){
        for (int k = 0; k < questions.length; k++){
            return questions[k].getPotentialAnswers();
        };
    }

    public void startQuiz(){
        int score = 0;
        for (int i = 0; i < questions.length; i++){
            System.out.println("Question " + (i + 1) + ": " + questions[i].getAsk())

            String[] options = questions[i].getPotentialAnswers();
            for (int j = 0; j < options.length; j++){
                System.out.println((j + 1) + ") " + options[j]);
            } 
            
            Scanner scanner = new Scanner(System.in);
            int userAnswerIndex = scanner.nextInt();
            String userAnswer = [userAnswerIndex - 1];

            if (userAnswer.equals(questions[i].getAnswer())) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect.");
            }
        }
        System.out.println("Quiz finished. Your score is " + score + "/" + questions.length);
        }
    }


}
