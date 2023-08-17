import java.io.*;
import java.lang.*;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 *Customer class creates user.
 *writes user data to txt file and updates account balance.
 */
public class Customer {
  /**
   *declaration of instance variables.
   */
  private String username;
  private String password;
  private Account[] accounts = new Account[10];
  private int count = 0;

  private static String oldLineFromReadIn = "";
  private String oldLine = "";
  private String accReadStringAccounts = "";
  private boolean moneyTransaction = false;
  private static String accReadString;
  private String accountString = "";
  /**
   *open and create new file.
   *filewriter to write to file.
   *scanner to read it
   */
  File inputFile = new File("customers1.txt");
  FileWriter fw = new FileWriter("customers1.txt", true);
  BufferedWriter bw = new BufferedWriter(fw);
  Scanner in = new Scanner(inputFile);
  Scanner in3 = new Scanner(inputFile);

  /**
   *reads the data from the txt file.
   *stores the data into accounts array.
   */
  public void readInFromFile() throws IOException { // print everything
    InputStream fis = new FileInputStream(inputFile);
    InputStreamReader isr = new InputStreamReader(fis);
    BufferedReader br = new BufferedReader(isr);
    //String accReadString = "";
    boolean done = false;
    String line = br.readLine();

    while (!done && in3.hasNext()) {
      String usernameCompare = in3.next();

      if (usernameCompare.equals(username)) {
        if (in3.hasNext()) {
          String passwordCompare = in3.next();
          if (passwordCompare.equals(password)) {
            accReadString = line;

            done = true;
          }
        }
      }
      line = br.readLine();

    }
    if (accReadString.length() < 1) {
      done = false;
    }
    if (!accReadString.contains("|")) {
      done = false;
    }
    if (done) {

      accReadString = accReadString.substring(accReadString.indexOf(' ', (username.length() + password.length() - 1)));

      accReadStringAccounts = accReadString;
      oldLineFromReadIn = accReadString;
      int accountCounter = 0;
      while (accReadString.length() > 10) {
        //read in the account type after the bracket and before the hashtag
        String acctype = accReadString.substring(1, accReadString.indexOf('#'));

        //cut down accReadString so that when it's done being read in, loop will end
        accReadString = accReadString.substring(accReadString.indexOf('#') + 1);
        //read in account number
        String acctNum = accReadString.substring(0, accReadString.indexOf(' '));

        int intAcctNum = Integer.parseInt(acctNum); //make into an integer to pass through parametrized constructor

        accReadString = accReadString.substring(accReadString.indexOf(' ') + 1);

        String acctBalance = accReadString.substring(0, accReadString.indexOf('|') - 1);

        double doubleAcctBalance = Double.parseDouble(acctBalance); //make into double

        accReadString = accReadString.substring(accReadString.indexOf('|'));

        accounts[count] = new Account(acctype, intAcctNum, doubleAcctBalance);
        count++;
      }

    }
    //close filewriter, bufferedreader, and inputstream
    //fw.write("\n");
    //fw.flush();
    br.close();
    fis.close();
    isr.close();
    //in3.close();
  }

  /**
   *set username and password to variables in constructor.
   */
  public Customer(String username, String password) throws IOException {
    this.password = password;
    this.username = username;
  }

  /**
   *write the registration contents into the txt file.
   */
  public void newCustomer() throws IOException {
    System.out.println("Successfully registered. Please log in to access your account.");
    fw.write(username + " " + password + " \n"); //KEEP \N HERE SO EVERYTHING PRINTS ON NEW LINE
    fw.flush();
  }

  /**
   *finds the customer in the txt file.
   *validates the user login.
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
            readInFromFile();
          }
        }
      }
    }
    return found;
  }

  /**
   *return the username.
   */
  public String getUsername() {
    return username;
  }

  /**
   *return the accounts.
   */
  public void getAccounts() {
    accountString = "";
    for (Account a: accounts) {
      if (a != null) {
        accountString = accountString + "" + toString(a) + " | ";
      }
    }
    System.out.println(accountString); //make old line traverse all over and change w changes
  }

