<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
					<li><a href="attendance.examinations">Attendance</a></li>
					<li><a href="subjects.examinations">Subjects</a></li>
					<li><a href="schedule.examinations">Schedule</a></li>
					<li class="activeLeftPane"><a href="student_mark.examinations">Marks
							Report</a></li>
					<li><a href="progress_report.examinations">Progress Report</a></li>
					<li><a href="certificates.examinations">Certificates</a></li>
				</ul>
			</div>
			<div class="mainRightBodyStyle">
				<fmt:bundle basename="com.vjhs.labels.label">
					<div>
						<fieldset>
							<legend>Marks Report</legend>
							<div class="fulWidth">
								<label class="leftLabelST">Class</label> <label
									class="rightLabelST"> <select name="className"
									id="className" onchange="getAdminssionNumbesByClassName()">
										<option value="<fmt:message key="SELECT"/>"><fmt:message
												key="SELECT" />
										</option>
										<option value="<fmt:message key="NURSERY"/>"><fmt:message
												key="NURSERY" />
										</option>
										<option value="<fmt:message key="LKG"/>"><fmt:message
												key="LKG" />
										</option>
										<option value="<fmt:message key="UKG"/>"><fmt:message
												key="UKG" />
										</option>
										<option value="<fmt:message key="FIRST_STANDARD"/>"><fmt:message
												key="FIRST_STANDARD" />
										</option>
										<option value="<fmt:message key="SECOND_STANDARD"/>"><fmt:message
												key="SECOND_STANDARD" />
										</option>
										<option value="<fmt:message key="THIRD_STANDARD"/>"><fmt:message
												key="THIRD_STANDARD" />
										</option>
										<option value="<fmt:message key="FOURTH_STANDARD"/>"><fmt:message
												key="FOURTH_STANDARD" />
										</option>
										<option value="<fmt:message key="FIFTH_STANDARD"/>"><fmt:message
												key="FIFTH_STANDARD" />
										</option>
										<option value="<fmt:message key="SIXTH_STANDARD"/>"><fmt:message
												key="SIXTH_STANDARD" />
										</option>
										<option value="<fmt:message key="SEVENTH_STANDARD"/>"><fmt:message
												key="SEVENTH_STANDARD" />
										</option>
										<option value="<fmt:message key="EIGHT_STANDARD"/>"><fmt:message
												key="EIGHT_STANDARD" />
										</option>
										<option value="<fmt:message key="NINETH_STANDARD"/>"><fmt:message
												key="NINETH_STANDARD" />
										</option>
										<option value="<fmt:message key="TENTH_STANDARD"/>"><fmt:message
												key="TENTH_STANDARD" />
										</option>
								</select>
								</label>
							</div>

							<div class="fulWidth">
								<label class="leftLabelST">Student Name / Admission No</label> <label
									class="rightLabelST"> <select name="admissionNo"
									id="admissionNo" onchange="getAllMarks()">
										<option value=""><fmt:message key="SELECT" />
										</option>
								</select>
								</label>
							</div>
							<c:set var="FA1">
								<fmt:message key="EX1" />
							</c:set>
							<c:set var="FA2">
								<fmt:message key="EX2" />
							</c:set>
							<c:set var="FA3">
								<fmt:message key="EX3" />
							</c:set>
							<c:set var="FA4">
								<fmt:message key="EX4" />
							</c:set>
							<c:set var="SA1">
								<fmt:message key="EX6" />
							</c:set>
							<c:set var="SA2">
								<fmt:message key="EX7" />
							</c:set>
							<c:set var="PAE">
								<fmt:message key="EX9" />
							</c:set>
							<c:set var="AE">
								<fmt:message key="EX10" />
							</c:set>
							<div
								class="fulWidth marginT17 fontBold border marksRprtDiv noHide">
								<div class="fulWidth100 reportHeadding">Cumulative Marks
									&amp; Grade Report</div>
								<div class="fulWidth">
									<label class="leftLabelSTS">Name of the Student</label> <label
										class="rightLabelST" id="nameHead"></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelSTS">Class</label><label
										class="rightLabelST" id="classHead"></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelSTS">Admission Number</label><label
										class="rightLabelST" id="adminNoHead"></label>
								</div>
								<div class="fulWidth100">
									<div class="fulWidth100">
										<div class="fulWidth100 reportHeadding">Formative
											Assessment (FA)</div>
										<table class="markReTab border" border="1">
											<tr>
												<th rowspan="2">Subjects</th>
												<th colspan="2">FA-1</th>
												<th colspan="2">FA-2</th>
												<th colspan="2">FA-3</th>
												<th colspan="2">FA-4</th>
											</tr>
											<tr>
												<th>Marks</th>
												<th>Grade</th>
												<th>Marks</th>
												<th>Grade</th>
												<th>Marks</th>
												<th>Grade</th>
												<th>Marks</th>
												<th>Grade</th>
											</tr>
											<c:forEach items="${subjectList}" var="subList">
												<tr>
													<th><c:out value="${subList.subjectName}" /></th>
													<td class="algnCentr" id="${FA1}Mark${subList.subjectId}"></td>
													<td class="algnCentr" id="${FA1}Grade${subList.subjectId}"></td>
													<td class="algnCentr" id="${FA2}Mark${subList.subjectId}"></td>
													<td class="algnCentr" id="${FA2}Grade${subList.subjectId}"></td>
													<td class="algnCentr" id="${FA3}Mark${subList.subjectId}"></td>
													<td class="algnCentr" id="${FA3}Grade${subList.subjectId}"></td>
													<td class="algnCentr" id="${FA4}Mark${subList.subjectId}"></td>
													<td class="algnCentr" id="${FA4}Grade${subList.subjectId}"></td>
												</tr>
											</c:forEach>
											<tr>
												<td>GPA</td>
												<td colspan="2" class="alignright" id="GPA${FA1}"></td>
												<td colspan="2" class="alignright" id="GPA${FA2}"></td>
												<td colspan="2" class="alignright" id="GPA${FA3}"></td>
												<td colspan="2" class="alignright" id="GPA${FA4}"></td>
											</tr>
											<tr>
												<td colspan="9" class="algnCentr">FA Cumulative Grade
													Point Average: <span id="CGPAFA"></span>
												</td>
											</tr>
										</table>
									</div>
								</div>
								<div class="fulWidth100">
									<div class="width49 marginR2Pr">
										<div class="fulWidth100 reportHeadding marginT17">Summative
											Assessment (SA)</div>
										<table class="markReTab border" border="1">
											<tr>
												<th rowspan="2">Subjects</th>
												<th colspan="2">SA-1</th>
												<th colspan="2">SA-2</th>
											</tr>
											<tr>
												<th>Marks</th>
												<th>Grade</th>
												<th>Marks</th>
												<th>Grade</th>
											</tr>
											<c:forEach items="${subjectList}" var="subList">
												<tr>
													<th><c:out value="${subList.subjectName}" /></th>
													<td class="algnCentr" id="${SA1}Mark${subList.subjectId}"></td>
													<td class="algnCentr" id="${SA1}Grade${subList.subjectId}"></td>
													<td class="algnCentr" id="${SA2}Mark${subList.subjectId}"></td>
													<td class="algnCentr" id="${SA2}Grade${subList.subjectId}"></td>
												</tr>
											</c:forEach>
											<tr>
												<td>GPA</td>
												<td colspan="2" class="alignright" id="GPA${SA1}"></td>
												<td colspan="2" class="alignright" id="GPA${SA2}"></td>
											</tr>
											<tr>
												<td colspan="5" class="algnCentr">SA Cumulative Grade
													Point Average: <span id="CGPASA"></span>
												</td>
											</tr>
										</table>
									</div>


									<%-- 	<div class="width49 marginR2Pr">
										<div class="fulWidth100 reportHeadding marginT17">Pre-Annual
											Examination</div>
										<table class="markReTab border" border="1">
											<tr>
												<th>Subjects</th>
												<th>Marks</th>
												<th>Grade</th>
											</tr>
											<c:forEach items="${subjectList}" var="subList">
												<tr>
													<th><c:out value="${subList.subjectName}" /></th>
													<td class="algnCentr" id="${PAE}Mark${subList.subjectId}"></td>
													<td class="algnCentr" id="${PAE}Grade${subList.subjectId}"></td>
												</tr>
											</c:forEach>
											<tr>
												<td colspan="3" class="algnCentr">Pre-Annual Grade
													Point Average:</td>
											</tr>
										</table>
									</div> --%>
									<div class="width49">
										<div class="fulWidth100 reportHeadding marginT17">Annual
											Examination</div>
										<table class="markReTab border" border="1">
											<tr>
												<th>Subjects</th>
												<th>Marks</th>
												<th>Grade</th>
											</tr>
											<c:forEach items="${subjectList}" var="subList">
												<tr>
													<th><c:out value="${subList.subjectName}" /></th>
													<td class="algnCentr" id="${AE}Mark${subList.subjectId}"></td>
													<td class="algnCentr" id="${AE}Grade${subList.subjectId}"></td>
												</tr>
											</c:forEach>
											<tr>
												<td colspan="3" class="algnCentr">Annual Grade Point
													Average: <span id="CGPAAE"></span>
												</td>
											</tr>
										</table>
									</div>
								</div>
								<div class="fulWidth100">
									<div class="cgpDiv border marginT17">
										Cumulative Grade Point Average(CGPA): <span id="CGPA"></span>
									</div>
								</div>
							</div>
						</fieldset>
						<%-- 	<div class="fulWidth">
							<c:import url="student_marks_child.jsp"></c:import>
						</div> --%>
					</div>
				</fmt:bundle>
			</div>
		</div>
	</div>
	<jsp:include page="vjhsbottom.jsp" />
</body>
</html>