package com.itheima.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.domain.Book;

public class BookDaoImpl extends HibernateDaoSupport implements BookDao {


	public Book bookDetail(Long id) {
		return this.getHibernateTemplate().get(Book.class, id);
	}

	public List<Book> allBooks() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Book.class);
		List<Book> list = (List<Book>) this.getHibernateTemplate().findByCriteria(criteria);
		
		return list;
	}

	public int addBook(Book book) {
		System.out.println(book);
		Serializable save = this.getHibernateTemplate().save(book);
        int i = Integer.parseInt(save+"");
        if(i >0){
        	return 1;
        }
		return 0;
	}

	public int deleteBook(Long id) {
        Book book = new Book();
        book.setBookID(id);
        System.out.println(book);
		this.getHibernateTemplate().delete(book);
		return 1;
	}

	public Book search(Long ISBN) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Book.class);
		criteria.add(Restrictions.eq("ISBN", ISBN));
		/*if(book.getBookName() != null){
			criteria.add(Restrictions.ilike("bookName", book.getBookName()));
		}
		if(book.getAuthorName() != null){
			criteria.add(Restrictions.ilike("authorName", book.getAuthorName()));
		}
		if(book.getISBN() != null){
			criteria.add(Restrictions.ilike("ISBN", book.getISBN()));
		}
		if(book.getGenre() != null){
			criteria.add(Restrictions.ilike("gener", book.getGenre()));
		}*/
		
		List<Book> list = (List<Book>) this.getHibernateTemplate().findByCriteria(criteria);
		return list.get(0);
	}





}
