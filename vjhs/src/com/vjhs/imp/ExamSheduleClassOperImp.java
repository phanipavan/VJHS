/**
 * 
 */
package com.vjhs.imp;

import static com.vjhs.interfaces.SQLQuery.ADD_EXAM_SCHEDULE;
import static com.vjhs.interfaces.SQLQuery.GET_HOLIDAY_MONTH;
import static com.vjhs.interfaces.SQLQuery.GET_PRESENT_YEAR_MONTH;
import static com.vjhs.interfaces.SQLQuery.GET_STUDENT_ATTENDED_DAYS;
import static com.vjhs.interfaces.SQLQuery.UPDATE_EXAM_SCHEDULE;
import static com.vjhs.interfaces.SQLQuery.GET_YEAR_BY_MONTH;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.vjhs.dao.DBConnection;
import com.vjhs.interfaces.ExamSheduleClassOperations;
import com.vjhs.pojo.ExamSheduleClass;
import com.vjhs.pojo.StudentAttendance;

/**
 * @author wasiakram.sutar
 *
 */
public class ExamSheduleClassOperImp implements ExamSheduleClassOperations {
	DBConnection dbConnection = DBConnection.util;
	private static final Logger LOGGER = Logger.getLogger(ExamSheduleClassOperImp.class.getName());

