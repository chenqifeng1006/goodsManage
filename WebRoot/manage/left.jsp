<%@ page language="java" contentType="text/html; charset=GB2312" pageEncoding="GB2312"%>

<div class="manage_left">
	<a href="<%=basePath%>giveGoods/giveGoods_query.action">
		<li class="<%= "giveGoods".equals(type) ? "current" :"" %>">������Ʒ����</li>
	</a>
	<a href="<%=basePath%>borrowGoods/borrowGoods_query.action">
		<li class="<%= "borrowGoods".equals(type) ? "current" :"" %>">������Ʒ����</li>
	</a>
	<a href="<%=basePath%>giveGoodsRecord/giveGoodsRecord_query.action">
		<li class="<%= "giveGoodsRecord".equals(type) ? "current" :"" %>">���ü�¼����</li>
	</a>
	<a href="<%=basePath%>borrowGoodsRecord/borrowGoodsRecord_query.action">
		<li class="<%= "borrowGoodsRecord".equals(type) ? "current" :"" %>">���ü�¼����</li>
	</a>
	
</div>