<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="GB2312">
    <title>萌萌哒亲子网</title>
    <link rel="stylesheet" type="text/css" href="./css/ec/main.css">
</head>
<body>
<div class="w100">
    <div class="logo">
        萌萌哒亲子网
        <b></b>
    </div>
    <div class="login-wrap">
        <div class="w">
            
        </div>
        <form action="<%=basePath %>userLogin/userLogin_CheckLogin.action" method="post">
        <div class="w">
            <div class="login-form">
                <div class="login-box">
                    <div class="mt">
                        <h1>亲子网</h1>
                        <div class="extra-r">
                            <div class="regist-link"><a href="./ec/regist.jsp" ><b></b>立即注册</a></div>
                        </div>
                    </div>
                    <div class="msg-wrap">
                        <div class="msg-warn hide"><b></b></div>
                        <div class="msg-error hide"><b></b></div>
                    </div>
                    <div class="mc">
                        <div class="form">
                            <form>
                                <div class="item item-fore1">
                                    <label class="login-label name-label"></label>
                                    <input type="text" class="text" name="user.username"  placeholder="用户名">
                                </div>
                                <div id="entry" class="item item-fore2">
                                    <label class="login-label pwd-label"></label>
                                    <input type="password" name="user.password" class="text"  placeholder="密码">
                                </div>
                                <div class="item item-fore5">
                                    <div class="login-btn">
                                        <button type="submit" class="btn-img btn-entry" >登&nbsp;&nbsp;&nbsp;&nbsp;录</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </form>
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