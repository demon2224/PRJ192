<%-- 
    Document   : addOrder
    Created on : Mar 21, 2025, 11:25:36 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>new order</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/style.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    </head>
    <body>
        <%
            Cookie[] cookies = request.getCookies();
            String userName = null;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equalsIgnoreCase("username")) {
                        userName = cookie.getValue();
                    }
                }
            }
            if (userName == null) {
                response.sendRedirect("Login");
                return;
            }


        %>
        <nav class="nav">
            <div class="container" >
                <div class="nav-content">
                    <ul>
                        <li class="nav-item">
                            <a href="#">Orders</a>
                        </li>

                    </ul>
                    <ul class="nav-content">
                        <li class="nav-tilte">
                            <a href="#">Orders</a>
                        </li>
                        <li class="nav-tilte">
                            <a href="Logout">Hi, <%= userName%>, logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container movies">
            <h1 class="text-center" >Add Orders</h1>
            <form method="POST" action="Order?action=create">
                <div class="mb-3"> 
                    <label class="form-label">Order ID:</label>
                    <input id="pName" type="text" name="txtOrID" class="form-control" required>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Username:</label>
                    <input id="pPrice" type="text" name="txtOrName" min="0" step="any" class="form-control" required>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Order Total:</label>
                    <input id="pQuantity" type="number" name="txtOrTotal" min="0" class="form-control" required>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Order Date</label>
                    <input id="pDescription" type="date"  name="txtOrDate" class="form-control" required>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Description</label>
                    <input id="pDescription" type="text"  name="txtOrDescription" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-primary" id="submit"><i class="bi bi-file-earmark-plus"></i> SUBMIT</button>
                <a href="Order" id="back" class="btn btn-secondary"><i class="bi bi-arrow-return-left"></i> Back to list</a>

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
