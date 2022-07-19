package com.uniquedeveloper.registration;

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

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail = request.getParameter("username");
		String upassword = request.getParameter("password");
		HttpSession session=request.getSession();
		RequestDispatcher dispatcher=null;
		
		if(uemail==null || uemail.equals("")) {
			request.setAttribute("status","invalidEmail");
			dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		if(upassword==null || upassword.equals("")) {
			request.setAttribute("status","invalidPassword");
			dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?autoReconnect=true&useSSL=false", "root","root");
			PreparedStatement pst=con.prepareStatement("select * from users where uemail = ? and upassword = ?");
			pst.setString(1, uemail);
			pst.setString(2, upassword);
			
			ResultSet rs=pst.executeQuery();
			
			
			
			if (rs.next()) {
				session.setAttribute("name",rs.getString("uname"));
				dispatcher=request.getRequestDispatcher("index.jsp");
				
			}else {
				request.setAttribute("status","failed");
				dispatcher=request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
	}


