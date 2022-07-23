package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.Booking;
import dto.BookingDto;

public class BookingService implements BookingCrud {
	public Boolean book(Booking bookingDao) {
		try{
		Connection con=VehicleConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into Booking(idBooking,user_id, vehicle_id,source,destination,driver_id,journey_date) values(?,?,?,?,?,?,?)");
		ps.setInt(1, 0);
		ps.setInt(2, bookingDao.getUser_id());
		ps.setString(3, bookingDao.getVehicle_id());
		ps.setString(4,bookingDao.getSource());
		ps.setString(5, bookingDao.getDestination());
		ps.setInt(6, bookingDao.getDriverId());
		ps.setDate(7, bookingDao.getDate());
		System.out.println(bookingDao.toString());
		ps.execute();
		con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	public Boolean cancel(int idBooking) {
		try{
			Connection con=VehicleConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from Booking where idBooking =?");
			ps.setInt(1, idBooking);
			ps.execute();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return false;
	}
	
	public List<BookingDto> showAllBookins(){
		ArrayList<BookingDto> list = new ArrayList(); 
		try{
		Connection con=VehicleConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from Booking");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			list.add(new BookingDto(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getDate(7)));
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
