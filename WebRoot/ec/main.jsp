<%@ page language="java" contentType="text/html;charset=GB2312" pageEncoding="GB2312"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//ҳ�����
	String type = "";	
	//�б��ҳ������ĵ�ַ
	String listAction = "";
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="GB2312">
<title>������</title>
<link rel="stylesheet" type="text/css" href="../css/ec/main.css">
</head>
<body>

<div class="w">
	<div class="w100">
		<%@ include  file="./top.jsp"%>
	    <%@ include  file="./menus.jsp"%>
	    <div style="font-size:40px;font-weight: bold;color: red;margin:100px auto;  width: 450px;text-align: center;">
	    	��ӭʹ��������������
	    </div>
    </div>
</div>

</body>
</html>