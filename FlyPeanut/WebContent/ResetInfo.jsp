<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="work.model.dto.EmployeeDto"%>
<%@page import="work.service.EmployeeService" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	

</script>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR"); %>
<% String e_id = (String) session.getAttribute("e_id");
	EmployeeService service = new EmployeeService();
	EmployeeDto result = service.myInfo(e_id);%>
<table width="1340" height="650" border="1">
  <tr>
  <td rowspan="3" width="10%" ></td>
   <td colspan="4" width="80%" height="15%">
   			<div style="text-align:right; width=300px; padding-right=10px"  ><%= session.getAttribute("e_kname") +"�� ȯ���մϴ�." %>
		<a href="Controller?action=myPage">����������</a>
		<a href="Controller?action=logout">�α׾ƿ�</a></div> 
   		<a href="Menu1.jsp">
		<img src="images/logo.jpg" width="200" height="100"></a>
		�ǳӿ��� ���հ����� �������Դϴ�.
		<hr>
	</td>
   <td rowspan="3" width="10%" ></td>
   </td>
  </tr>
  <tr>
   <td width="20%" height="70%">
   		<table width="250" height="200" border="1" cellpadding="10" align="center" >
   			<tr>
   				<td><h3>�� ����</h3><hr></td>
   			</tr>
   			<tr>
   			<td><a href="#">���� ����</a></td>
   			</tr>
   			<tr>
   			<td>><a href="ResetInfo.jsp">������ ����</a></td>
   			</tr>
   			<tr>
   			<td><a href="CheckPw.jsp">�����ȣ ����</a></td>
   			</tr>
   			<tr>
   			<td><a href="Delete.jsp">Ż���ϱ�</a></td>
   			</tr>
   		</table>
   </td>
   <td width="60%" height="70%">
   <form action="Controller" method="post" name="infoForm" >
   		<table border="1" align="center" width="500px" height="400px">
	<tr >
		<th>���</th>
		<td>
			<%= session.getAttribute("e_id") %>
		</td>
	</tr>
	<tr>
		<th rowspan="2">�̸�</th>
		<td>
			(�ѱ�) <%= session.getAttribute("e_kname")%>
		</td>
	</tr>
	<tr>
		<td>
			(����)<%= result.geteEfname()+result.geteElname()%>
		</td>
	</tr>
	<tr>
		<th>�������</th>
		<td>
			<%= result.geteBirth()%>
		</td>
	</tr>
	<tr>
		<th>�޴��� ��ȣ</th>	
		<td>
				<input type="text" id="e_mobile" name="e_mobile" value="<%= result.geteMobile()%>">
		</td>
	</tr>
	<tr>
		<th>�̸���</th>
		<td>
			<input type="text" id="e_email" name="e_email" value="<%= result.geteEmail()%>">
		</td>
	</tr>
	<tr>
		<th>�ּ�</th>
		<td>
			<input type="text" id="e_address" name="e_address" value="<%= result.geteAddress()%>">
		</td>
	</tr>
	</table>
	<div align="center" >
			<input type="hidden" name="action" value="resetInfo">
			<input type="submit" name="updateInfo" id="updateInfo" value="����"  >
			
	</div>
	</form>	
   </td>
  </tr>
  <tr>
   <td colspan="4" width="100%" height="15%">
   </td>
  </tr>
 </table>
</body>
</html>