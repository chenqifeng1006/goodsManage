<%@ page language="java" contentType="text/html; charset=GB2312" pageEncoding="GB2312"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="com.goodsmanage.action.*" %>
<%@ page language="java" import="com.goodsmanage.dao.*" %>
<%@ page language="java" import="com.goodsmanage.domain.*" %>
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
	String type = "giveGoods";	
	//�б��ҳ������ĵ�ַ
	String listAction = basePath + "giveGoods/giveGoods_userQuery.action";
	//�޸����ݵ������ַ
	String updateAction = basePath + "giveGoods/giveGoods_userQpdate.action";
	//ɾ�����ݵ������ַ
	String addAction = basePath + "giveGoodsRecord/giveGoodsRecord_add.action";
	//�б�����
	List<GiveGoods> giveGoodsList=(List<GiveGoods>)request.getAttribute("list");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="GB2312">
    <title>������˾���ʹ���ϵͳ</title>
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
		<%-- <div class="manageButton">
			<a class="button" href="<%=addAction %>">����</a>
		</div> --%>
		<div class="manageList">
			<table>
				<thead>
					<tr role="row">
						<th>����</th>
						<th>���</th>
						<th>����</th>						
						<th width="100px;">����</th>
					</tr>
				</thead>
				<tbody>
					<%for(int i = 0;i<giveGoodsList.size();i++){%>
					<tr>
						<td style="display:none;"><%=giveGoodsList.get(i).getId() %></td>
						<td><%=giveGoodsList.get(i).getGoodsname() %></td>
						<td><%=giveGoodsList.get(i).getGoodsno()%></td>
						<td><%=giveGoodsList.get(i).getCount() %></td>
						<td>
							<a  href="<%=addAction%>?goodsid=<%=giveGoodsList.get(i).getId() %>">
								<span>��Ʒ����</span>
							</a>
						</td>
					</tr>	
					<%}%>			
				</tbody>
			</table>
			<%if(giveGoodsList.size()==0){%>
				<div class="emptyData">��������,����Ӻ�鿴~</div>
			<%}%>
			<div class="listFooter">
				<a <%=currentPage == 1 ? "href='#'" : "href='" + listAction + "?currentPage=" + (currentPage - 1) + "'" %>>
					<span class="prev"></span>
				</a>
				<div class="cut"></div>
				<span>��<strong><%=currentPage %></strong>ҳ����<strong><%=totalPage %></strong>ҳ</span>
				<div class="cut"></div>
				<a <%=currentPage == totalPage ? "href='#'" : "href='" + basePath + "giveGoods/giveGoods_userQuery.action?currentPage=" + (currentPage + 1) + "'" %>>
					<span class="next"></span>
				</a>
				<div class="info">��<strong><%=recordNumber %></strong>����¼</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>