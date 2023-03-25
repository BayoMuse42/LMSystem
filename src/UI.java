package src;

import java.util.Scanner;
import java.util.ArrayList;

public class UI {
  private static final String WELCOME_HEADER = "---- Coding Learning Management System ----";
  private static final String LOGIN_HEADER = "---- Login ----";
  private static final String REGISTER_HEADER = "---- Register ----";
  private static final String CREATE_HEADER = "---- Course Creation ----";
  private static final String COURSE_HEADER = "---- Course List ----";
  private ArrayList<String> menu = new ArrayList<String>();
  private Scanner scanner;
  private LMS lms;

  UI() {
    scanner = new Scanner(System.in);
    lms = new LMS();
  }

  public void run() {
    menu.add("Login");
    menu.add("Register");
    menu.add("Exit");

    while(true) {
      System.out.println("\n" + WELCOME_HEADER);
      printMenu();

      int uInput = getIntInput(menu.size());
  
      if (uInput == -1) {
        System.out.println("Invalid Input: Try again");
        continue;
      }

      switch(uInput) {
        case (1):
          login();
          break;
        case(2):
          register();
          break;
        case(3): // Exit
          System.out.println("Thank you for using the Coding Learning Management System");
          System.exit(0);
      }

    }

  }

  public int getIntInput(int choices) {
    System.out.println("What would you like to do?\n");

    int input = scanner.nextInt();
    scanner.nextLine();

    if ( input >= 0 && input <= choices - 1)
      return input;
    return -1;
  }

  public String getInput() {
    System.out.println("What would you like to do?\n");

    String input = scanner.nextLine();

    if ( input != null)
      return input;
    return null;
  }

  private void printMenu() {
    for(int i = 0; i < menu.size(); i++) {
      System.out.println((i+1) + ". " + menu.get(i));
    }
    System.out.println("\n");
  }

  private void MainStudentMenu() {
    clearScreen();
    menu.clear();

    menu.add("Go to Course List");
    menu.add("Search from Course Database");
    menu.add("Logout");
    menu.add("Exit");

    System.out.println("Welcome, " + lms.getCurrentUser().username + "!");

    while(true) {
      printMenu();

      int uInput = getIntInput(menu.size());
  
      if (uInput == -1) {
        System.out.println("Invalid Input: Try again");
        continue;
      }

      switch(uInput) {
        case (1):
          viewCoursesStudent();
          break;
        case(2):
          courseSearch();
          break;
        case(3):
          lms.logout();
          run();
        case(4): // Exit
          System.out.println("Thank you for using the Coding Learning Management System");
          System.exit(0);
      }

    }

  }

  private void MainTeacherMenu() {
    clearScreen();
    menu.clear();

    System.out.println("Welcome, " + lms.getCurrentUser().username + "!");

    menu.add("Go to Course List");
    menu.add("Create a New Course");
    menu.add("Search from Course Database");
    menu.add("logout");
    menu.add("Exit");

    while(true) {
      printMenu();

      int uInput = getIntInput(menu.size());
  
      if (uInput == -1) {
        System.out.println("Invalid Input: Try again");
        continue;
      }

      switch(uInput) {
        case (1):
          viewCoursesTeacher();
          break;
        case(2):
          createCourse();
          break;
        case(3):
          courseSearch();
          break;
        case(4):
          lms.logout();
          run();
          break;
        case(5): // Exit
          System.out.println("Thank you for using the Coding Learning Management System");
          System.exit(0);
      }

    }
  }

  private void MainAdminMenu() {
    clearScreen();
    menu.clear();

    System.out.println("Welcome, " + lms.getCurrentUser().username + "!");

    menu.add("Search from Course Database");
    menu.add("logout");
    menu.add("exit");

    while(true) {
      printMenu();

      int uInput = getIntInput(menu.size());
  
      if (uInput == -1) {
        System.out.println("Invalid Input: Try again");
        continue;
      }

      switch(uInput) {
        case (1):
          courseSearch();
          break;
        case(2):
        lms.logout();
        run();
        break;
        case(3): // Exit
          System.out.println("Thank you for using the Coding Learning Management System");
          System.exit(0);
      }

    }
  }

