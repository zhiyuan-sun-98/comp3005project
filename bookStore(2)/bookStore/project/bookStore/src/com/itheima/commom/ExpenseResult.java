package com.itheima.commom;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class ExpenseResult implements Serializable{

	private int code;
    private List<ExpenseItem> list;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<ExpenseItem> getList() {
		return list;
	}

	public void setList(List<ExpenseItem> list) {
		this.list = list;
	}

	
}
