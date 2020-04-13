package com.itheima.dao;

import com.itheima.domain.Book;
import com.itheima.domain.User;

public interface UserDao {

	public int save(User user);

	public User login(User user);
	
}
