/**
 * 
 */
package com.vjhs.imp;

import static com.vjhs.interfaces.SQLQuery.ADD_CLASS_TIMETABLE;
import static com.vjhs.interfaces.SQLQuery.GET_CLASS_TIMETABLE_BY_CLASS;
import static com.vjhs.interfaces.SQLQuery.IS_CLASS_EXIT;
import static com.vjhs.interfaces.SQLQuery.UPDATE_CLASS_TIMETABLE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.vjhs.dao.DBConnection;
import com.vjhs.interfaces.ClassTimeTableOperation;
import com.vjhs.pojo.ClassTimeTable;

/**
 * @author wasimakram.sutar
 *
 */
public class ClassTimeTableOperImp implements ClassTimeTableOperation {
	DBConnection dbConnection = DBConnection.util;
	private static final Logger LOGGER = Logger.getLogger(ClassTimeTableOperImp.class.getName());

	@Override
	public boolean addClassTimeTable(List<ClassTimeTable> clsTTList) {
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst2 = null;
		int[] count, count2;
		boolean res = false;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(ADD_CLASS_TIMETABLE);
			pst2 = con.prepareStatement(UPDATE_CLASS_TIMETABLE);
			for (ClassTimeTable classTimeTable : clsTTList) {
				if (isClassAvail(classTimeTable.getClassName(), classTimeTable.getDay())) {
					pst2.setString(1, classTimeTable.getPeriodI());
					pst2.setString(2, classTimeTable.getPeriodII());
					pst2.setString(3, classTimeTable.getPeriodIII());
					pst2.setString(4, classTimeTable.getPeriodIV());
					pst2.setString(5, classTimeTable.getPeriodV());
					pst2.setString(6, classTimeTable.getPeriodVI());
					pst2.setString(7, classTimeTable.getPeriodVII());
					pst2.setString(8, classTimeTable.getPeriodVIII());
					pst2.setDate(9, classTimeTable.getUpdatedDate());
					pst2.setString(10, classTimeTable.getUpdatedBy());
					pst2.setString(11, classTimeTable.getClassName());
					pst2.setString(12, classTimeTable.getDay());
					pst2.addBatch();
				} else {
					pst.setString(1, classTimeTable.getClassName());
					pst.setString(2, classTimeTable.getDay());
					pst.setString(3, classTimeTable.getPeriodI());
					pst.setString(4, classTimeTable.getPeriodII());
					pst.setString(5, classTimeTable.getPeriodIII());
					pst.setString(6, classTimeTable.getPeriodIV());
					pst.setString(7, classTimeTable.getPeriodV());
					pst.setString(8, classTimeTable.getPeriodVI());
					pst.setString(9, classTimeTable.getPeriodVII());
					pst.setString(10, classTimeTable.getPeriodVIII());
					pst.setDate(11, classTimeTable.getCreationDate());
					pst.setString(12, classTimeTable.getCreatedBy());
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
			LOGGER.info("While Adding / Updating Class Timetable into Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst2);
			dbConnection.close(pst, con);
		}
		return res;
	}

	@Override
	public boolean isClassAvail(String cls, String day) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(IS_CLASS_EXIT);
			pst.setString(1, cls);
			pst.setString(2, day);
			rs = pst.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.info("While checking Class existance from Database: " + e.getMessage());
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return (count > 0);
	}

	@Override
	public boolean updateClassTimeTable(ClassTimeTable classTimeTable) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(UPDATE_CLASS_TIMETABLE);
			pst.setString(1, classTimeTable.getClassName());
			pst.setString(2, classTimeTable.getPeriodI());
			pst.setString(3, classTimeTable.getPeriodII());
			pst.setString(4, classTimeTable.getPeriodIII());
			pst.setString(5, classTimeTable.getPeriodIV());
			pst.setString(6, classTimeTable.getPeriodV());
			pst.setString(7, classTimeTable.getPeriodVI());
			pst.setString(8, classTimeTable.getPeriodVII());
			pst.setString(9, classTimeTable.getPeriodVIII());
			pst.setDate(12, classTimeTable.getUpdatedDate());
			pst.setString(13, classTimeTable.getUpdatedBy());
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
	public List<ClassTimeTable> getClassTimeTable(String className) {
		List<ClassTimeTable> clsTTList = new ArrayList<ClassTimeTable>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_CLASS_TIMETABLE_BY_CLASS);
			pst.setString(1, className);
			rs = pst.executeQuery();
			while (rs.next()) {
				ClassTimeTable clsTT = new ClassTimeTable();
				clsTT.setDay(rs.getString("DAY"));
				clsTT.setPeriodI(rs.getString("PERIOD_I"));
				clsTT.setPeriodII(rs.getString("PERIOD_II"));
				clsTT.setPeriodIII(rs.getString("PERIOD_III"));
				clsTT.setPeriodIV(rs.getString("PERIOD_IV"));
				clsTT.setPeriodV(rs.getString("PERIOD_V"));
				clsTT.setPeriodVI(rs.getString("PERIOD_VI"));
				clsTT.setPeriodVII(rs.getString("PERIOD_VII"));
				clsTT.setPeriodVIII(rs.getString("PERIOD_VIII"));
				clsTTList.add(clsTT);
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting Perticular Teacher into database:" + e.getMessage());
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return clsTTList;
	}

}
