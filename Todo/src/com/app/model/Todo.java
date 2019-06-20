package com.app.model;

import java.time.LocalDateTime;

public class Todo {
	private final int id;
	private String title;
	boolean completed;
	private LocalDateTime creationTime;

	public Todo(int id, String title) {
		this.id = id;
		this.title = title;
		this.completed = false;
		this.creationTime = LocalDateTime.now();
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

	public LocalDateTime getDate() {
		return creationTime;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", completed=" + completed + ", date=" + creationTime + "]";
	}

}
