package com.vjhs.interfaces;

import java.util.List;

import com.vjhs.pojo.Teacher;

public interface TeacherOperations {

	boolean addTeacher(Teacher teacher);

	boolean updateTeacher(Teacher teacher);

	boolean deleteTeacher(String jobId);

	List<Teacher> getTeachers();

	Teacher getTeacher(String jobId);

	String getEmpId(String empName);

	boolean isTeacherAvail(String empId);
}