  // Login
  private void login() {
    boolean isLog = false;
    while(!isLog) {
      System.out.println(LOGIN_HEADER);
      System.out.println("Enter your username:");
      String user = scanner.nextLine();
      System.out.println("Enter your password:");
      String pass = scanner.nextLine();

      isLog = lms.login(user, pass);

      if(!isLog) {
        System.out.println("Oops! The username and password do not match.");
        continue;
      }
        
      switch(lms.getCurrentUser().getType()) {
        case("student"):
           MainStudentMenu();
          break;
        case("teacher"):
          MainTeacherMenu();
          break;
        case("admin"):
          MainAdminMenu();
          break;
      }
    }
  }
  // Register
  private void register() {
    boolean isValid = false;
    System.out.println(REGISTER_HEADER);

    System.out.println("Enter your email address:");
    String email = scanner.nextLine();

    System.out.println("Enter your username:");
    String username = scanner.nextLine();

    clearScreen();
    String pass = " ";
    while(!isValid) {
      System.out.println(REGISTER_HEADER);
      System.out.println("For security reasons, your password is required to:");
      System.out.println("> be at least 8 characters in length\n" +
                          "> include at least 1 capital letter\n" +
                          "> include at least 1 lowercase letter\n" +
                          "> include at least 1 special character\n");
      System.out.println("Enter your password:");
      pass = scanner.nextLine();

       if(!validPass(pass)) {
        System.out.println("your password does not meet the requirements. Please enter a new password.");
         continue;
       }

      isValid = true;
    }

    System.out.println("Enter your first name:");
    String firstName = scanner.nextLine();

    System.out.println("Enter your last name:");
    String lastName = scanner.nextLine();

    lms.createUser(username, email, pass, firstName, lastName);

    System.out.println("Success! " + username + " has been created! Press \"ENTER\" to return to the main menu.");
    scanner.nextLine();
    printMenu();
      
  }

  private boolean validPass(String password) {
    boolean lengthFlag = false;
    boolean capFlag = false;
    boolean lowFlag = false;
    boolean specFlag = false;
    for(int i = 0; i < password.length(); i++) {
      char temp = password.charAt(i);
      if(Character.isUpperCase(temp))
        capFlag = true;
      if(Character.isLowerCase(temp))
        lowFlag = true;
      if(!Character.isLetterOrDigit(temp))
        specFlag = true;
    }
    if(password.length() >= 8)
      lengthFlag = true;
    if(lengthFlag && capFlag && lowFlag && specFlag)
      return true;
    return false;
  }
  // course menus
  private void viewCoursesStudent() {
    clearScreen();
    menu.clear();

    menu.add("Take a course");
    menu.add("Add a course to your list");
    menu.add("Remove a course from your list");
    menu.add("Back");

    System.out.println(COURSE_HEADER + "\n");

    for(Course course : lms.getUserCourses(lms.getCurrentUser())) {
      System.out.println(course.getName() +
      " -- " + course.checkProgress(course) +
      "% complete\n");
    }

    printMenu();
    int uInput = getIntInput(menu.size());

    switch(uInput) {
      case 1:
        System.out.println("What course would you like to take?");
        courseMenuStudent(getInput());
        break;
      case 2:
        courseSearch();
        break;
      case 3:
        System.out.println("Type in the name of the course you would like to remove.");
        System.out.println("WARNING: Removing a course from your lsit will erase your course progress unless you have already completed the course.");
        lms.deleteCourse(getInput());
        System.out.println("Course deleted");
        scanner.nextLine();
        viewCoursesStudent();
        break;
      case 4:
      MainStudentMenu();
      break;
    }
  }

