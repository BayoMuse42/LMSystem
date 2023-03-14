<<<<<<< HEAD
package src;

public abstract class User {

    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    public UUID userID;

    public User(String email, String username, String password){};

    public User(String email, String username, String password, UUID userID){};

    public ArrayList<Course> getCourses(String keyword){};

    public ArrayList<Course> getCourses(){};

    
}
=======
package src;

public abstract class User {

    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    public UUID userID;

    public User(String email, String username, String password){};

    public User(String email, String username, String password, UUID userID){};

    public ArrayList<Course> getCourses(String keyword){};

    public ArrayList<Course> getCourses(){};

    
}
>>>>>>> 5081bc48bc523f3cb034691f7e7c4d99ee4ca46c
