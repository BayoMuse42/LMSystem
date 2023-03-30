package src;
import java.util.UUID;
import java.util.ArrayList;

public abstract class User {

    protected String email;
    protected String username;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected String type; // Student, Teacher, or Admin. Lmk if this changes. Needed for UI.
    public UUID userID;   
    protected CourseList cList =  CourseList.getInstance();

    /**
     * constructor
     * @param email
     * @param password
     * @param username
     * @param firstName
     * @param lastName
     * @param type
     */
    public User(String email, String password, String username, String firstName, String lastName, String type){
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
    };

    /**
     * overloaded constructor
     * @param email
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param userID
     * @param type
     */
    public User(String email, String username, String password, String firstName, String lastName, UUID userID, String type){
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
        this.type = type;
    };

    /**
     * gets courses based on name
     * @param name
     * @return
     */
    public Course getCourses(String name){
        return cList.getCourse(name);
    };

    /**
     * gets all courses
     * @return
     */
    public ArrayList<Course> getCourses(){
        return cList.getCourses(userID);
    };

    /**
     * gets first name
     * @return
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * gets last name
     * @return
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     * gets password
     * @return
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * gets username
     * @return
     */
    public String getUserName(){
        return this.username;
    }

    /**
     * gets user ID
     * @return
     */
    public UUID getUserID(){
        return this.userID;
    }
    
    /**
     * gets email
     * @return
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * gets type of user
     * @return
     */
    public String getType() {
        return this.type;
    }
       
}
