package src;
import java.util.UUID;
import java.util.ArrayList;

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

  // TODO Differenciate between student, teacher, and admin
  public User createUser(String username, String email, String password, String firstName, String lastName) {
    UUID userID = UUID.randomUUID();
    userList.addUser(username, email, password, firstName, lastName, userID);
    return userList.getUser(userID);
  
  }

  public User getUser(UUID userID) {
    return userList.getUser(userID);
  }

  public void addUser(UUID userID) { 
    userList.addUser(userID);
  }

  public void deleteUser(UUID userID) {
    userList.deleteUser(userID);
  }

  public void editUser(User user) {
    userList.editUser(user);
  }

  public Course createCourse(UUID teacher, int difficulty, String name) {
    UUID courseID = UUID.randomUUID();
    courseList.addCourse(teacher, difficulty, name, courseID);
    return courseList.getCourse(name);
  }

  public Course getCourse(String name) {
    return courseList.getCourse(name);
  }

  public Module getModule(UUID courseID) {
    return currentCourse.getModule();
  }

  public Section getSection(UUID courseID) {
    return currentCourse.getModule().getSection();
  }

  public Quiz getQuiz(UUID courseID) {
    return currentCourse.getQuiz();
  }

  public ArrayList<Course> getUserCourses(User user) {
    return currentUser.getCourses();
  }

  public void addCourse(UUID teacherID, int difficulty, String name, UUID courseID) {
    courseList.addCourse(teacherID, difficulty, name, courseID);
  }

  public void deleteCourse(String courseName) {
    courseList.deleteCourse(courseName);
  }

  public void editCourse(Course course) {
    courseList.editCourse(course);
  }

  public Course Search(Teacher teacher) {
    return courseList.searchCourses(teacher);
  }

  public Course Search(int difficulty) {
    return courseList.searchCourses(difficulty);
  }

  public Course Search(String name) {
    return courseList.searchCourses(name);
  }
}
