/**
 * 
 */
package com.vjhs.pojo;

import java.sql.Date;

/**
 * @author wasimakram.sutar
 *
 */
public class StudentAttendance {
	private String admissionNo;
	private String className;
	private String studentName;
	private int year;
	private double dayAttended;
	private double workingDays;
	private double monthlyPercentage;
	private int month;
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
	 * @return the admissionNo
	 */
	public String getAdmissionNo() {
		return admissionNo;
	}

	/**
	 * @param admissionNo
	 *            the admissionNo to set
	 */
	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
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
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName
	 *            the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the dayAttended
	 */
	public double getDayAttended() {
		return dayAttended;
	}

	/**
	 * @param dayAttended
	 *            the dayAttended to set
	 */
	public void setDayAttended(double dayAttended) {
		this.dayAttended = dayAttended;
	}

	/**
	 * @return the workingDays
	 */
	public double getWorkingDays() {
		return workingDays;
	}

	/**
	 * @param workingDays
	 *            the workingDays to set
	 */
	public void setWorkingDays(double workingDays) {
		this.workingDays = workingDays;
	}

	/**
	 * @return the monthlyPercentage
	 */
	public double getMonthlyPercentage() {
		return monthlyPercentage;
	}

	/**
	 * @param monthlyPercentage
	 *            the monthlyPercentage to set
	 */
	public void setMonthlyPercentage(double monthlyPercentage) {
		this.monthlyPercentage = monthlyPercentage;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
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

	@Override
	public String toString() {
		return "StudentAttendance [admissionNo=" + admissionNo + ", className=" + className + ", year=" + year
				+ ", dayAttended=" + dayAttended + ", workingDays=" + workingDays + ", monthlyPercentage="
				+ monthlyPercentage + ", month=" + month + "]";
	}
	
	
}
