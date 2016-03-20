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
	/*ֱ����ת����½����*/
	public String view() {
		
		return "login_view";
	}
	/*ֱ����ת��ע�����*/
	public String registView() {
		
		return "regist_view";
	}
	
	/* ��֤�û���¼ */
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
