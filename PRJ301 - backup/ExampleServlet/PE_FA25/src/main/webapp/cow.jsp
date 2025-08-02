<%-- 
    Document   : cow.jsp
    Created on : Mar 12, 2025, 11:39:19 PM
    Author     : Admin
--%>

<%@page import="model.Account"%>
<%@page import="model.Cows"%>
<%@page import="java.util.List"%>
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
                response.sendRedirect("login.jsp");
                return;
            }


        %>
        <nav class="">
            <div class="container" >
                <ul >
                    <li>
                        <a href="Logout" class="float-end"><%= users.getUsername()%></a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container movies">
            <h1>List of Cows</h1>
            <%
                List<Cows> products = (List<Cows>) request.getAttribute("list");
                if (products != null && !products.isEmpty()) {
            %>

            <table border="1" class="table table-striped table-hover">
                <tr>
                    <th>Cows</th>
                    <th>Name</th>
                    <th>Breed</th>
                    <th>Farm</th>
                    <th>Age</th>
                    <th>Weight (kg)</th>
                    <th>Milk Production (liters/day)</th>
                    <th>Health Status</th>
                    <th></th>
                </tr>
                <%
                    for (Cows product : products) {
                %>
                <tr>
                    <td><%= product.getCowId()%></td>
                    <td><%= product.getName()%></td>
                    <td><%= product.getBreed()%></td>
                    <td><%= product.getFarm()%></td>
                    <td><%= product.getAge()%></td>
                    <td><%= product.getWeight()%></td>
                    <td><%= product.getMilkProduction()%></td>
                    <td><%= product.getHealthStatus()%></td>
                    <td>
                        <a href="updateCow?id=<%= product.getCowId()%>" class="btn btn-primary">Update</a>
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
