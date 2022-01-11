

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {


		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(ConnectDB.checkUser(username,password)) {
            RequestDispatcher rs = request.getRequestDispatcher("index2.html");
            rs.forward(request, response);
		}else {
			out.println("username or password incorrect");
			RequestDispatcher rs = request.getRequestDispatcher("index.html");
	        rs.include(request, response);
		}
	}

}
