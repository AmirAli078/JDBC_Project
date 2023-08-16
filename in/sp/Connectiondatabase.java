package in.sp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Connectiondatabase{
	/*
      static Connection connection =null;
      static String databaseName="";
      static String url="jdbc:mysql://localhost:3306/"+databaseName;
      static String username="root1";
      static String password="admin123";
      */
	public static void main(String[] args) throws Exception 
	{ 
		//load driver 
		Class.forName("com.mysql.cj.jdbc.Driver");
		//set connection 
	 Connection con=DriverManager.getConnection("jdbc:mysql://LocalHost:3306/students", "root","123456");
	 System.out.println("connection is created");
		//Add data into database 
	 PreparedStatement ps= con.prepareStatement("insert into student values(15,'Saqib',22)");
	 int i=ps.executeUpdate();
	 if(i>0){
		 System.out.println("Data is added successfully");
	 }
	 else 
	 {
		System.out.println("data is not added");
	 }
	}
}
