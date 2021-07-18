package servlet2_Dispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/","/disp"})
public class MyController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	//http://localhost:8082/servlet2_Dispatcher/?command=hello
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터 값을 가져옴.
		String command = req.getParameter("command");
		Object resultObj;
		//command를 처리
		if( command == null) {
			resultObj ="command가 null입니다";
		}else if(command.equals("hello")) {
			resultObj="command가 hello입니다";
		}else {
			resultObj = "command가 그 외입니다.";
		}
		
		//jsp에 넘길 데이터를 설정합니다.
		//request 객체나 session객체에 데이터 저장
		req.setAttribute("result", resultObj);
		
		//.jsp로 응답한다.  디스패치 -forward이다 - request,response객체가 살아서 간다.
		RequestDispatcher dp = req.getRequestDispatcher("/view.jsp");
		dp.forward(req, resp);
		
		
	}

}
