<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function loginchk() {
		var regx = /^[a-zA-Z0-9]*$/;
		var c_id = document.form.c_id.value;
		var c_pw = document.form.c_pw.value;
		if (id.length == 0 || c_id == null) {
			alert("���̵� �Է��Ͻÿ�");
			document.form.c_id.focus();
			return;
		}
		if (!regx.test(c_id)) {
			alert("���̵�� ����, ���ڸ� �Է°����մϴ�.");
			document.form.c_id.focus();
			return false;
		}
		if (c_pw.length < 6 || c_pw == null) {
			alert("��й�ȣ�� 6�����̻��Դϴ�");
			document.form.c_pw.focus();
			return;
		}
		if (!regx.test(c_pw)) {
			alert("��й�ȣ�� ����, ���ڸ� �Է°����մϴ�.");
			document.form.c_pw.focus();
			return false;
		}
		document.form.submit();
	}
</script>
</head>
<body>
<table width="1340" height="650" border="1">
  <tr>
  <td rowspan="3" width="10%" ></td>
   <td colspan="4" width="80%" height="15%">
   		<a href="Menu1.jsp">
		<img src="images/logo.jpg" width="200" height="100"></a>
		�ǳӿ��� ���հ����� �������Դϴ�.
		<hr>
	</td>
   <td rowspan="3" width="10%" ></td>
   
  </tr>
  <tr>
   <td width="80%" height="70%">
	<table align="center">
   	<tr>
   		<td>
   			<form action="Controller" method="post" name="form">
					<table align="right" style="padding-right:20px" >
						<tr>
							<td>ȸ�� �α���</td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<td>ID : &nbsp;<input type="text" size="10" maxlength="15"
								name="c_id" id="c_id">
							</td>
							<td rowspan="2" height="10px"><input type="hidden" name="action" value="login"><input type="submit"
								id="login" name="login" value="LOGIN" onclick="loginchk()"></td>
						</tr>
						<tr>
							<td>PW : <input type="password"
								size="10" maxlength="15" name="c_pw" id="c_pw">
							</td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;</td>
						</tr>
						<tr >
							<td colspan="2" ><input type="button" id="bt_join" name="bt_join"
								value="ȸ������" onclick="location='#'"> <input type="button" id="bt_idpw"
								name="bt_idpw" value="���̵� ��й�ȣã��" onclick="location='#'">
							</td>
						</tr>
					</table>
				</form>
   		</td>
   		<td>
   			<form action="Controller" method="post" name="form2">
					<table align="left" style="padding-left:20px" >
						<tr>
							<td>��ȸ�� ���� �α���</td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<td><input type="text" size="10" maxlength="15"
								name="email1" id="email1">@<input type="text" size="10" maxlength="15"
								name="email2" id="email2">&nbsp;<input type="submit" 
								name="submit" id="submit" value="LOGIN">
								<input type="hidden" name="action" value="login">
						</tr>
						<tr>
							<td>
								<textarea name="textarea" rows="3" cols="38">1. �����ϴ� �������� �׸� �� �������
									1) �����׸� ��. �ΰ� ���� �� ����� ���� �̿� �������� �ش� ������ �̿��ڿ� ���ؼ��� �Ʒ��� ���� �������� ������ �� �ֽ��ϴ�. <��ȸ�� �װ��� ����߱�>- �ʼ��׸� : ����, ��ȭ��ȣ(�޴��� ��ȣ, ���� ��ȣ �� ����), �̸����ּ�<Ȩ������, SNS Q&A �̿� �� �̺�Ʈ ����>- �ʼ��׸� : ����, ��ȭ��ȣ(�޴��� ��ȣ, ���� ��ȣ �� ����), �̸����ּ�<��ȸ������ ���༾�� ���� ���� ���� �� �̺�Ʈ ����>- �ʼ��׸� : ����, ��ȭ��ȣ(�޴��� ��ȣ, ���ù�ȣ, �̸����ּ� �� ����)
									��. ���� ���� �̿� �������� �Ʒ��� ���� ���� �������� ������ �� �ֽ��ϴ�. <��� ����>- �ſ�ī�� ������ : ī���ȣ �� ī�� �������� ��- �ǽð� ������ü ������ : ���¹�ȣ �� �������� �ڵ� ��
									2) ���� ��� �� ���� �� �������� ������� : Ȩ������ �� SNS (ȸ������, Q&A�Խ���), �̺�Ʈ ����, ���޻�κ����� ����
									�� �������� ���� ���� ��� - �¶��� : ȸ��� ���� �������� ó����ħ �Ǵ� �̿����� ���뿡 ���� '�����ԡ� ��ư�� Ŭ���� �� �ִ� ������ �����ϰ� ������, '������' ��ư�� Ŭ���ϸ� �������� ������ ���� ������ ������ ���ϴ�. 
								</textarea>
							</td>
						</tr>
						
						<tr>
							<td><p style="font-size:small"><input type="checkbox" value="agree">��� ���������� ����, �̿� ���׿� �����մϴ�.</p>
							<p style="font-size:x-small">* ��ȸ�� ���� �� ����Ʈ ����, ��� ���� �� �̺�Ʈ ������ ��ȸ�� ��ǵ˴ϴ�.<br>
							* �װ��� ���� ������ ����������>���� ���� ��ȸ/����/���>�¶��� ���೻��><br>��ȸ�� �����������⿡�� ���� �� �ֽ��ϴ�.</p>
							</td>
						</tr>
					</table>
				</form>
   		</td>
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