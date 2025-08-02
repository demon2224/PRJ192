<%-- 
    Document   : movies
    Created on : Mar 21, 2025, 9:39:24 PM
    Author     : Admin
--%>

<%@page import="model.Movies"%>
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
                response.sendRedirect("Login");
                return;
            }


        %>
        <nav class="nav">
            <div class="container" >
                <div class="nav-content">
                    <ul>
                        <li class="nav-item">
                            <a href="#">Movies</a>
                        </li>

                    </ul>
                    <ul class="nav-content">
                        <li class="nav-tilte">
                            <a href="#">Movies</a>
                        </li>
                        <li class="nav-tilte">
                            <a href="Logout">Hi, <%= userName%>, logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="container movies">
            <h1>Moviess list</h1>
            <a href="Movies?action=create" class="mb-3 btn btn-success float-end"><i class="bi bi-file-earmark-plus"></i> Create</a>

            <%
                List<Movies> products = (List<Movies>) request.getAttribute("list");
                if (products != null && !products.isEmpty()) {
            %>

            <table border="1" class="table table-striped table-hover">
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Director</th>
                    <th>Release Year</th>
                    <th>Rating</th>
                    <th>Rent?</th>
                    <th>Actions</th>
                </tr>
                <%
                    for (Movies product : products) {
                %>
                <tr>
                    <td><%= product.getId()%></td>
                    <td><%= product.getTitle()%></td>
                    <td><%= product.getDirector()%></td>
                    <td><%= product.getYear()%></td>
                    <td><%= product.getRating()%></td>
                    <td>
                        <input type="checkbox" class="form-check-input" id="exampleCheck1" <%= product.isRented() ? "checked " : ""%>disabled >
                    </td>
                    <td>
                        <a href="Movies?action=update&id=<%= product.getId()%>" class="btn btn-primary"><i class="bi bi-tools"></i> Edit</a>
                        <a href="Movies?action=delete&id=<%= product.getId()%>" class="btn btn-danger"><i class="bi bi-trash"></i> Delete</a>
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
