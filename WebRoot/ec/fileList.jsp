<%@ page language="java" contentType="text/html;charset=GB2312"
    pageEncoding="GB2312"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.qinziwang.action.*" %>
<%@ page language="java" import="com.qinziwang.dao.*" %>
<%@ page language="java" import="com.qinziwang.domain.*" %>
<% 
	//当前路径
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//总页数
	int totalPage = (Integer)request.getAttribute("totalPage");
	//总记录数
	int recordNumber = (Integer)request.getAttribute("recordNumber");
	//当前第几页
	int currentPage = (Integer)request.getAttribute("currentPage");
	
	int photoid = (Integer)request.getAttribute("photoid");
	//页面分类
	String type = "photo";	

	//列表数据
	List<FilePicture> list =(List<FilePicture>)request.getAttribute("list");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=GB2312">
<link rel="stylesheet" type="text/css" href="../css/ec/main.css">
<title>相册列表</title>
</head>
<body>
<div class="w">
	<div class="w100">
		<%@ include  file="./top.jsp"%>
	    <%@ include  file="./menus.jsp"%>
	    <div class="ec_content">
	    	<div style="margin-top:20px;margin-bottom:20px;">
	    		<form action="<%=basePath %>filePicture/filePicture_add.action" method="post" enctype="multipart/form-data" name="bookForm" id="bookForm">
					<input type="file" name="photoFile" >
		    		<input type="hidden" name="photoid"  value="<%=photoid%>">
					<button class="submit" type="submit">上传图片</button>
				</form>
	    	</div>
	    	
	    	<%for(int i = 0;i<list.size();i++){%>
	    	<div class="photo_block" style="width:140px;margin-right:10px;position: relative;">
				<img src="<%=basePath %><%=list.get(i).getSrc() %>" width="140" height="200">
				<div style="position: absolute; top:0;right:0;background: gray;color:#fff;">
					<a style="color:#fff;" href="<%=basePath %>filePicture/filePicture_delete.action?id=<%=list.get(i).getId()%>">删除</a>
				</div>
			</div>
			<%} %>
			<div class="listFooter">
				<a <%=currentPage == 1 ? "href='#'" : "href='" + basePath + "file/file_userQuery.action?photoid=" + photoid + "&currentPage=" + (currentPage - 1) + "'" %>>
					<span class="prev"></span>
				</a>
				<div class="cut"></div>
				<span>第<strong><%=currentPage %>页，共<strong><%=totalPage %>页</span>
				<div class="cut"></div>
				<a <%=currentPage == totalPage ? "href='#'" : "href='" + basePath + "file/file_userQuery.action?photoid=" + photoid + "&currentPage=" + (currentPage + 1) + "'" %>>
					<span class="next"></span>
				</a>
				<div class="info">共<strong><%=recordNumber %>条记录</div>
			</div>
	    </div>
    </div>
</div>
</body>
</html>