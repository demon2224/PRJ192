<%-- 
    Document   : delete
    Created on : Feb 11, 2025, 5:24:04 PM
    Author     : Admin
--%>
<%@page import="model.Account"%>
<%@page import="dao.AccountDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    AccountDAO dao = new AccountDAO();
    String idRaw = request.getParameter("id");
    int id = 0;
    Account acc = null;
    try {
        id = Integer.parseInt(idRaw);
        acc = dao.getAccountById(id);
    } catch (Exception e) {

    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Delete Accout</h1>
        <a href="list.jsp">Back</a>
        <p>Are you sure to delete account with ID = <%= id%>?</p>
        <% out.println(acc);%>
        <form method="POST">
            <input type="submit" value="OK" />
        </form>
        <%
            if (request.getMethod().equals("POST")) {
                if (dao.delete(id) == 1) {
                    response.sendRedirect("list.jsp");
                } else {
                    out.println("<p>Deletion failed</p>");
                    out.println("<a href=\"list.jsp\">Back</a>");
                }
            }
            
        %>
    </body>
</html>
