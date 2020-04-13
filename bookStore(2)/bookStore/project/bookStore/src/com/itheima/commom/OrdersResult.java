package com.itheima.commom;

import java.io.Serializable;
import java.util.LinkedList;

import com.itheima.domain.OrderItem;

public class OrdersResult implements Serializable{

	private int code;
	private LinkedList<OItem> list;


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public LinkedList<OItem> getList() {
		return list;
	}

	public void setList(LinkedList<OItem> list) {
		this.list = list;
	}

	


	
}
