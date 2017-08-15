package com.vjhs.dao;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;

public enum DBConnection {
	util;
	private static final Logger LOGGER = Logger.getLogger(DBConnection.class.getName());
	private static Properties properties = new Properties();

	static {
		try {
			InputStream inputStream = DBConnection.class.getResourceAsStream("db.properties");
			properties.load(inputStream);
			Class.forName(properties.getProperty("driverclass"));
		} catch (Exception e) {
			LOGGER.info("While loading the driver class " + e);
		}
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(properties.getProperty("url"), properties);
		} catch (SQLException e) {
			LOGGER.info("While connecting :" + e.getMessage());
		}
		return con;
	}

	public void close(ResultSet rs, Statement st, Connection con) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			LOGGER.info("While closing the resource " + e.getMessage());
		}
	}

	public void close(Statement st, Connection con) {
		try {

			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			LOGGER.info("While closing the resource " + e.getMessage());
		}
	}

	public void close(PreparedStatement pst, Connection con) {
		try {

			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			LOGGER.info("While closing the resource " + e.getMessage());
		}
	}

	public void close(ResultSet rs, PreparedStatement pst, Connection con) {
		try {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			LOGGER.info("While closing the resource " + e.getMessage());
		}
	}

	public void close(CallableStatement cst, Connection con) {
		try {
			if (cst != null)
				cst.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			LOGGER.info("While closing the resource " + e.getMessage());
		}
	}

	public void close(PreparedStatement pst) {
		try {
			if (pst != null)
				pst.close();
		} catch (Exception e) {
			LOGGER.info("While closing the resource " + e.getMessage());
		}
	}

	public void close(CallableStatement cst) {
		try {
			if (cst != null)
				cst.close();
		} catch (Exception e) {
			LOGGER.info("While closing the resource " + e.getMessage());
		}
	}

	public void close(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			LOGGER.info("While closing the resource " + e.getMessage());
		}
	}

	public void close(Connection con) {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			LOGGER.info("While closing the resource " + e.getMessage());
		}
	}
}