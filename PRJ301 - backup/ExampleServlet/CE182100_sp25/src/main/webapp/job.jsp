

<%@page import="model.Job"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>movies</title>
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
                response.sendRedirect("login");
                return;
            }


        %>
        <nav class="nav">
            <div class="container" >
                <div class="nav-content">
                    <ul>
                        <li class="nav-item">
                            <a href="#">Application</a>
                        </li>

                    </ul>
                    <ul class="nav-content">
                        <li class="nav-tilte">
                            <a href="#">Application</a>
                        </li>
                        <li class="nav-tilte">
                            <a href="Logout">Hi, <%= userName%>, logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="container movies">
            <h1>My job applications</h1>
            <%
                List<Job> products = (List<Job>) request.getAttribute("list");
                if (products != null && !products.isEmpty()) {
            %>

            <table border="1" class="table table-striped table-hover">
                <tr>
                    <th>ID</th>
                    <th>Positon</th>
                    <th>Comapany</th>
                    <th>Location</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
                <%
                    for (Job product : products) {
                %>
                <tr>
                    <td><%= product.getId()%></td>
                    <td><%= product.getTitle()%></td>
                    <td><%= product.getComapany()%></td>
                    <td><%= product.getLocation()%></td>
                    <td><%= product.getApplication().getStatus()%></td>
                    <td>
                        <a href="list?action=update&id=<%= product.getId()%>" class="btn btn-primary"><i class="bi bi-tools"></i> Edit</a>
                    </td>
                </tr>
                <% } %>
            </table>
            <% } else { %>
            <p>There is no data!</p>
            <%
                }
            %>
        </div>
    </body>
</html>
