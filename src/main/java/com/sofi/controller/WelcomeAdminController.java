package com.sofi.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeAdminController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Hard-coded Authentication For Admin: EMAIL & PASSWORD
    private final String EMAIL = "admin@zumba.com";
    private final String PASSWORD = "admin@123";

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	// Check if an admin session is already active
        HttpSession session = request.getSession(false);
        Boolean isAdminLoggedIn = false;
        		
        // Only fetch the attribute if the session exists
        if(session != null) {
        	isAdminLoggedIn = (Boolean) session.getAttribute("isAdminLoggedIn");
        }
        		
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (isAdminLoggedIn != null && isAdminLoggedIn) {
            // Already logged in, so redirect to welcomeAdmin.jsp
            request.getRequestDispatcher("/headerAdmin.jsp").include(request, response);
            request.getRequestDispatcher("/welcomeAdmin.jsp").include(request, response);
        } else {
            // Get login credentials from request
            String email = request.getParameter("txtEmail");
            String password = request.getParameter("txtPassword");

            // Check login credentials
            if (EMAIL.equals(email) && PASSWORD.equals(password)) {
                // Set admin session
                session = request.getSession();
                session.setAttribute("isAdminLoggedIn", true);

                // Forward to header and welcome pages
                request.getRequestDispatcher("/headerAdmin.jsp").include(request, response);
                request.getRequestDispatcher("/welcomeAdmin.jsp").include(request, response);
            } else {
                // Invalid credentials
                out.print("<h3 style='color:red;'>Invalid email or password!</h3>");
                out.print("<a href='index.html'>Back to Login</a>");
            }
        }
        out.close();
    }
}
