<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="headerAdmin.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Batches</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <div class="text-center mb-4">
        <form action="addBatch.jsp" method="get">
            <button type="submit" class="btn btn-primary">Add Batch</button>
        </form>
    </div>

     <div class="text-center mt-4">
        <a href="view-batches.jsp" class="btn btn-success">View Batches</a>
     </div>
     
      <div class="text-center mt-4">
        <a href="WelcomeAdmin" class="btn btn-primary">Back To Admin Dashboard</a>
     </div>
    
</div>

<!-- Bootstrap JavaScript and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
