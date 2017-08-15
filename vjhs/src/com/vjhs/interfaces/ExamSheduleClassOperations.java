/**
 * 
 */
package com.vjhs.interfaces;

import java.util.Date;
import java.util.List;

import com.vjhs.pojo.ExamSheduleClass;
import com.vjhs.pojo.StudentAttendance;

/**
 * @author wasimakam.sutar
 *
 */
public interface ExamSheduleClassOperations {

	boolean addExamShedule(ExamSheduleClass examSheduleClass);

	boolean updateExamShedule(ExamSheduleClass examSheduleClass);

	int getHolidaysMonth(int year, int month);

	int getWorkingDaysMonth(int year, int month, int startDate, int holiday);

	List<StudentAttendance> getPresentMonthYear();

	String getMonthPercentage(String cls, String adminNo);

	String getMonthDetForProg(String cls,String adminNo,String month);
	
	int getAttendence(String cls, String adminNo, int month, int year);

	int getDateDiff(Date date1, Date date2);
	
	int getYearbyMonth(int month);
	
}
