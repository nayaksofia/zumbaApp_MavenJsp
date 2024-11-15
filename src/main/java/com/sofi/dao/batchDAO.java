package com.sofi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import com.sofi.bean.Batch;
import com.sofi.db.DB;



//Manages CRUD operations for the Batch table
public class BatchDAO {


	// Insert Batches
	public int addBatch(Batch batch) throws ClassNotFoundException, SQLException {

		String sql = "insert into Batch(instructor, date, schedule, time) values ( ?,?,?,?)";

		//try-with-resources
		try (  Connection con = DB.getDB().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, batch.getInstructor());
			ps.setDate(2, batch.getDate());
			ps.setString(3, batch.getSchedule());
			ps.setTime(4, batch.getTime());

			return ps.executeUpdate();
		}

	}

	// Retrieve All Batch Data From Database

	public ArrayList<Batch> fetchAllBatch() throws ClassNotFoundException, SQLException {

		ArrayList<Batch> batches = new ArrayList<Batch>();

		String sql = "select * from Batch";

		//try-with-resources
		try (   Connection con = DB.getDB().getConnection();
				PreparedStatement ps = con.prepareStatement(sql); 
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Batch batch = new Batch();

				batch.setBid(rs.getInt("bid"));
				batch.setInstructor(rs.getString("instructor"));
				batch.setDate(rs.getDate("date"));
				batch.setSchedule(rs.getString("schedule"));
				batch.setTime(rs.getTime("time"));

				batches.add(batch);
			}
		}

		return batches;
	}

	// Retrieve Batch data By bid
	public Batch fetchBatchById(int id) throws ClassNotFoundException, SQLException {

		String sql = "select * from Batch where bid = ?";

		//try-with-resources
		try (   Connection con = DB.getDB().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Batch batch = new Batch();

					batch.setBid(rs.getInt("bid"));
					batch.setInstructor(rs.getString("instructor"));
					batch.setDate(rs.getDate("date"));
					batch.setSchedule(rs.getString("schedule"));
					batch.setTime(rs.getTime("time"));

					return batch;
				}

			}
		}

		return null;
	}

	// Update By Id
	public int updateBatch(Batch batch) throws ClassNotFoundException, SQLException {

		String sql = "update Batch set  instructor=?, date=?, schedule=? , time =? where bid =?";

		//try-with-resources
		try (  Connection con = DB.getDB().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, batch.getInstructor());

			ps.setDate(2, batch.getDate());

			ps.setString(3, batch.getSchedule());

			ps.setTime(4, batch.getTime());

			ps.setInt(5, batch.getBid());

			return ps.executeUpdate();

		}
	}

	// Delete
	public int deleteBatch(int id) throws ClassNotFoundException, SQLException {

		String sql = "delete from Batch where bid= ?";

		//try-with-resources
		try (  Connection con = DB.getDB().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);

			return ps.executeUpdate();

		}
	}
}

/* Notes: Exception Handling try..catch block
 * -----------------
 * No need of repeating catch and finally block repeatedly.
 * Using of try-with-resources : closes automatically the statements and result sets after execution
 * Make the code more cleaner 
 */
