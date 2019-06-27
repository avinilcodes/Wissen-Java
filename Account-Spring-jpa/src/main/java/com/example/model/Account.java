package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
	@Id
	@Column(name = "num")
	private String accNum;
	private double balance;

	public Account() {

	}

	public Account(String accNum) {
		super();
		this.accNum = accNum;
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", balance=" + balance + "]";
	}

}
