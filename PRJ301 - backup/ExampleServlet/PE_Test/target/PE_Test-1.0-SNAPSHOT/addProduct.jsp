<%-- 
    Document   : addProduct
    Created on : Mar 10, 2025, 9:39:03 PM
    Author     : Admin
--%>

<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    </head>
    <body>
        <%
            Account users = (Account) session.getAttribute("user");
            if (users == null) {
                response.sendRedirect("index.jsp");
                return;
            }
        %>

        <div class="container movies">
            <h1>Add new a product</h1>
            <form method="POST" action="list?action=Create">
                <div class="mb-3"> 
                    <label class="form-label">Product ID</label>
                    <input id="txtProID" type="text" name="txtProID" class="form-control" required>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Product name</label>
                    <input id="dtxtProName" type="text" name="txtProName" class="form-control" required>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Product Quantity</label>
                    <input id="txtProQuantity"" type="number" name="txtProQuantity" min="0" class="form-control" required>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Product Price</label>
                    <input id="txtProPrice" type="number" step="0.0"  min="0" name="txtProPrice" class="form-control" required>
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Product Description</label>
                    <input id="txtProDescription" type="text" name="txtProDescription" required class="form-control" >
                </div>
                <button type="submit" class="btn btn-primary" id="submit">Save</button>
                <a href="list" id="back" class="btn btn-secondary">Back to list</a>
                
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
