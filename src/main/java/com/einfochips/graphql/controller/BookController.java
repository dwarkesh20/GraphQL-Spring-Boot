package com.einfochips.graphql.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.einfochips.graphql.dto.BookReq;
import com.einfochips.graphql.entity.Book;
import com.einfochips.graphql.service.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	@Autowired
	ModelMapper mapper;
	
	@MutationMapping("createBook")
	public Book create(@Argument BookReq bookReq) {
		Book book = mapper.map(bookReq, Book.class);
		return bookService.create(book);
	}
	
	@MutationMapping("updateBook")
	public Book update(@Argument Book book) {
		return bookService.update(book);
	}
	
	@QueryMapping("allBooks")
	public List<Book> getAll(){
		return bookService.getBooks();
	}
	
	@QueryMapping("getBook")
	public Book getBook(@Argument String id){
		return bookService.getBook(id);
	}
	
	@MutationMapping("deleteBook")
	public Boolean deleteBook(@Argument String id){
		 return bookService.deleteBook(id);
	}
	
}
