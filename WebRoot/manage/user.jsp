<%@ page language="java" contentType="text/html; charset=GB2312" pageEncoding="GB2312"%>
<% 
	//页面分类
	String type = "user";	
	//列表分页的请求的地址
	String listAction = "";
	
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
		<!-- 用户列表 -->
		<form id="listForm" action="<%=listAction %>" method="get">
		<div class="manageSearch">
			<div><span>名称:</span><input type="text"></div>
			<div><span>名称:</span><input type="text"></div>
		</div>
		<div class="manageButton">
			<button class="add">新增</button>
			<button class="search">查询</button>
		</div>
		<div class="manageList">
			<table>
				<thead>
					<tr role="row">
						<th>
							编号
						</th>
						<th>
							名称
						</th>
						<th>
							电话
						</th>
						<th>
							地址
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>陈奇峰</td>
						<td>18642838458</td>
						<td>大连市中山区</td>
						<td>删除,修改</td>
					</tr>
				</tbody>
			</table>
			<div class="listFooter">
				<a><span class="prev"></span></a>
				<div class="cut"></div>
				<span>第<strong>1</strong>页，共<strong>80</strong>页</span>
				<div class="cut"></div>
				<a><span class="next"></span></a>
				
				<div class="info">共<strong>1585</strong>条记录，当前显示第<strong>21</strong>到第<strong>40</strong>条</div>
			</div>
		</div>
		</form>
	</div>
</div>

</body>
</html>