<%-- 
    Document   : order
    Created on : Mar 21, 2025, 11:16:33 PM
    Author     : Admin
--%>

<%@page import="model.Order"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>order</title>
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
                            <a href="#">Orders</a>
                        </li>

                    </ul>
                    <ul class="nav-content">
                        <li class="nav-tilte">
                            <a href="#">Orders</a>
                        </li>
                        <li class="nav-tilte">
                            <a href="Logout">Hi, <%= userName%>, logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="container movies">
            <h1>Orders list</h1>

            <a href="Order?action=create" class="mb-3 btn btn-primary float-end"><i class="bi bi-file-earmark-plus"></i> New Order</a>

            <%
                List<Order> products = (List<Order>) request.getAttribute("list");
                if (products != null && !products.isEmpty()) {
            %>

            <table border="1" class="table table-striped table-hover table-bordered">
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Total</th>
                    <th>Date</th>
                    <th>Description</th>
                    <th>Action</th>
                </tr>
                <%
                    for (Order product : products) {
                %>
                <tr>
                    <td><%= product.getId()%></td>
                    <td><%= product.getUsername()%></td>
                    <td><%= product.getTotal()%></td>
                    <td><%= product.getDate()%></td>
                    <td><%= product.getDesString()%></td>
                    <td class="d-flex">
                        <a href="Order?action=update&id=<%= product.getId()%>" class="btn btn-primary"><i class="bi bi-tools"></i> Edit</a>
                        <form method="POST" action="Order?action=delete"> 
                            <input type="text" name="id" value="<%= product.getId()%>" hidden />
                            <button type="submit" class="btn btn-danger" id="submit"><i class="bi bi-trash"></i>  Cancel</button>
                        </form>
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
