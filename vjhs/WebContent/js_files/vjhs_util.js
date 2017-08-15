/**
 * 
 */

$(function() {

	$(".datepicker").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : 'dd/mm/yy'
	});

	/*
	 * $(".num").each(function() { $(this).keyup(function() { var sum =
	 * calculateSum(); $("#total_fee").val(sum); }); });
	 */

});

function studyCertificate() {
	$('.studyPane').addClass("activeBottomPane");
	$('.conductPane,.meritPane').removeClass("activeBottomPane");
	$('.viewFullRight,.study').show();
	$('.studyConduct,.merit').hide();
}

function studyConductCertificate() {
	$('.conductPane').addClass("activeBottomPane");
	$('.studyPane,.meritPane').removeClass("activeBottomPane");
	$('.viewFullRight,.studyConduct').show();
	$('.study,.merit').hide();
}

function meritCertificate() {
	$('.meritPane').addClass("activeBottomPane");
	$('.conductPane,.studyPane').removeClass("activeBottomPane");
	$('.viewFullRight,.merit').show();
	$('.study,.studyConduct').hide();
}
function getPrint(id) {
	/* $("#" + id).print(); */
	window.print();
}
function onChangeClass() {
	var count = 0;
	var className = $('#className option:selected').val();
	if (className != '') {
		$(function() {
			var urlPat = "getClasstt.schedule?className=" + className;
			$.ajax({
				type : "POST",
				url : urlPat,
				datatype : "xml",
				async : "true",
				beforeSend : function() {
					$('.classTTable select').val('');
				},
				success : function(xml) {
					$(xml).find('LEVEL').each(function() {
						var day = $(this).find("DAY").text();
						var dayVal = getDayVal(day);
						$('#a' + dayVal).val($(this).find("PD1").text());
						$('#b' + dayVal).val($(this).find("PD2").text());
						$('#c' + dayVal).val($(this).find("PD3").text());
						$('#d' + dayVal).val($(this).find("PD4").text());
						$('#e' + dayVal).val($(this).find("PD5").text());
						$('#f' + dayVal).val($(this).find("PD6").text());
						$('#g' + dayVal).val($(this).find("PD7").text());
						$('#h' + dayVal).val($(this).find("PD8").text());
					});
					$(".classTTable select").each(function() {
						if (this.value != "") {
							count++;
						}
					});
					if (count == 0) {
						$('.subCList').css({
							"border" : "1px solid #808080",
						});
						$('.classTTable select').prop('disabled', false);
						$('#edit').hide();
						$('#submit').show();
						$('#reset').show();
					} else {
						$('.subCList').css({
							"border" : "1px solid #fff",
						});
						$('#edit').show();
						$('#submit').hide();
						$('#reset').hide();
						$('.classTTable select').prop('disabled', true);
					}
					$('.classTTable').removeClass("noHide");
				},
				error : function() {
					alert("Error occured while getting XML");
				}
			});
		});
	} else {
		$('.classTTable').addClass("noHide");
	}
}

function showReset(){
	$('#reset').show();
}

$(function() {
	$("#edit").click(function() {
		$('.subCList').css({
			"border" : "1px solid #808080",
		});
		$('.classTTable select').prop('disabled', false);
		$('#edit').hide();
		$('#submit').show();
	});
});

function getDayVal(day) {
	var dayVal = -1;
	if (day == 'MON') {
		dayVal = 1;
	} else if (day == 'TUE') {
		dayVal = 2;
	} else if (day == 'WED') {
		dayVal = 3;
	} else if (day == 'THU') {
		dayVal = 4;
	} else if (day == 'FRI') {
		dayVal = 5;
	} else if (day == 'SAT') {
		dayVal = 6;
	}
	return dayVal;
}

