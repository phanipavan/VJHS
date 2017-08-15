/**
 * 
 */
package com.vjhs.interfaces;

import java.util.List;

import com.vjhs.pojo.ProgressReport;

/**
 * @author wasimakram.sutar
 *
 */
public interface ProgressReportOperations {
	boolean addProgressReport(List<ProgressReport> progressReport);

	boolean updateProgressReport(ProgressReport progressReport);

	boolean deleteProgressReport(String admissionNo);

	List<ProgressReport> getProgressReport(String admissionNo, String className, String examType);

	List<ProgressReport> getAllMarks(String admissionNo, String className);
}
