package com.vjhs.web.teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vjhs.imp.ClassStrengthOperImp;
import com.vjhs.imp.SubjectOperImp;
import com.vjhs.imp.TeacherAttendanceOperImp;
import com.vjhs.imp.TeacherOperImp;
import com.vjhs.imp.TeacherTTOperImp;
import com.vjhs.interfaces.ClassStrengthOperations;
import com.vjhs.interfaces.SubjectOperation;
import com.vjhs.interfaces.TeacherAttendanceOperations;
import com.vjhs.interfaces.TeacherTTOperations;
import com.vjhs.pojo.Class_Strength;
import com.vjhs.pojo.Subject;
import com.vjhs.pojo.Teacher;
import com.vjhs.pojo.TeacherAttendance;
import com.vjhs.pojo.TeacherTT;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("*.teacher")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
	private static final Logger LOGGER = Logger.getLogger(TeacherServlet.class.getName());
	private TeacherOperImp teacherOperImp = new TeacherOperImp();
	private TeacherAttendanceOperations teacherAtnOprImp = new TeacherAttendanceOperImp();

	private Teacher getTeacherDetails(HttpServletRequest request) {

		Teacher teacher = new Teacher();
		String employeeId = request.getParameter("employee_id");
		teacher.setEmployeeId(employeeId);
		String teacherName = request.getParameter("name_of_teacher");
		teacher.setTeacherName(teacherName);
		String fatherOrHusbandName = request.getParameter("father_name");
		teacher.setFatherOrHusbundName(fatherOrHusbandName);
		String religion = request.getParameter("religion");
		teacher.setReligion(religion);
		String caste = request.getParameter("caste");
		teacher.setCaste(caste);
		String gender = request.getParameter("gender");
		teacher.setGender(gender);
		String maritalStatus = request.getParameter("marStatus");
		teacher.setMaritalStatus(maritalStatus);
		Date dateOfBirth;
		try {
			dateOfBirth = (Date) formatter.parse(request.getParameter("dob"));
			teacher.setDateOfBirth(dateOfBirth);
		} catch (ParseException e) {
			LOGGER.info("While parsing DOB: " + e.getMessage());
		} catch (Exception e) {
			LOGGER.info("While parsing DOB: " + e.getMessage());
		}
		Date dateOfJoining;
		try {
			dateOfJoining = (Date) formatter.parse(request.getParameter("doj"));
			teacher.setDateOfJoining(dateOfJoining);
		} catch (ParseException e) {
			LOGGER.info("While parsing DOJ: " + e.getMessage());
		} catch (Exception e) {
			LOGGER.info("While parsing DOJ: " + e.getMessage());
		}
		String address = request.getParameter("address");
		teacher.setAddresss(address);
		String city = request.getParameter("city");
		teacher.setCity(city);
		String state = request.getParameter("state");
		teacher.setState(state);
		String nationality = request.getParameter("nationality");
		teacher.setNationality(nationality);
		try {
			String phoneNo = request.getParameter("phone_no");
			teacher.setPhone(Long.parseLong(phoneNo));
		} catch (Exception e) {

		}
		String qualification = request.getParameter("qualification");
		teacher.setQualification(qualification);
		try {
			String experiance = request.getParameter("experience");
			teacher.setExperiance(Long.parseLong(experiance));
		} catch (Exception e) {
		}
		String subjects = request.getParameter("subjects");
		teacher.setSubjects(subjects);
		String classes = request.getParameter("classes");
		teacher.setClasses(classes);
		String class_teacher = request.getParameter("class_teacher");
		teacher.setClass_teacher(class_teacher);
		String designation = request.getParameter("designation");
		teacher.setDesignation(designation);
		String loginId = request.getParameter("login_id");
		teacher.setUser_id(loginId);
		String password = request.getParameter("password");
		teacher.setPassword(password);

		return teacher;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		if (uri.endsWith("add.teacher")) {
			request.getRequestDispatcher("add_teacher.jsp").forward(request, response);
		} else if (uri.endsWith("modifyTeacher.teacher")) {
			String empId = request.getParameter("empId");
			Teacher teacher = teacherOperImp.getTeacher(empId);
			request.setAttribute("teacher", teacher);
			request.getRequestDispatcher("add_teacher.jsp").forward(request, response);
		} else if (uri.endsWith("attendance.teacher")) {
			List<Teacher> teacherList = teacherOperImp.getTeachers();
			request.setAttribute("teacherList", teacherList);
			request.getRequestDispatcher("view_teacher_attendance.jsp").forward(request, response);
		} else if (uri.endsWith("addTeacherAtten.teacher")) {
			List<TeacherAttendance> teachAttenList = new ArrayList<TeacherAttendance>();
			List<Teacher> teacherList = teacherOperImp.getTeachers();
			for (Teacher teacher : teacherList) {
				TeacherAttendance teacherAttendance = new TeacherAttendance();
				teacherAttendance.setAttendanceStatus(request.getParameter("attSta" + teacher.getEmployeeId()));
				try {
					teacherAttendance.setAttendanceDate((Date) formatter.parse(request.getParameter("teacherAtDate")));
				} catch (ParseException e1) {
					LOGGER.info("While parsing DOA : " + e1.getMessage());
				}
				teacherAttendance.setEmployeeId(teacher.getEmployeeId());
				teacherAttendance.setEmployeeName(teacher.getTeacherName());
				teachAttenList.add(teacherAttendance);
			}
			teacherAtnOprImp.addTeacherAttandance(teachAttenList);
			request.getRequestDispatcher("view_teacher_attendance.jsp").forward(request, response);
		} else if (uri.endsWith("getTeacherStatus.teacher")) {
			TeacherAttendance teacherAttendance = new TeacherAttendance();
			List<TeacherAttendance> attList = null;
			try {
				teacherAttendance.setAttendanceDate((Date) formatter.parse(request.getParameter("selectedDate")));
				attList = teacherAtnOprImp.getAttenStatus(teacherAttendance);
			} catch (ParseException e1) {
				LOGGER.info("While parsing DOA : " + e1.getMessage());
			}
			out.print("<LIST>");
			for (TeacherAttendance attLisVal : attList) {
				out.print("<EMP><EMP_ID>" + attLisVal.getEmployeeId() + "</EMP_ID><EMP_NAME>"
						+ attLisVal.getEmployeeName() + "</EMP_NAME><EMP_STATUS>" + attLisVal.getAttendanceStatus()
						+ "</EMP_STATUS></EMP>");
			}
			out.print("</LIST>");
		} else if (uri.endsWith("view.teacher")) {
			List<Teacher> teacherList = teacherOperImp.getTeachers();
			request.setAttribute("teacherList", teacherList);
			request.getRequestDispatcher("view_teachers.jsp").forward(request, response);
		} else if (uri.endsWith("addtt.teacher")) {
			TeacherTTOperations tchrTTOpt = new TeacherTTOperImp();
			String empId = request.getParameter("empId");
			List<TeacherTT> tchrTTList = new ArrayList<TeacherTT>();
			for (int i = 1; i <= 6; i++) {
				TeacherTT tchrTT = new TeacherTT();
				tchrTT.setEmployeeId(empId);
				tchrTT.setPeriodI(request.getParameter("a" + i));
				tchrTT.setPeriodII(request.getParameter("b" + i));
				tchrTT.setPeriodIII(request.getParameter("c" + i));
				tchrTT.setPeriodIV(request.getParameter("d" + i));
				tchrTT.setPeriodV(request.getParameter("e" + i));
				tchrTT.setPeriodVI(request.getParameter("f" + i));
				tchrTT.setPeriodVII(request.getParameter("g" + i));
				tchrTT.setPeriodVIII(request.getParameter("h" + i));
				tchrTT.setPeriodIClass(request.getParameter("aC" + i));
				tchrTT.setPeriodIIClass(request.getParameter("bC" + i));
				tchrTT.setPeriodIIIClass(request.getParameter("cC" + i));
				tchrTT.setPeriodIVClass(request.getParameter("dC" + i));
				tchrTT.setPeriodVClass(request.getParameter("eC" + i));
				tchrTT.setPeriodVIClass(request.getParameter("fC" + i));
				tchrTT.setPeriodVIIClass(request.getParameter("gC" + i));
				tchrTT.setPeriodVIIIClass(request.getParameter("hC" + i));
				tchrTT.setDays(request.getParameter("i" + i));
				tchrTTList.add(tchrTT);
			}
			tchrTTOpt.addTimeTable(tchrTTList);
			SubjectOperation subjectOperations = new SubjectOperImp();
			List<Subject> subjectsList = subjectOperations.getSubjects();
			request.setAttribute("subjectList", subjectsList);
			List<Teacher> teacherList = teacherOperImp.getTeachers();
			request.setAttribute("teacherList", teacherList);
			ClassStrengthOperations classStrengthOperations = new ClassStrengthOperImp();
			List<Class_Strength> class_StrengthsList = classStrengthOperations.getClassStrengthList();
			request.setAttribute("classList", class_StrengthsList);
			request.getRequestDispatcher("view_teachertt.jsp").forward(request, response);
		} else if (uri.endsWith("viewtt.teacher")) {
			ClassStrengthOperations classStrengthOperations = new ClassStrengthOperImp();
			List<Class_Strength> class_StrengthsList = classStrengthOperations.getClassStrengthList();
			request.setAttribute("classList", class_StrengthsList);
			SubjectOperation subjectOperations = new SubjectOperImp();
			List<Subject> subjectsList = subjectOperations.getSubjects();
			request.setAttribute("subjectList", subjectsList);
			List<Teacher> teacherList = teacherOperImp.getTeachers();
			request.setAttribute("teacherList", teacherList);
			request.getRequestDispatcher("view_teachertt.jsp").forward(request, response);
		} else if (uri.endsWith("regform.teacher")) {
			boolean isAdded = false;
			Teacher teacher = getTeacherDetails(request);
			if (teacherOperImp.isTeacherAvail(teacher.getEmployeeId())) {
				isAdded = teacherOperImp.addTeacher(teacher);
			} else {
				isAdded = teacherOperImp.updateTeacher(teacher);
			}
			if (isAdded) {
				request.setAttribute("msgCode", "success");
				request.setAttribute("message", "Teacher: " + teacher.getTeacherName() + " added Successfully");
			} else {
				request.setAttribute("msgCode", "error");
				request.setAttribute("message", "Getting Error while adding Teacher: " + teacher.getTeacherName());
			}
			request.getRequestDispatcher("add_teacher.jsp").forward(request, response);
		} else if (uri.endsWith("deleteTeacher.teacher")) {
			String empId = request.getParameter("empId");
			if (teacherOperImp.deleteTeacher(empId)) {
				request.setAttribute("msgCode", "success");
				request.setAttribute("message", "Employee Id: " + empId + " deleted Successfully");
			} else {
				request.setAttribute("msgCode", "error");
				request.setAttribute("message", "Getting Error while deleting Employee Id: " + empId);
			}
			List<Teacher> teacherList = teacherOperImp.getTeachers();
			request.setAttribute("teacherList", teacherList);
			request.getRequestDispatcher("view_teachers.jsp").forward(request, response);
		} else if (uri.endsWith("confirmYes.teacher")) {
			boolean isAdded;
			HttpSession httpSession = request.getSession(false);
			Teacher teacher = (Teacher) httpSession.getAttribute("teacher");
			isAdded = teacherOperImp.addTeacher(teacher);
			httpSession.invalidate();
			if (isAdded) {
				request.setAttribute("msgCode", "success");
				request.setAttribute("message", "Teacher: " + teacher.getTeacherName() + " added Successfully");
			} else {
				request.setAttribute("msgCode", "error");
				request.setAttribute("message", "Getting Error while adding Teacher: " + teacher.getTeacherName());
			}
			request.getRequestDispatcher("add_teacher.jsp").forward(request, response);
		} else if (uri.endsWith("confirmNo.teacher")) {
			request.getRequestDispatcher("add_teacher.jsp").forward(request, response);
		} else if (uri.endsWith("viewAttendance.teacher")) {
			List<Teacher> teacherList = teacherOperImp.getTeachers();
			request.setAttribute("teacherList", teacherList);
			request.getRequestDispatcher("view_teacher_attendance.jsp").forward(request, response);
		} else if (uri.endsWith("getTeachertt.teacher")) {
			TeacherTTOperations tchrTTOpt = new TeacherTTOperImp();
			String empId = request.getParameter("empId");
			List<TeacherTT> teachTT = tchrTTOpt.getTimeTableByJobId(empId);
			out.print("<LIST>");
			for (TeacherTT tchrTT : teachTT) {
				out.print("<LEVEL><PD1>" + tchrTT.getPeriodI() + "</PD1><PD2>" + tchrTT.getPeriodII() + "</PD2><PD3>"
						+ tchrTT.getPeriodIII() + "</PD3><PD4>" + tchrTT.getPeriodIV() + "</PD4><PD5>"
						+ tchrTT.getPeriodV() + "</PD5><PD6>" + tchrTT.getPeriodVI() + "</PD6><PD7>"
						+ tchrTT.getPeriodVII() + "</PD7><PD8>" + tchrTT.getPeriodVIII() + "</PD8><PCD1>"
						+ tchrTT.getPeriodIClass() + "</PCD1><PCD2>" + tchrTT.getPeriodIIClass() + "</PCD2><PCD3>"
						+ tchrTT.getPeriodIIIClass() + "</PCD3><PCD4>" + tchrTT.getPeriodIVClass() + "</PCD4><PCD5>"
						+ tchrTT.getPeriodVClass() + "</PCD5><PCD6>" + tchrTT.getPeriodVIClass() + "</PCD6><PCD7>"
						+ tchrTT.getPeriodVIIClass() + "</PCD7><PCD8>" + tchrTT.getPeriodVIIIClass() + "</PCD8><DAY>"
						+ tchrTT.getDays() + "</DAY></LEVEL>");
			}
			out.print("</LIST>");
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