function calculateSum() {
	var sum = 0;
	$(".num").each(function() {
		if (!isNaN(this.value) && this.value.length != 0) {
			sum += parseFloat(this.value)
		}
	});
	return sum;
}
function checkExamType() {
	var examYear = $('#examType option:selected').val();
	if (examYear == '') {
		$('.frmDate,.toDate').addClass('noHide');
		$("#classType").prop("selectedIndex", 0);
	}
}
function checkExamYear() {
	var examYear = $('#exTypeYear option:selected').val();
	if (examYear == '') {
		$('.frmDate,.toDate').addClass('noHide');
		$("#classType").prop("selectedIndex", 0);
	}
}
function getStudentsAdminData() {
	var selVal = $('#classType option:selected').val();
	var exTypeYear = $('#exTypeYear option:selected').val();
	var examYear = $('#examType option:selected').val();
	if (exTypeYear == '' || examYear == '') {
		alert('Please Select Exam Type and Year');
		return;
	}
	if (selVal != '') {
		$('.frmDate,.toDate').removeClass('noHide');
	} else {
		$('.frmDate,.toDate').addClass('noHide');
	}
}

function getStudentData() {

}

function calculateSum(input) {
	var sum = 0;
	var sumval = $("#totalMark").val()
	if (!isNaN(sumval) && sumval.length != 0) {
		sum = parseFloat(sumval);
	}
	if (!isNaN(input.value) && input.value.length != 0) {
		sum += parseFloat(input.value);
		alert(sum)
		$("#totalMark").val(sum);
	}
}
/*
 * function getStudentsAdminData() { if ($('#examType').val() != '') { //
 * alert('To get class Admin No for AJAX'); $('.adminNoDiv').show(); } else {
 * alert('Please select Examination Name first');
 * $('#classType').prop('selectedIndex', 0); } }
 */
function getTableData() {
	$(function() {
		var sendURL = 'getMarkRpt.examinations?className=' + $('#className option:selected').val() + '&adminNo='
				+ $('#admissionNo option:selected').val() + "&examType=" + $('#examType option:selected').val();
		$.ajax({
			type : "POST",
			url : sendURL,
			dataType : "xml",
			cache : false,
			beforeSend : function() {
				$('.reportTab td input, .reportTab td select').val('');
				$('.reportTab span').html('');
			},
			success : function(xml) {
				$(xml).find('LEVEL').each(function() {
					var subject = $(this).find('SUBJECT').text();
					var marks = $(this).find('MARKS').text();
					var gPoint = $(this).find('GPOINT').text();
					var month = $(this).find('MONTH').text();
					$('#mark' + subject).val(marks);
					$('#mark' + subject + 'Grd').html(gPoint);
					$('#mark' + subject + 'Grd1').val(gPoint);
					$('#monthAttn').val(month);
				});
				totalMarks();
				if ($('#monthAttn').val() != '') {
					getWorkingDays();
				}
				enableAddEdit();
				$('.reportDiv').removeClass('noHide');
			},
			error : function() {
				alert("An error occurred while processing XML file.");
			}
		});
	});
	/* $('.getAfterAdminNo').show(); */
}

function enableAddEdit() {
	if ($('.reportTab td input').val() != '' && $('.reportTab td select').val() != '') {
		$('.reportTab td input').attr("readonly", true).css({
			"border" : "none",
			"background" : "none"
		});
		$('.reportTab td select').attr("disabled", true).css({
			"border" : "none",
			"background" : "none"
		});
		$('#submit').hide();
		$('#edit').show();
	} else {
		$('.reportTab td input').attr("readonly", false).css({
			"border" : "1px soild #808080",
			"background" : "#fff"
		});
		$('.reportTab td select').attr("disabled", false).css({
			"border" : "1px soild #808080",
			"background" : "#fff"
		});
		$('#edit').hide();
		$('#submit').show();
	}
}

