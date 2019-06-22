package com.app.repository;

import java.util.List;

import com.app.model.Book;
import com.app.model.Publisher;

public interface PublisherRepository {

	void save(Publisher publisher);

	List<Book> findById(int id);
}
