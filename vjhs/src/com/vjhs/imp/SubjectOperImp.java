/**
 * 
 */
package com.vjhs.imp;

import static com.vjhs.interfaces.SQLQuery.ADD_SUBJECT;
import static com.vjhs.interfaces.SQLQuery.DELETE_SUBJECT;
import static com.vjhs.interfaces.SQLQuery.GET_SUBJECT;
import static com.vjhs.interfaces.SQLQuery.GET_SUBJECTS;
import static com.vjhs.interfaces.SQLQuery.UPDATE_SUBJECT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.vjhs.dao.DBConnection;
import com.vjhs.interfaces.SubjectOperation;
import com.vjhs.pojo.Subject;

/**
 * @author wasimakram.sutar
 *
 */
public class SubjectOperImp implements SubjectOperation {

	DBConnection dbConnection = DBConnection.util;
	private static final Logger LOGGER = Logger.getLogger(SubjectOperImp.class.getName());

	@Override
	public boolean addSubject(Subject subject) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(ADD_SUBJECT);
			pst.setString(1, subject.getSubjectId());
			pst.setString(2, subject.getSubjectName());
			pst.setDate(3, subject.getCreationDate());
			pst.setString(4, subject.getCreatedBy());

			count = pst.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			LOGGER.info("While adding Subject into Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);

	}

	@Override
	public boolean updateSubject(Subject subject) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(UPDATE_SUBJECT);
			pst.setString(1, subject.getSubjectName());
			pst.setDate(2, subject.getUpdatedDate());
			pst.setString(3, subject.getUpdatedBy());
			pst.setString(4, subject.getSubjectId());

			count = pst.executeUpdate();
			/* con.commit(); */
		} catch (SQLException e) {
			LOGGER.info("While updating subject in Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);
	}

	@Override
	public Subject getSubject(String subjectId) {
		Subject subject = new Subject();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_SUBJECT);
			rs = pst.executeQuery();
			while (rs.next()) {
				subject.setSubjectId(rs.getString("SUBJECT_ID"));
				subject.setSubjectName(rs.getString("SUBJECT_NAME"));
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting Subject from database:" + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return subject;
	}

	@Override
	public boolean deleteSubject(String subjectId) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(DELETE_SUBJECT);
			pst.setString(1, subjectId);
			count = pst.executeUpdate();
			//con.commit();
		} catch (SQLException e) {
			LOGGER.info("While Deleting Subject from database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);
	}

	@Override
	public List<Subject> getSubjects() {
		List<Subject> subList = new ArrayList<Subject>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_SUBJECTS);
			rs = pst.executeQuery();
			while (rs.next()) {
				Subject subject = new Subject();
				subject.setSubjectId(rs.getString("SUBJECT_ID"));
				subject.setSubjectName(rs.getString("SUBJECT_NAME"));
				subList.add(subject);
			}
		} catch (SQLException e) {
			LOGGER.info("While getting all subjects from Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return subList;

	}

}
