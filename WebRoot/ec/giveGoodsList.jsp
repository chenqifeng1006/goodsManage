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
	String type = "giveGoods";	
	//列表分页的请求的地址
	String listAction = basePath + "giveGoods/giveGoods_userQuery.action";
	//修改数据的请求地址
	String updateAction = basePath + "giveGoods/giveGoods_userQpdate.action";
	//删除数据的请求地址
	String addAction = basePath + "giveGoodsRecord/giveGoodsRecord_add.action";
	//列表数据
	List<GiveGoods> giveGoodsList=(List<GiveGoods>)request.getAttribute("list");
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
		<%-- <div class="manageButton">
			<a class="button" href="<%=addAction %>">新增</a>
		</div> --%>
		<div class="manageList">
			<table>
				<thead>
					<tr role="row">
						<th>名称</th>
						<th>编号</th>
						<th>数量</th>						
						<th width="100px;">操作</th>
					</tr>
				</thead>
				<tbody>
					<%for(int i = 0;i<giveGoodsList.size();i++){%>
					<tr>
						<td style="display:none;"><%=giveGoodsList.get(i).getId() %></td>
						<td><%=giveGoodsList.get(i).getGoodsname() %></td>
						<td><%=giveGoodsList.get(i).getGoodsno()%></td>
						<td><%=giveGoodsList.get(i).getCount() %></td>
						<td>
							<a  href="<%=addAction%>?goodsid=<%=giveGoodsList.get(i).getId() %>">
								<span>物品申领</span>
							</a>
						</td>
					</tr>	
					<%}%>			
				</tbody>
			</table>
			<%if(giveGoodsList.size()==0){%>
				<div class="emptyData">暂无数据,请添加后查看~</div>
			<%}%>
			<div class="listFooter">
				<a <%=currentPage == 1 ? "href='#'" : "href='" + listAction + "?currentPage=" + (currentPage - 1) + "'" %>>
					<span class="prev"></span>
				</a>
				<div class="cut"></div>
				<span>第<strong><%=currentPage %></strong>页，共<strong><%=totalPage %></strong>页</span>
				<div class="cut"></div>
				<a <%=currentPage == totalPage ? "href='#'" : "href='" + basePath + "giveGoods/giveGoods_userQuery.action?currentPage=" + (currentPage + 1) + "'" %>>
					<span class="next"></span>
				</a>
				<div class="info">共<strong><%=recordNumber %></strong>条记录</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>