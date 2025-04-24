<%@page import="com.airline.entity.Flight"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgColor="pink",
align="center">
       <h1>Available Flights</h1>
       <%
          List<Flight> flights =  (List<Flight>) request.getAttribute("flights");
       for(Flight f: flights)
     {
       %>
          <p>
              Flight Number: <%=f.getFlightNumber()%> | <%=f.getSource()%> to  <%=f.getDestination()%> <br> 
              Schedule Date:  <%=f.getFlightDate()%> | Price:  <%=f.getPrice()%> <br>
            
              <Form action="bookFlight" method="post">
                 <input type="hidden" name="flightId" value=<%=f.getId()%>>
                 <input type="Submit" value="Book">
              </Form>
              <hr/>
          </p> 
       <%
     }
       %>
</body>
</html>