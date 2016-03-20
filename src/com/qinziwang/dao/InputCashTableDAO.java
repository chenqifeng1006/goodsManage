package com.qinziwang.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qinziwang.domain.MemberInfo;
import com.qinziwang.utils.ClassInputCashTable;
import com.qinziwang.utils.HibernateUtil;
import com.qinziwang.utils.InputCashTable;
import com.qinziwang.utils.PayWay;

public class InputCashTableDAO {

    /*ÿҳ��ʾ��¼��Ŀ*/
    private final int PAGE_SIZE = 10;

    /*�����ѯ���ܵ�ҳ��*/
    private int totalPage;
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getTotalPage() {
        return totalPage;
    }

    /*�����ѯ�����ܼ�¼��*/
    private int recordNumber;
    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }
    public int getRecordNumber() {
        return recordNumber;
    }

    /*���ͼ����Ϣ*/
    public void AddInputCashTable(InputCashTable inputCashTable) throws Exception {
        Session s = null;
        Transaction tx = null;
        try { 
            s = HibernateUtil.getSession();
            tx = s.beginTransaction(); 
            s.save(inputCashTable);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*��ѯInputCashTable��Ϣ*/
    public ArrayList<InputCashTable> QueryInputCashTableInfo(MemberInfo member,ClassInputCashTable inputFroms,PayWay payWayObj,String inputDateTime,int currentPage) { 
        Session s = null; 
        try {
            s = HibernateUtil.getSession();
            String hql = "From InputCashTable inputCashTable where 1=1";
            if(null != member && !member.getUserNo().equals("")) hql += " and inputCashTable.member.userNo='" + member.getUserNo() + "'";
            if(null != inputFroms && inputFroms.getInputClassId()!=0) hql += " and inputCashTable.inputFroms.inputClassId=" + inputFroms.getInputClassId();
            if(null != payWayObj && payWayObj.getPayWayId()!=0) hql += " and inputCashTable.payWayObj.payWayId=" + payWayObj.getPayWayId();
            if(!inputDateTime.equals("")) hql = hql + " and inputCashTable.inputDateTime like '%" + inputDateTime + "%'";
            Query q = s.createQuery(hql);
            /*���㵱ǰ��ʾҳ��Ŀ�ʼ��¼*/
            int startIndex = (currentPage-1) * this.PAGE_SIZE;
            q.setFirstResult(startIndex);
            q.setMaxResults(this.PAGE_SIZE);
            List inputCashTableList = q.list();
            return (ArrayList<InputCashTable>) inputCashTableList;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*�������ܣ���ѯ���е�InputCashTable��¼*/
    public ArrayList<InputCashTable> QueryAllInputCashTableInfo() {
        Session s = null; 
        try {
            s = HibernateUtil.getSession();
            String hql = "From InputCashTable";
            Query q = s.createQuery(hql);
            List inputCashTableList = q.list();
            return (ArrayList<InputCashTable>) inputCashTableList;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*�����ܵ�ҳ���ͼ�¼��*/
    public void CalculateTotalPageAndRecordNumber(MemberInfo member,ClassInputCashTable inputFroms,PayWay payWayObj,String inputDateTime) {
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            String hql = "From InputCashTable inputCashTable where 1=1";
            if(null != member && !member.getUserNo().equals("")) hql += " and inputCashTable.member.userNo='" + member.getUserNo() + "'";
            if(null != inputFroms && inputFroms.getInputClassId()!=0) hql += " and inputCashTable.inputFroms.inputClassId=" + inputFroms.getInputClassId();
            if(null != payWayObj && payWayObj.getPayWayId()!=0) hql += " and inputCashTable.payWayObj.payWayId=" + payWayObj.getPayWayId();
            if(!inputDateTime.equals("")) hql = hql + " and inputCashTable.inputDateTime like '%" + inputDateTime + "%'";
            Query q = s.createQuery(hql);
            List inputCashTableList = q.list();
            recordNumber = inputCashTableList.size();
            int mod = recordNumber % this.PAGE_SIZE;
            totalPage = recordNumber / this.PAGE_SIZE;
            if(mod != 0) totalPage++;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*����������ȡ����*/
    public InputCashTable GetInputCashTableByInputId(int inputId) {
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            InputCashTable inputCashTable = (InputCashTable)s.get(InputCashTable.class, inputId);
            return inputCashTable;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*����InputCashTable��Ϣ*/
    public void UpdateInputCashTable(InputCashTable inputCashTable) throws Exception {
        Session s = null;
        Transaction tx = null;
        try {
            s = HibernateUtil.getSession();
            tx = s.beginTransaction();
            s.update(inputCashTable);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
            	  tx.rollback();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*ɾ��InputCashTable��Ϣ*/
    public void DeleteInputCashTable (int inputId) throws Exception {
        Session s = null;
        Transaction tx = null;
        try {
            s = HibernateUtil.getSession();
            tx = s.beginTransaction();
            Object inputCashTable = s.get(InputCashTable.class, inputId);
            s.delete(inputCashTable);
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
