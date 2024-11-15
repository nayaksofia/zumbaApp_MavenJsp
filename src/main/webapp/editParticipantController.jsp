<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.sofi.dao.ParticipantDAO" %>
 <%@ page import="com.sofi.bean.Participant" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Participant Controller</title>
</head>
<body>

<%
ParticipantDAO pdao = new ParticipantDAO();
Participant participant = new Participant();

//get form data
participant.setPid(Integer.parseInt(request.getParameter("pid")));
participant.setName(request.getParameter("pname"));
participant.setAge(Integer.parseInt(request.getParameter("page")));
participant.setEmail(request.getParameter("pemail"));
participant.setPassword(request.getParameter("pcode"));


//Check if update was successful
if( pdao.updateParticipant(participant) > 0){
	response.sendRedirect("successUpdateParticipantMessage.jsp");
}else{
	out.println("Failed to update participant");
}

%>

</body>
</html>