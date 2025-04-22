package JDBCPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils 
{
  public static Connection buildConnection() throws Exception
  {
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  String ConnectionUrl = "jdbc:mysql://localhost:3306/cdac";
	  String userName = "root";
	  String password = "password";
	  Connection dbConnection = DriverManager.getConnection(ConnectionUrl,userName,password);
	  return dbConnection;
  }
}
