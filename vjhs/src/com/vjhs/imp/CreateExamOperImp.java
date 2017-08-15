/**
 * 
 */
package com.vjhs.imp;

import static com.vjhs.interfaces.SQLQuery.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.vjhs.dao.DBConnection;
import com.vjhs.interfaces.CreateExamOperations;
import com.vjhs.pojo.CreateExam;

/**
 * @author wasimakram.sutar
 *
 */
public class CreateExamOperImp implements CreateExamOperations{
	DBConnection dbConnection = DBConnection.util;
	private static final Logger LOGGER = Logger.getLogger(CreateExamOperImp.class
			.getName());

	@Override
	public boolean addCreateExam(CreateExam createExam) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(ADD_EXAMS);
			pst.setString(1, createExam.getExamType());
			pst.setDate(2, createExam.getFromDate());
			pst.setDate(3, createExam.getToDate());
			pst.setDate(4, createExam.getCreationDate());
			pst.setString(5, createExam.getCreatedBy());
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
	public boolean updateCreateExam(CreateExam createExam) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(UPDATE_EXAMS);
			pst.setString(1, createExam.getExamType());
			pst.setDate(2, createExam.getFromDate());
			pst.setDate(3, createExam.getToDate());
			pst.setDate(6, createExam.getUpdatedDate());
			pst.setString(7, createExam.getUpdatedBy());
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
	
	

}
