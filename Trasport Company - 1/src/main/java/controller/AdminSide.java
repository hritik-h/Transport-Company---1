package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class AdminSide extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		 response.getWriter().append("Served at: ").append(request.getContextPath());
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/AdminSidebar.jsp");
		 dispatcher.forward(request, response);
	 }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println(request.getAttributeNames());
		System.out.println(request.getParameter("vehicle-description"));		
	}
}

