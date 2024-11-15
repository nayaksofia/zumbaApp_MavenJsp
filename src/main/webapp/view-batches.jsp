<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.sofi.bean.Batch"%>
<%@ page import="com.sofi.dao.BatchDAO"%>
<%@ page import="java.util.*"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Batches List</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container my-4">
        <h3 class="text-center mb-4"><i>List of Batches!!!</i></h3>
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>Batch ID</th>
                    <th>Instructor Name</th>
                    <th>Date</th>
                    <th>Schedule</th>
                    <th>Time</th>
                    <%-- Register column only visible for participants --%>
                    <% if (session.getAttribute("isParticipantLoggedIn") != null) { %>
                        <th>Register</th>
                    <% } %>
                    <%-- Edit/Delete columns visible only for admin --%>
                    <% if (session.getAttribute("isAdminLoggedIn") != null) { %>
                        <th>Edit</th>
                        <th>Delete</th>
                    <% } %>
                </tr>
            </thead>
            <tbody>
                <%
                List<Batch> blist = null;
                try {
                    BatchDAO bdao = new BatchDAO();
                    blist = bdao.fetchAllBatch();
                    if (blist == null || blist.isEmpty()) {
                        out.println("<p>No Batch Found.</p>");
                    } else {
                        for (Batch b : blist) {
                %>
                <tr>
                    <td><%=b.getBid()%></td>
                    <td><%=b.getInstructor()%></td>
                    <td><%=b.getDate()%></td>
                    <td><%=b.getSchedule()%></td>
                    <td><%=b.getTime()%></td>

                    <%-- Registration link visible for participants only --%>
                    <% if (session.getAttribute("isParticipantLoggedIn") != null) { %>
                        <td><a href="RegisterBatchController?bid=<%=b.getBid()%>" class="btn btn-primary btn-sm">Register</a></td>
                    <% } %>

                    <%-- Edit/Delete links visible only for admin --%>
                    <% if (session.getAttribute("isAdminLoggedIn") != null) { %>
                        <td><a href="editBatch.jsp?id=<%=b.getBid()%>" class="btn btn-warning btn-sm">Edit</a></td>
                        <td><a href="deleteBatchController.jsp?id=<%=b.getBid()%>" class="btn btn-danger btn-sm">Delete</a></td>
                    <% } %>
                </tr>
                <%
                        }
                    }
                } catch (Exception e) {
                    out.println("<p>Error in retrieving Batch: " + e.getMessage() + "</p>");
                    e.printStackTrace();
                }
                %>
            </tbody>
        </table>
    </div>
    <div class="text-center mt-4">
        <a href="showBatches.jsp" class="btn btn-success">Back To BatchDashboard</a>
    </div>
</body>
</html>
