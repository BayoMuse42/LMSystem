package src;
import java.util.ArrayList;

public abstract class Quiz {
    
    protected String ask;
    protected int correctAnswer;
    protected ArrayList<String> answer;
    protected Object ArrayList;

    public Quiz(Question question) {
         question.ask(question);
    }
    
    } 