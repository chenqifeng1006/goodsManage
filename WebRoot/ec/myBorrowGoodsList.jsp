<%@ page language="java" contentType="text/html; charset=GB2312" pageEncoding="GB2312"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.goodsmanage.action.*" %>
<%@ page language="java" import="com.goodsmanage.dao.*" %>
<%@ page language="java" import="com.goodsmanage.domain.*" %>
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
	//页面分类
	String type = "myBorrowGoodsList";	
	//列表分页的请求的地址
	String listAction = basePath + "borrowGoodsRecord/borrowGoodsRecord_userQuery.action";
	//列表数据
	List<BorrowGoodsRecord> borrowGoodsRecord=(List<BorrowGoodsRecord>)request.getAttribute("list");
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
		<!-- 用户列表 -->
		<div class="manageSearch">
			<!-- <div><span>名称:</span><input type="text"></div>
			<div><span>名称:</span><input type="text"></div> -->
		</div>
		<div class="manageList">
			<table>
				<thead>
					<tr role="row">
						<th>物品名称</th>
						<th>申请时间</th>
						<th>归还时间</th>
						<th>状态</th>						
					</tr>
				</thead>
				<tbody>
					<%for(int i = 0;i<borrowGoodsRecord.size();i++){%>
					<tr>
						<td><%=borrowGoodsRecord.get(i).getGoodsname() %></td>
						<td><%=borrowGoodsRecord.get(i).getBorrow_time() %></td>
						<td><%=borrowGoodsRecord.get(i).getReturn_time() != null ? borrowGoodsRecord.get(i).getReturn_time():""%></td>
						<td><%=borrowGoodsRecord.get(i).getStatus() %></td>
					</tr>	
					<%}%>			
				</tbody>
			</table>
			<%if(borrowGoodsRecord.size()==0){%>
				<div class="emptyData">暂无数据,请添加后查看~</div>
			<%}%>
			<div class="listFooter">
				<a <%=currentPage == 1 ? "href='#'" : "href='" + listAction + "?currentPage=" + (currentPage - 1) + "'" %>>
					<span class="prev"></span>
				</a>
				<div class="cut"></div>
				<span>第<strong><%=currentPage %></strong>页，共<strong><%=totalPage %></strong>页</span>
				<div class="cut"></div>
				<a <%=currentPage == totalPage ? "href='#'" : "href='" + basePath + "borrowGoodsRecord/borrowGoodsRecord_userQuery.action?currentPage=" + (currentPage + 1) + "'" %>>
					<span class="next"></span>
				</a>
				<div class="info">共<strong><%=recordNumber %></strong>条记录</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>