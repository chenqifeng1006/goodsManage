package com.goodsmanage.action;

 

 

 

import com.goodsmanage.dao.AdminDAO;
import com.goodsmanage.dao.UserDAO;
import com.goodsmanage.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

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
		user=userDAO.getUser(user.getUserno());
		ctx.getSession().put("userno", user.getUserno());
		ctx.getSession().put("username", user.getUsername());
		ctx.getSession().put("password", user.getPassword());
		ctx.getSession().put("telephone", user.getTelephone());
		ctx.getSession().put("address", user.getAddress());


		return "main_view";
	}
	public String update() {
		UserDAO  dao= new UserDAO();
		ActionContext ctx = ActionContext.getContext();
		user.setUserno(ctx.getSession().get("userno").toString());
		try {
			dao.update(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ctx.getSession().put("userno", user.getUserno());
		ctx.getSession().put("username", user.getUsername());
		ctx.getSession().put("password", user.getPassword());
		ctx.getSession().put("telephone", user.getTelephone());
		ctx.getSession().put("address", user.getAddress());

		return "main_view";
	}
	
	
	public String updatePassword() {
		UserDAO  dao= new UserDAO();
		ActionContext ctx = ActionContext.getContext();
		user.setUserno(ctx.getSession().get("userno").toString());
		try {
			boolean bool=dao.ChangePassword(user.getUserno(),user.getOldPassword(), user.getPassword());
			if(bool==false){
				ctx.put("error",  java.net.URLEncoder.encode(dao.getErrMessage()));
				return "error";
			}
		} catch (Exception e) {
			ctx.put("error",  java.net.URLEncoder.encode(dao.getErrMessage()));
			e.printStackTrace();
		}
		
		ctx.getSession().put("userno", user.getUserno());
		ctx.getSession().put("username", user.getUsername());
		ctx.getSession().put("password", user.getPassword());
		ctx.getSession().put("telephone", user.getTelephone());
		ctx.getSession().put("address", user.getAddress());
		return "main_view";
	}
	
	


}
