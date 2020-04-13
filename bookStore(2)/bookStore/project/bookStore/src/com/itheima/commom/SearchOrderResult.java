package com.itheima.commom;

import java.io.Serializable;
import java.util.LinkedList;

import com.itheima.domain.OrderItem;

public class SearchOrderResult implements Serializable{

	private int code;
    private String orderDate;
    private String location;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
    

	


	
}
