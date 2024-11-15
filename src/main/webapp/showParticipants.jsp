<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="headerAdmin.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Participants</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <div class="text-center mb-4">
        <!-- Button to add a new participant -->
        <form action="addParticipant.jsp" method="get">
            <button type="submit" class="btn btn-primary">Add Participant</button>
        </form>
    </div>
    
     <div class="text-center mt-4">
        <a href="view-participants.jsp" class="btn btn-success">View Participants</a>
     </div>
     
      <div class="text-center mt-4">
        <a href="WelcomeAdmin" class="btn btn-success">Back To Admin Dashboard</a>
     </div>
    
</div>

<!-- Bootstrap JavaScript and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