function handleChange(input) {
	if ((input.value < 0) || (input.value > 100)) {
		alert('Mark should be in between 0 and 100');
		input.value = "";
		input.focus();
		return;
	} else {
		var mark = input.value
		average = (mark / 100) * 100;
		var gpa = 'F';
		if ((average >= 40) && (average <= 50)) {
			gpa = 'C';
		} else if ((average > 50) && (average <= 60)) {
			gpa = 'C+';
		} else if ((average > 60) && (average <= 70)) {
			gpa = 'B';
		} else if ((average > 70) && (average <= 80)) {
			gpa = 'B+';
		} else if ((average > 80) && (average <= 90)) {
			gpa = 'A';
		} else if ((average > 90) && (average <= 100)) {
			gpa = 'A+';
		}
		$('#' + input.id + "Grd").html(gpa);
		$('#' + input.id + "Grd1").val(gpa);
	}
}

function isNumber(evt) {
	evt = (evt) ? evt : window.event;
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		return false;
	}
	return true;
}

function totalMarks() {
	var sum = 0;
	var average = 0;
	$(".num ").each(function() {
		if ($(this).val() && ($(this).val()).length != 0) {
			sum += parseFloat($(this).val());
		}
		average = (sum / 600) * 100;
		var gpa = 0;
		if ((average >= 40) && (average <= 50)) {
			gpa = 5;
		} else if ((average > 50) && (average <= 60)) {
			gpa = 6;
		} else if ((average > 60) && (average <= 70)) {
			gpa = 7;
		} else if ((average > 70) && (average <= 80)) {
			gpa = 8;
		} else if ((average > 80) && (average <= 90)) {
			gpa = 9;
		} else if ((average > 90) && (average <= 100)) {
			gpa = 10;
		}
		$("#totalMark").html(sum);
		$('#marksaverage').html(Number((average).toFixed(2)));
		$('#gpa').html(gpa);
	});
}

function clearMarks() {
	$(".num ").each(function() {
		$(this).val('');
	});
	$(".total").val('');
	$('#marksaverage').val("");
}

function getWorkingDays() {
	$(function() {
		var sendURL = 'getOneMonthDet.examinations?className=' + $('#className option:selected').val() + '&adminNo='
				+ $('#admissionNo option:selected').val() + '&month=' + $('#monthAttn option:selected').val();
		$.ajax({
			type : "POST",
			url : sendURL,
			dataType : "xml",
			cache : false,
			beforeSend : function() {
				$('#workingDays').html('');
				$('#presentDays').html('');
			},
			success : function(xml) {
				$(xml).find('MONTH_ATTEN').each(function() {
					var presentDays = $(this).find('PRESENT_DAYS').text();
					var workingDays = $(this).find('WORKING_DAYS').text();
					$('#workingDays').html(workingDays);
					$('#presentDays').html(presentDays);
					var average = (presentDays / workingDays) * 100;
					$('#attendanceaverage').html(Number((average).toFixed(2)));
				});
			},
			error : function() {
				alert("An error occurred while processing XML file.");
			}
		});
	});
}

function getAdminssionNumbesByClassName() {
	$(function() {
		$('.marksRprtDiv').addClass('noHide');
		var sendURL = 'getAdminssionNumbesByClassName.examinations?className=' + $('#className option:selected').val();
		$.ajax({
			type : "POST",
			url : sendURL,
			dataType : "xml",
			cache : false,
			success : function(xml) {
				$('#admissionNo').find('option').not(':first').remove();
				$(xml).find('ADMISSION').each(function() {
					var temp = '';
					var temp2 = '';
					var adminNo = $(this).find('NUMBER').text();
					var name = $(this).find('NAME').text();
					temp2 = '<option value=' + adminNo + ' >' + name + " / " + adminNo + '</option>';
					$("#admissionNo").append(temp2);
				});
				$('#classHead').html($('#className option:selected').val());
			},
			error : function() {
				alert("An error occurred while processing XML file.");
			}
		});
	});
}

