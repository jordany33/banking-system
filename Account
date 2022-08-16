import java.util.Random;
/**
 *Account class creates user account.
 *tracks user account balance and creates type (checkings or savings) with associated ID number.
 */
public class Account {
    /**
     *declare instance variables.
     *account ID - num.
     *account type (checkings or savings) - type.
     *account balance - balance.
     */
    private int num;
    private String type = "";
    private double balance = 0.0;

    /**
     *takes String type (checkings or savings) as argument and creates ID number for account.
     */
    public Account(String type) {
        if (type.equalsIgnoreCase("checking")||type.equalsIgnoreCase("savings")) {
            this.type = type;
        }
        else {
            System.out.print("Please ever a valid account type (checking or savings)");
        }
        num = (int) (Math.random() * (100000000));
    }

    /**
     *constructor initializes account type, number, and balance.
     */
    public Account(String type, int num, double balance) {
        this.type = type;
        this.num = num;
        this.balance = balance;
    }

    /**
     *generates new account number.
     */
    public int accountNum() {
        Random rand = new Random();
        return rand.nextInt(100000);
    }

    /**
     *returns the account number.
     */
    public int getNumber() {
        return num;
    }

    /**
     *returns the account type (checkings or savings).
     */
    public String getType(){
        return type;
    }

    /**
     *returns the account balance.
     */
    public double getBalance(){
        return balance;
    }

    /**
     *deposits argument amount into account.
     *amount must be greater than or equal to 0.
     */
    public void deposit(double amount) {
        if(amount >= 0) {
            balance += amount;
        }
    }

    /**
     *withdraws argument amount out of account.
     *account must have valid balance. Return false if account has invalid amount.
     *return true if account has valid balance to withdraw.
     */
    public boolean withdraw(double amount) {
        if (balance - amount < 0) {
            return false;
        } else {
            balance -= amount;
        }
        return true;
    }
}
