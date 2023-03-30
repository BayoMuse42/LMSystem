package src;
import java.util.UUID;
import java.util.ArrayList;

public class Teacher extends User{

    public Teacher(String email, String username, String password, String firstName, String lastName){
        super(email, username, password, firstName, lastName, "teacher");
    }

    public Teacher(String email, String username, String password, String firstName, String lastName, UUID userID){
        super(email, username, password, firstName, lastName, userID, "teacher");
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
