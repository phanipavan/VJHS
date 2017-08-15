package com.vjhs.imp;

import static com.vjhs.interfaces.SQLQuery.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.vjhs.dao.DBConnection;
import com.vjhs.interfaces.TeacherTTOperations;
import com.vjhs.pojo.TeacherTT;

public class TeacherTTOperImp implements TeacherTTOperations {

	DBConnection dbConnection = DBConnection.util;
	private static final Logger LOGGER = Logger.getLogger(TeacherTTOperImp.class.getName());

	@Override
	public boolean addTimeTable(List<TeacherTT> teacherTTList) {
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst2 = null;
		int[] count, count2;
		boolean res = false;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(ADD_TEACHER_TIMETABLE);
			pst2 = con.prepareStatement(UPDATE_TEACHER_TIMETABLE);
			for (TeacherTT teacherTT : teacherTTList) {
				if (isTchrTTExist(teacherTT.getDays(), teacherTT.getEmployeeId())) {
					pst2.setString(1, teacherTT.getPeriodI());
					pst2.setString(2, teacherTT.getPeriodII());
					pst2.setString(3, teacherTT.getPeriodIII());
					pst2.setString(4, teacherTT.getPeriodIV());
					pst2.setString(5, teacherTT.getPeriodV());
					pst2.setString(6, teacherTT.getPeriodVI());
					pst2.setString(7, teacherTT.getPeriodVII());
					pst2.setString(8, teacherTT.getPeriodVIII());
					pst2.setString(9, teacherTT.getPeriodIClass());
					pst2.setString(10, teacherTT.getPeriodIIClass());
					pst2.setString(11, teacherTT.getPeriodIIIClass());
					pst2.setString(12, teacherTT.getPeriodIVClass());
					pst2.setString(13, teacherTT.getPeriodVClass());
					pst2.setString(14, teacherTT.getPeriodVIClass());
					pst2.setString(15, teacherTT.getPeriodVIIClass());
					pst2.setString(16, teacherTT.getPeriodVIIIClass());
					pst2.setDate(17, teacherTT.getUpdatedDate());
					pst2.setString(18, teacherTT.getUpdatedBy());
					pst2.setString(19, teacherTT.getEmployeeId());
					pst2.setString(20, teacherTT.getDays());
					pst2.addBatch();
				} else {
					pst.setString(1, teacherTT.getEmployeeId());
					pst.setString(2, teacherTT.getDays());
					pst.setString(3, teacherTT.getPeriodI());
					pst.setString(4, teacherTT.getPeriodII());
					pst.setString(5, teacherTT.getPeriodIII());
					pst.setString(6, teacherTT.getPeriodIV());
					pst.setString(7, teacherTT.getPeriodV());
					pst.setString(8, teacherTT.getPeriodVI());
					pst.setString(9, teacherTT.getPeriodVII());
					pst.setString(10, teacherTT.getPeriodVIII());
					pst.setString(11, teacherTT.getPeriodIClass());
					pst.setString(12, teacherTT.getPeriodIIClass());
					pst.setString(13, teacherTT.getPeriodIIIClass());
					pst.setString(14, teacherTT.getPeriodIVClass());
					pst.setString(15, teacherTT.getPeriodVClass());
					pst.setString(16, teacherTT.getPeriodVIClass());
					pst.setString(17, teacherTT.getPeriodVIIClass());
					pst.setString(18, teacherTT.getPeriodVIIIClass());
					pst.setDate(19, teacherTT.getCreation_Date());
					pst.setString(20, teacherTT.getCreatedBy());
					pst.addBatch();
				}
			}
			count = pst.executeBatch();
			count2 = pst2.executeBatch();
			for (int i : count) {
				if (i > 0) {
					res = true;
				} else {
					res = false;
				}
			}
			for (int i : count2) {
				if (i > 0) {
					res = true;
				} else {
					res = false;
				}
			}
			// con.commit();
		} catch (SQLException e) {
			LOGGER.info("While Adding / Updating Teacher Timetable into Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst2);
			dbConnection.close(pst, con);
		}
		return res;
	}

