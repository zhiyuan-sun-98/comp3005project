package com.itheima.commom;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class AuthorResult implements Serializable{

	private int code;
	private List<AuthorItem> list;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<AuthorItem> getList() {
		return list;
	}

	public void setList(List<AuthorItem> list) {
		this.list = list;
	}




}
