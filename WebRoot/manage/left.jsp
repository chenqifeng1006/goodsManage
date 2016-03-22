<%@ page language="java" contentType="text/html; charset=GB2312" pageEncoding="GB2312"%>

<div class="manage_left">

	<a href="<%=basePath%>book/book_query.action">
		<li class="<%= "book".equals(type) ? "current" :"" %>">领用物品管理</li>
	</a>
	<a href="<%=basePath%>toy/toy_query.action">
		<li class="<%= "toy".equals(type) ? "current" :"" %>">借用物品管理</li>
	</a>
	<a href="<%=basePath%>cloth/cloth_query.action">
		<li class="<%= "cloth".equals(type) ? "current" :"" %>">领用申请</li>
	</a>
	<a href="<%=basePath%>life/life_query.action">
		<li class="<%= "life".equals(type) ? "current" :"" %>">借用申请</li>
	</a>
	
</div>