package src;
import java.util.UUID;
import java.util.ArrayList;

public class Course {

    private UUID Teacher;
    private int difficulty;
    private String name;
    private ArrayList<Module> modules;
    private ArrayList<Comment> comments;
    private Quiz endOfCourseQuiz;
    private double quizResult;
    public UUID courseID;
    public UUID userID;

    public Course(UUID Teacher, int difficulty, String name, ArrayList<Module> modules, ArrayList<Comment> comments, Quiz quiz, UUID courseID, UUID userID){
        this.Teacher = Teacher;
        this.difficulty = difficulty;
        this.name = name;
        this.modules = modules;
        this.comments = comments;
        this.endOfCourseQuiz = quiz;
        this.courseID = courseID;
        this.userID = userID;
    }

    public Course(UUID Teacher, int difficulty, String name, Quiz endOfCourseQuiz){
        this.Teacher = Teacher;
        this.difficulty = difficulty;
        this.name = name;
        this.endOfCourseQuiz = endOfCourseQuiz;
    }

    public void createModule(String name, String description){
        this.modules = new ArrayList<Module>();

    }

    public Course searchCourses(Teacher teacher){
        return null;

    }

    public Course searchCourse(int difficulty){

    }

    public Course searchCourses(String name){

    }

    public Course searchCourses(Course course){

    }

    public double checkProgress(Course course){

    }

    public boolean isComplete(){

    }

    public double getQuizResult(Quiz quiz){
        
    }

    public UUID getTeacher(){
        return this.Teacher;
    }

    public int getDifficulty(){
        return this.difficulty;
    }

    public String getName(){
        return this.name;
    }

    public Quiz getEndOfCourseQuiz(){
        return this.endOfCourseQuiz;
    }

    public ArrayList<Comment> getComments(){
        return this.comments;
    }

    public ArrayList<Module> getModule(){
        return this.modules;
    }

    public UUID getCourseID(){
        return this.courseID;
    }

    public UUID getID(){
        return courseID;
    }

    public String getAsk(){
        return this.endOfCourseQuiz.getAsk();
    }
    
}
