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
      MainMenu();

      int uInput = getInput(menu.size());
  
      if (uInput == -1) {
        System.out.println("Invalid Input: Try again");
        continue;
      }

      switch(uInput) {
        case (1):
          // TODO Login Method
          break;
        case(2):
          // TODO Register Method
          break;
        case(0): // Exit
          
          break;
      }

    }
    System.out.println("Thank you for using the Coding Learning Management System");

  }

  public int getInput(int choices) {
    System.out.println("What would you like to do?\n");

    int input = scanner.nextInt();
    scanner.nextLine();

    if ( input >= 0 && input <= choices - 1)
      return input;
    return -1;
  }

  // TODO Gen Heading

  // TODO Main Menu
  private void MainMenu() {
    System.out.println("\n" + WELCOME_HEADER);

    for(int i = 0; i < menu.size(); i++) {
      System.out.println((i+1) + ". " + menu.get(i));
    }
    System.out.println("\n");
  }

  // TODO Login

  // TODO Register

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
}
