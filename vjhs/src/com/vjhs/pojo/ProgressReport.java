/**
 * 
 */
package com.vjhs.pojo;

import java.sql.Date;

/**
 * @author wasimakam.sutar
 *
 */
public class ProgressReport {

	private String examType;
	private String className;
	private String admissionNo;
	private String subject;
	private int marks;
	private String month;
	private String gradePoint;
	private Date creationDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;

	/**
	 * @return the examType
	 */
	public String getExamType() {
		return examType;
	}

	/**
	 * @param examType
	 *          the examType to set
	 */
	public void setExamType(String examType) {
		this.examType = examType;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className
	 *          the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the admissionNo
	 */
	public String getAdmissionNo() {
		return admissionNo;
	}

	/**
	 * @param admissionNo
	 *          the admissionNo to set
	 */
	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *          the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the marks
	 */
	public int getMarks() {
		return marks;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @param marks
	 *          the marks to set
	 */
	public void setMarks(int marks) {
		this.marks = marks;
	}

	/**
	 * @return the gradePoint
	 */
	public String getGradePoint() {
		return gradePoint;
	}

	/**
	 * @param gradePoint
	 *          the gradePoint to set
	 */
	public void setGradePoint(String gradePoint) {
		this.gradePoint = gradePoint;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *          the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *          the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate
	 *          the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy
	 *          the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProgressReport [examType=" + examType + ", className=" + className + ", admissionNo=" + admissionNo
		    + ", subject=" + subject + ", marks=" + marks + ", month=" + month + ", gradePoint=" + gradePoint + "]";
	}

}
