package com.itheima.service;

import com.itheima.domain.Book;
import com.itheima.domain.User;

public interface UserService {

	public int save(User user);

	public User login(User user);
	
}
