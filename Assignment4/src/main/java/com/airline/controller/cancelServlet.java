package com.airline.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.airline.Dao.BookingDao;


@WebServlet("/cancelBooking")
public class cancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id  = Integer.parseInt(request.getParameter("bookingId"));
		boolean status = new BookingDao().cancel(id);
		
		if(status)
		{
			out.println("<h1>Booking cancle sucessfully</h1>");
			request.getRequestDispatcher("showBooking.jsp").include(request, response);
		}
		else
		{
			out.println("<h1>Booking not cancle sucessfully</h1>");
			request.getRequestDispatcher("showBooking.jsp").include(request, response);
		}
	}

}
