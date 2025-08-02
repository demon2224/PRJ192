<%-- 
    Document   : index.jsp
    Created on : Mar 11, 2025, 3:47:06 PM
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>

        <nav >
            <div class="conta-contentiner" >
                <div class="nav-content">
                    <ul>
                        <li class="nav-item">
                            <a href="#">PRJ301</a>
                        </li>
                        <li class="nav-item">
                            <a href="#">Products</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


       <div class="container movies">
            <h1>List of Products</h1>
            <a href="Product?action=create" class="mb-3 btn btn-primary">Add New</a>

            <%
                List<Product> products = (List<Product>) request.getAttribute("list");
                if (products != null && !products.isEmpty()) {
            %>

            <table border="1" class="table table-hover table-bordered">
                <tr>
                    <th>ID</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Picture</th>
                    <th>Decription</th>
                    <th>Category Name</th>
                    <th></th>
                </tr>
                <%
                    for (Product product : products) {
                %>
                <tr>
                    <td><%= product.getpId() %></td>
                    <td><%= product.getpName() %></td>
                    <td><%= product.getpPrice() %></td>
                    <td><%= product.getpQuan() %></td>
                    <td><%= product.getpDes() %></td>
                    <td><%= product.getCat().getCatName() %></td>
                    <td>
                        <a href="Product?action=edit&id=<%= product.getpId() %>" class="btn btn-success">Edit</a>
                        <a href="Product?action=delete&id=<%= product.getpId()%>" class="btn btn-danger">Delete</a>
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
        </div>
    </body>
</html>
