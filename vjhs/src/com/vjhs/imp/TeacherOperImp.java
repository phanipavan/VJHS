package com.vjhs.imp;

import static com.vjhs.interfaces.SQLQuery.ADD_TEACHER;
import static com.vjhs.interfaces.SQLQuery.DELETE_TEACHER;
import static com.vjhs.interfaces.SQLQuery.GET_EMP_ID_BY_NAME;
import static com.vjhs.interfaces.SQLQuery.GET_EMP_NAME_BY_ID;
import static com.vjhs.interfaces.SQLQuery.GET_TEACHERS;
import static com.vjhs.interfaces.SQLQuery.GET_TEACHER_BY_ID;
import static com.vjhs.interfaces.SQLQuery.IS_TEACHER_AVAILS;
import static com.vjhs.interfaces.SQLQuery.UPDATE_TEACHER;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.vjhs.dao.DBConnection;
import com.vjhs.interfaces.TeacherOperations;
import com.vjhs.pojo.Teacher;

public class TeacherOperImp implements TeacherOperations {

	DBConnection dbConnection = DBConnection.util;
	private static final Logger LOGGER = Logger.getLogger(TeacherOperImp.class.getName());

	@Override
	public boolean addTeacher(Teacher teacher) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(ADD_TEACHER);
			pst.setString(1, teacher.getEmployeeId());
			pst.setString(2, teacher.getTeacherName());
			pst.setString(3, teacher.getFatherOrHusbundName());
			pst.setString(4, teacher.getReligion());
			pst.setString(5, teacher.getCaste());
			pst.setString(6, teacher.getGender());
			pst.setString(7, teacher.getMaritalStatus());
			pst.setDate(8, new java.sql.Date(teacher.getDateOfBirth().getTime()));
			pst.setDate(9, new java.sql.Date(teacher.getDateOfJoining().getTime()));
			pst.setString(10, teacher.getAddresss());
			pst.setString(11, teacher.getCity());
			pst.setString(12, teacher.getState());
			pst.setString(13, teacher.getNationality());
			pst.setLong(14, teacher.getPhone());
			pst.setString(15, teacher.getQualification());
			pst.setLong(16, teacher.getExperiance());
			pst.setString(17, teacher.getSubjects());
			pst.setString(18, teacher.getClasses());
			pst.setString(19, teacher.getClass_teacher());
			pst.setString(20, teacher.getDesignation());
			pst.setString(21, teacher.getUser_id());
			pst.setString(22, teacher.getPassword());
			pst.setDate(23, (Date) teacher.getCreation_date());
			pst.setString(24, teacher.getCreated_by());

