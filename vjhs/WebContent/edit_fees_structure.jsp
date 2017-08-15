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
					<li><a href="overview.profile">Overview</a></li>
					<li><a href="classstrength.profile">Classes &amp;
							Strengths</a></li>
					<li class="activeLeftPane"><a href="feestructure.profile">Fee
							Structure</a></li>
				</ul>
			</div>
			<div class="mainRightBodyStyle">
				<form action="updateFeeStr.profile" method="post"
					id="feesStructureForm" name="feesStructureForm">
					<fmt:bundle basename="com.vjhs.labels.label">
						<div>
							<fieldset>
								<legend>Manage Fee Structure</legend>
								<div class="fulWidth">
									<c:set var="nursery">
										<fmt:message key='NURSERY' />
									</c:set>
									<c:set var="LKG">
										<fmt:message key='LKG' />
									</c:set>
									<c:set var="UKG">
										<fmt:message key='UKG' />
									</c:set>
									<c:set var="I">
										<fmt:message key='FIRST_STANDARD' />
									</c:set>
									<c:set var="II">
										<fmt:message key='SECOND_STANDARD' />
									</c:set>
									<c:set var="III">
										<fmt:message key='THIRD_STANDARD' />
									</c:set>
									<c:set var="IV">
										<fmt:message key='FOURTH_STANDARD' />
									</c:set>
									<c:set var="V">
										<fmt:message key='FIFTH_STANDARD' />
									</c:set>
									<c:set var="VI">
										<fmt:message key='SIXTH_STANDARD' />
									</c:set>
									<c:set var="VII">
										<fmt:message key='SEVENTH_STANDARD' />
									</c:set>
									<c:set var="VIII">
										<fmt:message key='EIGHT_STANDARD' />
									</c:set>
									<c:set var="IX">
										<fmt:message key='NINETH_STANDARD' />
									</c:set>
									<c:set var="X">
										<fmt:message key='TENTH_STANDARD' />
									</c:set>
									<label class="leftLabelText"><fmt:message key="CLASS"></fmt:message></label>
									<label class="rightLabelText"> <select
										class="selectType" name="std" id="std">
											<option value="" selected><fmt:message key="SELECT"></fmt:message>
											</option>
											<option value="${nursery}"
												<c:if test="${feeStructure.className == nursery}">selected</c:if>>${nursery}
											</option>
											<option value="${LKG}"
												<c:if test="${feeStructure.className ==LKG}">selected</c:if>>${LKG}
											</option>
											<option value="${UKG}"
												<c:if test="${feeStructure.className ==UKG}">selected</c:if>>${LKG}
											</option>
											<option value="${I}"
												<c:if test="${feeStructure.className ==I}">selected</c:if>>${I}
											</option>
											<option value="${II}"
												<c:if test="${feeStructure.className ==II}">selected</c:if>>${II}
											</option>
											<option value="${III}"
												<c:if test="${feeStructure.className ==III}">selected</c:if>>${III}
											</option>
											<option value="${IV}"
												<c:if test="${feeStructure.className ==IV}">selected</c:if>>${IV}
											</option>
											<option value="${V}"
												<c:if test="${feeStructure.className ==V}">selected</c:if>>${V}
											</option>
											<option value="${VI}"
												<c:if test="${feeStructure.className ==VI}">selected</c:if>>${VI}
											</option>
											<option value="${VII}"
												<c:if test="${feeStructure.className ==VII}">selected</c:if>>${VII}
											</option>
											<option value="${VIII}"
												<c:if test="${feeStructure.className ==VIII}">selected</c:if>>${VIII}
											</option>
											<option value="${IX}"
												<c:if test="${feeStructure.className ==XI}">selected</c:if>>${IX}
											</option>
											<option value="${X}"
												<c:if test="${feeStructure.className ==X}">selected</c:if>>${X}
											</option>
									</select>
									</label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="ADMISSION_FEE"></fmt:message></label> <label
										class="rightLabelText"> <input type="text"
										class="num inputType" name="admission_fee" id="admission_fee"
										onkeypress="return allownumber(event)" maxlength="9" required
										placeholder="0.0"
										value='<c:out value="${feeStructure.admissionFee }"></c:out>' />
									</label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="APPLICATION_FEE"></fmt:message></label> <label
										class="rightLabelText"> <input type="text"
										class="num inputType" name="application_fee"
										id="application_fee" onkeypress="return allownumber(event)"
										maxlength="9" required placeholder="0.0"
										value='<c:out value="${feeStructure.applicationFee }"></c:out>' /></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="TUTION_FEE"></fmt:message></label> <label class="rightLabelText">
										<input type="text" class="num inputType" name="tution_fee"
										id="tution_fee" onkeypress="return allownumber(event)"
										maxlength="9" required placeholder="0.0"
										value='<c:out value="${feeStructure.tutionFee }"></c:out>' />
									</label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="BOOKS_FEE"></fmt:message></label> <label class="rightLabelText">
										<input type="text" class="num inputType" name="books_fee"
										id="books_fee" onkeypress="return allownumber(event)"
										maxlength="9" required placeholder="0.0"
										value='<c:out value="${feeStructure.booksFee }"></c:out>' />
									</label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="EXAMINATION_FEE"></fmt:message></label> <label
										class="rightLabelText"> <input type="text"
										class="num inputType" name="examination_fee"
										id="examination_fee" onkeypress="return allownumber(event)"
										maxlength="9" required placeholder="0.0"
										value='<c:out value="${feeStructure.examFee }"></c:out>' /></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="OTHER_FEE"></fmt:message></label> <label class="rightLabelText">
										<input type="text" class="num inputType" name="other_fee"
										id="other_fee" maxlength="9"
										onkeypress="return allownumber(event)" required
										placeholder="0.0"
										value='<c:out value="${feeStructure.otherFee }"></c:out>' />
									</label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelText"><fmt:message
											key="TOTAL_FEE"></fmt:message></label> <label class="rightLabelText">
										<input type="text" name="total_fee" id="total_fee"
										maxlength="9" readonly="readonly"
										style="font: bold; font-size: large;" required
										class="inputType" placeholder="0.0"
										value='<c:out value="${feeStructure.totalFee }"></c:out>' />
									</label>
								</div>
							</fieldset>
						</div>
						<div class="formButtons">
							<input type="submit" class="btnStyle" id="update" value="Update" />
							&nbsp;&nbsp; <input type="button" class="btnStyle"
								id="cancelFeeStru" value="Cancel">
						</div>
					</fmt:bundle>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="vjhsbottom.jsp" />
</body>
</html>