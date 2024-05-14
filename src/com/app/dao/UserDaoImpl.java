package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.entities.User;

import static dbutils.dbutils.*;

public class UserDaoImpl implements userDao {
	
	private Connection cn;
	private static PreparedStatement pst1,pst2,pst3,pst4,pst5,pst6;
	
	public UserDaoImpl() throws SQLException {
		cn = openConn();
		
		pst1 = cn.prepareStatement("select * from users");
		pst2 = cn.prepareStatement("insert into users values (default,?,?,?,?,?,?,?)");
		pst3 = cn.prepareStatement("delete from users where id=?");
		pst4 = cn.prepareStatement("update users set password=? where email=? and password=?");
		pst5 = cn.prepareStatement("select * from users where email=? and password=?");
		pst6 = cn.prepareStatement("update users set status=true where email=?");
	}
		
	public void dispAll() throws SQLException {
		ResultSet rst = pst1.executeQuery();
		
		while (rst.next()) {
			// id | first_name | last_name | email | password | dob | status | role
			System.out.println(rst.getInt(1) + " " + rst.getString(2) + " " + rst.getString(3) + " "
					+ rst.getString(4) + " " + rst.getString(5) + " " + rst.getDate(6) + " " + rst.getBoolean(7)
					+ " " + rst.getString(8));
		}

	}

	public String insert(User user) throws SQLException {
		// TODO Auto-generated method stub
		pst2.setString(1, user.getFn());
		pst2.setString(2, user.getLn());
		pst2.setString(3, user.getEmail());
		pst2.setString(4, user.getPass());
		pst2.setDate(5, user.getDob());
		pst2.setBoolean(6, user.isStatus());
		pst2.setString(7, user.getRole());
		
		if(pst2.executeUpdate()==1) {
			return "user inserted";
		}
		
		return "err";
	}
	
	public User userSign(String email, String pass) throws SQLException {
		pst5.setString(1, email);
		pst5.setString(2, pass);
		
		try(ResultSet rst = pst5.executeQuery()){
		if(rst != null) {
			rst.next();
			return new User(rst.getString(2),rst.getString(3),rst.getString(4), rst.getString(5), rst.getDate(6), rst.getString(7));
		}
		else
		throw new SQLException("invalid cred");
		}
	}

	public String deleteuser(int voterId) throws SQLException {
		pst3.setInt(1, voterId);
		
		if(pst3.executeUpdate()==1) {
			return "user deleted";
		}
		return "Invalid id";
	}

	public void changePass(String email, String pass, String newpass) throws SQLException {
		// TODO Auto-generated method stub
		pst4.setString(1, newpass);
		pst4.setString(2, email);
		pst4.setString(3, pass);
		
		if(pst4.executeUpdate()==1) {
			System.out.println("pass change");
		}
		else {
			System.out.println("err");
		}
	}
	
	public void changeStatus(String email) throws SQLException {
		pst6.setString(1, email);
		
		pst6.executeUpdate();
	}
	
	
	
	
	
	
		
}
