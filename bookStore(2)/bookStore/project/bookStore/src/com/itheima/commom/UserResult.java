package com.itheima.commom;

import java.io.Serializable;

public class UserResult implements Serializable{

	private int code;
	private int userId;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
}
