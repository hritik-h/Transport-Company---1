package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Booking;
import model.User;
import service.BookingService;
import service.UserService;

@WebServlet("/BookingHandler")
public class BookingHandler extends HttpServlet {
	Booking bookObject = new Booking();
	BookingService bookingService = new BookingService();
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
		System.out.println("Inside BookingHadler Post");
		System.out.println(request.getParameter("booking-id"));
		System.out.println(request.getParameter("action"));
		
		if(request.getParameter("action").equals("book")) {
			bookObject.setUser_id(Integer.parseInt(request.getParameter("user-id")));
			bookObject.setDestination(request.getParameter("destination"));
			bookObject.setDate(Date.valueOf(request.getParameter("date")));
			bookObject.setSource(request.getParameter("source"));
			bookObject.setVehicle_id(request.getParameter("vehicle-id"));
			bookObject.setDriverId(Integer.parseInt(request.getParameter("driver-id")));
			bookingService.book(bookObject);
		}
		else if(request.getParameter("action").equals("cancel")) {
			System.out.println("inside delete: "+request.getParameter("booking-id"));
			System.out.println(bookingService.cancel(Integer.parseInt(request.getParameter("booking-id"))));
		}
		else {
			System.out.println("Else of bookingHandler");
		}
		doGet(request,response);
	}
}

