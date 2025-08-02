<%-- 
    Document   : awards
    Created on : Feb 15, 2025, 1:07:36 PM
    Author     : Admin
--%>

<%@page import="model.Account"%>
<%@page import="java.util.List"%>
<%@page import="model.TikTokAwards"%>
<%@page import="dao.TikTokAwardsDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Awards</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    </head>
    <body>

        <%
            Account acc = (Account) session.getAttribute("user");
            String full = (String) session.getAttribute("fullname");
            if (acc == null) {
                response.sendRedirect("login.jsp");
                return;
            }
            TikTokAwardsDAO tikTokAwardsDAO = new TikTokAwardsDAO();
            List<TikTokAwards> tikTokAwardsList = tikTokAwardsDAO.getAll();
        %>


        <%
            if (tikTokAwardsList != null && !tikTokAwardsList.isEmpty()) {
        %>
        <div class="container">
            <h1>List of Awards</h1>
            <h3> Hi, <%= acc.getFullname()%> </h3>
            <a class="btn btn-danger" href="logout.jsp">LogOut</a>
            <table border="1" class="table table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Account</th>
                        <th>Category</th>
                        <th>Years</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (TikTokAwards tikTokAwards : tikTokAwardsList) {
                    %>
                    <tr>
                        <td> <%= tikTokAwards.getId()%></td>
                        <td><%= tikTokAwards.getName()%></td>
                        <td><%= tikTokAwards.getAccount()%></td>
                        <td><%= tikTokAwards.getCategory()%></td>
                        <td><%= tikTokAwards.getYears()%></td>
                        <td><a class="btn btn-danger" href="update-award.jsp?id=<%= tikTokAwards.getId()%>" >Update</a> </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <%
            } else {
            %>
            <p>There is no data!</p>

            <%
                }
            %>
        </div>

    </body>
</html>
