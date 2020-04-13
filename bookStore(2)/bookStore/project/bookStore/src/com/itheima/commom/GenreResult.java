package com.itheima.commom;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GenreResult implements Serializable{

	private int code;
	private LinkedList<GenreItem> list;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public LinkedList<GenreItem> getList() {
		return list;
	}

	public void setList(LinkedList<GenreItem> list) {
		this.list = list;
	}





}
