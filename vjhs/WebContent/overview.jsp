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
	<c:set var="page" scope="request" value="PROFILE" />
	<jsp:include page="vjhsmenu.jsp" />
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
				<form action="editOverview.profile" method="post" id="overviewForm"
					name="overviewForm">
					<fmt:bundle basename="com.vjhs.labels.label">
						<div>
							<fieldset>
								<legend>VJHS Overview</legend>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="SCHOOL_NAME"></fmt:message></label> <label
										class="rightLabelText"><c:out
											value="${overview.schoolName }"></c:out></label> <br>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="HEADQUARTERS"></fmt:message></label> <label
										class="rightLabelText"><c:out
											value="${overview.headquarters }"></c:out></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="BRANCHES"></fmt:message></label> <label class="rightLabelText"><c:out
											value="${overview.branches }"></c:out></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message key="CITY"></fmt:message></label>
									<label class="rightLabelText"><c:out
											value="${overview.city }"></c:out></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="DISTRICT"></fmt:message></label> <label class="rightLabelText"><c:out
											value="${overview.district }"></c:out></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message key="STATE"></fmt:message></label>
									<label class="rightLabelText"><c:out
											value="${overview.state }"></c:out></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="PHONE_NO"></fmt:message></label> <label class="rightLabelText"><c:out
											value="${overview.phoneNo }"></c:out></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="MOBILE_NO"></fmt:message></label> <label class="rightLabelText"><c:out
											value="${overview.mobileNo }"></c:out></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message key="EMAIL"></fmt:message></label>
									<label class="rightLabelText"><c:out
											value="${overview.email }"></c:out></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="STUDENTS"></fmt:message></label> <label class="rightLabelText"><c:out
											value="${overview.noOfStudents }"></c:out></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="TEACHERS"></fmt:message></label> <label class="rightLabelText"><c:out
											value="${overview.noOfStudents }"></c:out></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="START_YEAR"></fmt:message></label> <label class="rightLabelText"><c:out
											value="${overview.startYear }"></c:out></label>
								</div>
							</fieldset>
						</div>
						<div class="formButtons">
							<input type="submit" id="edit" value="Edit" class="btnStyle" />
						</div>
					</fmt:bundle>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="vjhsbottom.jsp" />
</body>
</html>