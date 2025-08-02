<%-- 
    Document   : movies
    Created on : Feb 23, 2025, 11:45:30 PM
    Author     : Admin
--%>

<%@page import="model.Product"%>
<%@page import="java.util.List"%>
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
                            <a href="#">Products</a>
                        </li>

                    </ul>
                    <ul class="nav-content">
                        <li class="nav-tilte">
                            <a href="#">Products</a>
                        </li>
                        <li class="nav-tilte">
                            <a href="Logout">Hi, <%= userName %>, logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="container movies">
            <h1>Products list</h1>
            <a href="Product?action=create" class="mb-3 btn btn-success float-end"><i class="bi bi-file-earmark-plus"></i> Create</a>

            <%
                List<Product> products = (List<Product>) request.getAttribute("list");
                if (products != null && !products.isEmpty()) {
            %>

            <table border="1" class="table table-striped table-hover">
                <tr>
                    <th>ID</th>
                    <th>Product Name</th>
                    <th>Product Price</th>
                    <th>Product Quantiy</th>
                    <th>Product Decription</th>
                    <th>Category</th>
                    <th>Action</th>
                </tr>
                <%
                    for (Product product : products) {
                %>
                <tr>
                    <td><%= product.getProId()%></td>
                    <td><%= product.getProNameString()%></td>
                    <td><%= product.getProPrice()%></td>
                    <td><%= product.getProQuantity()%></td>
                    <td><%= product.getProDescription()%></td>
                    <td><%= product.getCat().getCatName()%></td>
                    <td>
                        <a href="Product?action=update&id=<%= product.getProId()%>" class="btn btn-primary"><i class="bi bi-tools"></i> Edit</a>
                        <a href="Product?action=delete&id=<%= product.getProId()%>" class="btn btn-danger"><i class="bi bi-trash"></i> Delete</a>
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
