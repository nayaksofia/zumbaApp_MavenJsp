<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sofi.dao.BatchDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Batch Controller</title>
</head>
<body>
 <%
    try {
        // Initialize DAO and retrieve the Batch ID from request parameters
        BatchDAO bdao = new BatchDAO();
        int bid = Integer.parseInt(request.getParameter("id"));
        
        // Perform the delete operation
        int result = bdao.deleteBatch(bid);
        
        // Check the result and redirect based on success or failure
        if (result > 0) {
            
            response.sendRedirect("successDeleteBatch.jsp");
        } else {
           
            out.println("Batch deletion failed!");
        }
    } catch (Exception e) {
        e.printStackTrace();
        out.println("An error occurred while trying to delete the batch.");
    }
%>

</body>
</html>