package src;
import java.util.UUID;
import java.util.ArrayList;

public class Teacher extends User{

    public Teacher(String email, String username, String password, String firstName, String lastName){
        super(email, username, password, firstName, lastName);
    }

    public Teacher(String email, String username, String password, String firstName, String lastName, UUID userID){
        super(email, username, password, firstName, lastName, userID);
    }

    public ArrayList<Course> getCourses(String keyword){
            return this.getCourses(keyword);
    }

    public ArrayList<Course> getCourses(){
        return this.getCourses();
    }
    
    public String toString(){
        return firstName + " " + lastName + " is a teacher.";
    }
}
