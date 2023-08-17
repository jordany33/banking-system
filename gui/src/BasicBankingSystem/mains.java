package BasicBankingSystem;

import java.util.Scanner;

public class Mains {
    	Scanner scnr = new Scanner(System.in); // scanner for input
    	private int menuChoice = 0;
	    public static void main(String[] args) {

	        Main menu = new Main();
	        menu.header();
	        if(menuChoice == 1) {
	    		System.out.println("******************");
	    		System.out.println("	  Login       ");
	    		System.out.println();
	    		System.out.print("Username: ");
	    		String username = scnr.next();
	    		System.out.print("Password: ");
	    		String password = scnr.next();
	        } 
	        else if(menuChoice == 2) {
	    		System.out.println("******************");
	    		System.out.println("	  Register       ");
	    		System.out.println();
	    		System.out.println("Username: ");
	    		String username = scnr.next();
	    		System.out.println("Password: ");
	    		String password = scnr.next();
	        } else {
				System.out.println("System exited.");
				System.exit(0);
	        }
	    }

	    public void header() {
	        System.out.println("****************************************");
			System.out.println("Welcome to the Bank of Computer Science");
			System.out.println();
			System.out.println("Already have an account?");
			System.out.print("(1) Log in");
			System.out.println();
			System.out.println("Don't have an account?");
			System.out.println("(2) Register");
			System.out.println();
			System.out.println("Exit System");
			System.out.println("(3) Exit");
			System.out.println();
	        menuChoice = scnr.nextInt();
	        System.out.println("****************************************");
	    }
}
