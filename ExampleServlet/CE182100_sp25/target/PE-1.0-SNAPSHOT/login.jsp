

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>

        <nav class="nav">
            <div class="container" >
                <div class="nav-content">
                    <ul>
                        <li class="nav-item">
                            <a href="#">Products</a>
                        </li>

                    </ul>
                    <ul class="nav-content">
                        <li class="nav-tilte">
                            <a href="#">Products</a>
                        </li>
                        <li class="nav-tilte">
                            <a href="#">Login</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container container-login">
            <h1 class="login">Please sign in</h1>
            <form action="login" method="POST">
                <div class="mb-3"> 
                    <label class="form-label">Username</label>
                    <input id="u_id" type="text" name="username" class="form-control" required placeholder="Uername">
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Password</label>
                    <input id="u_pwd" type="password" name="password" class="form-control" required placeholder="Password">
                </div>
                <button id="submit" type="submit" class="btn btn-primary"><i class="bi bi-person-circle"></i> Login</button>
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
