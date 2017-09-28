package work.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import work.model.dto.EmployeeDto;
import work.service.EmployeeService;


public class EmployeeController extends HttpServlet {
	private EmployeeService service = new EmployeeService();       
	 protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println(">>>>>  ��й�ȣ ��ȸ ��û���� �޼��� ����");
			String e_pw= request.getParameter("e_pw");
			HttpSession session = request.getSession(false);
			String e_id = (String) session.getAttribute("e_id");
			System.out.println("���̵� : "+e_id);
			System.out.println("��й�ȣ :"+e_pw);
			
			boolean result = service.checkPw(e_id,e_pw );
			boolean result2 = service.delete(e_id);
			
			if(result) {
				if(result2) {
					request.setAttribute("Message", "���������� ������ �����Ǿ����ϴ� ");
					request.getRequestDispatcher("Service2.jsp").forward(request,response);
				}
			}
			else {
				request.setAttribute("errorMessage", "��й�ȣ ���� ");
				request.getRequestDispatcher("/Error2.jsp").forward(request,response);
			}
	 }
		 
	 protected void idCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println(">>>>> ����ߺ���ȸ ��û���� �޼��� ����");
			String e_id= request.getParameter("checkId");
			System.out.println("���̵� : "+e_id);
			
			boolean result = service.checkId(e_id) ;
			 System.out.println("result :" +result);
			 
			if(result) {
				request.setAttribute("result", true);
				request.getRequestDispatcher("/idCheck.jsp").forward(request,response);
			}
			else {
				request.setAttribute("result", false);
				request.getRequestDispatcher("/idCheck.jsp").forward(request,response);
			}
			
	 }
	 protected void resetPw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> ��й�ȣ ���� ��û���� �޼��� ����");
		String e_pw= request.getParameter("e_pw");
		HttpSession session = request.getSession(false);
		String e_id = (String) session.getAttribute("e_id");
		System.out.println("���̵� : "+e_id);
		System.out.println("��й�ȣ :"+e_pw);
		
		int result = service.resetPw(e_id,e_pw) ;
		 
		if(result != 0) {
			request.setAttribute("successMessage", "���������� ����Ǿ����ϴ�.");
			request.getRequestDispatcher("/Service.jsp").forward(request,response);
		}
		else {
			request.setAttribute("errorMessage", "��й�ȣ ������� ");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
		}
	 }
	 
	 protected void checkPw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> ��й�ȣ Ȯ�� ��û���� �޼��� ����");
		String e_pw= request.getParameter("e_pw");
		HttpSession session = request.getSession(false);
		String e_id = (String) session.getAttribute("e_id");
		System.out.println("���̵� : "+e_id);
		System.out.println("��й�ȣ :"+e_pw);
		
		boolean result = service.checkPw(e_id,e_pw );
		if(result != false) {
			response.sendRedirect("ResetPw.jsp");  
		}
		else {
			request.setAttribute("errorMessage", "��й�ȣ ���� ");
			request.getRequestDispatcher("/Error2.jsp").forward(request,response);
		}
		 
	 }
	 protected void resetInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println(">>>>> ������ ���� ��û���� �޼��� ����");
		 HttpSession session = request.getSession(false);
		 String e_id = (String) session.getAttribute("e_id");
		 String e_mobile= request.getParameter("e_mobile");
		 String e_email= request.getParameter("e_email");
		 String e_address= request.getParameter("e_address");
		 
		 int result1 = service.resetInfo(e_id,e_mobile,e_email,e_address);
		 EmployeeDto result = service.myInfo(e_id);
		 if(result1 != 0) {
			if(result != null) {
				request.setAttribute("dto",result);
				request.getRequestDispatcher("/MyPage.jsp").forward(request,response);
			}
		 }
			else {
				request.setAttribute("errorMessage", "������ ���� ���� ");
				request.getRequestDispatcher("/Error2.jsp").forward(request,response);
			}
		 
		 
	 }
	 protected void showInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println(">>>>> ������ ���� ��û���� �޼��� ����");
			
			HttpSession session = request.getSession(false);
			String e_id = (String) session.getAttribute("e_id");
			
			EmployeeDto result = service.myInfo(e_id);
			if(result != null) {
				request.setAttribute("dto",result);
				request.getRequestDispatcher("/MyPage.jsp").forward(request,response);
			}
			else {
				request.setAttribute("errorMessage", "������ ���� ���� ");
				request.getRequestDispatcher("/Error2.jsp").forward(request,response);
			}
	 }
	 
	 
    protected void findPw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> ��й�ȣ ã�� ��û���� �޼��� ����");
		String e_id = request.getParameter("e_id");
		String e_kname = request.getParameter("e_kname");
		String e_birthyear= request.getParameter("e_birthyear");
		String e_birthmonth= request.getParameter("e_birthmonth");
		String e_birthdate= request.getParameter("e_birthdate");
		String e_birth = e_birthyear + "-" + e_birthmonth + "-" + e_birthdate;
		String e_email1 = request.getParameter("e_email1");
		String e_email2 = request.getParameter("e_email2");
		String e_email = e_email1 + "@" + e_email2;
		
		if(e_id==null || e_id.trim().length()==0) {
			System.out.println("���� :���̵� ���Է�");
			request.setAttribute("errorMessage", "���̵� ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
		}
		if(e_kname==null || e_kname.trim().length()==0) {
			System.out.println("���� :�̸� ���Է�");
			request.setAttribute("errorMessage", "�̸� ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
		}
		if(e_birthyear==null || e_birthyear.trim().length()==0||e_birthmonth==null || e_birthmonth.trim().length()==0||e_birthdate==null || e_birthdate.trim().length()==0) {
			System.out.println("���� : ������� ���Է�");
			request.setAttribute("errorMessage", "������� ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
			
		}
		if(e_email1==null || e_email1.trim().length()==0||e_email2==null || e_email2.trim().length()==0) {
			System.out.println("���� :�̸����ּ� ���Է�");
			request.setAttribute("errorMessage", "�̸����ּ� ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
		}
		
		String result = service.findPw(e_id, e_kname, e_birth, e_email);
		
		if(result != null) {
			request.setAttribute("successMessage", "�ӽ� ��й�ȣ��  " + result + " �Դϴ�.");
			request.getRequestDispatcher("/Service.jsp").forward(request,response);
			
		}
		else {
			request.setAttribute("errorMessage", "��ġ�ϴ� ������ �����ϴ� ");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
		}
	}
		
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> �α׾ƿ� ��û���� �޼��� ����");
		
		HttpSession session = request.getSession(false);
		session.removeAttribute("e_id");
		session.invalidate();
		response.sendRedirect("Index.jsp");  
	}
    
    protected void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> ȸ������ ��û���� �޼��� ����");
		
		String e_id = request.getParameter("e_id");
		String e_kname = request.getParameter("e_kname");
		String e_efname = request.getParameter("e_efname");
		String e_elname = request.getParameter("e_elname");
		
		String e_pw = request.getParameter("e_pw");
		String e_birthyear= request.getParameter("e_birthyear");
		String e_birthmonth= request.getParameter("e_birthmonth");
		String e_birthdate= request.getParameter("e_birthdate");
		String e_birth = e_birthyear + "-" + e_birthmonth + "-" + e_birthdate;
		
		String e_sex = request.getParameter("e_sex");
		String e_email1 = request.getParameter("e_email1");
		String e_email2 = request.getParameter("e_email2");
		String e_email = e_email1 + "@" + e_email2;
		
		String e_mobile1 = request.getParameter("e_mobile1");
		String e_mobile2 = request.getParameter("e_mobile2");
		String e_mobile3= request.getParameter("e_mobile3");
		String e_mobile = e_mobile1 + "-" + e_mobile2 + "-" + e_mobile3;
		
		String e_address= request.getParameter("e_address");
		String e_state= request.getParameter("e_state");
		
		if(e_id==null || e_id.trim().length()==0) {
			System.out.println("���� :���̵� ���Է�");
			request.setAttribute("errorMessage", "���̵� ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
		}
		if(e_kname==null || e_kname.trim().length()==0) {
			System.out.println("���� :�̸� ���Է�");
			request.setAttribute("errorMessage", "�̸� ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
		}
		if(e_efname==null || e_efname.trim().length()==0||e_elname==null || e_elname.trim().length()==0) {
			System.out.println("���� :�����̸� ���Է�");
			request.setAttribute("errorMessage", "�����̸� ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
			
		}
		if(e_pw==null || e_pw.trim().length()==0) {
			System.out.println("���� :��й�ȣ ���Է�");
			request.setAttribute("errorMessage", "��й�ȣ ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
		}
		if(e_birthyear==null || e_birthyear.trim().length()==0||e_birthmonth==null || e_birthmonth.trim().length()==0||e_birthdate==null || e_birthdate.trim().length()==0) {
			System.out.println("���� : ������� ���Է�");
			request.setAttribute("errorMessage", "������� ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
		}
		if(e_sex==null || e_sex.trim().length()==0) {
			System.out.println("���� :���� ���Է�");
			request.setAttribute("errorMessage", "���� ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
		}
		if(e_email1==null || e_email1.trim().length()==0||e_email2==null || e_email2.trim().length()==0) {
			System.out.println("���� :�̸����ּ� ���Է�");
			request.setAttribute("errorMessage", "�̸����ּ� ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
		}
		if(e_mobile1==null || e_mobile1.trim().length()==0||e_mobile2==null || e_mobile2.trim().length()==0||e_mobile3==null || e_mobile3.trim().length()==0) {
			System.out.println("���� :����ó ���Է�");
			request.setAttribute("errorMessage", "����ó ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
		}
		
		int result = service.join(e_id,e_pw,e_kname,e_efname,e_elname,e_sex,e_birth,e_mobile,e_email,e_address,e_state);
		
		if(result !=0) {
			request.setAttribute("successMessage", "���������� ȸ�������� �Ǿ����ϴ�.");
			request.getRequestDispatcher("/Service.jsp").forward(request,response);
		}
		else {
			request.setAttribute("errorMessage", "ȸ������ ���� ");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
		}
		
	}
    protected void adminLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> �α��ο�û���� �޼��� ����");
		String a_id = request.getParameter("a_id");
		String a_pw = request.getParameter("a_pw");
		System.out.println("���̵� : "+a_id);
		System.out.println("��й�ȣ :"+a_pw);
		
		if(a_id==null || a_id.trim().length()==0) {
			System.out.println("���� :���̵� ���Է�");
			request.setAttribute("errorMessage", "���̵� ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
		}
		
		if(a_pw==null||a_pw.trim().length()==0) {
			System.out.println("���� :��й�ȣ ���Է�");
			response.sendRedirect("Index.jsp");  
			return;
		}
		
		if(a_id=="admin01"&&a_pw=="admin01") {
			request.setAttribute("successMessage", "�α��μ���");
			HttpSession session = request.getSession(true);
			session.setAttribute("a_id", a_id);
			request.getRequestDispatcher("/Menu2.jsp").forward(request,response);
		} else {
			request.setAttribute("errorMessage", "�α��ν��� ");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
		}
	}

    protected void eLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>> ���� �α��ο�û���� �޼��� ����");
		String e_id = request.getParameter("e_id");
		String e_pw = request.getParameter("e_pw");
	
		
		System.out.println("���̵� : "+e_id);
		System.out.println("��й�ȣ :"+e_pw);
		
		if(e_id==null || e_id.trim().length()==0) {
			System.out.println("���� :���̵� ���Է�");
			request.setAttribute("errorMessage", "���̵� ���Է�");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
			return;
		}
		
		if(e_pw==null||e_pw.trim().length()==0) {
			System.out.println("���� :��й�ȣ ���Է�");
			response.sendRedirect("Error.jsp");  
			return;
		}
		
		String e_kname = service.login(e_id,e_pw);
		System.out.println("login ������̸� : " + e_kname);
		
		if(e_kname != null) {
			request.setAttribute("successMessage", "�α��μ���");
			HttpSession session = request.getSession(true);
			session.setAttribute("e_id", e_id);
			session.setAttribute("e_kname", e_kname);
			
			request.getRequestDispatcher("/Menu1.jsp").forward(request,response);
		} else {
			request.setAttribute("errorMessage", "�α��ν��� ");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
		}
		
	}
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(">>>action : "+action);
		switch(action) {
		case "e_login" :
			eLogin(request,response);
			break;
		case "a_login" :
			adminLogin(request,response);
			break;
		case "join" :
			join(request,response);
			break;
		case "logout" :
			logout(request,response);
			break;
		case "findPw" :
			findPw(request,response);
			break;
		case "myPage" :
			showInfo(request,response);
			break;
		case "resetInfo" :
			resetInfo(request,response);
			break;
		case "checkPw" :
			checkPw(request,response);
			break;
		case "resetPw" :
			resetPw(request,response);
			break;
		case "idCheck":
			idCheck(request,response);
			break;
		case "delete":
			delete(request,response);
			break;
		default :
			System.out.println("������ �����Դϴ�");
				
		}
		
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		process(request, response);
	}

}
