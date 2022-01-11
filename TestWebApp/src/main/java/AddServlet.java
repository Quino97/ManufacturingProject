

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
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {


    	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    			throws ServletException, IOException {
    		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String velocity = request.getParameter("velocity");
		String hydration = request.getParameter("hydration");
		String diamond = request.getParameter("diamond");
		String ra1 = request.getParameter("ra1");
		String ra2 = request.getParameter("ra2");
		String ra3 = request.getParameter("ra3");
		String ra4 = request.getParameter("ra4");
		String ref = request.getParameter("ref");
		
		if(AddMethod.AddData(velocity,hydration,diamond,ra1,ra2,ra3,ra4,ref)) {
            RequestDispatcher rs = request.getRequestDispatcher("index2.html");
            out.println("Data Added Succesfully");
            rs.forward(request, response);
		}else {
			out.println("Data Not Added Succesfully");
			RequestDispatcher rs = request.getRequestDispatcher("index2.html");
	        rs.include(request, response);
		}
	
    }
    	
   }
