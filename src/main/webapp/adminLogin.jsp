<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
</head>
<body>
    <h3>Admin Login</h3>
    <form action="WelcomeAdminController" method="post">
        <label>Email:</label>
        <input type="text" name="txtEmail" required><br><br>
        
        <label>Password:</label>
        <input type="password" name="txtPassword" required><br><br>
        
        <input type="submit" value="Login">
    </form>
</body>
</html>
