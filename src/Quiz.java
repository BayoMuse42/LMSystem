package src;
import java.util.ArrayList;
import java.util.function.BooleanSupplier;
import java.util.Scanner;

public class Quiz {

    public Question[] questions;
    public double quizResult;    

    public Quiz(Question[] questions) {
        this.questions = questions;
    }

      
    public void addQuestion(String ask, String[] potentialAnswer, int answer) {
        Question question = new Question(ask, answer, potentialAnswer);
        questions[questions.length + 1] = question;
    }

    public double getQuizResult(int input){
        return quizResult;
    }

    public Question[] getQuestions(){
        return questions;
    }

    // To do 
    public void setQuizResult(double quizResult) {
        this.quizResult = quizResult;
    }

    public String[] getPotentialAnswers(){
        for (int k = 0; k < questions.length; k++){
            return questions[k].getPotentialAnswers();
        };
        return null;
    }

    public void startQuiz(){
        int score = 0;
        for (int i = 0; i < questions.length; i++){
            System.out.println("Question " + (i + 1) + ": " + questions[i].getAsk());

            String[] options = questions[i].getPotentialAnswers();
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
        System.out.println("Quiz finished. Your score is " + score + "/" + questions.length);
        this.quizResult = score / questions.length;
        }
    }


