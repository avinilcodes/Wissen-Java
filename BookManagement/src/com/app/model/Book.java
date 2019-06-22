package com.app.model;

public class Book {
	private int isbn;
	private String title;
	private double price;
	private int pid;

	public Book() {
		
	}
	public Book(int isbn, String title, double price, int pid) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.pid = pid;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price + ", pid=" + pid + "]";
	}

}
