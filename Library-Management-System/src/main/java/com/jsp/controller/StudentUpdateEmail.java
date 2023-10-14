package com.jsp.controller;

import com.jsp.service.StudentService;

public class StudentUpdateEmail {
	public static void main(String[] args) {
		StudentService studentService=new StudentService();
		studentService.updateStudentEmail(1, "ram@mail.com");
	}

}
