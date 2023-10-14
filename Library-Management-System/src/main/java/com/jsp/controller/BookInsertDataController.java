package com.jsp.controller;


import com.jsp.dto.BookDto;
import com.jsp.service.BookService;
public class BookInsertDataController {

		public static void main(String[] args) {
			BookDto bookDto=new BookDto();
			//LocalDate localDate = null;
			
			bookDto.setTitle("Mahabharat");
			bookDto.setAuthor_name("Vyas");
			bookDto.setStatus("Available");
			BookService bookService=new BookService();
			bookService.savebookData(bookDto);
		}

	}

