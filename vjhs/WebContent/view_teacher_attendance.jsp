<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VJHS::View Teachers</title>
</head>
<body>
	<jsp:include page="vjhstop.jsp" />
	<c:set var="page" scope="request" value="TEACHER" />
	<jsp:include page="vjhsmenu.jsp" />
	<div class="mainBody">
		<div class="mainBodyStyle">
			<div class="mainLeftBodyStyle">
				<div class="leftPaneHeadding">Manage Teachers</div>
				<ul>
					<li><a href="add.teacher">Add Teachers</a></li>
					<li><a href="view.teacher">View Teachers</a></li>
					<li class="activeLeftPane"><a href="attendance.teacher">Attendance</a></li>
					<li><a href="viewtt.teacher">Time Table</a></li>
				</ul>
			</div>
			<div class="mainRightBodyStyle">
				<div>
					<fieldset>
						<legend>View Teacher Attendance Report</legend>
						<form action="addTeacherAtten.teacher" method="post">
							<div class="fulWidth">
								<label class="leftLabelST">Select Date</label> <label
									class="rightLabelST"> <input type="text"
									name="teacherAtDate" id="teacherAtDate" class="datepicker"
									onchange="getEmpData()" />
								</label>
							</div>
							<div class="fulWidth showTab noHide">
								<table class="teachAttenTab" border="1">
									<thead>
										<tr>
											<th>Employee Name</th>
											<th>Attendance Status</th>
										</tr>
									</thead>
									<tbody></tbody>
								</table>
							</div>
							<div class="formButtons showTab noHide">
								<input type="submit" class="btnStyle" id="submit" name="Submit"
									value="Add / Update"> &nbsp;&nbsp; <input
									class="btnStyle" type="reset" id="reset" name="reset"
									value="Clear">
							</div>
						</form>
					</fieldset>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="vjhsbottom.jsp" />
</body>
</html>