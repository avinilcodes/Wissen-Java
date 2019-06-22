package com.app.model;

public class Chapter {
	private int idx;
	private String title;
	private int pages;
	private int bookIsbn;

	public Chapter(int idx, String title, int pages, int bookIsbn) {

		this.idx = idx;
		this.title = title;
		this.pages = pages;
		this.bookIsbn = bookIsbn;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(int bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	@Override
	public String toString() {
		return "Chapter [idx=" + idx + ", title=" + title + ", pages=" + pages + ", bookIsbn=" + bookIsbn + "]";
	}

}
