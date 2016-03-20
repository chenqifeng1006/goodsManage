<%@ page language="java" contentType="text/html;charset=GB2312"
    pageEncoding="GB2312"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.qinziwang.action.*" %>
<%@ page language="java" import="com.qinziwang.dao.*" %>
<%@ page language="java" import="com.qinziwang.domain.*" %>
<% 
	//当前路径
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//总页数
	int totalPage = (Integer)request.getAttribute("totalPage");
	//总记录数
	int recordNumber = (Integer)request.getAttribute("recordNumber");
	//当前第几页
	int currentPage = (Integer)request.getAttribute("currentPage");
	//页面分类
	String type = "toy";	

	//列表数据
	List<Toy> list=(List<Toy>)request.getAttribute("list");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=GB2312">
<link rel="stylesheet" type="text/css" href="../css/ec/main.css">
<title>Insert title here</title>
</head>
<body>
<div class="w">
	<div class="w100">
		<%@ include  file="./top.jsp"%>
	    <%@ include  file="./menus.jsp"%>
	    <div class="ec_content">
	    
	    	
	    	<%for(int i = 0;i<list.size();i++){%>
	    	<div class="block">
				<img src="<%=basePath%><%=list.get(i).getFileid()%>" width="140" height="200">
				<div class="info">
					
					<div class="title">名       称：<%=list.get(i).getName() %></div>
					<div class="author">颜色：<%=list.get(i).getColor()%></div>
					<div class="price">价格：￥<%=list.get(i).getPrice() %></div>
					<a href="<%=basePath%>shoppingCar/shoppingCar_add.action?commodityid=<%=list.get(i).getId() %>&type=toy&price=<%=list.get(i).getPrice()%>">
					
						<span class="buyCar"></span>
					</a>
				</div>
			</div>
			<%} %>
			
			
			<div class="listFooter">
				<a href="#">
					<span class="prev"></span>
				</a>
				<div class="cut"></div>
				<span>第<strong><%=currentPage %>页，共<strong><%=totalPage %>页</span>
				<div class="cut"></div>
				<a <%=currentPage == totalPage ? "href='#'" : "href='" + basePath + "toy/toy_query.action?currentPage=" + (currentPage + 1) + "'" %>>
					<span class="next"></span>
				</a>
				<div class="info">共<strong><%=recordNumber %>条记录</div>
			</div>
	    </div>
    </div>
</div>
</body>
</html>