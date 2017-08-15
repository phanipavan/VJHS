/**
 * 
 */
package com.vjhs.imp;

import static com.vjhs.interfaces.SQLQuery.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.vjhs.dao.DBConnection;
import com.vjhs.interfaces.SchoolTimingsOperations;
import com.vjhs.pojo.SchoolTimings;

/**
 * @author wasimakram.sutar
 *
 */
public class SchoolTimingsOperImp implements SchoolTimingsOperations {
	DBConnection dbConnection = DBConnection.util;
	private static final Logger LOGGER = Logger
			.getLogger(SchoolTimingsOperImp.class.getName());

	@Override
	public boolean addSchoolTimings(SchoolTimings schoolTimings) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(ADD_SCHOOL_TIMINGS);
			pst.setString(1, schoolTimings.getPeriod());
			pst.setString(2, schoolTimings.getFroTime());
			pst.setString(3, schoolTimings.getToTime());
			pst.setDate(4, schoolTimings.getCreationDate());
			pst.setString(5, schoolTimings.getCreatedBy());
			count = pst.executeUpdate();
			//con.commit();
		} catch (SQLException e) {
			LOGGER.info("While adding Overview into Database: "
					+ e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);
	}

	@Override
	public boolean updateSchoolTimings(SchoolTimings schoolTimings) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(UPDATE_SCHOOL_TIMINGS);
			pst.setString(1, schoolTimings.getPeriod());
			pst.setString(2, schoolTimings.getFroTime());
			pst.setString(3, schoolTimings.getToTime());
			pst.setDate(6, schoolTimings.getUpdatedDate());
			pst.setString(7, schoolTimings.getUpdatedBy());
			count = pst.executeUpdate();
			//con.commit();
		} catch (SQLException e) {
			LOGGER.info("While adding Overview into Database: "
					+ e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);

	}

	@Override
	public SchoolTimings getSchoolTimings() {
		SchoolTimings schoolTimings = new SchoolTimings();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement("");
			rs = pst.executeQuery();
			while (rs.next()) {
				schoolTimings.setPeriod(rs.getString("PERIOD"));
				schoolTimings.setFroTime(rs.getString("FROM_TIME"));
				schoolTimings.setToTime(rs.getString("TO_TIME"));
				schoolTimings.setCreationDate(rs.getDate("CREATION_DATE"));
				schoolTimings.setCreatedBy(rs.getString("CREATED_BY"));
				schoolTimings.setUpdatedDate(rs.getDate("UPDATED_DATE"));
				schoolTimings.setUpdatedBy(rs.getString("UPDATED_BY"));
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting Overview into database:"
					+ e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return schoolTimings;
	}
}
