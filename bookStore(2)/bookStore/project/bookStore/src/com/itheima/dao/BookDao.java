package com.itheima.dao;

import java.util.HashMap;
import java.util.List;

import com.itheima.domain.Book;

public interface BookDao {

	Book bookDetail(Long id);

	List<Book> allBooks();

	int addBook(Book book);

	int deleteBook(Long id);

	Book search(Long iSBN);



}
