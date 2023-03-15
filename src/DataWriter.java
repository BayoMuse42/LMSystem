package src;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    public static void saveUsers() {
		User users = User.getInstance();
		ArrayList<User> userList = users.getUsers();
		JSONArray jsonUsers = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< userList.size(); i++) {
			jsonUsers.add(getUserJSON(userList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}

    public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
		userDetails.put(USER_ID, user.getId().toString());
		userDetails.put(USERNAME, user.getUserName());
		userDetails.put(FIRST_NAME, user.getFirstName());
		userDetails.put(LAST_NAME, user.getLastName());
		userDetails.put(PASSWORD, user.getPassword().toString());
        
        return userDetails;
	}

    public static void saveCourses() {
		Course courses = Course.getInstance();
		ArrayList<User> courseList = courses.getCourses();
		JSONArray jsonCourses = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< CourseList.size(); i++) {
			jsonCourses.add(getCourseJSON(courseList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(COURSE_FILE_NAME)) {
 
            file.write(jsonCourses.toJSONString());
            file.flush();
 
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}

    public static JSONObject getUserJSON(User user) {
		JSONObject courseDetails = new JSONObject();
		courseDetails.put(TEACHER, user.getTeacher().toString());
		courseDetails.put(DIFFICULTY, user.getDifficulty());
		courseDetails.put(MODULES, user.getModule());
		courseDetails.put(COMMENTS, user.getComments());
		courseDetails.put(END_OF_COURSE_QUIZ, user.getEndOfCOurseQuiz().toString());
        courseDetails.put(QUIZ_RESULT, user.getQuizResult());
        courseDetails.put(COURSE_ID, user.getCourseID());
        courseDetails.put(USER_ID, user.getUser());
        
        return courseDetails;
	}
}
