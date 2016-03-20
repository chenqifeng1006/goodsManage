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
import com.qinziwang.domain.ShoppingCar;
import com.qinziwang.domain.ShoppingCarDTO;
import com.qinziwang.domain.Toy;
import com.qinziwang.domain.Travel;
import com.qinziwang.utils.HibernateUtil;

public class ShoppingCarDAO {

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
    public void add(ShoppingCar shoppingCar) throws Exception {
        Session s = null;
        Transaction tx = null;
        try { 
            s = HibernateUtil.getSession();
            tx = s.beginTransaction(); 
            s.save(shoppingCar);
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
    public List<ShoppingCarDTO> userQuery(String username) { 
        Session s = null; 
        try {
            s = HibernateUtil.getSession();
            String hql = "From ShoppingCar shoppingcar where username='"+username+"'" +"and status='notDeleted'";
            Query q = s.createQuery(hql);
            /*计算当前显示页码的开始记录*/
            List<ShoppingCar> list = q.list();
            BookDAO bookDao=new BookDAO();
            ClothDAO clothDao=new ClothDAO();
            LifeDAO lifeDao=new LifeDAO();
            ToyDAO toyDao=new ToyDAO();
            TravelDAO travelDao=new TravelDAO();
            
            List<ShoppingCarDTO> dtos=new ArrayList<ShoppingCarDTO>();
            
            for(ShoppingCar car :list){
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
            
            return dtos;
        } finally {
            HibernateUtil.closeSession();
        }
    }
    
    
    public ArrayList<ShoppingCar> QueryByUsernameAndCommodityId(String username,int commodityId,String type) { 
        Session s = null; 
        try {
            s = HibernateUtil.getSession();
            String hql = "From ShoppingCar shoppingCar where 1=1";
            hql+=" and shoppingCar.username='"+username+"'";
            hql+=" and shoppingCar.commodityid="+commodityId;
            hql+=" and shoppingCar.type='"+type+"'";
            hql+=" and shoppingCar.status!='deleted'";


/*            if(null != member && !member.getUserNo().equals("")) hql += " and inputCashTable.member.userNo='" + member.getUserNo() + "'";
            if(null != inputFroms && inputFroms.getInputClassId()!=0) hql += " and inputCashTable.inputFroms.inputClassId=" + inputFroms.getInputClassId();
            if(null != payWayObj && payWayObj.getPayWayId()!=0) hql += " and inputCashTable.payWayObj.payWayId=" + payWayObj.getPayWayId();
            if(!inputDateTime.equals("")) hql = hql + " and inputCashTable.inputDateTime like '%" + inputDateTime + "%'";*/
            Query q = s.createQuery(hql);
            /*计算当前显示页码的开始记录*/
            List list = q.list();
            return (ArrayList<ShoppingCar>) list;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*计算总的页数和记录数*/
    public void CalculateTotalPageAndRecordNumber(String username) {
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            String hql = "From ShoppingCar shoppingCar where 1=1";
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
    public ShoppingCar GetById(int id) {
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            ShoppingCar shoppingCar = (ShoppingCar)s.get(ShoppingCar.class, id);
            return shoppingCar;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*更新InputCashTable信息*/
    public void Update(ShoppingCar shoppingCar) throws Exception {
        Session s = null;
        Transaction tx = null;
        try {
            s = HibernateUtil.getSession();
            tx = s.beginTransaction();
            s.update(shoppingCar);
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
            Object obj = s.get(ShoppingCar.class, id);
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
