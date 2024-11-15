<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="headerUser.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Registration Success</title>
</head>
<body>

<div class="container mt-5 text-center">
    <h3>Registration Successful!</h3>
    <p>Your registration was successful for the following:</p>
    <p><strong>Participant ID:</strong> <%= request.getParameter("pid") %></p>
    <p><strong>Batch ID:</strong> <%= request.getParameter("bid") %></p>
   
    
    <p>
        <a href="registeredBatchParticipantList.jsp?pid=<%= request.getParameter("pid") %>&bid=<%= request.getParameter("bid") %>" class="btn btn-primary">
            View Registered Participant-Batch List
        </a>
    </p>
    
    <p>
    <a href="viewBatchesToRegister.jsp" class="btn btn-primary mt-3"> Batch List</a>
    
    </p>
</div>

</body>
</html>