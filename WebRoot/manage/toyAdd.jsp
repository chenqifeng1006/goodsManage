<%@ page language="java" contentType="text/html; charset=GB2312" pageEncoding="GB2312"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.qinziwang.action.*" %>
<%@ page language="java" import="com.qinziwang.dao.*" %>
<%@ page language="java" import="com.qinziwang.domain.*" %>

<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//页面分类
	String type = "toy";	
	//添加的请求地址
	String saveAction = basePath + "toy/toy_add.action";

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="GB2312">
    <title>萌萌哒亲子网</title>
	<link rel="stylesheet" type="text/css" href="../css/manage/main.css">
	<script type="text/javascript" src="../javascript/jquery.js"></script>
</head>
<body>
<%@ include  file="./top.jsp"%>
<%@ include  file="./left.jsp"%>

<div class="manage_right">
	<div class="content">
		<div class="formTitle">
			<span>新建玩具</span>
		</div>
		<div class="formPage">
		<form action="<%=saveAction %>" method="post" enctype="multipart/form-data" name="toyForm" id="toyForm">
		
				<table>
					<tr>
						<td>名称：</td>
						<td><input type="text" name="toy.name"/></td>
					</tr>
					<tr>
						<td>颜色：</td>
						<td><input type="text" name="toy.color"/></td>
					</tr>
					<tr>
						<td>价格：</td>
						<td><input type="text" name="toy.price"/></td>
					</tr>
					<tr>
						<td>图片：</td>
						<td><input type="file" id="photoFile" name="photoFile"/>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><button class="submit" type="submit">确定</button></td>
					</tr>
				</table>
				</form>
		
		</div>
	</div>
</div>
	
</body>
</html>