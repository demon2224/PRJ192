<%-- 
    Document   : login
    Created on : Feb 23, 2025, 10:05:20 PM
    Author     : Admin
--%>

<%@page import="model.Users"%>
<%@page import="dao.UsersDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>

        <nav class="nav">
            <div class="container" >
                <div class="nav-content">
                    <ul>
                        <li class="nav-item">
                            <a href="#">MovieRental</a>
                        </li>

                    </ul>
                    <ul class="nav-content">
                        <li class="nav-tilte">
                            <a href="#">Movies</a>
                        </li>
                        <li class="nav-tilte">
                            <a href="#">Login</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <%
            UsersDAO usersDAO = new UsersDAO();
            String errorMessage = null;
            if (request.getMethod().equalsIgnoreCase("POST")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                Users users = usersDAO.verifyMD5(username, password);
                if (users.getId() != -1) {
                    session.setAttribute("user", users);
                    response.sendRedirect("movies.jsp");
                } else {
                    errorMessage = "Incorrect username or password. Please try again!";
                }
            }
        %>
        <div class="container container-login">
            <h1 class="login">Login</h1>
            <form method="POST">
                <div class="mb-3"> 
                    <label class="form-label">Username</label>
                    <input id="u_id" type="text" name="username" class="form-control" required placeholder="Enter username">
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Password</label>
                    <input id="u_pwd" type="password" name="password" class="form-control" required placeholder="Enter your password">
                </div>
                <input id="submit" type="submit" class="btn btn-primary mb-3" value="Login">
            </form>
            <% if (errorMessage != null) {%>
            <div class="alert alert-danger"><%= errorMessage%></div>
            <% }%>
        </div>



    </body>
</html>
