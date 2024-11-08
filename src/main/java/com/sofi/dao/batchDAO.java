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

/* Notes: Exception Handling try..catch block
 * -----------------
 * No need of repeating catch and finally block repeatedly.
 * Using of try-with-resources : closes automatically the statements and result sets after execution
 * Make the code more cleaner 
 */

//Manages CRUD operations for the Batch table
public class BatchDAO {

	Connection con;
	PreparedStatement ps;

	public BatchDAO() {
		// Initialize the connection
		con = DB.getDB().con;
	}

	// Insert Batches
	public int addBatch(Batch batch) throws ClassNotFoundException, SQLException {
		int result = 0;

		try {
			String sql = "insert into Batch(instructor, date, schedule, time) values ( ?,?,?,?)";
			ps = con.prepareStatement(sql);

			ps.setString(1, batch.getInstructor());
			ps.setDate(2, Date.valueOf(batch.getDate()));
			ps.setString(3, batch.getSchedule());
			ps.setTime(4, Time.valueOf(batch.getTime()));

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			if (ps != null) {
				ps.close();
			}
		}

		return result;
	}

	// Retrieve All Batch Data From Database

	public ArrayList<Batch> fetchAllBatch() throws ClassNotFoundException, SQLException {

		ArrayList<Batch> batches = new ArrayList<Batch>();

		try {

			String sql = "select * from Batch";

			ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Batch batch = new Batch();

				batch.setBid(rs.getInt("bid"));
				batch.setInstructor(rs.getString("instructor"));
				batch.setDate(rs.getDate("date").toLocalDate());
				batch.setSchedule(rs.getString("schedule"));
				batch.setTime(rs.getTime("time").toLocalTime());

				batches.add(batch);
			}

			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}

		return batches;
	}

	// Retrieve Batch data By bid
	public Batch fetchBatchById(int id) throws ClassNotFoundException, SQLException {

		Batch batch = null;
		try {

			String sql = "select * from Batch where bid = ?";

			ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				batch = new Batch();

				batch.setBid(rs.getInt("bid"));
				batch.setInstructor(rs.getString("instructor"));
				batch.setDate(rs.getDate("date").toLocalDate());
				batch.setSchedule(rs.getString("schedule"));
				batch.setTime(rs.getTime("time").toLocalTime());
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}

		return batch;
	}

	// Update By Id
	public int updateBatch(Batch batch) throws ClassNotFoundException, SQLException {

		int result = 0;

		try {

			String sql = "update Batch set  instructor=?, date=?, schedule=? , time =? where bid =?";

			ps = con.prepareStatement(sql);

			ps.setString(1, batch.getInstructor());

			ps.setDate(2, Date.valueOf(batch.getDate()));

			ps.setString(3, batch.getSchedule());

			ps.setTime(4, Time.valueOf(batch.getTime()));

			ps.setInt(5, batch.getBid());

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
	public int deleteBatch(int id) throws ClassNotFoundException, SQLException {

		int result = 0;

		try {

			String sql = "delete from Batch where bid= ?";
			ps = con.prepareStatement(sql);

			ps.setInt(1, id);

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
