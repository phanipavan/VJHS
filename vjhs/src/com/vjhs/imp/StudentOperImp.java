package com.vjhs.imp;

import static com.vjhs.interfaces.SQLQuery.ADD_STUDENT;
import static com.vjhs.interfaces.SQLQuery.ADD_VIEW_STUDENT;
import static com.vjhs.interfaces.SQLQuery.DELETE_STUDENT;
import static com.vjhs.interfaces.SQLQuery.DELETE_VIEW_STUDENT;
import static com.vjhs.interfaces.SQLQuery.GET_ADMISSION_NO;
import static com.vjhs.interfaces.SQLQuery.GET_STUDENTS;
import static com.vjhs.interfaces.SQLQuery.GET_STUDENTS_BY_CLASS;
import static com.vjhs.interfaces.SQLQuery.GET_STUDENT_ADMIN_NO_BY_NAME_CLASS;
import static com.vjhs.interfaces.SQLQuery.GET_STUDENT_BY_ID;
import static com.vjhs.interfaces.SQLQuery.GET_STUDENT_NAME_BY_CLASS;
import static com.vjhs.interfaces.SQLQuery.UPDATE_VIEW_STUDENT;
import static com.vjhs.interfaces.SQLQuery.GET_STUDENT_REGNO_BY_CLASS;
import static com.vjhs.interfaces.SQLQuery.IS_STUDENT_AVAIL;
import static com.vjhs.interfaces.SQLQuery.UPDATE_STUDENT;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.Part;

import com.vjhs.dao.DBConnection;
import com.vjhs.interfaces.StudentOperations;
import com.vjhs.pojo.Student;

public class StudentOperImp implements StudentOperations {

	DBConnection dbConnection = DBConnection.util;
	private static final Logger LOGGER = Logger.getLogger(StudentOperImp.class.getName());

	@Override
	public boolean addStudent(Student student) {
		Connection con = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst1 = con.prepareStatement(ADD_STUDENT);
			try {
				pst1.setBinaryStream(1, student.getPhoto().getInputStream(), (int) student.getPhoto().getSize());
			} catch (IOException e) {
				LOGGER.info("While converstion part to binaryStream" + e.getMessage());
			}
			pst1.setString(2, student.getAdmissionNo());
			pst1.setDate(3, new java.sql.Date(student.getDateOfAdmission().getTime()));
			pst1.setString(4, student.getStudentName());
			pst1.setDate(5, new java.sql.Date(student.getDateOfBirth().getTime()));
			pst1.setString(6, student.getGender());
			pst1.setString(7, student.getNationality());
			pst1.setString(8, student.getState());
			pst1.setString(9, student.getReligion());
			pst1.setString(10, student.getCaste());
			pst1.setString(11, student.getCoc());
			pst1.setString(12, student.getMotherTongue());
			pst1.setString(13, student.getFatherName());
			pst1.setString(14, student.getMotherName());
			pst1.setString(15, student.getResidence());
			pst1.setString(16, student.getFatherOccupation());
			pst1.setString(17, student.getAddress());
			pst1.setLong(18, student.getMobile());
			pst1.setString(19, student.getPreviousSchool());
			pst1.setLong(20, student.getTcNumber());
			if (student.getTcDate() != null) {
				pst1.setDate(21, new java.sql.Date(student.getTcDate().getTime()));
			} else {
				pst1.setDate(21, null);
			}
			pst1.setString(22, student.getClassAdmitted());
			pst1.setString(23, student.getMedium());
			pst1.setString(24, student.getIdentityMarks());
			pst1.setDate(25, (Date) student.getCreationDate());
			pst1.setString(26, student.getCreatedBy());

			count = pst1.executeUpdate();
			// con.commit();
			if (count > 0) {
				try {

					pst2 = con.prepareStatement(ADD_VIEW_STUDENT);
					pst2.setString(1, student.getAdmissionNo());
					pst2.setString(2, student.getStudentName());
					pst2.setDate(3, new java.sql.Date(student.getDateOfBirth().getTime()));
					pst2.setString(4, student.getGender());
					pst2.setString(5, student.getFatherName());
					pst2.setString(6, student.getMotherName());
					pst2.setString(7, student.getResidence());
					pst2.setLong(8, student.getMobile());
					pst2.setString(9, student.getClassAdmitted());
					pst2.setString(10, student.getClassAdmitted());
					pst2.setString(11, student.getCoc());
					pst2.setDate(12, (Date) student.getCreationDate());
					pst2.setString(13, student.getCreatedBy());
					count = pst2.executeUpdate();
					// con.commit();
				} catch (SQLException e) {
					LOGGER.info("While Adding Student into Database: " + e.getMessage());
				} finally {
					dbConnection.close(pst2, con);
				}
			}
		} catch (SQLException e) {
			LOGGER.info("While Adding Student into Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst1, con);
		}
		return (count > 0);
	}

