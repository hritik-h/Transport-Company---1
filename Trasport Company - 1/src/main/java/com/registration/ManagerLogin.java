package com.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/managerlogin")
public class ManagerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mname = request.getParameter("username");
		String mpassword = request.getParameter("password");
if (mname.equals("manager") && mpassword.equals("manager")){
			
			
			response.sendRedirect("managerhome.jsp");
		}else {
			response.sendRedirect("managerlogin.jsp");
		}
		}
		}
	


