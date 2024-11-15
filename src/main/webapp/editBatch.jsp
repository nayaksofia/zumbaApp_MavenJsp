<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sofi.dao.BatchDAO" %>
<%@ page import="com.sofi.bean.Batch" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Edit Batch</title>
</head>
<body>
 <%
 //Fetch the batch's current deatils 
 String batchId = request.getParameter("id");
 BatchDAO bdao = new BatchDAO();
 Batch batch = bdao.fetchBatchById(Integer.parseInt(batchId));
 %>

<div class="container mt-5">
    <h3 class="text-center">Edit Batch</h3>
    
    <form action="editBatchController.jsp" class="mt-4">
    
        <!-- Hidden field for Batch ID -->
        <input type="hidden" name="bid" value="<%=batch.getBid() %>">

        <div class="form-group">
            <label for="bname">Instructor Name</label>
            <input type="text" class="form-control" id="bname" name="instructor" value="<%=batch.getInstructor() %>" required>
        </div>

        <div class="form-group">
            <label for="bdate">Date</label>
            <input type="date" class="form-control" id="bdate" name="date" value="<%=batch.getDate() %>"  required>
        </div>

        <div class="form-group">
            <label for="bschedule">Schedule</label>
            <input type="text" class="form-control" id="bschedule" name="schedule" value="<%=batch.getSchedule() %>"  required>
        </div>

        <div class="form-group">
            <label for="btime">Time</label>
            <input type="time" class="form-control" id="btime" name="time" value="<%=batch.getTime() %>"  required>
        </div>

        <button type="submit" class="btn btn-primary btn-block">Update Batch</button>
    </form>
    
     <div class="text-center mt-4">
        <a href="view-batches.jsp" class="btn btn-secondary">Batch List</a>
    </div>

</div>

  <!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>