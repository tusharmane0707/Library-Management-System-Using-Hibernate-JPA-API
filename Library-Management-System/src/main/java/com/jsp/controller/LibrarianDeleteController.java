package com.jsp.controller;

import com.jsp.service.LibrarianService;

public class LibrarianDeleteController {
	public static void main(String[] args) {
		LibrarianService librarianService=new LibrarianService();
		librarianService.deleteById(6);
		}

	}

	/*

	1	Mayur	UnAuthorized
	3	Rahul	UnAuthorized
	4	Pratik	UnAuthorized
			
	*/


