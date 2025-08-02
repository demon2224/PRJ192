<%-- 
    Document   : listProduct
    Created on : Mar 10, 2025, 9:05:37 PM
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/style.css"/>
    </head>
    <body>
        <%
            Account users = (Account) session.getAttribute("user");
            if (users == null) {
                response.sendRedirect("index.jsp");
                return;
            }


        %>
        <nav class="nav">
            <div class="container" >
                <div class="nav-content">
                    <ul class="nav-content">
                        <li class="nav-tilte">
                            <a href="Logout">Hello,<%= users.getFullname()%><span style="color: blue">(Sign out)</span></a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="container movies">
            <div class="center">
                <h1>List of products</h1>
                <a href="list?action=create" class="mb-3 btn btn-primary "> Add new</a>
                <a href="list?action=order" class="mb-3 btn btn-secondary "> Order</a>
            </div>


            <%
                List<Product> movieses = (List<Product>) request.getAttribute("list");
                if (movieses != null && !movieses.isEmpty()) {
            %>

            <table border="1" class="table table-striped table-hover table-bordered">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Action</th>
                </tr>
                <%
                    for (Product movies : movieses) {
                %>
                <tr>
                    <td><%= movies.getpId()%></td>
                    <td><%= movies.getpName()%></td>
                    <td><%= movies.getpQuan()%></td>
                    <td><%= movies.getpPrice()%></td>
                    <td><%= movies.getpDes()%></td>
                    <td>
                        <a href="list?action=update&id=<%= movies.getpId()%>" class="btn btn-warning"> Edit</a>
                        <a href="list?action=delete&id=<%= movies.getpId()%>" class="btn btn-danger">Delete</a>
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
