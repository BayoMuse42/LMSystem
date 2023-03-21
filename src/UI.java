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

  // TODO Login
    private void login() {

    }
  // TODO Register
    private void register() {

    }
  // TODO course menu

  // TODO create course

  // TODO Module menu

  // TODO Create module

  // TODO Section menu

  // TODO Create Section

  // TODO Quiz menu

  // TODO Create quiz

  // TODO Comment Menu

  // TODO Create Comment

  public static void main(String[] args) {
    UI userInterface = new UI();
    userInterface.run();
  }
}