	@Override
	public boolean addExamShedule(ExamSheduleClass examSheduleClass) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(ADD_EXAM_SCHEDULE);
			pst.setString(1, examSheduleClass.getExamType());
			pst.setDate(2, (java.sql.Date) examSheduleClass.getFromDate());
			pst.setDate(3, (java.sql.Date) examSheduleClass.getToDate());
			pst.setString(4, examSheduleClass.getClassName());
			pst.setDouble(5, examSheduleClass.getExamNo());
			pst.setString(6, examSheduleClass.getSubject());
			pst.setDate(7, (java.sql.Date) examSheduleClass.getExamDate());
			pst.setDate(8, (java.sql.Date) examSheduleClass.getCreationDate());
			pst.setString(9, examSheduleClass.getCreatedBy());
			count = pst.executeUpdate();
			/* con.commit(); */
		} catch (SQLException e) {
			LOGGER.info("While adding Overview into Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);

	}

	@Override
	public boolean updateExamShedule(ExamSheduleClass examSheduleClass) {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(UPDATE_EXAM_SCHEDULE);
			pst.setString(1, examSheduleClass.getExamType());
			pst.setDate(2, (java.sql.Date) examSheduleClass.getFromDate());
			pst.setDate(3, (java.sql.Date) examSheduleClass.getToDate());
			pst.setString(4, examSheduleClass.getClassName());
			pst.setDouble(5, examSheduleClass.getExamNo());
			pst.setString(6, examSheduleClass.getSubject());
			pst.setDate(7, (java.sql.Date) examSheduleClass.getExamDate());
			pst.setDate(8, (java.sql.Date) examSheduleClass.getUpdatedDate());
			pst.setString(9, examSheduleClass.getUpdatedBy());
			count = pst.executeUpdate();
			/* con.commit(); */
		} catch (SQLException e) {
			LOGGER.info("While adding Overview into Database: " + e.getMessage());
		} finally {
			dbConnection.close(pst, con);
		}
		return (count > 0);

	}

	@Override
	public int getHolidaysMonth(int year, int month) {
		int holidays = 0;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_HOLIDAY_MONTH);
			pst.setInt(1, month);
			pst.setInt(2, year);
			rs = pst.executeQuery();
			while (rs.next()) {
				holidays = rs.getInt("HOLIDAYS");
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting holidays from database: " + e.getMessage());
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return holidays;
	}

	@Override
	public int getWorkingDaysMonth(int year, int month, int startDate, int holiday) {
		int count = 0;
		Calendar cal = new GregorianCalendar(year, month, startDate);
		// Get the number of days in that month
		int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// stop when we reach the start of the next month
		do {
			// get the day of the week for the current day
			int day = cal.get(Calendar.DAY_OF_WEEK);
			// check if it is a Sunday
			if (day == Calendar.SUNDAY) {
				count++;
			}
			// advance to the next day
			cal.add(Calendar.DAY_OF_YEAR, 1);
		} while (cal.get(Calendar.MONTH) == month);
		daysInMonth = daysInMonth - (count + holiday);
		return daysInMonth;
	}

	@Override
	public List<StudentAttendance> getPresentMonthYear() {
		List<StudentAttendance> presentMonthyear = new ArrayList<StudentAttendance>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_PRESENT_YEAR_MONTH);
			rs = pst.executeQuery();
			while (rs.next()) {
				StudentAttendance stuAtten = new StudentAttendance();
				stuAtten.setMonth(rs.getInt("MONTH"));
				stuAtten.setYear(rs.getInt("YEAR"));
				presentMonthyear.add(stuAtten);
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting holidays from database: " + e.getMessage());
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return presentMonthyear;
	}

	@Override
	public String getMonthPercentage(String cls, String adminNo) {
		List<StudentAttendance> presentWorkingYear = getPresentMonthYear();
		double workingDays = 0;
		int holidaysMonth = 0;
		double presentDays = 0;
		double percentage = 0;
		String attendence = "<STU_ATTENDANCE>";
		int count = 0;
		double totCumulative = 0;
		double cumulative = 0;
		boolean isTotCumulated = false;
		int listSize = presentWorkingYear.size();
		for (StudentAttendance stuAtten : presentWorkingYear) {
			percentage = 0;
			workingDays = 0;
			presentDays = 0;
			cumulative = 0;
			holidaysMonth = getHolidaysMonth(stuAtten.getYear(), stuAtten.getMonth());
			workingDays = getWorkingDaysMonth(stuAtten.getYear(), stuAtten.getMonth(), 1, holidaysMonth);
			presentDays = getAttendence(cls, adminNo, stuAtten.getMonth(), stuAtten.getYear());
			if (presentDays != 0) {
				percentage = Math.round(presentDays * 100) / workingDays;
				percentage = roundDoubleValue(percentage, 2);
				totCumulative += percentage;
			}
			if ((presentDays == 0 && !isTotCumulated) || (!isTotCumulated && listSize == count + 1)) {
				if (listSize == count + 1) {
					count++;
				}
				cumulative = totCumulative / count;
				cumulative = roundDoubleValue(cumulative, 2);
				isTotCumulated = true;
			}
			count++;
			attendence += "<MONTH_ATTEN><PRESENT_DAYS>" + presentDays + "</PRESENT_DAYS><WORKING_DAYS>" + workingDays
					+ "</WORKING_DAYS><PERCENTAGE>" + percentage + "</PERCENTAGE><VALUE>" + cumulative
					+ "</VALUE></MONTH_ATTEN>";
			cumulative = 0;
		}
		attendence += "</STU_ATTENDANCE>";
		return attendence;
	}

	public double roundDoubleValue(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	@Override
	public int getAttendence(String cls, String adminNo, int month, int year) {
		int presentDays = 0;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_STUDENT_ATTENDED_DAYS);
			pst.setString(1, adminNo);
			pst.setInt(2, month);
			pst.setString(3, cls);
			pst.setInt(4, year);
			rs = pst.executeQuery();
			while (rs.next()) {
				presentDays = rs.getInt("DAYS_ATTENDED");
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting Attendance from database: " + e.getMessage());
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return presentDays;
	}

	@Override
	public int getDateDiff(Date date1, Date date2) {
		int diffDays = 0;
		try {
			long diff = date2.getTime() - date1.getTime();
			diffDays = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			LOGGER.info("While Getting differnece from two dates: " + e.getMessage());
		}
		return diffDays;
	}

	@Override
	public String getMonthDetForProg(String cls, String adminNo, String month) {
		int monthInt = Integer.parseInt(month);
		int year = getYearbyMonth(Integer.parseInt(month));
		double workingDays = 0;
		int holidaysMonth = 0;
		double presentDays = 0;
		double percentage = 0;
		String attendence = "<STU_ATTENDANCE>";
		if (year != -1) {
			holidaysMonth = getHolidaysMonth(year, monthInt);
			workingDays = getWorkingDaysMonth(year, monthInt, 1, holidaysMonth);
			presentDays = getAttendence(cls, adminNo, monthInt, year);
			attendence += "<MONTH_ATTEN><PRESENT_DAYS>" + presentDays + "</PRESENT_DAYS><WORKING_DAYS>" + workingDays
					+ "</WORKING_DAYS><PERCENTAGE>" + percentage + "</PERCENTAGE></MONTH_ATTEN>";
		}
		attendence += "</STU_ATTENDANCE>";
		return attendence;
	}

	@Override
	public int getYearbyMonth(int month) {
		int year = -1;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.getConnection();
			pst = con.prepareStatement(GET_YEAR_BY_MONTH);
			pst.setInt(1, month);
			rs = pst.executeQuery();
			while (rs.next()) {
				year = rs.getInt("YEAR");
			}
		} catch (SQLException e) {
			LOGGER.info("While Getting holidays from database: " + e.getMessage());
		} finally {
			dbConnection.close(rs, pst, con);
		}
		return year;
	}

}
