package com.airline.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.airline.entity.Booking;
import com.airline.util.jdbcUtils;

public class BookingDao {
	private String query;

	public boolean save(int userId, int flightId) {
		boolean status = false;
		query = "insert into booking(user_id, flight_id) values(?,?)";
		try (Connection con = jdbcUtils.getDbConnection();
				PreparedStatement pstm = con.prepareStatement(query);) {
			pstm.setInt(1, userId);
			pstm.setInt(2, flightId);
			int count = pstm.executeUpdate();
			if (count > 0) {
				System.out.println(count + "Row Inserted");
				status = true;
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return status;
	}

	public List<Booking> getAll() 
	{
		List<Booking> bookings = new ArrayList<>();
		String query = "select * from booking";
		try (Connection con = jdbcUtils.getDbConnection(); 
			Statement stm = con.createStatement();) {
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("id");
				int userId = rs.getInt("user_id");
				int flightId = rs.getInt("flight_id");
				LocalDate Date = rs.getDate("booking_date").toLocalDate();
				Booking booking = new Booking(id, userId, flightId, Date);
				bookings.add(booking);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bookings;
	}
	public boolean cancel(int id)
	{
		boolean status = false;
		String query = "delete from booking where id = ?";
		try (Connection con = jdbcUtils.getDbConnection(); 
				PreparedStatement pstm = con.prepareStatement(query)) 
		{
		   pstm.setInt(1, id);
		 int count = pstm.executeUpdate();
		 if(count > 0)
		 {
			 status = true;
			 
		 }
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		
		return status;
		
	}
}
