package org.arpit.java2blog.controller;

import java.util.Date;
import java.util.List;

import org.arpit.java2blog.model.Book;
import org.arpit.java2blog.model.Subject;
import org.arpit.java2blog.service.BookService;
import org.arpit.java2blog.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LibraryManagementController
{
	
	@Autowired
	BookService bookService;

	@Autowired
	SubjectService subjectService;
	
	@RequestMapping(value = "/getAllBooks", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getBooks(Model model) {
		
		List<Book> listOfBooks = bookService.getAllBooks();
		model.addAttribute("book", new Book());
		model.addAttribute("listOfBooks", listOfBooks);
		return "bookDetails";
	}

	@RequestMapping(value = "/getBook/{bookId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Book getBookById(@PathVariable("bookId") int id) {
		return bookService.getBook(id);
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addBook(@ModelAttribute("book") Book book) {

		if(book.getBookId() == 0)
		{
			book.setBookId(526L);
			book.setSubjectId(subjectService.getSubject(12));
			book.setPublishedDate(new Date());
			bookService.addBook(book);
		}
		else
		{
			Book book1 = bookService.getBook((int)book.getBookId());
			Subject subject = subjectService.getSubject((int) book1.getSubjectId().getSubjectId());
			book.setPublishedDate(book1.getPublishedDate());
			book.setSubjectId(subject);
			bookService.updateBook(book);
		}
		
		return "redirect:/getAllBooks";
	}

	@RequestMapping(value = "/updateBook/{bookId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateBook(@PathVariable("bookId") int id,Model model) {
		    model.addAttribute("book", this.bookService.getBook(id));
		model.addAttribute("listOfBooks", this.bookService.getAllBooks());
	        return "bookDetails";
	}

	@RequestMapping(value = "/deleteBook/{bookId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteBook(@PathVariable("bookId") int id) {
		bookService.deleteBook(id);
		return "redirect:/getAllBooks";

	}


	@RequestMapping(value = "/getAllSubjects", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getSubjects(Model model) {

		List<Subject> listOfSubjects = subjectService.getAllSubjects();
		model.addAttribute("subject", new Subject());
		model.addAttribute("listOfSubjects", listOfSubjects);
		return "subjectDetails";
	}

	@RequestMapping(value = "/getSubject/{subjectId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Subject getSubjectById(@PathVariable("subjectId") int id) {
		return subjectService.getSubject(id);
	}

	@RequestMapping(value = "/addSubject", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addSubject(@ModelAttribute("subject") Subject subject) {

		if(subject.getSubjectId() == 0)
		{
			subject.setSubjectId(52);
			subjectService.addSubject(subject);
		}
		else
		{
			subjectService.updateSubject(subject);
		}

		return "redirect:/getAllSubjects";
	}

	@RequestMapping(value = "/updateSubject/{subjectId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateSubject(@PathVariable("subjectId") int id,Model model) {
		model.addAttribute("subject", this.subjectService.getSubject(id));
		model.addAttribute("listOfSubjects", this.subjectService.getAllSubjects());
		return "subjectDetails";
	}

	@RequestMapping(value = "/deleteSubject/{subjectId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteSubject(@PathVariable("subjectId") int id) {
		subjectService.deleteSubject(id);
		return "redirect:/getAllSubjects";

	}
}
