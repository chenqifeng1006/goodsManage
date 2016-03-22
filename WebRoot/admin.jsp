<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="GB2312">
    <title>启化公司物资管理系统</title>
<link rel="stylesheet" type="text/css" href="./css/manage/main.css">
<link rel="stylesheet" type="text/css" href="./css/manage/admin.css">
<script type="text/javascript" src="./javascript/jquery.js"></script>
</head>
<div class="admin_top">
    启化公司物资管理系统
</div>
<div class="login">
<div class="login_top">
    请登录
</div>
<div>
	<form action="<%=basePath %>adminLogin/adminLogin_CheckLogin.action" method="post">
    <table width="100%">
        <tr>
            <td width="40%" height="50px" align="center">用户名:</td>
            <td width="60%" align="left">
                <input type="text" name="admin.loginid"/>
            </td>
        </tr>
        <tr>
            <td width="40%" height="50px" align="center">密码:</td>
            <td width="60%" align="left">
                <input type="password" name="admin.password"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit" class="submit">确定</button>
            </td>
        </tr>
    </table>
    </form>
</div>
</div>
</body>
</html>