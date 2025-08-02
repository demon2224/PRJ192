<%-- 
    Document   : list
    Created on : Feb 8, 2025, 1:51:45 PM
    Author     : Admin
--%>
<%@page import="dao.AccountDAO"%>
<%@page import="java.util.List" %>
<%@page import="model.Account" %>
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
            AccountDAO accountDAO = new AccountDAO();
            List<Account> accountList = accountDAO.getAll();
          
    
        %>
        <%
            if (accountList != null && !accountList.isEmpty()) {
        %>
        <div class="container">
            <a href="create.jsp" class="btn btn-info">Add</a>
            <h1>List Of Account</h1>
            <table border="1" class="table table-hover">
                <tbody>
                    <tr>
                        <td>ID</td>
                        <td>Username</td>
                        <td>Password</td>
                        <td>Fullname</td>
                        <td>Action</td>
                    </tr>
                    <%
                        for (Account account : accountList) {
                    %>
                    <tr>
                        <td><%= account.getId()%></td>
                        <td><%= account.getUsername()%></td>
                        <td><%= account.getPassword()%></td>
                        <td><%= account.getFullname()%></td>
                        <td>
                            <a class="btn btn-primary" href="update.jsp?id=<%= account.getId()%>">Update</a> 
                            <a class="btn btn-danger" href="delete.jsp?id=<%= account.getId()%>">Delete</a>
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
            <p>There is no data!</p>

            <%
                }
            %>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
