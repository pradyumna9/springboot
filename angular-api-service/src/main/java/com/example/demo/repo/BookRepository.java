package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

	 Book findBookByBookName(String bookName);
}
