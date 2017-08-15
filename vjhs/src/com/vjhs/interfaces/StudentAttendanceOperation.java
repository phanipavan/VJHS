/**
 * 
 */
package com.vjhs.interfaces;

import java.util.List;

import com.vjhs.pojo.StudentAttendance;

/**
 * @author wasimakram.sutar
 *
 */
public interface StudentAttendanceOperation {

	boolean addStudentAttendance(List<StudentAttendance> studentAttendance);

	boolean updateStudentAttendence(List<StudentAttendance> studentAttendance);

	String getAttenStatus(String reqDate);
}