	@Override
	public boolean updateTimeTable(List<TeacherTT> teacherTTList) {
		Connection con = null;
		PreparedStatement pst = null;
		int[] countArray = null;
		boolean flag = false;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(UPDATE_TEACHER_TIMETABLE);
			for (TeacherTT teacherTT : teacherTTList) {
				pst.setString(1, teacherTT.getDays());
				pst.setString(2, teacherTT.getEmployeeId());
				pst.setString(3, teacherTT.getPeriodI());
				pst.setString(4, teacherTT.getPeriodII());
				pst.setString(5, teacherTT.getPeriodIII());
				pst.setString(6, teacherTT.getPeriodIV());
				pst.setString(7, teacherTT.getPeriodV());
				pst.setString(8, teacherTT.getPeriodVI());
				pst.setString(9, teacherTT.getPeriodVII());
				pst.setString(10, teacherTT.getPeriodVIII());
				pst.addBatch();
			}
			countArray = pst.executeBatch();
			// con.commit();
		} catch (SQLException e) {
			LOGGER.info("While Updating Teacher Timetable into Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		for (int count : countArray) {
			if (count < 1) {
				flag = true;
				return flag;
			}
		}
		return flag;
	}

	@Override
	public boolean deleteTimeTable(String jobId) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(DELETE_TEACHER_TIMETABLE);
			pst.setString(1, jobId);
			count = pst.executeUpdate();
			// con.commit();
		} catch (SQLException e) {
			LOGGER.info("While Deleting Teacher Timetable into Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);
	}

	@Override
	public List<TeacherTT> getTimeTableByJobId(String empId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<TeacherTT> teacherTTList = new ArrayList<TeacherTT>();
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_TEACHER_TABLE_BY_ID);
			pst.setString(1, empId);
			rs = pst.executeQuery();
			while (rs.next()) {
				TeacherTT teacherTT = new TeacherTT();
				teacherTT.setDays(rs.getString("DAY"));
				teacherTT.setEmployeeId(empId);
				teacherTT.setPeriodI(rs.getString("PERIOD_I"));
				teacherTT.setPeriodII(rs.getString("PERIOD_II"));
				teacherTT.setPeriodIII(rs.getString("PERIOD_III"));
				teacherTT.setPeriodIV(rs.getString("PERIOD_IV"));
				teacherTT.setPeriodV(rs.getString("PERIOD_V"));
				teacherTT.setPeriodVI(rs.getString("PERIOD_VI"));
				teacherTT.setPeriodVII(rs.getString("PERIOD_VII"));
				teacherTT.setPeriodVIII(rs.getString("PERIOD_VIII"));
				teacherTT.setPeriodIClass(rs.getString("PERIOD_I_CLASS"));
				teacherTT.setPeriodIIClass(rs.getString("PERIOD_II_CLASS"));
				teacherTT.setPeriodIIIClass(rs.getString("PERIOD_III_CLASS"));
				teacherTT.setPeriodIVClass(rs.getString("PERIOD_IV_CLASS"));
				teacherTT.setPeriodVClass(rs.getString("PERIOD_V_CLASS"));
				teacherTT.setPeriodVIClass(rs.getString("PERIOD_VI_CLASS"));
				teacherTT.setPeriodVIIClass(rs.getString("PERIOD_VII_CLASS"));
				teacherTT.setPeriodVIIIClass(rs.getString("PERIOD_VIII_CLASS"));
				teacherTTList.add(teacherTT);
			}
		} catch (SQLException e) {
			LOGGER.info("While getting Teacher Timetable into Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return teacherTTList;
	}

	@Override
	public boolean isTchrTTExist(String day, String empId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(IS_TEACHER_EXIT);
			pst.setString(1, day);
			pst.setString(2, empId);
			rs = pst.executeQuery();
			while (rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (SQLException e) {
			LOGGER.info("While checking Employee existance from Database: " + e.getMessage());
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return (count > 0);
	}

}