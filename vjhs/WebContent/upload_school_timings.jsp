<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VJHS : Holiday List Upload</title>

<script type="text/javascript" src="js_files/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js_files/jquery.dataTables.js"></script>
<link rel="stylesheet" type="text/css"
	href="css_files/jquery.dataTables.css">
<link rel="stylesheet" type="text/css" href="css_files/style.css" />
<script type="text/javascript">
	function showFile() {
		var countFiles = $('#fileToUpload')[0].files.length;
		var imgPath = $('#fileToUpload')[0].value;
		var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1)
				.toLowerCase();
		var image_holder = $('#imgDisp');
		image_holder.empty();
		if (extn == "pdf") {
			if (typeof (FileReader) != "undefined") {
				for (var i = 0; i < countFiles; i++) {
					var reader = new FileReader();
					reader.onload = function(e) {
						$('#imgDisp').html('');
						$("<embed/>", {
							"src" : e.target.result,
							"width" : 1000,
							"height" : 550
						}).appendTo(image_holder);
					}
					image_holder.show();
					reader.readAsDataURL($('#fileToUpload')[0].files[i]);
				}
			} else {
				alert("This browser does not support FileReader.");
				return;
			}
		} else {
			alert("Please Select only pdf's");
			$('#fileToUpload').val('');
			return;
		}

	}

	function nameCheck() {
		$('#imgDisp, .mes').html('');
		var uploadedFileName = $('#fileToUpload')[0].files[0].name;
		$(function() {
			var isAccepted = true;
			$
					.ajax({
						url : 'getHolidayFiles.upload',
						dataType : 'xml',
						cache : false,
						success : function(xml) {
							$(xml)
									.find('FILE')
									.each(
											function() {
												var fileName = $(this).find(
														'FILENAMES').text();
												if (fileName == uploadedFileName) {
													isAccepted = confirm("File Name is alreday exists, Do you want to override?");
												}
											});
							if (isAccepted) {
								showFile();
							} else {
								$('#fileToUpload').val('');
								return false;
							}
						}
					});
		});
	}
	function checkFile() {
		if ($('#fileToUpload').val() == '') {
			alert("Please Select a File to Upload");
			$('#fileToUpload').select().focus();
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>
	<jsp:include page="vjhstop.jsp" />
	<c:set var="page" scope="request" value="SCHEDULE" />
	<jsp:include page="vjhsmenu.jsp" />
	<div class="mainBody">
		<div class="mainBodyStyle">
			<div class="mainLeftBodyStyle">
				<div class="leftPaneHeadding">Schedules</div>
				<ul>
					<li><a href="academic_calander.schedule">Academic Calendar</a></li>
					<li class="activeLeftPane"><a href="school_timings.schedule">School
							Timings</a></li>
					<li><a href="class_tt.schedule">Class Time Table</a></li>
					<li><a href="events.schedule">Events</a></li>
					<li><a href="holidays.schedule">Holiday List</a></li>
				</ul>
			</div>
			<div class="mainRightBodyStyle">

				<div>
					<fieldset>

						<legend>School Timings</legend>
						<form method="post" action="schooltimings.upload"
							enctype="multipart/form-data" onsubmit="return checkFile();">
							<div class="fulWidth">
								<label class="leftLabelST"> Select School timings file
									to upload</label> <label class="rightLabelST"><input
									type="file" id="fileToUpload" name="uploadFile" width="20"
									height="20" onchange="nameCheck();" /></label>
							</div>
							<div class="formButtons">
								<input type="submit" class="btnStyle" value="Upload" />
							</div>
						</form>
						<div id="imgDisp"></div>
					</fieldset>
				</div>
				<div class="minHeightDiv"></div>
			</div>
		</div>
	</div>
	<jsp:include page="vjhsbottom.jsp" />
</body>
</html>