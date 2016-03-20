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
	//列表分页的请求的地址
	String listAction = basePath + "order/order_query.action";
	//处理订单的请求地址
	String dealAction = basePath + "order/order_deal.action";
	//列表数据
	List<ServiceOrderDTO> list=(List<ServiceOrderDTO>)request.getAttribute("list");
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
						<th>编号</th>
						<th>用户名称</th>
						<th>商品名称</th>		
						<th>创建时间</th>																
						<th>价格</th>
						<th>状态</th>
						
						<th width="100px;">操作</th>
					</tr>
				</thead>
				<tbody>
					<%for(int i = 0;i<list.size();i++){%>
					<tr>
						<td><%=list.get(i).getId() %></td>
						<td><%=list.get(i).getUsername() %></td>
						<td>
						   <a href="<%=basePath%>order/order_manageDetail.action?id=<%=list.get(i).getId() %>"><span>详细</span></a>
						</td>
						<td><%=list.get(i).getCreationtime() %></td>
						<td><%=list.get(i).getPrice() %></td>						
						<td><%=list.get(i).getStatus() %></td>
						
						<td>
							<%if("购买中".equals(list.get(i).getStatus())){%>
								<a  href="<%=dealAction%>?id=<%=list.get(i).getId() %>">
									<span><a href="<%=basePath%>order/order_deal.action?id=<%=list.get(i).getId() %>">处理</a></span>
								</a>
							<%}%>
						</td>
					</tr>	
					<%}%>			
				</tbody>
			</table>
			<%if(list.size()==0){%>
				<div class="emptyData">暂无数据,请添加后查看~</div>
			<%}%>
			<div class="listFooter">
				<a <%=currentPage == 1 ? "href='#'" : "href='" + listAction + "?currentPage=" + (currentPage - 1) + "'" %>>
					<span class="prev"></span>
				</a>
				<div class="cut"></div>
				<span>第<strong><%=currentPage %></strong>页，共<strong><%=totalPage %></strong>页</span>
				<div class="cut"></div>
				<a <%=currentPage == totalPage ? "href='#'" : "href='" + basePath + "order/order_query.action?currentPage=" + (currentPage + 1) + "'" %>>
					<span class="next"></span>
				</a>
				<div class="info">共<strong><%=recordNumber %></strong>条记录</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>