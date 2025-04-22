package exampleCustomer.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import JDBCPractice.Customer;
import JDBCPractice.jdbcDao;
import JDBCPractice.CustomerDao;

/**
 * Servlet implementation class addCust
 */
@WebServlet("/addCust")
public class addCust extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		int cust_No = Integer.parseInt(request.getParameter("custNo"));
		String name = request.getParameter("custName");
		String loc = request.getParameter("custLocation");
		
		Customer currentCust = new Customer(cust_No,name,loc);
		jdbcDao<Customer, Integer> dao = new CustomerDao();
		dao.add(currentCust);
		out.println("<h2>Customer added successfully.</h2>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
