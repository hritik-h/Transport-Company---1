package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chat")
public class HelloWorld extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		 response.getWriter().append("Served at: ").append(request.getContextPath());
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/AddVehicle.jsp");
		 dispatcher.forward(request, response);
	 }
}

