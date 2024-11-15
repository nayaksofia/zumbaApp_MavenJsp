package com.sofi.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;

import com.sofi.bean.Batch;
import com.sofi.dao.BatchDAO;


//@WebServlet({ "/AddBatchController", "/AddBatch" })
public class AddBatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

        // Forward to headerAdmin.jsp before proceeding
        request.getRequestDispatcher("/headerAdmin.jsp").include(request, response);
		
		//Create Instance of Batch and BatchDAO
		Batch bch = new Batch();
		BatchDAO bdao = new BatchDAO();
		
		//Extract data from the form
		bch.setInstructor(request.getParameter("instructor"));
		bch.setDate(Date.valueOf(request.getParameter("date")));
		bch.setSchedule(request.getParameter("schedule"));
		
		
		
		//bch.setTime(Time.valueOf(request.getParameter("time")));
		
		// Validate and convert time string
		String timeStr = request.getParameter("time");
		
		 if (timeStr != null && !timeStr.isEmpty()) {
			 
	            try {
	                //Append ':00' Ensure time is in HH:mm:ss format
	            	
	            	if (timeStr.length() == 5) {
	                    timeStr += ":00"; // Add seconds to make the format valid
	                }

	                // Convert the time to the correct format
	                Time time = Time.valueOf(timeStr);
	                bch.setTime(time);
	                
	            } catch (IllegalArgumentException e) {
	                // Log the exception for debugging purposes
	                System.err.println("Invalid time format: " + timeStr);
	                response.setContentType("text/html");
	                try (PrintWriter out = response.getWriter()) {
	                    out.println("<html><body><h3>Invalid time format. Please use HH:mm:ss (e.g., 14:30:00).</h3>");
	                    out.println("<a href='addBatch.jsp'>Back to form</a>");
	                    out.println("</body></html>");
	                }
	                return; // Exit early if the time is invalid
	            }
	        }
		
		
		
		// Initialize the result variable
		int result = 0;
		String message = null;
		
		try {
			result = bdao.addBatch(bch);
			message = result > 0 ? bch.getInstructor() + " added to the database successfully!"
					: bch.getInstructor() + " could not be added, please try again.";
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			 message = "An error occurred while adding the batch. Please try again.";
			
		}
		
		
		// Set response content type 
				response.setContentType("text/html");
				try (PrintWriter out = response.getWriter()) {
					out.println("<html><head>");
					out.println(
							"<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
					out.println("</head><body>");
					out.println("<div class='container mt-5 text-center'>");
					out.println("<h3>" +message+ "</h3>");
					out.println("<a href='showBatches.jsp' class='btn btn-primary mt-3'>Back To Batch Directory</a>");
					out.println("</div>");
					out.println("</body></html>");
				}
	}

}
