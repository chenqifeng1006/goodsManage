package com.qinziwang.action;

 

 

 

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qinziwang.dao.ManagerDAO;
import com.qinziwang.domain.Manager;

public class ManagerLoginAction extends ActionSupport {
 
	
	private Manager manager;

	


	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	/*直接跳转到登陆界面*/
	public String view() {
		
		return "login_view";
	}
	/*直接跳转到注册界面*/
	public String registView() {
		
		return "regist_view";
	}
	
	/* 验证用户登录 */
	public String CheckLogin() {
		ManagerDAO managerDAO = new ManagerDAO();
		ActionContext ctx = ActionContext.getContext();
		if (!managerDAO.checkLogin(manager)) {
			ctx.put("error",  java.net.URLEncoder.encode(managerDAO.getErrMessage()));
			return "error";
		}
		ctx.getSession().put("username", manager.getUsername());
		return "main_view";
	}
	
	

	

}
