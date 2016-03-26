package com.goodsmanage.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.goodsmanage.domain.BorrowGoodsRecord;
import com.goodsmanage.utils.HibernateUtil;


public class BorrowGoodsRecordDAO {

    /*ÿҳ��ʾ��¼��Ŀ*/
    private final int PAGE_SIZE = 6;

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
    public void add(BorrowGoodsRecord entity) throws Exception {
        Session s = null;
        Transaction tx = null;
        try { 
            s = HibernateUtil.getSession();
            tx = s.beginTransaction(); 
            s.save(entity);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*��ѯ��Ϣ*/
    public ArrayList<BorrowGoodsRecord> query(int currentPage,int pageSize,String userno,String goodsname) { 
        Session s = null; 
        BorrowGoodsDAO dao = new BorrowGoodsDAO();
        try {
            s = HibernateUtil.getSession();
            String hql = "From BorrowGoodsRecord borrowGoodsRecord where 1=1";
            if(StringUtils.isNotBlank(userno)){
            	hql+="and userno="+userno;
            }
            if(StringUtils.isNotBlank(userno)){
            	hql+="and goodsname like '%"+goodsname+"%'";
            }
/*            if(null != member && !member.getUserNo().equals("")) hql += " and inputCashTable.member.userNo='" + member.getUserNo() + "'";
            if(null != inputFroms && inputFroms.getInputClassId()!=0) hql += " and inputCashTable.inputFroms.inputClassId=" + inputFroms.getInputClassId();
            if(null != payWayObj && payWayObj.getPayWayId()!=0) hql += " and inputCashTable.payWayObj.payWayId=" + payWayObj.getPayWayId();
            if(!inputDateTime.equals("")) hql = hql + " and inputCashTable.inputDateTime like '%" + inputDateTime + "%'";*/
            Query q = s.createQuery(hql);
            /*���㵱ǰ��ʾҳ��Ŀ�ʼ��¼*/
            int startIndex = (currentPage-1) * pageSize;
            q.setFirstResult(startIndex);
            q.setMaxResults(this.PAGE_SIZE);
            List recordList = q.list();
            if(recordList==null){
            	return null;
            }
            List<BorrowGoodsRecord>   list =(ArrayList<BorrowGoodsRecord>) recordList;

            for(int i=0;i<list.size();i++ ){
            	list.get(i).setGoodsname(dao.getById(list.get(i).getGoodsid()).getGoodsname());
            }
            
            return (ArrayList<BorrowGoodsRecord>) list;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*�����ܵ�ҳ���ͼ�¼��*/
    public void CalculateTotalPageAndRecordNumber(String userno,String goodsname) {
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            String hql = "From BorrowGoodsRecord borrowGoodsRecord where 1=1";
            if(StringUtils.isNotBlank(userno)){
            	hql+="and userno="+userno;
            }
            if(StringUtils.isNotBlank(userno)){
            	hql+="and goodsname like '%"+goodsname+"%'";
            }
     /*       if(null != member && !member.getUserNo().equals("")) hql += " and inputCashTable.member.userNo='" + member.getUserNo() + "'";
            if(null != inputFroms && inputFroms.getInputClassId()!=0) hql += " and inputCashTable.inputFroms.inputClassId=" + inputFroms.getInputClassId();
            if(null != payWayObj && payWayObj.getPayWayId()!=0) hql += " and inputCashTable.payWayObj.payWayId=" + payWayObj.getPayWayId();
            if(!inputDateTime.equals("")) hql = hql + " and inputCashTable.inputDateTime like '%" + inputDateTime + "%'";*/
            Query q = s.createQuery(hql);
            List list = q.list();
            recordNumber = list.size();
            int mod = recordNumber % this.PAGE_SIZE;
            totalPage = recordNumber / this.PAGE_SIZE;
            if(mod != 0) totalPage++;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*����������ȡ����*/
    public BorrowGoodsRecord getById(int id) {
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            BorrowGoodsRecord entity = (BorrowGoodsRecord)s.get(BorrowGoodsRecord.class, id);
            return entity;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*����InputCashTable��Ϣ*/
    public void update(BorrowGoodsRecord entity) throws Exception {
        Session s = null;
        Transaction tx = null;
        try {
            s = HibernateUtil.getSession();
            tx = s.beginTransaction();
            s.update(entity);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
            	  tx.rollback();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*ɾ����Ϣ*/
    public void delete (int inputId) throws Exception {
        Session s = null;
        Transaction tx = null;
        try {
            s = HibernateUtil.getSession();
            tx = s.beginTransaction();
            Object obj = s.get(BorrowGoodsRecord.class, inputId);
            s.delete(obj);
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
