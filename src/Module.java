package src;
import java.util.ArrayList;

public class Module {

    private String name;
    private String description;
    private Quiz quiz;
    private double quizResult;
    private ArrayList<Section> sections;

    public Module(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void createSection(String name, String content){
        this.name = name;
        this.content = content;

    }

    public String getName(){
        return this.name;

    }

    public String getContent(){
        return this.content;
    }

    public void setName(String name){

    }

    public void setContent(String message){

    }

    public boolean isComplete(){
        
    }

    public void createQuiz(){

    }

    public double getQuizResult(){

    }
    
}
