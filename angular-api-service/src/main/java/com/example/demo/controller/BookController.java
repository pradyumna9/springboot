package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepository;
/**
 * 
 * @author PRADYUMNA
 *
 */
@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	@PostMapping("/savebook")
	public String saveBook(@RequestBody Book book) {
		bookRepository.save(book);
		return "The Book-"+book.getBookName()+" successfully saved with price"+book.getPrice();
	}
	@GetMapping("/getbook/{bookName}")
	public Book getBookByName(@PathVariable String bookName) {
		return bookRepository.findBookByBookName(bookName);
	}
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	@DeleteMapping("/deletebook/{id}")
	public String deleteBookById(@PathVariable Long id) {
		bookRepository.deleteById(id);
		return "Book Deleted SuccessFull with id:"+id;
	}
}
