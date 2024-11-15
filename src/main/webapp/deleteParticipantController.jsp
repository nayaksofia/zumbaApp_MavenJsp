<%@ page import="com.sofi.dao.ParticipantDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Participant</title>
</head>
<body>

<%
    try {
        // Initialize DAO and retrieve the participant ID from request parameters
        ParticipantDAO pdao = new ParticipantDAO();
        int pid = Integer.parseInt(request.getParameter("id"));
        
        // Perform the delete operation
        int result = pdao.deleteParticipant(pid);
        
        // Check the result and redirect based on success or failure
        if (result > 0) {
            
            response.sendRedirect("successDeleteParticipant.jsp");
        } else {
           
            out.println("Participant deletion failed!");
        }
    } catch (Exception e) {
        e.printStackTrace();
        out.println("An error occurred while trying to delete the participant.");
    }
%>

</body>
</html>
