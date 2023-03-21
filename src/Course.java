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

    public Course(UUID Teacher, int difficulty, String name){
        this.Teacher = Teacher;
        this.difficulty = difficulty;
        this.name = name;
    }

    public void createModule(String name, String description){
        this.modules = new ArrayList<Module>();

    }

    public Course searchCourses(Teacher teacher){

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

    public UUID getID(){
        return courseID;
    }
    
}
