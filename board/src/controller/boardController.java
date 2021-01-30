package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dto.boardDTO;

@WebServlet("*.bo")
public class boardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    List<boardDTO> list = new ArrayList<>();   
	
	
    public boardController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String path = "";
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());	// /chapter6/test에서 /chater6의길이만큼을뺌
		
		
		//첫페이지 리스트로 이동
		if(command.equals("/boardList.bo")) {
			request.setAttribute("list", list);
			path = "boardList.jsp";
		}
		
		//리스트에서 작성페이지
		else if(command.equals("/boardWriteForm.bo")) {
			
			path = "boardWriteForm.jsp";
		}
		
		//작성하고 board에 넣고 list에넣기
		else if(command.equals("/boardWrite.bo")) {
			boardDTO board = new boardDTO();
			board.setTitle(request.getParameter("title"));
			board.setWriter(request.getParameter("writer"));
			board.setDate(request.getParameter("date"));
			board.setContent(request.getParameter("content"));
			board.setNumber(list.size() + 1);
			
			list.add(board);
			
			path = "boardWriteSuccess.bo";
		}
		
		//등록 성공창
		else if(command.equals("/boardWriteSucess.bo")) {
			path = "boardWriteSucess.jsp";
		}
		
		else if(command.equals("/selectBoardDetail.bo")) {
			
			path = "selectBoardDetail.jsp";
		}
		
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);	//path의 값 즉b.jsp로 이동한다.
		dispatcher.forward(request, response);
	}
	
}
