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

    public ArrayList<Course> getCourses(String keyword){

    }

    public ArrayList<Course> getCourses(){
        
    }

    public String toString(){
        return firstName + " " + lastName + " is a student";
    }
    
}
