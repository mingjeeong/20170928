<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table width="1340" height="650" border="1">
  <tr>
  <td rowspan="3" width="10%" ></td>
   <td colspan="4" width="80%" height="15%">
   		<div style="text-align:right; width=300px; padding-right=10px"  >
   		<a href="#">�ǳӿ���</a>
   		<%= session.getAttribute("e_kname") +"�� ȯ���մϴ�." %>
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
   <td width="80%" height="70%">
   		<table align="center" >
			<tr>
				<td><a href="Issue.jsp"><img src="images/e_issue.jpg" width="100" height="50"></a></td>
				<td>&nbsp;</td>
				<td><a href="SearchTicket.jsp"><img src="images/e_check.jpg" width="100" height="50"></a></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><a href="CancelTicket.jsp"><img src="images/e_cancel.jpg" width="100" height="50"></a></td>
				<td>&nbsp;</td>
				<td><a href="bookTicket.jsp"><img src="images/e_book.jpg" width="100" height="50"></a></td>
			</tr>
		</table>
   </td>
  </tr>
  <tr>
   <td colspan="4" width="100%" height="15%">
   </td>
  </tr>
 </table>
</body>
</html>