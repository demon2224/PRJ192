<%-- 
    Document   : Cows
    Created on : Mar 21, 2025, 6:11:33 PM
    Author     : Admin
--%>

<%@page import="model.Cows"%>
<%@page import="java.util.List"%>
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


        %>



        <div class="container movies">
            <h1>List of Cows</h1>
            <%                List<Cows> products = (List<Cows>) request.getAttribute("list");
                if (products != null && !products.isEmpty()) {
            %>

            <table border="1" class="table table-striped table-hover">
                <tr>
                    <th>CowsID</th>
                    <th>Name</th>
                    <th>Breed</th>
                    <th>Farm</th>
                    <th>Age</th>
                    <th>Weight (kg)</th>
                    <th>Milk Product (liter/day)</th>
                    <th>Headlth Status</th>
                    <th></th>
                </tr>
                <%
                    for (Cows product : products) {
                %>
                <tr>
                    <td><%= product.getCowID()%></td>
                    <td><%= product.getName()%></td>
                    <td><%= product.getBreed()%></td>
                    <td><%= product.getFarm()%></td>
                    <td><%= product.getAge()%></td>
                    <td><%= product.getWeight()%></td>
                    <td><%= product.getMilkPro()%></td>
                    <td><%= product.getHealthStatus()%></td>
                    <td>
                        <a href="Cows?action=update&id=<%= product.getCowID()%>" class="btn btn-secondary "><i class="bi bi-tools"></i> Update</a>
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
