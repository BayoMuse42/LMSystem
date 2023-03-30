package src;
import java.util.UUID;
import java.util.ArrayList;

public class Admin extends User{

    /**
     * 
     * @param email
     * @param password
     * @param username
     * @param firstName
     * @param lastName
     * Constructor calls the superconstructor in the User class
     */
    public Admin(String email, String password, String username, String firstName, String lastName){
        super(email, password, username, firstName, lastName, "admin");
    }

    /**
     * 
     * @param email
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param userID
     * Overloaded Constructor creates Admin object with userID
     */
    public Admin(String email, String username, String password, String firstName, String lastName, UUID userID){
        super(email, username, password, firstName, lastName, userID, "admin");
    }

    public void removeMessage(){

    }

    /**
     * @param name
     * @return Course
     * getCourses calls superclass getCourses method to search for a course based on the course name 
     */
    public Course getCourses(String name){
        return super.getCourses(name);
    }

    /**
     * getCourses calls superclass getCourses method and returns an arraylist of courses
     */
    public ArrayList<Course> getCourses(){
        return super.getCourses();
    }
    
    /**
     * toString returns string with admin information
     */
    public String toString() {
        return "First name: " + firstName + " Last name " + lastName + " Email:  "
        + email + " username " + username + " password: " + password + " type: " + type + " UUID: " + userID;
    }
}
