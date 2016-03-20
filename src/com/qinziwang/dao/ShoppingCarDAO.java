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

    /*ÿҳ��ʾ��¼��Ŀ*/
    private final int PAGE_SIZE = 10;

    /*�����ѯ���ܵ�ҳ��*/
    private int totalPage;
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getTotalPage() {
        return totalPage;
    }

    /*�����ѯ�����ܼ�¼��*/
    private int recordNumber;
    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }
    public int getRecordNumber() {
        return recordNumber;
    }

    /*�����Ϣ*/
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

    /*��ѯ��Ϣ*/
    public List<ShoppingCarDTO> userQuery(String username) { 
        Session s = null; 
        try {
            s = HibernateUtil.getSession();
            String hql = "From ShoppingCar shoppingcar where username='"+username+"'" +"and status='notDeleted'";
            Query q = s.createQuery(hql);
            /*���㵱ǰ��ʾҳ��Ŀ�ʼ��¼*/
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
            /*���㵱ǰ��ʾҳ��Ŀ�ʼ��¼*/
            List list = q.list();
            return (ArrayList<ShoppingCar>) list;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    /*�����ܵ�ҳ���ͼ�¼��*/
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

    /*����������ȡ����*/
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

    /*����InputCashTable��Ϣ*/
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

    /*ɾ����Ϣ*/
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
