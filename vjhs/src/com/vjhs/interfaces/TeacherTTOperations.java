package com.vjhs.interfaces;

import java.util.List;

import com.vjhs.pojo.TeacherTT;

public interface TeacherTTOperations {

	boolean addTimeTable(List<TeacherTT> teacherTTList);

	boolean updateTimeTable(List<TeacherTT> teacherTTList);

	boolean deleteTimeTable(String jobId);

	List<TeacherTT> getTimeTableByJobId(String jobId);

	boolean isTchrTTExist(String day, String empId);
}
