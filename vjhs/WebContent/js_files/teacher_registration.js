/**
 * 
 */
$().ready(function(){
	$(function() {
		$("#teacher_reg_form")
		.validate({
			rules : {
				employee_id : {
					required : true,
					minlength : 8
				},
				name_of_teacher : {
					required : true,
					minlength : 3
				},
				father_name : {
					required : true,
					minlength : 3
				},religion : {
					required : true,
					minlength : 4
				},
				caste : {
					required : true,
					minlength : 4
				},
				address : {
					required : true
				},
				city : {
					required : true,
					minlength : 3
				},
				state : {
					required : true,
					minlength : 3
				},
				phone_no : {
					required : true,
					minlength : 10
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
				},
				dob : {
					required : true
				},
				dob : {
					required : true
				}

			},
		messages:{
			employee_id : {
				required : "Employee id cannot be empty",
				minlength : "Employee id number should be 8 digit"
			},
			name_of_teacher : {
				required : "Teacher name cannot be empty",
				minlength : "Teacher name must contain atleast 3 characters"
			},
			father_name : {
				required : "Father/Husband name cannot be empty",
				minlength : "Father/Husband  name must contain atleast 3 characters"
			},
			religion : {
				required : "Religion cannot be empty",
				minlength : "Name must contain atleast 4 characters",
				maxlength : "Name must contain less than 10 characters"
			},
			caste : {
				required : "Caste cannot be empty",
				minlength : "Caste must contain atleast 4 characters"
			},
			address : {
				required : "Address is required"
			},
			city : {
				required : "City cannot be empty",
				minlength : "City must contain atleast 3 characters"
			},
			state : {
				required : "State cannot be empty",
				minlength : "Name must contain atleast 3 characters"
			},
			phone_no : {
				required : "Phone number  cannot be empty",
				minlength : "Phone number  must contain 10 digits"
			},
			qualification : {
				required : "Qualification is required"

			},
			experience : {
				required : "Experience is required"
			},
			subjects : {
				required : "Teaching subjects are required"
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
			},
			dob : {
				require : "Date of birth is required"
			},
			doj : {
				require : "Date of joining is required"
			}
			}
			});
})
})


