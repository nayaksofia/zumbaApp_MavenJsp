package com.sofi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sofi.bean.Participant;
import com.sofi.db.DB;

// Provides CRUD operations for the Participant table 

public class ParticipantDAO {


	// Insert Participant
	public int addParticipant(Participant p) throws ClassNotFoundException, SQLException {

		String sql = "insert into Participant(name, age, email, password) values (?,?,?,?)";
		
		try (   Connection con = DB.getDB().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, p.getName());
			ps.setInt(2, p.getAge());
			ps.setString(3, p.getEmail());
			ps.setString(4, p.getPassword());

			return ps.executeUpdate();
		}
	}

	// Retrieve All Participants
	public List<Participant> fetchAllParticipants() throws ClassNotFoundException, SQLException {

		List<Participant> participants = new ArrayList<Participant>();

		String sql = "select * from Participant";

		try (   Connection con = DB.getDB().getConnection();
				PreparedStatement ps = con.prepareStatement(sql); 
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Participant p = new Participant();

				p.setPid(rs.getInt("pid"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setEmail(rs.getString("email"));
				p.setPassword(rs.getString("password"));

				participants.add(p);
			}
		}

		return participants;
	}

	// Retrieve Participants By pid
	public Participant fetchParticipantById(int id) throws ClassNotFoundException, SQLException {

		String sql = "select * from Participant where pid = ?";

		try (   Connection con = DB.getDB().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id); // passing parameter id

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {

					Participant p = new Participant(); // Create object of Participant

					p.setPid(rs.getInt("pid"));
					p.setName(rs.getString("name"));
					p.setAge(rs.getInt("age"));
					p.setEmail(rs.getString("email"));
					p.setPassword(rs.getString("password"));

					return p;
				}
			}
		}

		return null;
	}

	// Update Participant By pid

	public int updateParticipant(Participant p) throws ClassNotFoundException, SQLException {

		String sql = "update Participant set name=?, age=?, email=?, password=? where pid =?";
		try (   Connection con = DB.getDB().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, p.getName());
			ps.setInt(2, p.getAge());
			ps.setString(3, p.getEmail());
			ps.setString(4, p.getPassword());
			ps.setInt(5, p.getPid());

			return ps.executeUpdate();

		}
	}

	// Delete

	public int deleteParticipant(int id) throws ClassNotFoundException, SQLException {

		String sql = "delete from Participant where pid= ?";

		try (   Connection con = DB.getDB().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id); // Set parameter value

			return ps.executeUpdate();
		}
	}
	
}

/*
 * Notes: 
 * 
 * Exception Handling try..catch block 
 * ----------------- 
 * No need of repeating catch and finally block repeatedly. 
 * 
 * Using of try-with-resources :
 * -----------------
 * closes automatically the statements and result sets after execution and Make the
 * code more cleaner
 */