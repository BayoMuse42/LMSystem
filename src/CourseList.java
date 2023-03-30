package src;
import java.util.ArrayList;
import java.util.UUID;

public class CourseList {
    private static CourseList courseList;
    public ArrayList<Course> courses;

<<<<<<< HEAD
    /**
     * Constructor
     */
    public CourseList() {
=======
    private CourseList() {
>>>>>>> 72dc240617bf1ed037468cbcf89ee6f6cc8f2ba7
        courses = DataLoader.getCourses();
    }
    
    /**
     * 
     * @return instance of courselist
     */
    public static CourseList getInstance() {
        if(courseList == null) {
            courseList = new CourseList();
        }

        return courseList;
    }
    
    /**
     * 
     * @param courseName
     * @return boolean
     * Checks of course is listed under user
     */
    public boolean hasCourse(String courseName) {
        for(Course course: courses) {
            if(course.getName().equals(courseName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param courseName
     * @return
     */
    public Course getCourse(String courseName) {
        for(Course course: courses) {
            if(course.getName().equals(courseName)) {
                return course;
            }
        }
        return null;
        
    }

    /**
     * 
     * @return ArrayList of courses
     */
    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    /**
     * 
     * @param teacherID
     * @param difficulty
     * @param name
     * @param courseID
     * adds course to courses arraylist
     */
    public void addCourse(UUID teacherID, int difficulty, String name, UUID courseID) {
        if(!hasCourse(name)) {
            courses.add(new Course(teacherID,difficulty,name));
        }
    }

    /**
     * 
     * @param name
     * deletes course based on name
     */
    public void deleteCourse(String name) {
        if(!hasCourse(name)) {
            courses.remove(getCourse(name));
        }
    }

    /**
     * 
     * @param teacher
     * @return ArrayList of courses based on teacher 
     */
    public ArrayList<Course> searchCourses(User teacher) {
        ArrayList<Course> results = new ArrayList<Course>();
        for (Course c: courses){
            if (c.getTeacher().equals(teacher.getUserID())){
                results.add(c);
            }
        };
        return results;
    }

    /**
     * 
     * @param difficulty
     * @return ArrayList of courses based on difficulty 
     */
    public ArrayList<Course> searchCourses(int difficulty) {
        ArrayList<Course> results = new ArrayList<Course>();
        for (Course c: courses){
            if (c.getDifficulty() == difficulty){
                results.add(c);
            }
        }
        return results;
    }

    /**
     * 
     * @param name
     * @return arrayList of courses based on course name
     */
    public ArrayList<Course> searchCourses(String name) {
        ArrayList<Course> results = new ArrayList<Course>();
        for (Course c: courses){
            if (c.getName().equals(name)){
                results.add(c);
            }
        }
        return results;
    }

    /**
     * 
     * @param userID
     * @return ArrayList of courses based on userID
     */
    public ArrayList<Course> getUserCourses(UUID userID){
        ArrayList<Course> userCourses = new ArrayList<Course>();
        for (Course c: courses){
            if (c.userID.equals(userID)){
                userCourses.add(c);
            }
        }
        return userCourses;
    }
}
