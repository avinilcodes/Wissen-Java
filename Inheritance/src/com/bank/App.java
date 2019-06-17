package com.bank;

public class App {
	public static void main(String[] args) {
	SavingsAccount sa = new SavingsAccount("098761234567");
	sa.setBalance(1245.0);
	CurrentAccount account = new CurrentAccount("239012387132");
	account.setBalance(2817.09);
	}
}
