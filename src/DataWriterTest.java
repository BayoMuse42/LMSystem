package src;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {

    private UserList users = UserList.getInstance();
	private ArrayList<User> userList = users.getUsers();
    private CourseList courses = CourseList.getInstance();
    private ArrayList<Course> courseList = courses.getCourses();

    @BeforeEach
	public void setup() {
		users.getInstance().getUsers().clear();
		DataWriter.saveUsers();
        courses.getInstance().getCourses().clear();
        DataWriter.saveCourses();
	}
	
	@AfterEach
	public void tearDown() {
		users.getInstance().getUsers().clear();
		DataWriter.saveUsers();
        courses.getInstance().getCourses().clear();
        DataWriter.saveCourses();
	}

    @Test
	void testWritingZeroUsers() {
		userList = DataLoader.getUsers();
		assertEquals(0, userList.size());
	}

    @Test
	void testWritingZeroCourses() {
		courseList = DataLoader.getCourses();
		assertEquals(0, courseList.size());
	}

    @Test
	void testWritingStudent() {
        UUID uuid = UUID. randomUUID();
		userList.add(new Student("email@gmail.com", "student123", "password", "Stud", "Ent", uuid));
		DataWriter.saveUsers();
		assertEquals("student123", DataLoader.getUsers().get(0).getUserName());
	}

    @Test
	void testWritingTeacher() {
        UUID uuid = UUID. randomUUID();
		userList.add(new Teacher("email@sc.edu", "teacher123", "password", "Teach", "Er", uuid));
		DataWriter.saveUsers();
		assertEquals("teacher123", DataLoader.getUsers().get(0).getUserName());
	}

    @Test
	void testWritingAdmin() {
        UUID uuid = UUID. randomUUID();
		userList.add(new Admin("email@admin.com", "admin123", "password", "Ad", "Min", uuid));
		DataWriter.saveUsers();
		assertEquals("admin123", DataLoader.getUsers().get(0).getUserName());
	}

    @Test
	void testWritingMultipleUsers() {
        UUID uuid = UUID. randomUUID();
		userList.add(new Student("email@gmail.com", "student123", "password", "Stud", "Ent", uuid));
        userList.add(new Student("email2@gmail.com", "student1234", "password", "Stu", "Dent", uuid));
        userList.add(new Teacher("email@sc.edu", "teacher123", "password", "Teach", "Er", uuid));
        userList.add(new Teacher("email2@sc.edu", "teacher1234", "password", "Tea", "Cher", uuid));
        userList.add(new Admin("email@admin.com", "admin123", "password", "Ad", "Min", uuid));
        userList.add(new Admin("email2@admin.com", "admin1234", "password", "A", "Dmin", uuid));
		DataWriter.saveUsers();
		assertEquals("student123", DataLoader.getUsers().get(0).getUserName());
	}

    @Test
	void testWritingOneCourse() {
        UUID uuid = UUID. randomUUID();
		ArrayList<Module> modules = new ArrayList<Module>();
        ArrayList<Comment> comments = new ArrayList<Comment>();
        ArrayList<Question> questions = new ArrayList<Question>();
        Quiz quiz = new Quiz(questions);
		courseList.add(new Course(uuid, 2, "Java tutorial", modules, comments, quiz, uuid, uuid));
		DataWriter.saveCourses();
		assertEquals(2, DataLoader.getCourses().get(0).getDifficulty());
	}

    @Test
	void testWritingMultipleCourse() {
        UUID uuid = UUID. randomUUID();
        ArrayList<Module> modules = new ArrayList<Module>();
        ArrayList<Comment> comments = new ArrayList<Comment>();
        ArrayList<Question> questions = new ArrayList<Question>();
        Quiz quiz = new Quiz(questions);
		courseList.add(new Course(uuid, 2, "Java tutorial", modules, comments, quiz, uuid, uuid));
        courseList.add(new Course(uuid, 3, "Python tutorial", modules, comments, quiz, uuid, uuid));
		DataWriter.saveCourses();
		assertEquals(2, DataLoader.getCourses().get(0).getDifficulty());
	}

    @Test
	void testWritingEmptyUser() {
        UUID uuid = UUID. randomUUID();
		userList.add(new Student("", "", "", "", "", uuid));
		DataWriter.saveUsers();
		assertEquals("", DataLoader.getUsers().get(0).getUserName());
	}
	
	@Test
	void testWritingNullUser() {
		userList.add(new Student(null, null, null, null, null, null));
		DataWriter.saveUsers();
		assertEquals(null, DataLoader.getUsers().get(0).getUserName());
	}

    @Test
    void testWritingNullCourse() {
        courseList.add(new Course(null, null, null, null, null, null, null, null));
        DataWriter.saveCourses();
		assertEquals(2, DataLoader.getCourses().get(0).getDifficulty());
    }

}