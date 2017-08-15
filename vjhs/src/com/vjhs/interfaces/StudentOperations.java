package com.vjhs.interfaces;

import java.util.List;
import java.util.Map;

import com.vjhs.pojo.Student;

public interface StudentOperations {

	boolean addStudent(Student student);

	boolean updateStudent(Student student);

	boolean deleteStudent(String adminNo);

	List<Student> getStudents();

	List<Student> getStudentsByClass(int className);

	Student getStudent(String adminNo);

	List<String> getAdmissionNo(String cls,String name);

	Map<String, String> getStudentNames(String cls);
	
	List<String> getStudentAdminNo(String cls, String name);
	
	List<Student> getStudentAdminNoByClassName(String cls);
	
	boolean isStudentAvail(String adminNo);

}
