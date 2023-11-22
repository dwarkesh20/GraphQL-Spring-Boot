package com.einfochips.graphql.service;

import java.util.List;

import com.einfochips.graphql.entity.Book;

public interface BookService {
	Book create(Book book);
	
	List<Book> getBooks();
	
	Book getBook(String id);

	Boolean deleteBook(String id);

	Book update(Book book);
}
