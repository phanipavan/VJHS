package com.vjhs.web.schedule;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vjhs.imp.ClassTimeTableOperImp;
import com.vjhs.imp.SubjectOperImp;
import com.vjhs.interfaces.ClassTimeTableOperation;
import com.vjhs.interfaces.SubjectOperation;
import com.vjhs.pojo.ClassTimeTable;
import com.vjhs.pojo.Subject;

/**
 * Servlet implementation class ScheduleServlet
 */
@WebServlet("*.schedule")
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		PrintWriter out = response.getWriter();
		if (uri.endsWith("academic_calander.schedule")) {
			request.getRequestDispatcher("upload_academic_calender.jsp").forward(request, response);
		} else if (uri.endsWith("school_timings.schedule")) {
			request.getRequestDispatcher("upload_school_timings.jsp").forward(request, response);
		} else if (uri.endsWith("class_tt.schedule")) {
			SubjectOperation subjectOperations = new SubjectOperImp();
			List<Subject> subjectsList = subjectOperations.getSubjects();
			request.setAttribute("subjectList", subjectsList);
			request.getRequestDispatcher("classtt.jsp").forward(request, response);
		} else if (uri.endsWith("events.schedule")) {
			request.getRequestDispatcher("").forward(request, response);
		} else if (uri.endsWith("holidays.schedule")) {
			request.getRequestDispatcher("upload_holiday_list.jsp").forward(request, response);
		} else if (uri.endsWith("addTT.schedule")) {
			ClassTimeTableOperation clsTTOper = new ClassTimeTableOperImp();
			String className = request.getParameter("className");
			List<ClassTimeTable> clsTTList = new ArrayList<ClassTimeTable>();
			for (int i = 1; i <= 6; i++) {
				ClassTimeTable clsTT = new ClassTimeTable();
				clsTT.setClassName(className);
				clsTT.setPeriodI(request.getParameter("a" + i));
				clsTT.setPeriodII(request.getParameter("b" + i));
				clsTT.setPeriodIII(request.getParameter("c" + i));
				clsTT.setPeriodIV(request.getParameter("d" + i));
				clsTT.setPeriodV(request.getParameter("e" + i));
				clsTT.setPeriodVI(request.getParameter("f" + i));
				clsTT.setPeriodVII(request.getParameter("g" + i));
				clsTT.setPeriodVIII(request.getParameter("h" + i));
				clsTT.setDay(request.getParameter("i" + i));
				clsTTList.add(clsTT);
			}
			clsTTOper.addClassTimeTable(clsTTList);
			request.getRequestDispatcher("class_tt.schedule").forward(request, response);
		} else if (uri.endsWith("getClasstt.schedule")) {
			ClassTimeTableOperation clsTTOpr = new ClassTimeTableOperImp();
			String className = request.getParameter("className");
			List<ClassTimeTable> clsTTList = clsTTOpr.getClassTimeTable(className);
			out.print("<LIST>");
			for (ClassTimeTable clsTT : clsTTList) {
				out.print("<LEVEL><CLASS>" + clsTT.getClassName() + "</CLASS><PD1>" + clsTT.getPeriodI() + "</PD1><PD2>"
						+ clsTT.getPeriodII() + "</PD2><PD3>" + clsTT.getPeriodIII() + "</PD3><PD4>"
						+ clsTT.getPeriodIV() + "</PD4><PD5>" + clsTT.getPeriodV() + "</PD5><PD6>" + clsTT.getPeriodVI()
						+ "</PD6><PD7>" + clsTT.getPeriodVII() + "</PD7><PD8>" + clsTT.getPeriodVIII() + "</PD8><DAY>"
						+ clsTT.getDay() + "</DAY></LEVEL>");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
