<%@ page language="java" contentType="text/html; charset=GB2312" pageEncoding="GB2312"%>

<div class="manage_left">
	<a href="<%=basePath%>giveGoods/giveGoods_userQuery.action">
		<li class="<%= "giveGoods".equals(type) ? "current" :"" %>">申领物品</li>
	</a>
	<a href="<%=basePath%>borrowGoods/borrowGoods_userQuery.action">
		<li class="<%= "borrowGoods".equals(type) ? "current" :"" %>">借用物品</li>
	</a>
	<a href="<%=basePath%>giveGoodsRecord/giveGoodsRecord_userQuery.action">
		<li class="<%= "myGiveGoodsList".equals(type) ? "current" :"" %>">我的申领记录</li>
	</a>
	<a href="<%=basePath%>borrowGoodsRecord/borrowGoodsRecord_userQuery.action">
		<li class="<%= "myBorrowGoodsList".equals(type) ? "current" :"" %>">我的借用记录</li>
	</a>
	
</div>