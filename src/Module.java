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

    /**
     * 
     * @param name
     * @param description
     * Constructor takes name and description
     */
    public Module(String name, String description, Quiz quiz){
        this.name = name;
        this.description = description;
        this.quiz = quiz;
        this.sections = new ArrayList<Section>();
    }

    /**
     * 
     * @param name
     * @param description
     * Constructor takes name and description
     */
    public Module(String name, String description){
        this.name = name;
        this.description = description;
        sections = new ArrayList<Section>();
    }

    /**
     * 
     * @param name
     * @param content
     * Creates a section and adds it to arraylist of sections 
     */
    public void createSection(String name, String content){
        sections.add(new Section(name, content));
    }

    /**
     * 
     * @return Module name
     */
    public String getName(){
        return this.name;
    }

    /**
     * 
     * @return String of module content
     */
    public String getContent(){
        for (Section s: sections){
            return s.getContent();
        }
        return null;
    }

    /**
     * 
     * @param name
     * Changes module name 
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 
     * @return boolean
     * Checks if module is complete
     */
    public boolean isComplete(){
        if(quiz.getQuizResult() >= 80) {
            completeFlag = true;
        }

        return completeFlag;
    }

    /**
     * 
     * @param b
     * Sets module completion
     */
    public void setComplete(boolean b) {
        this.completeFlag = b;
    }

    /**
     * 
     * @return double QuizResult
     */
    public double getQuizResult(){
        return quizResult;

    }

    /**
     * 
     * @return String description of module
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * 
     * @return quiz for module
     */
    public Quiz getQuiz(){
        return this.quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    /**
     * 
     * @param name
     * @return Section matches name
     */
    public Section getSection(String name){
        for (Section s: this.sections){
            if (s.getName().equals(name))
                return s;
        }
        return null;
    }

    /**
     * 
     * @return arraylist of sections
     */
    public ArrayList<Section> getSections() {
        return this.sections;
    }

    /**
     * 
     * @param secName
     * Removes section based on name
     */
    public void removeSection(String secName) {
        sections.remove(getSection(secName));
    }

    /**
     * Prints content of module out to text file
     */
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
        return "Name: " + name + "\nDescription: " + description + "\nQuiz Result:" + quizResult + "\nIs the course complete?: " + completeFlag;
    }
    
}
