/**
 * 
 */
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
import com.vjhs.interfaces.TeacherExamScheduleOperations;
import com.vjhs.pojo.ExamScheduleTeacher;

/**
 * @author wasimakram.sutar
 *
 */
public class TeacherExamScheduleOperImp implements TeacherExamScheduleOperations{

	DBConnection dbConnection = DBConnection.util;
	private static final Logger LOGGER = Logger.getLogger(TeacherExamScheduleOperImp.class
			.getName());
	@Override
	public boolean addTeacherExamSchedule(
			ExamScheduleTeacher examScheduleTeacher) {

		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(ADD_EXAM_SCHEDULE_TEACHER);
			
			pst.setString(1, examScheduleTeacher.getEmployeeId());
			pst.setString(2, examScheduleTeacher.getExamType());
			pst.setDate(3, examScheduleTeacher.getFromDate());
			pst.setDate(4, examScheduleTeacher.getToDate());
			pst.setString(5, examScheduleTeacher.getRole());
			pst.setString(6, examScheduleTeacher.getRoomNo());
			pst.setString(7, examScheduleTeacher.getSubject());
			pst.setDate(8, examScheduleTeacher.getCreationDate());
			pst.setString(9, examScheduleTeacher.getCreatedBy());
			
			count = pst.executeUpdate();
			//con.commit();
		} catch (SQLException e) {
			LOGGER.info("While adding Teacher Exam Schedule into Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);
	
	}

	@Override
	public boolean updateTeacherExamSchedule(
			ExamScheduleTeacher examScheduleTeacher) {

		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(UPDATE_EXAM_SCHEDULE_TEACHER);
			
			pst.setString(1, examScheduleTeacher.getEmployeeId());
			pst.setString(2, examScheduleTeacher.getExamType());
			pst.setDate(3, examScheduleTeacher.getFromDate());
			pst.setDate(4, examScheduleTeacher.getToDate());
			pst.setString(5, examScheduleTeacher.getRole());
			pst.setString(6, examScheduleTeacher.getRoomNo());
			pst.setString(7, examScheduleTeacher.getSubject());
			pst.setDate(8, examScheduleTeacher.getUpdatedDate());
			pst.setString(9, examScheduleTeacher.getUpdatedBy());
			
			count = pst.executeUpdate();
			//con.commit();
		} catch (SQLException e) {
			LOGGER.info("While upadating Teacher exam schedule in Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);
	
	}

	@Override
	public boolean deleteTeacherExamSchedule(String employeeId) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(DELETE_EXAM_SCHEDULE_TEACHER);
			pst.setString(1, employeeId);
			count = pst.executeUpdate();
			//con.commit();
		} catch (SQLException e) {
			LOGGER.info("While Deleting Teacher exam schedule into Database: "
					+ e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);
	}

	@Override
	public List<ExamScheduleTeacher> getTeacherExamSchedule(String employeeId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<ExamScheduleTeacher> teacherExamScheduleList = new ArrayList<ExamScheduleTeacher>();
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_EXAM_SCHEDULE_TEACHER);
			pst.setString(1, employeeId);
			rs = pst.executeQuery();
			while (rs.next()) {
				// batch processing code
			}
		} catch (SQLException e) {
			LOGGER.info("While Adding Teacher Timetable into Database: "
					+ e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return teacherExamScheduleList;
	}

}
