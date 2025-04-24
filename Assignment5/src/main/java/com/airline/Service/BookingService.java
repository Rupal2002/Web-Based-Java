package com.airline.Service;

import com.airline.Dao.BookingDao;

public class BookingService 
{
    private BookingDao bookingDao;
	public BookingService() 
	{
		bookingDao = new BookingDao();
	}
    public boolean bookFlight(int userId, int flightId)
    {
    	return bookingDao.save(userId, flightId);
    }
}
