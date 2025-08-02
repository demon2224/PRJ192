<%-- 
    Document   : addnew
    Created on : Mar 11, 2025, 4:21:58 PM
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="model.Category"%>
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
            <h2>Create New </h2>
            <p>Product</p>
            <form method="POST" action="Product?action=create">
                <div class="mb-3"> 
                    <label class="form-label">Product ID</label>
                    <input id="pName" type="text" name="txtID" class="form-control" required>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Product Name</label>
                    <input id="pName" type="text" name="txtName" class="form-control" required>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Price</label>
                    <input id="pPrice" type="number" name="txtPrice" min="0" step="any" class="form-control" required>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Quantity</label>
                    <input id="pQuantity" type="number" name="txtQuan" min="0" class="form-control" required>
                </div>
                <div class="mb-3"> 
                    <label class="form-label" >Description</label>
                    <textarea name="txtDes"  class="form-control" required></textarea>
                    <!--                    <input id="pDescription" type="text"  name="pDescription" class="form-control" required>-->
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Category Name</label>
                    <select id="cId" name="cboCat" class="form-select" aria-label="Default select example"> 
                        <%
                            List<Category> categories = (List<Category>) request.getAttribute("list");
                            if (categories != null && !categories.isEmpty()) {
                                for (Category category : categories) {
                        %>
                        <option value="<%= category.getCatId()%>"><%= category.getCatName()%></option>
                        <%
                            }
                        } else {
                        %>
                        <option value="">No categories available</option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <button type="submit" name="btnCreate" class="btn btn-primary" id="submit">Create</button>
                <a href="Product" id="back" class="btn btn-danger">Back to list</a>

            </form>
            <%
                String err = (String) request.getAttribute("err");
                if (err != null) {
                    out.println(err);
                }
            %>
    </body>
</html>
