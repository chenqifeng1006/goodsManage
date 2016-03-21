package com.goodsmanage.action;

 

 

 

import com.goodsmanage.dao.AdminDAO;
import com.goodsmanage.domain.Admin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginAction extends ActionSupport {
 
	
	private Admin admin;

	


	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
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
		AdminDAO managerDAO = new AdminDAO();
		ActionContext ctx = ActionContext.getContext();
		if (!managerDAO.checkLogin(admin)) {
			ctx.put("error",  java.net.URLEncoder.encode(managerDAO.getErrMessage()));
			return "error";
		}
		ctx.getSession().put("name", admin.getName());
		return "main_view";
	}
	
	

	

}
