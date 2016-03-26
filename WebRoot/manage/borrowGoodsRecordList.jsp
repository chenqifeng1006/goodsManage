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
	String type = "borrowGoodsRecord";	
	//列表分页的请求的地址
	String base = basePath + "borrowGoodsRecord/borrowGoodsRecord_";
	String listAction = basePath + "borrowGoodsRecord/borrowGoodsRecord_query.action";
	//删除数据的请求地址
	String deleteAction = basePath + "borrowGoods/borrowGoods_delete.action";
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
			<div><span>物品名称:</span><input id="goodsname" type="text" ></div>
		<div class="manageButton">
			<a style="margin-top: -30px;" class="button" id="search">查询</a>
		</div>
		</div>
		<div class="manageList">
			<table>
				<thead>
					<tr role="row">
						<th>物品名称</th>
						<th>申请人</th>
						<th>申请时间</th>
						<th>状态</th>						
						<th width="100px;">操作</th>
					</tr>
				</thead>
				<tbody>
					<%for(int i = 0;i<borrowGoodsRecord.size();i++){%>
					<tr>
						<td style="display:none;"><%=borrowGoodsRecord.get(i).getId() %></td>
						<td><%=borrowGoodsRecord.get(i).getGoodsname() %></td>
						<td><%=borrowGoodsRecord.get(i).getUsername()%></td>
						<td style="display:none;"><%=borrowGoodsRecord.get(i).getUserno() %></td>
						<td><%=borrowGoodsRecord.get(i).getBorrow_time()%></td>
						<td><%=borrowGoodsRecord.get(i).getStatus()%></td>
						<td>
							<% if("申请中".equals(borrowGoodsRecord.get(i).getStatus())){%>
								<a  href="<%=base%>agree.action?id=<%=borrowGoodsRecord.get(i).getId() %>">
									<span>同意</span>
								</a>
								<a  href="<%=base%>refuse.action?id=<%=borrowGoodsRecord.get(i).getId() %>">
									<span>拒绝</span>
								</a>
							<%} %>
							
							<% if("已同意".equals(borrowGoodsRecord.get(i).getStatus())){%>
								<a  href="<%=base%>borrow.action?id=<%=borrowGoodsRecord.get(i).getId() %>">
									<span>已借用</span>
								</a>
							<%} %>
							
							<% if("已拒绝".equals(borrowGoodsRecord.get(i).getStatus())){%>
								
							<%} %>
							
							<% if("已借用".equals(borrowGoodsRecord.get(i).getStatus())){%>
								<a  href="<%=base%>returnBack.action?id=<%=borrowGoodsRecord.get(i).getId() %>">
									<span>已归还</span>
								</a>
							<%} %>
							
							<% if("已归还".equals(borrowGoodsRecord.get(i).getStatus())){%>
								
							<%} %>
						</td>
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
				<a <%=currentPage == totalPage ? "href='#'" : "href='" + basePath + "borrowGoodsRecord/borrowGoodsRecord_query.action?currentPage=" + (currentPage + 1) + "'" %>>
					<span class="next"></span>
				</a>
				<div class="info">共<strong><%=recordNumber %></strong>条记录</div>
			</div>
		</div>
	</div>
</div>
<script>
	$(function(){
		$('#search').click(function(){
			var goodsname = $('#goodsname').val(),
				path = "<%=listAction%>" ;
			if(goodsname){
				location.replace(path + '?goodsname='+encodeURIComponent(goodsname));
			}	
		})
	})
</script>
</body>
</html>