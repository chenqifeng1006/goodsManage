package com.goodsmanage.action;

 

 

 

import java.util.Date;
import java.util.List;

import com.goodsmanage.dao.BorrowGoodsDAO;
import com.goodsmanage.dao.BorrowGoodsRecordDAO;
import com.goodsmanage.dao.GiveGoodsDAO;
import com.goodsmanage.dao.GiveGoodsRecordDAO;
import com.goodsmanage.domain.BorrowGoods;
import com.goodsmanage.domain.BorrowGoodsRecord;
import com.goodsmanage.domain.GiveGoods;
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
	
	
	public String goodsname;
	
	
	
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
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
    BorrowGoodsRecordDAO dao = new BorrowGoodsRecordDAO();

	

	/*添加信息*/
    @SuppressWarnings("deprecation")
    public String add() {
        ActionContext ctx = ActionContext.getContext();
        
        try {
           
        	BorrowGoodsRecordDAO dao=new BorrowGoodsRecordDAO();
           	entity=new BorrowGoodsRecord();
        	entity.setGoodsid(goodsid);
        	entity.setStatus("申请中");
        	entity.setBorrow_time(new Date());
        	entity.setUserno(ctx.getSession().get("userno").toString());
        	entity.setUsername(ctx.getSession().get("username").toString());
            dao.add(entity);
            ctx.put("message",  java.net.URLEncoder.encode("申请成功!"));
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("申请失败!"));
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
            ctx.put("message",  java.net.URLEncoder.encode("保存成功!"));
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("保存失败!"));
            return "error";
        }

    }
*/
    
    public String query() {
        ActionContext ctx = ActionContext.getContext();

        if(currentPage == 0) currentPage = 1;
        List<BorrowGoodsRecord> list = dao.query(currentPage,5,"",goodsname);
        dao.CalculateTotalPageAndRecordNumber("",goodsname);
        totalPage = dao.getTotalPage();
        recordNumber = dao.getRecordNumber();
        ctx.put("list",  list);
        ctx.put("totalPage", totalPage);
        ctx.put("recordNumber", recordNumber);
        ctx.put("currentPage", currentPage);
        return "query_view";
    }
    
     /**
      * 员工查询我的申请记录
      */
    public String userQuery() {
        ActionContext ctx = ActionContext.getContext();

        if(currentPage == 0) currentPage = 1;
        List<BorrowGoodsRecord> list = dao.query(currentPage,5,ctx.getSession().get("userno").toString(),goodsname);
        dao.CalculateTotalPageAndRecordNumber(ctx.getSession().get("userno").toString(),"");
        totalPage = dao.getTotalPage();
        recordNumber = dao.getRecordNumber();
        ctx.put("list",  list);
        ctx.put("totalPage", totalPage);
        ctx.put("recordNumber", recordNumber);
        ctx.put("currentPage", currentPage);
        return "user_query_view";
    }
   


    public String agree(){
        ActionContext ctx = ActionContext.getContext();

        BorrowGoodsRecord record = dao.getById(id);
    	record.setStatus("已同意");
    	try {
			dao.update(record);
		} catch (Exception e) {
	        ctx.put("message",  java.net.URLEncoder.encode("系统异常，请稍后重试!"));

			e.printStackTrace();
            return "error";

		}
        ctx.put("message",  java.net.URLEncoder.encode("已同意!"));

    	return "success";
    	
    }
  
    public String refuse(){
        ActionContext ctx = ActionContext.getContext();

    	BorrowGoodsRecord record = dao.getById(id);
    	record.setStatus("已同意");
    	try {
			dao.update(record);
		} catch (Exception e) {
			e.printStackTrace();
	        ctx.put("message",  java.net.URLEncoder.encode("系统异常，请稍后重试!"));
            return "error";

		}
        ctx.put("message",  java.net.URLEncoder.encode("已拒绝!"));

    	return "success";
    	
    }
	

    public String borrow(){
        ActionContext ctx = ActionContext.getContext();
        BorrowGoodsDAO borrowGoodsDao=new BorrowGoodsDAO();
        BorrowGoodsRecord record = dao.getById(id);
    	record.setStatus("已领取");
    	record.setBorrow_time(new Date());
    	try {
			dao.update(record);
			BorrowGoods goods= borrowGoodsDao.getById(record.getGoodsid());

				goods.setStatus("已借出");
				borrowGoodsDao.update(goods);
		        ctx.put("message",  java.net.URLEncoder.encode("借用成功!"));
	            return "success";

			
		} catch (Exception e) {
			e.printStackTrace();
	        ctx.put("message",  java.net.URLEncoder.encode("系统异常，请稍后重试!"));
            return "error";

		}

    	
    }
	

	
}
