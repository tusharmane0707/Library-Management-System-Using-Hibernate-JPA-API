package com.jsp.controller;

import com.jsp.service.BookService;

public class BookUpdateAuthorName {
	public static void main(String[] args) {
		BookService bookService=new BookService();
		bookService.updatebookAuthorName(4, "Valmiki");
	}

}
