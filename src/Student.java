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

    public Course getCourses(String name){
        return super.getCourses(name);

    }

    public ArrayList<Course> getCourses(){
        return super.getCourses();
    }

    public String toString(){
        return "First name: " + firstName + " Last name " + lastName + " Email:  "
        + email + " username " + username + " password: " + password + " type: " + type + " UUID: " + userID;
    }
    
    
}
