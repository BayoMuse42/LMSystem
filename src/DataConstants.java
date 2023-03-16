package src;
import java.util.ArrayList;
public abstract class DataConstants {
    protected static final String USER_FILE_NAME = "src/user.json";
    protected static final String COURSE_FILE_NAME = "src/course.json";
    /**
     * User elements
     */
    protected static final String EMAIL = "";
    protected static final String USERNAME = "";
    protected static final String PASSWORD = "";
    protected static final String FIRST_NAME = "";
    protected static final String LAST_NAME = "";
    protected static final String USER_LD = "";
    /**
     * Course elements
     */
    protected static final String TEACHER = "";
    protected static final int DIFFICULTY = 0;
    protected static final ArrayList<Module> MODULES = new ArrayList<Module>();
    protected static final ArrayList<Comment> COMMENTS = new ArrayList<Comment>();
    protected static final Quiz END_OF_COURSE_QUIZ = new Quiz();
    protected static final double QUIZ_RESULT = 1.5;
    protected static final String COURSE_ID = "";
    protected static final String USER_ID = "";

}