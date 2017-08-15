/**
 * 
 */
package com.vjhs.imp;

import static com.vjhs.interfaces.SQLQuery.ADD_CLASS_STRENGTH;
import static com.vjhs.interfaces.SQLQuery.GET_CLASS_STRENGTH;
import static com.vjhs.interfaces.SQLQuery.GET_CLASS_STRENGTH_LIST;
import static com.vjhs.interfaces.SQLQuery.UPDATE_CLASS_STRENGTH;
import static com.vjhs.interfaces.SQLQuery.GET_CLS_CNT_STR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.vjhs.dao.DBConnection;
import com.vjhs.interfaces.ClassStrengthOperations;
import com.vjhs.pojo.Class_Strength;

/**
 * @author wasimakram.sutar
 *
 */
public class ClassStrengthOperImp implements ClassStrengthOperations {

	DBConnection dbConnection = DBConnection.util;
	private static final Logger LOGGER = Logger.getLogger(ClassStrengthOperImp.class.getName());

	public boolean addClassStrength(Class_Strength classStrength) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(ADD_CLASS_STRENGTH);
			pst.setString(1, classStrength.getClassName());
			pst.setDouble(2, classStrength.getStrength());
			pst.setDate(3, classStrength.getCreationDate());
			pst.setString(4, classStrength.getCreatedBy());
			count = pst.executeUpdate();
			//con.commit();
		} catch (SQLException e) {
			LOGGER.info("While adding Overview into Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);

	}

	@Override
	public boolean updateClassStrength(Class_Strength classStrength) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(UPDATE_CLASS_STRENGTH);
			pst.setString(1, classStrength.getClassName());
			pst.setDouble(2, classStrength.getStrength());
			pst.setDate(5, classStrength.getUpdatedDate());
			pst.setString(6, classStrength.getUpdatedBy());
			count = pst.executeUpdate();
			//con.commit();
		} catch (SQLException e) {
			LOGGER.info("While updating Overview into Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);
	}

	@Override
	public Class_Strength getClassStrength(String className) {
		Class_Strength class_Strength = new Class_Strength();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_CLASS_STRENGTH);
			pst.setString(1, className);
			rs = pst.executeQuery();
			while (rs.next()) {
				class_Strength.setClassName(rs.getString("CLASS"));
				class_Strength.setStrength(rs.getInt("STRENGTH"));
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting Overview into database:" + e.getMessage());

		} finally {

			dbConnection.close(pst, con);
		}
		return class_Strength;
	}

	@Override
	public List<Class_Strength> getClassStrengthList() {

		List<Class_Strength> class_StrengthsList = new ArrayList<Class_Strength>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_CLASS_STRENGTH_LIST);
			rs = pst.executeQuery();
			while (rs.next()) {
				Class_Strength class_Strength = new Class_Strength();
				class_Strength.setClassName(rs.getString("CLASS"));
				class_Strength.setStrength(getClsStrength(class_Strength.getClassName()));
				System.out.println(class_Strength.toString());
				class_StrengthsList.add(class_Strength);
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting class strength list from database:" + e.getMessage());
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return class_StrengthsList;
	}

	private int getClsStrength(String className) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_CLS_CNT_STR);
			pst.setString(1, className);
			rs = pst.executeQuery();
			while (rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting class strength count from database:" + e.getMessage());
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return count;
	}

}