	@Override
	public boolean updateStudent(Student student) {
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst2 = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(UPDATE_STUDENT);
			try {
				pst.setBinaryStream(1, student.getPhoto().getInputStream(), (int) student.getPhoto().getSize());
			} catch (IOException e) {
				LOGGER.info("While converstion part to binaryStream" + e.getMessage());
			}
			pst.setDate(2, new java.sql.Date(student.getDateOfAdmission().getTime()));
			pst.setString(3, student.getStudentName());
			pst.setDate(4, new java.sql.Date(student.getDateOfBirth().getTime()));
			pst.setString(5, student.getGender());
			pst.setString(6, student.getNationality());
			pst.setString(7, student.getState());
			pst.setString(8, student.getReligion());
			pst.setString(9, student.getCaste());
			pst.setString(10, student.getCoc());
			pst.setString(11, student.getMotherTongue());
			pst.setString(12, student.getFatherName());
			pst.setString(13, student.getMotherName());
			pst.setString(14, student.getResidence());
			pst.setString(15, student.getFatherOccupation());
			pst.setString(16, student.getAddress());
			pst.setLong(17, student.getMobile());
			pst.setString(18, student.getPreviousSchool());
			pst.setLong(19, student.getTcNumber());
			if (student.getTcDate() != null) {
				pst.setDate(20, new java.sql.Date(student.getTcDate().getTime()));
			} else {
				pst.setDate(20, null);
			}
			pst.setString(21, student.getClassAdmitted());
			pst.setString(22, student.getMedium());
			pst.setString(23, student.getIdentityMarks());
			pst.setDate(24, (Date) student.getUpdatedDate());
			pst.setString(25, student.getUpdatedBy());
			pst.setString(26, student.getAdmissionNo());
			count = pst.executeUpdate();
			// con.commit();
			if (count > 0) {
				try {
					pst2 = con.prepareStatement(UPDATE_VIEW_STUDENT);
					pst2.setString(1, student.getStudentName());
					pst2.setDate(2, new java.sql.Date(student.getDateOfBirth().getTime()));
					pst2.setString(3, student.getGender());
					pst2.setString(4, student.getFatherName());
					pst2.setString(5, student.getMotherName());
					pst2.setString(6, student.getResidence());
					pst2.setLong(7, student.getMobile());
					pst2.setString(8, student.getClassAdmitted());
					pst2.setString(9, student.getClassAdmitted());
					pst2.setString(10, student.getCoc());
					pst2.setDate(11, (Date) student.getUpdatedDate());
					pst2.setString(12, student.getUpdatedBy());
					pst2.setString(13, student.getAdmissionNo());
					count = pst2.executeUpdate();
					// con.commit();
				} catch (SQLException e) {
					LOGGER.info("While Updating View-Student into Database: " + e.getMessage());
				} finally {
					dbConnection.close(pst2, con);
				}
			}
		} catch (SQLException e) {
			LOGGER.info("While Updating Student into database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);
	}

	@Override
	public boolean deleteStudent(String adminNo) {
		Connection con = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst1 = con.prepareStatement(DELETE_VIEW_STUDENT);
			pst1.setString(1, adminNo);
			count = pst1.executeUpdate();
			// con.commit();
			if (count > 0) {
				try {
					pst2 = con.prepareStatement(DELETE_STUDENT);
					pst2.setString(1, adminNo);
					count = pst2.executeUpdate();
					// con.commit();
				} catch (SQLException e) {
					LOGGER.info("While Deleting Student into database: " + e.getMessage());
				} finally {
					dbConnection.close(pst2, con);
				}
			}
		} catch (SQLException e) {
			LOGGER.info("While Deleting Student into database: " + e.getMessage());
		} finally {
			dbConnection.close(pst1, con);
		}
		return (count > 0);
	}

