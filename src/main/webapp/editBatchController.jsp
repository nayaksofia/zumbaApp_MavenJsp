<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sofi.dao.BatchDAO"%>
<%@ page import="com.sofi.bean.Batch"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.Date"%>
<%@ page import="java.sql.Time"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Batch Controller</title>
</head>
<body>

<%
    // Instantiate objects for BatchDAO and Batch
    BatchDAO bdao = new BatchDAO();
    Batch batch = new Batch();

    // Get and set form data
    batch.setBid(Integer.parseInt(request.getParameter("bid")));
    batch.setInstructor(request.getParameter("instructor"));

    // Convert and set Date
    batch.setDate(Date.valueOf(request.getParameter("date")));
    batch.setSchedule(request.getParameter("schedule"));

    // Handle time input
    String timeStr = request.getParameter("time");
    if (timeStr != null && !timeStr.isEmpty()) {
        // Ensure time is in HH:mm:ss format
        if (timeStr.length() == 5) {
            timeStr += ":00"; // Add seconds for proper format
        }
        Time time = Time.valueOf(timeStr);
        batch.setTime(time);  // Set the formatted time to batch
    }

    // Update batch
    int result = bdao.updateBatch(batch);

    if (result > 0) {
        // Redirect to success message page if update successful
        response.sendRedirect("successUpdateBatchMessage.jsp");
    } else {
        out.println("<p style='color:red;'>Error Updating Batch Information</p>");
    }
%>

</body>
</html>
