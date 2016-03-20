package com.qinziwang.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qinziwang.dao.FilePictureDAO;
import com.qinziwang.dao.PhotoDAO;
import com.qinziwang.domain.FilePicture;
import com.qinziwang.domain.Photo;

public class FilePictureAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private int id;

	private int photoid;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPhotoid() {
		return photoid;
	}
	public void setPhotoid(int photoid) {
		this.photoid = photoid;
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
    FilePictureDAO dao = new FilePictureDAO();

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
	/*添加InputCashTable信息*/
    @SuppressWarnings("deprecation")
    public String add() {
    	FilePicture filePicture=new FilePicture();
    	filePicture.setPhotoid(photoid);
        ActionContext ctx = ActionContext.getContext();
        try {
            String path = ServletActionContext.getServletContext().getRealPath("/img"); 
            /*处理图片上传*/
            String photoFileName = ""; 
       	 	if(photoFile != null) {
       	 		InputStream is = new FileInputStream(photoFile);
       			String fileContentType = this.getPhotoFileContentType();
       			if(fileContentType.equals("image/jpeg")  || fileContentType.equals("image/pjpeg"))
       				photoFileName = UUID.randomUUID().toString() +  ".jpg";
       			else if(fileContentType.equals("image/gif"))
       				photoFileName = UUID.randomUUID().toString() +  ".gif";
       			else {
       				ctx.put("error",  java.net.URLEncoder.encode("上传图片格式不正确!"));
       				return "error";
       			}
       			File file = new File(path, photoFileName);
       			OutputStream os = new FileOutputStream(file);
       			byte[] b = new byte[1024];
       			int bs = 0;
       			while ((bs = is.read(b)) > 0) {
       				os.write(b, 0, bs);
       			}
       			is.close();
       			os.close();
       	 	 }
	       	 if(photoFile != null){
	       		filePicture.setSrc("img/" + photoFileName);
	         }
	         else{
	        	 filePicture.setSrc("img/noImage.jpg");
	
	         }
       	    dao.add(filePicture);
            ctx.put("message",  java.net.URLEncoder.encode("添加成功!"));
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            ctx.put("error",  java.net.URLEncoder.encode("添加失败!"));
            return "error";
        }
    }

   
    /*用户查询信息*/
    public String userQuery() {
        ActionContext ctx = ActionContext.getContext();
        if(currentPage == 0) currentPage = 1;
        List<FilePicture> list = dao.Query(currentPage,6,photoid);
        /*计算总的页数和总的记录数*/
        dao.CalculateTotalPageAndRecordNumber(photoid);
        /*获取到总的页码数目*/
        totalPage = dao.getTotalPage();
        /*当前查询条件下总记录数*/
        recordNumber = dao.getRecordNumber();
        ctx.put("list",  list);
        ctx.put("totalPage", totalPage);
        ctx.put("recordNumber", recordNumber);
        ctx.put("currentPage", currentPage);
        ctx.put("photoid", photoid);

        return "user_query_view";
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
