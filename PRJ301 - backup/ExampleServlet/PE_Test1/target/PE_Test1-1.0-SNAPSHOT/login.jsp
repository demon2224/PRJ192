<%-- 
    Document   : login
    Created on : Mar 21, 2025, 4:50:46 PM
    Author     : Admin
--%>

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
        <div class="container container-login">
            <h1 class="login">LOGIN PAGE</h1>
            <form action="Login" method="POST">
                <div class="mb-3"> 
                    <label class="form-label">Username</label>
                    <input id="txtUS" type="text" name="username" class="form-control" required>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Password</label>
                    <input id="txtPWD" type="password" name="password" class="form-control" required >
                </div>
                <button id="btnLogin" type="submit" class="btn btn-primary"><i class="bi bi-person-circle"></i> Login</button>
                <button id="btnReset" type="reset" class="btn btn-danger"><i class="bi bi-person-circle"></i> Reset</button>

            </form>
            <%
                String err = (String) request.getAttribute("err");
                if (err != null) {
                    out.println(err);
                }
            %>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
