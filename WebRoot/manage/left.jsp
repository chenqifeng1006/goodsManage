<%@ page language="java" contentType="text/html; charset=GB2312" pageEncoding="GB2312"%>

<div class="manage_left">
	<a href="<%=basePath%>manager/manager_query.action">
		<li class="<%= "manager".equals(type) ? "current" :"" %>">����Ա����</li>
	</a>
	<a href="<%=basePath%>book/book_query.action">
		<li class="<%= "book".equals(type) ? "current" :"" %>">ͼ�����</li>
	</a>
	<a href="<%=basePath%>toy/toy_query.action">
		<li class="<%= "toy".equals(type) ? "current" :"" %>">��߹���</li>
	</a>
	<a href="<%=basePath%>cloth/cloth_query.action">
		<li class="<%= "cloth".equals(type) ? "current" :"" %>">��װ����</li>
	</a>
	<a href="<%=basePath%>life/life_query.action">
		<li class="<%= "life".equals(type) ? "current" :"" %>">�Ҿӹ���</li>
	</a>
	<a href="<%=basePath%>travel/travel_query.action">
		<li class="<%= "travel".equals(type) ? "current" :"" %>">���ι���</li>
	</a>
	<a href="<%=basePath%>order/order_query.action">
		<li class="<%= "order".equals(type) ? "current" :"" %>">��������</li>
	</a>
	
</div>