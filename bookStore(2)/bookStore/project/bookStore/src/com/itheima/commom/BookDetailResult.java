package com.itheima.commom;

import java.io.Serializable;

import com.itheima.domain.Book;

public class BookDetailResult implements Serializable{

	private int code;
	private Book book;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}
