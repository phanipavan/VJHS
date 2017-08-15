<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<jsp:include page="vjhstop.jsp" />
	<c:set var="page" scope="request" value="STUDENT" />
	<jsp:include page="vjhsmenu.jsp" />
	<div class="mainBody">
		<div class="mainBodyStyle">
			<div class="mainLeftBodyStyle">
				<div class="leftPaneHeadding">Manage Students</div>
				<ul>
					<li><a href="add.student">Add Student</a></li>
					<li class="activeLeftPane"><a href="view.student">View
							Students</a></li>
				</ul>
			</div>
			<div class="mainRightBodyStyle">
				<div>
					<fieldset>
						<legend>View Students</legend>
						<table class="example display compact">
							<thead>
								<tr>
									<th>Admission Number</th>
									<th>Student Name</th>
									<th>Class</th>
									<th>DOB</th>
									<th>Gender</th>
									<th>Caste Category</th>
									<th>Father Name</th>
									<th>Mobile Number</th>
									<th>Modify</th>
									<th>Delete</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${studentsList}" var="student">
									<c:url value="modifyStudent.student" var="modifyStudent">
										<c:param name="adminNo" value="${student.admissionNo}" />
									</c:url>
									<c:url value="deleteStudent.student" var="deleteStudent">
										<c:param name="adminNo" value="${student.admissionNo}" />
									</c:url>
									<tr>
										<td><c:out value="${student.admissionNo}"></c:out></td>
										<td><c:out value="${student.studentName}"></c:out></td>
										<td><c:out value="${student.currentClass}"></c:out></td>
										<td><c:out value="${student.dateOfBirth}"></c:out></td>
										<td><c:out value="${student.gender}"></c:out></td>
										<td><c:out value="${student.coc}"></c:out></td>
										<td><c:out value="${student.fatherName}"></c:out></td>
										<td><c:out value="${student.mobile}"></c:out></td>
										<td><a href="<c:out value="${modifyStudent}"></c:out>">Modify</a></td>
										<td><a href="<c:out value="${deleteStudent}"></c:out>">Delete</a></td>
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
		/* Custom filtering function which will search data in column four between two values */
		/* 	$.fn.dataTable.ext.search.push(function(settings, data, dataIndex) {
		 var min = parseInt($('#min').val(), 10);
		 var max = parseInt($('#max').val(), 10);
		 var age = parseFloat(data[3]) || 0; // use data for the age column
		 if ((isNaN(min) && isNaN(max)) || (isNaN(min) && age <= max)
		 || (min <= age && isNaN(max)) || (min <= age && age <= max)) {
		 return;
		 }
		 return;
		 }); */
		$(document).ready(function() {
			var table = $('.example').DataTable();
			// Event listener to the two range filtering inputs to redraw on input
			$('#min, #max').keyup(function() {
				table.draw();
			});
		});
	</script>

</body>
</html>
