package JDBCPractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
public class CustomerDao implements jdbcDao<Customer , Integer>
{

	@Override
	public Collection<Customer> getAll() 
	{
		Collection<Customer> allCustomer = new ArrayList<>();
		try(
			Connection dbConnection = Utils.buildConnection();
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from cust_Table");
			)
		{
			while(rs.next())
			{
				int custId = rs.getInt(1);
				String cName = rs.getString(2);
				String address = rs.getString(3);
				
				Customer cust = new Customer(custId, cName, address);
				allCustomer.add(cust);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return allCustomer;
	}

	@Override
	public Customer getOne(Integer custId)
	{
		Customer foundCustomer = null;
		String SqlQuery = "Select * from cust_Table where custid = ?";
		try(
			Connection dbConnection = Utils.buildConnection();
			PreparedStatement pstmt = dbConnection.prepareStatement(SqlQuery);
			)
		{
			pstmt.setInt(1, custId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				int custid = rs.getInt(1);
				String cName = rs.getString(2);
				String address = rs.getString(3);
				foundCustomer = new Customer(custid, cName, address);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return foundCustomer;
	}

	@Override
	public void add(Customer cust) 
	{
		String SqlQuery = "insert into cust_Table values(?,?,?,?,?,?,?)";
		try(
			Connection dbConnection = Utils.buildConnection();
			PreparedStatement pstmt = dbConnection.prepareStatement(SqlQuery);
			)
		{
			int custId = cust.getCustId();
			String name = cust.getCname();
			String address = cust.getAddress();
			
			pstmt.setInt(1,custId);
			pstmt.setString(2,name);
			pstmt.setString(3,address);
			pstmt.setString(4,null);
			pstmt.setString(5,null);
			pstmt.setString(6,null);
			pstmt.setString(7,null);
			
			
			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount + " record inserted ");
					
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
	}

	@Override
	public void update(Customer t) 
	{
		
	}

	@Override
	public void delete(Integer keys)
	{
		
		
	}
  
}
