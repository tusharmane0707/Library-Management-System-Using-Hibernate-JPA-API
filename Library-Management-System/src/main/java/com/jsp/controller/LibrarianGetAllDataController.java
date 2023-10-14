package com.jsp.controller;

import com.jsp.service.LibrarianService;

public class LibrarianGetAllDataController {
	public static void main(String[] args) {
		LibrarianService librarianService=new LibrarianService();
		librarianService.getAllData();
	}

}


