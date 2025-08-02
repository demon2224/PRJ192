<%-- 
    Document   : create-movie
    Created on : Feb 24, 2025, 4:47:19 PM
    Author     : Admin
--%>

<%@page import="dao.MoviesDAO"%>
<%@page import="model.Movies"%>
<%@page import="model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create movie</title>
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
            if (request.getMethod().equalsIgnoreCase("POST")) {
                String title = request.getParameter("title");
                String director = request.getParameter("director");
                String release_yearRaw = request.getParameter("releaseYear");
                String ratingRaw = request.getParameter("rating");
                boolean Is_rented = request.getParameter("isRented") != null;
                try {
                    int release_year = Integer.parseInt(release_yearRaw);
                    double rating = Double.parseDouble(ratingRaw);
                    if (moviesDAO.insert(new Movies(title, director, release_year, rating, Is_rented)) == 1) {
                        response.sendRedirect("movies.jsp");
                    } else {
                        errorMessage = "Failed to insert movie. Please try again!";
                    }
                } catch (Exception e) {
                }
            }
        %>
        <div class="container movies">
            <h1>Create new movie</h1>
            <form method="POST">
                <div class="mb-3"> 
                    <label class="form-label">Title</label>
                    <input id="title" type="text" name="title" class="form-control" required>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Director</label>
                    <input id="director" type="text" name="director" class="form-control" required>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Release Year</label>
                    <input id="release_year" type="number" name="releaseYear" min="1900" max="2024" class="form-control" required>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Rating</label>
                    <input id="rating" type="number" step="0.1" min="0.0" max="10.0" name="rating" class="form-control" required>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Is Rented?</label>
                    <input id="is_rented" type="checkbox" name="isRented" class="form-check-input" >
                </div>
                <a href="movies.jsp" id="back" class="btn btn-secondary">Back</a>
                <input id="submit" type="submit" class="btn btn-primary" value="Create">
            </form>
            <% if (errorMessage != null) {%>
            <div class="alert alert-danger"><%= errorMessage%></div>
            <% }%>
        </div>
    </body>
</html>
