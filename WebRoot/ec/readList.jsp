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
<link rel="stylesheet" type="text/css" href="../css/ec/main.css">
<script type="text/javascript" scr="../javascript/jquery-2.1.1.min.js"></script>
</head>
<body>
<div class="w">
	<div class="w100">
		<%@ include  file="./top.jsp"%>
	    <%@ include  file="./menus.jsp"%>
	    <div class="ec_content">
	    	<table class="shoppingCar"  boder="0" cellpadding="0" cellspacing="0">
	    		<thead>
					<tr role="row">
						<th width="25px;">���</th>
						<th width="100px;">����</th>						
						<th width="100px;">����</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
		    			<td class="name">
		    				�������������ɵ�
		    			</td>
		    			<td class="menus">
		    				<a href="./reading/1.jsp">�鿴</a>
		    			</td>
	    			</tr>
	    			<tr>
						<td>2</td>
		    			<td class="name">
		    				ͯ��.���˼�.�ҵĴ�ѧ
		    			</td>
		    			<td class="menus">
		    				<a href="./reading/2.jsp">�鿴</a>
		    			</td>
	    			</tr>
				</tbody>
	    	</table>
	    </div>
    </div>
   
</div>
</body>
</html>