package com.sofi.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.sofi.dao.ParticipantBatchDAO;

import java.io.IOException;

import com.sofi.bean.Participant;

//@WebServlet("/RegisterBatchController")
public class RegisterBatchController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	HttpSession session = request.getSession();

        // Retrieve `pid` from the session, which should be set during participant login
    	 Integer pid = (Integer) session.getAttribute("pid");
    	 
    	 
        // Retrieve the batch ID (bid) from the request parameter
    	 String bidParam = request.getParameter("bid");
    	 int bid = 0;
    	 try {
    		 bid = bidParam !=null ?Integer.parseInt(bidParam) : 0;
    	 }catch(NumberFormatException e){
    		 response.getWriter().write("Invalid Batch ID Format");
    		 return ;
    	 }
    	 
    	        
         
      // Validate `pid` and `bid`
         if (pid == null || bid == 0) {
             response.getWriter().write("Invalid Participant ID or Batch ID");
             return;
         }

         

        // Register participant for the batch
        ParticipantBatchDAO dao = new ParticipantBatchDAO();
        boolean isRegistered = dao.registerParticipantForBatch(pid, bid);

        // Forward to success page if registration is successful
        if (isRegistered) {
        	
            response.sendRedirect("successRegister.jsp?pid=" + pid + "&bid=" + bid);
            //request.getRequestDispatcher("successRegister.jsp").forward(request, response);
        } else {
            response.getWriter().println("Error: Registration failed.");
        }
    }
}
