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
            <h1>Create new movie</h1>
            <form method="POST" action="Movie?action=Create">
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
                <a href="Movie" id="back" class="btn btn-secondary"><i class="bi bi-arrow-return-left"></i> Back</a>
                <button type="submit" class="btn btn-primary" id="submit"><i class="bi bi-file-earmark-plus"></i> Create</button>
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
