package com.sofi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.sofi.bean.Participant;
import com.sofi.db.DB;

// Provides CRUD operations for the Participant table 

public class ParticipantDAO {

	Connection con;
	PreparedStatement ps;

	public ParticipantDAO() {
		// Initialize the connection
		con = DB.getDB().con;
	}

	// Insert Participant
	public int addParticipant(Participant p) throws ClassNotFoundException, SQLException {
		int result = 0;

		try {
			String sql = "insert into Participant(name, age, email, password) values (?,?,?,?)";
			ps = con.prepareStatement(sql);

			ps.setString(1, p.getName());
			ps.setInt(2, p.getAge());
			ps.setString(3, p.getEmail());
			ps.setString(4, p.getPassword());

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}

		return result;
	}

	// Retrieve All Participants
	public ArrayList<Participant> fetchAllParticipants() throws ClassNotFoundException, SQLException {

		ArrayList<Participant> participants = new ArrayList<Participant>();

		try {

			String sql = "select * from Participant";
			ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Participant p = new Participant();

				p.setPid(rs.getInt("pid"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setEmail(rs.getString("email"));
				p.setPassword(rs.getString("password"));

				participants.add(p);
			}

			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}

		return participants;
	}

	// Retrieve Participants By pid
	public Participant fetchParticipantById(int id) throws ClassNotFoundException, SQLException {

		Participant p = null;
		try {

			String sql = "select * from Participant where pid = ?";

			ps = con.prepareStatement(sql);
			ps.setInt(1, id); // passing parameter id

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				p = new Participant(); // Create object of Participant

				p.setPid(rs.getInt("pid"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setEmail(rs.getString("email"));
				p.setPassword(rs.getString("password"));
			}

			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}

		return p;
	}

	// Update Participant By pid

	public int updateParticipant(Participant p) throws ClassNotFoundException, SQLException {
		int result = 0;

		try {

			String sql = "update Participant set name=?, age=?, email=?, password=? where pid =?";

			ps = con.prepareStatement(sql);

			ps.setString(1, p.getName());
			ps.setInt(2, p.getAge());
			ps.setString(3, p.getEmail());
			ps.setString(4, p.getPassword());
			ps.setInt(5, p.getPid());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (ps != null) {
				ps.close();
			}
		}

		return result;
	}

	// Delete

	public int deleteParticipant(int id) throws ClassNotFoundException, SQLException {

		int result = 0;

		try {

			String sql = "delete from Participant where pid= ?";
			ps = con.prepareStatement(sql);

			ps.setInt(1, id); // Set parameter value

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}

		return result;
	}

}

/* Notes: Exception Handling try..catch block
 * -----------------
 * No need of repeating catch and finally block repeatedly.
 * Using of try-with-resources : closes automatically the statements and result sets after execution
 * Make the code more cleaner 
 */