<%@ page language="java" contentType="text/html; charset=GB2312" pageEncoding="GB2312"%>
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
	String type = "order";	
	//�б��ҳ������ĵ�ַ
	String listAction = basePath + "order/order_query.action";
	//�������������ַ
	String dealAction = basePath + "order/order_deal.action";
	//�б�����
	List<ServiceOrderDTO> list=(List<ServiceOrderDTO>)request.getAttribute("list");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="GB2312">
    <title>������������</title>
	<link rel="stylesheet" type="text/css" href="../css/manage/main.css">
	<script type="text/javascript" src="../javascript/jquery.js"></script>
</head>
<body>
<%@ include  file="./top.jsp"%>
<%@ include  file="./left.jsp"%>
<div class="manage_right">
	<div class="content">
		<!-- �û��б� -->
		<div class="manageSearch">
			<!-- <div><span>����:</span><input type="text"></div>
			<div><span>����:</span><input type="text"></div> -->
		</div>

		<div class="manageList">
			<table border="1">
				<thead>
					<tr role="row">
						<th>���</th>
						<th>�û�����</th>
						<th>��Ʒ����</th>		
						<th>����ʱ��</th>																
						<th>�۸�</th>
						<th>״̬</th>
						
						<th width="100px;">����</th>
					</tr>
				</thead>
				<tbody>
					<%for(int i = 0;i<list.size();i++){%>
					<tr>
						<td><%=list.get(i).getId() %></td>
						<td><%=list.get(i).getUsername() %></td>
						<td>
						   <a href="<%=basePath%>order/order_manageDetail.action?id=<%=list.get(i).getId() %>"><span>��ϸ</span></a>
						</td>
						<td><%=list.get(i).getCreationtime() %></td>
						<td><%=list.get(i).getPrice() %></td>						
						<td><%=list.get(i).getStatus() %></td>
						
						<td>
							<%if("������".equals(list.get(i).getStatus())){%>
								<a  href="<%=dealAction%>?id=<%=list.get(i).getId() %>">
									<span><a href="<%=basePath%>order/order_deal.action?id=<%=list.get(i).getId() %>">����</a></span>
								</a>
							<%}%>
						</td>
					</tr>	
					<%}%>			
				</tbody>
			</table>
			<%if(list.size()==0){%>
				<div class="emptyData">��������,����Ӻ�鿴~</div>
			<%}%>
			<div class="listFooter">
				<a <%=currentPage == 1 ? "href='#'" : "href='" + listAction + "?currentPage=" + (currentPage - 1) + "'" %>>
					<span class="prev"></span>
				</a>
				<div class="cut"></div>
				<span>��<strong><%=currentPage %></strong>ҳ����<strong><%=totalPage %></strong>ҳ</span>
				<div class="cut"></div>
				<a <%=currentPage == totalPage ? "href='#'" : "href='" + basePath + "order/order_query.action?currentPage=" + (currentPage + 1) + "'" %>>
					<span class="next"></span>
				</a>
				<div class="info">��<strong><%=recordNumber %></strong>����¼</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>