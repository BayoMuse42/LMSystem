package src;
import java.util.UUID;
import java.util.ArrayList;

public class Teacher extends User{

    /**
     * constructor
     * @param email
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     */
    public Teacher(String email, String username, String password, String firstName, String lastName){
        super(email, username, password, firstName, lastName, "teacher");
    }

    /**
     * overloaded constructor
     * @param email
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param userID
     */
    public Teacher(String email, String username, String password, String firstName, String lastName, UUID userID){
        super(email, username, password, firstName, lastName, userID, "teacher");
    }

    /**
     * calls super to get course based on name
     * @param name
     * @return
     */
    public Course getCourses(String name){
        return super.getCourses(name);
    }

    /**
     * calls super method to get all courses
     * @return
     */
    public ArrayList<Course> getCourses(){
        return super.getCourses();
    }
    
    /**
     * @return string description of teacher
     */
    public String toString(){
        return "First name: " + firstName + " Last name " + lastName + " Email:  "
        + email + " username " + username + " password: " + password + " type: " + type + " UUID: " + userID;
    }
}
