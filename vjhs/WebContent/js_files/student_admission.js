/**
 * 
 */
$()
		.ready(
				function() {
					$(function() {
						$("#registrationform")
								.validate(
										{
											rules : {
												admission_no : {
													required : true,
													minlength : 8
												},
												todaydate : {
													required : true
												},
												name : {
													required : true,
													minlength : 5
												},
												dob : {
													required : true
												},
												state : {
													required : true,
													minlength : 3
												},
												religion : {
													required : true,
													minlength : 4
												},
												caste : {
													required : true,
													minlength : 4
												},
												coc : {
													required : true,
													minlength : 2
												},
												mother_tongue : {
													required : true,
													minlength : 3
												},
												father_name : {
													required : true,
													minlength : 3
												},
												mother_name : {
													required : true,
													minlength : 3
												},
												residence : {
													required : true
												},
												father_occupation : {
													required : true,
													minlength : 5
												},
												phone_no : {
													required : true,
													minlength : 10
												},
												medium_of_instruction : {
													required : true,
													minlength : 4
												},
												marks_of_identity : {
													required : true,
													minlength : 10
												},
												father_address : {
													required : true										
												}
											},
											messages : {
												admission_no : {
													required : "Admission number cannot be empty",
													minlength : "Admission number should be 8 digit"
												},
												todaydate : {
													required : "Date of admission is required"
												},
												name : {
													required : "Name cannot be empty",
													minlength : "Name must contain atleast 5 characters"
												},
												dob : {
													required : "Date of birth is required"
												},
												state : {
													required : "State cannot be empty",
													minlength : "Name must contain atleast 3 characters"
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
												coc : {
													required : "Category of caste cannot be empty",
													minlength : "Category of caste must contain atleast 2 characters"
												},
												mother_tongue : {
													required : "Mother tongue cannot be empty",
													minlength : "Mother tongue must contain atleast 3 characters"
												},
												father_name : {
													required : "Father/Guardian name cannot be empty",
													minlength : "Father/Guardian  name must contain atleast 3 characters"
												},
												mother_name : {
													required : "Mother name cannot be empty",
													minlength : "Mother name must contain atleast 3 characters"
												},
												residence : {
													required : "Residence address  required"
												},
												father_occupation : {
													required : "Occupation  cannot be empty",
													minlength : "Occupation  must contain atleast 5 characters"
												},
												phone_no : {
													required : "Phone number  cannot be empty",
													minlength : "Phone number  must contain 1o digits"
												},
												medium_of_instruction : {
													required : "Medium of instruction  cannot be empty",
													minlength : "Medium of instruction is atleast 4 characters"
												},
												marks_of_identity : {
													required : "Marks of Identity  cannot be empty",
													minlength : "Marks of Identity is atleast 10 characters"
												},
												father_address : {
													required : "Father/Residence address  required"										
												}
											}
										});
					})
				})
