<%-- 
    Document   : delete-movie
    Created on : Feb 25, 2025, 12:38:06 AM
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="model.Category"%>
<%@page import="model.Product"%>
<%@page import="model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete movie</title>
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
            Product products = (Product) request.getAttribute("data");
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

        <div class="container  movies">
            <h1>Delete product</h1>
            <%
                if (products == null) {
                    out.print("<p>There is no movie with that id</p>");
                } else {
            %>

            <p>Are you sure to delete movie <b class="p_name"><%= products.getProNameString()%></b> with id <b class="p_id"><%= products.getProId()%></b>?</p>
            <form method="POST" action="Product?action=delete">
                <input type="text" name="id" value="<%= products.getProId() %>" hidden />
                <div class="mb-3"> 
                    <label class="form-label">Product ID</label>
                    <input id="pId" type="text" name="pId" class="form-control" required value="<%= products.getProId()%>" disabled>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Product Name</label>
                    <input id="pName" type="text" name="pName" class="form-control" required value="<%= products.getProNameString()%>" disabled>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Product Price</label>
                    <input id="pPrice" type="number" name="pPrice" min="0" step="any" class="form-control" required value="<%= products.getProPrice()%>" disabled>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Product Quantity</label>
                    <input id="pQuantity" type="number" name="pQuantity" min="0" class="form-control" required value="<%= products.getProQuantity()%>" disabled>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Product Description</label>
                    <input id="pDescription" type="text"  name="pDescription" class="form-control" required value="<%= products.getProDescription()%>" disabled>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Category Name</label>
                    <select id="cId" name="cId" class="form-select" aria-label="Default select example" disabled> 
                        <%
                            List<Category> categorys = (List<Category>) request.getAttribute("list");
                            for (Category category : categorys) {
                        %>
                        <option value="<%= category.getCatId()%>"<%= (category.getCatId() == products.getCat().getCatId()) ? "selected" : ""%>> <%= category.getCatName()%> </option>

                        <%
                            }
                        %>
                    </select>
                </div>
                <a href="Product" class="btn btn-secondary" id="back"><i class="bi bi-arrow-return-left"></i> Back</a>
                <button type="submit" class="btn btn-danger" id="submit"><i class="bi bi-trash"></i>  Delete</button>
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
