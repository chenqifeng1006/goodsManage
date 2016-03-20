package com.qinziwang.action;

 

 

 

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qinziwang.dao.UserDAO;
import com.qinziwang.domain.User;

public class UserLoginAction extends ActionSupport {
 
	
	private User user;

	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	
	/* 验证用户登录 */
	public String CheckLogin() {
		UserDAO userDAO = new UserDAO();
		ActionContext ctx = ActionContext.getContext();
		if (!userDAO.checkLogin(user)) {
			ctx.put("error",  java.net.URLEncoder.encode(userDAO.getErrMessage()));
			return "error";
		}
		ctx.getSession().put("username", user.getUsername());
		return "main_view";
	}
	
	
	public String regist() {

		  ActionContext ctx = ActionContext.getContext();
			UserDAO userDAO = new UserDAO();

	        try {
	        	userDAO.addUser(user);
	            ctx.put("message",  java.net.URLEncoder.encode("注册成功!"));
	            return "login_view";
	        } catch (Exception e) {
	            e.printStackTrace();
	            ctx.put("error",  java.net.URLEncoder.encode("注册失败!"));
	            return "error";
	        }
	}
	

}
