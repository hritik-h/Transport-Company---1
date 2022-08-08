package com.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User user = new User();
	UserService userService = new UserService();
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		user.setId(0);
		user.setFirstName(request.getParameter("first-name"));
		user.setLastName(request.getParameter("last-name"));
		user.setUname(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setContactno(Integer.parseInt(request.getParameter("contact-number")));
		RequestDispatcher dispatcher=null;
		
		if(request.getParameter("first-name")==null || request.getParameter("last-name").equals("")) {
			request.setAttribute("status","invalidName");
			dispatcher=request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		if(request.getParameter("username")==null || request.getParameter("username").equals("")) {
			request.setAttribute("status","invalidUserName");
			dispatcher=request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		if(request.getParameter("password")==null || request.getParameter("password").equals("")) {
			request.setAttribute("status","invalidPassword");
			dispatcher=request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}else if(!request.getParameter("password").equals(request.getParameter("re_pass"))){
			request.setAttribute("status","invalidConfirmPassword");
			dispatcher=request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		if(request.getParameter("contact-number")==null || request.getParameter("contact-number").equals("")) {
			request.setAttribute("status","invalidMobile");
			dispatcher=request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
			
		}else if(request.getParameter("contact-number").length()>10) {
			request.setAttribute("status","invalidMobileLength");
			dispatcher=request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		
		try {
			
			int rowCount=userService.insertRecord(user);;
			dispatcher = request.getRequestDispatcher("registration.jsp");
			if (rowCount>0) {
				request.setAttribute("status","success");
				
			}else {
				request.setAttribute("status","failed");
			}
			dispatcher.forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
