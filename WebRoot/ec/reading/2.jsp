<%@ page language="java" contentType="text/html;charset=GB2312" pageEncoding="GB2312"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.qinziwang.action.*" %>
<%@ page language="java" import="com.qinziwang.dao.*" %>
<%@ page language="java" import="com.qinziwang.domain.*" %>
<% 
	//��ǰ·��
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	//ҳ�����
	String type = "read";	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="GB2312">
<title>������</title>
<link rel="stylesheet" type="text/css" href="../../css/ec/main.css">
<script type="text/javascript" scr="../../javascript/jquery-2.1.1.min.js"></script>
</head>
<body>
<div class="w">
	<div class="w100">
		<%@ include  file="../top.jsp"%>
	    <%@ include  file="../menus.jsp"%>
	    <div class="ec_content">
	    	<h1 style="text-align: center">ͯ��.���˼�.�ҵĴ�ѧ</h1>
	    	<p>
	    		xxxxx,yyyyy
	    	</p>
	    </div>
    </div>
</div>

</body>
</html>