<%@ page language="java" contentType="text/html; charset=GB2312" pageEncoding="GB2312"%>
<% 
	//ҳ�����
	String type = "user";	
	//�б��ҳ������ĵ�ַ
	String listAction = "";
	
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
		<form id="listForm" action="<%=listAction %>" method="get">
		<div class="manageSearch">
			<div><span>����:</span><input type="text"></div>
			<div><span>����:</span><input type="text"></div>
		</div>
		<div class="manageButton">
			<button class="add">����</button>
			<button class="search">��ѯ</button>
		</div>
		<div class="manageList">
			<table>
				<thead>
					<tr role="row">
						<th>
							���
						</th>
						<th>
							����
						</th>
						<th>
							�绰
						</th>
						<th>
							��ַ
						</th>
						<th>
							����
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>�����</td>
						<td>18642838458</td>
						<td>��������ɽ��</td>
						<td>ɾ��,�޸�</td>
					</tr>
				</tbody>
			</table>
			<div class="listFooter">
				<a><span class="prev"></span></a>
				<div class="cut"></div>
				<span>��<strong>1</strong>ҳ����<strong>80</strong>ҳ</span>
				<div class="cut"></div>
				<a><span class="next"></span></a>
				
				<div class="info">��<strong>1585</strong>����¼����ǰ��ʾ��<strong>21</strong>����<strong>40</strong>��</div>
			</div>
		</div>
		</form>
	</div>
</div>

</body>
</html>