package exampleCustomer.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import JDBCPractice.Customer;

/**
 * Servlet implementation class showCustomer
 */
@WebServlet("/showCust")
public class showCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Object obj = request.getAttribute("loadedDept");
		Customer cust = (Customer)obj;
		String name = cust.getCname();
		String location = cust.getAddress();
		out.println("<h2>Showing Cust Details: </h2>");
		out.println("<h2>Name: " + name + "</h2>");
		out.println("<h2>Location: "+ location + "</h2>");
	}


	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
