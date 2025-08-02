<%-- 
    Document   : edit
    Created on : Mar 11, 2025, 4:39:04 PM
    Author     : Admin
--%>

<%@page import="model.Product"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="model.Category"%>
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
        <nav>
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
            <h2>Edit</h2>
            <p>Product</p>
            <%
                Product products = (Product) request.getAttribute("data");
                if (products == null) {
                    out.print("<p>There is no movie with that id</p>");
                } else {
            %>
            <form method="POST" action="Product?action=edit">
                <input type="text" name="id" value="<%= products.getpId()%>" hidden />
                <div class="mb-3"> 
                    <label class="form-label">Product ID</label>
                    <input id="pName" type="text" name="txtID" class="form-control" required  value="<%= products.getpId()%>" readonly  disabled>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Product Name</label>
                    <input id="pName" type="text" name="txtName" class="form-control" required value="<%= products.getpName()%>">
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Price</label>
                    <input id="pPrice" type="number" name="txtPrice" min="0" step="any" class="form-control" required value="<%= products.getpPrice()%>">
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Quantity</label>
                    <input id="pQuantity" type="number" name="txtQuan" min="0" class="form-control" required value="<%= products.getpQuan()%>">
                </div>
                <div class="mb-3"> 
                    <label class="form-label" >Description</label>
                    <textarea name="txtDes"  class="form-control" required><%= products.getpDes()%></textarea>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Category Name</label>
                    <select id="cId" name="cboCat" class="form-select" aria-label="Default select example"> 
                        <%
                            List<Category> categorys = (List<Category>) request.getAttribute("list");
                            for (Category category : categorys) {
                        %>
                        <option value="<%= category.getCatId()%>"<%= (category.getCatId() == products.getCat().getCatId()) ? "selected" : ""%>> <%= category.getCatName()%></option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <button type="submit" name="btnSave" class="btn btn-primary" id="submit">Save</button>
                <a href="Product" id="back" class="btn btn-danger">Back to list</a>
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
