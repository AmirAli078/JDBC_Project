package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	public static Connection getConnection(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 return DriverManager.getConnection("jdbc:mysql://LocalHost:3306/students", "root","123456");
			 
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	}
