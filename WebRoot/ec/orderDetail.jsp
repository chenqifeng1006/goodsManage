<%@ page language="java" contentType="text/html;charset=GB2312" pageEncoding="GB2312"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.qinziwang.action.*" %>
<%@ page language="java" import="com.qinziwang.dao.*" %>
<%@ page language="java" import="com.qinziwang.domain.*" %>
<% 
	//��ǰ·��
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	//�б�����
	List<ShoppingCarDTO> list=(List<ShoppingCarDTO>)request.getAttribute("list");
	String type ="";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="GB2312">
<title>������</title>
<link rel="stylesheet" type="text/css" href="../css/ec/main.css">
<script type="text/javascript" scr="../javascript/jquery-2.1.1.min.js"></script>
</head>
<body>
<div class="w">
	<div class="w100">
		<%@ include  file="./top.jsp"%>
	    <%@ include  file="./menus.jsp"%>
	    <div class="ec_content">
	    	<table class="shoppingCar"  boder="0" cellpadding="0" cellspacing="0">
	    		<thead>
					<tr role="row">
						<th width="120px;">ͼƬ</th>
						<th width="100px;">����</th>						
						<th width="120px;">���ʱ��</th>
						<th width="140px;">����</th>						
						<th width="100px;">�۸�</th>
					</tr>
				</thead>
				<tbody>
				<%for(int i=0;i<list.size();i++){ %>
					
					<tr>
	    			<td>
	    				<img src="<%=basePath %><%=list.get(i).getFileid() %>">
	    			</td>
	    			<td class="name">
	    				<%=list.get(i).getCommodityid()%>
	    			</td>
	    			<td class="time">
	    				<%=list.get(i).getCreationtime()%>

	    			</td>
	    			<td class="num">
	    				
	    				<span><%=list.get(i).getCount() %></span>
	    			</td>
	    			<td class="price shoppingCarPrice">
	    				<%=list.get(i).getPrice()%>
                	</td>
	    		</tr>
	    		<%} %>
				</tbody>
	    	</table>
	    </div>
    </div>
   
</div>
</body>
</html>