/**
 * 
 */
package com.vjhs.interfaces;

import java.util.List;

import com.vjhs.pojo.TeacherAttendance;

/**
 * @author wasimakram.sutar
 *
 */
public interface TeacherAttendanceOperations {

	boolean addTeacherAttandance(List<TeacherAttendance> techAttList);

	/* boolean updateTeacherAttandance(List<TeacherAttendance> techAttList); */

	List<TeacherAttendance> getAttenStatus(TeacherAttendance teachAtten);

	boolean isTeacherAvailable(TeacherAttendance teacherAttendance);

}
