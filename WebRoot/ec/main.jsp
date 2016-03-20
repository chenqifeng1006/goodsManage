<%@ page language="java" contentType="text/html;charset=GB2312" pageEncoding="GB2312"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//页面分类
	String type = "";	
	//列表分页的请求的地址
	String listAction = "";
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="GB2312">
<title>亲子网</title>
<link rel="stylesheet" type="text/css" href="../css/ec/main.css">
</head>
<body>

<div class="w">
	<div class="w100">
		<%@ include  file="./top.jsp"%>
	    <%@ include  file="./menus.jsp"%>
	    <div style="font-size:40px;font-weight: bold;color: red;margin:100px auto;  width: 450px;text-align: center;">
	    	欢迎使用萌萌哒亲子网
	    </div>
    </div>
</div>

</body>
</html>