function getStudentsNames() {
	$(function() {
		var sendURL = 'getStudentName.examinations?className=' + $('#className option:selected').val();
		$.ajax({
			type : "POST",
			url : sendURL,
			dataType : "xml",
			cache : false,
			success : function(xml) {
				$('#studentName').find('option:not(:first)').remove();
				$('#admissionNo').find('option').not(':first').remove();
				$(xml).find('STUDENT').each(function() {
					var temp = '';
					var temp2 = '';
					var name = $(this).find('NAME').text();
					var adminNo = $(this).find('ADMIN_NO').text();
					temp = '<option value=' + adminNo + ' >' + name + '</option>';
					temp2 = '<option value=' + adminNo + ' >' + adminNo + '</option>';
					$('#studentName').append(temp);
					$("#admissionNo").append(temp2);
				});
			},
			error : function() {
				alert("An error occurred while processing XML file.");
			}
		});
	});
}
function getStudentAdminNo() {

	$(function() {
		var count = 1;
		$.ajax({
			type : 'POST',
			url : 'getMonthDet.examinations',
			data : {
				'className' : $('#className option:selected').val(),
				'adminNo' : $('#admissionNo option:selected').val()
			},
			dataType : 'xml',
			cache : false,
			success : function(xml) {
				$(xml).find('MONTH_ATTEN').each(function() {
					var temp = '';
					var presentDays = $(this).find('PRESENT_DAYS').text();
					var workingDays = $(this).find('WORKING_DAYS').text();
					var percentage = $(this).find('PERCENTAGE').text();
					var cumulative = $(this).find('VALUE').text();
					$('#a' + count).val(presentDays);
					$('#w' + count).val(workingDays);
					$('#mp' + count).val(percentage);
					count++;
					if (cumulative != 0) {
						$('#cumPercentage').html(cumulative);
						cululative = 0;
					}
				});
				if ($('#cumPercentage').html() == '') {
					$('#cumPercentage').html('0.0');
				}
			},
			error : function() {
				alert("An error occurred while processing XML file.");
			}
		});
	});
}

function calPercentage(id) {
	var sub = id.substring(1, id.length);
	var subNo = parseFloat(sub) - 1;
	if (subNo >= 1) {
		var subVal = parseFloat($('#a' + subNo).val());
		if (subVal == '0' || isNaN(subVal)) {
			alert("Please enter Previous Month Attendance");
			$('#' + id).val('0.0');
			$('#a' + subNo).select();
			return;
		}
	}
	var attenDays = parseFloat($("#" + id).val());
	var workingDays = parseFloat($('#w' + sub).val());
	if (attenDays > workingDays) {
		alert('Number of Attended days should be less than or equals to Number of Working days');
		$('#' + id).val('0.0');
		$('#' + id).select();
		return;
	}
	if (attenDays == '' || isNaN(attenDays)) {
		$('#' + id).val('0.0');
		$('#mp' + sub).val('0.0');
		return;
	}
	var percentage = (attenDays * 100) / workingDays;
	$('#mp' + sub).val(round(percentage, 2));
	calCumulative(sub);
}

function calCumulative(sub) {
	var percentage = 0;
	var count = 0;
	var perCount = 0;
	for (count = 1; count <= sub; count++) {
		perCount = $('#mp' + count).val();
		percentage += parseFloat(perCount);
	}
	var cumPercentage = (percentage / sub);
	$('#cumPercentage').html(round(cumPercentage, 2));
}
function round(value, exp) {
	if (typeof exp === 'undefined' || +exp === 0)
		return Math.round(value);

	value = +value;
	exp = +exp;

	if (isNaN(value) || !(typeof exp === 'number' && exp % 1 === 0))
		return NaN;

	// Shift
	value = value.toString().split('e');
	value = Math.round(+(value[0] + 'e' + (value[1] ? (+value[1] + exp) : exp)));

	// Shift back
	value = value.toString().split('e');
	return +(value[0] + 'e' + (value[1] ? (+value[1] - exp) : -exp));
}

function addSubject() {
	$(".addSubjectPane").show();
	$('.updateSubjectPane').hide();
}

