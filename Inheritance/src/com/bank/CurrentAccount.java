package com.bank;

public class CurrentAccount extends BankAccount {
	public CurrentAccount(String accNum) {
		super(accNum);
	}

	public void setBalance(double amount) {
		super.setBalance(amount);
	}

	public void deductAmount(double amount) {
		super.deductAmount(amount);
	}
}
