package com.app.model;

import java.time.LocalDate;

public class Todo {
	private static int count=0;
	private final int id;
	private String title;
	boolean completed;
	private LocalDate date;
	public Todo(String title) {
		this.id = ++count;
		this.title = title;
		this.completed = false;
		this.date = LocalDate.now();
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public boolean isCompleted() {
		return completed;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", completed=" + completed + ", date=" + date + "]";
	}	
	
}
