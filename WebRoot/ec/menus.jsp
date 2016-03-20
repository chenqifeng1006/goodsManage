<%@ page language="java" contentType="text/html;charset=GB2312" pageEncoding="GB2312"%>
<ul class="navbar cf log-mod-viewed ec_menus">
	<li class="navbar__item-w <%= "book".equals(type) ? "current" :"" %>">
		<a class="navbar__item" href="<%=basePath%>book/book_userQuery.action" >
			<span class="nav-label">ͼ��</span>
		</a>
	</li>
	<li class="navbar__item-w <%= "toy".equals(type) ? "current" :"" %>">
		<a class="navbar__item" href="<%=basePath%>toy/toy_userQuery.action" >
			<span class="nav-label">���</span>
		</a>
	</li>
	<li class="navbar__item-w <%= "cloth".equals(type) ? "current" :"" %>">
		<a class="navbar__item" href="<%=basePath%>cloth/cloth_userQuery.action" >
			<span class="nav-label">��װ</span>
		</a>
	</li>
	<li class="navbar__item-w <%= "life".equals(type) ? "current" :"" %>">
		<a class="navbar__item" href="<%=basePath%>life/life_userQuery.action" >
			<span class="nav-label">�Ҿ�</span>
		</a>
	</li>
	<li class="navbar__item-w <%= "travel".equals(type) ? "current" :"" %>">
		<a class="navbar__item" href="<%=basePath%>travel/travel_userQuery.action" >
			<span class="nav-label">����</span>
		</a>
	</li>
	<li class="navbar__item-w <%= "read".equals(type) ? "current" :"" %>">
		<a class="navbar__item" href="<%=basePath %>ec/readList.jsp" >
			<span class="nav-label">�Ķ�</span>
		</a>
	</li>
	<li class="navbar__item-w <%= "photo".equals(type) ? "current" :"" %>">
		<a class="navbar__item" href="<%=basePath%>photo/photo_userQuery.action" >
			<span class="nav-label">���</span>
		</a>
	</li>
</ul>