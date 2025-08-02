<%-- 
    Document   : update
    Created on : Feb 13, 2025, 2:12:18 PM
    Author     : Admin
--%>
<%@page import="java.util.List"%>
<%@page import="model.Account"%>
<%@page import="dao.AccountDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    AccountDAO accountDAO = new AccountDAO();
    String idString = request.getParameter("id");
    int id = 0;
    Account acc = null;
    try {
        id = Integer.parseInt(idString);
        acc = accountDAO.getAccountById(id);
    } catch (Exception e) {
    }
        
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit Account!</h1>
        <a href="list.jsp">Back</a>
        <%
        if (request.getMethod().equals("POST")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String fullname = request.getParameter("fullname");
            if (!username.isEmpty() && !password.isEmpty() && !fullname.isEmpty()) {
                if ((accountDAO.update(id, username, password, fullname)) == 1) {
                    response.sendRedirect("list.jsp");
                }
            } else {
                out.println("<p>Update failed</p>");
                out.println("<a href=\"list.jsp\">Back</a>");
            }
        } else {
        %>
        <form method="POST">
            Id:
            <input type="text" readonly name="id" required value="<%= acc.getId()%>"><br/>
            Username:
            <input type="text" name="username" required value="<%= acc.getUsername()%>"><br/>
            Password:
            <input type="text" name="password" required value="<%= acc.getPassword()%>"><br/>
            Fullname:
            <input type="text" name="fullname" required value="<%= acc.getFullname()%>"><br/>
            <input type="submit" value="Save" />
        </form>
        <% } %>
    </body>
</html>
