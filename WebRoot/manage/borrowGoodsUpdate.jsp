<%@ page language="java" contentType="text/html; charset=GB2312" pageEncoding="GB2312"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.goodsmanage.action.*" %>
<%@ page language="java" import="com.goodsmanage.dao.*" %>
<%@ page language="java" import="com.goodsmanage.domain.*" %>

<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

	//页面分类
	String type = "borrowGoods";	
	//保存的请求地址
	String saveAction = basePath + "borrowGoods/borrowGoods_save.action";
	BorrowGoods borrowGoods = (BorrowGoods)request.getAttribute("entity");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="GB2312">
    <title>启化公司物资管理系统</title>
	<link rel="stylesheet" type="text/css" href="../css/manage/main.css">
	<script type="text/javascript" src="../javascript/jquery.js"></script>
</head>
<body>
<%@ include  file="./top.jsp"%>
<%@ include  file="./left.jsp"%>

<div class="manage_right">
	<div class="content">
		<div class="formTitle">
			<span>编辑借用物品</span>
		</div>
		<div class="formPage">
		<form action="<%=saveAction %>" method="post" name="bookForm" id="bookForm">
				<input type="hidden" name="entity.id" value="<%=borrowGoods.getId() %>"/>
				<table>
					<tr>
						<td>名称：</td>
						<td><input type="text" name="entity.goodsname" value="<%=borrowGoods.getGoodsname()%>"/></td>
					</tr>
					<tr>
						<td>编号：</td>
						<td><input type="text" name="entity.goodsno"  value="<%=borrowGoods.getGoodsno()%>"/></td>
					</tr>
					<tr style="display:none;">
						<td>状态：</td>
						<td><input type="text" name="entity.status"   value="<%=borrowGoods.getStatus()%>"/></td>
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