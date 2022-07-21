package service;

import dao.Booking;

public interface BookingCrud {
	Boolean book(Booking bookingDao);
	Boolean cancel(int idBooking);
}
