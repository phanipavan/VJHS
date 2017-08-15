/**
 * 
 */
package com.vjhs.imp;

import static com.vjhs.interfaces.SQLQuery.ADD_LOGINADMIN;
import static com.vjhs.interfaces.SQLQuery.DELETE_LOGINADMIN;
import static com.vjhs.interfaces.SQLQuery.GET_ALLADMINUSERS;
import static com.vjhs.interfaces.SQLQuery.GET_LOGINADMIN;
import static com.vjhs.interfaces.SQLQuery.UPDATE_LOGINADMIN;
import static com.vjhs.interfaces.SQLQuery.GET_USER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.vjhs.dao.DBConnection;
import com.vjhs.interfaces.LoginAdminOperations;
import com.vjhs.pojo.LoginAdmin;

/**
 * @author Pavan
 *
 */
public class LoginAdminOperImp implements LoginAdminOperations {

	DBConnection dbConnection = DBConnection.util;
	private static final Logger LOGGER = Logger.getLogger(FeeStructureOperImp.class.getName());

	@Override
	public LoginAdmin getLoginDetails(String userName) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		LoginAdmin loginAdmin = new LoginAdmin();
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_LOGINADMIN);
			pst.setString(1, userName);
			rs = pst.executeQuery();
			while (rs.next()) {
				loginAdmin.setUserId(rs.getString("USER_ID"));
				loginAdmin.setUserName(rs.getString("USER_NAME"));
				loginAdmin.setPassword(rs.getString("PASSWORD"));
				loginAdmin.setRole(rs.getString("ROLE"));
				loginAdmin.setBranch(rs.getString("BRANCH"));
			}
		} catch (SQLException e) {
			LOGGER.info("While Retreving loginAdmin details from Database: " + e.getMessage());
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return loginAdmin;
	}

	@Override
	public boolean addUserAdmin(LoginAdmin loginAdmin) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(ADD_LOGINADMIN);
			/* pst.setString(1, loginAdmin.getUserId()); */
			pst.setString(1, loginAdmin.getName());
			pst.setString(2, loginAdmin.getEmail());
			pst.setString(3, loginAdmin.getUserName());
			pst.setString(4, loginAdmin.getPassword());
			pst.setString(5, loginAdmin.getRole());
			pst.setString(6, loginAdmin.getBranch());
			count = pst.executeUpdate();
			//con.commit();
		} catch (SQLException e) {
			LOGGER.info("While Adding LoginAdmin into Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);
	}

	@Override
	public boolean deleteUserAdmin(String userId) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(DELETE_LOGINADMIN);
			pst.setString(1, userId);
			count = pst.executeUpdate();
			//con.commit();
		} catch (SQLException e) {
			LOGGER.info("While Deleting AdminUser into database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);
	}

	@Override
	public List<LoginAdmin> getAllUserAdmins() {
		List<LoginAdmin> loginAdminList = new ArrayList<LoginAdmin>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_ALLADMINUSERS);
			rs = pst.executeQuery();
			while (rs.next()) {
				LoginAdmin loginAdmin = new LoginAdmin();
				loginAdmin.setUserId(rs.getString("USER_ID"));
				loginAdmin.setUserName(rs.getString("USER_NAME"));
				loginAdmin.setPassword(rs.getString("PASSWORD"));
				loginAdmin.setBranch(rs.getString("BRANCH"));
				loginAdminList.add(loginAdmin);
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting all AdminUsers from database: " + e.getMessage());
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return loginAdminList;
	}

	@Override
	public boolean updateUserAdmin(String userId) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(UPDATE_LOGINADMIN);
			pst.setString(1, userId);
			count = pst.executeUpdate();
			//con.commit();
		} catch (SQLException e) {
			LOGGER.info("While Updating LoginAdmin into Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);
	}

	@Override
	public boolean checkUser(String userName) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean isAvail = false;
		try {
			System.out.println("userName--java--"+userName);
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_USER);
			pst.setString(1, userName);
			rs = pst.executeQuery();
			while (rs.next()) {
				isAvail = true;
				System.out.println(rs.getString(1));
				System.out.println("isAvail----"+isAvail);
			}
		} catch (SQLException e) {
			LOGGER.info("While Retreving loginAdmin details from Database: " + e.getMessage());
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return isAvail;
	}

}
