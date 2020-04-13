package com.itheima.domain;

public class Book {
	
    private Long bookID;
    private String bookName;
	private String authorName;
	private Long ISBN;
    private String genre;
	private String publisher;
	private Long pages;
	private Long price;
	private Long number;
	
	private Long sailBook;
	private String pubAddress;
	private String pubEmail;
	private int pubPhone;
	private int pubBank;
	public Long getBookID() {
		return bookID;
	}
	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Long getISBN() {
		return ISBN;
	}
	public void setISBN(Long iSBN) {
		ISBN = iSBN;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Long getPages() {
		return pages;
	}
	public void setPages(Long pages) {
		this.pages = pages;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public Long getSailBook() {
		return sailBook;
	}
	public void setSailBook(Long sailBook) {
		this.sailBook = sailBook;
	}
	public String getPubAddress() {
		return pubAddress;
	}
	public void setPubAddress(String pubAddress) {
		this.pubAddress = pubAddress;
	}
	public String getPubEmail() {
		return pubEmail;
	}
	public void setPubEmail(String pubEmail) {
		this.pubEmail = pubEmail;
	}
	public int getPubPhone() {
		return pubPhone;
	}
	public void setPubPhone(int pubPhone) {
		this.pubPhone = pubPhone;
	}
	public int getPubBank() {
		return pubBank;
	}
	public void setPubBank(int pubBank) {
		this.pubBank = pubBank;
	}
	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", bookName=" + bookName + ", authorName=" + authorName + ", ISBN=" + ISBN
				+ ", genre=" + genre + ", publisher=" + publisher + ", pages=" + pages + ", price=" + price
				+ ", number=" + number + ", sailBook=" + sailBook + ", pubAddress=" + pubAddress + ", pubEmail="
				+ pubEmail + ", pubPhone=" + pubPhone + ", pubBank=" + pubBank + "]";
	}
	
	
}
