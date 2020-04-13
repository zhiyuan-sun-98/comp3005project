package com.itheima.dao;

import java.util.HashMap;
import java.util.List;

import com.itheima.domain.OrderItem;

public interface OrderDao {

	int addShop(int userId, HashMap<Integer, Integer> map);

	OrderItem orderDetailById(int id);

	List<OrderItem> allOrder();

}
