/**
 * 
 */
package com.vjhs.pojo;

/**
 * @author Pavan
 *
 */
public class LoginAdmin {

	private String userId;
	private String userName;
	private String password;
	private String name;
	private String email;
	private String branch;
	private String role;
	private String attribute1;
	private String attribute2;
	private String attribute3;
	private String attribute4;
	private String attribute5;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @return the attribute1
	 */
	public String getAttribute1() {
		return attribute1;
	}

	/**
	 * @return the attribute2
	 */
	public String getAttribute2() {
		return attribute2;
	}

	/**
	 * @return the attribute3
	 */
	public String getAttribute3() {
		return attribute3;
	}

	/**
	 * @return the attribute4
	 */
	public String getAttribute4() {
		return attribute4;
	}

	/**
	 * @return the attribute5
	 */
	public String getAttribute5() {
		return attribute5;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param branch
	 *            the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @param attribute1
	 *            the attribute1 to set
	 */
	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	/**
	 * @param attribute2
	 *            the attribute2 to set
	 */
	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	/**
	 * @param attribute3
	 *            the attribute3 to set
	 */
	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	/**
	 * @param attribute4
	 *            the attribute4 to set
	 */
	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	/**
	 * @param attribute5
	 *            the attribute5 to set
	 */
	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}

	@Override
	public String toString() {
		return "userId=" + userId + ",userName=" + userName + ",password=" + password + ",branch=" + branch + ",role="
				+ role + ",attribute1=" + attribute1 + ",attribute2=" + attribute2 + ",attribute3=" + attribute3
				+ ",attribute4=" + attribute4 + ",attribute5=" + attribute5;
	}

}
