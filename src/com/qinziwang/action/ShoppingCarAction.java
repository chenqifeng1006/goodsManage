package com.qinziwang.action;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qinziwang.dao.ShoppingCarDAO;
import com.qinziwang.domain.ServiceOrderDTO;
import com.qinziwang.domain.ShoppingCar;
import com.qinziwang.domain.ShoppingCarDTO;

public class ShoppingCarAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ShoppingCar shoppingCar;
	
	private int commodityid;
	
	private String type;
	
	private double price;
	
	private int count;

	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCommodityid() {
		return commodityid;
	}
	public void setCommodityid(int commodityid) {
		this.commodityid = commodityid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


	private int id;

	
	

	public ShoppingCar getShoppingCar() {
		return shoppingCar;
	}
	public void setShoppingCar(ShoppingCar shoppingCar) {
		this.shoppingCar = shoppingCar;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


    /*业务层对象*/
    ShoppingCarDAO dao = new ShoppingCarDAO();

	
	/*添加信息*/
    @SuppressWarnings("deprecation")
    public String add() {
        ActionContext ctx = ActionContext.getContext();
        
           String username = (String)ctx.getSession().get("username");
           
          List<ShoppingCar> cars= dao.QueryByUsernameAndCommodityId(username, commodityid, type);
           if (cars==null || cars.size()==0){
        	   shoppingCar=new ShoppingCar();
               shoppingCar.setCommodityid(commodityid);
               shoppingCar.setCount(1);
               shoppingCar.setUsername(username);
               shoppingCar.setPrice(price);
               shoppingCar.setCreationtime(new Date());
               shoppingCar.setType(type);
               shoppingCar.setStatus("notDeleted");
			   try {
				dao.add(shoppingCar);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

           }else{
        	   ShoppingCar existShoppingCar=cars.get(0);
        	   existShoppingCar.setCount(existShoppingCar.getCount()+1);
        	   existShoppingCar.setPrice(existShoppingCar.getPrice()+price);
        	   try {
				dao.Update(existShoppingCar);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           }
          
            ctx.put("message",  java.net.URLEncoder.encode("添加成功!"));
            return "success";
       

    
    }
    
    
    public String update() {
        ActionContext ctx = ActionContext.getContext();
        /*根据主键inputId获取InputCashTable对象*/
    	ShoppingCar car=dao.GetById(id);
    	car.setPrice(car.getPrice()/car.getCount()*count);
    	 car.setCount(count);

    	try {
			dao.Update(car);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	        
        String username = (String)ctx.getSession().get("username");
        List<ShoppingCarDTO> list = dao.userQuery(username);

        ctx.put("list",  list);
        return "myshoppingcar_view";
       
    }


    /*查询信息*/
    public String userQuery() {

        ActionContext ctx = ActionContext.getContext();
        
        String username = (String)ctx.getSession().get("username");
        List<ShoppingCarDTO> list = dao.userQuery(username);

        ctx.put("list",  list);
        return "myshoppingcar_view";
    
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
