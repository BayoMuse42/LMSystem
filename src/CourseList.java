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

    // TODO Either edit arguments for Course constructor 
    // OR figure out a way to get the courses based on the UUID alone
    public void addCourse(UUID teacherID, int difficulty, String name, UUID courseID, Quiz endOfCourseQuiz) {
        if(!hasCourse(name)) {
            courses.add(new Course(teacherID,difficulty,name,endOfCourseQuiz));
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

    public Course searchCourses(Teacher teacher) {
        for (Course c: courses){
            if (c.getTeacher().equals(teacher.getUserID())){
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
