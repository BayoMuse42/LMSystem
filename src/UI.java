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
    menu.clear();
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

    System.out.println("Welcome, " + lms.getCurrentUser().firstName + "!");

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

    System.out.println("Welcome, " + lms.getCurrentUser().firstName + "!");

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

    System.out.println("Welcome, " + lms.getCurrentUser().firstName + "!");

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
    clearScreen();
    boolean isLog = false;
    while(!isLog) {
      System.out.println(LOGIN_HEADER);
      System.out.println("Enter your username:");
      String user = scanner.nextLine();
      System.out.println("Enter your password:");
      String pass = scanner.nextLine();

      isLog = lms.login(user, pass);

      if(!isLog) {
        clearScreen();
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
    clearScreen();
    boolean isValid = false;
    System.out.println(REGISTER_HEADER);

    System.out.println("Enter your email address:");
    String email = scanner.nextLine();
    String type;
    if(email.contains(".edu")) {
      type = "teacher";
    } else {
      type = "student";
    }
      

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

    lms.createUser(username, email, pass, firstName, lastName, type);

    System.out.println("Success! " + username + " has been created! Press \"ENTER\" to return to the main menu.");
    scanner.nextLine();
    run();
      
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
    menu.add("Print certificate");
    menu.add("Back");

    System.out.println(COURSE_HEADER + "\n");

    for(Course course : lms.getUserCourses(lms.getCurrentUser())) {
      System.out.println(course.getName() +
      " -- " + course.checkProgress() +
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
        System.out.println("WARNING: Removing a course from your list will erase your course progress unless you have already completed the course.");
        lms.deleteCourse(getInput());
        System.out.println("Course deleted");
        scanner.nextLine();
        viewCoursesStudent();
        break;
      case 4:
        System.out.println("Which course would you like to print the certificate for?");
        String input = getInput();
        if(!lms.getCourse(input).isComplete()) {
          System.out.println("A course must be completed in order for you to print the certificate");
          viewCoursesStudent();
          break;
        }
        lms.printCertificate(input);
        break;
      case 5:
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
      System.out.println(course.getName());
    }

    printMenu();
    int uInput = getIntInput(menu.size());

    switch(uInput) {
      case 1:
        System.out.println("What course would you like to view");
        courseMenuTeacher(getInput());
        break;
      case 2:
        System.out.println("Which course would you like to edit?");
        editCourse(getInput());
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
    Course currentCourse = lms.getCurrentCourse();
    

    menu.add("Take module");
    menu.add("Take end-of-course quiz");
    menu.add("View comments");
    menu.add("Go back");

    System.out.println("---- " + courseName + " ----");
    System.out.println("| " + lms.getUser(currentCourse.getTeacher()).getUserName() + " |");
    printModules();

    printMenu();

    int uInput = getIntInput(menu.size());

    while(true) {
      switch(uInput) {
        case 1:
          System.out.println("Which module would you like to take?");
          String mInput = getInput();
          if(currentCourse.getModule(mInput).isComplete()) {
            System.out.println("This is a module that you have already completed.\n" +
            "Would you like to review this module?\nyes or no");
            if(getInput().equals("yes"))
              sectionMenuStudent(mInput);
            continue;
          }
          moduleMenuStudent(mInput);
          break;
        case 2:
          for(Module module : currentCourse.getModules()) {
            if(!module.isComplete()) {
              System.out.println("All modules must be complete to take the end-of-course quiz");
              courseMenuStudent(courseName);
              break;
            }
          }
          quizMenuStudent(courseName, true);
          break;
        case 3:
          commentMenu(courseName);
          break;
        case 4:
          viewCoursesStudent();
          break;
      }
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
    System.out.println("| " + lms.getCurrentUser().getUserName() + " |");
    printModules();

    printMenu();

    int uInput = getIntInput(menu.size());

    switch(uInput) {
      case 1:
        System.out.println("Which module would you like to view?");
        moduleMenuTeacher(getInput());
        break;
      case 2:
        commentMenu(courseName);
        break;
      case 3:
        viewCoursesTeacher();
      break;
    }

  }
  // create course
  private void createCourse() {
    clearScreen();
    menu.clear();

    menu.add("Beginner");
    menu.add("Intermidiate");
    menu.add("Experienced");

    System.out.println(CREATE_HEADER);

    System.out.println("Enter the name of your course");
    String courseName = getInput();

    System.out.println("Enter the difficulty of your course");

    printMenu();

    int difficulty = getIntInput(menu.size());

    lms.createCourse(lms.getCurrentUser().getUserID(), difficulty, courseName);

    System.out.println("Course has been created");
    scanner.nextLine();

    editCourse(courseName);
  }

  private void editCourse(String courseName) {
    clearScreen();
    menu.clear();
    lms.setCurrentCourse(courseName);
    Course currentCourse = lms.getCurrentCourse();
    Quiz currentQuiz = lms.getCurrentQuiz(courseName, true);

    menu.add("Add a module");
    if(!currentCourse.getModules().equals(null)) {
      menu.add("Edit a module");
      menu.add("Remove a course");
    }
    if(currentQuiz.equals(null)) {
      menu.add("Create end-of-course quiz");
    } else {
      menu.add("Edit end-of-course quiz");
    }
    menu.add("back");
      

    System.out.println("---- " + courseName + " ----");
    System.out.println("| " + lms.getCurrentUser().getUserName() + " |");
    printModules();

    printMenu();

    int uInput = getIntInput(menu.size());

    if(!currentCourse.getModules().equals(null)) {
      switch(uInput) {
        case 1:
          createModule();
          break;
        case 2:
          System.out.println("Which module would you like to edit?");
          editModule(getInput());
          break;
        case 3:
          System.out.println("Which module would you like to remove?");
          currentCourse.removeModule(getInput());
          System.out.println("Module removed");
          editCourse(courseName);
          break;
        case 4:
          if(currentQuiz.equals(null)) {
            createQuiz(true);
            break;
          }
          editQuiz(courseName, true);
          break;
        case 5:
          viewCoursesTeacher();
          break;
      }
    } else {
      switch(uInput) {
        case 1:
          createModule();
          break;
        case 2:
          if(currentQuiz.equals(null)) {
            createQuiz(true);
            break;
          }
        editQuiz(courseName, true);
        break;
        case 3:
          viewCoursesTeacher();
         break;
      }
    }

  }

  // Module menu
  private void moduleMenuStudent(String moduleName) {
    clearScreen();
    menu.clear();

    lms.setCurrentModule(moduleName);
    Module currentModule = lms.getCurrentModule();

    menu.add("Start first section");
    menu.add("Print module content");
    menu.add("View comments");
    menu.add("Back");

    System.out.println("| " + moduleName + " |");

    System.out.println(lms.getCurrentModule().getDescription());
    System.out.println("There are " + currentModule.getSections().size() + " sections");

    for(Section section : currentModule.getSections()) {
      System.out.println("> " + section);
    }

    printMenu();

    int uInput = getIntInput(menu.size());

    switch(uInput) {
      case 1:
        sectionMenuStudent(currentModule.getSections().get(0).getName());
        break;
      case 2:
        lms.printModule();
        break;
      case 3:
        commentMenu(lms.getCurrentCourse().getName());
        break;
      case 4:
        courseMenuStudent(lms.getCurrentCourse().getName());
        break;
      default:
        System.out.println("Invalid input");
        moduleMenuStudent(moduleName);
        break;
    }

  }

  private void moduleMenuTeacher(String moduleName) {
    clearScreen();
    menu.clear();
    lms.setCurrentModule(moduleName);
    Module currentModule = lms.getCurrentModule();

    menu.add("View section");
    menu.add("View end-of-module quiz");
    menu.add("View comments");
    menu.add("Back");

    System.out.println("| " + moduleName + " |");

    System.out.println(lms.getCurrentModule().getDescription());
    System.out.println("There are " + currentModule.getSections().size() + " sections");

    for(Section section : currentModule.getSections()) {
      System.out.println("> " + section);
    }

    printMenu();

    int uInput = getIntInput(menu.size());

    switch(uInput) {
      case 1:
        System.out.println("Which section would you like to view?");
        sectionMenuTeacher(getInput());
        break;
      case 2:
        quizMenuTeacher(moduleName, false);
        break;
      case 3:
        commentMenu(lms.getCurrentCourse().getName());
        break;
      case 4:
        courseMenuTeacher(lms.getCurrentCourse().getName());
        break;
      default:
        System.out.println("Invalid input");
        moduleMenuTeacher(moduleName);
        break;
    }

  }

  private void printModules() {
    Course currentCourse = lms.getCurrentCourse();
    System.out.println("There are " + currentCourse.getModules().size() + " modules avaliable");

    for(int i = 0; i < currentCourse.getModules().size(); i++) {
      System.out.println("> " + currentCourse.getModules().get(i).getName());
      if(currentCourse.getModules().get(i).isComplete())
        System.out.print(" -- Complete");
    }
    System.out.println("> End of Course Quiz\n");
  }

  // Create module
  private void createModule() {
      clearScreen();
      menu.clear();

    System.out.println("Enter the name of the module");
    String modname = getInput();

    System.out.println("Enter the module's description");
    String modDesc = getInput();

    lms.getCurrentCourse().createModule(modname, modDesc);
    createQuiz(false);

  }

  private void editModule(String modName) {
    clearScreen();
    menu.clear();
    lms.setCurrentModule(modName);
    Module currentModule = lms.getCurrentModule();

    menu.add("Add a section");
    if(!currentModule.getSections().equals(null)) {
      menu.add("Remove a section");
      menu.add("Edit a section");
    }
    menu.add("Edit end-of-module quiz");
    menu.add("Back");

    System.out.println("| " + modName + " |");
    System.out.println(currentModule.getDescription());
    System.out.println("There are " + currentModule.getSections().size() + " sections");

    for(Section section : currentModule.getSections()) {
      System.out.println("> " + section);
    }

    printMenu();

    int uInput = getIntInput(menu.size());
      if(!currentModule.getSections().equals(null)) {
        switch(uInput) {
          case 1:
            createSection();
            break;
          case 2:
            System.out.println("Which section would you like to remove?");
            currentModule.removeSection(getInput());
            System.out.println("Section removed");
            editModule(modName);
            break;
          case 3:
            System.out.println("Which section would you like to edit?");
            editSection(getInput());
            break;
          case 4:
            editQuiz(modName, false);
            break;
          case 5:
            editCourse(lms.getCurrentCourse().getName());
            break;

        }
      } else {
        switch(uInput) {
          case 1:
            createSection();
            break;
          case 2:
            editQuiz(modName, false);
            break;
          case 3:
            editCourse(lms.getCurrentCourse().getName());
            break;
        }
      }
  }

  // Section menu
  private void sectionMenuStudent(String sectionName) {
    clearScreen();
    lms.setCurrentSection(sectionName);
    Section currentSection = lms.getCurrentSection();
    Module currentModule = lms.getCurrentModule();

    System.out.println(currentSection.getName());

    System.out.println(currentSection.getContent());

    if(currentModule.getSections().indexOf(currentSection) ==
      currentModule.getSections().size() - 1) {
        System.out.println("This is the last section of the module.");
        System.out.println("When you are finished with this section, type \"next\" to move on to the end-of-module quiz.");
        while(true) {
          switch(getInput()) {
            case "next":
            quizMenuStudent(currentModule.getName(), false);
            default:
              System.out.println("invalid input");
              continue;
          }
        }
    }

    System.out.println("When you are finished with this section, type \"next\" to move on to the next section.");
    while(true) {
      switch(getInput()) {
        case "next":
          sectionMenuStudent(currentModule.getSections().get(currentModule.getSections().indexOf(currentSection)+1).getName());
          break;
        default:
          System.out.println("invalid input");
          continue;
      }
    }
  }

  private void sectionMenuTeacher(String sectionName) {
    clearScreen();
    lms.setCurrentSection(sectionName);
    Section currentSection = lms.getCurrentSection();
    Module currentModule = lms.getCurrentModule();

    System.out.println(currentSection.getName());

    System.out.println(currentSection.getContent());

    if(currentModule.getSections().indexOf(currentSection) ==
      currentModule.getSections().size() - 1) {
        System.out.println("This is the last section of the module.");
        System.out.println("When you are finished with this section, type \"next\" to move on to the end-of-module quiz.");
        while(true) {
          switch(getInput()) {
            case "next":
            quizMenuTeacher(currentModule.getName(), false);
            default:
              System.out.println("invalid input");
              continue;
          }
        }
    }

    System.out.println("When you are finished with this section, type \"next\" to move on to the next section.");
    while(true) {
      switch(getInput()) {
        case "next":
          sectionMenuTeacher(currentModule.getSections().get(currentModule.getSections().indexOf(currentSection)+1).getName());
          break;
        default:
          System.out.println("invalid input");
          continue;
      }
    }
  }

  // Create Section
  private void createSection() {
    clearScreen();

    System.out.println("Enter the name of the section");
    String secName = getInput();

    System.out.println("Enter the section's content");
    String secDesc = getInput();

    lms.getCurrentModule().createSection(secName, secDesc);
    System.out.println("Section created");

    scanner.nextLine();
    editModule(lms.getCurrentModule().getName());
  }

  private void editSection(String secName) {
    clearScreen();
    menu.clear();

    lms.setCurrentSection(secName);
    Section currentSection = lms.getCurrentSection();
    Module currentModule = lms.getCurrentModule();

    menu.add("Edit section name");
    menu.add("Edit section content");
    menu.add("Back");

    System.out.println(currentSection.getName());

    System.out.println(currentSection.getContent());

    printMenu();
    int uInput = getIntInput(menu.size());

    while(true) {
      switch(uInput) {
        case 1:
          System.out.println("Enter the new section name");
          currentSection.setName(getInput());
          editSection(currentSection.getName());
          break;
        case 2:
          System.out.println("Enter the new content for this section");
          currentSection.setContent(getInput());
          editSection(secName);
          break;
        case 3:
          editModule(currentModule.getName());
          break;
        default:
          System.out.println("Invalid input");
          continue;
      }
    }
  }
  // Quiz menu
  private void quizMenuStudent(String name, boolean isEndCourse) {
    clearScreen();
    menu.clear();

    lms.setCurrentQuiz(name, isEndCourse);
    Quiz currentQuiz = lms.getCurrentQuiz(name, isEndCourse);
    int numCorrect = 0;

    for(int i = 0; i < currentQuiz.getQuestions().size(); i++) {
      Question currentQuestion = currentQuiz.getQuestions().get(i);

      if(isEndCourse)
      System.out.println("| end-of-course quiz |");
     else
      System.out.println("| end-of-module quiz |");

      System.out.println(currentQuestion.ask);

      for(int j = 0; j < currentQuestion.getPotentialAnswers().size(); j++)
        System.out.println((j+1) + currentQuestion.getPotentialAnswers().get(j));

      int answer = getIntInput(currentQuestion.getPotentialAnswers().size());

      if(currentQuestion.isCorrect(answer)) {
        numCorrect++;
        System.out.println("Your answer was correct");
      } else {
        System.out.println("Your answer was incorrect");
      }

      scanner.nextLine();

    }

    currentQuiz.calcQuizResult(numCorrect);

    System.out.println("You have completed the quiz!");
    System.out.println("Your score: " + currentQuiz.getQuizResult() + "%");

    if(currentQuiz.getQuizResult() >= 80) {
      if(isEndCourse) {
        System.out.println("You passed! You have successfully completed the course and earned your certification.");
      } else {
        System.out.println("You passed! You can now move on to the next module");
        lms.getCurrentModule().setComplete(true);
        lms.getCurrentCourse().calcProgress(numCorrect);
      }
    } else {
      if(isEndCourse) {
        System.out.println("You did not pass the quiz. You will have to reatake the quiz in order to recieve your certification.");
      } else {
        System.out.println("You did not pass the quiz. You will not be able to move on to the next module.");
      }
        
    }

    System.out.println("Press any key to continue");

    scanner.nextLine();
    courseMenuStudent(lms.getCurrentCourse().getName());
  }

  private void quizMenuTeacher(String name, boolean isEndCourse) {
    clearScreen();
    menu.clear();

    lms.setCurrentQuiz(name, isEndCourse);
    Quiz currentQuiz = lms.getCurrentQuiz(name, isEndCourse);

    for(int i = 0; i < currentQuiz.getQuestions().size(); i++) {
      Question currentQuestion = currentQuiz.getQuestions().get(i);

      if(isEndCourse)
      System.out.println("| end-of-course quiz |");
     else
      System.out.println("| end-of-module quiz |");

      System.out.println(currentQuestion.ask);

      for(int j = 0; j < currentQuestion.getPotentialAnswers().size(); j++)
        System.out.println((j+1) + currentQuestion.getPotentialAnswers().get(j));

      System.out.println("Correct answer: " + currentQuestion.getPotentialAnswers().get(currentQuestion.getAnswer()));
      
      System.out.println("Press any key to continue");
      scanner.nextLine();
    }

    if(isEndCourse)
      courseMenuTeacher(lms.getCurrentCourse().getName());
    moduleMenuTeacher(lms.getCurrentCourse().getName());

  }

  // Create quiz
  private void createQuiz(boolean isEndCourse) {
    clearScreen();
    menu.clear();
    ArrayList<Question> questions = new ArrayList<Question>();

    if(isEndCourse) {
      System.out.println("| End-of-Course Quiz Creation |");
    } else {
      System.out.println("| End-of-Course Module Creation |");
    }

    System.out.println("This quiz currently has 0 questions");

    System.out.println("Enter the question");
    String ask = getInput();

    System.out.println("How many answer choices are there?");
    int numofQuestions = getIntInput(4);
    ArrayList<String> answers = new ArrayList<String>();
    for(int i = 0; i < answers.size(); i++) {
      System.out.println("Enter answer choice " + i+1);
      answers.add(getInput());
    }
    System.out.println("Which answer is the correct answer?");
    int correct = getIntInput(numofQuestions);
    questions.add(new Question(ask, correct, answers));
    lms.addQuiz(new Quiz(questions));

    if(isEndCourse) {
      editQuiz(lms.getCurrentCourse().getName(), isEndCourse);
    } else {
      editQuiz(lms.getCurrentModule().getName(), isEndCourse);
    }
  }

  private void editQuiz(String name, boolean isEndCourse) {
    clearScreen();
    menu.clear();

    menu.add("Add a question");
    menu.add("remove a question");
    menu.add("Done");
    
    lms.setCurrentQuiz(name, isEndCourse);
    Quiz currentQuiz = lms.getCurrentQuiz(name, isEndCourse);

    if(isEndCourse)
      System.out.println("| end-of-course quiz |");
    else
      System.out.println("| end-of-module quiz |");

    for(int i = 0; i < currentQuiz.getQuestions().size(); i++) {
      Question currentQuestion = currentQuiz.getQuestions().get(i);

      System.out.println(currentQuestion.ask);

      for(int j = 0; j < currentQuestion.getPotentialAnswers().size(); j++)
        System.out.println((j+1) + currentQuestion.getPotentialAnswers().get(j));
      System.out.println("Correct answer: " + currentQuestion.getPotentialAnswers().get(currentQuestion.getAnswer()));
    }

    printMenu();

    int uInput = getIntInput(menu.size());

    while(true) {
      switch(uInput) {
        case 1:
          clearScreen();
          System.out.println("Enter the question");
          String ask = getInput();
      
          System.out.println("How many answer choices are there?");
          int numofQuestions = getIntInput(4);
          ArrayList<String> answers = new ArrayList<String>();
          for(int i = 0; i < answers.size(); i++) {
            System.out.println("Enter answer choice " + i+1);
            answers.add(getInput());
          }
          System.out.println("Which answer is the correct answer?");
          int correct = getIntInput(numofQuestions);
          currentQuiz.addQuestion(ask, answers, correct);
          editQuiz(name, isEndCourse);
          break;
        case 2:
          System.out.println("Which question would you like to remove?");
          currentQuiz.removeQuestion(getIntInput(currentQuiz.getQuestions().size())-1);
          editQuiz(name, isEndCourse);
          break;
        case 3:
          if(currentQuiz.getQuestions().equals(null)) {
            System.out.println("You must have at least 1 question to complete quiz creation");
            editQuiz(name, isEndCourse);
            break;
          }

          if(isEndCourse) {
            courseMenuTeacher(name);
            break;
          }
          moduleMenuTeacher(name);
        default:
          System.out.println("Invalid input");
          continue;
      }
    }
  }
  // Comment Menu
  private void commentMenu(String courseName) {
    clearScreen();
    menu.clear();

    menu.add("Add a comment");
    menu.add("Reply to a comment");
    menu.add("Back");

    Course currentCourse = lms.getCurrentCourse();
    System.out.println("---- " + courseName + " ----");
    System.out.println("| comments |");
    
    for(int i = 0; i < currentCourse.getComments().size(); i++) {
      Comment currentComment = currentCourse.getComments().get(i);
      System.out.println(i + ". " + currentComment.message);
      System.out.println(lms.getUser(currentComment.getUserID()).getUserName());
      
      for(int j = 0; j < currentComment.getReplies().size(); j++) {
        Comment currentreply = currentComment.getReplies().get(j);
        System.out.println(j + ". " + currentreply.message);
        System.out.println(lms.getUser(currentreply.getUserID()).getUserName());
      }
    }

    printMenu();

    int uInput = getIntInput(menu.size());

    switch(uInput) {
      case 1:
        createComment();
        break;
      case 2:
        System.out.println("Which comment would you like to reply to?");
        createReply(getIntInput(currentCourse.getComments().size()));
        break;
      case 3:
        if(lms.getCurrentUser().getType().equals("student")) {
          courseMenuStudent(courseName);
        } else {
          courseMenuTeacher(courseName);
        }
        break;
    }

  }

  // Create Comment
  private void createComment() {
    clearScreen();

    System.out.println("Type your comment:");
    lms.getCurrentCourse().addComment(lms.getCurrentUser().getUserID(), getInput());

    System.out.println("Comment Added");
    scanner.nextLine();

    commentMenu(lms.getCurrentCourse().getName());
  }

  private void createReply(int comIndex) {
      Comment currentComment = lms.getCurrentCourse().getComments().get(comIndex);
      clearScreen();

    System.out.println("Type your reply:");
    currentComment.replyMessage(lms.getCurrentUser().getUserID(), getInput());

    System.out.println("Comment Added");
    scanner.nextLine();

    commentMenu(lms.getCurrentCourse().getName());
    
  }

  private void courseSearch() {
    clearScreen();
    menu.clear();

    menu.add("Search by teacher");
    menu.add("Search by Difficulty");
    menu.add("Search by keyword");
    menu.add("Back");

    printMenu();
    int uInput = getIntInput(menu.size());

    switch(uInput) {
      case 1:
        searchByTeacher();
        break;
      case 2:
        searchByDifficulty();
        break;
      case 3:
        searchByKeyword();
        break;
      case 4:
        switch(lms.getCurrentUser().getType()) {
          case "student":
            MainStudentMenu();
            break;
          case "teacher":
            MainTeacherMenu();
            break;
          case "admin":
            MainAdminMenu();
            break;
        }
        break;
    }
  }

  private void searchByTeacher() {
    System.out.println("Enter the name of the teacher");
    ArrayList<Course> result = lms.Search(lms.getUser(getInput()));
    clearScreen();
    System.out.println("There are " + result.size() + " results");
    for (Course courses : result)
      System.out.println(courses);

    printMenu();

    int uInput = getIntInput(menu.size());

    while(true) {
      switch(uInput) {
        case 1:
          System.out.println("Which course would you like to add?");
          lms.addUserCourses(getInput());
          System.out.println("Course added");
          scanner.nextLine();
          courseSearch();
          break;
        case 2:
          courseSearch();
          break;
        default:
          System.out.println("Invalid input");
          continue;
      }
    }
  }

  private void searchByDifficulty() {
    menu.clear();

    menu.add("Add course to course list");
    menu.add("Back");

    System.out.println("Enter the difficulty level you would like to view");
    ArrayList<Course> result = lms.Search(getIntInput(3));
    clearScreen();
    System.out.println("There are " + result.size() + " results");
    for (Course courses : result)
      System.out.println(courses);

    printMenu();

    int uInput = getIntInput(menu.size());

    while(true) {
      switch(uInput) {
        case 1:
          System.out.println("Which course would you like to add?");
          lms.addUserCourses(getInput());
          System.out.println("Course added");
          scanner.nextLine();
          courseSearch();
          break;
        case 2:
          courseSearch();
          break;
        default:
          System.out.println("Invalid input");
          continue;
      }
    }
    
  }

  private void searchByKeyword() {
    System.out.println("Enter what you would like to search by");
    ArrayList<Course> result = lms.Search(getInput());
    clearScreen();
    System.out.println("There are " + result.size() + " results");
    for (Course courses : result)
      System.out.println(courses);

    printMenu();

    int uInput = getIntInput(menu.size());

    while(true) {
      switch(uInput) {
        case 1:
          System.out.println("Which course would you like to add?");
          lms.addUserCourses(getInput());
          System.out.println("Course added");
          scanner.nextLine();
          courseSearch();
          break;
        case 2:
          courseSearch();
          break;
        default:
          System.out.println("Invalid input");
          continue;
      }
    }
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
