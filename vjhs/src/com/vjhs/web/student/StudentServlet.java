package com.vjhs.web.student;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.vjhs.imp.StudentOperImp;
import com.vjhs.interfaces.StudentOperations;
import com.vjhs.pojo.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("*.student")
@MultipartConfig
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(StudentServlet.class.getName());
	StudentOperations studentOperations = new StudentOperImp();
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	private Student getStudentDetails(HttpServletRequest request) {
		Student student = new Student();
		Part photo = null;
		try {
			photo = request.getPart("photo");
		} catch (IOException e2) {
			LOGGER.info("While reading photo from reg form IOException: " + e2.getMessage());
		} catch (ServletException e2) {
			LOGGER.info("While reading photo from reg form ServletException: " + e2.getMessage());
		}
		student.setPhoto(photo);
		String admissionNo = request.getParameter("admission_no");
		student.setAdmissionNo(admissionNo);
		Date dateOfAdmission;
		try {
			dateOfAdmission = (Date) formatter.parse(request.getParameter("todaydate"));
			student.setDateOfAdmission(dateOfAdmission);
		} catch (ParseException e1) {
			LOGGER.info("While parsing DOA : " + e1.getMessage());
		}
		String studentName = request.getParameter("name");
		student.setStudentName(studentName);
		Date dateOfBirth;
		try {
			dateOfBirth = (Date) formatter.parse(request.getParameter("dob"));
			student.setDateOfBirth(dateOfBirth);
		} catch (ParseException e) {
			LOGGER.info("While parsing DOB: " + e.getMessage());
		}
		String gender = request.getParameter("gender");
		student.setGender(gender);
		String nationality = request.getParameter("nationality");
		student.setNationality(nationality);
		String state = request.getParameter("state");
		student.setState(state);
		String religion = request.getParameter("religion");
		student.setReligion(religion);
		String caste = request.getParameter("caste");
		student.setCaste(caste);
		String coc = request.getParameter("coc");
		student.setCoc(coc);
		String mother_tongue = request.getParameter("mother_tongue");
		student.setMotherTongue(mother_tongue);
		String father_name = request.getParameter("father_name");
		student.setFatherName(father_name);
		String mother_name = request.getParameter("mother_name");
		student.setMotherName(mother_name);
		String residence = request.getParameter("residence");
		student.setResidence(residence);
		String father_occupation = request.getParameter("father_occupation");
		student.setFatherOccupation(father_occupation);
		String father_address = request.getParameter("father_address");
		student.setAddress(father_address);
		String phone_no = request.getParameter("phone_no");
		student.setMobile(Long.parseLong(phone_no));
		String previous_school = request.getParameter("previous_school");
		student.setPreviousSchool(previous_school);
		String tcNum = request.getParameter("tcNum");
		if (tcNum != null && !"".equals(tcNum)) {
			student.setTcNumber(Long.parseLong(tcNum));
		}
		Date rec_tc_date;
		if (request.getParameter("rec_tc_date") != null && !"".equals(request.getParameter("rec_tc_date"))) {
			try {
				rec_tc_date = (Date) formatter.parse(request.getParameter("rec_tc_date"));
				student.setTcDate(rec_tc_date);
			} catch (ParseException e) {
				LOGGER.info("While parsing TC Date Previous School: " + e.getMessage());
			}
		}
		String std = request.getParameter("std");
		student.setClassAdmitted(std);
		String medium_of_instruction = request.getParameter("medium_of_instruction");
		student.setMedium(medium_of_instruction);
		String marks_of_identity = request.getParameter("marks_of_identity");
		student.setIdentityMarks(marks_of_identity);
		return student;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.endsWith("add.student")) {
			request.getRequestDispatcher("admission.jsp").forward(request, response);
		} else if (uri.endsWith("view.student")) {
			List<Student> studentsList = studentOperations.getStudents();
			request.setAttribute("studentsList", studentsList);
			request.getRequestDispatcher("view_students.jsp").forward(request, response);
		} else if (uri.endsWith("regform.student")) {
			Student student = getStudentDetails(request);
			boolean isAdded = false;
			if (studentOperations.isStudentAvail(student.getAdmissionNo())) {
				isAdded = studentOperations.addStudent(student);
			} else {
				isAdded = studentOperations.updateStudent(student);
			}
			if (isAdded) {
				request.setAttribute("msgCode", "success");
				request.setAttribute("message", "Student: " + student.getStudentName() + " added Successfully");
			} else {
				request.setAttribute("msgCode", "error");
				request.setAttribute("message", "Getting Error while adding Student: " + student.getStudentName());
			}
			request.setAttribute("student", new Student());
			request.getRequestDispatcher("admission.jsp").forward(request, response);
		} else if (uri.endsWith("confirmYes.student")) {
			HttpSession httpSession = request.getSession(false);
			Student student = (Student) httpSession.getAttribute("student");
			if (student.isAdded()) {
				request.setAttribute("msgCode", "success");
				request.setAttribute("message", "Student: " + student.getStudentName() + " added Successfully");
			} else {
				request.setAttribute("msgCode", "error");
				request.setAttribute("message", "Getting Error while adding Student: " + student.getStudentName());
			}
			httpSession.invalidate();
			request.getRequestDispatcher("admission.jsp").forward(request, response);
		} else if (uri.endsWith("confirmNo.student")) {
			HttpSession httpSession = request.getSession(false);
			Student student = (Student) httpSession.getAttribute("student");
			if (student.isAdded()) {
				studentOperations.deleteStudent(student.getAdmissionNo());
			}
			httpSession.invalidate();
			request.getRequestDispatcher("admission.jsp").forward(request, response);
		} else if (uri.endsWith("modifyStudent.student")) {
			String adminNo = request.getParameter("adminNo");
			Student student = studentOperations.getStudent(adminNo);
			request.setAttribute("student", student);
			request.getRequestDispatcher("admission.jsp").forward(request, response);
		} else if (uri.endsWith("deleteStudent.student")) {
			String adminNo = request.getParameter("adminNo");
			if (studentOperations.deleteStudent(adminNo)) {
				request.setAttribute("msgCode", "success");
				request.setAttribute("message", "Admission No: " + adminNo + " deleted Successfully");
			} else {
				request.setAttribute("msgCode", "error");
				request.setAttribute("message", "Getting Error while deleting Admission No: " + adminNo);
			}
			List<Student> studentsList = studentOperations.getStudents();
			request.setAttribute("studentsList", studentsList);
			request.getRequestDispatcher("view_students.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
