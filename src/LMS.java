package src;
import java.util.UUID;
import java.util.ArrayList;

public abstract class LMS {
  private User currentUser;
  private Course currentCourse;

  public LMS() {
    currentUser = UserList.getInstance();
    currentCourse = CourseList.getInstance();
  }
  public boolean login(String username, String password) {

  }

  public void logout() {

  }

  public User createUser(String username, String email, String password, String firstName, String lastName, UUID userID) {

  }

  public User getUser(UUID userID) {
    return UserList.getUser(userID);
  }

  public void addUser(UUID userID) { 
    UserList.addUser(userID);
  }

  public void deleteUser(UUID userID) {
    UserList.deleteUser(userID);
  }

  public void editUser(User user) {
    UserList.editUser(user);
  }

  public Course createCourse(UUID teacher, int difficulty, String name) {

  }

  public Course getCourse(UUID courseID) {
    return CourseList.getCourse(courseID);
  }

  public Module getModule(UUID courseID) {

  }

  public Section getSection(UUID courseID) {

  }

  public Quiz getQuiz(UUID courseID) {

  }

  public ArrayList<Course> getUserCourses(User user) {
    
  }

  public void addCourse(UUID courseID) {
    CourseList.addCourse(courseID);
  }

  public void deleteCourse(UUID courseID) {
    CourseList.deleteCourse(courseID);
  }

  public void editCourse(Course course) {
    CourseList.editCourse(course);
  }

  public abstract Course Search(Teacher teacher);

  public abstract Course Search(int difficulty);

  public abstract Course Search(String name);
}
