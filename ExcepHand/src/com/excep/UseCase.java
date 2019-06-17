package com.excep;

class LaundryPickupException extends RuntimeException {
	public String getMessage() {
		return "pickup person not available try after sometime";
	}
}

class LaundryClosed extends RuntimeException {
	private String day;

	public LaundryClosed(String day) {
		super(day);
		this.day = day;
	}

	public String getMessage() {
		return "Laundry is closed beacause it is " + day;
	}
}

class LaundryAvail {
	public boolean avail(String day, int person){
		if (day == "Sunday") {
			throw new LaundryClosed(day);
		} else if (person != 1)
			throw new LaundryPickupException();
		else
			return true;
	}
}

class BookLaundry {
	private LaundryAvail laundryAvail = new LaundryAvail();

	public void bookLaundry(String day) {
		int person = 1;
		
		try {
			boolean b = laundryAvail.avail(day, person);
			if (b) {
				System.out.println("Person will come to pickup your laundry");
			}
		} catch (LaundryClosed | LaundryPickupException e) {
			System.out.println(e.getMessage());
		}
	}
}

public class UseCase {
	public static void main(String[] args) {
		BookLaundry bookLaundry = new BookLaundry();
		bookLaundry.bookLaundry("Monday");
	}
}
