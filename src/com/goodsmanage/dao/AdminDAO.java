package com.goodsmanage.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.goodsmanage.domain.Admin;
import com.goodsmanage.domain.User;
import com.goodsmanage.utils.HibernateUtil;


public class AdminDAO {
	/*保存业务逻辑错误信息字段*/
	private String errMessage;
	public String getErrMessage() { return this.errMessage; }
	
	
	/*验证用户登录*/
	public boolean checkLogin(Admin admin) { 
		Session s = null;
		try {
			s = HibernateUtil.getSession();
			Admin manager1 = (Admin)s.get(Admin.class, admin.getLoginid());
			if(manager1 == null) { 
				this.errMessage = " 账号不存在 ";
				System.out.print(this.errMessage);
				return false;
			} else if( !manager1.getPassword().equals(admin.getPassword())) {
				this.errMessage = " 密码不正确! ";
				System.out.print(this.errMessage);
				return false;
			}
		} finally {
			HibernateUtil.closeSession();
		} 
		return true;
	}
	

	public static Admin getManager(String loginid) {
		Session s = null;
		Admin manager = null;
		try {
			s = HibernateUtil.getSession();
			manager = (Admin)s.get(Admin.class, loginid); 
		} finally {
			HibernateUtil.closeSession();
		} 
		return manager;
	}
	

    




    /*添加*/
 /*   public void add(Admin manager) throws Exception {
        Session s = null;
        Transaction tx = null;
        try { 
            s = HibernateUtil.getSession();
            tx = s.beginTransaction(); 
            s.save(manager);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }*/

  /*  查询信息
    public ArrayList<Admin> Query(int currentPage) { 
        Session s = null; 
        try {
            s = HibernateUtil.getSession();
            String hql = "From Manager manager where 1=1";
            if(null != member && !member.getUserNo().equals("")) hql += " and inputCashTable.member.userNo='" + member.getUserNo() + "'";
            if(null != inputFroms && inputFroms.getInputClassId()!=0) hql += " and inputCashTable.inputFroms.inputClassId=" + inputFroms.getInputClassId();
            if(null != payWayObj && payWayObj.getPayWayId()!=0) hql += " and inputCashTable.payWayObj.payWayId=" + payWayObj.getPayWayId();
            if(!inputDateTime.equals("")) hql = hql + " and inputCashTable.inputDateTime like '%" + inputDateTime + "%'";
            Query q = s.createQuery(hql);
            计算当前显示页码的开始记录
            int startIndex = (currentPage-1) * this.PAGE_SIZE;
            q.setFirstResult(startIndex);
            q.setMaxResults(this.PAGE_SIZE);
            List list = q.list();
            return (ArrayList<Admin>) list;
        } finally {
            HibernateUtil.closeSession();
        }
    }

*/
  

    /*更新信息*/
    public void update(Admin admin) throws Exception {
        Session s = null;
        Transaction tx = null;
        try {
            s = HibernateUtil.getSession();
            tx = s.beginTransaction();
            s.update(admin);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
            	  tx.rollback();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

	public  void changePassword(String loginid, String oldPassword,String newPassword) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			Admin db_admin = (Admin)s.get(Admin.class, loginid);
			if(!db_admin.getPassword().equals(oldPassword)){
				this.errMessage = " 旧密码错误 ";
			}else{
				db_admin.setPassword(newPassword);
				s.save(db_admin);
				tx.commit();
			}
		
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}  finally {
			HibernateUtil.closeSession();
		}  
	}

}
