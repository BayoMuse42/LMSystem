package src;
import java.util.ArrayList;
import java.util.UUID;

public class CourseList {
    private CourseList courseList;
    private ArrayList<Course> courses;

    private CourseList() {
    }
    
    public CourseList getInstance() {
        return courseList;
          
    }

    public Course getCourse(UUID courseID) {
        return null;
        
    }

    public void addCourse(UUID courseID) {

    }

    public void deleteCourse(UUID courseID){

    }
    
    public void editCourses(Course course){

    }
}
