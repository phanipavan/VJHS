/**
 * 
 */
package com.vjhs.imp;

import static com.vjhs.interfaces.SQLQuery.ADD_TEACHER_ATTENDANCE;
import static com.vjhs.interfaces.SQLQuery.GET_TEACHER_ATTENDANCE_BY_EMPID;
import static com.vjhs.interfaces.SQLQuery.IS_TEACHER_AVAIL;
import static com.vjhs.interfaces.SQLQuery.UPDATE_TEACHER_ATTENDANCE;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.vjhs.dao.DBConnection;
import com.vjhs.interfaces.TeacherAttendanceOperations;
import com.vjhs.interfaces.TeacherOperations;
import com.vjhs.pojo.TeacherAttendance;

/**
 * @author wasimakram.sutar
 *
 */
public class TeacherAttendanceOperImp implements TeacherAttendanceOperations {
	DBConnection dbConnection = DBConnection.util;
	private static final Logger LOGGER = Logger.getLogger(TeacherAttendanceOperImp.class.getName());
	private TeacherOperations teacherOprImp = new TeacherOperImp();

	@Override
	public boolean addTeacherAttandance(List<TeacherAttendance> techAttList) {
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst2 = null;
		int[] count, count2;
		boolean res = false;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(ADD_TEACHER_ATTENDANCE);
			pst2 = con.prepareStatement(UPDATE_TEACHER_ATTENDANCE);
			for (TeacherAttendance techAttendance : techAttList) {
				if (isTeacherAvailable(techAttendance)) {
					pst2.setString(1, techAttendance.getAttendanceStatus());
					pst2.setDate(2, (Date) techAttendance.getUpdatedDate());
					pst2.setString(3, techAttendance.getUpdatedBy());
					pst2.setString(4, techAttendance.getEmployeeId());
					pst2.setDate(5, new Date(techAttendance.getAttendanceDate().getTime()));
					pst2.addBatch();
				} else {
					pst.setString(1, techAttendance.getEmployeeId());
					pst.setDate(2, new Date(techAttendance.getAttendanceDate().getTime()));
					pst.setString(3, techAttendance.getAttendanceStatus());
					pst.setDate(4, (Date) techAttendance.getCreationDate());
					pst.setString(5, techAttendance.getCreatedBy());
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
			//con.commit();
		} catch (SQLException e) {
			LOGGER.info("While adding Teacher into Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst2);
			dbConnection.close(pst, con);
		}
		return res;
	}

	@Override
	public List<TeacherAttendance> getAttenStatus(TeacherAttendance teachAtten) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<TeacherAttendance> attList = new ArrayList<TeacherAttendance>();
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_TEACHER_ATTENDANCE_BY_EMPID);
			pst.setDate(1, new Date(teachAtten.getAttendanceDate().getTime()));
			rs = pst.executeQuery();
			while (rs.next()) {
				TeacherAttendance teachAtdance = new TeacherAttendance();
				teachAtdance.setEmployeeId(rs.getString("EMP_ID"));
				teachAtdance.setEmployeeName(rs.getString("EMP_NAME"));
				teachAtdance.setAttendanceStatus(rs.getString("ATTENDANCE_STATUS"));
				attList.add(teachAtdance);
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting Attendance Status into Database: " + e.getMessage());
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return attList;
	}

	@Override
	public boolean isTeacherAvailable(TeacherAttendance teacherAttendance) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int count = 0;
		if (teacherAttendance.getEmployeeId() == null || "".equals(teacherAttendance.getEmployeeId())) {
			if ("".equalsIgnoreCase(teacherAttendance.getEmployeeName())) {
				teacherAttendance.setEmployeeId(teacherOprImp.getEmpId(teacherAttendance.getEmployeeName()));
			}
		}
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(IS_TEACHER_AVAIL);
			pst.setString(1, teacherAttendance.getEmployeeId());
			pst.setDate(2, new java.sql.Date(teacherAttendance.getAttendanceDate().getTime()));
			rs = pst.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.info("While Updating Teacher into Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);
	}

}
