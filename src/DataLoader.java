package src;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends DataConstants {
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();
        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                String email = (String)personJSON.get(EMAIL);
                String password = (String)personJSON.get(PASSWORD);
				String userName = (String)personJSON.get(USERNAME);
				String firstName = (String)personJSON.get(FIRST_NAME);
				String lastName = (String)personJSON.get(LAST_NAME);
                UUID id = UUID.fromString((String)personJSON.get(USER_ID));

                users.add(new User(email, password, userName, firstName, lastName));
            }

            return users;
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public static ArrayList<Course> getCourses() {
        ArrayList<Course> courses = new ArrayList<Course>();
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray courseJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < courseJSON.size(); i++) {
                JSONObject coursesJSON = (JSONObject)courseJSON.get(i);
                String teacher = (String)coursesJSON.get(TEACHER);
                int difficulty = (int)coursesJSON.get(DIFFICULTY);
                ArrayList<Module> modules = (Module)coursesJSON.get(MODULES);
                ArrayList<Comment> comments = (Comment)coursesJSON.get(COMMENTS);
                Quiz endOfCourseQuiz = (Quiz)coursesJSON.get(END_OF_COURSE_QUIZ);
                String courseID = (String)coursesJSON.get(COURSE_ID);
                String userID = (String)coursesJSON.get(USER_ID);
            }

            return courses;
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
