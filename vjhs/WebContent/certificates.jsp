<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VJHS:: Certificates</title>
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
					<li><a href="student_mark.examinations">Marks Report</a></li>
					<li><a href="progress_report.examinations">Progress Report</a></li>
					<li class="activeLeftPane"><a href="certificates.examinations">Certificates</a></li>
				</ul>
			</div>
			<div class="mainRightBodyStyle">
				<fmt:bundle basename="com.vjhs.labels.label">
					<div class="fulWidth">
						<div class="subsPane fontSize14 studyPane">
							<a href="javascript:studyCertificate()">Study Certificate</a>
						</div>
						<div class="subsPane fontSize14 conductPane">
							<a href="javascript:studyConductCertificate()">Study-cum-Conduct
								Certificate</a>
						</div>
						<div class="subsPane fontSize14 meritPane">
							<a href="javascript:meritCertificate()">Merit Certificate</a>
						</div>
					</div>
					<div class="fulWidth">
						<div class="study">
							<fieldset>
								<legend>Details for Study Certificate</legend>
								<form action="studyCertificate" method="post">
									<div class="fulWidth">
										<label class="leftLabel">Admission Number</label><label
											class="rightLabel"><input type="text" name="adminNo"
											class="inputType40" id="adminNo" /></label>
									</div>
									<div class="formButtons">
										<input type="submit" value="Submit" class="btnStyle" />&nbsp;&nbsp;<input
											type="reset" class="btnStyle" value="Reset" />
									</div>
								</form>
							</fieldset>
						</div>
						<div class="studyConduct">
							<fieldset>
								<legend>Details for Study-cum-Conduct Certificate</legend>
								<form action="studyConductCert" method="post">
									<div class="fulWidth">
										<label class="leftLabel">Admission Number </label><label
											class="rightLabel"> <input type="text" name="adminNo"
											class="inputType40" id="adminNo" /></label>
									</div>
									<div class="fulWidth">
										<label class="leftLabel">Conduct</label><label
											class="rightLabel"> <select name="conductType"
											class="selectType42" id="conductType">
												<option value="<fmt:message key="SELECT" />"><fmt:message
														key="SELECT" /></option>
												<option value="<fmt:message key="GOOD" />"><fmt:message
														key="GOOD" /></option>
												<option value="<fmt:message key="BAD" />"><fmt:message
														key="BAD" /></option>
												<option value="<fmt:message key="SATISFACTORY" />"><fmt:message
														key="SATISFACTORY" /></option>
										</select></label>
									</div>
									<div class="formButtons">
										<input type="submit" value="Submit" class="btnStyle" />&nbsp;&nbsp;<input
											type="reset" class="btnStyle" value="Reset" />
									</div>
								</form>
							</fieldset>
						</div>
						<div class="merit">
							<fieldset>
								<legend>Details for Merit Certificate</legend>
								<form action="meritCertificate" method="post">
									<div class="fulWidth">
										<label class="leftLabel">Class</label><label
											class="rightLabel"> <select name="className"
											class="selectType42" id="classType"
											onchange="getStudentsAdminData()">
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
										</select></label>
									</div>
									<div class="fulWidth">
										<label class="leftLabel">Name</label><label class="rightLabel">
											<input type="text" name="nameToCerify" id="nameToCerify"
											class="inputType40" />
										</label>
									</div>
									<div class="fulWidth">
										<label class="leftLabel">Secured</label><label
											class="rightLabel"> <input type="text" name="secured"
											class="inputType40" id="secured" /></label>
									</div>
									<div class="fulWidth">
										<label class="leftLabel">Event Name</label><label
											class="rightLabel"> <input type="text"
											name="eventName" id="eventName" class="inputType40" /></label>
									</div>
									<div class="fulWidth">
										<label class="leftLabel">Year</label><label class="rightLabel">
											<input type="text" name="year" id="year" class="inputType40" />
										</label>
									</div>
									<div class="fulWidth">
										<label class="leftLabel">Occasion</label><label
											class="rightLabel"> <input type="text"
											name="occasion" id="occasion" class="inputType40" /></label>
									</div>
									<div class="formButtons">
										<input type="button" value="Submit" class="btnStyle mrtCertBtn" />&nbsp;&nbsp;<input
											type="reset" class="btnStyle" value="Reset" />
									</div>
								</form>
							</fieldset>
						</div>
						<div class="mrtCertificate desc">
							<fieldset id="meritCertificate">
								<!-- <div class="fulWidth">
									<h1 class="descStyle alignCenter">Certificate of Merit</h1>
								</div>
								<div class="fulWidth">
									This is to certify that <label class="descStyle" id="meritName">Mr.
										Phanangipalli Phani Pavan</label> of class <label class="descStyle"
										id="meritClass">9th </label> of <label class="descStyle"
										id="schoolPlace">VIGNANA JYOTHI High SCHOOL,Nadakuduru</label>
									secured <label class="descStyle" id="ranking">1st place</label>
									in <label class="descStyle" id="eventName"> Sports and
										Games </label> for the year<label class="descStyle" id="eventYear">
										2005</label> and awarded this Certificate of merit on the occasion of
									<label class="descStyle" id="eventName">Anual Day</label>.
								</div>
								<div class="fulWidth">
									<div class="fulWidth">Date:</div>
									<div class="fulWidth">
										<div class="width33">Place:</div>
										<div class="width33 alignCenter">Correspondent</div>
										<div class="width33 alignright">Principal</div>

									</div>

								</div> -->
								<jsp:include page="meritCertificate.jsp"></jsp:include>
								<div class="formButtons">
									<input type="button" value="Print" class="btnStyle"
										onclick="getPrint('meritCertificate')" />
								</div>
							</fieldset>
						</div>

					</div>
				</fmt:bundle>
			</div>
		</div>
	</div>
	<jsp:include page="vjhsbottom.jsp" />
	<script type="text/javascript">
		$(function() {
			studyCertificate();
		});
	</script>
</body>
</html>