package com.einfochips.graphql.dto;

import lombok.Data;

@Data
public class BookReq {
	private String title;
	private String desc;
	private String author;
	private double price;
	private int pages;
}
