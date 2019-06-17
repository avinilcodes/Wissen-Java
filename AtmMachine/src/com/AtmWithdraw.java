package com;

interface Chain {
	public abstract void setNext(Chain nextInChain);

	public abstract void withdraw(double amount, StringBuffer s);
}

class HundredRuppeeBill implements Chain {
	private Chain nextInChain;
	private double bill = 100.00;
	private int numBills;

	public HundredRuppeeBill(int numBills) {
		super();
		this.numBills = numBills;
	}

	@Override
	public void setNext(Chain nextInChain) {
		this.nextInChain = nextInChain;
	}

	@Override
	public void withdraw(double amount, StringBuffer s) {
		if (amount >= bill && numBills >= 1) {
			amount -= bill;
			s.append(String.valueOf(bill)+" ");
			if (amount != 0) {
				nextInChain.withdraw(amount, s);
			}
		} else {
			nextInChain.withdraw(amount, s);
		}
	}

}

class TwoHundredRuppeeBill implements Chain {
	private Chain nextInChain;
	private double bill = 200.00;
	private int numBills;

	public TwoHundredRuppeeBill(int numBills) {
		super();
		this.numBills = numBills;
	}

	@Override
	public void setNext(Chain nextInChain) {
		this.nextInChain = nextInChain;
	}

	@Override
	public void withdraw(double amount, StringBuffer s) {
		if (amount >= bill && numBills >= 1) {
			amount -= bill;
			s.append(String.valueOf(bill)+ " ");
			if (amount != 0) {
				nextInChain.withdraw(amount, s);
			} 
		} else {
			nextInChain.withdraw(amount, s);
		}
		
	}

}

class FiveHundredRuppeeBill implements Chain {
	private Chain nextInChain;
	private double bill = 500.00;
	private int numBills;

	public FiveHundredRuppeeBill(int numBills) {
		super();
		this.numBills = numBills;
	}

	@Override
	public void setNext(Chain nextInChain) {
		this.nextInChain = nextInChain;
	}

	@Override
	public void withdraw(double amount, StringBuffer s) {
		if (amount >= bill && numBills >= 1) {
			amount -= bill;
			s.append(String.valueOf(bill)+" ");
			if (amount != 0) {
				nextInChain.withdraw(amount, s);
			} 

		} else {
		nextInChain.withdraw(amount, s);
		}
	}

}

class TwoThousandRuppeeBill implements Chain {
	private Chain nextInChain;
	private double bill = 2000.00;
	private int numBills;

	public TwoThousandRuppeeBill(int numBills) {
		super();
		this.numBills = numBills;
	}

	@Override
	public void setNext(Chain nextInChain) {
		this.nextInChain = nextInChain;
	}

	@Override
	public void withdraw(double amount, StringBuffer s) {
		if (amount >= bill && numBills >= 1) {
			amount -= bill;
			s.append(String.valueOf(bill)+" ");
			if (amount != 0) {
				nextInChain.withdraw(amount, s);
			}

		} else {
			nextInChain.withdraw(amount, s);
		}
	
	}

}

public class AtmWithdraw {
	public static void main(String[] args) {
		Chain c1 = new HundredRuppeeBill(10);
		Chain c2 = new TwoHundredRuppeeBill(20);
		Chain c3 = new FiveHundredRuppeeBill(20);
		Chain c4 = new TwoThousandRuppeeBill(5);
		c1.setNext(c2);
		c2.setNext(c3);
		c3.setNext(c4);
		c4.setNext(c1);
		StringBuffer s = new StringBuffer();
		c1.withdraw(1000, s);
		System.out.println(s);

	}
}
