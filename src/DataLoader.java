package src;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends DataConstants {
    public static void main(String[] args) {
        ArrayList<User> testUsers = getUsers();
        for(User u : testUsers) {
            System.out.println(u.toString());
        }
        ArrayList<Course> testCourses = getCourses();
        for(Course c : testCourses) {
            System.out.println(c.toString());
        }
    } 
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);	
			JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                String email = (String)personJSON.get(EMAIL);
                String password = (String)personJSON.get(PASSWORD);
				String userName = (String)personJSON.get(USERNAME);
				String firstName = (String)personJSON.get(FIRST_NAME);
				String lastName = (String)personJSON.get(LAST_NAME);
                UUID id = UUID.fromString((String)personJSON.get(USER_ID));
                String type = (String)personJSON.get(TYPE);
                switch(type) {
                    case "teacher":
                        users.add(new Teacher(email, userName, password, firstName, lastName, id));
                        break;
                    case "student":
                        users.add(new Student(email, userName, password, firstName, lastName, id));
                        break;
                    case "admin":
                        users.add(new Admin(email, userName, password, firstName, lastName, id));
                    default:
                        break;
                }
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
            FileReader reader = new FileReader(COURSE_FILE_NAME);
			JSONArray courseJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < courseJSON.size(); i++) {
                JSONObject coursesJSON = (JSONObject)courseJSON.get(i);
                UUID teacher = UUID.fromString((String)coursesJSON.get(TEACHER));
                int difficulty = ((Long)coursesJSON.get(DIFFICULTY)).intValue();
                String name = (String)coursesJSON.get(NAME);
                JSONArray jsonModules = (JSONArray)coursesJSON.get(MODULES);
                ArrayList<Module> modules = new ArrayList<>();

                for(int j=0; j<jsonModules.size(); j++){
                    JSONObject moduleJSON = (JSONObject)jsonModules.get(j);
                    String nameModule = (String)moduleJSON.get(NAME);
                    String description = (String)moduleJSON.get(DESCRIPTION);

                    JSONArray jsonQuiz = (JSONArray)moduleJSON.get(QUIZ);
                    ArrayList<Question> quizQuestions = new ArrayList<Question>();
                    ArrayList<Quiz> quiz = new ArrayList<Quiz>();
                    for(int a = 0; a < jsonQuiz.size(); a++) {
                        JSONObject quizJSON = (JSONObject)jsonQuiz.get(a);
                        JSONArray jsonQuestion = (JSONArray)quizJSON.get(QUESTION);
                        for(int b = 0; b < jsonQuestion.size(); b++) {
                            JSONObject questionJSON = (JSONObject)jsonQuestion.get(b);
                            String ask = (String)questionJSON.get(ASK);
                            int answer = ((Long)questionJSON.get(ANSWER)).intValue();
                            ArrayList<String> potentialAnswers = new ArrayList<String>();
                            JSONArray jsonPotAns = (JSONArray)questionJSON.get(POTENTIAL_ANSWERS);
                            for(int c = 0; c < jsonPotAns.size() - 1; c++) {
                                //JSONObject potAnsJSON = (JSONObject)jsonPotAns.get(c);
                                //String potAns = (String)potAnsJSON
                                potentialAnswers.add((String)jsonPotAns.get(c));
                            }
                            //String[] potentialAnswers = (String[])questionJSON.get(POTENTIAL_ANSWERS);
                            quizQuestions.add(new Question(ask, answer, potentialAnswers));
                        }
                        
                        quiz.add(new Quiz(quizQuestions));
                    }

                    //make a module
                    Module module = new Module(nameModule, description);

                    JSONArray jsonSection = (JSONArray)moduleJSON.get(SECTIONS);
                    for(int b = 0; b < jsonSection.size(); b++) {
                        JSONObject sectionJSON = (JSONObject)jsonModules.get(b);
                        String nameSection = (String)sectionJSON.get(NAME);
                        String content = (String)sectionJSON.get(CONTENT);
                        module.createSection(nameSection, content);
                    }

                    // add it to the modules
                    modules.add(module);
                }

                JSONArray jsonComments = (JSONArray)coursesJSON.get(COMMENTS);
                ArrayList<Comment> comments = new ArrayList<Comment>();
                ArrayList<Comment> replyComments = new ArrayList<Comment>();
                for(int a = 0; a < jsonComments.size(); a++) {
                    JSONObject commentJSON = (JSONObject)jsonComments.get(a);
                    UUID userID = UUID.fromString((String)commentJSON.get(USER_ID));
                    String message = (String)commentJSON.get(MESSAGE);

                    JSONArray jsonReply = (JSONArray)commentJSON.get(REPLY);
                    for(int b = 0; b < jsonReply.size(); b++) {
                        JSONObject replyJSON = (JSONObject)jsonReply.get(b);
                        UUID userIDR = UUID.fromString((String)replyJSON.get(USERID));
                        String messageR = (String)replyJSON.get(MESSAGE);
                        replyComments.add(new Comment(userIDR, messageR));
                    }

                    comments.add(new Comment(userID, message, replyComments));

                }

                ArrayList<Quiz> quiz = new ArrayList<Quiz>();
                ArrayList<Question> endQuizQuestions = new ArrayList<Question>();
                JSONArray jsonEndOfCourseQuiz = (JSONArray)coursesJSON.get(END_OF_COURSE_QUIZ);
                for(int j = 0; j < jsonEndOfCourseQuiz.size(); j++) {
                    JSONObject endQuizJSON = (JSONObject)jsonEndOfCourseQuiz.get(j);
                    JSONArray jsonQuestion = (JSONArray)endQuizJSON.get(QUESTION);
                    for(int a = 0; a < jsonQuestion.size(); a++) {
                        JSONObject questionJSON = (JSONObject)jsonQuestion.get(a);
                        String ask = (String)questionJSON.get(ASK);
                        int answer = ((Long)questionJSON.get(ANSWER)).intValue();
                        ArrayList<String> potentialAnswers = new ArrayList<String>();
                        JSONArray jsonPotAnsEnd = (JSONArray)questionJSON.get(POTENTIAL_ANSWERS);
                        for(int b = 0; b < jsonPotAnsEnd.size() - 1; b++) {
                            potentialAnswers.add((String)jsonPotAnsEnd.get(b));
                        }
                        //String[] potentialAnswers = (String[])questionJSON.get(a);
                        endQuizQuestions.add(new Question(ask, answer, potentialAnswers));
                    }
                    quiz.add(new Quiz(endQuizQuestions));
                }

                UUID courseID = UUID.fromString((String)coursesJSON.get(COURSE_ID));
                UUID userID = UUID.fromString((String)coursesJSON.get(USER_ID));

                System.out.println("add course");

                courses.add(new Course(teacher, difficulty, name, modules, comments, quiz.get(0), courseID, userID));
            }

            return courses;
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
