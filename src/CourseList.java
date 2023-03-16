package src;
import java.util.ArrayList;

public class CourseList {
    private CourseList courseList;
    private ArrayList<Course> courses;

    private CourseList() {
    }
    
    public static CourseList getInstance() {
        return courseList;
          
    }
    public static Course getCourse(String UUID) {
        return null;
        
    }
    public void addCourse(String UUIDID) {

    }
    public void deleteCourse(String UUID){

    }
    public void editCourses(Course course){

    }
}
