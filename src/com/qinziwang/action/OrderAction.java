package com.qinziwang.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qinziwang.dao.BookDAO;
import com.qinziwang.dao.ClothDAO;
import com.qinziwang.dao.LifeDAO;
import com.qinziwang.dao.OrderDAO;
import com.qinziwang.dao.ShoppingCarDAO;
import com.qinziwang.dao.ToyDAO;
import com.qinziwang.dao.TravelDAO;
import com.qinziwang.domain.Book;
import com.qinziwang.domain.Cloth;
import com.qinziwang.domain.Life;
import com.qinziwang.domain.ServiceOrder;
import com.qinziwang.domain.ServiceOrderDTO;
import com.qinziwang.domain.ShoppingCar;
import com.qinziwang.domain.ShoppingCarDTO;
import com.qinziwang.domain.Toy;
import com.qinziwang.domain.Travel;

public class OrderAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ServiceOrder order;
    private String ids;
    private double price;
    
    
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public ServiceOrder getOrder() {
		return order;
	}
	public void setOrder(ServiceOrder order) {
		this.order = order;
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
    OrderDAO dao = new OrderDAO();

	 ShoppingCarDAO carDao=new ShoppingCarDAO();
	 
  

  
	/*添加信息*/
    @SuppressWarnings("deprecation")
    public String add() {

    	ServiceOrder serviceOrder=new ServiceOrder();
        serviceOrder.setCreationtime(new Date());
        serviceOrder.setPrice(price);
        serviceOrder.setShoppingcarids(ids);
        serviceOrder.setStatus("购买中");    
        ActionContext ctx = ActionContext.getContext();
        String username = (String)ctx.getSession().get("username");
        serviceOrder.setUsername(username);
        String[] idsArray=ids.split(",");
        for(String shoppingCarId:idsArray){
        	int carId=Integer.valueOf(shoppingCarId);
        	ShoppingCar car=carDao.GetById(carId);
        	car.setStatus("deleted");
        	
        	try {
				carDao.Update(car);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
        try {
            /*处理图片上传*/
            dao.add(serviceOrder);
            ctx.put("message",  java.net.URLEncoder.encode("添加成功!"));
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("添加失败!"));
            return "error";
        }

    
    }
    
    public String detail(){
        BookDAO bookDao=new BookDAO();
        ClothDAO clothDao=new ClothDAO();
        LifeDAO lifeDao=new LifeDAO();
        ToyDAO toyDao=new ToyDAO();
        TravelDAO travelDao=new TravelDAO();
        ActionContext ctx = ActionContext.getContext();
        
        String username = (String)ctx.getSession().get("username");
        
        ServiceOrder order=dao.GetById(id);
        String [] shoppingCarIds=order.getShoppingcarids().split(",");
        List<ShoppingCarDTO> dtos=new ArrayList<ShoppingCarDTO>();

        for(String carId:shoppingCarIds){
        	Integer carIdInt=Integer.valueOf(carId);
            ShoppingCar car =carDao.GetById(carIdInt);
        	ShoppingCarDTO dto=new ShoppingCarDTO();
        	dto.setCreationtime(car.getCreationtime());
        	dto.setCount(car.getCount());
        	dto.setId(car.getId());
        	dto.setPrice(car.getPrice());
        	dto.setType(car.getType());
        	dto.setUsername(username);
        
        	if("book".equals(car.getType())){
        		Book book =	bookDao.GetBookById(Integer.valueOf(car.getCommodityid()));
            	dto.setFileid(book.getFileid());
        		dto.setCommodityid(book.getName());
        		}else if("life".equals(car.getType())){
                	Life life =	lifeDao.GetById(Integer.valueOf(car.getCommodityid()));
                	dto.setFileid(life.getFileid());
            		dto.setCommodityid(life.getName());
        		}else if("cloth".equals(car.getType())){
            		Cloth cloth =	clothDao.GetById(Integer.valueOf(car.getCommodityid()));
            		dto.setFileid(cloth.getFileid());
            		dto.setCommodityid(cloth.getName());
        		}else if("toy".equals(car.getType())){
            		Toy toy =	toyDao.GetById(Integer.valueOf(car.getCommodityid()));
            		dto.setFileid(toy.getFileid());
            		dto.setCommodityid(toy.getName());
        		}
        		else if("travel".equals(car.getType())){
            		Travel travel =	travelDao.GetById(Integer.valueOf(car.getCommodityid()));
            		dto.setFileid(travel.getFileid());
            		dto.setCommodityid(travel.getName());
        		}    
        	dtos.add(dto);
        }
    	
        ctx.put("list",  dtos);
        ctx.put("totalPage", totalPage);
        ctx.put("recordNumber", recordNumber);
        ctx.put("currentPage", currentPage);
        return "order_detail";
    }
    
    public String manageDetail(){
    	BookDAO bookDao=new BookDAO();
    	ClothDAO clothDao=new ClothDAO();
    	LifeDAO lifeDao=new LifeDAO();
    	ToyDAO toyDao=new ToyDAO();
    	TravelDAO travelDao=new TravelDAO();
    	ActionContext ctx = ActionContext.getContext();
    	
    	
    	ServiceOrder order=dao.GetById(id);
    	String [] shoppingCarIds=order.getShoppingcarids().split(",");
    	List<ShoppingCarDTO> dtos=new ArrayList<ShoppingCarDTO>();
    	
    	for(String carId:shoppingCarIds){
    		Integer carIdInt=Integer.valueOf(carId);
    		ShoppingCar car =carDao.GetById(carIdInt);
    		ShoppingCarDTO dto=new ShoppingCarDTO();
    		dto.setCreationtime(car.getCreationtime());
    		dto.setCount(car.getCount());
    		dto.setId(car.getId());
    		dto.setPrice(car.getPrice());
    		dto.setType(car.getType());
    		
    		if("book".equals(car.getType())){
    			Book book =	bookDao.GetBookById(Integer.valueOf(car.getCommodityid()));
    			dto.setFileid(book.getFileid());
    			dto.setCommodityid(book.getName());
    		}else if("life".equals(car.getType())){
    			Life life =	lifeDao.GetById(Integer.valueOf(car.getCommodityid()));
    			dto.setFileid(life.getFileid());
    			dto.setCommodityid(life.getName());
    		}else if("cloth".equals(car.getType())){
    			Cloth cloth =	clothDao.GetById(Integer.valueOf(car.getCommodityid()));
    			dto.setFileid(cloth.getFileid());
    			dto.setCommodityid(cloth.getName());
    		}else if("toy".equals(car.getType())){
    			Toy toy =	toyDao.GetById(Integer.valueOf(car.getCommodityid()));
    			dto.setFileid(toy.getFileid());
    			dto.setCommodityid(toy.getName());
    		}
    		else if("travel".equals(car.getType())){
    			Travel travel =	travelDao.GetById(Integer.valueOf(car.getCommodityid()));
    			dto.setFileid(travel.getFileid());
    			dto.setCommodityid(travel.getName());
    		}    
    		dtos.add(dto);
    	}
    	
    	ctx.put("list",  dtos);
    	ctx.put("totalPage", totalPage);
    	ctx.put("recordNumber", recordNumber);
    	ctx.put("currentPage", currentPage);
    	return "order_manageDetail";
    }

    @SuppressWarnings("deprecation")
    public String deal() {
        ActionContext ctx = ActionContext.getContext();
        
        try {
        	ServiceOrder serviceOrder =dao.GetById(id);
        	serviceOrder.setStatus("已处理");
            dao.Update(serviceOrder);
            ctx.put("message",  java.net.URLEncoder.encode("处理成功!"));
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("处理失败!"));
            return "error";
        }

    }

    /*查询信息*/
    public String query() {
        if(currentPage == 0) currentPage = 1;
        List<ServiceOrderDTO> list = dao.Query(currentPage);
        /*计算总的页数和总的记录数*/
        dao.CalculateTotalPageAndRecordNumber();
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
    public String userQuery() {
        ActionContext ctx = ActionContext.getContext();
        
        String username = (String)ctx.getSession().get("username");
        if(currentPage == 0) currentPage = 1;
        List<ServiceOrderDTO> list = dao.userQuery(currentPage, username,0);
        /*计算总的页数和总的记录数*/
        dao.CalculateTotalPageAndRecordNumber();
        /*获取到总的页码数目*/
        totalPage = dao.getTotalPage();
        /*当前查询条件下总记录数*/
        recordNumber = dao.getRecordNumber();
        ctx.put("list",  list);
        ctx.put("totalPage", totalPage);
        ctx.put("recordNumber", recordNumber);
        ctx.put("currentPage", currentPage);
        return "myorder_view";
    }

    /*删除InputCashTable信息*/
    public String delete() {
        ActionContext ctx = ActionContext.getContext();
        try { 
        	dao.Delete(id);
            ctx.put("message",  java.net.URLEncoder.encode("删除成功!"));
            return "success";
        } catch (Exception e) { 
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("删除失败!"));
            return "error";
        }
    }

}
