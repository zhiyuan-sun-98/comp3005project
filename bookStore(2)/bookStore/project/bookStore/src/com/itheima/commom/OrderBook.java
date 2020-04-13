package com.itheima.commom;

public class OrderBook {

	private int bookId;
	private int num;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "OrderBook [bookId=" + bookId + ", num=" + num + "]";
	}
	
}
