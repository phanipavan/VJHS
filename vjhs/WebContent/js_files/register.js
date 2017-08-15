/*function showTC() {
	if ($("#tcYes").is(":checked")) {
		alert('hi');
		$(".noHide").show();
		$('.noHide').css({
			'style' : 'width:100px'
		});
	} else if ($("#tcNo").is(":checked")) {
		alert('hello');
		$(".noHide").hide();
	}
}*/

function allowonlynumber(key) {
	var datakey = (key.which) ? key.which : key.keyCode;// capturing pressed key
	var textboxdata = document.getElementById("phone_no");// capturing Text
	// box reference
	if (datakey == 46)// allowing delete key
		return true;
	else if (datakey == 8)// allowing backspace key
		return true;
	else if ((datakey < 48 || datakey > 57))// avoiding characters other than
		// digits
		return false;
	else if (textboxdata.value.length < 10)// restricting more than 10 digits
		return true;

}

function getAddress() {

	if (document.getElementById("add").checked == true) {
		var address = document.getElementById("residence").value;
		document.getElementById("father_address").value = address;
		father_address.setAttribute('readonly', 'readonly');
	} else {
		document.getElementById("father_address").value = "";
		father_address.removeAttribute('readonly');
	}

}

function submitGetFeeStru() {
	$("#submitClass").submit();
}

// add the rule here
$.validator.addMethod("valueNotEquals", function(value, element, arg) {

	return arg != value;
}, "Value must not equal arg.");

