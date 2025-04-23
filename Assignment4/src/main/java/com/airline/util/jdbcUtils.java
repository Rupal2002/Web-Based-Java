package com.airline.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcUtils
{
  private static Connection con;
  
  public static Connection getDbConnection()throws ClassNotFoundException , SQLException
  {
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_reservation_syatem","root","password");
	  return con;
  }
}
