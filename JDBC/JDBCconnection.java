package Jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class JDBCconnection {
private static final String URL="jdbc:mysql://localhost:3306/my_database";
private static final String USER="root";
private static final String Password="Root";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection(URL,USER,Password);
	System.out.println("Connected to the database successfully");
	con.close();
	}
catch (SQLException e)
	{
	System.out.println("Failed to connect to the database.");
	e.printStackTrace();
	
	}catch(ClassNotFoundException e) {
System.out.println("Failed to connect to the database.");
e.printStackTrace();
	}

}
	}

		



