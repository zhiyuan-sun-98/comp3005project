package com.itheima.service;

import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.UserDao;
import com.itheima.domain.Book;
import com.itheima.domain.User;

@Transactional
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public int save(User user) {
		return  userDao.save(user);
	}

	public User login(User user) {
		
		return userDao.login(user);
	}




}
