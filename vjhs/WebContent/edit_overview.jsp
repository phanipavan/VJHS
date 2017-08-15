<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VJHS:: Overview</title>
</head>
<body>
	<jsp:include page="vjhstop.jsp" />
	<div class="mainMenuStyle">
		<div class="menuStyle">
			<a href="overview.profile"><span
				class="profileStyle mainMenuSubStyle activeProfile">Profile</span></a> <a
				href="add.student"><span class="mainMenuSubStyle studentProfile">Students</span></a>
			<a href="add.teacher"><span
				class="mainMenuSubStyle teacherProfile">Teachers</span></a> <a
				href="academic_calander.schedule"><span
				class="mainMenuSubStyle scheduleProfile">Schedule</span></a> <a
				href="attendance.examinations"><span
				class="mainMenuSubStyle examsProfile">Exams</span></a> <a href="#"><span
				class="mainMenuSubStyle smsProfile">SMS</span></a> <a href="#"><span
				class="mainMenuSubStyle libraryProfile">Library</span></a> <a href="#"><span
				class="mainMenuSubStyle vehiclesProfile">Vehicles</span></a> <a href="#"><span
				class="mainMenuSubStyle accountsProfile">Accounts</span></a>
		</div>
	</div>
	<div class="mainBody">
		<div class="mainBodyStyle">
			<div class="mainLeftBodyStyle">
				<div class="leftPaneHeadding">Manage Profile</div>
				<ul>
					<li class="activeLeftPane"><a href="overview.profile">Overview</a></li>
					<li><a href="classstrength.profile">Classes &amp;
							Strengths</a></li>
					<li><a href="feestructure.profile">Fee Structure</a></li>
				</ul>
			</div>
			<div class="mainRightBodyStyle">
				<form action="updOverview.profile" method="post" id="overviewForm"
					name="overviewForm">
					<fmt:bundle basename="com.vjhs.labels.label">
						<div>
							<fieldset>
								<legend>Manage VJHS Overview</legend>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="SCHOOL_NAME"></fmt:message></label> <label
										class="rightLabelText"> <input type="text"
										class="inputType" name="school_name" id="school_name"
										maxlength="100" required placeholder="Enter School name"
										value="<c:out value="${overview.schoolName }"></c:out>" />
									</label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="HEADQUARTERS"></fmt:message></label> <label
										class="rightLabelText"><input type="text"
										class="inputType" name="headquarter" id="headquarter"
										maxlength="30" required placeholder="Enter Headquarters"
										value="<c:out value="${overview.headquarters }"></c:out>" /></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="BRANCHES"></fmt:message></label> <label class="rightLabelText">
										<input type="text" name="branches" id="branches"
										onkeypress="return allowletters(event)" maxlength="40"
										required class="inputType" placeholder="Enter Branches"
										value="<c:out value="${overview.branches }"></c:out>" />
									</label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message key="CITY"></fmt:message></label>
									<label class="rightLabelText"><input type="text"
										name="city" id="city" maxlength="30" required
										class="inputType" placeholder="Enter City name"
										value="<c:out value="${overview.city }"></c:out>" /></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="DISTRICT"></fmt:message></label> <label class="rightLabelText"><input
										type="text" name="district" id="district" maxlength="30"
										required class="inputType" placeholder="Enter District name"
										value="<c:out value="${overview.district }"></c:out>" /></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message key="STATE"></fmt:message></label>
									<label class="rightLabelText"><input type="text"
										name="state" id="state" class="inputType" maxlength="30"
										required placeholder="Enter State name"
										value="<c:out value="${overview.state }"></c:out>" /></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="PHONE_NO"></fmt:message></label> <label class="rightLabelText"><input
										type="tel" name="phone" id="phone" maxlength="10"
										onkeypress="return allownumber(event)" required
										class="inputType" placeholder="Enter Phone number"
										value="<c:out value="${overview.phoneNo }"></c:out>" /></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="MOBILE_NO"></fmt:message></label> <label class="rightLabelText"><input
										type="tel" name="mobile" id="mobile" maxlength="10"
										onkeypress="return allownumber(event)" required
										class="inputType" placeholder="Enter Mobile number"
										value="<c:out value="${overview.mobileNo }"></c:out>" /></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message key="EMAIL"></fmt:message></label>
									<label class="rightLabelText"><input type="email"
										name="email" id="email" maxlength="100" required
										class="inputType" placeholder="Enter email id"
										value="<c:out value="${overview.email }"></c:out>" /></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="STUDENTS"></fmt:message></label> <label class="rightLabelText"><input
										type="number" name="students" id="students" required
										class="inputType" min="0" readonly="readonly"
										value="<c:out value="${overview.noOfStudents }"></c:out>" /></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="TEACHERS"></fmt:message></label> <label class="rightLabelText"><input
										type="number" name="teachers" id="teachers" required
										class="inputType" min="0" readonly="readonly"
										value="<c:out value="${overview.noOfStudents }"></c:out>" /></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="START_YEAR"></fmt:message></label> <label class="rightLabelText"><input
										type="text" name="start_year" id="start_year" maxlength="4"
										required class="inputType" placeholder="Enter Start year"
										value="<c:out value="${overview.startYear }"></c:out>" /></label>
								</div>
							</fieldset>
						</div>
						<div class="formButtons">
							<input type="submit" class="btnStyle" id="update" value="Update" />
							&nbsp;&nbsp; <input type="button" class="btnStyle"
								id="cancelOverveiwEdit" value="Cancel">
						</div>
					</fmt:bundle>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="vjhsbottom.jsp" />
</body>
</html>