<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Navbar</title>

    <!-- Bootstrap CDN for styling -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

 
    <style>
        .navbar {
            margin-bottom: 20px;
        }
        .navbar-brand img {
            width: 50px;  /* Adjust logo size */
            height: auto;
        }
    </style>
</head>
<body>

    <!-- Navbar using Bootstrap -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <!-- Logo and Admin link -->
            <a class="navbar-brand" href="WelcomeAdminController">
                <img src="images/logo_zumba1.jpg" alt="Logo"> Admin Panel 
            </a>
            
            <!-- Navbar Toggler for smaller screens -->
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <!-- Navbar Links -->
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                
                <!-- Admin Link -->
                    <li class="nav-item">
                        <a class="nav-link" href="WelcomeAdminController">Admin</a>
                    </li>
                
                    <!-- Users Link -->
                    <li class="nav-item">
                        <a class="nav-link" href="userDashboard.jsp">Users</a>
                    </li>
                    
                    <!-- Logout Link -->
                    <li class="nav-item">
                        <a class="nav-link" href="LogoutServlet">LogOut</a>
                    </li>
                    
                </ul>
            </div>
        </div>
    </nav>

    <!-- Bootstrap JS and Popper.js (needed for the navbar toggle feature) -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>

</body>
</html>
