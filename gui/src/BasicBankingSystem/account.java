package BasicBankingSystem;

import java.io.FileWriter;
import java.io.IOException;

public class Account{
	/**
	 * 
	 */
	protected int num;
	protected String type;
	protected double balance;

	/**
	 * generate a random account number.
	 */
	public Account(String accountType) {
		this.num = (int) (Math.random() * 100000000);
		this.type = accountType;
		this.balance = 0.0;
	}
	
	/**
	 * use getNum to get account number and store into file;
	 */
    public Account(String type, int num, double balance) {
        this.type = type;
        this.num = num;
        this.balance = balance;
    }
	
//	/**
//	 * initialize @accountNum to num, @balance to 0.0, and @accountType to type/
//	 */
//	public Account(int accountNum, double balance, String accountType) {
//		this.type = accountType;
//		this.num = accountNum;
//		this.balance = 0.0;
//	}
	
	/**
	 * return the account's number.
	 */
	public int getNumber() {
		return num;
	}
	
	/**
	 * return the account's type (checkings or savings).
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * return the account's balance.
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * if the deposit @amount is greater than 0, add the @amount to the account balance 
	 */
	public void deposit(double amount) {
		if (amount >= 0) {
			balance += amount;
		}
	}
	
	/**
	 * if the account balance is less the @amount or the @amount is less than than 0, return false.
	 * else, subtract @amount from the balance and return true;
	 */
	public boolean withdraw(double amount) {
		if (balance < amount || amount < 0) {
			return false;
		} else {
			balance -= amount;
			return true;
		}
	}
}
