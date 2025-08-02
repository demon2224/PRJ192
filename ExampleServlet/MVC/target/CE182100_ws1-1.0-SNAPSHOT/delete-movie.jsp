<%-- 
    Document   : delete-movie
    Created on : Feb 25, 2025, 12:38:06 AM
    Author     : Admin
--%>

<%@page import="model.Movies"%>
<%@page import="dao.MoviesDAO"%>
<%@page import="model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete movie</title>
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
            Movies movies = (Movies) request.getAttribute("data");
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

        <div class="container  movies">
            <h1>Delete movie</h1>
            <%                if (movies == null) {
                    out.print("<p>There is no movie with that id</p>");
                } else {
            %>

            <p>Are you sure to delete movie <b class="m_title"><%= movies.getTitle()%></b> with id <b class="m_id"><%= movies.getId()%></b>?</p>
            <form method="POST" action="Movie?action=delete">
                <input type="text" name="id" value="<%= movies.getId()%>" hidden />
                <a href="Movie" class="btn btn-secondary" id="back"><i class="bi bi-arrow-return-left"></i> Back</a>
                <button type="submit" class="btn btn-danger" id="submit"><i class="bi bi-trash"></i>  Delete</button>
            </form>
            <%
                }
            %>
            <%
                String err = (String) request.getAttribute("err");
                if (err != null) {
                    out.println(err);
                }
            %>
        </div>
    </body>
</html>
