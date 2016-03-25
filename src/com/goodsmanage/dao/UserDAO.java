package com.goodsmanage.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.goodsmanage.domain.Admin;
import com.goodsmanage.domain.User;
import com.goodsmanage.utils.HibernateUtil;

public class UserDAO {
	/*����ҵ���߼�������Ϣ�ֶ�*/
	private String errMessage;
	public String getErrMessage() { return this.errMessage; }
	
	/*��֤�û���¼*/
	public boolean checkLogin(User user) { 
		Session s = null;
		try {
			s = HibernateUtil.getSession();
			User user1 = (User)s.get(User.class, user.getUserno());
			if(user1 == null) { 
				this.errMessage = "Ա�����Ų����� ";
				System.out.print(this.errMessage);
				return false;
			} else if( !user1.getPassword().equals(user.getPassword())) {
				this.errMessage = " ���벻��ȷ! ";
				System.out.print(this.errMessage);
				return false;
			}
		} finally {
			HibernateUtil.closeSession();
		} 
		return true;
	}
	

	/*�޸��û���¼����*/
	public boolean ChangePassword(String userno,String oldPassword, String newPassword) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			User db_user = (User)s.get(User.class, userno);
			if(!db_user.getPassword().equals(oldPassword)){
				this.errMessage = " ��������� ";
				return false;
			}else{
				db_user.setPassword(newPassword);
				s.save(db_user);
				tx.commit();
				return true;
			}
		
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();

			throw e;
		}  finally {
			HibernateUtil.closeSession();
		}  

	}
	
	public static User getUser(String userno) {
		Session s = null;
		User user = null;
		try {
			s = HibernateUtil.getSession();
			user = (User)s.get(User.class, userno); 
		} finally {
			HibernateUtil.closeSession();
		} 
		return user;
	}
	
	  /*������Ϣ*/
    public void update(User user) throws Exception {
        Session s = null;
        Transaction tx = null;
        try {
        	User db_user=this.getUser(user.getUserno());
        	user.setPassword(db_user.getPassword());
            s = HibernateUtil.getSession();
            tx = s.beginTransaction();
            s.update(user);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
            	  tx.rollback();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }
 /*   public void addUser(User user) throws Exception {
        Session s = null;
        Transaction tx = null;
        try { 
            s = HibernateUtil.getSession();
            tx = s.beginTransaction(); 
            s.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }*/

}
