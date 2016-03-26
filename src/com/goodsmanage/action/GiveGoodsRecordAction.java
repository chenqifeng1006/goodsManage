package com.goodsmanage.action;

 

 

 

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import com.goodsmanage.dao.BorrowGoodsDAO;
import com.goodsmanage.dao.GiveGoodsDAO;
import com.goodsmanage.dao.GiveGoodsRecordDAO;
import com.goodsmanage.domain.GiveGoods;
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
        GiveGoodsDAO dao1=new GiveGoodsDAO();

        try {
        	GiveGoods goods=dao1.getById(goodsid);
        	GiveGoodsRecordDAO dao=new GiveGoodsRecordDAO();
        	entity=new GiveGoodsRecord();
        	entity.setGoodsid(goodsid);
        	entity.setGoodsname(goods.getGoodsname());
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
        try {
        	if(goodsname != null)
			goodsname = URLDecoder.decode(goodsname, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        List<GiveGoodsRecord> list = dao.query("",goodsname,currentPage,5);
        dao.CalculateTotalPageAndRecordNumber("",goodsname);
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
        dao.CalculateTotalPageAndRecordNumber(userno,goodsname);
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

    	GiveGoodsRecord record = dao.getById(id);
    	record.setStatus("��ͬ��");
    	try {
			dao.update(record);
		} catch (Exception e) {
	        ctx.put("message",  java.net.URLEncoder.encode("ϵͳ�쳣�����Ժ�����!"));

			e.printStackTrace();
            return "error";

		}
        ctx.put("message",  java.net.URLEncoder.encode("��ͬ��!"));

    	return "success";
    	
    }
  
    public String refuse(){
        ActionContext ctx = ActionContext.getContext();

    	GiveGoodsRecord record = dao.getById(id);
    	record.setStatus("�Ѿܾ�");
    	try {
			dao.update(record);
		} catch (Exception e) {
			e.printStackTrace();
	        ctx.put("message",  java.net.URLEncoder.encode("ϵͳ�쳣�����Ժ�����!"));
            return "error";

		}
        ctx.put("message",  java.net.URLEncoder.encode("�Ѿܾ�!"));

    	return "success";
    	
    }
	

    public String give(){
        ActionContext ctx = ActionContext.getContext();
        GiveGoodsDAO giveGoodsDao=new GiveGoodsDAO();
    	GiveGoodsRecord record = dao.getById(id);
    	record.setStatus("����ȡ");
    	record.setGive_time(new Date());
    	try {
			dao.update(record);
			GiveGoods goods= giveGoodsDao.getById(record.getGoodsid());
			if(goods.getCount()-1<=0){
				  ctx.put("message",  java.net.URLEncoder.encode("����Ʒ�������㣬�޷���ȡ!"));
		          return "error";
			}else{
				goods.setCount(goods.getCount()-1);
				giveGoodsDao.update(goods);
			  ctx.put("message",  java.net.URLEncoder.encode("��ȡ�ɹ�!"));

		    	return "success";

			}
			
		} catch (Exception e) {
			e.printStackTrace();
	        ctx.put("message",  java.net.URLEncoder.encode("ϵͳ�쳣�����Ժ�����!"));
            return "error";

		}
    	
    }
	
	
}
