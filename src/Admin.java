package src;
import java.util.UUID;
import java.util.ArrayList;

public class Admin extends User{

    public Admin(String email, String username, String password){
        super(email, username, password);
    }

    public Admin(String email, String username, String password, UUID userID){
        super(email, username, password, userID);
    }

    public void removeMessage(){

    }

    public ArrayList<Course> getCourses(String keyword){
        return null;

    }

    public ArrayList<Course> getCourses(){
        return null;

    }
    
}
