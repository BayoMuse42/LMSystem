package src;
import java.util.ArrayList;
import java.util.UUID;

public class CourseList {
    private CourseList courseList;
    private ArrayList<Course> courses;

    private CourseList() {
    }
    
    public static CourseList getInstance() {
        return courseList;
          
    }
<<<<<<< HEAD
    public static Course getCourse(String UUID) {
        return null;
        
    }
    public void addCourse(String UUIDID) {

    }
    public void deleteCourse(String UUID){
=======

    public Course getCourse(UUID courseID) {
        return null;
        
    }

    public void addCourse(UUID courseID) {

    }

    public void deleteCourse(UUID courseID){
>>>>>>> 87461f49450027961b716beb13bebafcb3902310

    }
    
    public void editCourses(Course course){

    }
}
