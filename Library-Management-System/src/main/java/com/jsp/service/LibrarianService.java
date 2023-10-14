package com.jsp.service;

import java.time.LocalDate;
import java.util.List;

import com.jsp.dao.BookDao;
import com.jsp.dao.LibrarianDao;
import com.jsp.dao.StudentDao;
import com.jsp.dto.AdminDto;
import com.jsp.dto.BookDto;
import com.jsp.dto.LibrarianDto;
import com.jsp.dto.StudentDto;

public class LibrarianService {
	LibrarianDao librarianDao = new LibrarianDao(); // create object of Dao class
	BookDao bookDao = new BookDao();
	StudentDao studentDao = new StudentDao();

	// insert/save Librarian data
	public LibrarianDto saveLibrarianData(LibrarianDto librarianDto) {
		librarianDto.setStatus("UnApproved");
		return librarianDao.saveLibrarianData(librarianDto);

	}

	// get by id login validation condition
	public boolean validateLibrarian(int id, String name, String status) {
		LibrarianDto l = librarianDao.getLibrarianById(id);
		if (l != null && l.getName().equals(name) && l.getStatus().equals(status)) {
			return true;
		} else {
			return false;
		}

	}

	// delete/remove Librarian data
	public boolean deleteById(int id) {
		return librarianDao.deleteById(id);
	}

	// update name in Librarian data
	public boolean updateById(int id, String name) {
		return librarianDao.updateByIdName(id, name);
	}

	// update Status in Librarian data
	public boolean updateByIdStatus(int id, String status) {
		return librarianDao.updateByIdName(id, status);
	}

	// get one Librarian data by id
	public void getOneData(int id) {
		librarianDao.getOneData(id);
	}

	// get all Librarian data
	public List<LibrarianDto> getAllData() {
		List<LibrarianDto> l = librarianDao.getAllData();
		return l;

	}

//	===============


	// Book add by librarian

	public BookDto insertBookByLibrarian(BookDto bookDto) {
		return bookDao.savebookData(bookDto);
	}

	// Book remove by Librarian
	public boolean removeBook(int id) {
		return bookDao.deletebookById(id);
	}

	// Book issued by Librarian to student
	public boolean issuedBookByLibrarian(int book_id, int student_id, int librarian_id) {

		BookDto bookDto = bookDao.getOnebookData2(book_id);
		StudentDto studentDto = studentDao.getOneStudentData2(student_id);
		LibrarianDto librarianDto = librarianDao.getOneData2(librarian_id);
		if (bookDto != null && studentDto != null && librarianDto != null) {
			if (bookDto.getStatus().equalsIgnoreCase("Available") || bookDto.getStatus().equalsIgnoreCase("Requested")) {
				if(librarianDto.getStatus().equalsIgnoreCase("Approved")) {		//only approved librarian issued book
				bookDto.setStatus("Issued");
				bookDto.setStudent(studentDto);
				bookDto.setLibrarianDto(librarianDto);
				bookDto.setLocalDate(LocalDate.now());
				return bookDao.issueBook(bookDto);
				}else {
					System.out.println("Librarian is not approved or not in data");
				}
			}else {
				System.out.println("Book is not available");
			}
		}else {
			System.out.println("Student not added in database");
		}
		return false;
	}

	// Book return to the librarian
	public boolean returnBookToLibrarian(int book_id) {
		StudentDto studentDto=new StudentDto();
		LibrarianDto librarianDto=new LibrarianDto();
		BookDto bookDto = bookDao.getOnebookData2(book_id);
		//StudentDto studentDto = studentDao.getOneStudentData2(student_id);
		//LibrarianDto librarianDto = librarianDao.getOneData2(librarian_id);
		if (bookDto != null && studentDto != null && librarianDto != null) {
			if (bookDto.getStatus().equalsIgnoreCase("Issued") || bookDto.getStatus().equalsIgnoreCase("Requested")) {
				bookDto.setStatus("Available");
				bookDto.setStudent(null);
				bookDto.setLibrarianDto(null);
				bookDto.setLocalDate(null);
				return bookDao.returnBook(bookDto);
			} else {
				System.out.println("This book is already Available");
			}
		}else {
			System.out.println("Please type correct book id");
		}
		return false;

	}
	
	
		
	// student request book to librarian
	public boolean requestBookLibrarian(int book_id, int student_id, int librarian_id) {

		BookDto bookDto = bookDao.getOnebookData2(book_id);
		StudentDto studentDto = studentDao.getOneStudentData2(student_id);
		LibrarianDto librarianDto = librarianDao.getOneData2(librarian_id);
		if (bookDto != null && studentDto != null && librarianDto != null) {
			if (bookDto.getStatus().equalsIgnoreCase("Available")) {
				bookDto.setStatus("Requested");
				bookDto.setStudent(studentDto);
				//bookDto.setLibrarianDto(librarianDto);
				return bookDao.requsetBook(bookDto);
			} else {
				System.out.println("This book is already requested or issued");
			}return false;
		}
		return false;

	}
	
	
	// get all Unapprove Librarian data
		public List<LibrarianDto> getAllDataUnapprovedLibrarian() {
			List<LibrarianDto> l = librarianDao.getAllUnapprovedLibrarian();
			return l;

		}

}
