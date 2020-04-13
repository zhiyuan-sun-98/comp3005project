package com.itheima.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.itheima.commom.AuthorItem;
import com.itheima.commom.AuthorResult;
import com.itheima.commom.BookDetailResult;
import com.itheima.commom.BooksResult;
import com.itheima.commom.CodeResult;
import com.itheima.commom.ExpenseItem;
import com.itheima.commom.ExpenseResult;
import com.itheima.commom.GenreItem;
import com.itheima.commom.GenreResult;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import com.itheima.utils.FastJsonUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BookAction extends ActionSupport implements ModelDriven<Book> {

	private static final long serialVersionUID = -8675614587354516320L;

	private Book book = new  Book();
	public Book getModel() {
		return book;
	}
	private Long id;
	public Long getId() {
		return id;
	}	
	public void setId(Long id) {
		this.id = id;
	}	
	private BookService bookService;
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public String bookDetail(){
		 Book bookDetail = bookService.bookDetail(id);
		 
		 BookDetailResult bookDetailResult = new BookDetailResult();
		 bookDetailResult.setCode(1);
		 bookDetailResult.setBook(bookDetail);
		 
         String jsonString = FastJsonUtil.toJSONString(bookDetailResult);
		 HttpServletResponse response = ServletActionContext.getResponse();
		 FastJsonUtil.write_json(response,jsonString);			 
		 return NONE;
	}

	public String allBooks(){
		 List<Book> books = bookService.allBooks();
		 BooksResult booksResult = new BooksResult();
		 booksResult.setCode(1);
		 booksResult.setList(books);		 
         String jsonString = FastJsonUtil.toJSONString(booksResult);
		 HttpServletResponse response = ServletActionContext.getResponse();
		 FastJsonUtil.write_json(response,jsonString);			 
		 return NONE;
	}
	
	public String addBook(){
		 int code = bookService.addBook(book);
		 CodeResult codeResult = new CodeResult();
		 codeResult.setCode(code);
		 String jsonString = FastJsonUtil.toJSONString(codeResult);
		 HttpServletResponse response = ServletActionContext.getResponse();
		 FastJsonUtil.write_json(response,jsonString);	
		 return NONE;
	}
	
	public String deleteBook(){
		System.out.println(1);
		 int code = bookService.deleteBook(id);
         String jsonString = FastJsonUtil.toJSONString(code);
		 HttpServletResponse response = ServletActionContext.getResponse();
		 FastJsonUtil.write_json(response,jsonString);				 
		 return NONE;
	}
	
	public String search(){
		 Book b = bookService.search(book.getISBN());		 
		 BookDetailResult bd = new BookDetailResult();
		 bd.setCode(1);
		 bd.setBook(b);
		 String jsonString = FastJsonUtil.toJSONString(bd);
		 HttpServletResponse response = ServletActionContext.getResponse();
		 FastJsonUtil.write_json(response,jsonString);	
		 return NONE;
	}
	
	public String genre(){
		 HashMap<String, Long> map = bookService.genre();
         GenreResult genreResult = new GenreResult();
         genreResult.setCode(1);
       
         LinkedList<GenreItem> list = new LinkedList<>();
         
       
         for(Map.Entry<String, Long> entry : map.entrySet()){
        	 GenreItem genreItem = new GenreItem();
        	 genreItem.setGenreName(entry.getKey());
        	 genreItem.setNumber(entry.getValue());
        	 list.add(genreItem);
        	 System.out.println("genreItem="+genreItem);
         }
         for(GenreItem G : list){
        	 System.out.println("G="+G);
         }
         genreResult.setList(list);
         
         String jsonString = FastJsonUtil.toJSONString(genreResult);
		 System.out.println(jsonString);
		 HttpServletResponse response = ServletActionContext.getResponse();
		 FastJsonUtil.write_json(response,jsonString);	
		 return NONE;
	}

	public String author(){
		 HashMap<String, Long> map = bookService.author();
		 AuthorResult authorResult =new AuthorResult();
		 authorResult.setCode(1);
         List<AuthorItem> list = new LinkedList<>();
         
         for(Map.Entry<String, Long> entry : map.entrySet()){
        	 AuthorItem authorItem = new AuthorItem();
        	 authorItem.setAuthorName(entry.getKey());
        	 authorItem.setNumber(entry.getValue());
        	 list.add(authorItem);
         }
         authorResult.setList(list);		         
         
         String jsonString = FastJsonUtil.toJSONString(authorResult);
		 System.out.println(jsonString);
         
		 HttpServletResponse response = ServletActionContext.getResponse();
		 FastJsonUtil.write_json(response,jsonString);	
		 return NONE;
	}
	
		public String expense(){
			 HashMap<String, Long> map = bookService.expense();			 
			 
			 ExpenseResult expense = new ExpenseResult();
			 expense.setCode(1);
			 List<ExpenseItem> list = new LinkedList<>();
			 for(Map.Entry<String, Long> entry : map.entrySet()){
				 ExpenseItem expenseItem = new ExpenseItem();
				 expenseItem.setPublisher(entry.getKey());
				 expenseItem.setPrice(entry.getValue());
	        	 list.add(expenseItem);
	         }
			 expense.setList(list);
			 
	         String jsonString = FastJsonUtil.toJSONString(expense);
	         
			 HttpServletResponse response = ServletActionContext.getResponse();
			 FastJsonUtil.write_json(response,jsonString);	
			 return NONE;
		}
	
}
