package com.itheima.service;

import java.util.HashMap;
import java.util.List;

import com.itheima.domain.OrderItem;

public interface OrderService {

	int addShop(int userId, HashMap<Integer, Integer> map);

	OrderItem orderDetailById(int id);

	List<OrderItem> allOrder();

}
