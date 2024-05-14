package com.app.dao;

import static dbutils.dbutils.openConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidatesDaoImpl {
	private Connection cn;
	private static PreparedStatement pst1,pst2,pst3;
	
	
	public CandidatesDaoImpl() throws SQLException {
		cn = openConn();
		
		pst1 = cn.prepareStatement("select * from candidates order by votes desc");
		pst2 = cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		pst3 =cn.prepareStatement("select party,sum(votes) from candidates group by party");
	}
	
	public void getCandidates() throws SQLException {
		ResultSet rst = pst1.executeQuery();
		
		while(rst.next()) {
			System.out.println(rst.getInt(1)+" "+rst.getString(2)+" "+rst.getString(3)+" "+rst.getInt(4));
		}
		
	}
	
	public void getVotesByParty() throws SQLException {
		ResultSet rst = pst3.executeQuery();
		
		while(rst.next()) {
			System.out.println(rst.getString(1)+" "+rst.getString(2));
		}
	}

	public void updateVotes(int voterid) throws SQLException {
		pst2.setInt(1, voterid);
		pst2.executeUpdate();
	}
	
}
