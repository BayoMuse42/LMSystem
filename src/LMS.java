package src;
import java.util.UUID;
import java.util.ArrayList;

public abstract class LMS {
  private User currentUser;
  private Course currentCourse;

  public boolean login(String username, String password) {

  }

  public void logout() {

  }

  public User createUser(String username, String email, String password, String firstName, String lastName, UUID userID) {

  }

  public User getUser(UUID userID) {

  }

  public void addUser(UUID userID) { 

  }

  public void deleteUser(UUID userID) {

  }

  public void editUser(User user) {

  }

  public Course createCourse(UUID teacher, int difficulty, String name) {

  }

  public Course getCourse(UUID courseID) {

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

  }

  public void deleteCourse(UUID courseID) {

  }

  public void editCourse(Course course) {

  }

  public abstract Course Search(Teacher teacher);

  public abstract Course Search(int difficulty);

  public abstract Course Search(String name);
}
