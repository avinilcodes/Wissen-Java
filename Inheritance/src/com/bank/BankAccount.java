package com.bank;

abstract public class BankAccount {
	private String accNum;
	double balance = 0;

	public BankAccount(String accNum) {
		super();
		this.accNum = accNum;
	}

	public void setBalance(double amount) {
		balance += amount;
		System.out.println("your account is credited with " + amount);
	}

	public void deductAmount(double amount) {
		if (balance >= amount) {
			balance -= amount;
			System.out.println("your account is debited with " + amount);
		} else {
			System.out.println("Insufficient funds");
		}
	}

}
