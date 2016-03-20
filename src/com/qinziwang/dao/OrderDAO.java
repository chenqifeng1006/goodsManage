package com.qinziwang.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qinziwang.domain.Book;
import com.qinziwang.domain.Cloth;
import com.qinziwang.domain.Life;
import com.qinziwang.domain.ServiceOrder;
import com.qinziwang.domain.ServiceOrderDTO;
import com.qinziwang.domain.ShoppingCar;
import com.qinziwang.domain.Toy;
import com.qinziwang.domain.Travel;
import com.qinziwang.utils.HibernateUtil;

public class OrderDAO {

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

    /*添加信息*/
    public void add(ServiceOrder order) throws Exception {
        Session s = null;
        Transaction tx = null;
        try { 
            s = HibernateUtil.getSession();
            tx = s.beginTransaction(); 
            s.save(order);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*查询信息*/
    public List<ServiceOrderDTO> Query(int currentPage) { 
        Session s = null; 
        try {
            s = HibernateUtil.getSession();
            String hql = "From ServiceOrder serviceorder where 1=1";
/*            if(null != member && !member.getUserNo().equals("")) hql += " and inputCashTable.member.userNo='" + member.getUserNo() + "'";
            if(null != inputFroms && inputFroms.getInputClassId()!=0) hql += " and inputCashTable.inputFroms.inputClassId=" + inputFroms.getInputClassId();
            if(null != payWayObj && payWayObj.getPayWayId()!=0) hql += " and inputCashTable.payWayObj.payWayId=" + payWayObj.getPayWayId();
            if(!inputDateTime.equals("")) hql = hql + " and inputCashTable.inputDateTime like '%" + inputDateTime + "%'";*/
            Query q = s.createQuery(hql);
            /*计算当前显示页码的开始记录*/
            int startIndex = (currentPage-1) * this.PAGE_SIZE;
            q.setFirstResult(startIndex);
            q.setMaxResults(this.PAGE_SIZE);
            List<ServiceOrder> list = q.list();
        	ShoppingCarDAO carDao=new ShoppingCarDAO();
            BookDAO bookDao=new BookDAO();
            LifeDAO lifeDao=new LifeDAO();
            ClothDAO clothDao=new ClothDAO();
            ToyDAO toyDao=new ToyDAO();
            TravelDAO travelDao=new TravelDAO();
            
            List<ServiceOrderDTO> dtos=this.convertToDTO(list);
            
            for(ServiceOrderDTO order:dtos){
            	String shopingCarIds=order.getShoppingcarids();
            	String carIdArray[]=shopingCarIds.split(",");
            	
            	for(String carId:carIdArray){
            		ShoppingCar car =carDao.GetById(Integer.valueOf(carId));
            	
            		if("Book".equals(car.getType())){
            		Book book =	bookDao.GetBookById(Integer.valueOf(car.getCommodityid()));
            		order.getCommodities().add(book.getName());
            		order.getCount().add(car.getCount());
            		}else if("Life".equals(car.getType())){
                	Life life =	lifeDao.GetById(Integer.valueOf(car.getCommodityid()));
            		order.getCommodities().add(life.getName());
            		order.getCount().add(car.getCount());

            		}else if("Cloth".equals(car.getType())){
            		Cloth cloth =	clothDao.GetById(Integer.valueOf(car.getCommodityid()));
            		order.getCommodities().add(cloth.getName());
            		order.getCount().add(car.getCount());

            		}else if("Toy".equals(car.getType())){
            		Toy toy =	toyDao.GetById(Integer.valueOf(car.getCommodityid()));
            		order.getCommodities().add(toy.getName());
            		order.getCount().add(car.getCount());

            		}
            		else if("Travel".equals(car.getType())){
            		Travel travel =	travelDao.GetById(Integer.valueOf(car.getCommodityid()));
            		order.getCommodities().add(travel.getName());
            		order.getCount().add(car.getCount());

            		}          			
            	}

            }
            return dtos;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public List<ServiceOrderDTO> userQuery(int currentPage,String username,int id) { 
        Session s = null; 
        try {
            s = HibernateUtil.getSession();
            String hql = "From ServiceOrder serviceorder where 1=1";
            hql+=" and username='"+username+"'";
            if(id!=0){
                hql+=" and id="+id;
	
            }
            Query q = s.createQuery(hql);
            /*计算当前显示页码的开始记录*/
            int startIndex = (currentPage-1) * this.PAGE_SIZE;
            q.setFirstResult(startIndex);
            q.setMaxResults(this.PAGE_SIZE);
            List<ServiceOrder> list = q.list();
        	ShoppingCarDAO carDao=new ShoppingCarDAO();
            BookDAO bookDao=new BookDAO();
            LifeDAO lifeDao=new LifeDAO();
            ClothDAO clothDao=new ClothDAO();
            ToyDAO toyDao=new ToyDAO();
            TravelDAO travelDao=new TravelDAO();
            
            List<ServiceOrderDTO> dtos=this.convertToDTO(list);
            
            for(ServiceOrderDTO order:dtos){
            	String shopingCarIds=order.getShoppingcarids();
            	String carIdArray[]=shopingCarIds.split(",");
            	
            	for(String carId:carIdArray){
            		ShoppingCar car =carDao.GetById(Integer.valueOf(carId));
            	
            		if("Book".equals(car.getType())){
            		Book book =	bookDao.GetBookById(Integer.valueOf(car.getCommodityid()));
            		order.getCommodities().add(book.getName());
            		order.getCount().add(car.getCount());
            		}else if("Life".equals(car.getType())){
                	Life life =	lifeDao.GetById(Integer.valueOf(car.getCommodityid()));
            		order.getCommodities().add(life.getName());
            		order.getCount().add(car.getCount());

            		}else if("Cloth".equals(car.getType())){
            		Cloth cloth =	clothDao.GetById(Integer.valueOf(car.getCommodityid()));
            		order.getCommodities().add(cloth.getName());
            		order.getCount().add(car.getCount());

            		}else if("Toy".equals(car.getType())){
            		Toy toy =	toyDao.GetById(Integer.valueOf(car.getCommodityid()));
            		order.getCommodities().add(toy.getName());
            		order.getCount().add(car.getCount());

            		}
            		else if("Travel".equals(car.getType())){
            		Travel travel =	travelDao.GetById(Integer.valueOf(car.getCommodityid()));
            		order.getCommodities().add(travel.getName());
            		order.getCount().add(car.getCount());

            		}          			
            	}

            }
            return dtos;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    
    private List<ServiceOrderDTO> convertToDTO(List<ServiceOrder> list){
    	
    	List<ServiceOrderDTO> dtos=new ArrayList<ServiceOrderDTO>();
    	
    	for(ServiceOrder order:list){
    		ServiceOrderDTO dto=new ServiceOrderDTO();
    		dto.setShoppingcarids(order.getShoppingcarids());
    		dto.setCreationtime(order.getCreationtime());
    		dto.setId(order.getId());
    		dto.setPrice(order.getPrice());
    		dto.setStatus(order.getStatus());
    		dto.setUsername(order.getUsername());
    		dtos.add(dto);
    	}
    	return dtos;
    	
    }
    
    /*计算总的页数和记录数*/
    public void CalculateTotalPageAndRecordNumber() {
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            String hql = "From ServiceOrder serviceorder where 1=1";
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

    public void userCalculateTotalPageAndRecordNumber(String username) {
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            String hql = "From ServiceOrder serviceorder where 1=1";
            hql+="and username='"+username+"'";
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
    
    /*根据主键获取对象*/
    public ServiceOrder GetById(int id) {
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            ServiceOrder order = (ServiceOrder)s.get(ServiceOrder.class, id);
            return order;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*更新InputCashTable信息*/
    public void Update(ServiceOrder order) throws Exception {
        Session s = null;
        Transaction tx = null;
        try {
            s = HibernateUtil.getSession();
            tx = s.beginTransaction();
            s.update(order);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
            	  tx.rollback();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*删除信息*/
    public void Delete (int id) throws Exception {
        Session s = null;
        Transaction tx = null;
        try {
            s = HibernateUtil.getSession();
            tx = s.beginTransaction();
            Object obj = s.get(ServiceOrder.class, id);
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
