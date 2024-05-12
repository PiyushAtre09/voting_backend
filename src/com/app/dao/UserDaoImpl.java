package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static dbutils.dbutils.*;

public class UserDaoImpl implements userDao {
	
	private Connection cn;
	private static PreparedStatement pst1;
	
	public UserDaoImpl() throws SQLException {
		cn = openConn();
		
		pst1 = cn.prepareStatement("select * from users");
	}
		
	public static void dispAll() throws SQLException {
		ResultSet rst = pst1.executeQuery();
		
		while (rst.next()) {
			// id | first_name | last_name | email | password | dob | status | role
			System.out.println(rst.getInt(1) + " " + rst.getString(2) + " " + rst.getString(3) + " "
					+ rst.getString(4) + " " + rst.getString(5) + " " + rst.getDate(6) + " " + rst.getBoolean(7)
					+ " " + rst.getString(8));
		}
	}
		
}
