<%@ page language="java" contentType="text/html;charset=GB2312" pageEncoding="GB2312"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.qinziwang.action.*" %>
<%@ page language="java" import="com.qinziwang.dao.*" %>
<%@ page language="java" import="com.qinziwang.domain.*" %>
<% 
	//当前路径
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	//页面分类
	String type = "read";	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="GB2312">
<title>亲子网</title>
<link rel="stylesheet" type="text/css" href="../../css/ec/main.css">
<script type="text/javascript" scr="../../javascript/jquery-2.1.1.min.js"></script>
</head>
<body>
<div class="w">
	<div class="w100">
		<%@ include  file="../top.jsp"%>
	    <%@ include  file="../menus.jsp"%>
	    <div class="ec_content">
	    	<h1 style="text-align: center">童年.在人间.我的大学</h1>
	    	<p>
	    		xxxxx,yyyyy
	    	</p>
	    </div>
    </div>
</div>

</body>
</html>