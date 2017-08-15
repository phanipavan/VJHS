<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VJHS:: Progress Report</title>
</head>
<body>
	<form id="progressrppt" action="progress.examinations" method="post">
		<jsp:include page="vjhstop.jsp" />
		<c:set var="page" scope="request" value="EXAM" />
		<jsp:include page="vjhsmenu.jsp" />
		<div class="mainBody">
			<div class="mainBodyStyle">
				<div class="mainLeftBodyStyle">
					<div class="leftPaneHeadding">Manage Examinations</div>
					<ul>
						<li><a href="attendance.examinations">Attendance</a></li>
						<li><a href="subjects.examinations">Subjects</a></li>
						<li><a href="schedule.examinations">Schedule</a></li>
						<li><a href="student_mark.examinations">Marks Report</a></li>
						<li class="activeLeftPane"><a
							href="progress_report.examinations">Progress Report</a></li>
						<li><a href="certificates.examinations">Certificates</a></li>
					</ul>
				</div>
				<div class="mainRightBodyStyle">
					<fmt:bundle basename="com.vjhs.labels.label">
						<fieldset>
							<legend>Progress Report</legend>
							<div class="fulWidth">
								<label class="leftLabelST">Examination Name</label> <label
									class="rightLabelST"> <select name="examType"
									id="examType">
										<option value=""><fmt:message key="SELECT" />
										</option>
										<option value='<fmt:message key="EX1"/>'><fmt:message key="FA1" />
										</option>
										<option value="<fmt:message key="EX2"/>"><fmt:message key="FA2" />
										</option>
										<option value="<fmt:message key="EX3"/>"><fmt:message key="FA3" />
										</option>
										<option value="<fmt:message key="EX4"/>"><fmt:message key="FA4" />
										</option>
										<option value="<fmt:message key="EX5"/>"><fmt:message key="FA5" />
										</option>
										<option value="<fmt:message key="EX6"/>"><fmt:message key="SA1" />
										</option>
										<option value="<fmt:message key="EX7"/>"><fmt:message key="SA2" />
										</option>
										<option value="<fmt:message key="EX8"/>"><fmt:message key="SA3" />
										</option>
										<option value="<fmt:message key="EX9"/>"><fmt:message key="PAE" />
										</option>
										<option value="<fmt:message key="EX10"/>"><fmt:message key="AE" />
										</option>
								</select>
								</label>
							</div>
							<div class="fulWidth">
								<label class="leftLabelST">Class</label> <label
									class="rightLabelST"> <select name="className"
									id="className" onchange="getAdminssionNumbesByClassName();">
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
								<label class="leftLabelST">Student Name / Admission No </label>
								<label class="rightLabelST"> <select name="admissionNo"
									id="admissionNo" onchange="getTableData()">
										<option value="select"><fmt:message key="SELECT" />
										</option>
								</select>
								</label>
							</div>
							<div class="fulWidth reportDiv noHide">
								<div class="width60 marginLR10">
									<div class="fulWidth100 reportHeadding">Marks Report</div>
									<table class="reportTab" border="1">
										<tr>
											<th>Subject</th>
											<th>Marks / Out of 100</th>
											<th>Grade Point</th>
										</tr>
										<c:forEach var="subList" items="${subjectList}">
											<tr>
												<th><c:out value="${subList.subjectName}"></c:out> <input
													type="hidden" value="${subList.subjectId}"
													name="sub${subList.subjectId}" id="sub${subList.subjectId}" /></th>
												<td class="algnCentr fontBold"><input type="text"
													name="mark${subList.subjectId}" class="num fonBold"
													id="mark${subList.subjectId}"
													onkeypress="return isNumber(event)" placeholder="0"
													onchange="handleChange(this);totalMarks()" maxlength="3" /></td>
												<td class="algnCentr fontBold"><span class="fonBold"
													id="mark${subList.subjectId}Grd"></span> <input
													type="hidden" id="mark${subList.subjectId}Grd1"
													name="mark${subList.subjectId}Grd1" /></td>
											</tr>
										</c:forEach>
										<tr>
											<td class="fontBold alignright">Total Marks :</td>
											<td class="fontBold alignCenter"><span id="totalMark"></span>
												/ 600</td>
											<td></td>
										</tr>
									</table>
								</div>
								<div class="width37">
									<div class="fulWidth100 reportHeadding">Attendance Report</div>
									<div class="fulWidth100">
										<table class="reportTab" border="1">
											<tr>
												<th>Month</th>
												<td><select name="monthAttn" id="monthAttn"
													onChange="getWorkingDays();">
														<option value=""><fmt:message key="SELECT" /></option>
														<option value="0"><fmt:message key="JAN" /></option>
														<option value="1"><fmt:message key="FEB" /></option>
														<option value="2"><fmt:message key="MAR" /></option>
														<option value="3"><fmt:message key="APR" /></option>
														<option value="5"><fmt:message key="JUN" /></option>
														<option value="6"><fmt:message key="JUL" /></option>
														<option value="7"><fmt:message key="AUG" /></option>
														<option value="8"><fmt:message key="SEP" /></option>
														<option value="9"><fmt:message key="OCT" /></option>
														<option value="10"><fmt:message key="NOV" /></option>
														<option value="11"><fmt:message key="DEC" /></option>
												</select></td>
											</tr>
											<tr>
												<th class="alignright">Number of Working Days :</th>
												<td><span id="workingDays" class="fontBold alignCenter"></span></td>
											</tr>
											<tr>
												<th class="alignright">Number of Days Present :</th>
												<td><span id="presentDays" class="fontBold alignCenter"></span></td>
											</tr>
										</table>
									</div>

									<div class="fulWidth100 reportHeadding marginT17">Report
										Summary</div>
									<div class="fulWidth100">
										<table class="reportTab" border="1">
											<tr>
												<th class="alignright">Marks Percentage ( % ) :</th>
												<td><span id="marksaverage"
													class="fontBold alignCenter"></span></td>
											</tr>
											<tr>
												<th class="alignright">Grade Points Average ( GPA ) :</th>
												<td><span id="gpa" class="fontBold alignCenter"></span></td>
											</tr>
											<tr>
												<th class="alignright">Attendance Percentage ( % ) :</th>
												<td><span id="attendanceaverage"
													class="fontBold alignCenter"></span></td>
											</tr>
										</table>
									</div>
								</div>
								<div class="formButtons">
									<input type="button" class="btnStyle" id="edit" value="Edit">
									<input type="submit" class="btnStyle" id="submit"
										value="Add / Update"> &nbsp;&nbsp; <input
										class="btnStyle" type="button" id="reset" value="Clear"
										onclick="resetReportData()">
								</div>
							</div>
						</fieldset>
					</fmt:bundle>
				</div>
			</div>
		</div>
		<jsp:include page="vjhsbottom.jsp" />
	</form>
</body>
</html>