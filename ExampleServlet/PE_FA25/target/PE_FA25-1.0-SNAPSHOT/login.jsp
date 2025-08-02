<%-- 
    Document   : login
    Created on : Mar 12, 2025, 11:32:09 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    </head>
    <body>
        
        <div class="container container-login">
            <h1 class="login">LOGIN PAGE</h1>
            <form action="login" method="POST">
                <div class="mb-3"> 
                    <label class="form-label">Username</label>
                    <input id="u_id" type="text" name="username" class="form-control" required placeholder="Enter username">
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Password</label>
                    <input id="u_pwd" type="password" name="password" class="form-control" required placeholder="Enter your password">
                </div>
                <button id="submit" type="submit" class="btn btn-primary">OK</button>
                <a href="login" class="btn btn-danger">Reset</a>
            </form>
            <%
                String err = (String) request.getAttribute("err");
                if (err != null) {
                    out.println(err);
                }
            %>
        </div>
    </body>
</html>
