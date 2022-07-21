package controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vehicle;
import service.VehicleService;

@WebServlet("/VehicleHandler")
public class VehicleHandler extends HttpServlet {
	Vehicle vehicle = new Vehicle();
	VehicleService vehicleService = new VehicleService();
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
		System.out.println("Inside VehicleHadler Post");
		System.out.println(request.getAttributeNames());
		System.out.println(request.getParameter("action"));
		
		if(request.getParameter("action").equals("add")) {
			vehicle.setVehicle_id(request.getParameter("vehicle-id"));
			vehicle.setVehicle_customer_id(Integer.parseInt(request.getParameter("vehicle-owner")));
			vehicle.setVehicle_desription(request.getParameter("vehicle-description"));
			vehicle.setVehicle_number(Integer.parseInt(request.getParameter("vehicle-number")));
			vehicle.setVehicle_type(request.getParameter("vehicle-type"));
			vehicleService.insertRecord(vehicle);
		}
		else if(request.getParameter("action").equals("update")) {
			
		}
		else if(request.getParameter("action").equals("delete")) {
			System.out.println("inside delete: "+request.getParameter("vehicle-id"));
			System.out.println(vehicleService.deleteRecord(request.getParameter("vehicle-id")));
		}
		else {
			vehicleService.getVehicleByVehicleNumber(Integer.parseInt(request.getParameter("vehicle-id")));
		}
		doGet(request,response);
	}
}
