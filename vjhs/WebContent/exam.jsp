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
					<li><a href="subjects.examinations">Subjects</a></li>
					<li class="activeLeftPane"><a href="schedule.examinations">Schedule</a></li>
					<li><a href="student_mark.examinations">Marks Report</a></li>
					<li><a href="progress_report.examinations">Progress Report</a></li>
					<li><a href="certificates.examinations">Certificates</a></li>
				</ul>
			</div>
			<div class="mainRightBodyStyle">
				<form action="addSchedule.examinations" name="scheduleForm"
					id="scheduleForm">
					<fmt:bundle basename="com.vjhs.labels.label">
						<div>
							<fieldset>
								<legend>View / Update Examination Schedule</legend>
								<div class="fulWidth">
									<label class="leftLabelST">Examination Type</label> <label
										class="rightLabelST"><select name="examType"
										id="examType" onchange="checkExamType()">
											<option value="">Select</option>
											<option value="<fmt:message key="EX1" />"><fmt:message
													key="FA1" /></option>
											<option value="<fmt:message key="EX2" />"><fmt:message
													key="FA2" /></option>
											<option value="<fmt:message key="EX3" />"><fmt:message
													key="FA3" /></option>
											<option value="<fmt:message key="EX4" />"><fmt:message
													key="FA4" /></option>
											<option value="<fmt:message key="EX5" />"><fmt:message
													key="SA1" /></option>
											<option value="<fmt:message key="EX6" />"><fmt:message
													key="SA2" /></option>
											<option value="<fmt:message key="EX7" />"><fmt:message
													key="PAE" /></option>
											<option value="<fmt:message key="EX8" />"><fmt:message
													key="AE" /></option>
									</select><select name="exTypeYear" id="exTypeYear" class="exTypeYear"
										onchange="checkExamYear()">
											<option value="">Select</option>
											<option value="2015">2015</option>
											<option value="2016">2016</option>
											<option value="2017">2017</option>
											<option value="2018">2018</option>
											<option value="2019">2019</option>
											<option value="2020">2020</option>
									</select></label>
								</div>
								<div class="fulWidth">
									<label class="leftLabelST">Class</label> <label
										class="rightLabelST"><select name="className"
										id="classType" onchange="getStudentsAdminData()">
											<option value=""><fmt:message key="SELECT" />
											</option>
											<option value="nursery"><fmt:message key="NURSERY" />
											</option>
											<option value="lkg"><fmt:message key="LKG" />
											</option>
											<option value="ukg"><fmt:message key="UKG" />
											</option>
											<option value="first"><fmt:message
													key="FIRST_STANDARD" />
											</option>
											<option value="second"><fmt:message
													key="SECOND_STANDARD" />
											</option>
											<option value="third"><fmt:message
													key="THIRD_STANDARD" />
											</option>
											<option value="fourth"><fmt:message
													key="FOURTH_STANDARD" />
											</option>
											<option value="fifth"><fmt:message
													key="FIFTH_STANDARD" />
											</option>
											<option value="sixth"><fmt:message
													key="SIXTH_STANDARD" />
											</option>
											<option value="seventh"><fmt:message
													key="SEVENTH_STANDARD" />
											</option>
											<option value="eight"><fmt:message
													key="EIGHT_STANDARD" />
											</option>
											<option value="nineth"><fmt:message
													key="NINETH_STANDARD" />
											</option>
											<option value="tenth"><fmt:message
													key="TENTH_STANDARD" />
											</option>
									</select></label>
								</div>
								<div class="fulWidth frmDate noHide">
									<label class="leftLabelST">From Date</label> <label
										class="rightLabelST"><input type="text" readonly
										class="futuredatepicker" name="examFrmDate" id="examFrmDate"></label>
								</div>
								<div class="fulWidth toDate noHide">
									<label class="leftLabelST">To Date</label> <label
										class="rightLabelST"><input type="text" readonly
										class="futuredatepicker" name="examToDate" id="examToDate"></label>
								</div>
								<div class="fulWidth">
									<table class="display compact tabWidth noHide">
										<thead>
											<tr>
												<th>Subject</th>
												<th>Date</th>
												<th>Time</th>
												<th>Delete</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
								</div>
							</fieldset>
						</div>
						<div class="formButtons">
							<input type="submit" value="Add / Update" class="btnStyle" />&nbsp;&nbsp;<input
								type="reset" class="btnStyle" value="Reset" />
						</div>
					</fmt:bundle>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="vjhsbottom.jsp" />
	<script type="text/javascript">
	$(function() {
		$('#examToDate')
				.change(
						function() {
							var date1 = $('#examFrmDate').datepicker('getDate');
							var date2 = $('#examToDate').datepicker('getDate');
							var dateFrom = new Date(Date.parse(date1));
							var dateTo = new Date(Date.parse(date2));
							var i = 1;
							$('.tabWidth').attr('id', '');
							$('.tabWidth tbody').html("");
							$
									.ajax({
										type : "POST",
										url : "getSubList.examinations",
										dataType : "xml",
										cache : false,
										success : function(xml) {
											var temp = "";
											$(xml)
													.find('SUBJECT')
													.each(
															function() {
																var id = $(this)
																		.find(
																				'SUBJECTID')
																		.text();
																var name = $(
																		this)
																		.find(
																				'SUBJECTNAME')
																		.text();
																temp += '<option value='+id+' >'
																		+ name
																		+ '</option>';
															});
											for (; $.datepicker.formatDate(
													"dd/mm/yy", new Date(
															dateFrom)) <= $.datepicker
													.formatDate("dd/mm/yy",
															new Date(dateTo));) {
												$('.tabWidth tbody')
														.append(
																'<tr><td><select name="sub'+i+'"><option value="">Select</option>'
																		+ temp
																		+ '</select></td><td><input type="text" readonly name="date'+i+'" id="date'+i+'"/></td><td><input type="text" name="time'+i+'"/></td><td><a href="#" class="removeTr">Delete</a></td></tr>');
												var dateId = "#date" + i;
												var newDate = dateFrom
														.toDateString();
												newDate = new Date(Date
														.parse(newDate));
												$(dateId)
														.val(
																$.datepicker
																		.formatDate(
																				"dd/mm/yy",
																				new Date(
																						dateFrom)));
												dateFrom.setDate(dateFrom
														.getDate() + 1);
												i++;
											}
											$('.tabWidth')
													.attr('id', 'example');
											$('.tabWidth')
													.removeClass('noHide');

											$('.tabWidth input').css({
												"background" : "none",
												"width" : "150px"
											});

											$('.tabWidth select').css({
												"background" : "none",
												"width" : "154px"
											});
											$('#example').dataTable({
												destroy : true,
												retrieve : true,
												paging : false,
												searching : false,
												info : false,
												"bSort" : false
											});
										},
										error : function() {
											alert("An error occurred while processing XML file.");
										}
									});

						});

		$(document).on('click', '.removeTr', function() {
			$(this).closest('tr').remove();
			return false;
		});

	});
</script>
</body>
</html>