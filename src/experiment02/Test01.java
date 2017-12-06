/*Project: The Account Class


Problem Description:
(The Account class) Design a class named Account that contains: 
A private int data field named id for the account (default 0).
A private double data field named balance for the account (default 0).
A private double data field named annualInterestRate that stores the 
		current interest rate (default 0). 
		Assume all accounts have the same interest rate.
A private Date data field named dateCreated that stores the date 
		when the account was created.
A no-arg constructor that creates a default account.
A constructor that creates an account with the specified id and initial balance.
The accessor and mutator methods for id, balance, and annualInterestRate. 
The accessor method for dateCreated. 
A method named getMonthlyInterestRate() that returns the monthly interest rate.
A method named withdraw that withdraws a specified amount from the account.
A method named deposit that deposits a specified amount to the account.

Draw the UML diagram for the class. 
Implement the class. 
Write a test program that creates an Account object with an account ID of 1122, 
a balance of $20,000, and an annual interest rate of 4.5%. 
Use the withdraw method to withdraw $2,500, 
use the deposit method to deposit $3,000, and print the balance, 
the monthly interest, and the date when this account was created.*/

package experiment02;

import java.util.Date;

class Account {
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated = new Date();

	public Account() {
		super();
	}

	public Account(int id, double balance, double annualInterestRate) {
		super();
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	// 获取月利率的方法
	public double getMonthlyInterestRate() {
		return this.annualInterestRate / 12;
	}

	// 取款方法
	public void withdraw(int amount) {
		if (this.balance - amount >= 0) {
			this.balance -= amount;
		}
		else {
			System.out.println("资金不足，取款失败");
		}
		
	}

	// 存款方法
	public void deposit(int amount) {
		this.balance += amount;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", annualInterestRate=" + annualInterestRate
				+ ", dateCreated=" + dateCreated + "]";
	}

}

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account(1122,20000,0.045);
		
		account.withdraw(2500);//提款
		account.deposit(3000);//存款
		
		System.out.println("余额：" + account.getBalance());
		System.out.println("每月利率：" + account.getMonthlyInterestRate() * account.getBalance());
		System.out.println("创建日期：" + account.getDateCreated());
	}

}
