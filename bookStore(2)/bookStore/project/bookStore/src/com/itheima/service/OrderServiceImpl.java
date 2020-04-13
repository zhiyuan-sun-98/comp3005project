package com.itheima.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.OrderDao;
import com.itheima.domain.OrderItem;

@Transactional
public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao;
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	public int addShop(int userId, HashMap<Integer, Integer> map) {
		return orderDao.addShop(userId,map);		
	}
	public OrderItem orderDetailById(int id) {
		return orderDao.orderDetailById(id);
	}
	public List<OrderItem> allOrder() {
		return orderDao.allOrder();
	}
	
}
