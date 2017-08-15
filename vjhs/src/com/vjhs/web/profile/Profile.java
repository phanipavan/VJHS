package com.vjhs.web.profile;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vjhs.imp.ClassStrengthOperImp;
import com.vjhs.imp.FeeStructureOperImp;
import com.vjhs.imp.OverviewOperImp;
import com.vjhs.interfaces.ClassStrengthOperations;
import com.vjhs.interfaces.FeeStructureOperations;
import com.vjhs.interfaces.OverviewOperations;
import com.vjhs.pojo.Class_Strength;
import com.vjhs.pojo.FeeStructure;
import com.vjhs.pojo.Overview;

/**
 * Servlet implementation class Profile
 */
@WebServlet("*.profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	OverviewOperations overviewOperations = new OverviewOperImp();
	FeeStructureOperations feeStructureOperations = new FeeStructureOperImp();
	ClassStrengthOperations classStrengthOperations = new ClassStrengthOperImp();

	private Overview getOverview(HttpServletRequest request) {
		Overview overview = new Overview();
		overview.setSchoolName(request.getParameter("school_name"));
		overview.setHeadquarters(request.getParameter("headquarter"));
		overview.setBranches(request.getParameter("branches"));
		overview.setCity(request.getParameter("city"));
		overview.setDistrict(request.getParameter("district"));
		overview.setState(request.getParameter("state"));
		overview.setPhoneNo(request.getParameter("phone"));
		overview.setMobileNo(request.getParameter("mobile"));
		overview.setEmail(request.getParameter("email"));
		overview.setStartYear(Integer.parseInt(request.getParameter("start_year")));
		return overview;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();

		if (uri.endsWith("overview.profile")) {
			Overview overview = new Overview();
			overview = overviewOperations.getOverview();
			request.setAttribute("overview", overview);
			Cookie[] cookies = null;
			cookies = request.getCookies();
			System.out.println("Cookies: " + cookies);
			if (cookies != null)
				for (int i = 0; i < cookies.length; i++) {
					Cookie cookie = cookies[i];
					System.out.println("Cookie at overview :" + cookie.getName());

				}
			System.out.println("Before dispatching");
			request.getRequestDispatcher("overview.jsp").forward(request, response);
		} else if (uri.endsWith("classes_strength.profile")) {
			request.getRequestDispatcher("class_strength.jsp").forward(request, response);
		} else if (uri.endsWith("getFeeStru.profile")) {
			String className = request.getParameter("std");
			FeeStructure feeStructure = feeStructureOperations.getFeeStructure(className);
			request.setAttribute("feeStructure", feeStructure);
			request.getRequestDispatcher("fees_structure.jsp").forward(request, response);
		} else if (uri.endsWith("editFeeStru.profile")) {
			String className = request.getParameter("className");
			FeeStructure feeStructure = feeStructureOperations.getFeeStructure(className);
			request.setAttribute("feeStructure", feeStructure);
			request.getRequestDispatcher("edit_fees_structure.jsp").forward(request, response);
		}

		else if (uri.endsWith("updateFeeStr.profile")) {
			boolean isUpdated;
			FeeStructure feeStructure = getFeeStructure(request);
			isUpdated = feeStructureOperations.updateFeeStructure(feeStructure);
			if (isUpdated) {
				request.setAttribute("msgCode", "success");
				request.setAttribute("message",
						"Fee Structure updated sucessfully for the Class: " + feeStructure.getClassName());
			} else {
				request.setAttribute("msgCode", "error");
				request.setAttribute("message",
						"Fee Structure not updated for the  Class: " + feeStructure.getClassName());
			}
			List<FeeStructure> feeStructureList = feeStructureOperations.getFeeStructureList();
			request.setAttribute("feeStruList", feeStructureList);
			request.getRequestDispatcher("feestructure.jsp").forward(request, response);

		} else if (uri.endsWith("fee_structure.profile")) {
			request.getRequestDispatcher("fees_structure.jsp").forward(request, response);
		} else if (uri.endsWith("feestructure.profile")) {
			List<FeeStructure> feeStructureList = feeStructureOperations.getFeeStructureList();
			request.setAttribute("feeStruList", feeStructureList);
			request.getRequestDispatcher("feestructure.jsp").forward(request, response);
		} else if (uri.endsWith("editOverview.profile")) {
			Overview overview = new Overview();
			overview = overviewOperations.getOverview();
			request.setAttribute("overview", overview);
			request.getRequestDispatcher("edit_overview.jsp").forward(request, response);
		} else if (uri.endsWith("updOverview.profile")) {
			boolean isUpdate;
			Overview overview = getOverview(request);
			isUpdate = overviewOperations.updateOverview(overview);
			if (isUpdate) {
				request.setAttribute("msgCode", "success");
				request.setAttribute("message", "Overview Updated Sucessfully");
			} else {
				request.setAttribute("msgCode", "error");
				request.setAttribute("message", "Overview not updated sucessfully");
			}
			overview = overviewOperations.getOverview();
			request.setAttribute("overview", overview);
			request.getRequestDispatcher("overview.jsp").forward(request, response);
		} else if (uri.endsWith("classstrength.profile")) {
			List<Class_Strength> class_StrengthsList = classStrengthOperations.getClassStrengthList();
			request.setAttribute("classStrengthList", class_StrengthsList);
			request.getRequestDispatcher("classstrength.jsp").forward(request, response);
		}
	}

	private FeeStructure getFeeStructure(HttpServletRequest request) {
		FeeStructure feeStructure = new FeeStructure();
		feeStructure.setClassName(request.getParameter("std"));
		feeStructure.setAdmissionFee(Double.parseDouble(request.getParameter("admission_fee")));
		feeStructure.setApplicationFee(Double.parseDouble(request.getParameter("application_fee")));
		feeStructure.setTutionFee(Double.parseDouble(request.getParameter("tution_fee")));
		feeStructure.setBooksFee(Double.parseDouble(request.getParameter("books_fee")));
		feeStructure.setExamFee(Double.parseDouble(request.getParameter("examination_fee")));
		feeStructure.setOtherFee(Double.parseDouble(request.getParameter("examination_fee")));
		feeStructure.setTotalFee(Double.parseDouble(request.getParameter("total_fee")));
		return feeStructure;
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
