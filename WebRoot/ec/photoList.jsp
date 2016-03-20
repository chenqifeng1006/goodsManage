<%@ page language="java" contentType="text/html;charset=GB2312"
    pageEncoding="GB2312"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.qinziwang.action.*" %>
<%@ page language="java" import="com.qinziwang.dao.*" %>
<%@ page language="java" import="com.qinziwang.domain.*" %>
<% 
	//��ǰ·��
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//��ҳ��
	int totalPage = (Integer)request.getAttribute("totalPage");
	//�ܼ�¼��
	int recordNumber = (Integer)request.getAttribute("recordNumber");
	//��ǰ�ڼ�ҳ
	int currentPage = (Integer)request.getAttribute("currentPage");
	//ҳ�����
	String type = "photo";	

	//�б�����
	List<Photo> list =(List<Photo>)request.getAttribute("list");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=GB2312">
<link rel="stylesheet" type="text/css" href="../css/ec/main.css">
<title>����б�</title>
</head>
<body>
<div class="w">
	<div class="w100">
		<%@ include  file="./top.jsp"%>
	    <%@ include  file="./menus.jsp"%>
	    <div class="ec_content">
	    	<div style="margin-top:20px;margin-bottom:20px;">
		    	<form action="<%=basePath %>photo/photo_add.action" method="post">
		    		<input type="text" name="name" value="">
		    		<button type="submit">�½����</button>
		    	</form>
	    	</div>
	    	
	    	<%for(int i = 0;i<list.size();i++){%>
	    	<a href="<%=basePath%>filePicture/filePicture_userQuery.action?photoid=<%=list.get(i).getId() %>">
	    	<div class="photo_block" style="width:200px;">
				<img src="<%=basePath %>img/photo.png" width="140" height="200">
				<div style="width:140px;">
					<div style="float:left;width:50%;">
						<%=list.get(i).getName() %>
					</div>
					<div style="float:left;text-align: right;position: relative;width:50%;">
						<a style="position: absolute;right:0;" href="<%=basePath%>photo/photo_delete.action?id=<%=list.get(i).getId() %>">ɾ��</a>
					</div>
				</div>
			</div>
			</a>
			<%} %>
			<div class="listFooter">
				<a href="#">
					<span class="prev"></span>
				</a>
				<div class="cut"></div>
				<span>��<strong><%=currentPage %>ҳ����<strong><%=totalPage %>ҳ</span>
				<div class="cut"></div>
				<a <%=currentPage == totalPage ? "href='#'" : "href='" + basePath + "photo/photo_userQuery.action?currentPage=" + (currentPage + 1) + "'" %>>
					<span class="next"></span>
				</a>
				<div class="info">��<strong><%=recordNumber %>����¼</div>
			</div>
	    </div>
    </div>
</div>
</body>
</html>