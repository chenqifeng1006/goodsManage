<%@ page language="java" contentType="text/html; charset=GB2312" pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta charset="GB2312">
<title>������</title>
<link rel="stylesheet" type="text/css" href="../css/ec/main.css">
</head>
<body>
<div class="w100">
    <div class="logo">
        ������������
        <!-- <b></b> -->
    </div>
    <div class="login-wrap">
        <div class="w">

        </div>
        <div class="w">
            <div class="login-form" style="top: 5px;">
                <div class="login-box">
                    <div class="mt">
                        <h1>������</h1>
                        <div class="extra-r">
                            <!-- <div class="regist-link"><a href="./jsp/ec/regist.jsp" ><b></b>����ע��</a></div> -->
                        </div>
                    </div>
                    <div class="msg-wrap">
                        <div class="msg-warn hide"><b></b></div>
                        <div class="msg-error hide"><b></b></div>
                    </div>
                    <div class="mc">
                        <div  class="form">
                            <form id="registForm" action="<%=basePath %>userLogin/userLogin_regist.action" method="post">
                                <div class="item item-fore1">
                                    <label class="login-label name-label"></label>
                                    <input id="name" type="text" class="text" name="user.username"  placeholder="�û���">
                                </div>
                                <div id="entry" class="item item-fore2">
                                    <label class="login-label pwd-label"></label>
                                    <input id="psd1" type="password" name="user.password" class="text"  placeholder="����">
                                </div>
                                 
                                <div id="entry" class="item item-fore2">
                                    <label class="login-label pwd-label"></label>
                                    <input id="addr" type="text" name="user.address" class="text"  placeholder="��ַ">
                                </div>
                                <div id="entry" class="item item-fore2">
                                    <label class="login-label pwd-label"></label>
                                    <input id="tel" type="text" name="user.phone" class="text"  placeholder="�绰">
                                </div>
                                <div class="item item-fore5">
                                    <div class="login-btn">
                                        <button type="submit" class="btn-img btn-entry" >ע&nbsp;&nbsp;&nbsp;&nbsp;��</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="login-banner">
            <div class="w">
                <div id="banner-bg" class="i-inner">

                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>