$(function() {
	$(".datepicker").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : 'dd/mm/yy',
		maxDate : new Date()
	});

	$(".futuredatepicker").datepicker({
		changeMonth : true,
		changeYear : true,
		dateFormat : 'dd/mm/yy'
	});
	$("#registrationform")
			.validate(
					{
						rules : {
							admission_no : {
								required : true,
								minlength : 8,
							},
							doa : {
								required : true
							},
							name : {
								required : true,
								minlength : 5,
							},
							dob : {
								required : true
							},
							gender : {
								valueNotEquals : "select"
							},
							state : {
								required : true,
								minlength : 3,
							},
							religion : {
								required : true,
								minlength : 4,
							},
							caste : {
								required : true,
								minlength : 4,
							},
							coc : {
								valueNotEquals : "Select"
							},
							mother_tongue : {
								required : true,
								minlength : 3,
							},
							father_name : {
								required : true,
								minlength : 3,
							},
							mother_name : {
								required : true,
								minlength : 3,
							},
							residence : {
								required : true
							},
							father_occupation : {
								required : true,
								minlength : 5,
							},
							phone_no : {
								required : true,
								minlength : 10,
							},
							doa : {
								required : true
							},
							std : {
								valueNotEquals : "select"
							},
							medium_of_instruction : {
								required : true,
								minlength : 4
							},
							marks_of_identity : {
								required : true,
								minlength : 10
							}
						},
						messages : {
							admission_no : {
								required : "Admission number cannot be empty",
								minlength : "Admission number should be 8 digit",
							},
							doa : {
								required : "Date of admission is required"
							},
							name : {
								required : "Name cannot be empty",
								minlength : "Name must contain atleast 5 characters",
							},
							dob : {
								required : "Date of birth is required"
							},
							gender : {
								valueNotEquals : "Please Select the Gender!!"
							},
							state : {
								required : "State cannot be empty",
								minlength : "Name must contain atleast 3 characters",
							},
							religion : {
								required : "Religion cannot be empty",
								minlength : "Name must contain atleast 4 characters",
								maxlength : "Name must contain less than 10 characters"
							},
							caste : {
								required : "Caste cannot be empty",
								minlength : "Caste must contain atleast 4 characters",
							},
							coc : {
								valueNotEquals : "Please select Category of Caste",
							},
							mother_tongue : {
								required : "Mother tongue cannot be empty",
								minlength : "Mother tongue must contain atleast 3 characters",
							},
							father_name : {
								required : "Father/Guardian name cannot be empty",
								minlength : "Father/Guardian  name must contain atleast 3 characters",
							},
							mother_name : {
								required : "Mother name cannot be empty",
								minlength : "Mother name must contain atleast 3 characters",
							},
							residence : {
								required : "Residence is required"
							},
							father_occupation : {
								required : "Occupation  cannot be empty",
								minlength : "Occupation  must contain atleast 5 characters",

							},
							phone_no : {
								required : "Phone number  cannot be empty",
								minlength : "Phone number  must contain 1o digits",
							},
							doa : {
								required : "Date of admission is required"
							},
							std : {
								valueNotEquals : "Please select the Class!!"
							},
							medium_of_instruction : {
								required : "Medium of instruction  cannot be empty",
								minlength : "Medium of instruction is atleast 4 characters"
							},
							marks_of_identity : {
								required : "Marks of Identity  cannot be empty",
								minlength : "Marks of Identity is atleast 10 characters"
							}
						}
					});

	$("#teacher_reg_form")
			.validate(
					{
						rules : {
							employee_id : {
								required : true,
								minlength : 8,
							},
							name_of_teacher : {
								require : true,
								minlength : 3
							},
							father_name : {
								required : true,
								minlength : 3,
							},
							religion : {
								required : true,
								minlength : 4,
							},
							caste : {
								valueNotEquals : "Select",
							},
							gender : {
								valueNotEquals : "select"
							},
							marStatus : {
								valueNotEquals : "select"
							},
							dob : {
								require : true
							},
							address : {
								required : true
							},
							city : {
								required : true,
								minlength : 3,
							},
							state : {
								required : true,
								minlength : 3,
							},
							phone_no : {
								required : true,
								minlength : 10,
							},
							qualification : {
								required : true

							},
							experience : {
								required : true
							},
							subjects : {
								required : true
							},
							class_teacher : {
								valueNotEquals : "select"
							},
							designation : {
								required : true
							},
							login_id : {
								required : true,
								minlength : 6
							},
							password : {
								required : true,
								minlength : 8
							}
						},
						messages : {
							employee_id : {
								required : "Employee id cannot be empty",
								minlength : "Employee id number should be 8 digit",
							},
							name_of_teacher : {
								required : "Teacher name cannot be empty",
								minlength : "Teacher name must contain atleast 3 characters",
							},
							father_name : {
								required : "Father/Husband name cannot be empty",
								minlength : "Father/Husband  name must contain atleast 3 characters",
							},
							religion : {
								required : "Religion cannot be empty",
								minlength : "Name must contain atleast 4 characters",
								maxlength : "Name must contain less than 10 characters"
							},
							caste : {
								valueNotEquals : "Please select the Caste",
							},
							gender : {
								valueNotEquals : "Please select the Gender"
							},
							marStatus : {
								valueNotEquals : "Please select the Marital status"
							},
							dob : {
								required : "Date of birth is required"
							},
							address : {
								required : "Address is required"
							},
							city : {
								required : "City cannot be empty",
								minlength : "City must contain atleast 3 characters",
							},
							state : {
								required : "State cannot be empty",
								minlength : "Name must contain atleast 3 characters",
							},
							phone_no : {
								required : "Phone number  cannot be empty",
								minlength : "Phone number  must contain 1o digits",
							},
							qualification : {
								required : "Qualification is required"

							},
							experience : {
								required : "Qualification is required"
							},
							subjects : {
								required : "Teaching subjects are required"
							},
							class_teacher : {
								valueNotEquals : "Please select the class"
							},
							designation : {
								required : "Designation is required"
							},
							login_id : {
								required : "Login Id is required",
								minlength : "Login Id should be minimum 6 characters"
							},
							password : {
								required : "Password is required",
								minlength : "Password should be minimum 8 characters"
							}
						}
					});

	$("#confirm_teacher").click(function() {
		location.href = "confirmYes.teacher";
	});

	$("#modify_teacher").click(function() {
		location.href = "confirmNo.teacher";
	});

	$("#confirm_student").click(function() {
		location.href = "confirmYes.student";
	});

	$("#modify_student").click(function() {
		location.href = "confirmNo.student";
	});

	$("#cancelOverveiwEdit").click(function() {
		location.href = "overview.profile";
	});

	$("#cancelFeeStru").click(function() {
		location.href = "feestructure.profile";
	});
});
