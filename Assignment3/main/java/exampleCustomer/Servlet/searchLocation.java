package exampleCustomer.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import JDBCPractice.Customer;
import JDBCPractice.jdbcDao;
import JDBCPractice.CustomerDao;

/**
 * Servlet implementation class searchLocation
 */
@WebServlet("/searchLocation")
public class searchLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String location = request.getParameter("loc");
		jdbcDao<Customer, Integer> dao = new CustomerDao();
		Collection<Customer> allCustomers = dao.getAll();
		List<String> custNames = new ArrayList<>();
		for(Customer cust : allCustomers) {
			String custLoc = cust. getAddress() ;
			if(custLoc.equals(location))custNames.add(cust.getCname());
		}
		int listSize = custNames.size();
		if(listSize == 0) {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("searchLocation.html");
		    out.println("<h2>No Customer found against the entered location. Try again</h2>");
		    dispatcher.include(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("loadedCustNames", custNames);
			out.println("<h2>" + listSize + " customer(s) Found</h2>");
			out.println("<h2> To view them, <a href = 'viewDepts'>Click Here</a></h2>");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
