<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VJHS:: Teachers Time Table</title>
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
					<li><a href="attendance.teacher">Attendance</a></li>
					<li class="activeLeftPane"><a href="viewtt.teacher">Time
							Table</a></li>
				</ul>
			</div>
			<div class="mainRightBodyStyle">
				<form name="updateCTable" method="post" action="addtt.teacher">
					<div>
						<fieldset>
							<legend>View / Update Time Table</legend>
							<div class="fulWidth">
								<label class="leftLabelST">Please select Teacher to get
									Time Table</label> <label class="rightLabelST"> <select
									name="empId" id="empId" onchange="onChangeTeacher()">
										<option value="">Select</option>
										<c:forEach items="${teacherList}" var="teacher">
											<option value="${teacher.employeeId}">${teacher.teacherName}</option>
										</c:forEach>
								</select>
								</label>
							</div>
							<div class="techrTable noHide">
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
											<tr>
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

												<td><select name="aC${i}" id="aC${i}" class="clsList">
														<option value="" />
														<c:forEach var="classList" items="${classList}">
															<option value="${classList.className}">${classList.className}</option>
														</c:forEach>
												</select><select name="a${i}" id="a${i}" class="subList">
														<option value="" />
														<c:forEach var="subList" items="${subjectList}">
															<option value="${subList.subjectId}">${subList.subjectName}</option>
														</c:forEach>
												</select></td>

												<td><select name="bC${i}" id="bC${i}" class="clsList">
														<option value="" />
														<c:forEach var="classList" items="${classList}">
															<option value="${classList.className}">${classList.className}</option>
														</c:forEach>
												</select><select name="b${i}" id="b${i}" class="subList">
														<option value="" />
														<c:forEach var="subList" items="${subjectList}">
															<option value="${subList.subjectId}">${subList.subjectName}</option>
														</c:forEach>
												</select></td>

												<td><select name="cC${i}" id="cC${i}" class="clsList">
														<option value="" />
														<c:forEach var="classList" items="${classList}">
															<option value="${classList.className}">${classList.className}</option>
														</c:forEach>
												</select><select name="c${i}" id="c${i}" class="subList">
														<option value="" />
														<c:forEach var="subList" items="${subjectList}">
															<option value="${subList.subjectId}">${subList.subjectName}</option>
														</c:forEach>
												</select></td>

												<td><select name="dC${i}" id="dC${i}" class="clsList">
														<option value="" />
														<c:forEach var="classList" items="${classList}">
															<option value="${classList.className}">${classList.className}</option>
														</c:forEach>
												</select><select name="d${i}" id="d${i}" class="subList">
														<option value="" />
														<c:forEach var="subList" items="${subjectList}">
															<option value="${subList.subjectId}">${subList.subjectName}</option>
														</c:forEach>
												</select></td>

												<td><select name="eC${i}" id="eC${i}" class="clsList">
														<option value="" />
														<c:forEach var="classList" items="${classList}">
															<option value="${classList.className}">${classList.className}</option>
														</c:forEach>
												</select><select name="e${i}" id="e${i}" class="subList">
														<option value="" />
														<c:forEach var="subList" items="${subjectList}">
															<option value="${subList.subjectId}">${subList.subjectName}</option>
														</c:forEach>
												</select></td>

												<td><select name="fC${i}" id="fC${i}" class="clsList">
														<option value="" />
														<c:forEach var="classList" items="${classList}">
															<option value="${classList.className}">${classList.className}</option>
														</c:forEach>
												</select><select name="f${i}" id="f${i}" class="subList">
														<option value="" />
														<c:forEach var="subList" items="${subjectList}">
															<option value="${subList.subjectId}">${subList.subjectName}</option>
														</c:forEach>
												</select></td>

												<td><select name="gC${i}" id="gC${i}" class="clsList">
														<option value="" />
														<c:forEach var="classList" items="${classList}">
															<option value="${classList.className}">${classList.className}</option>
														</c:forEach>
												</select><select name="g${i}" id="g${i}" class="subList">
														<option value="" />
														<c:forEach var="subList" items="${subjectList}">
															<option value="${subList.subjectId}">${subList.subjectName}</option>
														</c:forEach>
												</select></td>

												<td><select name="hC${i}" id="hC${i}" class="clsList">
														<option value="" />
														<c:forEach var="classList" items="${classList}">
															<option value="${classList.className}">${classList.className}</option>
														</c:forEach>
												</select><select name="h${i}" id="h${i}" class="subList">
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
									<input type="button" class="btnStyle" id="edit" value="Edit">
									<input type="submit" class="btnStyle" id="submit"
										value="Add / Update"> &nbsp;&nbsp; <input
										class="btnStyle" type="button" id="reset" value="Clear"
										onclick="resetFields()">
								</div>
							</div>
						</fieldset>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="vjhsbottom.jsp" />
</body>
</html>