<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VJHS:: Attendance</title>
</head>
<body>
	<jsp:include page="vjhstop.jsp" />
	<c:set var="page" scope="request" value="EXAM" />
	<jsp:include page="vjhsmenu.jsp" />
	<div class="mainBody">
		<div class="mainBodyStyle">
			<div class="mainLeftBodyStyle">
				<div class="leftPaneHeadding">Manage Examinations</div>
				<ul>
					<li class="activeLeftPane"><a href="attendance.examinations">Attendance</a></li>
					<li><a href="subjects.examinations">Subjects</a></li>
					<li><a href="schedule.examinations">Schedule</a></li>
					<li><a href="student_mark.examinations">Marks Report</a></li>
					<li><a href="progress_report.examinations">Progress Report</a></li>
					<li><a href="certificates.examinations">Certificates</a></li>
				</ul>
			</div>
			<div class="mainRightBodyStyle">
				<form action="addStudentAtten.examinations" method="POST"
					name="addStudentAtten" id="addStudentAtten">
					<fmt:bundle basename="com.vjhs.labels.label">
						<div>
							<fieldset>
								<legend>Update / View Student Attendance Report</legend>
								<div class="fulWidth">
									<label class="leftLabelST">Class</label> <label
										class="rightLabelST"> <select name="className"
										id="className" onchange="getAdminssionNumbesByClassName()">
											<option value=""><fmt:message key="SELECT" />
											</option>
											<option value="<fmt:message key="NURSERY" />"><fmt:message
													key="NURSERY" />
											</option>
											<option value="<fmt:message key="LKG" />"><fmt:message
													key="LKG" />
											</option>
											<option value="<fmt:message key="UKG" />"><fmt:message
													key="UKG" />
											</option>
											<option value="<fmt:message key="FIRST_STANDARD" />"><fmt:message
													key="FIRST_STANDARD" />
											</option>
											<option value="<fmt:message key="SECOND_STANDARD" />"><fmt:message
													key="SECOND_STANDARD" />
											</option>
											<option value="<fmt:message key="THIRD_STANDARD" />"><fmt:message
													key="THIRD_STANDARD" />
											</option>
											<option value="<fmt:message key="FOURTH_STANDARD" />"><fmt:message
													key="FOURTH_STANDARD" />
											</option>
											<option value="<fmt:message key="FIFTH_STANDARD" />"><fmt:message
													key="FIFTH_STANDARD" />
											</option>
											<option value="<fmt:message key="SIXTH_STANDARD" />"><fmt:message
													key="SIXTH_STANDARD" />
											</option>
											<option value="<fmt:message key="SEVENTH_STANDARD" />"><fmt:message
													key="SEVENTH_STANDARD" />
											</option>
											<option value="<fmt:message key="EIGHT_STANDARD" />"><fmt:message
													key="EIGHT_STANDARD" />
											</option>
											<option value="<fmt:message key="NINETH_STANDARD" />"><fmt:message
													key="NINETH_STANDARD" />
											</option>
											<option value="<fmt:message key="TENTH_STANDARD" />"><fmt:message
													key="TENTH_STANDARD" />
											</option>
									</select>
									</label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelST">Student Name/Admission Number</label> <label
										class="rightLabelST"> <select name="admissionNo"
										id="admissionNo" onchange="getStudentAdminNo()">
											<option value="select"><fmt:message key="SELECT" />
											</option>
									</select>
									</label>
								</div>
								<%-- <div class="fulWidth">
									<label class="leftLabelST">Student Attendance Number</label> <label
										class="rightLabelST"> <select name="admissionNo"
										id="admissionNo" onchange="getTableData()">
											<option value="select"><fmt:message key="SELECT" />
												<c:forEach items="${admissionList}" var="addminVal">
													<option value="${addminVal}">${addminVal}</option>
												</c:forEach>									</select>
									</label>
								</div> --%>
								<div class="fulWidth">
									<table class="monthAttend">
										<tr>
											<th class="toShowNo"></th>
											<th>JUNE</th>
											<th>JULY</th>
											<th>AUGUST</th>
											<th>SEPTEMBER</th>
											<th>OCTOBER</th>
											<th>NOVEMBER</th>
											<th>DECEMBER</th>
											<th>JANUARY</th>
											<th>FEBRUARY</th>
											<th>MARCH</th>
											<th>APRIL</th>
										</tr>
										<tr class=attended>
											<th class="toShowNo">Number of Days Attended</th>
											<td><input type="text" class="attenInput" name="a1"
												id="a1" onchange="calPercentage(id)" /></td>
											<td><input type="text" class="attenInput" name="a2"
												id="a2" onchange="calPercentage(id)" /></td>
											<td><input type="text" class="attenInput" name="a3"
												id="a3" onchange="calPercentage(id)" /></td>
											<td><input type="text" class="attenInput" name="a4"
												id="a4" onchange="calPercentage(id)" /></td>
											<td><input type="text" class="attenInput" name="a5"
												id="a5" onchange="calPercentage(id)" /></td>
											<td><input type="text" class="attenInput" name="a6"
												id="a6" onchange="calPercentage(id)" /></td>
											<td><input type="text" class="attenInput" name="a7"
												id="a7" onchange="calPercentage(id)" /></td>
											<td><input type="text" class="attenInput" name="a8"
												id="a8" onchange="calPercentage(id)" /></td>
											<td><input type="text" class="attenInput" name="a9"
												id="a9" onchange="calPercentage(id)" /></td>
											<td><input type="text" class="attenInput" name="a10"
												id="a10" onchange="calPercentage(id)" /></td>
											<td><input type="text" class="attenInput" name="a11"
												id="a11" onchange="calPercentage(id)" /></td>
										</tr>
										<tr>
											<th class="toShowNo">Number of Working Days</th>
											<td><input type="text" class="attenInput" name="w1"
												id="w1" readonly /></td>
											<td><input type="text" class="attenInput" name="w2"
												id="w2" readonly /></td>
											<td><input type="text" class="attenInput" name="w3"
												id="w3" readonly /></td>
											<td><input type="text" class="attenInput" name="w4"
												id="w4" readonly /></td>
											<td><input type="text" class="attenInput" name="w5"
												id="w5" readonly /></td>
											<td><input type="text" class="attenInput" name="w6"
												id="w6" readonly /></td>
											<td><input type="text" class="attenInput" name="w7"
												id="w7" readonly /></td>
											<td><input type="text" class="attenInput" name="w8"
												id="w8" readonly /></td>
											<td><input type="text" class="attenInput" name="w9"
												id="w9" readonly /></td>
											<td><input type="text" class="attenInput" name="w10"
												id="w10" readonly /></td>
											<td><input type="text" class="attenInput" name="w11"
												id="w11" readonly /></td>
										</tr>
										<tr class=attpercent>
											<th class="toShowNo">Monthly Percentage</th>
											<td><input type="text" class="attenInput" name="mp1"
												id="mp1" readonly /></td>
											<td><input type="text" class="attenInput" name="mp2"
												id="mp2" readonly /></td>
											<td><input type="text" class="attenInput" name="mp3"
												id="mp3" readonly /></td>
											<td><input type="text" class="attenInput" name="mp4"
												id="mp4" readonly /></td>
											<td><input type="text" class="attenInput" name="mp5"
												id="mp5" readonly /></td>
											<td><input type="text" class="attenInput" name="mp6"
												id="mp6" readonly /></td>
											<td><input type="text" class="attenInput" name="mp7"
												id="mp7" readonly /></td>
											<td><input type="text" class="attenInput" name="mp8"
												id="mp8" readonly /></td>
											<td><input type="text" class="attenInput" name="mp9"
												id="mp9" readonly /></td>
											<td><input type="text" class="attenInput" name="mp10"
												id="mp10" readonly /></td>
											<td><input type="text" class="attenInput" name="mp11"
												id="mp11" readonly /></td>
										</tr>
									</table>
								</div>
								<div class="fulWidth">
									<table class="cumulativePercen">
										<tr>
											<th>Cumulative Attendance Percentage ( % )</th>
											<th id="cumPercentage"></th>
										</tr>
									</table>
								</div>
							</fieldset>
						</div>
						<div class="formButtons">
							<input type="submit" class="btnStyle" id="submit" name="Submit"
								value="Add / Update"> &nbsp;&nbsp; <input
								class="btnStyle" type="button" id="reset" name="reset"
								value="Clear" onclick="clearAttendanceFields()">
						</div>
					</fmt:bundle>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="vjhsbottom.jsp" />
</body>
</html>