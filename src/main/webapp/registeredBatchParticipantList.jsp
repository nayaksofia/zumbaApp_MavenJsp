<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.sofi.db.DB" %>
<%@ include file="headerUser.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registered Participant-Batch List</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2>Registered Participant-Batch List</h2>

    <!-- Display the participant and batch IDs -->
    <p><strong>Participant ID:</strong> <%= request.getParameter("pid") %></p>
    <p><strong>Batch ID:</strong> <%= request.getParameter("bid") %></p>

    <h3>Details of Participants Registered in the Batch</h3>

    <%
        String pidParam = request.getParameter("pid");
        String bidParam = request.getParameter("bid");

        if (pidParam == null || pidParam.isEmpty() || bidParam == null || bidParam.isEmpty()) {
            out.println("<p class='text-danger'>Error: Missing Participant ID or Batch ID.</p>");
            return;
        }

        int pid = Integer.parseInt(pidParam);
        int bid = Integer.parseInt(bidParam);

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        // Database connection and query
        try {
            conn = DB.getDB().getConnection();

            String sql = "SELECT p.pid, p.name, b.bid, b.schedule, b.instructor " +
                         "FROM ParticipantBatch pb " +
                         "JOIN Participant p ON pb.pid = p.pid " +
                         "JOIN Batch b ON pb.bid = b.bid " +
                         "WHERE pb.pid = ? AND pb.bid = ?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1, pid);
            pst.setInt(2, bid);

            rs = pst.executeQuery();

            // Displaying the data in table rows
            if (rs.next()) {
       %>
       
       
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Participant ID</th>
                            <th>Batch ID</th>
                            <th>Instructor</th>
         
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><%= rs.getInt("pid") %></td>
                            <td><%= rs.getInt("bid") %></td>
                            <td><%= rs.getString("instructor") %></td>
                            
                        </tr>
                    </tbody>
                </table>
                
       <%
            } else {
                out.println("<p class='text-info'>No data found for the specified Participant ID and Batch ID.</p>");
            }
        } catch (SQLException e) {
            out.println("<p class='text-danger'>An error occurred: " + e.getMessage() + "</p>");
        } finally {
            // Closing resources
            if (rs != null) try { rs.close(); } catch (SQLException e) {  }
            if (pst != null) try { pst.close(); } catch (SQLException e) {  }
            if (conn != null) try { conn.close(); } catch (SQLException e) {  }
        }
    %>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
