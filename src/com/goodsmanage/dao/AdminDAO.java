package com.goodsmanage.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.goodsmanage.domain.Admin;
import com.goodsmanage.domain.User;
import com.goodsmanage.utils.HibernateUtil;


public class AdminDAO {
	/*����ҵ���߼�������Ϣ�ֶ�*/
	private String errMessage;
	public String getErrMessage() { return this.errMessage; }
	
	
	/*��֤�û���¼*/
	public boolean checkLogin(Admin admin) { 
		Session s = null;
		try {
			s = HibernateUtil.getSession();
			Admin manager1 = (Admin)s.get(Admin.class, admin.getLoginid());
			if(manager1 == null) { 
				this.errMessage = " �˺Ų����� ";
				System.out.print(this.errMessage);
				return false;
			} else if( !manager1.getPassword().equals(admin.getPassword())) {
				this.errMessage = " ���벻��ȷ! ";
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
	

    




    /*���*/
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

  /*  ��ѯ��Ϣ
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
            ���㵱ǰ��ʾҳ��Ŀ�ʼ��¼
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
  

    /*������Ϣ*/
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
				this.errMessage = " ��������� ";
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
