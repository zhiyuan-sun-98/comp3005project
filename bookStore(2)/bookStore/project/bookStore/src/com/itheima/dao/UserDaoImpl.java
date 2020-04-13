package com.itheima.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.domain.Book;
import com.itheima.domain.Manager;
import com.itheima.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	public int save(User user) {
		int code = Integer.parseInt((String) this.getHibernateTemplate().save(user)) ;
		return code;
		
	}

	@Override
	public User login(User user) {
		System.out.println(user.getUserName());
		String str = user.getUserName();
		System.out.println((str+"") == "admin");
		if(str == "admin"){
			DetachedCriteria criteria = DetachedCriteria.forClass(Manager.class);
			criteria.add(Restrictions.eq("userName", user.getUserName()));
			criteria.add(Restrictions.eq("password", user.getPassword()));
			List<Manager> list = (List<Manager>) this.getHibernateTemplate().findByCriteria(criteria);
			if(list != null && list.size() > 0){
				System.out.println(list.get(0));
			}
		}else{
			DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
			criteria.add(Restrictions.eq("userName", user.getUserName()));
			criteria.add(Restrictions.eq("password", user.getPassword()));
			List<User> list = (List<User>) this.getHibernateTemplate().findByCriteria(criteria);
			if(list != null && list.size() > 0){
				return list.get(0);
			}
		}

		return null;
	}



}
