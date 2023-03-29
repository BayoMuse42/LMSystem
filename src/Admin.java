package src;
import java.util.UUID;
import java.util.ArrayList;

public class Admin extends User{

    public Admin(String email, String password, String username, String firstName, String lastName){
        super(email, password, username, firstName, lastName);
    }

    public Admin(String email, String username, String password, String firstName, String lastName, UUID userID){
        super(email, username, password, firstName, lastName, userID);
    }

    public void removeMessage(){

    }

    public Course getCourses(String name){
        return super.getCourses(name);
    }

    public ArrayList<Course> getCourses(){
        return super.getCourses();
    }
    
}
