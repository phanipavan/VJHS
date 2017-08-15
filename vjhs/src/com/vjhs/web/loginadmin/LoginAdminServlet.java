package com.vjhs.web.loginadmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vjhs.imp.LoginAdminOperImp;
import com.vjhs.imp.OverviewOperImp;
import com.vjhs.interfaces.LoginAdminOperations;
import com.vjhs.interfaces.OverviewOperations;
import com.vjhs.pojo.LoginAdmin;
import com.vjhs.pojo.Overview;

/**
 * Servlet implementation class LoginAdmin
 */
@WebServlet("*.admin")
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OverviewOperations overviewOperations = new OverviewOperImp();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		LoginAdminOperations loginadminOper = new LoginAdminOperImp();
		if (uri.endsWith("showAdminLogin.admin")) {
			request.getRequestDispatcher("vjhsadminlogin.jsp").forward(request, response);
		} else if (uri.endsWith("addAdminLogin.admin")) {
			LoginAdmin loginAdmin = new LoginAdmin();
			/* loginAdmin.setUserId("54367"); */
			loginAdmin.setName(request.getParameter("name"));
			loginAdmin.setEmail(request.getParameter("email"));
			loginAdmin.setUserName(request.getParameter("userName"));
			loginAdmin.setPassword(request.getParameter("password"));
			loginAdmin.setBranch(request.getParameter("branch"));
			loginAdmin.setRole(request.getParameter("role"));
			System.out.println("username--"+loginAdmin.getUserName());
			if (!loginadminOper.checkUser(loginAdmin.getUserName())) {
				boolean isAdd = loginadminOper.addUserAdmin(loginAdmin);
				if (isAdd) {
					request.setAttribute("msgCode", "success");
					request.setAttribute("message",
							"We successfully created your account, you can login by using your crendentials.");
				} else {
					request.setAttribute("msgCode", "error");
					request.setAttribute("message",
							"Oops! Something went wrong while creating accocunt, Please try after sometime.");
				}
			} else {
				request.setAttribute("msgCode", "error");
				request.setAttribute("message", "User name specified is already exist in our records!");
			}
			request.getRequestDispatcher("vjhsadminlogin.jsp").forward(request, response);
		} else if (uri.endsWith("showAddAdminLogin.admin")) {
			request.getRequestDispatcher("createaccount.jsp").forward(request, response);
		} else if (uri.endsWith("showUpdateAdminPass.admin")) {
			request.getRequestDispatcher("forgotpassword.jsp").forward(request, response);
		} else if (uri.endsWith("deleteAdminLogin.admin")) {
			request.getRequestDispatcher("fees_structure.jsp").forward(request, response);
		} else if (uri.endsWith("checkAdminUser.admin")) {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String loginInfo;
			String[] splitObj;
			LoginAdmin loginAdmin = new LoginAdmin();
			loginAdmin = loginadminOper.getLoginDetails(userName);
			if (userName.equals(loginAdmin.getUserName()) && password.equals(loginAdmin.getPassword())) {
				Cookie cookie = null;
				loginInfo = loginAdmin.toString();
				for (String loginDet : loginInfo.split(",")) {
					splitObj = loginDet.split("=");
					if (splitObj[1] != null && !"".equals(splitObj[1]) && !"null".equals(splitObj[1])) {
						cookie = null;
						cookie = new Cookie(splitObj[0], splitObj[1]);
						response.addCookie(cookie);
					}
				}
				Overview overview = new Overview();
				overview = overviewOperations.getOverview();
				System.out.println("Overview : " + overview);
				request.setAttribute("overview", overview);

				request.getRequestDispatcher("overview.profile").forward(request, response);
			} else {
				request.setAttribute("errorMessage", "Username / Password Invalid");
				request.getRequestDispatcher("vjhsadminlogin.jsp").forward(request, response);
			}
		} else if (uri.endsWith("sessionAlive.admin")) {
			request.getRequestDispatcher("overview.profile").forward(request, response);
		} else if (uri.endsWith("getAllAdmin.admin")) {
			request.getRequestDispatcher("class_strength.jsp").forward(request, response);
		} else if (uri.endsWith("logout.admin")) {
			eraseCookie(request, response);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.setAttribute("errorMessage", "You have logged out successfully");
			request.getRequestDispatcher("vjhsadminlogin.jsp").forward(request, response);
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

	private void eraseCookie(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Cookie[] cookies = null;
			cookies = req.getCookies();

			if (cookies != null)
				for (int i = 0; i < cookies.length; i++) {
					Cookie cookie = cookies[i];
					System.out.println("Cookie :" + cookie.getName());
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
					// System.out.println("Cookie after clear
					// :"+cookie.getName());
					// cookies[i].setValue("");
					// cookies[i].setPath("/");
					// cookies[i].setMaxAge(0);
					// resp.addCookie(cookies[i]);
				}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

}
