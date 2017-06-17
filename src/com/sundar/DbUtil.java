package com.sundar;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	public static final String url = "jdbc:mysql://localhost:3306/student";
	public static final String user = "root";
	public static final String pass = "";
	public static Connection getConnection()throws Exception 
	{
		Connection c;
		Class.forName("com.mysql.jdbc.Driver");
		c= DriverManager.getConnection(url, user, pass);
		return c;
	}
	
}
