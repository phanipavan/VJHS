package com.vjhs.pojo;

import java.util.Date;

import javax.servlet.http.Part;

public class Student {

	private Part photo;
	private String admissionNo;
	private Date dateOfAdmission;
	private String studentName;
	private Date dateOfBirth;
	private String gender;
	private String nationality;
	private String state;
	private String religion;
	private String caste;
	private String coc;
	private String motherTongue;
	private String fatherName;
	private String motherName;
	private String residence;
	private String fatherOccupation;
	private String address;
	private long mobile;
	private String previousSchool;
	private Boolean tcYesNo;
	private Long tcNumber;
	private Date tcDate;
	private String classAdmitted;
	private String medium;
	private String identityMarks;
	private String currentClass;
	private Date creationDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private String attribute1;
	private String attribute2;
	private String attribute3;
	private String attribute4;
	private String attribute5;
	private boolean isAdded;

	public Student() {
		admissionNo = "";
		studentName = "";
		gender = "";
		nationality = "";
		state = "";
		religion = "";
		caste = "";
		coc = "";
		motherTongue = "";
		fatherName = "";
		motherName = "";
		residence = "";
		fatherOccupation = "";
		address = "";
		mobile = 0;
		previousSchool = "";
		tcYesNo = false;
		tcNumber = (long) 0;
		medium = "";
		identityMarks = "";
		currentClass = "";
		createdBy = "";
		updatedBy = "";
		attribute1 = "";
		attribute2 = "";
		attribute3 = "";
		attribute4 = "";
		attribute5 = "";
		isAdded = false;
	}

	/**
	 * @return the photo
	 */
	public Part getPhoto() {
		return photo;
	}

	/**
	 * @param photo2
	 *            the photo to set
	 */
	public void setPhoto(Part photo2) {
		this.photo = photo2;
	}

	/**
	 * @return the admissionNo
	 */
	public String getAdmissionNo() {
		return admissionNo;
	}

