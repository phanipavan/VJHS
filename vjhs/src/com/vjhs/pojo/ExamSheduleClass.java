/**
 * 
 */
package com.vjhs.pojo;

import java.util.Date;

/**
 * @author wasimakram.sutar
 */
public class ExamSheduleClass {
	private String examType;
	private String examYear;
	private Date fromDate;
	private Date toDate;
	private String className;
	private int examNo;
	private String subject;
	private Date examDate;
	private String examTiming;
	private Date creationDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private String attribute1;
	private String attribute2;
	private String attribute3;
	private String attribute4;
	private String attributes;

	/**
	 * @return the examType
	 */
	public String getExamType() {
		return examType;
	}

	/**
	 * @param examType
	 *            the examType to set
	 */
	public void setExamType(String examType) {
		this.examType = examType;
	}

	/**
	 * @return the examYear
	 */
	public String getExamYear() {
		return examYear;
	}

	/**
	 * @param examYear
	 *            the examYear to set
	 */
	public void setExamYear(String examYear) {
		this.examYear = examYear;
	}

	/**
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate2
	 *            the fromDate to set
	 */
	public void setFromDate(Date fromDate2) {
		this.fromDate = fromDate2;
	}

	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate
	 *            the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className
	 *            the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the examNo
	 */
	public int getExamNo() {
		return examNo;
	}

	/**
	 * @param examNo
	 *            the examNo to set
	 */
	public void setExamNo(int examNo) {
		this.examNo = examNo;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the examDate
	 */
	public Date getExamDate() {
		return examDate;
	}

	/**
	 * @param examDate
	 *            the examDate to set
	 */
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	/**
	 * @return the examTiming
	 */
	public String getExamTiming() {
		return examTiming;
	}

	/**
	 * @param examTiming
	 *            the examTiming to set
	 */
	public void setExamTiming(String examTiming) {
		this.examTiming = examTiming;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set
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
	 *            the createdBy to set
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
	 *            the updatedDate to set
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
	 *            the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the attribute1
	 */
	public String getAttribute1() {
		return attribute1;
	}

	/**
	 * @param attribute1
	 *            the attribute1 to set
	 */
	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	/**
	 * @return the attribute2
	 */
	public String getAttribute2() {
		return attribute2;
	}

	/**
	 * @param attribute2
	 *            the attribute2 to set
	 */
	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	/**
	 * @return the attribute3
	 */
	public String getAttribute3() {
		return attribute3;
	}

	/**
	 * @param attribute3
	 *            the attribute3 to set
	 */
	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	/**
	 * @return the attribute4
	 */
	public String getAttribute4() {
		return attribute4;
	}

	/**
	 * @param attribute4
	 *            the attribute4 to set
	 */
	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	/**
	 * @return the attributes
	 */
	public String getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes
	 *            the attributes to set
	 */
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExamSheduleClass [examType=" + examType + ", examYear=" + examYear + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", className=" + className + ", examNo=" + examNo + ", subject=" + subject
				+ ", examDate=" + examDate + ", examTiming=" + examTiming + ", creationDate=" + creationDate
				+ ", createdBy=" + createdBy + ", updatedDate=" + updatedDate + ", updatedBy=" + updatedBy
				+ ", attribute1=" + attribute1 + ", attribute2=" + attribute2 + ", attribute3=" + attribute3
				+ ", attribute4=" + attribute4 + ", attributes=" + attributes + "]";
	}

}
