import java.io.*;
import java.util.Scanner;
/**
 * Developed by Jordan Yee, Charmy Schultz, and Luke Martin
 */

/**
 *Main class performs actions.
 *displays messages and prompts.
 */
public class Main {
  /**
   *menuChoice displays menu based on input.
   */
  private static int menuChoice = 0;

  // scanner for input
  private static Scanner scnr = new Scanner(System.in);

  /**
   * calls performInteractions to run the menu and prompt user input.
   */
  public static void main(String[] args) throws IOException {
    performInteractions();
  }

  /**
   *prints out prompts and allows for user input.
   *provides full functionality of banking system with interaction to Account and Customer classes.
   */
  public static void performInteractions() throws IOException {
    System.out.println("****************************************");
    System.out.println("Welcome to the Bank of Computer Science");
    System.out.println();
    System.out.println("Already have an account?");
    System.out.print("(1) Log in");
    System.out.println();
    System.out.println("Don't have an account?");
    System.out.println("(2) Register");
    System.out.println();
    System.out.println("Exit System.");
    System.out.println("(3) Exit");
    System.out.println();
    System.out.print("Enter a choice: ");
    menuChoice = scnr.nextInt();
    System.out.println("****************************************");

    if (menuChoice == 1) {
      System.out.println("****************************************");
      System.out.println("Login");
      System.out.println();
      System.out.print("Username: ");
      String username = scnr.next();
      System.out.println();
      System.out.print("Password: ");
      String password = scnr.next();
      System.out.println();
      System.out.println("****************************************");
      //make new customer obj, check to see if existing customer
      Customer customer = new Customer(username, password);
      boolean found = customer.findCustomer(username, password);
      boolean done = false;
      if (found) { //if they're found, show main menu
        System.out.println("Successfully logged in.");
        while (!done) {
          customer.getAccounts();
          System.out.println("(c)reate account");
          System.out.println("(r)emove account");
          System.out.println("(d)eposit");
          System.out.println("(w)ithdrawal");
          System.out.println("(t)ransfer");
          System.out.println("(q)uit");
          System.out.println();
          System.out.print("Enter a choice: ");
          String input = scnr.next();
          if (input.equalsIgnoreCase("W")) {
            //open withdrawal options
            System.out.println("Which account do you want to withdraw from?");
            System.out.print("Enter the account number: ");
            int accNum = scnr.nextInt();
            System.out.print("Amount: ");
            double amount = scnr.nextDouble();
            //send through withdrawal method
            customer.withdraw(accNum, amount);
            customer.addAccountsToFile();

          } else if (input.equalsIgnoreCase("T")) {
            System.out.print("From account number: ");
            int from = scnr.nextInt();
            System.out.print("To account number: ");
            int to = scnr.nextInt();
            System.out.print("Amount: ");
            double amount = scnr.nextDouble();
            customer.transfer(amount, from, to);
            System.out.println(customer.getBalance(from));
            System.out.println(customer.getBalance(to));
            customer.addAccountsToFile();

          } else if (input.equalsIgnoreCase("C")) {
            System.out.println("(Checking) or (Savings)?");
            System.out.print("Enter a choice: ");
            String acctType = scnr.next();
            customer.createAccount(acctType);
            customer.addAccountsToFile(); //immediately display

          } else if (input.equalsIgnoreCase("Q")) {
            System.out.println("Thank you for using our service.");
            done = true;

          } else if (input.equalsIgnoreCase("D")) {
            System.out.println("Which account do you want to deposit in?");
            System.out.print("Enter the account number: ");
            int accountnum = scnr.nextInt();
            System.out.print("Amount: ");
            double depositAmount = scnr.nextDouble();
            customer.deposit(accountnum, depositAmount);
            System.out.println(customer.getBalance(accountnum));
            customer.addAccountsToFile();
          } else if (input.equalsIgnoreCase("R")) {
            System.out.print("Which account do you want to remove?");
            System.out.println();
            System.out.print("Enter the account number: ");
            int removeAccount = scnr.nextInt();
            customer.removeAccount(removeAccount);
            customer.addAccountsToFile();
          } else {
            System.out.println("Invalid input.");
          }

        }
        customer.addAccountsToFile();
      } else {
        System.out.println("Invalid username or password."); // print error statement if user not found
        performInteractions();
      }

    } else if (menuChoice == 2) {
      System.out.println("****************************************");
      System.out.println("Register");
      System.out.println();
      System.out.print("Username: ");
      String username = scnr.next();
      System.out.println();
      System.out.print("Password: ");
      String password = scnr.next();
      System.out.println();
      System.out.println("****************************************");
      Customer customer = new Customer(username, password);
      customer.newCustomer();
      performInteractions();

    } else {
      System.out.println("System exited.");
      System.exit(0);
    }
  }
}