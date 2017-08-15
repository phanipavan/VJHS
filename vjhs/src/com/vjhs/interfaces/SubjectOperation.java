/**
 * 
 */
package com.vjhs.interfaces;

import java.util.List;

import com.vjhs.pojo.Subject;

/**
 * @author wasimakram.sutar
 *
 */
public interface SubjectOperation {
	
	boolean addSubject(Subject subject);

	boolean updateSubject(Subject subject);
	
	boolean deleteSubject(String subjectId);
	
	Subject getSubject(String subjectId);
	
	List<Subject> getSubjects();

}
