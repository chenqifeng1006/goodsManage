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
	String type = "giveGoodsRecord";	
	//�б��ҳ������ĵ�ַ
	String base = basePath + "giveGoodsRecord/giveGoodsRecord_";
	String listAction = basePath + "giveGoodsRecord/giveGoodsRecord_query.action";
	//ɾ�����ݵ������ַ
	String deleteAction = basePath + "giveGoods/giveGoods_delete.action";
	//�б�����
	List<GiveGoodsRecord> giveGoodsRecord=(List<GiveGoodsRecord>)request.getAttribute("list");
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
			<div><span>��Ʒ����:</span><input id="goodsname" type="text" ></div>
		<div class="manageButton">
			<a style="margin-top: -30px;" class="button" id="search">��ѯ</a>
		</div>
		</div>
		<div class="manageList">
			<table>
				<thead>
					<tr role="row">
						<th>��Ʒ����</th>
						<th>������</th>
						<th>����ʱ��</th>
						<th>״̬</th>						
						<th width="100px;">����</th>
					</tr>
				</thead>
				<tbody>
					<%for(int i = 0;i<giveGoodsRecord.size();i++){%>
					<tr>
						<td style="display:none;"><%=giveGoodsRecord.get(i).getId() %></td>
						<td><%=giveGoodsRecord.get(i).getGoodsname() %></td>
						<td><%=giveGoodsRecord.get(i).getUsername()%></td>
						<td style="display:none;"><%=giveGoodsRecord.get(i).getUserno() %></td>
						<td><%=giveGoodsRecord.get(i).getGive_time()%></td>
						<td><%=giveGoodsRecord.get(i).getStatus()%></td>
						<td>
							<% if("������".equals(giveGoodsRecord.get(i).getStatus())){%>
								<a  href="<%=base%>agree.action?id=<%=giveGoodsRecord.get(i).getId() %>">
									<span>ͬ��</span>
								</a>
								<a  href="<%=base%>refuse.action?id=<%=giveGoodsRecord.get(i).getId() %>">
									<span>�ܾ�</span>
								</a>
							<%} %>
							
							<% if("��ͬ��".equals(giveGoodsRecord.get(i).getStatus())){%>
								<a  href="<%=base%>give.action?id=<%=giveGoodsRecord.get(i).getId() %>">
									<span>����ȡ</span>
								</a>
							<%} %>
							
							<% if("�Ѿܾ�".equals(giveGoodsRecord.get(i).getStatus())){%>
								
							<%} %>
							
							<% if("����ȡ".equals(giveGoodsRecord.get(i).getStatus())){%>
								
							<%} %>
							
							<% if("�ѹ黹".equals(giveGoodsRecord.get(i).getStatus())){%>
								
							<%} %>
						</td>
					</tr>	
					<%}%>			
				</tbody>
			</table>
			<%if(giveGoodsRecord.size()==0){%>
				<div class="emptyData">��������,����Ӻ�鿴~</div>
			<%}%>
			<div class="listFooter">
				<a <%=currentPage == 1 ? "href='#'" : "href='" + listAction + "?currentPage=" + (currentPage - 1) + "'" %>>
					<span class="prev"></span>
				</a>
				<div class="cut"></div>
				<span>��<strong><%=currentPage %></strong>ҳ����<strong><%=totalPage %></strong>ҳ</span>
				<div class="cut"></div>
				<a <%=currentPage == totalPage ? "href='#'" : "href='" + basePath + "giveGoodsRecord/giveGoodsRecord_query.action?currentPage=" + (currentPage + 1) + "'" %>>
					<span class="next"></span>
				</a>
				<div class="info">��<strong><%=recordNumber %></strong>����¼</div>
			</div>
		</div>
	</div>
</div>
<script>
	$(function(){
		$('#search').click(function(){
			var goodsname = $('#goodsname').val(),
				path = "<%=listAction%>" ;
			if(goodsname){
				location.replace(path + '?goodsname='+encodeURIComponent(goodsname));
			}	
		})
	})
</script>
</body>
</html>