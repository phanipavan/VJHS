package com.vjhs.web.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("*.user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		if(uri.endsWith("gallery.user")){
			request.getRequestDispatcher("WEB-INF/jsp_files/gallerydashboard.jsp").forward(request, response);
		}else if(uri.endsWith("aboutschool.user")){
			request.getRequestDispatcher("WEB-INF/jsp_files/asdashboard.jsp").forward(request, response);
		}else if(uri.endsWith("contact.user")){
			request.getRequestDispatcher("WEB-INF/jsp_files/condashboard.jsp").forward(request, response);
		}else if(uri.endsWith("schoollife.user")){
			request.getRequestDispatcher("WEB-INF/jsp_files/sldashboard.jsp").forward(request, response);
		}else if(uri.endsWith("homepage.user")){
			request.getRequestDispatcher("WEB-INF/jsp_files/homepage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
