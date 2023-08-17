package BasicBankingSystem;

import java.io.*;
import java.util.*;

public class Main{
	Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {
		Main menu = new Main(); 
		menu.runMenu();
	}
	
	public void runMenu() {
		boolean exit = false;
		homeView();
		
		while (!exit) {
			int choice = input();
			if (choice == 1) {
				loginView();
			}
			else if (choice == 2) {
				registerView();
			}
			else if (choice == 3) {
				System.out.println("System exited.");
				System.exit(0);
			}
		}
	}
	
	private void homeView() {		
		System.out.println("****************************************");
		System.out.println("Welcome to the Bank of Computer Science");
		System.out.println(); 
		System.out.println("Already have an account?");
		System.out.println("(1) Log in");
		System.out.println();
		System.out.println("Don't have an account?");
		System.out.println("(2) Register");
		System.out.println();
		System.out.println("Exit System");
		System.out.println("(3) Exit");
		System.out.println();
		System.out.println("****************************************");
	}
	
	private void loginView() {
		String username = "";
		String password = "";
		System.out.println("******************");
		System.out.println("	  Login       ");
		System.out.println();
		System.out.print("Username: ");
		username = scnr.next();
		System.out.print("Password: ");
		password = scnr.next();
		
//		Customer user = loginValidation(username, password);
//		if (user) {
//			System.out.println("Welcome " + username);
//			user.accountView;
//		} else {
//			System.out.println("Sorry, we can't find an account with this username or password.");
//			loginView();
//		}
	}
	
	private void registerView() {
		String username = "";
		String password = "";
		System.out.println("******************");
		System.out.println("	  Register       ");
		System.out.println();
		System.out.println("Username: ");
		username = scnr.next();
		System.out.println("Password: ");
		password = scnr.next();
	}
	
	private int input() {
		int choice = -1;
		
		do {
			System.out.print("Enter a choice: ");
			try {
				choice = scnr.nextInt();
			} catch (NumberFormatException e) {
				System.out.println("Invalid selection, please input only numbers.");
			}
			
			if (choice < 0 || choice > 4) {
				System.out.println("Please input a number within the valid range.");
			}
		} while (choice < 0 || choice> 4);
		return choice;
	}
	
	private void sss(int choice) {
		switch (choice) {
			case 0:
				System.out.println("System exited.");
				System.exit(0);
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4: 
				break;
			case 5:
				break;
		}
	}
}
