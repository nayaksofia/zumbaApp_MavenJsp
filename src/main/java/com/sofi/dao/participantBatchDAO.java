package com.sofi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.sofi.db.DB;

public class ParticipantBatchDAO {
	
	public boolean isParticipantExists(int pid) {
	    String query = "SELECT COUNT(*) FROM Participant WHERE pid = ?";
	    try (    Connection conn = DB.getDB().getConnection();
	    		PreparedStatement pst = conn.prepareStatement(query)) {
	        pst.setInt(1, pid);
	        ResultSet rs = pst.executeQuery();
	        if (rs.next() && rs.getInt(1) > 0) {
	            return true; // Participant exists
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	
	
    public boolean registerParticipantForBatch(int pid, int bid) {
    	
    	 // Check if participant exists before attempting to register
        if (!isParticipantExists(pid)) {
            System.out.println("Registration failed: Participant with ID " + pid + " does not exist.");
            return false;
        }
    	
        try (Connection conn = DB.getDB().getConnection()) {
            String sql = "INSERT INTO ParticipantBatch (pid, bid) VALUES (?, ?)";
            
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, pid);
            pst.setInt(2, bid);
            int rowsAffected = pst.executeUpdate();
            
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
