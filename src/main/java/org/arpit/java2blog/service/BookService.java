package org.arpit.java2blog.service;

import org.arpit.java2blog.model.Book;
import org.arpit.java2blog.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class BookService
{

	@Autowired
	BookRepository bookRepository;

	@Transactional
	public List<Book> getAllBooks() {
		List<Book> books=new ArrayList<Book>();
		Iterable<Book> booksIterable=bookRepository.findAll();
		Iterator<Book> booksIterator=booksIterable.iterator();
		while(booksIterator.hasNext())
		{
			books.add(booksIterator.next());
		}
		return books;
	}

	@Transactional
	public Book getBook(int id) {
		Optional<Book> book =  bookRepository.findById(new Long(id));
		return book.get();
	}

	@Transactional
	public void addBook(Book book) {
		bookRepository.save(book);
	}

	@Transactional
	public void updateBook(Book book) {
		bookRepository.save(book);

	}

	@Transactional
	public void deleteBook(int id) {
		bookRepository.deleteById(new Long(id));
	}
}
