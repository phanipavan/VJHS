<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VJHS : Class Time Table</title>
</head>
<body>
	<jsp:include page="vjhstop.jsp" />
	<c:set var="page" scope="request" value="SCHEDULE" />
	<jsp:include page="vjhsmenu.jsp" />
	<div class="mainBody">
		<div class="mainBodyStyle">
			<div class="mainLeftBodyStyle">
				<div class="leftPaneHeadding">Schedules</div>
				<ul>
					<li><a href="academic_calander.schedule">Academic Calendar</a></li>
					<li><a href="school_timings.schedule">School Timings</a></li>
					<li class="activeLeftPane"><a href="class_tt.schedule">Class
							Time Table</a></li>
					<li><a href="events.schedule">Events</a></li>
					<li><a href="holidays.schedule">Holiday List</a></li>
				</ul>
			</div>
			<div class="mainRightBodyStyle">
				<form action="addTT.schedule" method="post" id="addCTable"
					name="addCTable">
					<fmt:bundle basename="com.vjhs.labels.label">
						<div>
							<fieldset>
								<legend>View / Update Class Time Table</legend>
								<div class="fulWidth">
									<label class="leftLabelST">Please select Class to get
										Time Table</label> <label class="rightLabelST"> <select
										name="className" id="className" onchange="onChangeClass()">
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
								<div class="classTTable noHide">
									<div class="fulWidth">
										<table class="teachTimTbl selectStyleAdd" border="1">
											<tr>
												<th></th>
												<th>Period I</th>
												<th>Period II</th>
												<th>Period III</th>
												<th>Period IV</th>
												<th>Period V</th>
												<th>Period VI</th>
												<th>Period VII</th>
												<th>Period VIII</th>
											</tr>

											<c:forEach begin="1" end="6" var="i">
												<tr class=classTtable>
													<th class="thLabel"><c:choose>
															<c:when test="${i == 1}">
       MON
       <input type="hidden" name="i${i}" id="i${i}" value="MON" />
															</c:when>
															<c:when test="${i==2}">
        TUE
        <input type="hidden" name="i${i}" id="i${i}" value="TUE" />
															</c:when>
															<c:when test="${i==3}">
        WED
        <input type="hidden" name="i${i}" id="i${i}" value="WED" />
															</c:when>
															<c:when test="${i==4}">
        THU
        <input type="hidden" name="i${i}" id="i${i}" value="THU" />
															</c:when>
															<c:when test="${i==5}">
        FRI
        <input type="hidden" name="i${i}" id="i${i}" value="FRI" />
															</c:when>
															<c:when test="${i==6}">
        SAT
        <input type="hidden" name="i${i}" id="i${i}" value="SAT" />
															</c:when>
														</c:choose></th>

													<td><select name="a${i}" id="a${i}" class="subCList">
															<option value="" />
															<c:forEach var="subList" items="${subjectList}">
																<option value="${subList.subjectId}">${subList.subjectName}</option>
															</c:forEach>
													</select></td>

													<td><select name="b${i}" id="b${i}" class="subCList">
															<option value="" />
															<c:forEach var="subList" items="${subjectList}">
																<option value="${subList.subjectId}">${subList.subjectName}</option>
															</c:forEach>
													</select></td>

													<td><select name="c${i}" id="c${i}" class="subCList">
															<option value="" />
															<c:forEach var="subList" items="${subjectList}">
																<option value="${subList.subjectId}">${subList.subjectName}</option>
															</c:forEach>
													</select></td>

													<td><select name="d${i}" id="d${i}" class="subCList">
															<option value="" />
															<c:forEach var="subList" items="${subjectList}">
																<option value="${subList.subjectId}">${subList.subjectName}</option>
															</c:forEach>
													</select></td>

													<td><select name="e${i}" id="e${i}" class="subCList">
															<option value="" />
															<c:forEach var="subList" items="${subjectList}">
																<option value="${subList.subjectId}">${subList.subjectName}</option>
															</c:forEach>
													</select></td>

													<td><select name="f${i}" id="f${i}" class="subCList">
															<option value="" />
															<c:forEach var="subList" items="${subjectList}">
																<option value="${subList.subjectId}">${subList.subjectName}</option>
															</c:forEach>
													</select></td>

													<td><select name="g${i}" id="g${i}" class="subCList">
															<option value="" />
															<c:forEach var="subList" items="${subjectList}">
																<option value="${subList.subjectId}">${subList.subjectName}</option>
															</c:forEach>
													</select></td>

													<td><select name="h${i}" id="h${i}" class="subCList">
															<option value="" />
															<c:forEach var="subList" items="${subjectList}">
																<option value="${subList.subjectId}">${subList.subjectName}</option>
															</c:forEach>
													</select></td>
												</tr>

											</c:forEach>
										</table>
									</div>
									<div class="formButtons">
										<input type="button" class="btnStyle" id="edit" value="Edit" onclick="showReset()">
										<input type="submit" class="btnStyle" id="submit"
											value="Add / Update"> &nbsp;&nbsp; <input
											class="btnStyle" type="button" id="reset" value="Clear"
											onclick="resetFields()">
									</div>
								</div>
							</fieldset>
						</div>
					</fmt:bundle>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="vjhsbottom.jsp" />
</body>
</html>