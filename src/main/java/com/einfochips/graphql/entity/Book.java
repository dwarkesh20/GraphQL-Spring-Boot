package com.einfochips.graphql.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Book {
	@Id
	private String id;	
	private String title;
	private String desc;
	private String author;
	private double price;
	private int pages;
	
}
