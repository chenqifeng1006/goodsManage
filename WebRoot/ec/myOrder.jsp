<%@ page language="java" contentType="text/html;charset=GB2312" pageEncoding="GB2312"%>
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
	String type = "order";	
	//列表分页的请求的地址
	String listAction = basePath + "order/order_myOrder.action";

	String deleteAction = basePath + "myOrder/myOrder_delete.action";
	//列表数据
	List<ServiceOrderDTO> list=(List<ServiceOrderDTO>)request.getAttribute("list");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="GB2312">
<title>亲子网</title>
<link rel="stylesheet" type="text/css" href="../css/ec/main.css">
<script type="text/javascript" scr="../javascript/jquery.js"></script>
</head>
<body>
<div class="w">
	<div class="w100">
		<%@ include  file="./top.jsp"%>
	    <%@ include  file="./menus.jsp"%>
	    <div class="ec_content">
	    	<table class="shoppingCar"  border="0" cellpadding="0" cellspacing="0">
	    		<thead>
					<tr role="row">
						<th width="25px;">编号</th>				
						<th width="120px;">添加时间</th>				
						<th width="100px;">价格</th>
						<th width="100px;">状态</th>
						<th width="100px;">操作</th>
					</tr>
				</thead>
				<tbody>
				<%for(int i=0;i<list.size();i++){ %>
					<tr>
	    			<td class="shoppingCarId">
	    			    <%=list.get(i).getId()%>
	    			</td>
	    		
	    			<td class="time">
	    				<%=list.get(i).getCreationtime() %>
	    			</td>
	    			
	    			<td class="price">
	    				<%=list.get(i).getPrice() %>
	    			</td>
	    			<td class="menus">
	    			    <%=list.get(i).getStatus() %>
	    			</td>
	    			<td>
	    				<a href="<%=basePath %>order/order_detail.action?id=<%=list.get(i).getId()%>">详细</a>
	    			</td>
	    		</tr>
	    		<%} %>
				</tbody>
	    	</table>
	    </div>
    </div>
    <form id="addOrderForm" action="" method="post" style="display:none;">
    	<input id="ids" type="hidden" name="ids" value="">
    </form>
</div>
<script>

	$('#addOrder').click(function(){
		var ids = [],
			idStr = '';
		$('#shoppingCarId').each(function(){
			ids.push($(this).text());
		})
		idStr = ids.join(',');
		$('#ids').val(idStr);
		$('#addOrderForm').submit();
	})
	
</script>
</body>
</html>