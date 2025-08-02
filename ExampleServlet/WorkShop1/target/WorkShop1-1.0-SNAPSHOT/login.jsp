<%-- 
    Document   : login
    Created on : Feb 18, 2025, 5:14:25 PM
    Author     : Admin
--%>

<%@page import="dao.AccountDAO"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    </head>
    <body>
        <div class="container">
            <h1>Login</h1>
            <form method="POST">
                <div class="mb-3"> 
                    <label class="form-label">Username</label>
                    <input type="text" name="user" class="form-control" required>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Password</label>
                    <input type="text" name="pass" class="form-control" required>
                </div>


                <input type="submit" class="btn btn-primary" value="Login">

            </form>
        </div>
        <%
            AccountDAO dao = new AccountDAO();
            if (request.getMethod().equalsIgnoreCase("POST")) {
                String user = request.getParameter("user");
                String pass = request.getParameter("pass");
                Account acc = dao.verifyMD5(user, pass);
                if (acc.getId() != -1) {
                    session.setAttribute("user", acc);
                    session.setAttribute("fullname", acc.getFullname());
                    response.sendRedirect("awards.jsp");
                } else {
                    out.println("<p style='color:red'>Username invalid, password invalid</p>");
                }
            }
        %>
    </body>
</html>
