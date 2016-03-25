package com.goodsmanage.action;

 

 

 

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.goodsmanage.dao.BorrowGoodsDAO;
import com.goodsmanage.dao.GiveGoodsDAO;
import com.goodsmanage.dao.UserDAO;
import com.goodsmanage.domain.BorrowGoods;
import com.goodsmanage.domain.GiveGoods;
import com.goodsmanage.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GiveGoodsAction extends ActionSupport {
	 


		private static final long serialVersionUID = 1L;
		private GiveGoods entity;

	    
	  
		public GiveGoods getEntity() {
			return entity;
		}
		public void setEntity(GiveGoods entity) {
			this.entity = entity;
		}
	    private int id;

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
	    GiveGoodsDAO dao = new GiveGoodsDAO();

		

		/*���InputCashTable��Ϣ*/
	    @SuppressWarnings("deprecation")
	    public String add() {
	        ActionContext ctx = ActionContext.getContext();
	        
	        try {
	           
	        	GiveGoodsDAO dao=new GiveGoodsDAO();

	            dao.add(entity);
	            ctx.put("message",  java.net.URLEncoder.encode("��ӳɹ�!"));
	            return "success";
	        } catch (Exception e) {
	            e.printStackTrace();
	            ctx.put("error",  java.net.URLEncoder.encode("���ʧ��!"));
	            return "error";
	        }

	    
	    }
	    
	    
	    public String update() {
	        ActionContext ctx = ActionContext.getContext();
	        /*��������inputId��ȡInputCashTable����*/
	        GiveGoods goods =dao.getById(id);

	        ctx.put("entity",  goods);
	        return "modify_view";
	    }
	    @SuppressWarnings("deprecation")
	    public String save() {
	        ActionContext ctx = ActionContext.getContext();
	        
	        try {
	            GiveGoodsDAO goodsDao=new GiveGoodsDAO();
	            goodsDao.update(entity);
	            ctx.put("message",  java.net.URLEncoder.encode("����ɹ�!"));
	            return "success";
	        } catch (Exception e) {
	            e.printStackTrace();
	            ctx.put("error",  java.net.URLEncoder.encode("����ʧ��!"));
	            return "error";
	        }

	    }

	    /*����Ա��ѯ��Ϣ*/
	    public String query() {
	        if(currentPage == 0) currentPage = 1;
	        List<GiveGoods> list = dao.query(currentPage,10,entity.getGoodsname());
	        /*�����ܵ�ҳ�����ܵļ�¼��*/
	        dao.CalculateTotalPageAndRecordNumber(entity.getGoodsname());
	        /*��ȡ���ܵ�ҳ����Ŀ*/
	        totalPage = dao.getTotalPage();
	        /*��ǰ��ѯ�������ܼ�¼��*/
	        recordNumber = dao.getRecordNumber();
	        ActionContext ctx = ActionContext.getContext();
	        ctx.put("list",  list);
	        ctx.put("totalPage", totalPage);
	        ctx.put("recordNumber", recordNumber);
	        ctx.put("currentPage", currentPage);
	        return "query_view";
	    }

	    

	   

	    /*ɾ��InputCashTable��Ϣ*/
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


		
}
