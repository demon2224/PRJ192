<%-- 
    Document   : update
    Created on : Mar 13, 2025, 12:05:21 AM
    Author     : Admin
--%>

<%@page import="model.Cows"%>
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
                response.sendRedirect("login.jsp");
                return;
            }
            Cows products = (Cows) request.getAttribute("data");
        %>
        <div class="container movies">
            <h1>Update cow</h1>
            <%
                if (products == null) {
                    out.print("<p>There is no movie with that id</p>");
                } else {
            %>
            <form method="POST" action="updateCow">
                <input type="text" name="id" value="<%= products.getCowId()%>" hidden />
                <div class="mb-3"> 
                    <label class="form-label">Cowt ID</label>
                    <input id="pId" type="text" name="txtCowID" class="form-control" required value="<%= products.getCowId()%>" disabled >
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Name</label>
                    <input id="pName" type="text" name="txtCowName" class="form-control" required value="<%= products.getName()%>">
                </div>
                <div class="mb-3"> 
                    <label class="form-label">breed</label>
                    <input id="pPrice" type="text" name="txtCowBreed" min="0" step="any" class="form-control" required value="<%= products.getBreed()%>">
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Farm</label>
                    <input id="pQuantity" type="text" name="txtCowFarm" min="0" class="form-control" required value="<%= products.getFarm()%>">
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Age</label>
                    <input id="pDescription" type="text"  name="txtCowAge" class="form-control" required value="<%= products.getAge()%>">
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Weight</label>
                    <input id="pDescription" type="text"  name="txtCowWeight" class="form-control" required value="<%= products.getWeight()%>">
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Milk Production</label>
                    <input id="pDescription" type="text"  name="txtCowMilk" class="form-control" required value="<%= products.getMilkProduction()%>">
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Health Status</label>
                    <input id="pDescription" type="text"  name="txtCowStatus" class="form-control" required value="<%= products.getHealthStatus()%>">
                </div>
                <button  name="btnUpdate" type="submit" class="btn btn-primary" id="submit">Update</button>
                <button  name="btnReset" type="submit" class="btn btn-secondary" id="submit">Back</button>

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
