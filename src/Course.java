package src;
import java.util.UUID;
import java.util.ArrayList;

public class Course {

    private UUID Teacher;
    private int difficulty;
    private String name;
    private ArrayList<Module> modules;
    private ArrayList<Comment> comments;
    private Quiz endOfCourseQuiz;
    private double quizResult;
    private double courseProgress;
    public UUID courseID;
    public UUID userID;

    public Course(UUID Teacher, int difficulty, String name, ArrayList<Module> modules, ArrayList<Comment> comments, Quiz quiz, UUID courseID, UUID userID){
        this.Teacher = Teacher;
        this.difficulty = difficulty;
        this.name = name;
        this.modules = modules;
        this.comments = comments;
        this.endOfCourseQuiz = quiz;
        this.courseID = courseID;
        this.userID = userID;
    }

    public Course(UUID Teacher, int difficulty, String name, Quiz endOfCourseQuiz){
        this.Teacher = Teacher;
        this.difficulty = difficulty;
        this.name = name;
        this.endOfCourseQuiz = endOfCourseQuiz;
    }

    public void createModule(String name, String description){
        Module mod = new Module(name, description)
        modules.add(mod);

    }

    public Course searchCourses(Teacher teacher){
        CourseList clist = new CourseList();
        return clist.searchCourses(teacher);

    }

    public Course searchCourse(int difficulty){
        CourseList clist = new CourseList();
        return clist.searchCourses(difficulty);
         
    }

    public Course searchCourse(String name){
        CourseList clist = new CourseList();
        return clist.searchCourses(name);

    }

    public Course searchCourses(Course course){
        CourseList clist = new CourseList();
        return clist.searchCourses(course);

    }

    public double checkProgress(Course course){
        return courseProgress;
    }

    public boolean isComplete(){
        if(isComplete()) {
            return true;
        }
        return false;
    }

    public double getQuizResult(Quiz quiz){
        return this.quizResult;
    }

    public UUID getTeacher(){
        return this.Teacher;
    }

    public int getDifficulty(){
        return this.difficulty;
    }

    public String getName(){
        return this.name;
    }

    public Quiz getEndOfCourseQuiz(){
        return this.endOfCourseQuiz;
    }

    public ArrayList<Comment> getComments(){
        return this.comments;
    }

    public ArrayList<Module> getModules(){
        return this.modules;
    }

    public Module getModule(String name) {
        for(Module m : modules) {
            if(m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }

    public void removeModule(String modName) {

    }

    public UUID getCourseID(){
        return this.courseID;
    }

    public UUID getUserID(){
        return courseID;
    }

    public ArrayList<Section> getSections(){
        for (Module m: modules){
            return m.getSections();
        }
        return null;
    }
    
}
