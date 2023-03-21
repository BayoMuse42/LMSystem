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
    public String courseID;
    public UUID userID;

    public Course(Teacher teacher, int difficulty, String name){
        
    }

    public void createModule(String name, String description){

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
    
}
