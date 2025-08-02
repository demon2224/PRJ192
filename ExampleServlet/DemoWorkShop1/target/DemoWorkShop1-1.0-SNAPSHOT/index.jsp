<%-- 
    Document   : index
    Created on : Feb 14, 2025, 11:41:46 PM
    Author     : Admin
--%>

<%@page import="model.Category"%>
<%@page import="dao.CategoryDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@page import="dao.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of product</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1>List of product</h1>
            <a href="addnew.jsp" class="btn btn-primary">Add new</a>

            <%
                ProductDAO productDAO = new ProductDAO();
                List<Product> productList = productDAO.getAll();
                CategoryDAO categoryDAO = new CategoryDAO();
                List<Category> categorList = categoryDAO.getAll();
                if (productList != null && !productList.isEmpty() && categorList != null && !categorList.isEmpty()) {
            %>
            <table border="1" class="table table-bordered ">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>ProductName</th>
                        <th>Price</th>
                        <th>Picture</th>
                        <th>Description</th>
                        <th>Category  Name</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Product product : productList) {

                    %>
                    <tr>
                        <td> <%= product.getPro_id()%> </td>
                        <td><%= product.getPro_name()%></td>
                        <td><%= product.getPro_price()%></td>
                        <td><%= product.getPro_quantity()%></td>
                        <td><%= product.getPro_description()%></td>
                        <td><%= category.getCat_name()%></td>
                        <td>
                            <a href="" class="btn btn-success">Edit</a>
                            <a href="" class="btn btn-danger">Delete</a>

                        </td>
                    </tr>

                    <%
                        }
                    %>
                </tbody>
            </table>
            <%
            } else {
            %>
            <p> There is no data! </p>

            <% }%>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
