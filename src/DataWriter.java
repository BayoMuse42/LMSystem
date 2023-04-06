package src;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
	/**
	 * Save users to ArrayList then add user data to JSON file
	 */
    public static void saveUsers() {
		UserList users = UserList.getInstance();
		ArrayList<User> userList = users.getUsers();
		JSONArray jsonUsers = new JSONArray();
		
		/**
		 * Create the JSON object
		 */
		for(int i=0; i< userList.size(); i++) {
			jsonUsers.add(getUserJSON(userList.get(i)));
		}
		
		/**
		 * Write to JSON file
		 */
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	/**
	 * It takes an instance of user, extracts data, then stores in a JSON file
	 * @param user
	 * @return a JSONObject for JSON file
	 */
    public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
		userDetails.put(USER_ID, user.getUserID().toString());
		userDetails.put(USERNAME, user.getUserName());
		userDetails.put(FIRST_NAME, user.getFirstName());
		userDetails.put(LAST_NAME, user.getLastName());
		userDetails.put(PASSWORD, user.getPassword());
		userDetails.put(TYPE, user.getType());
        
        return userDetails;
	}
	/**
	 * Save courses to an ArrayList then add to JSON file
	 */
    public static void saveCourses() {
		CourseList courses = CourseList.getInstance();
		ArrayList<Course> courseList = courses.getCourses();
		JSONArray jsonCourses = new JSONArray();
		
		/**
		 * Create all JSON objects
		 */
		for(int i=0; i< courseList.size(); i++) {
			jsonCourses.add(getCourseJSON(courseList.get(i)));
		}
		
		/**
		 * Write to JSON file
		 */
        try (FileWriter file = new FileWriter(COURSE_FILE_NAME)) {
 
            file.write(jsonCourses.toJSONString());
            file.flush();
 
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	/**
	 * It takes an instance of course, extracts data, then stores in a JSON file
	 * @param course
	 * @return JSONObject for JSON file
	 */
    public static JSONObject getCourseJSON(Course course) {
		JSONObject courseDetails = new JSONObject();
		courseDetails.put(TEACHER, course.getTeacher().toString());
		courseDetails.put(DIFFICULTY, course.getDifficulty());
		courseDetails.put(NAME, course.getName());
		/**
		 * Extract module data
		 */
		JSONArray moduleArrayJSON = new JSONArray();
		for(Module m : course.getModules()) {
			JSONObject moduleJSON = new JSONObject();
			moduleJSON.put(NAME, m.getName());
			moduleJSON.put(DESCRIPTION, m.getDescription());
			/**
			 * Extract module quiz data
			 */
			JSONObject quizJSON = new JSONObject();
			JSONObject questionJSON = new JSONObject();
			JSONArray moduleQuizQuestions = new JSONArray();
			for(Question q : m.getQuiz().getQuestions()) {
				questionJSON.put(ASK, q.getAsk());
				questionJSON.put(ANSWER, q.getAnswer());
				JSONArray potAnsJSON = new JSONArray();
				for(String pa : q.getPotentialAnswers()) {
					potAnsJSON.add(pa);
				}
				questionJSON.put(POTENTIAL_ANSWERS, potAnsJSON);
				moduleQuizQuestions.add(questionJSON);
			}
			quizJSON.put(QUESTION, questionJSON);
			quizJSON.put(QUIZ_RESULT, m.getQuiz().getQuizResult());
			moduleJSON.put(QUIZ, quizJSON);
			/**
			 * Extract section data
			 */
			JSONArray sectionArrayJSON = new JSONArray();
			for(Section s : course.getSections()) {
				JSONObject sectionJSON = new JSONObject();
				sectionJSON.put(NAME, s.getName());
				sectionJSON.put(CONTENT, s.getContent());
				sectionArrayJSON.add(sectionJSON);
			}
			moduleJSON.put(SECTIONS, sectionArrayJSON);
			moduleArrayJSON.add(moduleJSON);
			
		}
		courseDetails.put(MODULES, moduleArrayJSON);
		/**
		 * Extract comment data
		 */
		JSONArray commentArrayJSON = new JSONArray();
		for(Comment c : course.getComments()) {
			JSONObject commentJSON = new JSONObject();
			commentJSON.put(USER_ID, c.getUserID().toString());
			commentJSON.put(MESSAGE, c.getMessage());
			for(Comment cReply : c.getReplies()) {
				JSONObject commentReplyJSON = new JSONObject();
				commentReplyJSON.put(USER_ID, cReply.getUserID().toString());
				commentReplyJSON.put(MESSAGE, cReply.getMessage());
				commentJSON.put(REPLY, commentReplyJSON);
			}

			commentArrayJSON.add(commentJSON);
		}
		courseDetails.put(COMMENTS, commentArrayJSON);
		/**
		 * Extract end of course quiz data
		 */
		JSONObject endQuizJSON = new JSONObject();
		JSONObject endQuestionsJSON = new JSONObject();
		JSONArray endQuizQuestions = new JSONArray();
		for(Question q : course.getEndOfCourseQuiz().getQuestions()) {
			endQuestionsJSON.put(ASK, q.getAsk());
			endQuestionsJSON.put(ANSWER, q.getAnswer());
			JSONArray potAnsJSON = new JSONArray();
			for(String pa : q.getPotentialAnswers()) {
				potAnsJSON.add(pa);
			}
			endQuestionsJSON.put(POTENTIAL_ANSWERS, potAnsJSON);
			endQuizQuestions.add(endQuestionsJSON);
		}
		endQuizJSON.put(QUESTION, endQuizQuestions);
		endQuizJSON.put(QUIZ_RESULT, course.getEndOfCourseQuiz().getQuizResult());
		courseDetails.put(END_OF_COURSE_QUIZ, endQuizJSON);
		/**
		 * Extract ID data
		 */
        courseDetails.put(COURSE_ID, course.getCourseID().toString());
        courseDetails.put(USER_ID, course.getUserID().toString());
        
        return courseDetails;
	}
}
