package com.itheima.service;

import java.util.HashMap;
import java.util.List;

import com.itheima.domain.Book;

public interface BookService {

	Book bookDetail(Long id);

	List<Book> allBooks();

	int addBook(Book book);

	int deleteBook(Long id);

	Book search(Long iSBN);

	HashMap<String, Long> genre();

	HashMap<String, Long> author();

	HashMap<String, Long> expense();

}
