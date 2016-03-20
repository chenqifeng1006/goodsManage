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
	String type = "life";	
	//�б��ҳ������ĵ�ַ
	String listAction = basePath + "life/life_query.action";
	//�������ݵ������ַ
	String addAction = basePath + "manage/lifeAdd.jsp";
	//�޸����ݵ������ַ
	String updateAction = basePath + "life/life_update.action";
	//ɾ�����ݵ������ַ
	String deleteAction = basePath + "life/life_delete.action";
	//�б�����
	List<Life> list=(List<Life>)request.getAttribute("list");
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
		<div class="manageButton">
			<a class="button" href="<%=addAction %>">����</a>
		</div>
		<div class="manageList">
			<table>
				<thead>
					<tr role="row">
						<th>���</th>
						<th>����</th>
						<th>��ɫ</th>		
						<th>Ʒ��</th>																
						<th>�۸�</th>
						<th>ͼƬ</th>
						
						<th width="100px;">����</th>
					</tr>
				</thead>
				<tbody>
					<%for(int i = 0;i<list.size();i++){%>
					<tr>
						<td><%=list.get(i).getId() %></td>
						<td><%=list.get(i).getName() %></td>
						<td><%=list.get(i).getBrand()%></td>
						
						<td><%=list.get(i).getColor() %></td>
						<td><%=list.get(i).getPrice() %></td>
						<td><input type="image" src="<%=basePath%><%=list.get(i).getFileid()%>"  width="50px" height="50px"/></td>
						
						<td>
							<a  href="<%=updateAction%>?id=<%=list.get(i).getId() %>">
								<span>�༭</span>
							</a>
							<a  href="<%=deleteAction%>?id=<%=list.get(i).getId() %>">
								<span>ɾ��</span>
							</a>
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
				<a <%=currentPage == totalPage ? "href='#'" : "href='" + basePath + "life/life_query.action?currentPage=" + (currentPage + 1) + "'" %>>
					<span class="next"></span>
				</a>
				<div class="info">��<strong><%=recordNumber %></strong>����¼</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>