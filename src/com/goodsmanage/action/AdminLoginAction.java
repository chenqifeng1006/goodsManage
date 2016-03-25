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
		AdminDAO adminDAO = new AdminDAO();
		ActionContext ctx = ActionContext.getContext();
		if (!adminDAO.checkLogin(admin)) {
			ctx.put("error",  java.net.URLEncoder.encode(adminDAO.getErrMessage()));
			return "error";
		}
		admin=adminDAO.getManager(admin.getLoginid());
		ctx.getSession().put("name", admin.getName());
		ctx.getSession().put("loginid", admin.getLoginid());
		ctx.getSession().put("telephone", admin.getTelephone());
        
		return "main_view";
	}
	
	public String update() {
		AdminDAO adminDAO = new AdminDAO();
		ActionContext ctx = ActionContext.getContext();
		try {
			adminDAO.update(admin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ctx.getSession().put("name", admin.getName());
		ctx.getSession().put("loginid", admin.getLoginid());
		ctx.getSession().put("telephone", admin.getTelephone());
        
		return "main_view";
	}
	
	
	public String updatePassword() {
		AdminDAO adminDAO = new AdminDAO();
		ActionContext ctx = ActionContext.getContext();
		try {
			adminDAO.changePassword(admin.getLoginid(),admin.getOldPassword(), admin.getPassword());
		} catch (Exception e) {
			ctx.put("error",  java.net.URLEncoder.encode(adminDAO.getErrMessage()));
			e.printStackTrace();
		}
		
		ctx.getSession().put("name", admin.getName());
		ctx.getSession().put("loginid", admin.getLoginid());
		ctx.getSession().put("telephone", admin.getTelephone());
        
		return "main_view";
	}
	
	

	

}
