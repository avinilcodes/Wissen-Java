package com.bank;

public class SavingsAccount extends BankAccount {
	public SavingsAccount(String accNum) {
		super(accNum);
	}
	
	public void setBalance(double amount) {
		super.setBalance(amount);
	}
	public void deductAmount(double amount) {
		super.deductAmount(amount);
	}
	
}
