package com.itheima.commom;

import java.util.LinkedList;
import java.util.List;

public class AddShopItem {

	private int id;
	
	private LinkedList<ShopItem> bookData;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LinkedList<ShopItem> getBookData() {
		return bookData;
	}
	public void setBookData(LinkedList<ShopItem> bookData) {
		this.bookData = bookData;
	}
}
