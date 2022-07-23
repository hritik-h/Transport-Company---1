package dto;

import java.sql.Date;

public class BookingDto {
	int booking_id;
	int user_id;
	String vehicle_id;
	String source;
	String destination;
	int driverId;
	Date date;
	public BookingDto(int booking_id, int user_id, String vehicle_id, String source, String destination, int driverId,
			Date date) {
		super();
		this.booking_id = booking_id;
		this.user_id = user_id;
		this.vehicle_id = vehicle_id;
		this.source = source;
		this.destination = destination;
		this.driverId = driverId;
		this.date = date;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public BookingDto() {
		super();
	}
}