			count = pst.executeUpdate();
			// con.commit();
		} catch (SQLException e) {
			LOGGER.info("While adding Teacher into Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);
	}

	@Override
	public boolean updateTeacher(Teacher teacher) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(UPDATE_TEACHER);
			pst.setString(1, teacher.getTeacherName());
			pst.setString(2, teacher.getFatherOrHusbundName());
			pst.setString(3, teacher.getReligion());
			pst.setString(4, teacher.getCaste());
			pst.setString(5, teacher.getGender());
			pst.setString(6, teacher.getMaritalStatus());
			pst.setDate(7, new java.sql.Date(teacher.getDateOfBirth().getTime()));
			pst.setDate(8, new java.sql.Date(teacher.getDateOfJoining().getTime()));
			pst.setString(9, teacher.getAddresss());
			pst.setString(10, teacher.getCity());
			pst.setString(11, teacher.getState());
			pst.setString(12, teacher.getNationality());
			pst.setLong(13, teacher.getPhone());
			pst.setString(14, teacher.getQualification());
			pst.setLong(15, teacher.getExperiance());
			pst.setString(16, teacher.getSubjects());
			pst.setString(17, teacher.getClasses());
			pst.setString(18, teacher.getClass_teacher());
			pst.setString(19, teacher.getDesignation());
			pst.setString(20, teacher.getUser_id());
			pst.setString(21, teacher.getPassword());
			pst.setDate(22, (Date) teacher.getUpdated_date());
			pst.setString(23, teacher.getUpdated_by());
			pst.setString(24, teacher.getEmployeeId());
			count = pst.executeUpdate();
			// con.commit();
		} catch (SQLException e) {
			LOGGER.info("While updating Teacher into Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);
	}

	@Override
	public boolean deleteTeacher(String jobId) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(DELETE_TEACHER);
			pst.setString(1, jobId);
			count = pst.executeUpdate();
			// con.commit();
		} catch (SQLException e) {
			LOGGER.info("While Deleting Teacher into database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);
	}

	@Override
	public List<Teacher> getTeachers() {
		List<Teacher> sList = new ArrayList<Teacher>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_TEACHERS);
			rs = pst.executeQuery();
			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setEmployeeId(rs.getString("EMP_ID"));
				teacher.setTeacherName(rs.getString("EMP_NAME"));
				teacher.setFatherOrHusbundName(rs.getString("FATHER_HUSBAND_NAME"));
				teacher.setReligion(rs.getString("RELIGION"));
				teacher.setCaste(rs.getString("CASTE"));
				teacher.setGender(rs.getString("GENDER"));
				teacher.setMaritalStatus(rs.getString("MARITAL_STATUS"));
				teacher.setDateOfBirth(rs.getDate("DOB"));
				teacher.setDateOfJoining(rs.getDate("DOJ"));
				teacher.setAddresss(rs.getString("ADDRESS"));
				teacher.setCity(rs.getString("CITY"));
				teacher.setState(rs.getString("STATE"));
				teacher.setNationality(rs.getString("NATIONALITY"));
				teacher.setPhone(rs.getLong("PHONE_NUMBER"));
				teacher.setQualification(rs.getString("QUALIFICATION"));
				teacher.setExperiance(rs.getLong("EXPERIENCE"));
				teacher.setSubjects(rs.getString("SUBJECTS"));
				teacher.setClasses(rs.getString("CLASSES_HANDLING"));
				teacher.setClass_teacher(rs.getString("CLASS_TEACHER"));
				teacher.setDesignation(rs.getString("DESIGNATION"));
				teacher.setUser_id(rs.getString("LOGIN_ID"));
				teacher.setPassword(rs.getString("PASSWORD"));
				sList.add(teacher);
			}
		} catch (SQLException e) {
			LOGGER.info("While getting all Teacher into Database: " + e.getMessage());
			e.printStackTrace();
		} finally {
			dbConnection.close(pst, con);
		}
		return sList;
	}

	@Override
	public Teacher getTeacher(String jobId) {
		Teacher teacher = new Teacher();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_TEACHER_BY_ID);
			pst.setString(1, jobId);
			rs = pst.executeQuery();
			while (rs.next()) {
				teacher.setEmployeeId(rs.getString("EMP_ID"));
				teacher.setTeacherName(rs.getString("EMP_NAME"));
				teacher.setFatherOrHusbundName(rs.getString("FATHER_HUSBAND_NAME"));
				teacher.setReligion(rs.getString("RELIGION"));
				teacher.setCaste(rs.getString("CASTE"));
				teacher.setGender(rs.getString("GENDER"));
				teacher.setMaritalStatus(rs.getString("MARITAL_STATUS"));
				teacher.setDateOfBirth(rs.getDate("DOB"));
				teacher.setDateOfJoining(rs.getDate("DOJ"));
				teacher.setAddresss(rs.getString("ADDRESS"));
				teacher.setCity(rs.getString("CITY"));
				teacher.setState(rs.getString("STATE"));
				teacher.setNationality(rs.getString("NATIONALITY"));
				teacher.setPhone(rs.getLong("PHONE_NUMBER"));
				teacher.setQualification(rs.getString("QUALIFICATION"));
				teacher.setExperiance(rs.getLong("EXPERIENCE"));
				teacher.setSubjects(rs.getString("SUBJECTS"));
				teacher.setClasses(rs.getString("CLASSES_HANDLING"));
				teacher.setClass_teacher(rs.getString("CLASS_TEACHER"));
				teacher.setDesignation(rs.getString("DESIGNATION"));
				teacher.setUser_id(rs.getString("LOGIN_ID"));
				teacher.setPassword(rs.getString("PASSWORD"));
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting Perticular Teacher into database:" + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return teacher;
	}

	@Override
	public String getEmpId(String empName) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String empId = "";
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_EMP_ID_BY_NAME);
			pst.setString(1, empName);
			rs = pst.executeQuery();
			while (rs.next()) {
				empId = rs.getString("EMP_ID");
			}
		} catch (SQLException e) {
			LOGGER.info("While getting Teacher name based on emp id into Database: " + e.getMessage());
			e.printStackTrace();
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return empId;
	}

	public String getEmpName(String empId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String empName = "";
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_EMP_NAME_BY_ID);
			pst.setString(1, empId);
			rs = pst.executeQuery();
			while (rs.next()) {
				empName = rs.getString("EMP_NAME");
			}
		} catch (SQLException e) {
			LOGGER.info("While getting Teacher name based on emp id into Database: " + e.getMessage());
			e.printStackTrace();
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return empName;
	}

	@Override
	public boolean isTeacherAvail(String empId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(IS_TEACHER_AVAILS);
			pst.setString(1, empId);
			rs = pst.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting perticular Teacher Info into database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return count == 0;
	}

}
