package com.qinziwang.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qinziwang.dao.BookDAO;
import com.qinziwang.dao.ManagerDAO;
import com.qinziwang.domain.Book;
import com.qinziwang.domain.Manager;

public class ManagerAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Manager manager;
    ManagerDAO dao=new ManagerDAO();

	private String username;



	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}





	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
    BookDAO bookDao = new BookDAO();

	 private File photoFile;
	 private String photoFileFileName;
	 private String photoFileContentType;
	 
	 
	 
  

    public File getPhotoFile() {
		return photoFile;
	}
	public void setPhotoFile(File photoFile) {
		this.photoFile = photoFile;
	}
	public String getPhotoFileFileName() {
		return photoFileFileName;
	}
	public void setPhotoFileFileName(String photoFileFileName) {
		this.photoFileFileName = photoFileFileName;
	}
	public String getPhotoFileContentType() {
		return photoFileContentType;
	}
	public void setPhotoFileContentType(String photoFileContentType) {
		this.photoFileContentType = photoFileContentType;
	}
	/*���InputCashTable��Ϣ*/
    @SuppressWarnings("deprecation")
    public String add() {
        ActionContext ctx = ActionContext.getContext();
        
        try {
           
            dao.add(manager);
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
         Manager manager= dao.GetByUsername(username);

        ctx.put("manager",  manager);
        return "modify_view";
    }
    @SuppressWarnings("deprecation")
    public String save() {
        ActionContext ctx = ActionContext.getContext();
        
        try {
      
            dao.Update(manager);
            ctx.put("message",  java.net.URLEncoder.encode("����ɹ�!"));
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("����ʧ��!"));
            return "error";
        }

    }

    /*��ѯ��Ϣ*/
    public String query() {
        if(currentPage == 0) currentPage = 1;
        List<Manager> list = dao.Query(currentPage);
        /*�����ܵ�ҳ�����ܵļ�¼��*/
        dao.CalculateTotalPageAndRecordNumber();
        /*��ȡ���ܵ�ҳ����Ŀ*/
        totalPage = dao.getTotalPage();
        /*��ǰ��ѯ�������ܼ�¼��*/
        recordNumber =dao.getRecordNumber();
        ActionContext ctx = ActionContext.getContext();
        ctx.put("list", list);
        ctx.put("totalPage", totalPage);
        ctx.put("recordNumber", recordNumber);
        ctx.put("currentPage", currentPage);
        return "query_view";
    }


    /*ɾ��InputCashTable��Ϣ*/
    public String delete() {
        ActionContext ctx = ActionContext.getContext();
        try { 
        	dao.Delete(username);
            ctx.put("message",  java.net.URLEncoder.encode("ɾ���ɹ�!"));
            return "success";
        } catch (Exception e) { 
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("ɾ��ʧ��!"));
            return "error";
        }
    }

}
