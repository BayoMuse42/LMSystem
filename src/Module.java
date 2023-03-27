package src;
import java.util.ArrayList;
import java.util.concurrent.CompletionException;

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

    public Object setName(String name){
            return this.setName(name);
    }

    public Object setContent(String message){
            return this.setContent(message);
    }

    public boolean isComplete(){
        if(isComplete())  {
            return true;
            }
            else return false;
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

    public void removeSection(String secName) {

    }
    
}
