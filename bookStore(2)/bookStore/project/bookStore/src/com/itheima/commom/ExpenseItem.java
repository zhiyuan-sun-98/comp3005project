package com.itheima.commom;

public class ExpenseItem {

	private String publisher;
	private Long price;
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ExpenseItem [publisher=" + publisher + ", price=" + price + "]";
	}

}
