package src;
import java.util.ArrayList;
import java.util.UUID;

public class CourseList {
    private static CourseList courseList;
    private ArrayList<Course> courses;

    private CourseList() {
        courses = DataLoader.getCourses();
    }
    
    public static CourseList getInstance() {
        if(courseList == null) {
            courseList = new CourseList();
        }

        return courseList;
          
    }
    
    public boolean hasCourse(UUID courseID) {
        for(Course course: courses) {
            if(course.getCourseID().equals(courseID)) {
                return true;
            }
        }
        return false;
    }

    public Course getCourse(UUID courseID) {
        for(Course course: courses) {
            if(course.getCourseID().equals(courseID)) {
                return course;
            }
        }
        return null;
        
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    // TODO Either edit arguments for Course constructor 
    // OR figure out a way to get the courses based on the UUID alone
    public void addCourse(UUID courseID) {
        if(!hasCourse(courseID)) {
            courses.add(new Course());
        }
    }

    public void deleteCourse(UUID courseID) {
        if(!hasCourse(courseID)) {
            courses.remove(getCourse(courseID));
        }
    }
    
    //TODO
    public void editCourse(Course course){

    }

    public Course searchCourses(Teacher teacher) {
        for (Course c: courses){
            if (c.getTeacher().equals(teacher)){
                return c;
            }
        };
        return null;

    }

    public Course searchCourses(int difficulty) {
        for (Course c: courses){
            if (c.getDifficulty() == difficulty){
                return c;
            }
        }
        return null;
    }

    public Course searchCourses(String name) {
        for (Course c: courses){
            if (c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }
}
