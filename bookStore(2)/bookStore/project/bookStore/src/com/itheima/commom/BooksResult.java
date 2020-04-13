package com.itheima.commom;

import java.io.Serializable;
import java.util.List;

import com.itheima.domain.Book;

public class BooksResult implements Serializable{

	private int code;
	private List<Book> list;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}
	
	
}
