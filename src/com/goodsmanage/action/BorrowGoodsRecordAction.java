package com.goodsmanage.action;

 

 

 

import java.util.Date;

import com.goodsmanage.dao.BorrowGoodsRecordDAO;
import com.goodsmanage.dao.GiveGoodsRecordDAO;
import com.goodsmanage.domain.BorrowGoodsRecord;
import com.goodsmanage.domain.GiveGoodsRecord;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BorrowGoodsRecordAction extends ActionSupport {
 

	 

	 


	private static final long serialVersionUID = 1L;
	private BorrowGoodsRecord entity;

    
  
	public BorrowGoodsRecord getEntity() {
		return entity;
	}
	public void setEntity(BorrowGoodsRecord entity) {
		this.entity = entity;
	}
    private int id;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int goodsid;
	
	
	
	
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public BorrowGoodsRecordDAO getDao() {
		return dao;
	}
	public void setDao(BorrowGoodsRecordDAO dao) {
		this.dao = dao;
	}
	/*��ǰ�ڼ�ҳ*/
    private int currentPage;
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getCurrentPage() {
        return currentPage;
    }

    /*һ������ҳ*/
    private int totalPage;
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getTotalPage() {
        return totalPage;
    }


    /*��ǰ��ѯ���ܼ�¼��Ŀ*/
    private int recordNumber;
    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }
    public int getRecordNumber() {
        return recordNumber;
    }

    /*ҵ������*/
    BorrowGoodsRecordDAO dao = new BorrowGoodsRecordDAO();

	

	/*���InputCashTable��Ϣ*/
    @SuppressWarnings("deprecation")
    public String add() {
        ActionContext ctx = ActionContext.getContext();
        
        try {
           
        	BorrowGoodsRecordDAO dao=new BorrowGoodsRecordDAO();
           	entity=new BorrowGoodsRecord();
        	entity.setGoodsid(goodsid);
        	entity.setStatus("������");
        	entity.setBorrow_time(new Date());
        	entity.setUserno(ctx.getSession().get("userno").toString());
        	entity.setUsername(ctx.getSession().get("username").toString());
            dao.add(entity);
            ctx.put("message",  java.net.URLEncoder.encode("����ɹ�!"));
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("����ʧ��!"));
            return "error";
        }

    
    }
    
/*
    @SuppressWarnings("deprecation")
    public String save() {
        ActionContext ctx = ActionContext.getContext();
        
        try {
        	BorrowGoodsDAO goodsDao=new BorrowGoodsDAO();
            goodsDao.update(entity);
            ctx.put("message",  java.net.URLEncoder.encode("����ɹ�!"));
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("����ʧ��!"));
            return "error";
        }

    }

    ����Ա��ѯ��Ϣ
    public String query() {
        if(currentPage == 0) currentPage = 1;
        List<BorrowGoods> list = dao.query(currentPage,5,"");
        �����ܵ�ҳ�����ܵļ�¼��
        dao.CalculateTotalPageAndRecordNumber("");
        ��ȡ���ܵ�ҳ����Ŀ
        totalPage = dao.getTotalPage();
        ��ǰ��ѯ�������ܼ�¼��
        recordNumber = dao.getRecordNumber();
        ActionContext ctx = ActionContext.getContext();
        ctx.put("list",  list);
        ctx.put("totalPage", totalPage);
        ctx.put("recordNumber", recordNumber);
        ctx.put("currentPage", currentPage);
        return "query_view";
    }

    
    ����Ա��ѯ��Ϣ
    public String userQuery() {
        if(currentPage == 0) currentPage = 1;
        List<BorrowGoods> list = dao.query(currentPage,5,"");
        �����ܵ�ҳ�����ܵļ�¼��
        dao.CalculateTotalPageAndRecordNumber("");
        ��ȡ���ܵ�ҳ����Ŀ
        totalPage = dao.getTotalPage();
        ��ǰ��ѯ�������ܼ�¼��
        recordNumber = dao.getRecordNumber();
        ActionContext ctx = ActionContext.getContext();
        ctx.put("list",  list);
        ctx.put("totalPage", totalPage);
        ctx.put("recordNumber", recordNumber);
        ctx.put("currentPage", currentPage);
        return "user_query_view";
    }
   

    ɾ��InputCashTable��Ϣ
    public String delete() {
        ActionContext ctx = ActionContext.getContext();
        try { 
        	dao.delete(id);
            ctx.put("message",  java.net.URLEncoder.encode("ɾ���ɹ�!"));
            return "success";
        } catch (Exception e) { 
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("ɾ��ʧ��!"));
            return "error";
        }
    }
*/

	

	

	
}
