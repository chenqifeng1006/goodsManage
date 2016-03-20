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

    /*每页显示记录数目*/
    private final int PAGE_SIZE = 10;

    /*保存查询后总的页数*/
    private int totalPage;
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getTotalPage() {
        return totalPage;
    }

    /*保存查询到的总记录数*/
    private int recordNumber;
    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }
    public int getRecordNumber() {
        return recordNumber;
    }

    /*添加图书信息*/
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

    /*查询InputCashTable信息*/
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
            /*计算当前显示页码的开始记录*/
            int startIndex = (currentPage-1) * this.PAGE_SIZE;
            q.setFirstResult(startIndex);
            q.setMaxResults(this.PAGE_SIZE);
            List inputCashTableList = q.list();
            return (ArrayList<InputCashTable>) inputCashTableList;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*函数功能：查询所有的InputCashTable记录*/
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

    /*计算总的页数和记录数*/
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

    /*根据主键获取对象*/
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

    /*更新InputCashTable信息*/
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

    /*删除InputCashTable信息*/
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
