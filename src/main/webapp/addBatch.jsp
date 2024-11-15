<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="headerAdmin.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Add Batch</title>
</head>
<body>
<div class="container mt-5">
    <h3 class="text-center">Add Batch</h3>
    <form action="AddBatchController" class="mt-4">

        <div class="form-group">
            <label for="bname">Instructor Name</label>
            <input type="text" class="form-control" id="bname" name="instructor" placeholder="Enter Instructor's Name" required>
        </div>

        <div class="form-group">
            <label for="bdate">Date</label>
            <input type="date" class="form-control" id="bdate" name="date" placeholder="Enter Date" required>
        </div>

        <div class="form-group">
            <label for="bschedule">Schedule</label>
            <input type="text" class="form-control" id="bschedule" name="schedule" placeholder="Enter Batch Schedule" required>
        </div>

        <div class="form-group">
            <label for="btime">Time</label>
            <input type="time" class="form-control" id="btime" name="time" placeholder="Enter Time" required>
        </div>

        <button type="submit" class="btn btn-primary btn-block">Add Batch</button>
    </form>
    
      <div class="text-center mt-4">
        <a href="showBatches.jsp" class="btn btn-secondary">Batch Dashboard</a>
    </div>
</div>



<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


 
</body>
</html>