package com.uniquedeveloper.registration;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String upass = request.getParameter("pass");
		
		if (uname.equals("admin") && upass.equals("admin")){
			
			//HttpSession session=request.getSession();
			//session.setAttribute("email",uemail);
			response.sendRedirect("welcome.jsp");
		}else {
			response.sendRedirect("adminlogin.jsp");
		}
		
	}


}
