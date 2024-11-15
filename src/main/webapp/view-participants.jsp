<%@ page import="com.sofi.dao.ParticipantDAO"%>
<%@ page import="java.util.*"%>
<%@ page import="com.sofi.bean.Participant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="headerAdmin.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Participants List</title>
<!-- Bootstrap CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container my-4">
		<h3 class="text-center mb-4">
			<i>List of Participants!!!</i>
		</h3>

		<table class="table table-striped table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>Participant ID</th>
					<th>Participant Name</th>
					<th>Participant Age</th>
					<th>Participant Email</th>
					<th>Participant Password</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Participant> plist = null;
				try {
					ParticipantDAO pdao = new ParticipantDAO();
					plist = pdao.fetchAllParticipants();
					if ( plist == null ||  plist.isEmpty()) {
						out.println("<p>No participants found.</p>");
					} else {
						for (Participant p : plist) {
				%>
				<tr>
					<td><%=p.getPid()%></td>
					<td><%=p.getName()%></td>
					<td><%=p.getAge()%></td>
					<td><%=p.getEmail()%></td>
					<td><%=p.getPassword()%></td>
					<td><a href="editParticipant.jsp?id=<%=p.getPid()%>"
						class="btn btn-warning btn-sm">Edit</a></td>
					<td><a
						href="deleteParticipantController.jsp?id=<%=p.getPid()%>"
						class="btn btn-danger btn-sm">Delete</a></td>
				</tr>
				<%
				}
				}

				} catch (Exception e) {
				out.println("<p>Error retrieving participants: " + e.getMessage() + "</p>");
				e.printStackTrace();
				}
				%>
			</tbody>
		</table>
	</div>

	<div class="text-center mt-4">
		<a href="showParticipants.jsp" class="btn btn-success">Back To Participants
			Dashboard</a>
	</div>

	<!-- Bootstrap JS and Popper.js for interactive elements -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
