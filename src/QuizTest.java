package src;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
//import java.util.UUID;


public class QuizTest {
    private Quiz quiz;
    private ArrayList<Question> questions;
    private ArrayList<String> potAnswers1;
    private ArrayList<String> potAnswers2;


    @BeforeEach
    public void setup(){

        questions = new ArrayList<Question>();
        potAnswers1 = new ArrayList<String>();
        potAnswers2 = new ArrayList<String>();

        potAnswers1.add("0001");
        potAnswers1.add("0101");
        potAnswers1.add("0111");
        potAnswers1.add("1001");
        questions.add(new Question("What is 7 in 4-bit unsigned binary?", 3, potAnswers1));

        potAnswers2.add("break");
        potAnswers2.add("continue");
        potAnswers2.add("stop");
        potAnswers2.add("delete");
        questions.add(new Question("What statement is used to stop a loop?", 1, potAnswers2));

        quiz = new Quiz(questions);
    }

    @AfterEach
    public void tearDown(){
        
    }

    @Test
    public void testing(){
        assertTrue(true);
    }

    @Test
    public void hasQuestions(){
        Boolean test1 = true;
        for (int i = 0; i < questions.size(); i++){
            if (questions.get(i).getAsk() == null){
                test1 = false;
            }
        assertTrue(test1);
        }
    }

    @Test
    public void hasQuestion(){
        Boolean test2 = true;
        for (int i = 0; i < questions.size(); i++){
            for (int j = 0; j < questions.get(i).potentialAnswers.size(); j++){
                if (questions.get(i).potentialAnswers.get(j) == null){
                    test2 = false;
                }
            }
        }
        assertTrue(test2);
    }

    @Test
    public void hasResult(){
        quiz.setQuizResult(0.5);
        Boolean test3 = true;
        if (quiz.quizResult != 0.5){
            test3 = false;
        }
        assertTrue(test3);

    }

    @Test
    public void hasCorrectAnswerIndex(){
        Boolean test4 = true;
        if (questions.get(0).getAnswer() != 3){
            test4 = false;
        }

        else if (questions.get(1).getAnswer() != 1){
            test4 = false;
        }
        assertTrue(test4);
    }

    @Test
    public void hasPotentialAnswers(){
        Boolean test5 = true;
        for (int i = 0; i < questions.size(); i++){
            Question q = questions.get(i);
            ArrayList<String> potentialAnswers = q.getPotentialAnswers();
            ArrayList<String> potAnswers = i == 0 ? potAnswers1 : potAnswers2;
            if (potentialAnswers.size() != potAnswers.size()){
                test5 = false;
            }

            for (int j = 0; j < potentialAnswers.size(); j++){
                if (!potentialAnswers.get(j).equals(potAnswers.get(j))){
                    test5 = false;
                }
            }
        }
        assertTrue(test5);   
    }


    

}
