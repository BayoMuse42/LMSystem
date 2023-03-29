package src;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    public static void saveUsers() {
		UserList users = UserList.getInstance();
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
		userDetails.put(USER_ID, user.getUserID().toString());
		userDetails.put(USERNAME, user.getUserName());
		userDetails.put(FIRST_NAME, user.getFirstName());
		userDetails.put(LAST_NAME, user.getLastName());
		userDetails.put(PASSWORD, user.getPassword().toString());
		userDetails.put(TYPE, user.getType());
        
        return userDetails;
	}

    public static void saveCourses() {
		CourseList courses = CourseList.getInstance();
		ArrayList<Course> courseList = courses.getCourses();
		JSONArray jsonCourses = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< courseList.size(); i++) {
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

    public static JSONObject getCourseJSON(Course course) {
		JSONObject courseDetails = new JSONObject();
		courseDetails.put(TEACHER, course.getTeacher().toString());
		courseDetails.put(DIFFICULTY, course.getDifficulty());
		courseDetails.put(NAME, course.getName());

		JSONArray moduleArrayJSON = new JSONArray();
		for(Module m : course.getModules()) {
			JSONObject moduleJSON = new JSONObject();
			moduleJSON.put(NAME, m.getName());
			moduleJSON.put(DESCRIPTION, m.getDescription());

			JSONObject quizJSON = new JSONObject();
			JSONObject questionJSON = new JSONObject();
			JSONArray moduleQuizQuestions = new JSONArray();
			for(Question q : m.getQuiz().getQuestions()) {
				questionJSON.put(ASK, q.getAsk());
				questionJSON.put(ANSWER, q.getAnswer());
				questionJSON.put(POTENTIAL_ANSWERS, q.getPotentialAnswers());
				moduleQuizQuestions.add(questionJSON);
			}
			quizJSON.put(QUESTION, questionJSON);
			quizJSON.put(QUIZ_RESULT, m.getQuiz().getQuizResult());
			moduleJSON.put(QUIZ, quizJSON);

			for(Section s : course.getSections()) {
				JSONObject sectionJSON = new JSONObject();
				sectionJSON.put(NAME, s.getName());
				sectionJSON.put(CONTENT, s.getContent());
				moduleJSON.put(SECTIONS, sectionJSON);
			}

			moduleArrayJSON.add(moduleJSON);
			
		}
		courseDetails.put(MODULES, moduleArrayJSON);

		//courseDetails.put(COMMENTS, course.getComments());
		JSONArray commentArrayJSON = new JSONArray();
		for(Comment c : course.getComments()) {
			JSONObject commentJSON = new JSONObject();
			commentJSON.put(USER_ID, c.getUserID());
			commentJSON.put(MESSAGE, c.getMessage());
			for(Comment cReply : c.getReplies()) {
				JSONObject commentReplyJSON = new JSONObject();
				commentReplyJSON.put(USER_ID, cReply.getUserID());
				commentReplyJSON.put(MESSAGE, cReply.getMessage());
				commentJSON.put(REPLY, commentReplyJSON);
			}

			//courseDetails.put(COMMENTS, commentJSON);
			commentArrayJSON.add(commentJSON);
		}
		courseDetails.put(COMMENTS, commentArrayJSON);

		//courseDetails.put(END_OF_COURSE_QUIZ, course.getEndOfCOurseQuiz().toString());
		JSONObject endQuizJSON = new JSONObject();
		JSONObject endQuestionsJSON = new JSONObject();
		JSONArray endQuizQuestions = new JSONArray();
		for(Question q : course.getEndOfCourseQuiz().getQuestions()) {
			endQuestionsJSON.put(ASK, q.getAsk());
			endQuestionsJSON.put(ANSWER, q.getAnswer());
			endQuestionsJSON.put(POTENTIAL_ANSWERS, q.getPotentialAnswers());
			endQuizQuestions.add(endQuestionsJSON);
		}
		endQuizJSON.put(QUESTION, endQuizQuestions);
		endQuizJSON.put(QUIZ_RESULT, course.getEndOfCourseQuiz().getQuizResult());
		courseDetails.put(END_OF_COURSE_QUIZ, endQuizJSON);
        courseDetails.put(COURSE_ID, course.getCourseID());
        courseDetails.put(USER_ID, course.getUserID());
        
        return courseDetails;
	}
}
