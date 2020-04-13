package com.itheima.commom;

public class ShopItem {

	private int bookId;
	private int count;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "ShopItem [bookId=" + bookId + ", count=" + count + "]";
	}

	
}
