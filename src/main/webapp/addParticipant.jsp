<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="headerAdmin.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Participant</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h3 class="text-center">Add Participant</h3>
    <form action="AddParticipantController" class="mt-4">

        <div class="form-group">
            <label for="pname">Participant Name</label>
            <input type="text" class="form-control" id="pname" name="pname" placeholder="Enter participant name" required>
        </div>

        <div class="form-group">
            <label for="page">Participant Age</label>
            <input type="number" class="form-control" id="page" name="page" placeholder="Enter participant age" required>
        </div>

        <div class="form-group">
            <label for="pemail">Participant Email</label>
            <input type="email" class="form-control" id="pemail" name="pemail" placeholder="Enter participant email" required>
        </div>

        <div class="form-group">
            <label for="pcode">Participant Password</label>
            <input type="password" class="form-control" id="pcode" name="pcode" placeholder="Enter participant password" required>
        </div>

        <button type="submit" class="btn btn-primary btn-block">Add Participant</button>
    </form>
    
      <div class="text-center mt-4">
        <a href="showParticipants.jsp" class="btn btn-secondary">Participants Dashboard</a>
    </div>
</div>



<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


</body>
</html>
