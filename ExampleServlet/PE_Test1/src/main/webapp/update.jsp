<%-- 
    Document   : update
    Created on : Mar 21, 2025, 6:36:19 PM
    Author     : Admin
--%>

<%@page import="model.Cows"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>movies</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/style.css">
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
            Cows products = (Cows) request.getAttribute("data");
        %>
        <nav class="nav">
            <div class="container" >
                <div class="nav-content">
                    <ul>
                        <li class="nav-tilte">
                            <a href="Logout">Hi, <%= userName%>, logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="container movies">
            <h1>Update cow</h1>
            <%
                if (products == null) {
                    out.print("<p>There is no cows with that id</p>");
                } else {
            %>
            <form method="POST" action="Cows?action=update">
                <input type="text" name="id" value="<%= products.getCowID()%>" hidden />
                <div class="mb-3"> 
                    <label class="form-label">Cows ID</label>
                    <input id="txtCowID" type="text" name="txtCowID" class="form-control" required value="<%= products.getCowID()%>" disabled >
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Name</label>
                    <input id="txtCowName" type="text" name="txtCowName" class="form-control" required value="<%= products.getName()%>">
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Breed</label>
                    <input id="txtCowBreed" type="text" name="txtCowBreed" class="form-control" required value="<%= products.getBreed()%>">
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Farm</label>
                    <input id="txtCowFarm" type="text" name="txtCowFarm" class="form-control" required value="<%= products.getFarm()%>">
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Age</label>
                    <input id="txtCowAge" type="text"  name="txtCowAge" min="0" class="form-control" required value="<%= products.getAge()%>">
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Weight</label>
                    <input id="txtCowWeight" type="text" name="txtCowWeight" min="0" class="form-control" required value="<%= products.getWeight()%>">
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Milk Production</label>
                    <input id="txtCowMilk" type="text" name="txtCowMilk" min="0" class="form-control" required value="<%= products.getMilkPro()%>">
                </div>
                <div class="mb-3"> 
                    <label class="form-label">Healthy Status</label>
                    <input id="txtCowSatus" type="text" name="txtCowStatus" class="form-control" required value="<%= products.getHealthStatus()%>">
                </div>
                <button type="submit" class="btn btn-primary" id="submit"><i class="bi bi-tools"></i> Update</button>
                <a href="Cows" id="back" class="btn btn-secondary"><i class="bi bi-arrow-return-left"></i> Back</a>
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
