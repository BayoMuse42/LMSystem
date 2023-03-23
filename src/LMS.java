package src;
import java.util.UUID;
import java.util.ArrayList;

public class LMS {
  private User currentUser;
  private Course currentCourse;
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

  public Course getCurrentCourse() {
    return currentCourse;
  }

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
    return courseList.getCourse(courseID);
  }

  public Course getCourse(UUID courseID) {
    return courseList.getCourse(courseID);
  }

  public Module getModule(UUID courseID) {

  }

  public Section getSection(UUID courseID) {
    currentCourse.getModule()
  }

  public Quiz getQuiz(UUID courseID) {
    return currentCourse.getQuiz;
  }

  public ArrayList<Course> getUserCourses(User user) {
    return currentUser.getCourses();
  }

  public void addCourse(UUID courseID) {
    courseList.addCourse(courseID);
  }

  public void deleteCourse(UUID courseID) {
    courseList.deleteCourse(courseID);
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
