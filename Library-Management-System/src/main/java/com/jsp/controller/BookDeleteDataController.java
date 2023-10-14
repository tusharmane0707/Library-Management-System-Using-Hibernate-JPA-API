package com.jsp.controller;
import com.jsp.service.BookService;
public class BookDeleteDataController {

		public static void main(String[] args) {
			BookService bookService=new BookService();
			boolean a=bookService.deletebookById(8);
			System.out.println(a);
		}

	}

