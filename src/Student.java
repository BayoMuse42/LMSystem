package src;
import java.util.UUID;
import java.util.ArrayList;

public class Student extends User{

    private int skill;
    private ArrayList<Double> grades;

    public Student(String email, String username, String password, String firstName, String lastName){
        super(email, username, password, firstName, lastName, "student");
    }

    public Student(String email, String username, String password, String firstName, String lastName, UUID userID){
        super(email, username, password, firstName, lastName, userID, "student");
    }

    public ArrayList<Course> getCourses(String keyword){
        return this.getCourses(keyword);

    }

    public ArrayList<Course> getCourses(){
        return this.getCourses();
    }

    public String toString(){
        return firstName + " " + lastName + " is a student";
    }
    
    
}
