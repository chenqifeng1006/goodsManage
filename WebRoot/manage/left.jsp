<%@ page language="java" contentType="text/html; charset=GB2312" pageEncoding="GB2312"%>

<div class="manage_left">
	<a href="<%=basePath%>manager/manager_query.action">
		<li class="<%= "manager".equals(type) ? "current" :"" %>">管理员管理</li>
	</a>
	<a href="<%=basePath%>book/book_query.action">
		<li class="<%= "book".equals(type) ? "current" :"" %>">图书管理</li>
	</a>
	<a href="<%=basePath%>toy/toy_query.action">
		<li class="<%= "toy".equals(type) ? "current" :"" %>">玩具管理</li>
	</a>
	<a href="<%=basePath%>cloth/cloth_query.action">
		<li class="<%= "cloth".equals(type) ? "current" :"" %>">服装管理</li>
	</a>
	<a href="<%=basePath%>life/life_query.action">
		<li class="<%= "life".equals(type) ? "current" :"" %>">家居管理</li>
	</a>
	<a href="<%=basePath%>travel/travel_query.action">
		<li class="<%= "travel".equals(type) ? "current" :"" %>">旅游管理</li>
	</a>
	<a href="<%=basePath%>order/order_query.action">
		<li class="<%= "order".equals(type) ? "current" :"" %>">订单管理</li>
	</a>
	
</div>