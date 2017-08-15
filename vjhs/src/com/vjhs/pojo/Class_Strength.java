/**
 * 
 */
package com.vjhs.pojo;

import java.sql.Date;

/**
 * @author wasimakram.sutar
 *
 */
public class Class_Strength {

	private String className;
	private int strength;
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
	 * @return the class_name
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param class_name
	 *            the class_name to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the strength
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * @param strength
	 *            the strength to set
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}

	/**
	 * @return the creation_date
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creation_date
	 *            the creation_date to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the created_by
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param created_by
	 *            the created_by to set
	 */
	public void setCreated_by(String createdBy) {
		this.createdBy = createdBy;
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
		return "Class_Strength [className=" + className + ", strength=" + strength + "]";
	}

	
}
