package com.itheima.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.BookDao;
import com.itheima.domain.Book;

@Transactional
public class BookServiceImpl implements BookService {

	private BookDao bookDao;
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	public Book bookDetail(Long id) {      
		return bookDao.bookDetail(id);
	}
	
	public List<Book> allBooks() {
		return bookDao.allBooks();
	}

	public int addBook(Book book) {
		return bookDao.addBook(book);
	}

	public int deleteBook(Long id) {
		return bookDao.deleteBook(id);
	}

	public Book search(Long ISBN) {
		return bookDao.search(ISBN);
	}

	public HashMap<String, Long> genre(){		
		List<Book> allBooks = bookDao.allBooks();
        HashMap<String, Long> map = new HashMap<>();
        String genre ="";
        Long sailBook =(long) 0;
        for(Book book : allBooks){
	       genre = book.getGenre();
	       sailBook = book.getSailBook();
	       if(map.containsKey(genre)){
	           sailBook = sailBook + map.get(genre);
	           map.put(genre, sailBook);
	       }else{
	       	   map.put(genre, sailBook);
	       }
       	 
        }
        
        return map;
	}

	public HashMap<String, Long> author() {
		List<Book> allBooks = bookDao.allBooks();
        HashMap<String, Long> map = new HashMap<>();
        String author ="";
        Long sailBook =(long) 0;
        for(Book book : allBooks){
           author = book.getAuthorName();
	       sailBook = book.getSailBook();
	       if(map.containsKey(author)){
	           sailBook = sailBook + map.get(author);
	       }else{
	       	   map.put(author, sailBook);
	       }
       	 
        }
        
        return map;
	}
	
	public HashMap<String, Long> expense() {
		List<Book> allBooks = bookDao.allBooks();
        HashMap<String, Long> map = new HashMap<>();
        HashMap<String, Long> mapPrice = new HashMap<>();
        String publisher ="";
        Long sailBook =(long) 0;
        Long price = (long) 0;
        for(Book book : allBooks){
           publisher = book.getPublisher();
	       sailBook = book.getSailBook();
	       price = book.getPrice();
	       if(map.containsKey(publisher)){
	           sailBook = sailBook + map.get(publisher);
	       }else{
	       	   map.put(publisher, sailBook);
	       	   mapPrice.put(publisher, price);
	       }
       	 
        }
        
		 for(Map.Entry<String, Long> entry : map.entrySet()){
			 Long num = entry.getValue();
			 if(0 < num && num < 10){
				 map.put(entry.getKey(), (long) (0.1 *num * mapPrice.get(entry.getKey())));
			 }else if(num < 100){
				 map.put(entry.getKey(), (long) (0.2 *num * mapPrice.get(entry.getKey())));
			 }else{
				 map.put(entry.getKey(), (long) (0.3 *num * mapPrice.get(entry.getKey())));
			 }
		 }
        
        return map;
	}
	
}
