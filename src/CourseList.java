package src;
import java.util.ArrayList;
import java.util.UUID;

public class CourseList {
    private static CourseList courseList;
    public ArrayList<Course> courses;

    public CourseList() {
        courses = DataLoader.getCourses();
    }
    
    public static CourseList getInstance() {
        if(courseList == null) {
            courseList = new CourseList();
        }

        return courseList;
          
    }
    
    public boolean hasCourse(String courseName) {
        for(Course course: courses) {
            if(course.getName().equals(courseName)) {
                return true;
            }
        }
        return false;
    }

    public Course getCourse(String courseName) {
        for(Course course: courses) {
            if(course.getName().equals(courseName)) {
                return course;
            }
        }
        return null;
        
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public void addCourse(UUID teacherID, int difficulty, String name, UUID courseID) {
        if(!hasCourse(name)) {
            courses.add(new Course(teacherID,difficulty,name));
        }
    }

    public void deleteCourse(String name) {
        if(!hasCourse(name)) {
            courses.remove(getCourse(name));
        }
    }
    
    
    //TODO
    public void editCourse(Course course){

    }

    public ArrayList<Course> searchCourses(User teacher) {
        ArrayList<Course> results = new ArrayList<Course>();
        for (Course c: courses){
            if (c.getTeacher().equals(teacher.getUserID())){
                results.add(c);
            }
        };
        return results;
    }

    public ArrayList<Course> searchCourses(int difficulty) {
        ArrayList<Course> results = new ArrayList<Course>();
        for (Course c: courses){
            if (c.getDifficulty() == difficulty){
                results.add(c);
            }
        }
        return results;
    }

    public ArrayList<Course> searchCourses(String name) {
        ArrayList<Course> results = new ArrayList<Course>();
        for (Course c: courses){
            if (c.getName().equals(name)){
                results.add(c);
            }
        }
        return results;
    }

    // Do we need this? -RB
    public Course searchCourses(Course course){
        for (Course c: courses){
            if (c.getCourseID().equals(course.getCourseID())){
                return c;
            }
        }
        return null;
    }
}
