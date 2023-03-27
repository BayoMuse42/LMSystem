package src;
import java.util.ArrayList;

public class Module {

    private String name;
    private String description;
    private Quiz quiz;
    private double quizResult;
    private ArrayList<Section> sections;
    private String content;

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
        for (Section s: sections){
            return s.getContent();
        }
        
        return null;
    }

    public void setName(String name){

    }

    public void setContent(String message){

    }

    public boolean isComplete(){
        return false;
        
    }

    public void createQuiz(){

    }

    public double getQuizResult(){
        return quizResult;

    }

    public String getDescription(){
        return this.description;
    }

    public Quiz getQuiz(){
        return this.quiz;
    }

    public ArrayList<String> getPotentialAnswers(){
        return this.quiz.getPotentialAnswers();
    }

    public Section getSection(String name){
        for (Section s: this.sections){
            if (s.getName().equals(name))
                return s;
        }
        return null;
    }

    public ArrayList<Section> getSections() {
        return this.sections;
    }
    
}
