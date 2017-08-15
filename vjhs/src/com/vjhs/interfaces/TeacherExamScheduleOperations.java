/**
 * 
 */
package com.vjhs.interfaces;

import java.util.List;

import com.vjhs.pojo.ExamScheduleTeacher;


/**
 * @author wasimakram.sutar
 *
 */
public interface TeacherExamScheduleOperations {
	
	boolean addTeacherExamSchedule(ExamScheduleTeacher examScheduleTeacher);

	boolean updateTeacherExamSchedule(ExamScheduleTeacher examScheduleTeacher);
	
	boolean deleteTeacherExamSchedule(String employeeId);
	
	List<ExamScheduleTeacher> getTeacherExamSchedule(String employeeId);
}
