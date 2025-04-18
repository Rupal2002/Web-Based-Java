package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcUtils 
{
   private static Connection con;
   public static Connection getDbConnection() throws SQLException
   {
	   con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/cdac","root","password");
	   return con;
   }
}
