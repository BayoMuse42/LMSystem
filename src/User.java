package src;
import java.util.UUID;
import java.util.ArrayList;

public abstract class User {

    protected String email;
    protected String username;
    protected String password;
    protected String firstName;
    protected String lastName;
    public UUID userID;

    public User(String email, String username, String password, String firstName, String lastName){
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    };

    public User(String email, String username, String password, String firstName, String lastName, UUID userID){
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
    };

    public ArrayList<Course> getCourses(String keyword){

    };

    public ArrayList<Course> getCourses(){
        
    };

    
}
