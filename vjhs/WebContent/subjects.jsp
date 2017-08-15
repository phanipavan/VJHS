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
					<li class="activeLeftPane"><a href="subjects.examinations">Subjects</a></li>
					<li><a href="schedule.examinations">Schedule</a></li>
					<li><a href="student_mark.examinations">Marks Report</a></li>
					<li><a href="progress_report.examinations">Progress Report</a></li>
					<li><a href="certificates.examinations">Certificates</a></li>
				</ul>
			</div>
			<div class="mainRightBodyStyle">
				<fmt:bundle basename="com.vjhs.labels.label">
					<div>
						<fieldset>
							<legend>Subjects</legend>
							<div class="fulWidth">
								<c:forEach var="subject" items="${subjectList}">
									<div class="fulWidth">
										<input type="hidden"
											id='<c:out value="${fn:replace(subject.subjectName,' ','')}"></c:out>'
											name="hideSubId"
											value='<c:out value="${subject.subjectId}"></c:out>' /> <input
											type="checkbox" id="subjectName" name="subjectName"
											value="${subject.subjectName}" />&nbsp;
										<c:out value="${subject.subjectName}"></c:out>
									</div>
								</c:forEach>
							</div>
							<div class="formButtonsLeft">
								<input type="button" class="btnStyle" id="add" name="add"
									value="Add" onclick="addSubject()" /> &nbsp;&nbsp; <input
									class="btnStyle" type="button" name="subedit" id="subedit"
									value="Edit" onclick="editSub()" /> &nbsp;&nbsp;<input
									type="button" class="btnStyle" name="delete" id="delete"
									value="Delete" onclick="deleteSubjects()" />
							</div>
						</fieldset>
					</div>
					<div class="addSubjectPane">
						<fieldset>
							<legend>Add Subject</legend>
							<form action="addSubjects.examinations" name="addSubPage"
								id="addSubPage" method="POST">
								<div class="fulWidth">
									<label class="leftLabel">Please Enter Subject ID </label><label
										class="rightLabel"><input type="text" id="SubId"
										name="SubId" /></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabel">Please Enter Subject Name </label><label
										class="rightLabel"><input type="text" id="newSub"
										name="newSub" /></label>
								</div>
								<div class="formButtons">
									<input type="submit" id="addSubject" name="addSubject"
										class="btnStyle" value="Add Subject" />
								</div>
							</form>
						</fieldset>
					</div>
					<div class="updateSubjectPane">
						<fieldset>
							<legend>Update Subject</legend>
							<form action="updateSubjects.examinations" name="updateSubPane"
								id="updateSubPane" method="POST">
								<div class="fulWidth">
									<input type="hidden" id="editSubId" name="editSubId" /> <label
										class="leftLabel">Please modify Subject</label><label
										class="rightLabel"><input type="text" id="editSubName"
										name="editSubName" /></label>
								</div>
								<div class="formButtons">
									<input type="submit" id="addSubject" name="addSubject"
										value="Update Subject" class="btnStyle" />
								</div>
							</form>
						</fieldset>
					</div>
				</fmt:bundle>
			</div>
		</div>
	</div>
	<jsp:include page="vjhsbottom.jsp" />
</body>
</html>