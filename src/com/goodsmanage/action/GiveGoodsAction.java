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

		/*当前第几页*/
	    private int currentPage;
	    public void setCurrentPage(int currentPage) {
	        this.currentPage = currentPage;
	    }
	    public int getCurrentPage() {
	        return currentPage;
	    }

	    /*一共多少页*/
	    private int totalPage;
	    public void setTotalPage(int totalPage) {
	        this.totalPage = totalPage;
	    }
	    public int getTotalPage() {
	        return totalPage;
	    }


	    /*当前查询的总记录数目*/
	    private int recordNumber;
	    public void setRecordNumber(int recordNumber) {
	        this.recordNumber = recordNumber;
	    }
	    public int getRecordNumber() {
	        return recordNumber;
	    }

	    /*业务层对象*/
	    GiveGoodsDAO dao = new GiveGoodsDAO();

		

		/*添加InputCashTable信息*/
	    @SuppressWarnings("deprecation")
	    public String add() {
	        ActionContext ctx = ActionContext.getContext();
	        
	        try {
	           
	        	GiveGoodsDAO dao=new GiveGoodsDAO();

	            dao.add(entity);
	            ctx.put("message",  java.net.URLEncoder.encode("添加成功!"));
	            return "success";
	        } catch (Exception e) {
	            e.printStackTrace();
	            ctx.put("error",  java.net.URLEncoder.encode("添加失败!"));
	            return "error";
	        }

	    
	    }
	    
	    
	    public String update() {
	        ActionContext ctx = ActionContext.getContext();
	        /*根据主键inputId获取InputCashTable对象*/
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
	            ctx.put("message",  java.net.URLEncoder.encode("保存成功!"));
	            return "success";
	        } catch (Exception e) {
	            e.printStackTrace();
	            ctx.put("error",  java.net.URLEncoder.encode("保存失败!"));
	            return "error";
	        }

	    }

	    /*管理员查询信息*/
	    public String query() {
	        if(currentPage == 0) currentPage = 1;
	        List<GiveGoods> list = dao.query(currentPage,10,entity.getGoodsname());
	        /*计算总的页数和总的记录数*/
	        dao.CalculateTotalPageAndRecordNumber(entity.getGoodsname());
	        /*获取到总的页码数目*/
	        totalPage = dao.getTotalPage();
	        /*当前查询条件下总记录数*/
	        recordNumber = dao.getRecordNumber();
	        ActionContext ctx = ActionContext.getContext();
	        ctx.put("list",  list);
	        ctx.put("totalPage", totalPage);
	        ctx.put("recordNumber", recordNumber);
	        ctx.put("currentPage", currentPage);
	        return "query_view";
	    }

	    

	   

	    /*删除InputCashTable信息*/
	    public String delete() {
	        ActionContext ctx = ActionContext.getContext();
	        try { 
	        	dao.delete(id);
	            ctx.put("message",  java.net.URLEncoder.encode("删除成功!"));
	            return "success";
	        } catch (Exception e) { 
	            e.printStackTrace();
	            ctx.put("error",  java.net.URLEncoder.encode("删除失败!"));
	            return "error";
	        }
	    }


		
}
