<%-- 
    Document   : logout
    Created on : Feb 25, 2025, 1:10:14 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.invalidate();
    response.sendRedirect("login.jsp");
%>
