package com.vjhs.imp;

import static com.vjhs.interfaces.SQLQuery.ADD_OVERVIEW;
import static com.vjhs.interfaces.SQLQuery.GET_OVERVIEW;
import static com.vjhs.interfaces.SQLQuery.UPDATE_OVERVIEW;
import static com.vjhs.interfaces.SQLQuery.GET_NO_OF_STU;
import static com.vjhs.interfaces.SQLQuery.GET_NO_OF_TEACHERS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.vjhs.dao.DBConnection;
import com.vjhs.interfaces.OverviewOperations;
import com.vjhs.pojo.Overview;

public class OverviewOperImp implements OverviewOperations {

	DBConnection dbConnection = DBConnection.util;
	private static final Logger LOGGER = Logger.getLogger(OverviewOperImp.class
			.getName());

	@Override
	public boolean addOverview(Overview overview) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(ADD_OVERVIEW);
			pst.setString(1, overview.getSchoolName());
			pst.setString(2, overview.getHeadquarters());
			pst.setString(3, overview.getBranches());
			pst.setString(4, overview.getCity());
			pst.setString(5, overview.getDistrict());
			pst.setString(6, overview.getState());
			pst.setString(7, overview.getPhoneNo());
			pst.setString(8, overview.getMobileNo());
			pst.setString(9, overview.getEmail());
			pst.setInt(10, overview.getNoOfStudents());
			pst.setInt(11, overview.getNoOfTeachers());
			pst.setInt(12, overview.getStartYear());
			pst.setDate(13, overview.getCreationDate());
			pst.setString(14, overview.getCreatedBy());
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
	public boolean updateOverview(Overview overview) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(UPDATE_OVERVIEW);
			pst.setString(1, overview.getSchoolName());
			pst.setString(2, overview.getHeadquarters());
			pst.setString(3, overview.getBranches());
			pst.setString(4, overview.getCity());
			pst.setString(5, overview.getDistrict());
			pst.setString(6, overview.getState());
			pst.setString(7, overview.getPhoneNo());
			pst.setString(8, overview.getMobileNo());
			pst.setString(9, overview.getEmail());
			pst.setInt(10, overview.getStartYear());
			pst.setDate(11, overview.getUpdatedDate());
			pst.setString(12, overview.getUpdatedBy());
			count = pst.executeUpdate();
			//con.commit();
		} catch (SQLException e) {
			LOGGER.info("While updating Overview into Database: "
					+ e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);
	}

	@Override
	public Overview getOverview() {
		Overview overview = new Overview();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_OVERVIEW);
			rs = pst.executeQuery();
			while (rs.next()) {
				overview.setSchoolName(rs.getString("SCHOOL_NAME"));
				overview.setHeadquarters(rs.getString("HEDQUARTERS"));
				overview.setBranches(rs.getString("BRANCHES"));
				overview.setCity(rs.getString("CITY"));
				overview.setDistrict(rs.getString("DISTRICT"));
				overview.setState(rs.getString("STATE"));
				overview.setPhoneNo(rs.getString("PHONE_NUMBER"));
				overview.setMobileNo(rs.getString("MOBILE_NUMBER"));
				overview.setEmail(rs.getString("EMAIL"));
				overview.setNoOfStudents(getTotalStudents());
				overview.setNoOfTeachers(getTotalTeachers());
				overview.setStartYear(rs.getInt("START_YEAR"));
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting Overview into database:"
					+ e.getMessage());
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return overview;
	}
	
	private int getTotalStudents(){
		int count = 0;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_NO_OF_STU);
			rs = pst.executeQuery();
			while (rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting Total no of students from database:"
					+ e.getMessage());
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return count;
	}
	
	private int getTotalTeachers(){
		int count = 0;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_NO_OF_TEACHERS);
			rs = pst.executeQuery();
			while (rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting Total no of teachers from database:"
					+ e.getMessage());
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return count;
	}

}
