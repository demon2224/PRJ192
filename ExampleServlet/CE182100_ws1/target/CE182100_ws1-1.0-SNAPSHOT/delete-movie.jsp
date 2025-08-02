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
                            <a href="logout.jsp">Hi, <%= users.getUsername()%>, logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <%
            MoviesDAO moviesDAO = new MoviesDAO();
            String errorMessage = null;
            String idRaw = request.getParameter("id");
            Movies movies = null;
            int id = 0;
            try {
                id = Integer.parseInt(idRaw);
                movies = moviesDAO.getAccountById(id);
            } catch (Exception e) {
                response.sendRedirect("movies.jsp");
            }
        %>
        <div class="container  movies">
            <h1>Delete movie</h1>
            <%
                if (request.getMethod().equals("POST")) {
                    if (moviesDAO.delete(id) == 1) {
                        response.sendRedirect("movies.jsp");
                    } else {
                        errorMessage = "Failed to delete movie. Please try again!";
                    }
                }
            %>
            <p>Are you sure to delete movie <b class="m_title"><%= movies.getTitle()%></b> with id <b class="m_id"><%= movies.getId()%></b>?</p>
            <form method="POST">
                <a href="movies.jsp" class="btn btn-secondary" id="back">Back</a>
                <button type="submit" class="btn btn-danger" id="submit">Delete</button>
            </form>

            <% if (errorMessage != null) {%>
            <div class="alert alert-danger"><%= errorMessage%></div>
            <% }%>
        </div>
    </body>
</html>
