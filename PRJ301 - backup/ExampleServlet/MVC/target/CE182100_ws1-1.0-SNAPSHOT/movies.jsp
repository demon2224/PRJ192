<%-- 
    Document   : movies
    Created on : Feb 23, 2025, 11:45:30 PM
    Author     : Admin
--%>

<%@page import="model.Movies"%>
<%@page import="java.util.List"%>
<%@page import="dao.MoviesDAO"%>
<%@page import="model.Users"%>
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
            Users users = (Users) session.getAttribute("user");
            if (users == null) {
                response.sendRedirect("login.jsp");
                return;
            }


        %>
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
                            <a href="Logout">Hi, <%= users.getUsername()%>, logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="container movies">
            <h1>Movies list</h1>
            <a href="Movie?action=Create" class="mb-3 btn btn-success float-end"><i class="bi bi-file-earmark-plus"></i> Create</a>

            <%
                List<Movies> movieses = (List<Movies>) request.getAttribute("list");
                if (movieses != null && !movieses.isEmpty()) {
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
                    for (Movies movies : movieses) {
                %>
                <tr>
                    <td><%= movies.getId()%></td>
                    <td><%= movies.getTitle()%></td>
                    <td><%= movies.getDirector()%></td>
                    <td><%= movies.getRelease_year()%></td>
                    <td><%= movies.getRating()%></td>
                    <td>
                        <input class="form-check-input" type="checkbox" name="isRented" disabled <%= (movies.isIs_rented()) ? "checked " : ""%> />
                    </td>
                    <td>
                        <a href="Movie?action=update&id=<%= movies.getId()%>" class="btn btn-primary"><i class="bi bi-tools"></i> Edit</a>
                        <a href="Movie?action=delete&id=<%= movies.getId()%>" class="btn btn-danger"><i class="bi bi-trash"></i> Delete</a>
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
