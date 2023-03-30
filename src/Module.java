package src;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException; 

public class Module {

    private String name;
    private String description;
    private Quiz quiz;
    private double quizResult;
    private ArrayList<Section> sections;
    private boolean completeFlag;

    public Module(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void createSection(String name, String content){
        sections.add(new Section(name, content));
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
        return completeFlag;
    }

    public void setComplete(boolean b) {
        this.completeFlag = b;
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
        sections.remove(getSection(secName));
    }

    public void printContent() {
        try {
            FileWriter modWriter = new FileWriter(name + ".txt");
            for (Section s : sections) {
                modWriter.write(s.getName() + "\n");
                modWriter.write(s.getContent() + "\n");
            }
            modWriter.close();
            System.out.println("Module content successfully printed!");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          } 
    }

    public String toString() {
        return "Name: " + name + " Description: " + description + " Quiz Result:" + quizResult + " Is the course complete?: " + completeFlag;
    }
    
}
