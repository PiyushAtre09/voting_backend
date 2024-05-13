package com.app.dao;

import static dbutils.dbutils.openConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidatesDaoImpl {
	private Connection cn;
	private static PreparedStatement pst1;
	
	public CandidatesDaoImpl() throws SQLException {
		cn = openConn();
		
		pst1 = cn.prepareStatement("select * from candidates");
	}
	
	public void getCandidates() throws SQLException {
		ResultSet rst = pst1.executeQuery();
		
		while(rst.next()) {
			System.out.println(rst.getInt(1)+" "+rst.getString(2)+" "+rst.getString(3)+" "+rst.getInt(4));
		}
		
	}
	
}
