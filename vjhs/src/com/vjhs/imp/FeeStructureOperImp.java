/**
 * 
 */
package com.vjhs.imp;

import static com.vjhs.interfaces.SQLQuery.ADD_FEESTRUCTURE;
import static com.vjhs.interfaces.SQLQuery.GET_FEESTRUCTURE;
import static com.vjhs.interfaces.SQLQuery.GET_FEESTRUCTURE_LIST;
import static com.vjhs.interfaces.SQLQuery.UPDATE_FEESTRUCTURE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.vjhs.dao.DBConnection;
import com.vjhs.interfaces.FeeStructureOperations;
import com.vjhs.pojo.FeeStructure;

/**
 * @author AMMA & NANNA
 *
 */
public class FeeStructureOperImp implements FeeStructureOperations {

	DBConnection dbConnection = DBConnection.util;
	private static final Logger LOGGER = Logger
			.getLogger(FeeStructureOperImp.class.getName());

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vjhs.interfaces.FeeStructureOperations#addFeeStructure(com.vjhs.pojo
	 * .FeeStructure)
	 */
	@Override
	public boolean addFeeStructure(FeeStructure feeStructure) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(ADD_FEESTRUCTURE);
			pst.setString(1, feeStructure.getClassName());
			pst.setDouble(2, feeStructure.getAdmissionFee());
			pst.setDouble(3, feeStructure.getApplicationFee());
			pst.setDouble(4, feeStructure.getTutionFee());
			pst.setDouble(5, feeStructure.getBooksFee());
			pst.setDouble(6, feeStructure.getExamFee());
			pst.setDouble(7, feeStructure.getOtherFee());
			pst.setDouble(8, feeStructure.getTotalFee());
			pst.setDate(9, feeStructure.getCreationDate());
			pst.setString(10, feeStructure.getCreatedBy());
			count = pst.executeUpdate();
			// con.commit();
		} catch (SQLException e) {
			LOGGER.info("While adding Overview into Database: "
					+ e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vjhs.interfaces.FeeStructureOperations#updateFeeStructure(com.vjhs
	 * .pojo.FeeStructure)
	 */
	@Override
	public boolean updateFeeStructure(FeeStructure feeStructure) {

		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(UPDATE_FEESTRUCTURE);
			pst.setDouble(1, feeStructure.getAdmissionFee());
			pst.setDouble(2, feeStructure.getApplicationFee());
			pst.setDouble(3, feeStructure.getTutionFee());
			pst.setDouble(4, feeStructure.getBooksFee());
			pst.setDouble(5, feeStructure.getExamFee());
			pst.setDouble(6, feeStructure.getOtherFee());
			pst.setDouble(7, feeStructure.getTotalFee());
			pst.setDate(8, feeStructure.getUpdatedDate());
			pst.setString(9, feeStructure.getUpdatedBy());
			pst.setString(10, feeStructure.getClassName());
			count = pst.executeUpdate();
			// con.commit();
		} catch (SQLException e) {
			LOGGER.info("While updating Overview into Database: "
					+ e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vjhs.interfaces.FeeStructureOperations#getFeeStructure(java.lang.
	 * String)
	 */
	@Override
	public FeeStructure getFeeStructure(String className) {
		FeeStructure feeStructure = new FeeStructure();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_FEESTRUCTURE);
			pst.setString(1, className);
			rs = pst.executeQuery();
			while (rs.next()) {
				feeStructure.setClassName(rs.getString("CLASS"));
				feeStructure.setAdmissionFee(rs.getDouble("ADMISSION_FEE"));
				feeStructure.setApplicationFee(rs.getDouble("APPLICATION_FEE"));
				feeStructure.setTutionFee(rs.getDouble("TUTION_FEE"));
				feeStructure.setBooksFee(rs.getDouble("BOOKS_FEE"));
				feeStructure.setExamFee(rs.getDouble("EXAM_FEE"));
				feeStructure.setOtherFee(rs.getDouble("OTHER_FEE"));
				feeStructure.setTotalFee(rs.getDouble("TOTAL_FEE"));
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting Overview into database:"
					+ e.getMessage());
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return feeStructure;
	}

	@Override
	public List<FeeStructure> getFeeStructureList() {
		List<FeeStructure> feeStructureList = new ArrayList<FeeStructure>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_FEESTRUCTURE_LIST);
			rs = pst.executeQuery();
			while (rs.next()) {
				FeeStructure feeStructure = new FeeStructure();
				feeStructure.setClassName(rs.getString("CLASS"));
				feeStructure.setAdmissionFee(rs.getDouble("ADMISSION_FEE"));
				feeStructure.setApplicationFee(rs.getDouble("APPLICATION_FEE"));
				feeStructure.setTutionFee(rs.getDouble("TUTION_FEE"));
				feeStructure.setBooksFee(rs.getDouble("BOOKS_FEE"));
				feeStructure.setExamFee(rs.getDouble("EXAM_FEE"));
				feeStructure.setOtherFee(rs.getDouble("OTHER_FEE"));
				feeStructure.setTotalFee(rs.getDouble("TOTAL_FEE"));
				feeStructureList.add(feeStructure);
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting Overview into database:"
					+ e.getMessage());
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return feeStructureList;
	}

}
