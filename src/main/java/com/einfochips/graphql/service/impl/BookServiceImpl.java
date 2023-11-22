package com.einfochips.graphql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.einfochips.graphql.entity.Book;
import com.einfochips.graphql.repo.BookRepo;
import com.einfochips.graphql.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepo repo;

	@Override
	public Book create(Book book) {
		return repo.save(book);
	}

	@Override
	public List<Book> getBooks() {
		return repo.findAll();
	}

	@Override
	public Book getBook(String id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("book not found with id: " + id));
	}

	@Override
	public Boolean deleteBook(String id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;

	}

	@Override
	public Book update(Book book) {
		if(!repo.existsById(book.getId())) {
			throw new RuntimeException("book not found with id: "+book.getId());
		}
		
		return repo.save(book);
	}

}
