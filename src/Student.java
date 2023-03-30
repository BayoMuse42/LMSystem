package src;
import java.util.UUID;
import java.util.ArrayList;

public class Student extends User{

    private int skill;
    private ArrayList<Double> grades;

    /**
     * constructor
     * @param email
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     */
    public Student(String email, String username, String password, String firstName, String lastName){
        super(email, username, password, firstName, lastName, "student");
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
    public Student(String email, String username, String password, String firstName, String lastName, UUID userID){
        super(email, username, password, firstName, lastName, userID, "student");
    }

    /**
     * calls super method to get course based on name
     * @param name
     * @return 
     */
    public Course getCourses(String name){
        return super.getCourses(name);

    }

    /**
     * calls super to get all courses
     * 
     */
    public ArrayList<Course> getCourses(){
        return super.getCourses();
    }

    /**
     * returns string description of student
     */
    public String toString(){
        return "First name: " + firstName + " Last name " + lastName + " Email:  "
        + email + " username " + username + " password: " + password + " type: " + type + " UUID: " + userID;
    }
    
    
}
