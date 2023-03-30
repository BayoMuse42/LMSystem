package src;
import java.util.UUID;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException; 

public class LMS {
  private User currentUser;
  private Course currentCourse;
  private Module currentModule;
  private Section currentSection;
  private Quiz currentQuiz;
  private UserList userList;
  private CourseList courseList;

  public LMS() {
    userList = UserList.getInstance();
    courseList = CourseList.getInstance();
  }

  public boolean login(String username, String password) {
    if(!userList.hasUser(username)) {
      return false;
    }
    User temp = userList.getUser(username);
    if(temp.getPassword().equals(password)) {
      currentUser = userList.getUser(username);
      return true;
    }
    return false;
  }

  public void logout() {
    currentUser = null;
  }

  public User getCurrentUser() {
    return currentUser;
  }

  public void setCurrentUser(String name) {
    this.currentUser = userList.getUser(name);
  }

  public Course getCurrentCourse() {
    return currentCourse;
  }

  public void setCurrentCourse(String name) {
    this.currentCourse = courseList.getCourse(name);
  }

  public Module getCurrentModule() {
    return currentModule;
  }

  public void setCurrentModule(String name) {
    this.currentModule = currentCourse.getModule(name);
  }

  public Section getCurrentSection() {
    return currentSection;
  }

  public void setCurrentSection(String name) {
    this.currentSection = currentModule.getSection(name);
  }

  public Quiz getCurrentQuiz(String Coursename, boolean isEndCourse) {
   return currentQuiz;
  }

  public void setCurrentQuiz(String name, boolean isEndCourse) {
    if(isEndCourse)
      this.currentQuiz = getCurrentCourse().getEndOfCourseQuiz();
    this.currentQuiz = getCurrentModule().getQuiz();
  }

  public User createUser(String username, String email, String password, String firstName, String lastName, String type) {
    UUID userID = UUID.randomUUID();
    userList.addUser(username, email, password, firstName, lastName, userID, type);
    return userList.getUser(userID);
  
  }

  public User getUser(UUID userID) {
    return userList.getUser(userID);
  }

  public User getUser(String name) {
    return userList.getUser(name);
  }

  public void addUser(String userName, String email, String password, String firstName, String lastName, UUID userID, String type) { 
    userList.addUser(userName, email, password, firstName, lastName, userID, type);
  }

  public void deleteUser(UUID userID) {
    userList.deleteUser(userID);
  }

  public Course createCourse(UUID teacher, int difficulty, String name) {
    UUID courseID = UUID.randomUUID();
    courseList.addCourse(teacher, difficulty, name, courseID);
    return courseList.getCourse(name);
  }

  public Course getCourse(String name) {
    return courseList.getCourse(name);
  }

  public Module getModule(String name) {
    return currentCourse.getModule(name);
  }

  public Section getSection(String name) {
    return currentModule.getSection(name);
  }

  public Quiz getQuiz(String name, boolean isEndCourse) {
    if(isEndCourse)
      return currentCourse.getEndOfCourseQuiz();
    return currentModule.getQuiz();
  }

  public void addQuiz(Quiz quiz) {
    currentCourse.setQuiz(quiz);
  }

  public ArrayList<Course> getUserCourses(User user) {
    return currentUser.getUserCourses();
  }

  public void addUserCourses(String name) {
    Course c = getCourse(name);
    currentUser.getUserCourses().add(c);
  }

  public void addCourse(UUID teacherID, int difficulty, String name, UUID courseID) {
    courseList.addCourse(teacherID, difficulty, name, courseID);
  }

  public void deleteCourse(String courseName) {
    courseList.deleteCourse(courseName);
  }

  public ArrayList<Course> Search(User teacher) {
    return courseList.searchCourses(teacher);
  }

  public ArrayList<Course> Search(int difficulty) {
    return courseList.searchCourses(difficulty);
  }

  public ArrayList<Course> Search(String name) {
    return courseList.searchCourses(name);
  }

  public void printCertificate(String courseName) {
    try {
        FileWriter certWriter = new FileWriter("Certificate.txt");
        certWriter.write("---- Certificate of Completion ----\n");
        certWriter.write("This certifies that\n");
        certWriter.write(currentUser.getFirstName() + currentUser.getLastName() + "\n");
        certWriter.write("Has completed " + courseName + "\n");
        certWriter.close();
        System.out.println("Certificate successfully created!");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      } 
}

  public void printModule() {
    currentModule.printContent();
  }
}
