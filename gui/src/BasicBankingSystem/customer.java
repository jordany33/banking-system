package BasicBankingSystem;

import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.Arrays;

public class Customer {
	/**
	 * Store the user's balance
	 * 
	 *
	 */
	 protected double balance = 0.0;
	 protected String username;
	 protected String password;
	 protected Account[] accounts = new Account[10];
	 protected int count = 0;
	 protected String type;

	 public Customer () throws IOException {}
	 
	 /**
	 * Input file for data storage in customers.txt.
	 * 
	 * FileWriter for writing to files. If there is a "customers.txt" file, set to true, else false.
	 */	 
	 File inputFile = new File("accounts.txt");
	 FileWriter fw = new FileWriter(inputFile,true);

	 public boolean equals(Object obj) {
	    return super.equals(obj);
	 }

	/**
	 * Read the input file with a scanner.
	 */
	  Scanner in = new Scanner(inputFile);
	  Scanner in2 = new Scanner(inputFile);
	  Scanner in3 = new Scanner(inputFile);
	
    /**
     * 
     * @param username stores the user's username.
     * @param password stores the user's password.
     * @throws IOException
     */
   public Customer(String username, String password) throws IOException {
        this.password = password;
        this.username = username;       
   }
   
   public void storeCustomer(String username, String password) throws IOException{
        //create new account
       	fw.write(username + " " + password + " ");
       	fw.write("\n");
       	fw.close();
    }
   
	public void readInFromFile() {
        in3.next();
        in3.next();
        String thing = in3.next();
        String accReadString = "";
        int accountCounter = 0;
            while (thing.charAt(thing.length() - 1) != ']') {
                accReadString += thing;
                thing = in3.next();
            }
            
        accReadString += thing;
        while (accReadString.length() > 1) {
            //read in the account type after the bracket and before the hashtag
            String acctype = accReadString.substring(1, accReadString.indexOf('#'));
            //cut down accReadString so that when it's done being read in, loop will end
            accReadString = accReadString.substring(accReadString.indexOf('#') + 1);
            //read in account number
            String acctNum = accReadString.substring(0, accReadString.indexOf(':'));
            int intAcctNum = Integer.parseInt(acctNum); //make into an integer to pass through parametrized constructor

            accReadString = accReadString.substring(accReadString.indexOf(':') + 1);

            String acctBalance = accReadString.substring(0, accReadString.indexOf(']'));
            double doubleAcctBalance = Double.parseDouble(acctBalance);

            accReadString = accReadString.substring(accReadString.indexOf(']')+1);


            accounts[accountCounter] = new Account(acctype,intAcctNum,doubleAcctBalance);
            accountCounter++;
        }

    }
	
    /**
     * validates the user's login by matching @username and @password with @purpose. 
     */
    public boolean findCustomer(String username, String password) throws IOException {
        boolean found = false;

        while (in.hasNext()) {
            String user = in.next();
            
            if (in.hasNext()) {
                String pw = in.next();
                
                if (user.equals(username)) {
                    if (pw.equals(password)) {
                        found = true;
                    }
                }
            }
        }
        return found;
    }
    
    /**
     * @return the user's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the user's accounts.
     * Copy the data into the file.
     */
    public Account[] getAccounts() {

        return accounts;
    }

    /**
     * @return return account type (string) and account number (int).
     */
    public String toString(Account acc) {
        //return account type and account number with get number and get type method
        String[] stringAccount = new String[accounts.length];
            int c = count-1;
            String acctType = acc.getType();
            int acctNum = acc.getNumber();


        return acctType + " " + "#" + acctNum + " : " + acc.getBalance();
    }
    /**
     * stores the user's username in the paramater @username.
     */
    public void setName(String username) {
        this.username = username;
    }

   /**
    * stores the user's password in the paramter @password.
    */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * creates an account of type checking or saving associated with a user's account.
     */
 public void createAccount(String type) throws IOException {
        Account newAccount = new Account(type);
        accounts[count] = newAccount;

        count++;
 }
 
    /**
     * removes a user's account by account number.
     */
    public boolean removeAccount(int num) {
        Account toRemove = null;
        int accCount = 0;
        int toRemoveIndex = 0;
        for (Account acc : accounts) {
            if (acc.getNumber() == num) {
                toRemove = acc;
                toRemoveIndex = accCount;
            }
        accCount++;
        }
        for(int i = toRemoveIndex; i < accounts.length-1; i++) {
            accounts[i] = accounts[i+1];
        }

        return false;
    }
    
    /**
     * withdraws a double @amount from an account's number. 
     */
    public void withdraw(int acc, double amount) {
        accounts[acc].withdraw(amount);
    }
    
    /**
     * transfer an @amount @to another account @from a user's account. 
     * find account number for sender and receiver.
     * return false if sender's balance is less than the amount requested to be withdrawn. 
     * else return true if sender's balance is greater than the amount requested to be withdrawn.
     */
    public boolean transfer(double amount, int from, int to) {
        Account sender = accountNum(from);
        Account receiver = accountNum(to);

        if((sender.getBalance() - amount) <= 0) {
            return false;
        }
        else if(sender.getBalance() >= amount) {
            sender.withdraw(amount);
            return true;
        }
        return false;
    }
    
    /**
     * works with transfer method to locate the account number return it.
     */
    public Account accountNum(int num) {

        for(Account getNum : accounts) {
            if(getNum.getNumber() == num) {
                return getNum;
            }
        }
        return null;
    }
	
	 public void addAccountsToFile() throws IOException {
	        //find username/password scnr.next()
	        String accountString = "";
	        for (Account a : accounts) {
	            if (a != null) {
	                accountString += "[" + toString(a) + "] ";
	            }
	        }
	        StringBuffer buffer = new StringBuffer();

	        while (in2.hasNextLine()){
	            buffer.append(in2.nextLine()+System.lineSeparator());
	        }
	        String fileContents = buffer.toString();
	        //System.out.println(fileContents);
	        in2.close();
	        String oldLine = username + " " + password + " ";
	        String newLine = username +  " " + password + " " + accountString;
	        fileContents = fileContents.replaceAll(oldLine,newLine);
	        FileWriter writer = new FileWriter(inputFile);

	        writer.append(fileContents);

	        //fw.write("\n");
	        writer.flush();
	        writer.close();
	        in.close();
	        fw.flush();
	        fw.close();
	}
}
