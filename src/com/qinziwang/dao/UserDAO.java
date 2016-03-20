package com.qinziwang.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qinziwang.domain.User;
import com.qinziwang.utils.HibernateUtil;

public class UserDAO {
	/*����ҵ���߼�������Ϣ�ֶ�*/
	private String errMessage;
	public String getErrMessage() { return this.errMessage; }
	
	/*��֤�û���¼*/
	public boolean checkLogin(User user) { 
		Session s = null;
		try {
			s = HibernateUtil.getSession();
			User user1 = (User)s.get(User.class, user.getUsername());
			if(user1 == null) { 
				this.errMessage = " �˺Ų����� ";
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
/*	public static void ChangePassword(String username, String newPassword) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getSession();
			tx = s.beginTransaction();
			User db_admin = (User)s.get(User.class, username);
			db_admin.setPassword(newPassword);
			s.save(db_admin);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}  finally {
			HibernateUtil.closeSession();
		}  
	}*/
	
	public static User getUser(String username) {
		Session s = null;
		User user = null;
		try {
			s = HibernateUtil.getSession();
			user = (User)s.get(User.class, username); 
		} finally {
			HibernateUtil.closeSession();
		} 
		return user;
	}
	
	
    public void addUser(User user) throws Exception {
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
    }

}