  /**
   *return the account type, account number, and account balance as a string.
   */
  public String toString(Account acc) {
    //return account type and account number with get number and get type method
    String acctType = acc.getType();
    int acctNum = acc.getNumber();
    double acctBalance = acc.getBalance();
    return (acctType + " " + "#" + acctNum + " " + acctBalance);
  }

  /**
   *passes in accounts at index through the toString method and returns string.
   */
  public String toString() {
    String accountString = "";
    for (Account a: accounts) {
      if (a != null) {
        accountString = accountString + toString(a) + " | ";

      }
    }
    return accountString;
  }

  /**
   *set the username to the String passed in through setName.
   */
  public void setName(String username) {
    this.username = username;
  }

  /**
   *set the password to the String passed in through setPassword.
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   *creates an account.
   *takes a String type as an argument (checkings or savings) and updates user data at index.
   */
  public void createAccount(String type) throws IOException {
    Account newAccount = new Account(type);
    accounts[count] = newAccount;
    count++;
  }

  /**
   *removes account.
   *takes an int num as an argument (account number) and removes the account associated with this number.
   *return true if account is removed, else return false.
   */
  public boolean removeAccount(int num) {
    boolean removed = false;

    int accCount = 0;
    int toRemoveIndex = 0;
    for (Account acc: accounts) {
      if (acc != null) {
        if (acc.getNumber() == num) {
          toRemoveIndex = accCount;
          removed = true;
        }
      }
      accCount++;
    }

    for (int i = toRemoveIndex; i < count; i++) {
      accounts[i] = accounts[i + 1];
    }
    return removed;
  }

  //----------------------------------------------------------
  //-----------------account class dupes----------------------
  public void withdraw(int acc, double amount) {
    accountNum(acc).withdraw(amount);
  }

  public double getBalance(int accountNum) {
    Account acc = accountNum(accountNum);
    return acc.getBalance();
  }
  public void deposit(int acc, double amount) {
    accountNum(acc).deposit(amount);
    moneyTransaction = true;
  }
  //----------------------------------------------------------

  /**
   *transfers user's amount from an account to another.
   *takes user amount, the sender's acccount number, and receiver's account number as an argument.
   *return true if the amount is sent, else returns false;
   */
  public boolean transfer(double amount, int from, int to) {
    Account sender = accountNum(from);
    Account receiver = accountNum(to);
    moneyTransaction = true;
    if ((sender.getBalance() - amount) <= 0) {
      return false;
    } else if (sender.getBalance() >= amount) {
      sender.withdraw(amount);
      receiver.deposit(amount);
      return true;
    }
    return false;
  }

  /**
   *returns the account number in txt file.
   */
  public Account accountNum(int num) {
    for (Account getNum: accounts) {
      if (getNum.getNumber() == num) {
        return getNum;
      }
    }
    return null;
  }

  /**
   *adds the accounts to the txt file by user info.
   */
  public void addAccountsToFile() throws IOException {

    //find username/password scnr.next()
    /*---------------------making all accounts into string for file and display-------------------*/
    accountString = "";
    for (Account a: accounts) {
      if (a != null) {
        accountString = accountString + "" + toString(a) + " | ";

      }
    }
    /*------------------------------------display accounts-----------------------------------------*/
    //System.out.println(accountString);
    /*-------------------------------scan files into buffer---------------------------------------*/
    Scanner in2 = new Scanner(inputFile);
    StringBuffer buffer = new StringBuffer();
    while (in2.hasNextLine()) {
      buffer.append(in2.nextLine() + System.lineSeparator());
    }

    String fileContents = buffer.toString();
    in2.close();

    String oldLine1 = accReadString;
    if (oldLineFromReadIn.equals("")) {
      oldLine1 = username + " " + password + " ";
    }
    String newLine = (username + " " + password + " " + accountString);

    fileContents = fileContents.replace(oldLine1, newLine);

    FileWriter writer = new FileWriter(inputFile);

    writer.append(newLine);
    writer.write("\n");
    writer.flush();

    writer.close();
    //fw.flush();
    fw.close();
    in.close();
    in3.close();
  }
}