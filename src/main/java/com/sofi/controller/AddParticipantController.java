package com.sofi.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.sofi.bean.Participant;
import com.sofi.dao.ParticipantDAO;

//@WebServlet("/AddParticipant")
public class AddParticipantController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 // Forward to headerAdmin.jsp before proceeding
        //request.getRequestDispatcher("/headerAdmin.jsp").include(request, response);

		// Create an instance of Participant class and ParticipantDAO
		Participant pt = new Participant();
		ParticipantDAO pdao = new ParticipantDAO();

		// Extract data from request parameters
		pt.setName(request.getParameter("pname"));
		pt.setAge(Integer.parseInt(request.getParameter("page")));
		pt.setEmail(request.getParameter("pemail"));
		pt.setPassword(request.getParameter("pcode"));

		int result = 0; // Initialize the result variable
		String message;

		try {
			result = pdao.addParticipant(pt);
			message = result > 0 ? pt.getName() + " added to the database successfully!"
					: pt.getName() + " could not be added, please try again.";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			message = "An error occurred: " + e.getMessage();
		} 

		// Set response content type 
		response.setContentType("text/html");
		try (PrintWriter out = response.getWriter()) {
			out.println("<html><head>");
			out.println(
					"<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
			out.println("</head><body>");
			out.println("<div class='container mt-5 text-center'>");
			out.println("<h3>" + message + "</h3>");
			out.println("<a href='showParticipants.jsp' class='btn btn-primary mt-3'>Back To Participant Directory</a>");
			out.println("</div>");
			out.println("</body></html>");
		}
	}
}
