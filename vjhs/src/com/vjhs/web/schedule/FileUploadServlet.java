package com.vjhs.web.schedule;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * A Java servlet that handles file upload from client.
 * 
 * @author www.codejava.net
 */
@WebServlet("*.upload")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// location to store file uploaded

	// upload settings
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	private static String UPLOAD_DIRECTORY = "";
	private boolean fileUploaded = false;

	/**
	 * Upon receiving file upload submission, parses the request to read upload
	 * data and saves the file on disk.
	 */

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();

		if (uri.endsWith("holidays.upload")) {
			UPLOAD_DIRECTORY = "upload_holidays";
			String message = uploadFiles(request, response);
			if (fileUploaded) {
				request.setAttribute("msgCode", "success");
			} else {
				request.setAttribute("msgCode", "error");
			}
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/upload_holiday_list.jsp").forward(request, response);
		} else if (uri.endsWith("academic.upload")) {
			UPLOAD_DIRECTORY = "upload_academic";
			String message = uploadFiles(request, response);
			if (fileUploaded) {
				request.setAttribute("msgCode", "success");
			} else {
				request.setAttribute("msgCode", "error");
			}
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/upload_academic_calender.jsp").forward(request, response);

		} else if (uri.endsWith("schooltimings.upload")) {
			UPLOAD_DIRECTORY = "upload_schooltimings";
			String message = uploadFiles(request, response);
			if (fileUploaded) {
				request.setAttribute("msgCode", "success");
			} else {
				request.setAttribute("msgCode", "error");
			}
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/upload_school_timings.jsp").forward(request, response);
		} else if (uri.endsWith("getAcademicCalendarFiles.upload")) {
			UPLOAD_DIRECTORY = "upload_academic";
			String uploadPath1 = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
			String fileNames = "<FILES>";
			File folder1 = new File(uploadPath1);
			if (folder1.exists()) {
				String[] files = folder1.list();
				if (files.length == 0) {
					System.out.println("The directory is empty");
				} else {
					for (String aFile : files) {
						fileNames += "<FILE><FILENAMES>" + aFile + "</FILENAMES></FILE>";
					}
				}
			}
			fileNames += "</FILES>";
			System.out.println(fileNames);
			out.print(fileNames);

		} else if (uri.endsWith("getHolidayFiles.upload")) {
			UPLOAD_DIRECTORY = "upload_holidays";
			String uploadPath1 = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
			String fileNames = "<FILES>";
			File folder1 = new File(uploadPath1);
			if (folder1.exists()) {
				String[] files = folder1.list();
				if (files.length == 0) {
					System.out.println("The directory is empty");
				} else {
					for (String aFile : files) {
						fileNames += "<FILE><FILENAMES>" + aFile + "</FILENAMES></FILE>";
					}
				}
			}
			fileNames += "</FILES>";
			System.out.println(fileNames);
			out.print(fileNames);

		} else if (uri.endsWith("getSchoolTimingsFiles.upload")) {
			UPLOAD_DIRECTORY = "upload_schooltimings";
			String uploadPath1 = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
			String fileNames = "<FILES>";
			File folder1 = new File(uploadPath1);
			if (folder1.exists()) {
				String[] files = folder1.list();
				if (files.length == 0) {
					System.out.println("The directory is empty");
				} else {
					for (String aFile : files) {
						fileNames += "<FILE><FILENAMES>" + aFile + "</FILENAMES></FILE>";
					}
				}
			}
			fileNames += "</FILES>";
			System.out.println(fileNames);
			out.print(fileNames);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private String uploadFiles(HttpServletRequest request, HttpServletResponse response) {
		// // checks if the request actually contains upload file
		// if (!ServletFileUpload.isMultipartContent(request)) {
		// // if not, we stop here
		// PrintWriter writer = response.getWriter();
		// writer.println("Error: Form must has enctype=multipart/form-data.");
		// writer.flush();
		// return;
		// }

		String messaage = "";

		// configures upload settings
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// sets memory threshold - beyond which files are stored in disk
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		// sets temporary location to store files
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload upload = new ServletFileUpload(factory);
		// sets maximum size of upload file
		upload.setFileSizeMax(MAX_FILE_SIZE);
		// sets maximum size of request (include file + form data)
		upload.setSizeMax(MAX_REQUEST_SIZE);
		// constructs the directory path to store upload file
		// this path is relative to application's directory
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		File folder = new File(uploadPath);
		if (!folder.exists()) {
			folder.mkdir();
		}
		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			// parses the request's content to extract file data
			@SuppressWarnings("unchecked")
			List<FileItem> formItems = upload.parseRequest(request);
			if (formItems != null && formItems.size() > 0) {
				// iterates over form's fields
				for (FileItem item : formItems) {
					// processes only fields that are not form fields
					if (!item.isFormField()) {
						String fileName = new File(item.getName()).getName();
						String filePath = uploadPath + File.separator + fileName;
						File storeFile = new File(filePath);
						// saves the file on disk
						item.write(storeFile);
						messaage = "Upload has been done successfully!";
						fileUploaded = true;
					}
				}
			}
		} catch (Exception ex) {
			messaage = "Opps! Got error while uploading file";
			fileUploaded = false;
		}

		return messaage;
	}
}