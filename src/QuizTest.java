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
    private ArrayList<String> potAnswers;


    @BeforeEach
    public void setup(){

        questions = new ArrayList<Question>();
        potAnswers = new ArrayList<String>();

        potAnswers = new ArrayList<String>();
        potAnswers.add("0001");
        potAnswers.add("0101");
        potAnswers.add("0111");
        potAnswers.add("1001");
        questions.add(new Question("What is 7 in 4-bit unsigned binary?", 3, potAnswers));

        potAnswers.clear();
        potAnswers.add("break");
        potAnswers.add("continue");
        potAnswers.add("stop");
        potAnswers.add("delete");
        questions.add(new Question("What statement is used to stop a loop?", 1, potAnswers));

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


    

}