	/**
	 * @param admission_no
	 *            the admission_no to set
	 */
	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}

	/**
	 * @return the dateOfAdmission
	 */
	public Date getDateOfAdmission() {
		return dateOfAdmission;
	}

	/**
	 * @param dateOfAdmission
	 *            the dateOfAdmission to set
	 */
	public void setDateOfAdmission(Date dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
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
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality
	 *            the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the religion
	 */
	public String getReligion() {
		return religion;
	}

	/**
	 * @param religion
	 *            the religion to set
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}

	/**
	 * @return the caste
	 */
	public String getCaste() {
		return caste;
	}

	/**
	 * @param caste
	 *            the caste to set
	 */
	public void setCaste(String caste) {
		this.caste = caste;
	}

	/**
	 * @return the coc
	 */
	public String getCoc() {
		return coc;
	}

	/**
	 * @param coc
	 *            the coc to set
	 */
	public void setCoc(String coc) {
		this.coc = coc;
	}

	/**
	 * @return the motherTongue
	 */
	public String getMotherTongue() {
		return motherTongue;
	}

	/**
	 * @param motherTongue
	 *            the motherTongue to set
	 */
	public void setMotherTongue(String motherTongue) {
		this.motherTongue = motherTongue;
	}

	/**
	 * @return the fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}

	/**
	 * @param fatherName
	 *            the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	/**
	 * @return the motherName
	 */
	public String getMotherName() {
		return motherName;
	}

	/**
	 * @param motherName
	 *            the motherName to set
	 */
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	/**
	 * @return the residence
	 */
	public String getResidence() {
		return residence;
	}

	/**
	 * @param residence
	 *            the residence to set
	 */
	public void setResidence(String residence) {
		this.residence = residence;
	}

	/**
	 * @return the fatherOccupation
	 */
	public String getFatherOccupation() {
		return fatherOccupation;
	}

	/**
	 * @param fatherOccupation
	 *            the fatherOccupation to set
	 */
	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the mobile
	 */
	public long getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the previousSchool
	 */
	public String getPreviousSchool() {
		return previousSchool;
	}

	/**
	 * @param previousSchool
	 *            the previousSchool to set
	 */
	public void setPreviousSchool(String previousSchool) {
		this.previousSchool = previousSchool;
	}

	/**
	 * @return the tcYesNo
	 */
	public Boolean getTcYesNo() {
		return tcYesNo;
	}

	/**
	 * @param tcYesNo
	 *            the tcYesNo to set
	 */
	public void setTcYesNo(Boolean tcYesNo) {
		this.tcYesNo = tcYesNo;
	}

	/**
	 * @return the tcNumber
	 */
	public Long getTcNumber() {
		return tcNumber;
	}

	/**
	 * @param tcNumber
	 *            the tcNumber to set
	 */
	public void setTcNumber(Long tcNumber) {
		this.tcNumber = tcNumber;
	}

	/**
	 * @return the tcDate
	 */
	public Date getTcDate() {
		return tcDate;
	}

	/**
	 * @param tcDate
	 *            the tcDate to set
	 */
	public void setTcDate(Date tcDate) {
		this.tcDate = tcDate;
	}

	/**
	 * @return the classAdmitted
	 */
	public String getClassAdmitted() {
		return classAdmitted;
	}

	/**
	 * @param classAdmitted
	 *            the classAdmitted to set
	 */
	public void setClassAdmitted(String classAdmitted) {
		this.classAdmitted = classAdmitted;
	}

	/**
	 * @return the medium
	 */
	public String getMedium() {
		return medium;
	}

	/**
	 * @param medium
	 *            the medium to set
	 */
	public void setMedium(String medium) {
		this.medium = medium;
	}

	/**
	 * @return the identityMarks
	 */
	public String getIdentityMarks() {
		return identityMarks;
	}

	/**
	 * @param identityMarks
	 *            the identityMarks to set
	 */
	public void setIdentityMarks(String identityMarks) {
		this.identityMarks = identityMarks;
	}

	/**
	 * @return the currentClass
	 */
	public String getCurrentClass() {
		return currentClass;
	}

	/**
	 * @param currentClass
	 *            the currentClass to set
	 */
	public void setCurrentClass(String currentClass) {
		this.currentClass = currentClass;
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
	 * @return the isAdded
	 */
	public boolean isAdded() {
		return isAdded;
	}

	/**
	 * @param isAdded
	 *            the isAdded to set
	 */
	public void setAdded(boolean isAdded) {
		this.isAdded = isAdded;
	}

	/**
	 * @return the attributes
	 */
	public String getAttribute5() {
		return attribute5;
	}

	/**
	 * @param attributes
	 *            the attributes to set
	 */
	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [photo=" + photo + ", admissionNo=" + admissionNo + ", dateOfAdmission=" + dateOfAdmission
				+ ", studentName=" + studentName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", nationality=" + nationality + ", state=" + state + ", religion=" + religion + ", caste=" + caste
				+ ", coc=" + coc + ", motherTongue=" + motherTongue + ", fatherName=" + fatherName + ", motherName="
				+ motherName + ", residence=" + residence + ", fatherOccupation=" + fatherOccupation + ", address="
				+ address + ", mobile=" + mobile + ", previousSchool=" + previousSchool + ", tcYesNo=" + tcYesNo
				+ ", tcNumber=" + tcNumber + ", tcDate=" + tcDate + ", classAdmitted=" + classAdmitted + ", medium="
				+ medium + ", identityMarks=" + identityMarks + ", creationDate=" + creationDate + ", createdBy="
				+ createdBy + ", updatedDate=" + updatedDate + ", updatedBy=" + updatedBy + ", attribute1=" + attribute1
				+ ", attribute2=" + attribute2 + ", attribute3=" + attribute3 + ", attribute4=" + attribute4
				+ ", attribute5=" + attribute5 + "]";
	}

}
