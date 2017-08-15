/**
 * 
 */
package com.vjhs.imp;

import static com.vjhs.interfaces.SQLQuery.ADD_STUDENT_ATTENDANCE;
import static com.vjhs.interfaces.SQLQuery.GET_TEACHER_ATTENDANCE_BY_EMPID;
import static com.vjhs.interfaces.SQLQuery.UPDATE_STUDENT_ATTENDANCE;
import static com.vjhs.interfaces.SQLQuery.GET_STUDENT_ATTENDANCE_EXIST;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import com.vjhs.dao.DBConnection;
import com.vjhs.interfaces.StudentAttendanceOperation;
import com.vjhs.pojo.StudentAttendance;

/**
 * @author wasimakram.sutar
 *
 */
public class StudentAttendanceOperImp implements StudentAttendanceOperation {
	DBConnection dbConnection = DBConnection.util;
	private static final Logger LOGGER = Logger.getLogger(StudentAttendanceOperImp.class.getName());

	@Override
	public boolean addStudentAttendance(List<StudentAttendance> studentAttendance) {
		Connection con = null;
		PreparedStatement pst = null;
		int[] count;
		boolean res = false;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(ADD_STUDENT_ATTENDANCE);
			for (StudentAttendance studAtten : studentAttendance) {
				pst.setString(1, studAtten.getAdmissionNo());
				pst.setString(2, studAtten.getClassName());
				pst.setString(3, studAtten.getStudentName());
				pst.setInt(4, studAtten.getMonth());
				pst.setInt(5, studAtten.getYear());
				pst.setDouble(6, studAtten.getDayAttended());
				pst.setDouble(7, studAtten.getWorkingDays());
				pst.setDouble(8, studAtten.getMonthlyPercentage());
				pst.setDate(9, studAtten.getCreationDate());
				pst.setString(10, studAtten.getCreatedBy());
				pst.addBatch();
			}
			count = pst.executeBatch();
			for (int i : count) {
				if (i > 0) {
					res = true;
				} else {
					res = false;
				}
			}
			// con.commit();
		} catch (SQLException e) {
			LOGGER.info("While adding Student Attendance into Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return res;
	}

	@Override
	public boolean updateStudentAttendence(List<StudentAttendance> studentAttendance) {
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst2 = null;
		int[] count, count2;
		boolean res = false;
		try {
			con = dbConnection.getConnection();
			pst2 = con.prepareStatement(ADD_STUDENT_ATTENDANCE);
			pst = con.prepareStatement(UPDATE_STUDENT_ATTENDANCE);
			for (StudentAttendance studAtten : studentAttendance) {
				if (isAttendanceExist(studAtten.getClassName(), studAtten.getAdmissionNo(), studAtten.getMonth(),
						studAtten.getYear())) {
					pst.setString(1, studAtten.getStudentName());
					pst.setDouble(2, studAtten.getDayAttended());
					pst.setDouble(3, studAtten.getWorkingDays());
					pst.setDouble(4, studAtten.getMonthlyPercentage());
					pst.setDate(5, (Date) studAtten.getUpdatedDate());
					pst.setString(6, studAtten.getUpdatedBy());
					pst.setString(7, studAtten.getAdmissionNo());
					pst.setString(8, studAtten.getClassName());
					pst.setInt(9, studAtten.getMonth());
					pst.setInt(10, studAtten.getYear());
					pst.addBatch();
				} else {
					pst2.setString(1, studAtten.getAdmissionNo());
					pst2.setString(2, studAtten.getClassName());
					pst2.setString(3, studAtten.getStudentName());
					pst2.setInt(4, studAtten.getMonth());
					pst2.setInt(5, studAtten.getYear());
					pst2.setDouble(6, studAtten.getDayAttended());
					pst2.setDouble(7, studAtten.getWorkingDays());
					pst2.setDouble(8, studAtten.getMonthlyPercentage());
					pst2.setDate(9, (Date) studAtten.getCreationDate());
					pst2.setString(10, studAtten.getCreatedBy());
					pst2.addBatch();
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
			/*con.commit();*/
		} catch (SQLException e) {
			LOGGER.info("While updating Stdenace Attendance into Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst2);
			dbConnection.close(pst, con);
		}
		return res;
	}

	private boolean isAttendanceExist(String cls, String adminNo, int month, int year) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_STUDENT_ATTENDANCE_EXIST);
			pst.setString(1, adminNo);
			pst.setInt(2, month);
			pst.setString(3, cls);
			pst.setInt(4, year);
			rs = pst.executeQuery();
			while (rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting Attendance Status into Database: " + e.getMessage());
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return (count > 0);

	}

	@Override
	public String getAttenStatus(String reqDate) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String status = "";
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_TEACHER_ATTENDANCE_BY_EMPID);
			pst.setString(1, reqDate);
			rs = pst.executeQuery();
			while (rs.next()) {
				status = rs.getString("");
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting Attendance Status into Database: " + e.getMessage());
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return status;
	}

}