function editSub() {
	if ($('#subjectName:checked').size() == 0) {
		alert("Please Select atleast one subject");
		$(".updateSubjectPane").hide();
	} else if ($('#subjectName:checked').size() > 1) {
		alert("You cannot edit more than one subject at a time");
		$(".updateSubjectPane").hide();
	} else {
		$(".updateSubjectPane").show();
		$('.addSubjectPane').hide();
		$('#editSubName').val($('#subjectName:checked').val());
		var subId = $('#subjectName:checked').val();
		subId = '#' + subId;
		subId = subId.replace(/\s+/g, '');
		$('#editSubId').val($(subId).val());
	}
}

function deleteSubjects() {
	if ($('input:checkbox[name="subjectName"]:checked').size() == 0) {
		alert("Please Select atleast one subject");
	} else if ($('input:checkbox[name="subjectName"]:checked').size() > 1) {
		alert("You cannot delete more than one subject at a time");
	} else {
		var isDelete = confirm("delete subjects:" + $('#subjectName:checked').val());
		if (isDelete) {
			var subId = $('#subjectName:checked').val();
			subId = '#' + subId;
			subId = subId.replace(/\s+/g, '');
			location.href = "deleteSubjects.examinations?subjectId=" + $(subId).val();
		}
	}
}

function creSelect(id) {
	var select = '<select name="attSta'
			+ id
			+ '" id="attSta'
			+ id
			+ '" class="selectType42" onchange="javascript:toSetHoliday(id)"><option value="">Select</option><option value="Present">Present</option><option value="Absent">Absent</option><option value="Half-Day">Half-Day</option><option value="Leave">Leave</option><option value="Holiday">Holiday</option></select>'
	return select;
}

function toSetHoliday(id) {
	var attenSta = $('#' + id).val();
	if (attenSta == 'Holiday') {
		$("select").val("Holiday");
	}
}

function getTeacherMonthAtData() {
	var selectedDate = $('#teacherAtDate').val();
	alert('Ajax call to get the details of teachers month report');
	$('.toGetDataForMonth').show();
}

function getEmpData() {
	var urlPat = "getTeacherStatus.teacher?selectedDate=" + $('#teacherAtDate').val();
	$(function() {
		$.ajax({
			type : "POST",
			url : urlPat,
			datatype : "xml",
			async : "true",
			success : function(xml) {
				$('.showTab').addClass("noHide");
				$('.teachAttenTab > tbody').empty();
				$(xml).find('EMP').each(
						function() {
							$('.teachAttenTab > tbody').append(
									'<tr><th>' + $(this).find('EMP_NAME').text() + '</th><td>' + creSelect($(this).find('EMP_ID').text())
											+ '</td></tr>');
							if ($(this).find('EMP_STATUS').text() != '' && $(this).find('EMP_STATUS').text() != 'null') {
								$('#attSta' + $(this).find('EMP_ID').text()).val($(this).find('EMP_STATUS').text());
							}
							$('.showTab').removeClass("noHide");
						});
			},
			error : function() {
				alert("Error occured while getting XML");
			}
		});
	});
}

