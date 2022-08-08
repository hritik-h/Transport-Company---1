package controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.DriverService;
import service.UserService;

@WebServlet("/DriverHandler")
public class DriverHandler extends HttpServlet {
	User user = new User();
	DriverService driverService = new DriverService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.print("Inside VehicleHadler get");
		 response.getWriter().append("Served at: ").append(request.getContextPath());
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/AdminSidebar.jsp");
		 dispatcher.forward(request, response);
	 }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()) {
            System.out.println("Value is: " + e.nextElement());
		}
		System.out.println("Inside DriverHadler Post");
		System.out.println(request.getParameter("contact-number"));
		System.out.println(request.getParameter("action"));
		
		if(request.getParameter("action").equals("add")) {
			user.setId(0);
			user.setFirstName(request.getParameter("first-name"));
			user.setLastName(request.getParameter("last-name"));
			user.setUname(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setContactno(Integer.parseInt(request.getParameter("contact-number")));
			driverService.insertRecord(user);
		}
		else if(request.getParameter("action").equals("update")) {
			user.setId(Integer.parseInt(request.getParameter("driver-id")));
			user.setFirstName(request.getParameter("first-name"));
			user.setLastName(request.getParameter("last-name"));
			user.setUname(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setContactno(Integer.parseInt(request.getParameter("contact-number")));
			driverService.updateRecord(user);
		}
		else if(request.getParameter("action").equals("delete")) {
			System.out.println("inside delete: "+request.getParameter("user-id"));
			System.out.println(driverService.deleteRecord(Integer.parseInt(request.getParameter("user-id"))));
		}
		else {
			driverService.getUserbyId(Integer.parseInt(request.getParameter("user-id")));
		}
		doGet(request,response);
	}
}