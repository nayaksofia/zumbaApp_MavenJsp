package com.sofi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sofi.bean.ParticipantBatch;
import com.sofi.db.DB;

//Manages the relationship between participants and batches:many-to-many relationship

public class ParticipantBatchDAO {
	
	Connection con;
	

	public ParticipantBatchDAO() {
		con = DB.getDB().con;
	}



	//Insert 
	public int addParticipantToBatch(ParticipantBatch pb) throws ClassNotFoundException, SQLException {
	    
		String sql = "insert into ParticipantBatch(pid, bid) values (?, ?)";

	    try (PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setInt(1, pb.getPid());
	        ps.setInt(2, pb.getBid());

	        return ps.executeUpdate();
	    }
	}

	
	//Retrieve All 
	
	
	//Retrieve By Id
	
	
	//Update by Id
	
	
	//Delete
	

}
