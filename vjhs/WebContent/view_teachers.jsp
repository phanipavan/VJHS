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
					<li class="activeLeftPane"><a href="view.teacher">View
							Teachers</a></li>
					<li><a href="attendance.teacher">Attendance</a></li>
					<li><a href="viewtt.teacher">Time Table</a></li>
				</ul>
			</div>
			<div class="mainRightBodyStyle">
				<div>
					<fieldset>
						<legend>View Teachers</legend>
						<table class="example display compact">
							<thead>
								<tr>
									<th>Emp ID</th>
									<th>Emp Name</th>
									<th>DOJ</th>
									<th>Mobile</th>
									<th>Qualification</th>
									<th>Class Teacher</th>
									<th>Exp</th>
									<th>Modify</th>
									<th>Delete</th>
								</tr>
							</thead>
							<!-- 
						<tfoot>
							<tr>
								<th>Emp ID</th>
								<th>Emp Name</th>
								<th>DOJ</th>
								<th>Mobile</th>
								<th>Qualification</th>
								<th>Class Teacher</th>
								<th>Exp</th>
								<th>Modify</th>
								<th>Delete</th>
							</tr>
						</tfoot> -->
							<tbody>
								<c:forEach items="${teacherList}" var="teacher">
									<c:url value="modifyTeacher.teacher" var="modifyTeacher">
										<c:param name="empId" value="${teacher.employeeId}" />
									</c:url>
									<c:url value="deleteTeacher.teacher" var="deleteTeacher">
										<c:param name="empId" value="${teacher.employeeId}" />
									</c:url>
									<tr>
										<td><c:out value="${teacher.employeeId}"></c:out></td>
										<td><c:out value="${teacher.teacherName}"></c:out></td>
										<td><c:out value="${teacher.dateOfJoining}"></c:out></td>
										<td><c:out value="${teacher.phone}"></c:out></td>
										<td><c:out value="${teacher.qualification}"></c:out></td>
										<td><c:out value="${teacher.class_teacher}"></c:out></td>
										<td><c:out value="${teacher.experiance}"></c:out></td>
										<td><a href="<c:out value="${modifyTeacher}"></c:out>">Modify</a></td>
										<td><a href="<c:out value="${deleteTeacher}"></c:out>">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</fieldset>
				</div>
				<div class="minHeightDiv"></div>
			</div>
		</div>
	</div>
	<jsp:include page="vjhsbottom.jsp" />
	<script type="text/javascript">
		$(function() {
			$('.example').dataTable();
		});
	</script>
</body>
</html>