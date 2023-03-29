package src;
import java.util.UUID;
import java.util.ArrayList;

public class Student extends User{

    private int skill;
    private ArrayList<Double> grades;

    public Student(String email, String username, String password, String firstName, String lastName){
        super(email, username, password, firstName, lastName);
    }

    public Student(String email, String username, String password, String firstName, String lastName, UUID userID){
        super(email, username, password, firstName, lastName, userID);
    }

    public Course getCourses(String name){
        return super.getCourses(name);

    }

    public ArrayList<Course> getCourses(){
        return super.getCourses();
    }

    public String toString(){
        return firstName + " " + lastName + " is a student";
    }
    
    
}