  private void viewCoursesTeacher() {
    clearScreen();
    menu.clear();

    menu.add("View a course");
    menu.add("Edit a course");
    menu.add("Remove a course from your list");
    menu.add("Back");

    System.out.println(COURSE_HEADER + "\n");

    for(Course course : lms.getUserCourses(lms.getCurrentUser())) {
      System.out.println(course.getName() +
      " -- " + course.checkProgress(course) +
      "% complete\n");
    }

    printMenu();
    int uInput = getIntInput(menu.size());

    switch(uInput) {
      case 1:
        System.out.println("What course would you like to view");
        courseMenuTeacher(getInput());
        break;
      case 2:
        editCourse();
        break;
      case 3:
        System.out.println("Type in the name of the course you would like to remove.");
        System.out.println("WARNING: Removing a course from your lsit will erase your course progress unless you have already completed the course.");
        lms.deleteCourse(getInput());
        System.out.println("Course deleted");
        scanner.nextLine();
        viewCoursesTeacher();
        break;
      case 4:
      MainTeacherMenu();
      break;
    }
  }

  private void courseMenuStudent(String courseName) {
    clearScreen();
    menu.clear();
    lms.setCurrentCourse(courseName);
    

    menu.add("Take module");
    menu.add("View comments");
    menu.add("Go back");

    System.out.println("---- " + courseName + " ----");
    System.out.println("| " + lms.getCurrentCourse().getTeacher().toString() + " |");
    printModules();

    printMenu();

    int uInput = getIntInput(menu.size());

    switch(uInput) {
      case 1:
        System.out.println("Which module would you like to take?");
        String mInput = getInput();
        if(lms.getCurrentCourse().getModule(mInput).getQuizResult() > 80) {
          System.out.println("This is a module that you have already completed.\n" +
          "Would you like to review this module?\nyes or no");
          if(getInput().equals("yes"))
            sectionMenuStudent(mInput);
          courseMenuStudent(courseName);
        }
        sectionMenuStudent(mInput);
        break;
      case 2:
        commentMenu();
        break;
      case 3:
        viewCoursesStudent();
      break;
  }
}

  private void courseMenuTeacher(String courseName) {
    clearScreen();
    menu.clear();
    lms.setCurrentCourse(courseName);
    

    menu.add("View module");
    menu.add("View comments");
    menu.add("Go back");

    System.out.println("---- " + courseName + " ----");
    System.out.println("| " + lms.getCurrentCourse().getTeacher().toString() + " |");
    printModules();

    printMenu();

    int uInput = getIntInput(menu.size());

    switch(uInput) {
      case 1:
        System.out.println("Which module would you like to view?");
        sectionMenuTeacher(getInput());
        break;
      case 2:
        commentMenu();
        break;
      case 3:
        viewCoursesTeacher();
      break;
    }

  }
  // TODO create course
  private void createCourse() {

  }

  private void editCourse() {

  }

  // Module menu
  private void moduleMenuStudent(String moduleName) {
    clearScreen();
    menu.clear();

    System.out.println("| " + moduleName + " |");
    
  }

  private void moduleMenuTeacher(String moduleName) {
      
  }

  private void printModules() {
    System.out.println("There are " + lms.getCurrentCourse().getModules().size() + " modules avaliable");

    for(int i = 0; i < lms.getCurrentCourse().getModules().size(); i++) {
      System.out.println("> " + lms.getCurrentCourse().getModules().get(i).getName());
      if(lms.getCurrentCourse().getModules().get(i).getQuizResult() > 80)
        System.out.print(" -- Complete");
    }
    System.out.println("> End of Course Quiz\n");
  }

  // TODO Create module
  private void createModule() {
      
  }

  private void editModule() {

  }

  // TODO Section menu
  private void sectionMenuStudent(String sectionName) {

  }

  private void sectionMenuTeacher(String sectionName) {

  }

  // TODO Create Section
  private void createSection() {

  }
  // TODO Quiz menu
  private void quizMenuStudent() {

  }

  private void quizMenuTeacher() {

  }

  // TODO Create quiz
  private void createQuiz() {

  }
  // TODO Comment Menu
  private void commentMenu() {

  }

  // TODO Create Comment
  private void createComment() {

  }

  // TODO
  private void courseSearch() {

  }

  private void clearScreen() {
    System.out.print("\033[H\033[2J");  
    System.out.flush(); 
  }

  public static void main(String[] args) {
    UI userInterface = new UI();
    userInterface.run();
  }
}
