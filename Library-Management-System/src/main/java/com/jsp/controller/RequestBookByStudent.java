package com.jsp.controller;

import com.jsp.service.LibrarianService;

public class RequestBookByStudent {
	public static void main(String[] args) {
		LibrarianService librarianService=new LibrarianService();
		boolean b=	librarianService.requestBookLibrarian(6, 2, 2);	//book,student,librarian id
		System.out.println(b);
	}
	

}
