<%@page import="com.airline.Dao.BookingDao"%>
<%@page import="com.airline.entity.Booking"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
      List<Booking> bookings = new BookingDao().getAll();
    %>
    <%
     for(Booking booking: bookings)
     {
    %>
       <h1>
         id <%=booking.getId() %>
         userId <%=booking.getUserId() %>
         flightId <%=booking.getFlightId() %>
         bookingDate <%=booking.getBookingDate() %>
       </h1>
       <form action="cancelBooking" method="post">
        <input type="hidden" name="bookingId"  value=<%=booking.getId() %>>
         <input type="submit" value="Cancel">
       </form>
       
      <%
     } 
      %>
</body>
</html>