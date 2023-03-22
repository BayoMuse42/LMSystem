package src;

import java.util.Scanner;
import java.util.ArrayList;

public class UI {
  private static final String WELCOME_HEADER = "---- Coding Learning Management System ----";
  private static final String LOGIN_HEADER = "---- Login ----";
  private static final String REGISTER_HEADER = "---- Register ----";
  private static final String CREATE_HEADER = "---- Course Creation ----";
  private ArrayList<String> menu = new ArrayList<String>();
  private Scanner scanner;
  private LMS lms;
  private boolean isTeacher;

  UI() {
    scanner = new Scanner(System.in);
    lms = new LMS();
  }

  public void run() {
    menu.add("Login");
    menu.add("Register");
    menu.add("Exit");

    while(true) {
      mainMenu();

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

  public String getInput(int choices) {
    System.out.println("What would you like to do?\n");

    String input = scanner.nextLine();

    if ( input != null)
      return input;
    return null;
  }

  // TODO Gen Heading

  private void mainMenu() {
    System.out.println("\n" + WELCOME_HEADER);

    for(int i = 0; i < menu.size(); i++) {
      System.out.println((i+1) + ". " + menu.get(i));
    }
    System.out.println("\n");
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
        //TODO add additional screens for Student, Teacher, Admin
      }
    }
  // TODO Register
    private void register() {
      boolean isValid = false;
      System.out.println(REGISTER_HEADER);

      System.out.println("Enter your email address:");
      String email = scanner.nextLine();

      System.out.println("Enter your username:");
      String username = scanner.nextLine();

      clearScreen();
      while(!isValid) {
        System.out.println(REGISTER_HEADER);
        System.out.println("For security reasons, your password is required to:");
      }


      
    }
  // TODO course menu
    private void courseMenu() {

    }
  // TODO create course
    private void createCourse() {

    }
  // TODO Module menu
    private void moduleMenu() {

    }
  // TODO Create module
    private void createModule() {
      
    }

  // TODO Section menu
    private void sectionMenu() {

    }
  // TODO Create Section
    private void createSection() {

    }
  // TODO Quiz menu
    private void quizMenu() {

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

  private void clearScreen() {

  }

  public static void main(String[] args) {
    UI userInterface = new UI();
    userInterface.run();
  }
}
