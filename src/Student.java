package src;
import java.util.UUID;
import java.util.ArrayList;

public class Student extends User{

    private int skill;
    private ArrayList<double> grades;

    public Student(String email, String username, String password){
        super(email, username, password);
    }

    public Student(String email, String username, String password, UUID userID){
        super(email, username, password, userID);
    }

    public ArrayList<Course> getCourses(String keyword){

    }

    public ArrayList<Course> getCourses(){
        
    }

    public String toString(){
        
    }
    
}
