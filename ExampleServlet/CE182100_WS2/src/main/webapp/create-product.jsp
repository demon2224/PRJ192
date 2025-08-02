<%--
    Document   : create-movie
    Created on : Feb 24, 2025, 4:47:19 PM
    Author     : Admin
--%>


<%@page import="java.util.List"%>
<%@page import="model.Category"%>
<%@page import="model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
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
                            <a href="#">PRJ301</a>
                        </li>
                        <li class="nav-item">
                            <a href="#">Products</a>
                        </li>

                    </ul>
                    <ul class="nav-content">
                        <li class="nav-tilte">
                            <a href="Logout">Hi, <%= users.getUsername()%>, logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container movies">
            <h1>Create New</h1>
            <form method="POST" action="Product?action=create">
                <div class="mb-3">
                    <label class="form-label">Product ID</label>
                    <input id="pId" type="text" name="pId" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Product Name</label>
                    <input id="pName" type="text" name="pName" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Price</label>
                    <input id="pPrice" type="number" name="pPrice" min="0" step="any" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Quantity</label>
                    <input id="pQuantity" type="number" name="pQuantity" min="0" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Description</label>
                    <input id="pDescription" type="text"  name="pDescription" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Category Name</label>
                    <select id="cId" name="cId" class="form-select" aria-label="Default select example">
                        <%
                            List<Category> categorys = (List<Category>) request.getAttribute("list");
                            for (Category category : categorys) {
                        %>
                        <option value="<%= category.getCatId()%>"><%= category.getCatName()%></option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary" id="submit">Create</button>
                <a href="Product" id="back" class="btn btn-danger">Back to list</a>
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
