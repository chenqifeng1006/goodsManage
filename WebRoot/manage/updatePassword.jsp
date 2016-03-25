<%@ page language="java" contentType="text/html; charset=GB2312" pageEncoding="GB2312"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//页面分类
	String type = " ";	
	//列表分页的请求的地址
	String listAction = "";
	
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
	<div class="content" style="padding-top: 50px;text-align: center;">
		<div class="login-form" style="top: 5px;">
                <div class="login-box">
                    <div class="mc">
                        <div  class="form">
                            <form id="registForm" action="<%=basePath %>adminLogin/adminLogin_updatePassword.action" method="post">
                            	<div class="item item-fore1 mt20">
                                    <label class="login-label name-label">原密码</label>
                                    <input id="name" type="text" class="text" name="admin.oldPassword"  placeholder="原密码">
                                </div>
                                <div class="item item-fore1 mt20">
                                    <label class="login-label name-label">密码</label>
                                    <input id="name" type="text" class="text" name="admin.password"  placeholder="密码">
                                </div>
                                <div class="item item-fore5 mt20" style="  margin-left: 140px;">
                                    <div class="login-btn">
                                        <button type="submit" class="btn-img btn-entry" >提&nbsp;&nbsp;&nbsp;&nbsp;交</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
	</div>
</div>

</body>
</html>