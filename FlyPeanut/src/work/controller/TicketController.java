package work.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import work.model.dto.ReservationDto;
import work.service.EmployeeService;
import work.service.TicketService;

/**
 * Servlet implementation class TicketController
 */
public class TicketController extends HttpServlet {
	private TicketService service = new TicketService();
    protected void searchforCancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println(">>>>> 취소를 위한 승객 조회 요청 서비스 메서드 수행");
    	String r_name = request.getParameter("r_name");
		String r_num = request.getParameter("r_num");
		System.out.println("승객명 : "+r_name);
		System.out.println("예약번호 :"+r_num);
		
		
    
    }
    protected void issueTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println(">>>>> 티켓 발급 요청 서비스 메서드 수행");
    
    }
    protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println(">>>>> 승객 조회 요청 서비스 메서드 수행");
    	
		String r_name = request.getParameter("r_name");
		String r_num = request.getParameter("r_num");
		System.out.println("승객명 : "+r_name);
		System.out.println("예약번호 :"+r_num);
		
		ReservationDto dto = service.search(r_name,r_num);
		
		if(dto !=null) {
			request.setAttribute("dto", "dto");
			request.getRequestDispatcher("/SearchTicket2.jsp").forward(request,response);
		}
		else {
			request.setAttribute("errorMessage", "일치하는 정보가 없습니다.");
			request.getRequestDispatcher("/Error2.jsp").forward(request,response);
		}
    	
    }
    protected void nextIssue(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println(">>>>> 승객 조회 후 수하물 추가 서비스 메서드 수행");
    	String r_name = request.getParameter("r_name");
    	String t_bagnum = request.getParameter("t_bagnum");
    	String bagg = service.setBagg(r_name,t_bagnum);
    	
    }
	
    protected void searchIssue(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println(">>>>> 발행전 승객 조회 서비스 메서드 수행");
		String r_name = request.getParameter("r_name");
		String r_num = request.getParameter("r_num");
		System.out.println("승객명 : "+r_name);
		System.out.println("예약번호 :"+r_num);
		
		String rname = service.searchIssue(r_name,r_num);
		
		if(rname !=null) {
			request.setAttribute("rname", "rname");
			request.getRequestDispatcher("/Issue2.jsp").forward(request,response);
		}
		else {
			request.setAttribute("errorMessage", "일치하는 정보가 없습니다.");
			request.getRequestDispatcher("/Error2.jsp").forward(request,response);
		}
    }
       
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(">>>action : "+action);
		switch(action) {
		case "searchissue" :
			searchIssue(request,response);
			break;
		case "nextIssue" :
			nextIssue(request,response);
			break;
		case "search" :
			search(request,response);
			break;
		case "issue" :
			issueTicket(request,response);
			break;
		case "searchcancel" :
			searchforCancel(request,response);
			break;

		default :
			System.out.println("미지원 서비스입니다");
				
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
