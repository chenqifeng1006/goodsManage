<%@ page language="java" contentType="text/html;charset=GB2312"
    pageEncoding="GB2312"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.qinziwang.action.*" %>
<%@ page language="java" import="com.qinziwang.dao.*" %>
<%@ page language="java" import="com.qinziwang.domain.*" %>
<% 
	//��ǰ·��
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//��ҳ��
	int totalPage = (Integer)request.getAttribute("totalPage");
	//�ܼ�¼��
	int recordNumber = (Integer)request.getAttribute("recordNumber");
	//��ǰ�ڼ�ҳ
	int currentPage = (Integer)request.getAttribute("currentPage");
	//ҳ�����
	String type = "toy";	

	//�б�����
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
					
					<div class="title">��       �ƣ�<%=list.get(i).getName() %></div>
					<div class="author">��ɫ��<%=list.get(i).getColor()%></div>
					<div class="price">�۸񣺣�<%=list.get(i).getPrice() %></div>
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
				<span>��<strong><%=currentPage %>ҳ����<strong><%=totalPage %>ҳ</span>
				<div class="cut"></div>
				<a <%=currentPage == totalPage ? "href='#'" : "href='" + basePath + "toy/toy_query.action?currentPage=" + (currentPage + 1) + "'" %>>
					<span class="next"></span>
				</a>
				<div class="info">��<strong><%=recordNumber %>����¼</div>
			</div>
	    </div>
    </div>
</div>
</body>
</html>