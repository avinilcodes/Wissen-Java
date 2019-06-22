package com.app;
import java.util.List;

import com.app.model.Book;
import com.app.model.Chapter;
import com.app.model.Publisher;
import com.app.repository.BookRepository;
import com.app.repository.ChapterRepository;
import com.app.repository.JdbcBookRepository;
import com.app.repository.JdbcChapterRepository;
import com.app.repository.JdbcPublisherRepository;
import com.app.repository.PublisherRepository;

public class App {
	public static void main(String[] args) {
		PublisherRepository publisherRepository = new JdbcPublisherRepository();
		ChapterRepository chapterRepository = new JdbcChapterRepository();
		BookRepository bookRepository = new JdbcBookRepository();
		
		//Publisher publisher = new Publisher(1, "Swan");
		//publisherRepository.save(publisher);
		
//		Book book1 = new Book(1, "god loves you", 0.0, 1);
//		Book book2 = new Book(2, "1984", 150.0, 1);
//		bookRepository.save(book1);
//		bookRepository.save(book2);
//		
//		Chapter chapter1 = new Chapter(1, "1984", 123, 2);
//		chapterRepository.save(chapter1);
		
		List<Book> books= publisherRepository.findById(1);
		for (Book book : books) {
			System.out.println(book);
		}
		
	}
}
