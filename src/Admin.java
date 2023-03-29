package src;
import java.util.UUID;
import java.util.ArrayList;

public class Admin extends User{

    public Admin(String email, String password, String username, String firstName, String lastName){
        super(email, password, username, firstName, lastName, "admin");
    }

    public Admin(String email, String username, String password, String firstName, String lastName, UUID userID){
        super(email, username, password, firstName, lastName, userID, "admin");
    }

    public void removeMessage(){

    }

    public ArrayList<Course> getCourses(String keyword){
        return this.getCourses(keyword);
    }

    public ArrayList<Course> getCourses(){
        return this.getCourses();
    }
    
}
