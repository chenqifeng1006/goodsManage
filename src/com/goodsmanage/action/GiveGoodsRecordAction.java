package com.goodsmanage.action;

 

 

 

import java.util.Date;
import java.util.List;

import com.goodsmanage.dao.GiveGoodsRecordDAO;
import com.goodsmanage.domain.GiveGoodsRecord;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GiveGoodsRecordAction extends ActionSupport {
 

	 


	private static final long serialVersionUID = 1L;
	private GiveGoodsRecord entity;

    
  
	public GiveGoodsRecord getEntity() {
		return entity;
	}
	public void setEntity(GiveGoodsRecord entity) {
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

    private String goodsname;
    
    
    public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	/*ҵ������*/
    GiveGoodsRecordDAO dao = new GiveGoodsRecordDAO();

	

	/*���InputCashTable��Ϣ*/
    @SuppressWarnings("deprecation")
    public String add() {
        ActionContext ctx = ActionContext.getContext();
        
        try {
           
        	GiveGoodsRecordDAO dao=new GiveGoodsRecordDAO();
        	entity=new GiveGoodsRecord();
        	entity.setGoodsid(goodsid);
        	entity.setStatus("������");
        	entity.setGive_time(new Date());
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
    
    public String query() {
        ActionContext ctx = ActionContext.getContext();
        if(currentPage == 0) currentPage = 1;
        List<GiveGoodsRecord> list = dao.query("",goodsname,currentPage,5);
        dao.CalculateTotalPageAndRecordNumber("");
        totalPage = dao.getTotalPage();
        recordNumber = dao.getRecordNumber();

        ctx.put("list",  list);
        ctx.put("totalPage", totalPage);
        ctx.put("recordNumber", recordNumber);
        ctx.put("currentPage", currentPage);
        return "query_view";
    }
   
   
    
    public String userQuery() {
        ActionContext ctx = ActionContext.getContext();
        String userno=ctx.getSession().get("userno").toString();
        if(currentPage == 0) currentPage = 1;
        List<GiveGoodsRecord> list = dao.query(userno,"",currentPage,5);
        dao.CalculateTotalPageAndRecordNumber("");
        totalPage = dao.getTotalPage();
        recordNumber = dao.getRecordNumber();

        ctx.put("list",  list);
        ctx.put("totalPage", totalPage);
        ctx.put("recordNumber", recordNumber);
        ctx.put("currentPage", currentPage);
        return "user_query_view";
    }
   

  

	

	
}