function onChangeTeacher() {
	var empId = $('#empId option:selected').val();
	if (empId == '') {
		$('.techrTable').addClass('noHide');
		$('.showClassData').hide();
	} else {
		var urlPat = "getTeachertt.teacher?empId=" + empId;
		$(function() {
			$.ajax({
				type : "POST",
				url : urlPat,
				datatype : "xml",
				async : "true",
				beforeSend : function() {
					$('.teachTimTbl select').val('');
				},
				success : function(xml) {
					$(xml).find('LEVEL').each(function() {
						var day = $(this).find("DAY").text();
						var dayVal = getDayVal(day);
						$('#a' + dayVal).val($(this).find("PD1").text());
						$('#b' + dayVal).val($(this).find("PD2").text());
						$('#c' + dayVal).val($(this).find("PD3").text());
						$('#d' + dayVal).val($(this).find("PD4").text());
						$('#e' + dayVal).val($(this).find("PD5").text());
						$('#f' + dayVal).val($(this).find("PD6").text());
						$('#g' + dayVal).val($(this).find("PD7").text());
						$('#h' + dayVal).val($(this).find("PD8").text());
						$('#aC' + dayVal).val($(this).find("PCD1").text());
						$('#bC' + dayVal).val($(this).find("PCD2").text());
						$('#cC' + dayVal).val($(this).find("PCD3").text());
						$('#dC' + dayVal).val($(this).find("PCD4").text());
						$('#eC' + dayVal).val($(this).find("PCD5").text());
						$('#fC' + dayVal).val($(this).find("PCD6").text());
						$('#gC' + dayVal).val($(this).find("PCD7").text());
						$('#hC' + dayVal).val($(this).find("PCD8").text());
					});
					var count = 0;
					$(".teachTimTbl select").each(function() {
						if (this.value != "") {
							count++;
						}
					});
					if (count == 0) {
						$('.clsList').css({
							"border-top" : "1px solid #808080",
							"border-bottom" : "1px solid #808080",
							"border-left" : "1px solid #808080"
						});
						$('.subList').css({
							"border-top" : "1px solid #808080",
							"border-bottom" : "1px solid #808080",
							"border-right" : "1px solid #808080"
						});
						$('.teachTimTbl select').prop('disabled', false);
						$('#edit').hide();
						$('#submit').show();
					} else {
						$('.clsList').css({
							"border-top" : "1px solid #fff",
							"border-bottom" : "1px solid #fff",
							"border-left" : "1px solid #fff"
						});
						$('.subList').css({
							"border-top" : "1px solid #fff",
							"border-bottom" : "1px solid #fff",
							"border-right" : "1px solid #fff"
						});
						$('#edit').show();
						$('#submit').hide();
						$('.teachTimTbl select').prop('disabled', true);
					}
				},
				error : function() {
					alert("Error occured while getting XML");
				}
			});
		});
		$('.techrTable').removeClass('noHide');
	}
}
function getDayVal(day) {
	var dayVal = -1;
	if (day == 'MON') {
		dayVal = 1;
	} else if (day == 'TUE') {
		dayVal = 2;
	} else if (day == 'WED') {
		dayVal = 3;
	} else if (day == 'THU') {
		dayVal = 4;
	} else if (day == 'FRI') {
		dayVal = 5;
	} else if (day == 'SAT') {
		dayVal = 6;
	}
	return dayVal;
}

$(function() {
	$("#edit").click(function() {
		$('.clsList').css({
			"border-top" : "1px solid #808080",
			"border-bottom" : "1px solid #808080",
			"border-left" : "1px solid #808080"
		});
		$('.subList').css({
			"border-top" : "1px solid #808080",
			"border-bottom" : "1px solid #808080",
			"border-right" : "1px solid #808080"
		});
		$('.reportTab td input').attr("readonly", false).css({
			"border" : "1px soild #808080",
			"background" : "#fff"
		});
		$('.reportTab td select').attr("disabled", false).css({
			"border" : "1px soild #808080",
			"background" : "#fff"
		});
		$('.teachTimTbl select').prop('disabled', false);
		$('#edit').hide();
		$('#submit').show();
	});
});

function resetFields() {
	$('tr select').val("");
}

function resetReportData() {
	$('td select').val("");
	$('td input').val("");
	$('td span').html("");
}