	@Override
	public List<Student> getStudents() {
		List<Student> sList = new ArrayList<Student>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_STUDENTS);
			rs = pst.executeQuery();
			while (rs.next()) {
				// ADMISSION_NUMBER, STUDENT_NAME, DOB,CASTE_CATEGORY, GENDER,
				// FATHER_NAME, PHONE_NUMBER, CURRENT_CLASS
				Student student = new Student();
				student.setAdmissionNo(rs.getString("ADMISSION_NUMBER"));
				student.setStudentName(rs.getString("STUDENT_NAME"));
				student.setDateOfBirth(rs.getDate("DOB"));
				student.setCoc(rs.getString("CASTE_CATEGORY"));
				student.setGender(rs.getString("GENDER"));
				student.setFatherName(rs.getString("FATHER_NAME"));
				student.setMobile(rs.getLong("PHONE_NUMBER"));
				student.setCurrentClass(rs.getString("CURRENT_CLASS"));

				sList.add(student);
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting all Students into database: " + e.getMessage());
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return sList;
	}

	@Override
	public List<Student> getStudentsByClass(int className) {
		List<Student> sListByClass = new ArrayList<Student>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_STUDENTS_BY_CLASS);
			pst.setInt(1, className);
			rs = pst.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				// add data to Student POJO
				student.setPhoto((Part) rs.getBlob("PHOTO"));
				student.setAdmissionNo(rs.getString("ADMISSION_NUMBER"));
				student.setDateOfAdmission(rs.getDate("DOJ"));
				student.setStudentName(rs.getString("STUDENT_NAME"));
				student.setDateOfBirth(rs.getDate("DOB"));
				student.setGender(rs.getString("GENDER"));
				student.setNationality(rs.getString("NATIONALITY"));
				student.setState(rs.getString("STATE"));
				student.setReligion(rs.getString("RELIGION"));
				student.setCaste(rs.getString("CASTE"));
				student.setCoc(rs.getString("CASTE_CATEGORY"));
				student.setMotherTongue(rs.getString("MOTHER_TOUNGE"));
				student.setFatherName(rs.getString("FATHER_NAME"));
				student.setMotherName(rs.getString("MOTHER_NAME"));
				student.setResidence(rs.getString("RESIDENCE"));
				student.setFatherOccupation(rs.getString("FATHER_OCCUPATION"));
				student.setAddress(rs.getString("FATHER_RESIDENCE"));
				student.setMobile(rs.getLong("PHONE_NUMBER"));
				student.setPreviousSchool(rs.getString("SCHOOLS_PREVIOUS"));
				student.setTcNumber(rs.getLong("TC_NUMBER"));
				student.setTcDate(rs.getDate("TC_DATE"));
				student.setClassAdmitted(rs.getString("CLASS_ADMITTED"));
				student.setMedium(rs.getString("MEDIUM"));
				student.setIdentityMarks(rs.getString("IDENTITY_MARKS"));
				sListByClass.add(student);
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting Students from perticular Class into database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return sListByClass;
	}

	@Override
	public Student getStudent(String adminNo) {
		Student student = new Student();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_STUDENT_BY_ID);
			pst.setString(1, adminNo);
			rs = pst.executeQuery();
			while (rs.next()) {
				// add data to Student POJO
				// student.setPhoto((Part) rs.getBlob("PHOTO"));
				student.setAdmissionNo(rs.getString("ADMISSION_NUMBER"));
				student.setDateOfAdmission(rs.getDate("DOJ"));
				student.setStudentName(rs.getString("STUDENT_NAME"));
				student.setDateOfBirth(rs.getDate("DOB"));
				student.setGender(rs.getString("GENDER"));
				student.setNationality(rs.getString("NATIONALITY"));
				student.setState(rs.getString("STATE"));
				student.setReligion(rs.getString("RELIGION"));
				student.setCaste(rs.getString("CASTE"));
				student.setCoc(rs.getString("CASTE_CATEGORY"));
				student.setMotherTongue(rs.getString("MOTHER_TOUNGE"));
				student.setFatherName(rs.getString("FATHER_NAME"));
				student.setMotherName(rs.getString("MOTHER_NAME"));
				student.setResidence(rs.getString("RESIDENCE"));
				student.setFatherOccupation(rs.getString("FATHER_OCCUPATION"));
				student.setAddress(rs.getString("FATHER_RESIDENCE"));
				student.setMobile(rs.getLong("PHONE_NUMBER"));
				student.setPreviousSchool(rs.getString("SCHOOLS_PREVIOUS"));
				student.setTcNumber(rs.getLong("TC_NUMBER"));
				student.setTcDate(rs.getDate("TC_DATE"));
				student.setClassAdmitted(rs.getString("CLASS_ADMITTED"));
				student.setMedium(rs.getString("MEDIUM"));
				student.setIdentityMarks(rs.getString("IDENTITY_MARKS"));
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting perticular Student Info into database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return student;
	}

	@Override
	public List<String> getAdmissionNo(String cls, String name) {
		List<String> admissionNo = new ArrayList<String>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_ADMISSION_NO);
			pst.setString(1, cls);
			pst.setString(2, name);
			rs = pst.executeQuery();
			while (rs.next()) {
				admissionNo.add(rs.getString("ADMISSION_NUMBER"));
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting perticular Student Info into database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return admissionNo;
	}

	@Override
	public Map<String, String> getStudentNames(String cls) {
		Map<String, String> studentNamesList = new HashMap<String, String>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_STUDENT_NAME_BY_CLASS);
			pst.setString(1, cls);
			rs = pst.executeQuery();
			while (rs.next()) {
				studentNamesList.put(rs.getString("ADMISSION_NUMBER"), rs.getString("STUDENT_NAME"));
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting perticular Student Info into database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return studentNamesList;
	}

	@Override
	public List<String> getStudentAdminNo(String cls, String name) {
		List<String> stdAdmissionList = new ArrayList<String>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_STUDENT_ADMIN_NO_BY_NAME_CLASS);
			pst.setString(1, cls);
			pst.setString(2, name);
			rs = pst.executeQuery();
			while (rs.next()) {
				stdAdmissionList.add(rs.getString("ADMISSION_NUMBER"));
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting perticular Student Info into database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return stdAdmissionList;
	}

	@Override
	public List<Student> getStudentAdminNoByClassName(String cls) {
		List<Student> stdAdmissionList = new ArrayList<Student>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_STUDENT_REGNO_BY_CLASS);
			pst.setString(1, cls);
			rs = pst.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setAdmissionNo(rs.getString("ADMISSION_NUMBER"));
				student.setStudentName(rs.getString("STUDENT_NAME"));
				stdAdmissionList.add(student);
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting perticular Student Info into database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return stdAdmissionList;
	}

	@Override
	public boolean isStudentAvail(String adminNo) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(IS_STUDENT_AVAIL);
			pst.setString(1, adminNo);
			rs = pst.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting perticular Student Info into database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return count == 0;
	}
}