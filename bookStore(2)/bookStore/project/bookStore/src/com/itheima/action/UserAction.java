package com.itheima.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.itheima.commom.UserResult;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.FastJsonUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1511781982402769048L;

	private User user = new User();
	public User getModel() {
		return user;
	}

	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public int regist(){
		// 接收请求参数
		return userService.save(user);
	}
	
	public String login(){
		User existUser = userService.login(user);
		System.out.println(user);
		System.out.println(existUser);
		int code =0;
		if(existUser == null){
			code = 0;
			String jsonString = FastJsonUtil.toJSONString(code);
			HttpServletResponse response = ServletActionContext.getResponse();
			FastJsonUtil.write_json(response, jsonString);
			return NONE;
		}else{
			UserResult r = new UserResult();
			r.setCode(1);
			r.setUserId((int) existUser.getId());
			
			System.out.println(existUser.getId());
			
			String jsonString = FastJsonUtil.toJSONString(r);
			System.out.println(jsonString);
			HttpServletResponse response = ServletActionContext.getResponse();
			FastJsonUtil.write_json(response,jsonString);			
			return NONE;
		}
	}
	
}
