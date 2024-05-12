package dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbutils {
	
	private static Connection connection;
	private static final String DBURL; 
	private static final String USERNAME;
	private static final String PASSWORD;
	
	static {
		DBURL = "jdbc:mysql://localhost:3306/iacsd_mar2024";
		USERNAME = "root";
		PASSWORD = "piyush12";
	}
	
	public static Connection openConn() throws SQLException {
		
		connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void closeconn() throws SQLException {
		if(connection!=null)
			connection.close();
		System.out.println("closed");
	}
	

}
