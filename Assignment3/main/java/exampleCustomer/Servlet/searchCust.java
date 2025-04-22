package exampleCustomer.Servlet;

import jakarta.servlet.RequestDispatcher;
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
 * Servlet implementation class searchCust
 */
@WebServlet("/searchCust")
public class searchCust extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int cust_No = Integer.parseInt(request.getParameter("custNo"));
		
		jdbcDao<Customer, Integer> dao = new CustomerDao();
		Customer foundDepartment = dao.getOne(cust_No);
		RequestDispatcher dispatcher = null;
		if(foundDepartment == null) {
			out.println("<h2> Department Not Found due to invalid ID. Please try again.</h2>");
			dispatcher = request.getRequestDispatcher("searchDept.html");
			dispatcher.include(request, response);
		}else {
			dispatcher = request.getRequestDispatcher("showCust");
			request.setAttribute("loadedCust", foundDepartment);
			dispatcher.forward(request, response);
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
