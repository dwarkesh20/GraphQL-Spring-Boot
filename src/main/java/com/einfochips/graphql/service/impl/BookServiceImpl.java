package com.einfochips.graphql.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.einfochips.graphql.entity.Book;
import com.einfochips.graphql.repo.BookRepo;
import com.einfochips.graphql.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	Logger logger = LoggerFactory.getLogger(BookService.class);
	
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
	@Cacheable(cacheNames = "books", key = "#id")
	public Book getBook(String id) {
		logger.info("Fetch Book: "+id);
		return repo.findById(id).orElseThrow(() -> new RuntimeException("book not found with id: " + id));
	}

	@Override
	@CacheEvict(cacheNames = "books", key = "#id")
	public Boolean deleteBook(String id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			logger.warn("Book deleted: "+id);
			return true;
		}
		return false;

	}

	@Override
	@CachePut(cacheNames = "books", key = "#book.id")
	public Book update(Book book) {
		if(!repo.existsById(book.getId())) {
			throw new RuntimeException("book not found with id: "+book.getId());
		}
		logger.info("Book Updated: "+book.getId());
		return repo.save(book);
	}

}
