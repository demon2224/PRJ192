<%-- 
    Document   : index
    Created on : Mar 10, 2025, 8:13:06 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    </head>
    <body>
        <style>
            .container-login {
                max-width: 500px;
                margin-top: 50px;
            }
            .login {
                text-align: center;
            }
            .btn {
                width: 100%;
            }
        </style>
        <div class="container container-login">
            <h1 class="login">Login</h1>
            <form action="login" method="POST">
                <div class="mb-3"> 
                    <label class="form-label">Username</label>
                    <input id="u_id" type="text" name="username" class="form-control" required placeholder="Enter username">
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Password</label>
                    <input id="u_pwd" type="password" name="password" class="form-control" required placeholder="Enter your password">
                </div>
                <button type="submit" class="btn btn-primary"><i class="bi bi-person-circle"></i> Login</button>
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
