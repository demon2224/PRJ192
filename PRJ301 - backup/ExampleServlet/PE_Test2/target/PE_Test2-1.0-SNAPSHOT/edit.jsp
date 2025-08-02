<%-- 
    Document   : edit
    Created on : Mar 21, 2025, 10:24:16 PM
    Author     : Admin
--%>

<%@page import="model.Movies"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            Movies products = (Movies) request.getAttribute("data");
        %>
        <nav class="nav">
            <div class="container" >
                <div class="nav-content">
                    <ul>
                        <li class="nav-item">
                            <a href="#">Moviess</a>
                        </li>

                    </ul>
                    <ul class="nav-content">
                        <li class="nav-tilte">
                            <a href="#">Moviess</a>
                        </li>
                        <li class="nav-tilte">
                            <a href="Logout">Hi, <%= userName%>, logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="container movies">
            <h1>Edit movie</h1>
            <%
                if (products == null) {
                    out.print("<p>There is no movie with that id</p>");
                } else {
            %>
            <form method="POST" action="Movies?action=update">
                <input type="text" name="id" value="<%= products.getId() %>" hidden />
                <div class="mb-3"> 
                    <label class="form-label">Title</label>
                    <input id="title" type="text" name="title" class="form-control" required value= "<%= products.getTitle() %>" >
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Director</label>
                    <input id="director" type="text" name="director" min="0" step="any" class="form-control" required value="<%= products.getDirector() %>">
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Release Year</label>
                    <input id="release_year" type="number" name="year" min="0" max="2025" class="form-control" required value="<%= products.getYear() %>">
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Rating</label>
                    <input id="rating" type="number"  name="rating" min="0" step="0" class="form-control" required value="<%= products.getRating() %>">
                </div>
                <div class="mb-3 form-check">
                    <label class="form-check-label" for="exampleCheck1">Is Rented?</label>
                    <input id="is_rented" type="checkbox" class="form-check-input" name="rented" <%= products.isRented() ? "checked" : ""%> >                  
                </div>

                <a href="Movies" id="back" class="btn btn-secondary"><i class="bi bi-arrow-return-left"></i> Back</a>
                <button type="submit" class="btn btn-primary" id="submit"><i class="bi bi-file-earmark-plus"></i> Edit</button>
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
