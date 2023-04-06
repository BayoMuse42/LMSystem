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

    /**
     * 
     * @param Teacher
     * @param difficulty
     * @param name
     * @param modules
     * @param comments
     * @param quiz
     * @param courseID
     * @param userID
     * Course Constructor 
     */
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

    /**
     * 
     * @param Teacher
     * @param difficulty
     * @param name
     * Overloaded constructor
     */
    public Course(UUID Teacher, int difficulty, String name){
        this.Teacher = Teacher;
        this.difficulty = difficulty;
        this.name = name;
    }

    /**
     * 
     * @param name
     * @param description
     * Creates module and adds to arraylist of modules
     */
    public void createModule(String name, String description){
        Module mod = new Module(name, description);
        modules.add(mod);

    }

    /**
     * 
     * @param teacher
     * @return ArrayList of courses created by teacher
     */
    public ArrayList<Course> searchCourses(Teacher teacher){
        return CourseList.getInstance().searchCourses(teacher);

    }

    /**
     * 
     * @param difficulty
     * @return Arraylist of courses selected by difficulty
     */
    public ArrayList<Course> searchCourse(int difficulty){
        return CourseList.getInstance().searchCourses(difficulty);
         
    }

    /**
     * 
     * @param name
     * @return Arraylist of courses based on course name
     */
    public ArrayList<Course> searchCourse(String name){
        return CourseList.getInstance().searchCourses(name);

    }

    /**
     * 
     * @return double representing users progress on course
     */
    public double checkProgress() {
        int count = 0;
        for(Module m : modules) {
            if(m.isComplete()) {
                count++;
            }
            calcProgress(count);
        }
        return courseProgress;
    }

    /**
     * 
     * @param numCorrect
     * Calculates user progress
     */
    public void calcProgress(int numCorrect) {
        courseProgress = (double) numCorrect/(double)modules.size();
        courseProgress = (courseProgress)*100;
    }

    /**
     * 
     * @return boolean 
     * Checks if user has completed a course
     */
    public boolean isComplete() {
        if(courseProgress == 100) {
            return true;
        }
        return false;
    }

    /**
     * 
     * @param quiz
     * @return double 
     * Gets result of endOfCourseQuiz
     */
    public double getQuizResult(Quiz quiz){
        return this.quizResult;
    }

    /**
     * 
     * @return UUID of teacher who created course
     */
    public UUID getTeacher(){
        return this.Teacher;
    }

    /**
     * 
     * @return course difficulty
     */
    public int getDifficulty(){
        return this.difficulty;
    }

    /**
     * 
     * @return String of courses name
     */
    public String getName(){
        return this.name;
    }

    /**
     * 
     * @return endOfCourseQuiz
     */
    public Quiz getEndOfCourseQuiz(){
        return this.endOfCourseQuiz;
    }

    /**
     * 
     * @param quiz 
     * sets the endOfCourseQuiz
     */
    public void setQuiz(Quiz quiz) {
        endOfCourseQuiz = quiz;
    }

    /**
     * 
     * @return ArrayList of comments left on course
     */
    public ArrayList<Comment> getComments(){
        return this.comments;
    }

    /**
     * 
     * @param userID
     * @param message
     * Adds comment to arraylist of comments on course
     */
    public void addComment(UUID userID, String message) {
        comments.add(new Comment(userID, message));
    }

    /**
     * 
     * @return Arraylist of modules listed under course
     */
    public ArrayList<Module> getModules(){
        return this.modules;
    }

    /**
     * 
     * @param name
     * @return module based on module name
     */
    public Module getModule(String name) {
        for(Module m : modules) {
            if(m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }

    /**
     * 
     * @param modName
     * Removes module based on modules name
     */
    public void removeModule(String modName) {
        for (Module m: modules){
            if (m.getName().equals(modName)){
                modules.remove(m);
            }
        }
    }

    /**
     * 
     * @return UUID of course ID
     */
    public UUID getCourseID(){
        return this.courseID;
    }

    /**
     * 
     * @return UUId of user id
     */ 
    public UUID getUserID(){
        return userID;
    }

    /**
     * 
     * @return ArrayList of sections under courses modules
     */
    public ArrayList<Section> getSections(){
        for (Module m: modules){
            return m.getSections();
        }
        return null;
    }

<<<<<<< HEAD
<<<<<<< HEAD
    public String toString(){
        return courseID + " is the course." ; 
=======
=======
>>>>>>> f7379d5d6f36f433aadafc73e91f259b21ef071c
    /**
     * @return String description of course
     */
    public String toString() {
        return "Teacher ID: " + Teacher + " Difficulty: " + difficulty + " Course Name: " + name
        + " Quiz Result: " + quizResult + " Course Progress: " + courseProgress + " Course ID: " 
        + courseID + " UserID: " + userID;
<<<<<<< HEAD
>>>>>>> f7379d5d6f36f433aadafc73e91f259b21ef071c
=======
>>>>>>> f7379d5d6f36f433aadafc73e91f259b21ef071c
    }
}
