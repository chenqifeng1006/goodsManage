<%@ page language="java" contentType="text/html; charset=GB2312" pageEncoding="GB2312"%>
<div class="manage_top">
	<div>
		启化公司物资管理系统管理系统
		<a href="../manage/updatePassword.jsp">
			<span>修改密码</span>
		</a>
		<a href="../manage/updateInfo.jsp">
			<span><%=(String)session.getAttribute("name") %>您好</span>
		</a>
	</div>
</div>
