package com.einfochips.graphql.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.einfochips.graphql.entity.Book;

public interface BookRepo extends MongoRepository<Book, String>{

}
