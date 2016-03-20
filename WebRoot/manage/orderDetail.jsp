<%@ page language="java" contentType="text/html; charset=GB2312" pageEncoding="GB2312"%>
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
	//页面分类
	String type = "order";	
	//列表数据
	List<ShoppingCarDTO> list=(List<ShoppingCarDTO>)request.getAttribute("list");
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
		<div class="manageSearch">
			<!-- <div><span>名称:</span><input type="text"></div>
			<div><span>名称:</span><input type="text"></div> -->
		</div>

		<div class="manageList">
			<table border="1">
				<thead>
					<tr role="row">
						<th width="120px;">图片</th>
						<th width="100px;">名称</th>						
						<th width="120px;">添加时间</th>
						<th width="140px;">数量</th>						
						<th width="100px;">价格</th>
					</tr>
				</thead>
				<tbody>
				<%for(int i=0;i<list.size();i++){ %>
					
					<tr>
	    			<td>
	    				<img width="100" height="100" src="<%=basePath %><%=list.get(i).getFileid() %>">
	    			</td>
	    			<td class="name">
	    				<%=list.get(i).getCommodityid()%>
	    			</td>
	    			<td class="time">
	    				<%=list.get(i).getCreationtime()%>

	    			</td>
	    			<td class="num">
	    				
	    				<span><%=list.get(i).getCount() %></span>
	    			</td>
	    			<td class="price shoppingCarPrice">
	    				<%=list.get(i).getPrice()%>
                	</td>
	    		</tr>
	    		<%} %>
				</tbody>
			</table>
		</div>
	</div>
</div>

</body>
</html>