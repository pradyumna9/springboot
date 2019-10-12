package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue
	private Long bookId;
	private String bookName;
	@Column(name="price")
	private BigDecimal bookPrice;
	private String authorName;
	
	public Book(Long bookId, String bookName, BigDecimal bookPrice, String authorName) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.authorName = authorName;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public BigDecimal getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(BigDecimal bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
	
}
