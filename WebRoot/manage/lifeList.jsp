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
	String type = "life";	
	//列表分页的请求的地址
	String listAction = basePath + "life/life_query.action";
	//新增数据的请求地址
	String addAction = basePath + "manage/lifeAdd.jsp";
	//修改数据的请求地址
	String updateAction = basePath + "life/life_update.action";
	//删除数据的请求地址
	String deleteAction = basePath + "life/life_delete.action";
	//列表数据
	List<Life> list=(List<Life>)request.getAttribute("list");
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
		<div class="manageButton">
			<a class="button" href="<%=addAction %>">新增</a>
		</div>
		<div class="manageList">
			<table>
				<thead>
					<tr role="row">
						<th>编号</th>
						<th>名称</th>
						<th>颜色</th>		
						<th>品牌</th>																
						<th>价格</th>
						<th>图片</th>
						
						<th width="100px;">操作</th>
					</tr>
				</thead>
				<tbody>
					<%for(int i = 0;i<list.size();i++){%>
					<tr>
						<td><%=list.get(i).getId() %></td>
						<td><%=list.get(i).getName() %></td>
						<td><%=list.get(i).getBrand()%></td>
						
						<td><%=list.get(i).getColor() %></td>
						<td><%=list.get(i).getPrice() %></td>
						<td><input type="image" src="<%=basePath%><%=list.get(i).getFileid()%>"  width="50px" height="50px"/></td>
						
						<td>
							<a  href="<%=updateAction%>?id=<%=list.get(i).getId() %>">
								<span>编辑</span>
							</a>
							<a  href="<%=deleteAction%>?id=<%=list.get(i).getId() %>">
								<span>删除</span>
							</a>
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
				<a <%=currentPage == totalPage ? "href='#'" : "href='" + basePath + "life/life_query.action?currentPage=" + (currentPage + 1) + "'" %>>
					<span class="next"></span>
				</a>
				<div class="info">共<strong><%=recordNumber %></strong>条记录</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>