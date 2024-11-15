<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sofi.bean.Participant" %>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="com.sofi.db.DB" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Connection"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login Controller</title>
<!-- Add Bootstrap CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
</head>
<body>

<%
Participant user = new Participant();

//Capture Participant's input
String email = request.getParameter("txtEmail");
String password = request.getParameter("txtPassword");

//database Interaction
DB db = DB.getDB();  //Singletone instance
String sql = "select * from Participant where email = ? and password = ? ";
boolean isParticipantLoggedIn = false;

try(Connection connection = db.getConnection()){
	
	PreparedStatement pst = connection.prepareStatement(sql);
	pst.setString(1, email);
    pst.setString(2, password);
    ResultSet rs = pst.executeQuery();
    
    
    if(rs.next()){
    	  // If credentials are valid, log in the participant
    	isParticipantLoggedIn = true;
    	Participant participant = new Participant();
    	
    	
    	// Set participant details
    	int pid = rs.getInt("pid"); //Retrieve pid from ResultSet; Retrive Participant Id from database
    	participant.setPid(pid);  //Assign the retrived pid to the Participant object
    	participant.setEmail(email);
    	participant.setPassword(password);
    	
    	// Store participant info in session
    	  session.setAttribute("isParticipantLoggedIn", true);
          session.setAttribute("participant", participant);
          session.setAttribute("pid", pid); //stores the pid directly in the session for use in other pages or controller
          
          // Redirect to participant dashboard or home page
          response.sendRedirect("userDashboard.jsp");
      } else {
    	// Redirect to login page with an error message
          session.setAttribute("loginError", "Invalid email or password. Please try again.");
          response.sendRedirect("userLogin.jsp");
      }
  } catch (SQLException e) {
	  session.setAttribute("loginError", "An error occurred while trying to log in. Please try again later.");
      response.sendRedirect("userLogin.jsp");
  }
%>
  


<!-- Add Bootstrap JavaScript and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>