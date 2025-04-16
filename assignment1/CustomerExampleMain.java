package JDBCPractice;

import java.util.Collection;

public class CustomerExampleMain
{
    public static void showAllCustomers()
    {
    	jdbcDao<Customer , Integer> Dao = new CustomerDao();
    	Collection<Customer> custList = Dao.getAll();
    	custList.stream().forEach(cust -> System.out.println(cust));
    	
    }
    private static void showOneCustomer()
    {
  	
     jdbcDao<Customer, Integer> dao = new CustomerDao();
 	 Customer cust = dao.getOne(2);
 	if(cust != null)
 	{
 		System.out.println(cust);
 	}
 	else
 	{
 		System.out.println("Customer with given ID does not exist.");
 	}
    }
     
    private static void addNewCustomer()
    {
    	jdbcDao<Customer, Integer> dao = new CustomerDao();
    	Customer cust = new Customer(4, "Renuka", "New Delhi");
    	dao.add(cust);
    }
	public static void main(String[] args) 
	{
		//showAllCustomers();
		//showOneCustomer();
		addNewCustomer();

	}

}