function getAllMarks() {
	$(function() {
		var sendURL = 'getallmarks.examinations?className=' + $('#className option:selected').val() + '&admissionNo='
				+ $('#admissionNo option:selected').val();
		$.ajax({
			type : "POST",
			url : sendURL,
			dataType : "xml",
			cache : false,
			beforeSend : function() {
				$('.marksRprtDiv').addClass('noHide');
				$('#adminNoHead').html($('#admissionNo option:selected').val());
				$('#nameHead').html($('#admissionNo option:selected').text());
			},
			success : function(xml) {
				console.log(xml);
				$(xml).find('LEVEL').each(function() {
					var exType = $(this).find('EXTYPE').text();
					var sub = $(this).find('SUB').text();
					var marks = $(this).find('MARKS').text();
					var gp = $(this).find('GP').text();
					$('#' + exType + "Mark" + sub).html(marks);
					$('#' + exType + "Grade" + sub).html(gp);
				});
				fa1Det();
				fa2Det();
				fa3Det();
				fa4Det();
				sa1Det();
				sa2Det();
				calFACGPA();
				calSACGPA();
				aeDet();
				cgpa();
				$('.marksRprtDiv').removeClass('noHide');
			},
			error : function() {
				alert("An error occurred while processing XML file.");
			}
		});
	});
}

function fa1Det() {
	var marks = 0;
	$('[id^="FA1Mark"]').each(function() {
		marks += parseFloat($('#' + this.id).html());
	});
	$('#GPAFA1').html(calculateGPA(marks));
}
function fa2Det() {
	var marks = 0;
	$('[id^="FA2Mark"]').each(function() {
		marks += parseFloat($('#' + this.id).html());
	});
	$('#GPAFA2').html(calculateGPA(marks));
}
function fa3Det() {
	var marks = 0;
	$('[id^="FA3Mark"]').each(function() {
		marks += parseFloat($('#' + this.id).html());
	});
	$('#GPAFA3').html(calculateGPA(marks));
}
function fa4Det() {
	var marks = 0;
	$('[id^="FA4Mark"]').each(function() {
		marks += parseFloat($('#' + this.id).html());
	});
	$('#GPAFA4').html(calculateGPA(marks));
}

function sa1Det() {
	var marks = 0;
	$('[id^="SA1Mark"]').each(function() {
		marks += parseFloat($('#' + this.id).html());
	});
	$('#GPASA1').html(calculateGPA(marks));
}

function sa2Det() {
	var marks = 0;
	$('[id^="SA2Mark"]').each(function() {
		marks += parseFloat($('#' + this.id).html());
	});
	$('#GPASA2').html(calculateGPA(marks));
}

function calFACGPA() {
	var marks = 0;
	var count = 0;
	$('[id^="GPAFA"]').each(function() {
		marks += parseFloat($('#' + this.id).html());
		count++;
	});
	$('#CGPAFA').html(marks / count);
}
function calSACGPA() {
	var marks = 0;
	var count = 0;
	$('[id^="GPASA"]').each(function() {
		marks += parseFloat($('#' + this.id).html());
		count++;
	});
	$('#CGPASA').html(marks / count);
}

function aeDet() {
	var marks = 0;
	$('[id^="AEMark"]').each(function() {
		marks += parseFloat($('#' + this.id).html());
	});
	$('#CGPAAE').html(calculateGPA(marks));
}

function cgpa() {
	var cgpa = 0;
	cgpa += parseFloat($('#CGPAFA').html());
	cgpa += parseFloat($('#CGPASA').html());
	cgpa += parseFloat($('#CGPAAE').html());
	$('#CGPA').html(round(cgpa / 3,2));
}

function calculateGPA(marks) {
	var average = (marks / 600) * 100;
	var gpa = 0;
	if ((average >= 40) && (average <= 50)) {
		gpa = 5;
	} else if ((average > 50) && (average <= 60)) {
		gpa = 6;
	} else if ((average > 60) && (average <= 70)) {
		gpa = 7;
	} else if ((average > 70) && (average <= 80)) {
		gpa = 8;
	} else if ((average > 80) && (average <= 90)) {
		gpa = 9;
	} else if ((average > 90) && (average <= 100)) {
		gpa = 10;
	}
	return gpa;
}

function clearAttendanceFields(){
	$('.attended input').val('');
	$('.attpercent input').val('');
	$('#cumPercentage').html('0.0');
	
}
