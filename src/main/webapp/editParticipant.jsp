<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sofi.dao.ParticipantDAO" %>
<%@ page import="com.sofi.bean.Participant" %>
<%@include file="headerAdmin.jsp"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Participant</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

 <%
 //Fetch the participant's current deatils using the pid from request
 String participantId = request.getParameter("id");
 ParticipantDAO pdao = new ParticipantDAO();
 Participant participant = pdao.fetchParticipantById(Integer.parseInt(participantId));
 %>

<div class="container mt-5">
    <h3 class="text-center">Edit Participant</h3>
    
    <form action="editParticipantController.jsp" class="mt-4">

        <!-- Hidden field for Participant ID -->
        <input type="hidden" name="pid" value="<%= participant.getPid() %>">
        
        <!-- Participant Name -->
        <div class="form-group">
            <label for="pname">Participant Name</label>
            <input type="text" class="form-control" id="pname" name="pname" value="<%= participant.getName() %>" required>
        </div>

        <!-- Participant Age -->
        <div class="form-group">
            <label for="page">Participant Age</label>
            <input type="number" class="form-control" id="page" name="page" value="<%= participant.getAge() %>" required>
        </div>

        <!-- Participant Email -->
        <div class="form-group">
            <label for="pemail">Participant Email</label>
            <input type="email" class="form-control" id="pemail" name="pemail" value="<%= participant.getEmail() %>" required>
        </div>

        <!-- Participant Password -->
        <div class="form-group">
            <label for="pcode">Participant Password</label>
            <input type="password" class="form-control" id="pcode" name="pcode" value="<%= participant.getPassword() %>" required>
        </div>

        <button type="submit" class="btn btn-primary btn-block">Update Participant</button>
    </form>
    
    <div class="text-center mt-4">
        <a href="view-participants.jsp" class="btn btn-secondary">Participants List</a>
    </div>
</div>

    
    
    <!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    

</body>
</html>