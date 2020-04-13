package com.itheima.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.commom.IDUtils;
import com.itheima.domain.Book;
import com.itheima.domain.OrderItem;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {

	public int addShop(int userId, HashMap<Integer, Integer> map) {
		String bookId ="";
        String num ="";
        int price = 0;
		Book book = new Book();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        	bookId=bookId + entry.getKey() +" ";
        	num=num + entry.getValue() +" ";
        	
        	Long bookId2 = Long.parseLong((entry.getKey()+"")) ;        	
        	book = this.getHibernateTemplate().get(Book.class, bookId2);        	
   
        	autoAddBook(bookId2,Long.parseLong((entry.getValue()+"")));
        	
        	if(addSailBook(bookId2,Long.parseLong((entry.getValue()+""))) != true){
        		return 0;
        	}
	
        	System.out.println(book);
        	price += (int) (book.getPrice()* entry.getValue());
        }
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String orderDate = df.format(new Date());
		
		OrderItem order = new OrderItem();
		order.setUserId((long) userId);
		order.setBookId(bookId);
		order.setNum(num);
		order.setOrderDate(orderDate);
		order.setPrice(price);
		order.setLocation("New York");
		
		Serializable save = this.getHibernateTemplate().save(order);
		int code = Integer.parseInt(save+"");
		if(code >0){
			return 1;
		}
		return 0;
	}

	public OrderItem orderDetailById(int id) {     
		return this.getHibernateTemplate().get(OrderItem.class, Long.parseLong(id+""));
	}

	//查看所有订单
	public List<OrderItem> allOrder() {
		DetachedCriteria criteria = DetachedCriteria.forClass(OrderItem.class);
		List<OrderItem> orderList = (List<OrderItem>) this.getHibernateTemplate().findByCriteria(criteria);
		
		return orderList;
	}
	
	private boolean addSailBook(Long bookId,Long num){
		Book book = this.getHibernateTemplate().get(Book.class, bookId);
		if(num> book.getNumber() ){
			return false;
		}		
		Long sailBook = num +book.getSailBook();
		Long number = book.getNumber() - num;
		book.setSailBook(sailBook);
		book.setNumber(number);
		return true;
	}
	
	private void autoAddBook(Long bookId,Long num){
		Book book = this.getHibernateTemplate().get(Book.class, bookId);
		Long n = book.getNumber();
		if((n - num) <10 ){
			book.setNumber(n+10);
			this.getHibernateTemplate().save(book);
		}		

	}

}
